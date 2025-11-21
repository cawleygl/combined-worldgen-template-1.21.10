package bluesteel42.combinedworldgen.wood.citrus.tree;

import bluesteel42.combinedworldgen.wood.citrus.block.CitrusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModConfiguredFeatures;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

import static bluesteel42.combinedworldgen.wood.citrus.block.FloweringOrangeLeavesBlock.AGE;

public class CitrusWoodTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_TREE = ModConfiguredFeatures.registerKey("orange_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_BUSH = ModConfiguredFeatures.registerKey("orange_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_ORANGE_TREE = ModConfiguredFeatures.registerKey("fallen_orange_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        BlockStateProvider orangeLeaves = new WeightedBlockStateProvider(Pool.<BlockState>builder()
                .add(CitrusWoodModBlocks.MOD_LEAVES.getDefaultState(), 360)
                .add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES.getDefaultState().with(AGE, 0), 4)
                .add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES.getDefaultState().with(AGE, 1), 2)
                .add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES.getDefaultState().with(AGE, 2), 1)
                .add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES.getDefaultState().with(AGE, 3), 1)
        );

        ModConfiguredFeatures.register(context, ORANGE_TREE, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(CitrusWoodModBlocks.MOD_LOG),
                        new StraightTrunkPlacer(3, 2, 0),
                        orangeLeaves,
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25F)))
                        .ignoreVines()
                        .build()
        );
        ModConfiguredFeatures.register(context, ORANGE_BUSH, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(CitrusWoodModBlocks.MOD_LOG),
                        new StraightTrunkPlacer(1, 0, 0),
                        orangeLeaves,
                        new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0)
                )
                        .build()
        );
        ModConfiguredFeatures.register(context, FALLEN_ORANGE_TREE, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(CitrusWoodModBlocks.MOD_LOG), UniformIntProvider.create(3, 5))
                .logDecorators(
                        ImmutableList.of(
                                new AttachedToLogsTreeDecorator(
                                        0.1F,
                                        new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 2).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)),
                                        List.of(Direction.UP)
                                )
                        )
                ).stumpDecorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());
    }

}
