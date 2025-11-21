package bluesteel42.combinedworldgen.entity.moobloom;

import bluesteel42.combinedworldgen.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

import java.util.EnumSet;
import java.util.function.Predicate;

public class SpreadFlowersGoal extends Goal {
    private static final int MAX_TIMER = 40;
    private static final Predicate<BlockState> SPREADABLE_PREDICATE = state -> state.isIn(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS);
    private final MoobloomEntity mob;
    private final World world;
    private int timer;

    public SpreadFlowersGoal(MoobloomEntity mob) {
        this.mob = mob;
        this.world = mob.getEntityWorld();
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK, Control.JUMP));
    }

    @Override
    public boolean canStart() {
        if (this.mob.isBaby() || this.mob.getRandom().nextInt(this.getTickCount(1000)) != 0) {
            return false;
        } else {
            BlockPos blockPos = this.mob.getBlockPos();
            return SPREADABLE_PREDICATE.test(this.world.getBlockState(blockPos));
        }
    }

    @Override
    public void start() {
        this.timer = this.getTickCount(40);
        this.world.sendEntityStatus(this.mob, EntityStatuses.SET_SHEEP_EAT_GRASS_TIMER_OR_PRIME_TNT_MINECART);
        this.mob.getNavigation().stop();
    }

    @Override
    public void stop() {
        this.timer = 0;
    }

    @Override
    public boolean shouldContinue() {
        return this.timer > 0;
    }

    public int getTimer() {
        return this.timer;
    }


    private static void spawnBonemealLikeParticles(ServerWorld world, BlockPos pos) {
        Random random = world.getRandom();
        double baseX = pos.getX();
        double baseY = pos.getY();
        double baseZ = pos.getZ();

        for (int i = 0; i < random.nextInt(4) + 7; ++i) {
            double x = baseX + (random.nextDouble() - 0.5) * 1.2;
            double y = baseY + random.nextDouble() * 1.2;
            double z = baseZ + (random.nextDouble() - 0.5) * 1.2;
            double velX = random.nextGaussian() * 0.02;
            double velY = random.nextGaussian() * 0.02;
            double velZ = random.nextGaussian() * 0.02;

            world.spawnParticles(
                    ParticleTypes.HAPPY_VILLAGER,
                    x, y, z,
                    0,
                    velX, velY, velZ,
                    1.0
            );
        }
    }

    private void placeFlower(BlockState flower, BlockPos position) {
        BlockState spreadAttemptBlock = this.world.getBlockState(position);
        BlockState spreadAttemptBlock2 = this.world.getBlockState(position.up());
        if (flower.canPlaceAt(this.world, position)) {
            if (flower.isIn(BlockTags.SMALL_FLOWERS) || flower.isOf(Blocks.CACTUS_FLOWER)) {
                if (spreadAttemptBlock.isIn(BlockTags.AIR)) {
                    this.world.setBlockState(position, flower);
                    spawnBonemealLikeParticles((ServerWorld) this.world, position);
                    ((ServerWorld) this.world).syncWorldEvent(WorldEvents.BONE_MEAL_USED, position, 15);
                }
            } else if (spreadAttemptBlock.isIn(BlockTags.AIR) && spreadAttemptBlock2.isIn(BlockTags.AIR)) {
                this.world.setBlockState(position, flower.with(TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
                this.world.setBlockState(position.up(), flower.with(TallPlantBlock.HALF, DoubleBlockHalf.UPPER));
                spawnBonemealLikeParticles((ServerWorld) this.world, position);
                ((ServerWorld) this.world).syncWorldEvent(WorldEvents.BONE_MEAL_USED, position, 15);
            }
        }
    }

    @Override
    public void tick() {
        this.timer = Math.max(0, this.timer - 1);
        if (this.timer == this.getTickCount(4)) {
            BlockPos blockPos = this.mob.getBlockPos();
            BlockState variantFlower = this.mob.getVariant().getFlowerState();
            BlockState plantedFlower = this.world.getBlockState(blockPos);
            spawnBonemealLikeParticles((ServerWorld) this.world, blockPos);
            if (plantedFlower == variantFlower) {
                for (int l = -1; l < 2; l++) {
                    for (int m = 0; m < this.mob.getRandom().nextInt(4) + 6; m++) {
                        BlockPos blockPos2 = blockPos.add(this.mob.getRandom().nextInt(5) - 2, l, this.mob.getRandom().nextInt(5) - 2);
                        placeFlower(variantFlower, blockPos2);
                    }

                }
            } else {
                for (int n = -1; n < 2; n++) {
                    for (int m = 0; m < this.mob.getRandom().nextInt(2) + 1; m++) {
                        BlockPos blockPos2 = blockPos.add(this.mob.getRandom().nextInt(3) - 1, n, this.mob.getRandom().nextInt(3) - 1);
                        placeFlower(variantFlower, blockPos2);
                    }
                }
            }
            this.mob.onSpreadingFlowers();
        }
    }

}
