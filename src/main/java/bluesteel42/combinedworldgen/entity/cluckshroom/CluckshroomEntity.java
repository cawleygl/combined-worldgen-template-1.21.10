package bluesteel42.combinedworldgen.entity.cluckshroom;

import bluesteel42.combinedworldgen.entity.ModEntities;
import bluesteel42.combinedworldgen.entity.ModLootTables;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.conversion.EntityConversionContext;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.function.IntFunction;

public class CluckshroomEntity extends AnimalEntity implements Shearable {
    private static final EntityDimensions BABY_BASE_DIMENSIONS = EntityType.CHICKEN.getDimensions().scaled(0.5F).withEyeHeight(0.2975F);
    private static final TrackedData<Integer> VARIANT = DataTracker.registerData(CluckshroomEntity.class, TrackedDataHandlerRegistry.INTEGER);
    public float flapProgress;
    public float maxWingDeviation;
    public float prevMaxWingDeviation;
    public float prevFlapProgress;
    public float flapSpeed = 1.0F;
    private float field_28639 = 1.0F;
    public int eggLayTime = this.random.nextInt(6000) + 6000;
    @Nullable
    private UUID lightningId;

    public CluckshroomEntity(EntityType<? extends CluckshroomEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0F);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4));
        this.goalSelector.add(2, new PassiveAvoidSunlightGoal(this));
        this.goalSelector.add(3, new PassiveEscapeSunlightGoal(this, 1.4));
        this.goalSelector.add(4, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(5, new TemptGoal(this, 1.0, stack -> stack.isIn(ItemTags.CHICKEN_FOOD), false));
        this.goalSelector.add(6, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(7, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(8, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(9, new LookAroundGoal(this));
    }

    @Override
    public EntityDimensions getBaseDimensions(EntityPose pose) {
        return this.isBaby() ? BABY_BASE_DIMENSIONS : super.getBaseDimensions(pose);
    }

    public static DefaultAttributeContainer.Builder createChickenAttributes() {
        return AnimalEntity.createAnimalAttributes().add(EntityAttributes.MAX_HEALTH, 4.0).add(EntityAttributes.MOVEMENT_SPEED, 0.25);
    }

    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos.down()).isOf(Blocks.MYCELIUM) ? 10.0F : -world.getPhototaxisFavor(pos);
    }

    public static boolean canSpawn(EntityType<CluckshroomEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBlockState(pos.down()).isIn(BlockTags.MOOSHROOMS_SPAWNABLE_ON) && isLightLevelValidForNaturalSpawn(world, pos);
    }


    @Override
    public void onStruckByLightning(ServerWorld world, LightningEntity lightning) {
        UUID uUID = lightning.getUuid();
        if (!uUID.equals(this.lightningId)) {
            this.setVariant(this.getVariant() == CluckshroomEntity.Variant.RED ? CluckshroomEntity.Variant.BROWN : CluckshroomEntity.Variant.RED);
            this.lightningId = uUID;
            this.playSound(SoundEvents.ENTITY_MOOSHROOM_CONVERT, 2.0F, 1.0F);
        }
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(VARIANT, CluckshroomEntity.Variant.DEFAULT.index);
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        this.prevFlapProgress = this.flapProgress;
        this.prevMaxWingDeviation = this.maxWingDeviation;
        this.maxWingDeviation = this.maxWingDeviation + (this.isOnGround() ? -1.0F : 4.0F) * 0.3F;
        this.maxWingDeviation = MathHelper.clamp(this.maxWingDeviation, 0.0F, 1.0F);
        if (!this.isOnGround() && this.flapSpeed < 1.0F) {
            this.flapSpeed = 1.0F;
        }

        this.flapSpeed *= 0.9F;
        Vec3d vec3d = this.getVelocity();
        if (!this.isOnGround() && vec3d.y < 0.0) {
            this.setVelocity(vec3d.multiply(1.0, 0.6, 1.0));
        }

        this.flapProgress = this.flapProgress + this.flapSpeed * 2.0F;
        if (this.getEntityWorld() instanceof ServerWorld serverWorld && this.isAlive() && !this.isBaby() && --this.eggLayTime <= 0) {
            RegistryKey<LootTable> laidEgg = ModLootTables.RED_CLUCKSHROOM_LAY_GAMEPLAY;
            if (this.getVariant() == CluckshroomEntity.Variant.BROWN) {
                laidEgg = ModLootTables.BROWN_CLUCKSHROOM_LAY_GAMEPLAY;
            }
            if (this.forEachGiftedItem(serverWorld, laidEgg, this::dropStack)) {
                this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                this.emitGameEvent(GameEvent.ENTITY_PLACE);
            }

            this.eggLayTime = this.random.nextInt(6000) + 6000;
        }

        if (this.getEntityWorld() instanceof ServerWorld serverWorld) {
            if (!serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                return;
            }

            if (!this.isBaby()) {
                if (this.random.nextInt(128) == 0) {
                    int i = random.nextInt(4);
                    int j = MathHelper.floor(this.getX() + (i % 2 * 2 - 1) * 0.25F);
                    int k = MathHelper.floor(this.getY());
                    int l = MathHelper.floor(this.getZ() + (i / 2 % 2 * 2 - 1) * 0.25F);
                    BlockPos blockPos = new BlockPos(j, k, l);
                    BlockState mushroom = this.getVariant().getMushroomState();
                    if (this.getEntityWorld().getBlockState(blockPos).isIn(BlockTags.AIR) && mushroom.canPlaceAt(this.getEntityWorld(), blockPos)) {
                        this.getEntityWorld().setBlockState(blockPos, mushroom);
                        this.getEntityWorld().emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, mushroom));
                        this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 0.75F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 0.5F);
                    }
                }

            }
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.SHEARS) && this.isShearable()) {
            if (this.getEntityWorld() instanceof ServerWorld serverWorld) {
                this.sheared(serverWorld, SoundCategory.PLAYERS, itemStack);
                this.emitGameEvent(GameEvent.SHEAR, player);
                itemStack.damage(1, player, hand.getEquipmentSlot());
            }

            return ActionResult.SUCCESS;
        } else {
            return super.interactMob(player, hand);
        }
    }



    @Override
    protected boolean isFlappingWings() {
        return this.speed > this.field_28639;
    }

    @Override
    protected void addFlapEffects() {
        this.field_28639 = this.speed + this.maxWingDeviation / 2.0F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ItemTags.CHICKEN_FOOD);
    }

    @Override
    protected void writeCustomData(WriteView view) {
        super.writeCustomData(view);
        view.put("Type", CluckshroomEntity.Variant.CODEC, this.getVariant());
        view.putInt("EggLayTime", this.eggLayTime);
    }

    @Override
    protected void readCustomData(ReadView view) {
        super.readCustomData(view);
        this.setVariant((CluckshroomEntity.Variant)view.read("Type", CluckshroomEntity.Variant.CODEC).orElse(CluckshroomEntity.Variant.DEFAULT));
        view.getOptionalInt("EggLayTime").ifPresent(eggLayTime -> this.eggLayTime = eggLayTime);
    }

    @Override
    protected void updatePassengerPosition(Entity passenger, PositionUpdater positionUpdater) {
        super.updatePassengerPosition(passenger, positionUpdater);
        if (passenger instanceof LivingEntity) {
            ((LivingEntity)passenger).bodyYaw = this.bodyYaw;
        }
    }

    @Override
    public void sheared(ServerWorld world, SoundCategory shearedSoundCategory, ItemStack shears) {
        world.playSoundFromEntity(null, this, SoundEvents.ENTITY_MOOSHROOM_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
        this.convertTo(EntityType.CHICKEN, EntityConversionContext.create(this, false, false), chicken -> {
            world.spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getBodyY(0.5), this.getZ(), 1, 0.0, 0.0, 0.0, 0.0);
            this.forEachShearedItem(world, ModLootTables.CLUCKSHROOM_SHEARING, shears, (worldx, stack) -> {
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

    void setVariant(CluckshroomEntity.Variant variant) {
        this.dataTracker.set(VARIANT, variant.index);
    }

    public CluckshroomEntity.Variant getVariant() {
        return CluckshroomEntity.Variant.fromIndex(this.dataTracker.get(VARIANT));
    }

    @Nullable
    public CluckshroomEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        CluckshroomEntity cluckshroomEntity = ModEntities.CLUCKSHROOM.create(serverWorld, SpawnReason.BREEDING);
        if (cluckshroomEntity != null) {
            cluckshroomEntity.setVariant(this.chooseBabyVariant((CluckshroomEntity)passiveEntity));
        }

        return cluckshroomEntity;
    }

    private CluckshroomEntity.Variant chooseBabyVariant(CluckshroomEntity cluckshroom) {
        CluckshroomEntity.Variant variant = this.getVariant();
        CluckshroomEntity.Variant variant2 = cluckshroom.getVariant();
        CluckshroomEntity.Variant variant3;
        if (variant == variant2 && this.random.nextInt(1024) == 0) {
            variant3 = variant == CluckshroomEntity.Variant.BROWN ? CluckshroomEntity.Variant.RED : CluckshroomEntity.Variant.BROWN;
        } else {
            variant3 = this.random.nextBoolean() ? variant : variant2;
        }

        return variant3;
    }

    public static enum Variant implements StringIdentifiable {
        RED("red", 0, Blocks.RED_MUSHROOM.getDefaultState()),
        BROWN("brown", 1, Blocks.BROWN_MUSHROOM.getDefaultState());

        public static final CluckshroomEntity.Variant DEFAULT = RED;
        public static final Codec<CluckshroomEntity.Variant> CODEC = StringIdentifiable.createCodec(CluckshroomEntity.Variant::values);
        private static final IntFunction<CluckshroomEntity.Variant> INDEX_MAPPER = ValueLists.createIndexToValueFunction(
                CluckshroomEntity.Variant::getIndex, values(), ValueLists.OutOfBoundsHandling.CLAMP
        );
        public static final PacketCodec<ByteBuf, CluckshroomEntity.Variant> PACKET_CODEC = PacketCodecs.indexed(INDEX_MAPPER, CluckshroomEntity.Variant::getIndex);
        private final String name;
        final int index;
        private final BlockState mushroom;

        private Variant(final String name, final int index, final BlockState mushroom) {
            this.name = name;
            this.index = index;
            this.mushroom = mushroom;
        }

        public BlockState getMushroomState() {
            return this.mushroom;
        }

        @Override
        public String asString() {
            return this.name;
        }

        private int getIndex() {
            return this.index;
        }

        static CluckshroomEntity.Variant fromIndex(int index) {
            return (CluckshroomEntity.Variant)INDEX_MAPPER.apply(index);
        }
    }

}
