package bluesteel42.combinedworldgen.entity.cluckshroom;

import bluesteel42.combinedworldgen.entity.ModEntities;
import bluesteel42.combinedworldgen.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class CluckshroomEggEntity extends ThrownItemEntity {
    private static final EntityDimensions EMPTY_DIMENSIONS = EntityDimensions.fixed(0.0F, 0.0F);

    public CluckshroomEggEntity(EntityType<CluckshroomEggEntity> entityType, World world) {
        super(entityType, world);
    }

    public CluckshroomEggEntity(World world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.CLUCKSHROOM_EGG, owner, world, stack);
    }

    public CluckshroomEggEntity(World world, double x, double y, double z, ItemStack stack) {
        super(ModEntities.CLUCKSHROOM_EGG, x, y, z, world, stack);
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES) {
            double d = 0.08;

            for (int i = 0; i < 8; i++) {
                this.getEntityWorld()
                        .addParticleClient(
                                new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack()),
                                this.getX(),
                                this.getY(),
                                this.getZ(),
                                ((double)this.random.nextFloat() - 0.5) * 0.08,
                                ((double)this.random.nextFloat() - 0.5) * 0.08,
                                ((double)this.random.nextFloat() - 0.5) * 0.08
                        );
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().serverDamage(this.getDamageSources().thrown(this, this.getOwner()), 0.0F);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getEntityWorld().isClient()) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for (int j = 0; j < i; j++) {
                    CluckshroomEntity cluckshroomEntity = ModEntities.CLUCKSHROOM.create(this.getEntityWorld(), SpawnReason.TRIGGERED);
                    if (cluckshroomEntity != null) {
                        cluckshroomEntity.setBreedingAge(-24000);
                        cluckshroomEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                        if (!cluckshroomEntity.recalculateDimensions(EMPTY_DIMENSIONS)) {
                            break;
                        }

                        this.getEntityWorld().spawnEntity(cluckshroomEntity);
                    }
                }
            }
            if (this.random.nextInt(5) == 0) {
                int i = random.nextInt(4);
                int j = MathHelper.floor(this.getX() + (i % 2 * 2 - 1) * 0.25F);
                int k = MathHelper.floor(this.getY());
                int l = MathHelper.floor(this.getZ() + (i / 2 % 2 * 2 - 1) * 0.25F);
                BlockPos blockPos = new BlockPos(j, k, l);
                BlockState mushroom = this.random.nextBoolean() ? Blocks.RED_MUSHROOM.getDefaultState() : Blocks.BROWN_MUSHROOM.getDefaultState();
                if (this.getEntityWorld().getBlockState(blockPos).isIn(BlockTags.AIR) && mushroom.canPlaceAt(this.getEntityWorld(), blockPos)) {
                    this.getEntityWorld().setBlockState(blockPos, mushroom);
                    this.getEntityWorld().emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, mushroom));
                }
            }

            this.getEntityWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.CLUCKSHROOM_EGG;
    }
}
