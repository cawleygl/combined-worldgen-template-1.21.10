package bluesteel42.combinedworldgen.wood.citrus.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.TintedParticleLeavesBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class FloweringOrangeLeavesBlock extends TintedParticleLeavesBlock implements Fertilizable {
    public static final MapCodec<FloweringOrangeLeavesBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            Codecs.rangedInclusiveFloat(0.0F, 1.0F).fieldOf("leaf_particle_chance").forGetter(block -> block.leafParticleChance), createSettingsCodec())
                    .apply(instance, FloweringOrangeLeavesBlock::new)
    );
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = Properties.AGE_3;

    @Override
    public MapCodec<FloweringOrangeLeavesBlock> getCodec() {
        return CODEC;
    }

    public FloweringOrangeLeavesBlock(float f, Settings settings) {
        super(f, settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(DISTANCE, 7).with(PERSISTENT, false).with(WATERLOGGED, false).with(AGE, 0));
    }

    protected IntProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    public int getAge(BlockState state) {
        return (Integer)state.get(this.getAgeProperty());
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return !this.isMature(state) || ((Integer)state.get(DISTANCE) == 7 && !(Boolean)state.get(PERSISTENT));
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (this.shouldDecay(state)) {
            dropStacks(state, world, pos);
            world.removeBlock(pos, false);
        } else if (world.getBaseLightLevel(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                if (random.nextInt(100) == 0) {
                    world.setBlockState(pos, this.withAgeDistanceAndPersistence(i + 1, state), Block.NOTIFY_LISTENERS);
                }
            }
        }
    }

    public BlockState withAgeDistanceAndPersistence(int age, BlockState state) {
        return this.getDefaultState().with(DISTANCE, state.get(DISTANCE)).with(PERSISTENT, state.get(PERSISTENT)).with(this.getAgeProperty(), age);
    }

    public final boolean isMature(BlockState state) {
        return this.getAge(state) >= this.getMaxAge();
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return !this.isMature(state);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int i = Math.min(this.getMaxAge(), this.getAge(state) + 1);
        world.setBlockState(pos, this.withAgeDistanceAndPersistence(i, state), Block.NOTIFY_LISTENERS);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.applyGrowth(world, pos, state);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(AGE);
    }
}
