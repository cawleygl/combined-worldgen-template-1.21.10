package bluesteel42.combinedworldgen.wood.maple.tree;

import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
import bluesteel42.combinedworldgen.world.tree.ModTreeBuilders;
import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class ShortMapleTreeFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<ShortMapleTreeFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance -> createCodec(instance).apply(instance, ShortMapleTreeFoliagePlacer::new));
    protected final int height;
    protected final int mixedLeafChance;

    protected static <P extends ShortMapleTreeFoliagePlacer> Products.P4<RecordCodecBuilder.Mu<P>, IntProvider, IntProvider, Integer, Integer> createCodec(RecordCodecBuilder.Instance<P> builder) {
        return fillFoliagePlacerFields(builder).and(Codec.intRange(0, 16).fieldOf("height").forGetter(placer -> placer.height)).and(Codec.intRange(0, 256).fieldOf("mixedLeafChance").forGetter(placer -> placer.mixedLeafChance));
    }

    public ShortMapleTreeFoliagePlacer(IntProvider radius, IntProvider offset, int height, int mixedLeafChance) {
        super(radius, offset);
        this.height = height;
        this.mixedLeafChance = mixedLeafChance;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModTreeBuilders.SHORT_MAPLE_TREE_FOLIAGE_PLACER;
    }

    protected static boolean placeFoliageBlock(TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos pos, boolean mixedLeaves, BlockState blockState) {
        boolean bl = world.testBlockState(pos, state -> (Boolean)state.get(Properties.PERSISTENT, false));
        if (!bl && TreeFeature.canReplace(world, pos)) {
            if (mixedLeaves) {
                if (random.nextInt(3) != 0) {
                    blockState = MapleWoodModBlocks.MIXED_MAPLE_LEAVES.getDefaultState();
                }
            }

            if (blockState.contains(Properties.WATERLOGGED)) {
                blockState = blockState.with(Properties.WATERLOGGED, world.testFluidState(pos, fluidState -> fluidState.isEqualAndStill(Fluids.WATER)));
            }

            placer.placeBlock(pos, blockState);
            return true;
        } else {
            return false;
        }
    }

    protected void generateSquare(
            TestableWorld world, FoliagePlacer.BlockPlacer placer, Random random, TreeFeatureConfig config, BlockPos centerPos, int radius, int y, boolean giantTrunk, boolean mixedLeaves, BlockState block
    ) {
        int i = giantTrunk ? 1 : 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for (int j = -radius; j <= radius + i; j++) {
            for (int k = -radius; k <= radius + i; k++) {
                if (!this.isPositionInvalid(random, j, y, k, radius, giantTrunk)) {
                    mutable.set(centerPos, j, y, k);
                    placeFoliageBlock(world, placer, random, config, mutable, mixedLeaves, block);
                }
            }
        }
    }

    @Override
    protected void generate(
            TestableWorld world,
            FoliagePlacer.BlockPlacer placer,
            Random random,
            TreeFeatureConfig config,
            int trunkHeight,
            FoliagePlacer.TreeNode treeNode,
            int foliageHeight,
            int radius,
            int offset
    ) {
        BlockState blockState = config.foliageProvider.get(random, new BlockPos.Mutable());
        Boolean mixedLeaves = random.nextInt(this.mixedLeafChance) == 0;
        for (int i = offset; i >= offset - foliageHeight; i--) {
            int j = Math.max(radius + treeNode.getFoliageRadius() - 1 - i / 2, 0);
            this.generateSquare(world, placer, random, config, treeNode.getCenter(), j, i, treeNode.isGiantTrunk(), mixedLeaves, blockState);
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return this.height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        if (radius == 3) {
            // Remove corners
            if (dx == radius && dz == radius) {
                return true;
            }
            // Remove positions near corners with 50% chance
            if ((dx == radius || dz == radius) && (dx >= radius - 1 && dz >= radius - 1)) {
                return random.nextInt(2) == 0;
            }
        }

        return dx == radius && dz == radius && (random.nextInt(2) == 0 || y == 0);
    }
}
