package bluesteel42.combinedworldgen.block.flora;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class SnowyShortPlantBlock extends ShortPlantBlock {
    public SnowyShortPlantBlock(Settings settings) {
        super(settings);
    }

    public static BlockState getMeltedState(BlockState state) {
        return state.isOf(ModFloraBlocks.SNOWY_FERN) ? Blocks.FERN.getDefaultState() : Blocks.SHORT_GRASS.getDefaultState();
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
        world.setBlockState(pos, getMeltedState(state));
        world.updateNeighbor(pos, getMeltedState(state).getBlock(), null);
    }
}
