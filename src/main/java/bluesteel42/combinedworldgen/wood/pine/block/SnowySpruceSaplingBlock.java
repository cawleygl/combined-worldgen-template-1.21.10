package bluesteel42.combinedworldgen.wood.pine.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class SnowySpruceSaplingBlock extends PlantBlock implements Fertilizable {
    public static final MapCodec<SnowySpruceSaplingBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(SaplingGenerator.CODEC.fieldOf("tree").forGetter(block -> block.generator), createSettingsCodec())
                    .apply(instance, SnowySpruceSaplingBlock::new)
    );
    public static final IntProperty STAGE = Properties.STAGE;
    private static final VoxelShape SHAPE = Block.createColumnShape(12.0, 0.0, 12.0);
    protected final SaplingGenerator generator;

    @Override
    public MapCodec<? extends SnowySpruceSaplingBlock> getCodec() {
        return CODEC;
    }

    public SnowySpruceSaplingBlock(SaplingGenerator generator, Settings settings) {
        super(settings);
        this.generator = generator;
        this.setDefaultState(this.stateManager.getDefaultState().with(STAGE, 0));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public static BlockState getMeltedState() {
        return Blocks.SPRUCE_SAPLING.getDefaultState();
    }

    protected void melt(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, getMeltedState());
        world.updateNeighbor(pos, getMeltedState().getBlock(), null);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 11 - state.getOpacity()) {
            this.melt(state, world, pos);
        }
        if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(7) == 0) {
            this.generate(world, pos, state, random);
        }
    }

    public void generate(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        if ((Integer)state.get(STAGE) == 0) {
            world.setBlockState(pos, state.cycle(STAGE), Block.SKIP_REDRAW_AND_BLOCK_ENTITY_REPLACED_CALLBACK);
        } else {
            this.generator.generate(world, world.getChunkManager().getChunkGenerator(), pos, state, random);
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return world.random.nextFloat() < 0.45;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.generate(world, pos, state, random);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
