package bluesteel42.combinedworldgen.wood.willow.tree;

import bluesteel42.combinedworldgen.wood.willow.block.WillowWoodModBlocks;
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
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.PlaceOnGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class WillowWoodTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> WILLOW_TREE_KEY = ModConfiguredFeatures.registerKey("willow_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WILLOW_TREE_LEAF_LITTER_KEY = ModConfiguredFeatures.registerKey("willow_tree_leaf_litter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WEEPING_WILLOW_KEY = ModConfiguredFeatures.registerKey("weeping_willow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_WILLOW_TREE_KEY = ModConfiguredFeatures.registerKey("fallen_willow_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        PlaceOnGroundTreeDecorator placeOnGroundTreeDecorator = new PlaceOnGroundTreeDecorator(
                96, 4, 2, new WeightedBlockStateProvider(VegetationConfiguredFeatures.leafLitter(1, 3))
        );
        PlaceOnGroundTreeDecorator placeOnGroundTreeDecorator2 = new PlaceOnGroundTreeDecorator(
                150, 2, 2, new WeightedBlockStateProvider(VegetationConfiguredFeatures.leafLitter(1, 4))
        );

        TreeFeatureConfig.Builder smallWillowTree = new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WillowWoodModBlocks.MOD_LOG),
                new StraightTrunkPlacer(5, 3, 0),
                BlockStateProvider.of(WillowWoodModBlocks.MOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        );
        LeavesVineTreeDecorator smallWillowVines = new LeavesVineTreeDecorator(0.5F);

        ModConfiguredFeatures.register(context, WILLOW_TREE_KEY, Feature.TREE, smallWillowTree
                .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, smallWillowVines))
                .build());
        ModConfiguredFeatures.register(context, WILLOW_TREE_LEAF_LITTER_KEY, Feature.TREE, smallWillowTree
                .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, smallWillowVines, placeOnGroundTreeDecorator, placeOnGroundTreeDecorator2))
                .build());

        ModConfiguredFeatures.register(context, WEEPING_WILLOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(WillowWoodModBlocks.MOD_LOG),
                new WillowTrunkPlacer(6, 3, 2, UniformIntProvider.create(2, 4), UniformIntProvider.create(7, 9), UniformIntProvider.create(3, 5), UniformIntProvider.create(3, 4), UniformIntProvider.create(2, 4)),
                BlockStateProvider.of(WillowWoodModBlocks.MOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(1, 0, 2)
        )
                .decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.7F)))
                .build());

        ModConfiguredFeatures.register(context, FALLEN_WILLOW_TREE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(WillowWoodModBlocks.MOD_LOG), UniformIntProvider.create(5, 8))
                .logDecorators(
                        ImmutableList.of(
                                new AttachedToLogsTreeDecorator(
                                        0.5F,
                                        new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 1).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 2)),
                                        List.of(Direction.UP)
                                )
                        )
                ).stumpDecorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());

    }

}
