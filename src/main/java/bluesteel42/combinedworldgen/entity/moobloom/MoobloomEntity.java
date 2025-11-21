package bluesteel42.combinedworldgen.entity.moobloom;

import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.entity.ModDataComponentTypes;
import bluesteel42.combinedworldgen.entity.ModEntities;
import bluesteel42.combinedworldgen.entity.ModLootTables;
import bluesteel42.combinedworldgen.item.ModItems;
import bluesteel42.combinedworldgen.sound.ModSoundEvents;
import bluesteel42.combinedworldgen.util.ModTags;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.component.ComponentType;
import net.minecraft.component.ComponentsAccess;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.conversion.EntityConversionContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AbstractCowEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.EffectParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;
import java.util.function.IntFunction;

import static bluesteel42.combinedworldgen.property.ModProperties.FLOWERS;

public class MoobloomEntity extends AbstractCowEntity implements Shearable {
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(MoobloomEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> HONEY_COUNT = DataTracker.registerData(MoobloomEntity.class, TrackedDataHandlerRegistry.INTEGER);
    @Nullable
    private UUID lightningId;
    private int spreadFlowersTimer;
    private SpreadFlowersGoal spreadFlowersGoal;
    private static final int maxHoneyCount = 5;

    public MoobloomEntity(EntityType<? extends MoobloomEntity> entityType, World world) {
        super(entityType, world);
        if (!world.isClient()) {
            int v = Variant.getWeightedNaturalVariant(world.random).index;
            this.dataTracker.set(VARIANT, v);
        }
    }

    @Override
    protected void initGoals() {
        this.spreadFlowersGoal = new SpreadFlowersGoal(this);
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.25, stack -> stack.isIn(ItemTags.COW_FOOD), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.add(5, this.spreadFlowersGoal);
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    private BlockState getOppositeEyeblossomState(BlockState currentState) {
        if (currentState == Blocks.OPEN_EYEBLOSSOM.getDefaultState()) {
            return Blocks.CLOSED_EYEBLOSSOM.getDefaultState();
        } else if (currentState == Blocks.CLOSED_EYEBLOSSOM.getDefaultState()) {
            return Blocks.OPEN_EYEBLOSSOM.getDefaultState();
        } else {
            return currentState;
        }
    }

    private SoundEvent getEyeblossomSound(BlockState currentState) {
        if (currentState == Blocks.OPEN_EYEBLOSSOM.getDefaultState()) {
            return SoundEvents.BLOCK_EYEBLOSSOM_OPEN_LONG;
        } else if (currentState == Blocks.CLOSED_EYEBLOSSOM.getDefaultState()) {
            return SoundEvents.BLOCK_EYEBLOSSOM_CLOSE_LONG;
        } else {
            return SoundEvents.ENTITY_COW_AMBIENT;
        }
    }

    @Override
    protected void mobTick(ServerWorld world) {
        this.spreadFlowersTimer = this.spreadFlowersGoal.getTimer();
        if (
                Variant.EYEBLOSSOMS.contains(this.getVariantFromFlower(this.getVariant().getFlowerState())) &&
                this.getEntityWorld().getDimension().natural() &&
                        !(CreakingHeartBlock.isNightAndNatural(this.getEntityWorld()) == (this.getVariant().getFlowerState() == Blocks.OPEN_EYEBLOSSOM.getDefaultState()))

        ) {
            BlockState oppositeEyeblossomState = getOppositeEyeblossomState(this.getVariant().getFlowerState());
            setVariantFromFlower(oppositeEyeblossomState);
            this.playSound(getEyeblossomSound(oppositeEyeblossomState), 1.0F, 1.0F);
        }
        super.mobTick(world);
    }

    @Override
    public void tickMovement() {
        if (this.getEntityWorld().isClient()) {
            this.spreadFlowersTimer = Math.max(0, this.spreadFlowersTimer - 1);
        }

        super.tickMovement();

        if (this.getEntityWorld() instanceof ServerWorld serverWorld) {
            if (!serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int j = MathHelper.floor(this.getX() + (i % 2 * 2 - 1) * 0.25F);
                int k = MathHelper.floor(this.getY() - 1);
                int l = MathHelper.floor(this.getZ() + (i / 2 % 2 * 2 - 1) * 0.25F);
                BlockPos blockPos = new BlockPos(j, k, l);
                if (this.getEntityWorld().getBlockState(blockPos).isIn(BlockTags.WOOL)) {
                    this.getEntityWorld().setBlockState(blockPos, this.getVariant().getWoolState());
                    this.getEntityWorld().emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, this.getVariant().getWoolState()));
                } else if (this.getEntityWorld().getBlockState(blockPos).isOf(Blocks.TERRACOTTA)) {
                    this.getEntityWorld().setBlockState(blockPos, this.getVariant().getTerracottaState());
                    this.getEntityWorld().emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, this.getVariant().getTerracottaState()));
                } else if (this.getEntityWorld().getBlockState(blockPos).isOf(Blocks.GLASS)) {
                    this.getEntityWorld().setBlockState(blockPos, this.getVariant().getGlassState());
                    this.getEntityWorld().emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, this.getVariant().getGlassState()));
                }
            }
        }
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.SET_SHEEP_EAT_GRASS_TIMER_OR_PRIME_TNT_MINECART) {
            this.spreadFlowersTimer = 40;
        } else {
            super.handleStatus(status);
        }
    }

    public boolean getSpreadingFlowersState() {
        return this.spreadFlowersTimer > 0;
    }


    public float getNeckAngle(float tickProgress) {
        if (this.spreadFlowersTimer <= 0) {
            return 0.0F;
        } else if (this.spreadFlowersTimer >= 4 && this.spreadFlowersTimer <= 36) {
            return 1.0F;
        } else {
            return this.spreadFlowersTimer < 4 ? (this.spreadFlowersTimer - tickProgress) / 4.0F : -(this.spreadFlowersTimer - 40 - tickProgress) / 4.0F;
        }
    }

    public float getHeadAngle(float tickProgress) {
        if (this.spreadFlowersTimer > 4 && this.spreadFlowersTimer <= 36) {
            float f = (this.spreadFlowersTimer - 4 - tickProgress) / 32.0F;
            return (float) (Math.PI / 5) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.spreadFlowersTimer > 0 ? (float) (Math.PI / 5) : this.getLerpedPitch(tickProgress) * (float) (Math.PI / 180.0);
        }
    }

    public void onSpreadingFlowers() {
        setHoneyCount(0);
        this.emitGameEvent(GameEvent.BLOCK_PLACE);
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        if (world.getBlockState(pos).isOf(this.getVariant().getFlowerState().getBlock())) {
            return 10.0F;
        } else if (world.getBlockState(pos).isIn(BlockTags.FLOWERS) || world.getBlockState(pos.down()).isIn(BlockTags.FLOWERS)) {
            return 9.0F;
        } else return world.getPhototaxisFavor(pos);
    }

    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
        UUID uUID = lightning.getUuid();
        if (!uUID.equals(this.lightningId)) {
            BlockState standingBlock = world.getBlockState(this.getBlockPos());
            if (!standingBlock.isIn(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS)) {
                this.setVariant(MoobloomEntity.Variant.getRandomNaturalVariant(this.random));
            } else {
                setVariantFromFlower(standingBlock);
            }

            this.lightningId = uUID;
            this.playSound(SoundEvents.ENTITY_MOOSHROOM_CONVERT, 2.0F, 1.0F);
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(VARIANT, Variant.DEFAULT.index);
        builder.add(HONEY_COUNT, 0);
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);

        // Server already assigned the variant; ensure client uses it immediately
        this.dataTracker.set(VARIANT, this.getVariant().index);
    }

    private void placeFlower(BlockState flower, BlockPos position) {
        BlockState spreadAttemptBlock = this.getEntityWorld().getBlockState(position);
        BlockState spreadAttemptBlock2 = this.getEntityWorld().getBlockState(position.up());
        if (flower.canPlaceAt(this.getEntityWorld(), position)) {
            if (flower.isIn(BlockTags.SMALL_FLOWERS) || flower.isOf(Blocks.CACTUS_FLOWER)) {
                if (spreadAttemptBlock.isIn(BlockTags.AIR)) {
                    this.getEntityWorld().setBlockState(position, flower);
                    ParticleUtil.spawnParticlesAround(this.getEntityWorld(), position, this.random.nextInt(3) + 4, 1.0, 1.0, false, ParticleTypes.HAPPY_VILLAGER);
                }
            } else if (spreadAttemptBlock.isIn(BlockTags.AIR) && spreadAttemptBlock2.isIn(BlockTags.AIR)) {
                this.getEntityWorld().setBlockState(position, flower.with(TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
                this.getEntityWorld().setBlockState(position.up(), flower.with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER));
                ParticleUtil.spawnParticlesAround(this.getEntityWorld(), position, this.random.nextInt(3) + 4, 1.0, 1.0, false, ParticleTypes.HAPPY_VILLAGER);
            }
        }
    }


    private void incrementHoneyCount() {
        if (getHoneyCount() < maxHoneyCount) {
            setHoneyCount(getHoneyCount() + 1);
        } else {
            setHoneyCount(maxHoneyCount);
        }
    }

    private void setHoneyCount(int honeyCount) {
        this.dataTracker.set(HONEY_COUNT, honeyCount);
    }

    public int getHoneyCount() {
        return this.dataTracker.get(HONEY_COUNT);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (getHoneyCount() < maxHoneyCount && itemStack.isOf(Items.HONEY_BOTTLE) && !this.isBaby()) {
            this.eat(player, hand, itemStack);
            this.playSound(ModSoundEvents.ITEM_HONEY_DRINK, 1.0F, 1.0F);
            this.playSound(SoundEvents.ENTITY_MOOSHROOM_EAT, 1.0F, 1.0F);
            if (this.getVariant().getFlowerState().canPlaceAt(this.getEntityWorld(), this.getBlockPos()) && random.nextInt(4) == 0) {
                EffectParticleEffect effectParticleEffect = EffectParticleEffect.of(ParticleTypes.EFFECT, -1, 1.0F);
                for (int j = 0; j < 4; j++) {
                    this.getEntityWorld()
                            .addParticleClient(
                                    effectParticleEffect,
                                    this.getX() + this.random.nextDouble() / 2.0,
                                    this.getBodyY(0.5),
                                    this.getZ() + this.random.nextDouble() / 2.0,
                                    0.0,
                                    this.random.nextDouble() / 5.0,
                                    0.0
                            );
                }
                placeFlower(this.getVariant().getFlowerState(), this.getBlockPos());
                ParticleUtil.spawnParticlesAround(this.getEntityWorld(), this.getBlockPos(), 10, 2.0, 1.0, false, ParticleTypes.HAPPY_VILLAGER);
            } else {
                for (int i = 0; i < 2; i++) {
                    this.getEntityWorld()
                            .addParticleClient(
                                    ParticleTypes.SMOKE,
                                    this.getX() + this.random.nextDouble() / 2.0,
                                    this.getBodyY(0.5),
                                    this.getZ() + this.random.nextDouble() / 2.0,
                                    0.0,
                                    this.random.nextDouble() / 5.0,
                                    0.0
                            );
                }
            }
            incrementHoneyCount();
            return ActionResult.SUCCESS;
        } else if (itemStack.isOf(Items.GLASS_BOTTLE) && !this.isBaby()) {
            boolean bl = false;
            ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, player, new ItemStack(this.getVariant().getFloralMilk()), false);
            player.setStackInHand(hand, itemStack3);
            this.playSound(SoundEvents.ENTITY_MOOSHROOM_SUSPICIOUS_MILK, 1.0F, 1.0F);
            return ActionResult.SUCCESS;
        } else if (itemStack.isOf(Items.SHEARS) && this.isShearable()) {
            if (this.getEntityWorld() instanceof ServerWorld serverWorld) {
                this.sheared(serverWorld, SoundCategory.PLAYERS, itemStack);
                this.emitGameEvent(GameEvent.SHEAR, player);
                itemStack.damage(1, player, hand.getEquipmentSlot());
            }
            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }

    @Override
    public void sheared(ServerWorld world, SoundCategory shearedSoundCategory, ItemStack shears) {
        world.playSoundFromEntity(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
        this.convertTo(EntityType.COW, EntityConversionContext.create(this, false, false), cow -> {
            world.spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getBodyY(0.5), this.getZ(), 1, 0.0, 0.0, 0.0, 0.0);
            this.forEachShearedItem(world, ModLootTables.MOOBLOOM_SHEARING, shears, (worldx, stack) -> {
                for (int i = 0; i < stack.getCount(); i++) {
                    worldx.spawnEntity(new ItemEntity(this.getEntityWorld(), this.getX(), this.getBodyY(1.0), this.getZ(), stack.copyWithCount(1)));
                }
            });
        });
    }

    @Override
    public boolean isShearable() {
        return this.isAlive() && !this.isBaby();
    }

    @Override
    protected void writeCustomData(WriteView view) {
        super.writeCustomData(view);
        view.put("Type", MoobloomEntity.Variant.CODEC, this.getVariant());
        view.putInt("honeyCount",  this.getHoneyCount());
    }

    @Override
    protected void readCustomData(ReadView view) {
        super.readCustomData(view);
        this.setVariant((MoobloomEntity.Variant)view.read("Type", MoobloomEntity.Variant.CODEC).orElse(Variant.DEFAULT));
        this.setHoneyCount(view.getInt("honeyCount", 0));
    }

    private void setVariantFromFlower(BlockState flower) {
        if (flower.isIn(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS)) {
            MoobloomEntity.Variant flowerVariant = this.getVariant();
            for (MoobloomEntity.Variant variant : MoobloomEntity.Variant.values()) {
                if (variant.getFlowerState() == flower) {
                    flowerVariant = variant;
                }
            }
            this.setVariant(flowerVariant);
        }
    }

    private Variant getVariantFromFlower(BlockState flower) {
        if (flower.isIn(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS)) {
            MoobloomEntity.Variant flowerVariant = Variant.DEFAULT;
            for (MoobloomEntity.Variant variant : MoobloomEntity.Variant.values()) {
                if (variant.getFlowerState() == flower) {
                    flowerVariant = variant;
                }
            }
            return flowerVariant;
        } else {
            return Variant.DEFAULT;
        }
    }

    public void setVariant(MoobloomEntity.Variant variant) {
        this.dataTracker.set(VARIANT, variant.index);
    }

    public MoobloomEntity.Variant getVariant() {
        return MoobloomEntity.Variant.fromIndex(this.dataTracker.get(VARIANT));
    }

    @Nullable
    @Override
    public <T> T get(ComponentType<? extends T> type) {
        return type == ModDataComponentTypes.MOOBLOOM_VARIANT ? castComponentValue((ComponentType<T>)type, this.getVariant()) : super.get(type);
    }

    @Override
    protected void copyComponentsFrom(ComponentsAccess from) {
        this.copyComponentFrom(from, ModDataComponentTypes.MOOBLOOM_VARIANT);
        super.copyComponentsFrom(from);
    }

    @Override
    protected <T> boolean setApplicableComponent(ComponentType<T> type, T value) {
        if (type == ModDataComponentTypes.MOOBLOOM_VARIANT) {
            this.setVariant(castComponentValue(ModDataComponentTypes.MOOBLOOM_VARIANT, value));
            return true;
        } else {
            return super.setApplicableComponent(type, value);
        }
    }

    @Nullable
    public MoobloomEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        MoobloomEntity moobloomEntity = ModEntities.MOOBLOOM.create(serverWorld, SpawnReason.BREEDING);
        if (moobloomEntity != null) {
            moobloomEntity.setVariant(this.chooseBabyVariant((MoobloomEntity)passiveEntity));
        }

        return moobloomEntity;
    }

    private Variant chooseBabyVariant(MoobloomEntity moobloom) {
        MoobloomEntity.Variant variant = this.getVariant();
        MoobloomEntity.Variant variant2 = moobloom.getVariant();
        MoobloomEntity.Variant variant3;
        if (this.random.nextInt(64) == 0) {
            variant3 = Variant.getRandomNaturalVariant(this.random);
        } else {
            variant3 = this.random.nextBoolean() ? variant : variant2;
        }
        return variant3;
    }

    @Override
    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        return !effect.equals(StatusEffects.WITHER) && super.canHaveStatusEffect(effect);
    }

    public static enum Variant implements StringIdentifiable {
        DANDELION("dandelion", 0, Blocks.DANDELION.getDefaultState(), ModItems.SATURATION_FLORAL_MILK_BOTTLE, Blocks.YELLOW_WOOL.getDefaultState(), Blocks.YELLOW_TERRACOTTA.getDefaultState(), Blocks.YELLOW_STAINED_GLASS.getDefaultState()),
        POPPY("poppy", 1, Blocks.POPPY.getDefaultState(), ModItems.NIGHT_VISION_FLORAL_MILK_BOTTLE, Blocks.RED_WOOL.getDefaultState(), Blocks.RED_TERRACOTTA.getDefaultState(), Blocks.RED_STAINED_GLASS.getDefaultState()),
        CORNFLOWER("cornflower", 2, Blocks.CORNFLOWER.getDefaultState(), ModItems.JUMP_BOOST_FLORAL_MILK_BOTTLE, Blocks.BLUE_WOOL.getDefaultState(), Blocks.BLUE_TERRACOTTA.getDefaultState(), Blocks.BLUE_STAINED_GLASS.getDefaultState()),
        ALLIUM("allium", 3, Blocks.ALLIUM.getDefaultState(), ModItems.FIRE_RESISTANCE_FLORAL_MILK_BOTTLE, Blocks.MAGENTA_WOOL.getDefaultState(), Blocks.MAGENTA_TERRACOTTA.getDefaultState(), Blocks.MAGENTA_STAINED_GLASS.getDefaultState()),
        BLUE_ORCHID("blue_orchid", 4, Blocks.BLUE_ORCHID.getDefaultState(), ModItems.SATURATION_FLORAL_MILK_BOTTLE, Blocks.LIGHT_BLUE_WOOL.getDefaultState(), Blocks.LIGHT_BLUE_TERRACOTTA.getDefaultState(), Blocks.LIGHT_BLUE_STAINED_GLASS.getDefaultState()),
        OXEYE_DAISY("oxeye_daisy", 5, Blocks.OXEYE_DAISY.getDefaultState(), ModItems.REGENERATION_FLORAL_MILK_BOTTLE, Blocks.LIGHT_GRAY_WOOL.getDefaultState(), Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState(), Blocks.LIGHT_GRAY_STAINED_GLASS.getDefaultState()),
        AZURE_BLUET("azure_bluet", 6, Blocks.AZURE_BLUET.getDefaultState(), ModItems.BLINDNESS_FLORAL_MILK_BOTTLE, Blocks.LIGHT_GRAY_WOOL.getDefaultState(), Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState(), Blocks.LIGHT_GRAY_STAINED_GLASS.getDefaultState()),
        RED_TULIP("red_tulip", 7, Blocks.RED_TULIP.getDefaultState(), ModItems.WEAKNESS_FLORAL_MILK_BOTTLE, Blocks.RED_WOOL.getDefaultState(), Blocks.RED_TERRACOTTA.getDefaultState(), Blocks.RED_STAINED_GLASS.getDefaultState()),
        ORANGE_TULIP("orange_tulip", 8, Blocks.ORANGE_TULIP.getDefaultState(), ModItems.WEAKNESS_FLORAL_MILK_BOTTLE, Blocks.ORANGE_WOOL.getDefaultState(), Blocks.ORANGE_TERRACOTTA.getDefaultState(), Blocks.ORANGE_STAINED_GLASS.getDefaultState()),
        WHITE_TULIP("white_tulip", 9, Blocks.WHITE_TULIP.getDefaultState(), ModItems.WEAKNESS_FLORAL_MILK_BOTTLE, Blocks.LIGHT_GRAY_WOOL.getDefaultState(), Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState(), Blocks.LIGHT_GRAY_STAINED_GLASS.getDefaultState()),
        PINK_TULIP("pink_tulip", 10, Blocks.PINK_TULIP.getDefaultState(), ModItems.WEAKNESS_FLORAL_MILK_BOTTLE, Blocks.PINK_WOOL.getDefaultState(), Blocks.PINK_TERRACOTTA.getDefaultState(), Blocks.PINK_STAINED_GLASS.getDefaultState()),
        LILY_OF_THE_VALLEY("lily_of_the_valley", 11, Blocks.LILY_OF_THE_VALLEY.getDefaultState(), ModItems.POISON_FLORAL_MILK_BOTTLE, Blocks.WHITE_WOOL.getDefaultState(), Blocks.WHITE_TERRACOTTA.getDefaultState(), Blocks.WHITE_STAINED_GLASS.getDefaultState()),
        LILAC("lilac", 12, Blocks.LILAC.getDefaultState(), ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE, Blocks.MAGENTA_WOOL.getDefaultState(), Blocks.MAGENTA_TERRACOTTA.getDefaultState(), Blocks.MAGENTA_STAINED_GLASS.getDefaultState()),
        PEONY("peony", 13, Blocks.PEONY.getDefaultState(), ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE, Blocks.PINK_WOOL.getDefaultState(), Blocks.PINK_TERRACOTTA.getDefaultState(), Blocks.PINK_STAINED_GLASS.getDefaultState()),
        ROSE("rose", 14, Blocks.ROSE_BUSH.getDefaultState(), ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE, Blocks.RED_WOOL.getDefaultState(), Blocks.RED_TERRACOTTA.getDefaultState(), Blocks.RED_STAINED_GLASS.getDefaultState()),
        SUNFLOWER("sunflower", 15, Blocks.SUNFLOWER.getDefaultState(), ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE, Blocks.YELLOW_WOOL.getDefaultState(), Blocks.YELLOW_TERRACOTTA.getDefaultState(), Blocks.YELLOW_STAINED_GLASS.getDefaultState()),
        TORCHFLOWER("torchflower", 16, Blocks.TORCHFLOWER.getDefaultState(), ModItems.NIGHT_VISION_FLORAL_MILK_BOTTLE, Blocks.ORANGE_WOOL.getDefaultState(), Blocks.ORANGE_TERRACOTTA.getDefaultState(), Blocks.ORANGE_STAINED_GLASS.getDefaultState()),
        PITCHER_PLANT("pitcher_plant", 17, Blocks.PITCHER_PLANT.getDefaultState(), ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE, Blocks.CYAN_WOOL.getDefaultState(), Blocks.CYAN_TERRACOTTA.getDefaultState(), Blocks.CYAN_STAINED_GLASS.getDefaultState()),
        OPEN_EYEBLOSSOM("open_eyeblossom", 18, Blocks.OPEN_EYEBLOSSOM.getDefaultState(), ModItems.BLINDNESS_FLORAL_MILK_BOTTLE, Blocks.ORANGE_WOOL.getDefaultState(), Blocks.ORANGE_TERRACOTTA.getDefaultState(), Blocks.ORANGE_STAINED_GLASS.getDefaultState()),
        CLOSED_EYEBLOSSOM("closed_eyeblossom", 19, Blocks.CLOSED_EYEBLOSSOM.getDefaultState(), ModItems.NAUSEA_FLORAL_MILK_BOTTLE,  Blocks.GRAY_WOOL.getDefaultState(), Blocks.GRAY_TERRACOTTA.getDefaultState(), Blocks.GRAY_STAINED_GLASS.getDefaultState()),
        WITHER_ROSE("wither_rose", 20, Blocks.WITHER_ROSE.getDefaultState(), ModItems.WITHER_FLORAL_MILK_BOTTLE, Blocks.BLACK_WOOL.getDefaultState(), Blocks.BLACK_TERRACOTTA.getDefaultState(), Blocks.BLACK_STAINED_GLASS.getDefaultState()),
        CACTUS_FLOWER("cactus_flower", 21, Blocks.CACTUS_FLOWER.getDefaultState(), ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE, Blocks.PINK_WOOL.getDefaultState(), Blocks.PINK_TERRACOTTA.getDefaultState(), Blocks.PINK_STAINED_GLASS.getDefaultState()),
        MONSTERA("monstera", 22, ModFloraBlocks.MONSTERA.getDefaultState(), ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE, Blocks.GREEN_WOOL.getDefaultState(), Blocks.GREEN_TERRACOTTA.getDefaultState(), Blocks.GREEN_STAINED_GLASS.getDefaultState()),
        YELLOW_TULIP("yellow_tulip", 23, ModFloraBlocks.YELLOW_TULIP.getDefaultState(), ModItems.WEAKNESS_FLORAL_MILK_BOTTLE, Blocks.YELLOW_WOOL.getDefaultState(), Blocks.YELLOW_TERRACOTTA.getDefaultState(), Blocks.YELLOW_STAINED_GLASS.getDefaultState()),
        PURPLE_TULIP("purple_tulip", 24, ModFloraBlocks.PURPLE_TULIP.getDefaultState(), ModItems.WEAKNESS_FLORAL_MILK_BOTTLE, Blocks.PURPLE_WOOL.getDefaultState(), Blocks.PURPLE_TERRACOTTA.getDefaultState(), Blocks.PURPLE_STAINED_GLASS.getDefaultState()),
        HELLEBORE("hellebore", 25, ModFloraBlocks.HELLEBORE.getDefaultState(), ModItems.POISON_FLORAL_MILK_BOTTLE, Blocks.LIME_WOOL.getDefaultState(), Blocks.LIME_TERRACOTTA.getDefaultState(), Blocks.LIME_STAINED_GLASS.getDefaultState()),
        GIANT_PADMA("giant_padma", 26, ModFloraBlocks.GIANT_PADMA.getDefaultState(), ModItems.HASTE_FLORAL_MILK_BOTTLE, Blocks.BROWN_WOOL.getDefaultState(), Blocks.BROWN_TERRACOTTA.getDefaultState(), Blocks.BROWN_STAINED_GLASS.getDefaultState());

        private final static MoobloomEntity.Variant DEFAULT = DANDELION;
        private final static List<Variant> NATURAL = List.of(
                MoobloomEntity.Variant.ALLIUM,
                MoobloomEntity.Variant.AZURE_BLUET,
                MoobloomEntity.Variant.CORNFLOWER,
                MoobloomEntity.Variant.DANDELION,
                MoobloomEntity.Variant.LILY_OF_THE_VALLEY,
                MoobloomEntity.Variant.OXEYE_DAISY,
                MoobloomEntity.Variant.POPPY,
                MoobloomEntity.Variant.ORANGE_TULIP,
                MoobloomEntity.Variant.PINK_TULIP,
                MoobloomEntity.Variant.RED_TULIP,
                MoobloomEntity.Variant.WHITE_TULIP,
                MoobloomEntity.Variant.YELLOW_TULIP,
                MoobloomEntity.Variant.PURPLE_TULIP,
                MoobloomEntity.Variant.LILAC,
                MoobloomEntity.Variant.PEONY,
                MoobloomEntity.Variant.ROSE
        );
        private final static List<Variant> COMMON = List.of(
                MoobloomEntity.Variant.DANDELION,
                MoobloomEntity.Variant.POPPY
        );
        private final static List<Variant> UNCOMMON = List.of(
                MoobloomEntity.Variant.ALLIUM,
                MoobloomEntity.Variant.AZURE_BLUET,
                MoobloomEntity.Variant.CORNFLOWER,
                MoobloomEntity.Variant.OXEYE_DAISY,
                MoobloomEntity.Variant.ORANGE_TULIP,
                MoobloomEntity.Variant.PINK_TULIP,
                MoobloomEntity.Variant.RED_TULIP,
                MoobloomEntity.Variant.WHITE_TULIP,
                MoobloomEntity.Variant.YELLOW_TULIP,
                MoobloomEntity.Variant.PURPLE_TULIP
        );
        private final static List<Variant> RARE = List.of(
                MoobloomEntity.Variant.LILY_OF_THE_VALLEY,
                MoobloomEntity.Variant.LILAC,
                MoobloomEntity.Variant.PEONY,
                MoobloomEntity.Variant.ROSE
        );
        private final static List<Variant> EYEBLOSSOMS = List.of(
                Variant.OPEN_EYEBLOSSOM,
                Variant.CLOSED_EYEBLOSSOM
        );
        public static MoobloomEntity.Variant getWeightedNaturalVariant(Random random) {
            int commonWeight = 8;
            int uncommonWeight = 3;

            int total = (commonWeight * COMMON.size()) + (uncommonWeight * UNCOMMON.size()) + RARE.size();
            int roll = random.nextInt(total) + 1;

            int cursor = 0;
            for (int i = 0; i < COMMON.size(); i++) {
                cursor += commonWeight;
                if (cursor >= roll) {
                    return COMMON.get(i);
                }
            }
            for (int i = 0; i < UNCOMMON.size(); i++) {
                cursor += uncommonWeight;
                if (cursor >= roll) {
                    return UNCOMMON.get(i);
                }
            }
            for (int i = 0; i < RARE.size(); i++) {
                cursor += 1;
                if (cursor >= roll) {
                    return RARE.get(i);
                }
            }
            return Variant.DEFAULT;
        }
        public static MoobloomEntity.Variant getRandomNaturalVariant(Random random) {
            return MoobloomEntity.Variant.NATURAL.get(random.nextInt(MoobloomEntity.Variant.NATURAL.size()));
        }
        public static final Codec<MoobloomEntity.Variant> CODEC = StringIdentifiable.createCodec(MoobloomEntity.Variant::values);
        private static final IntFunction<MoobloomEntity.Variant> INDEX_MAPPER = ValueLists.createIndexToValueFunction(
                MoobloomEntity.Variant::getIndex, values(), ValueLists.OutOfBoundsHandling.CLAMP
        );
        public static final PacketCodec<ByteBuf, MoobloomEntity.Variant> PACKET_CODEC = PacketCodecs.indexed(INDEX_MAPPER, MoobloomEntity.Variant::getIndex);
        private final String name;
        final int index;
        private final BlockState flower;
        private final Item floralMilk;
        private final BlockState wool;
        private final BlockState terracotta;
        private final BlockState glass;

        private Variant(final String name, final int index, final BlockState flower, final Item floralMilk, final BlockState wool, final BlockState terracotta, final BlockState glass) {
            this.name = name;
            this.index = index;
            this.flower = flower;
            this.floralMilk = floralMilk;
            this.wool = wool;
            this.terracotta = terracotta;
            this.glass = glass;
        }

        public BlockState getFlowerState() {
            return this.flower;
        }
        public Item getFloralMilk() {
            return this.floralMilk;
        }
        public BlockState getWoolState() {
            return this.wool;
        }
        public BlockState getTerracottaState() {
            return this.terracotta;
        }
        public BlockState getGlassState() {
            return this.glass;
        }

        @Override
        public String asString() {
            return this.name;
        }

        private int getIndex() {
            return this.index;
        }

        static MoobloomEntity.Variant fromIndex(int index) {
            return (MoobloomEntity.Variant)INDEX_MAPPER.apply(index);
        }
    }
}
