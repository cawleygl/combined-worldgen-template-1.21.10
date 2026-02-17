package bluesteel42.combinedworldgen.wood.pine.block;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class SnowySaplingBlock extends SaplingBlock {
    private final Block meltedBlock;
    public SnowySaplingBlock(SaplingGenerator generator, AbstractBlock.Settings settings, Block meltedBlockInit) {
        super(generator, settings);
        meltedBlock = meltedBlockInit;
    }

    public static BlockState getMeltedState(Block meltedBlock) {
        return meltedBlock.getDefaultState();
    }

    protected void melt(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, getMeltedState(this.meltedBlock));
        world.updateNeighbor(pos, getMeltedState(this.meltedBlock).getBlock(), null);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) > 11 - state.getOpacity()) {
            this.melt(state, world, pos);
        }
        super.randomTick(state, world, pos, random);
    }
}
