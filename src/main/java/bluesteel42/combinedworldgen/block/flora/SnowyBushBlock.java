package bluesteel42.combinedworldgen.block.flora;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class SnowyBushBlock extends PlantBlock implements Fertilizable {
    public static final MapCodec<BushBlock> CODEC = createCodec(BushBlock::new);
    private static final VoxelShape SHAPE = Block.createColumnShape(16.0, 0.0, 13.0);

    @Override
    public MapCodec<BushBlock> getCodec() {
        return CODEC;
    }

    public SnowyBushBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return Fertilizable.canSpread(world, pos, state);
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        Fertilizable.findPosToSpreadTo(world, pos, state).ifPresent(posx -> world.setBlockState(posx, this.getDefaultState()));
    }

    public static BlockState getMeltedState() {
        return Blocks.BUSH.getDefaultState();
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 11 - state.getOpacity()) {
            this.melt(state, world, pos);
        }
    }

    protected void melt(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, getMeltedState());
        world.updateNeighbor(pos, getMeltedState().getBlock(), null);
    }
}
