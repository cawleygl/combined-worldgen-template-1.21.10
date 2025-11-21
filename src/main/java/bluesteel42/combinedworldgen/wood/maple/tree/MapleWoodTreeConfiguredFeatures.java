package bluesteel42.combinedworldgen.wood.maple.tree;

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
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.PlaceOnGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class MapleWoodTreeConfiguredFeatures {
    /* SAPLING-GENERATED */
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_MULTICOLORED_MAPLE_KEY = ModConfiguredFeatures.registerKey("tall_multicolored_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_MULTICOLORED_MAPLE_KEY = ModConfiguredFeatures.registerKey("short_multicolored_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_MULTICOLORED_MAPLE_BEES_005_KEY = ModConfiguredFeatures.registerKey("tall_multicolored_maple_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_MULTICOLORED_MAPLE_BEES_005_KEY = ModConfiguredFeatures.registerKey("short_multicolored_maple_bees_005");

    /* FOREST / WATER */
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_GREEN_MAPLE_BEES_0002_LEAF_LITTER_KEY = ModConfiguredFeatures.registerKey("tall_green_maple_bees_0002_leaf_litter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_GREEN_MAPLE_BEES_0002_LEAF_LITTER_KEY = ModConfiguredFeatures.registerKey("short_green_maple_bees_0002_leaf_litter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_KEY = ModConfiguredFeatures.registerKey("tall_yellow_maple_bees_0002_leaf_litter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_KEY = ModConfiguredFeatures.registerKey("short_yellow_maple_bees_0002_leaf_litter");

    /* PLAINS */
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_GREEN_MAPLE_BEES_005_KEY = ModConfiguredFeatures.registerKey("tall_green_maple_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_GREEN_MAPLE_BEES_005_KEY = ModConfiguredFeatures.registerKey("short_green_maple_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_YELLOW_MAPLE_BEES_005_KEY = ModConfiguredFeatures.registerKey("tall_yellow_maple_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_YELLOW_MAPLE_BEES_005_KEY = ModConfiguredFeatures.registerKey("short_yellow_maple_bees_005");

    /* FLOWER FOREST */
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_YELLOW_MAPLE_BEES_002_KEY = ModConfiguredFeatures.registerKey("tall_yellow_maple_bees_002");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_YELLOW_MAPLE_BEES_002_KEY = ModConfiguredFeatures.registerKey("short_yellow_maple_bees_002");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_GREEN_MAPLE_BEES_002_KEY = ModConfiguredFeatures.registerKey("tall_green_maple_bees_002");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_GREEN_MAPLE_BEES_002_KEY = ModConfiguredFeatures.registerKey("short_green_maple_bees_002");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_RED_MAPLE_BEES_002_KEY = ModConfiguredFeatures.registerKey("tall_red_maple_bees_002");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_RED_MAPLE_BEES_002_KEY = ModConfiguredFeatures.registerKey("short_red_maple_bees_002");

    /* SNOWY / GROVE */
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_RED_MAPLE_KEY = ModConfiguredFeatures.registerKey("tall_red_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_RED_MAPLE_KEY = ModConfiguredFeatures.registerKey("short_red_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_YELLOW_MAPLE_KEY = ModConfiguredFeatures.registerKey("tall_yellow_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_YELLOW_MAPLE_KEY = ModConfiguredFeatures.registerKey("short_yellow_maple");

    /* WINDSWEPT HILLS */
    public static final RegistryKey<ConfiguredFeature<?, ?>> SHORT_GREEN_MAPLE_KEY = ModConfiguredFeatures.registerKey("short_green_maple");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_GREEN_MAPLE_KEY = ModConfiguredFeatures.registerKey("tall_green_maple");

    /* FALLEN MAPLE TREE */
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_MAPLE_TREE_KEY = ModConfiguredFeatures.registerKey("fallen_maple_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SNOWY_MAPLE_KEY = ModConfiguredFeatures.registerKey("fallen_snowy_maple_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        BlockStateProvider mapleLogs = BlockStateProvider.of(MapleWoodModBlocks.MOD_LOG);

        StraightTrunkPlacer tallTrunk = new StraightTrunkPlacer(7, 2, 0);
        TallMapleTreeFoliagePlacer tallFoliage =  new TallMapleTreeFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 6, 35);
        TwoLayersFeatureSize tallFeatures = new TwoLayersFeatureSize(2, 0, 2);

        StraightTrunkPlacer shortTrunk = new StraightTrunkPlacer(5, 1, 0);
        ShortMapleTreeFoliagePlacer shortFoliage =  new ShortMapleTreeFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4, 35);
        TwoLayersFeatureSize shortFeatures = new TwoLayersFeatureSize(1, 0, 1);

        PlaceOnGroundTreeDecorator placeOnGroundTreeDecorator = new PlaceOnGroundTreeDecorator(96, 4, 2, new WeightedBlockStateProvider(VegetationConfiguredFeatures.leafLitter(1, 3)));
        PlaceOnGroundTreeDecorator placeOnGroundTreeDecorator2 = new PlaceOnGroundTreeDecorator(150, 2, 2, new WeightedBlockStateProvider(VegetationConfiguredFeatures.leafLitter(1, 4)));
        BeehiveTreeDecorator beehiveTreeDecorator005 = new BeehiveTreeDecorator(0.05F);
        BeehiveTreeDecorator beehiveTreeDecorator0002 = new BeehiveTreeDecorator(0.002F);
        BeehiveTreeDecorator beehiveTreeDecorator002 = new BeehiveTreeDecorator(0.02F);

        BlockStateProvider redLeaves = BlockStateProvider.of(MapleWoodModBlocks.RED_MAPLE_LEAVES);
        BlockStateProvider yellowLeaves = BlockStateProvider.of(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES);
        BlockStateProvider greenLeaves = BlockStateProvider.of(MapleWoodModBlocks.MOD_LEAVES);
        BlockStateProvider multicoloredLeaves = new WeightedBlockStateProvider(Pool.<BlockState>builder().add(MapleWoodModBlocks.MOD_LEAVES.getDefaultState(), 2).add(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES.getDefaultState(), 1).add(MapleWoodModBlocks.RED_MAPLE_LEAVES.getDefaultState(), 1));

        TreeFeatureConfig.Builder tallGreenMapleTree = new TreeFeatureConfig.Builder(mapleLogs, tallTrunk, greenLeaves, tallFoliage, tallFeatures);
        TreeFeatureConfig.Builder tallYellowMapleTree = new TreeFeatureConfig.Builder(mapleLogs, tallTrunk, yellowLeaves, tallFoliage, tallFeatures);
        TreeFeatureConfig.Builder tallRedMapleTree = new TreeFeatureConfig.Builder(mapleLogs, tallTrunk, redLeaves , tallFoliage, tallFeatures);
        TreeFeatureConfig.Builder tallMulticoloredMapleTree = new TreeFeatureConfig.Builder(mapleLogs, tallTrunk, multicoloredLeaves, tallFoliage, tallFeatures);

        TreeFeatureConfig.Builder shortGreenMapleTree = new TreeFeatureConfig.Builder(mapleLogs, shortTrunk, greenLeaves, shortFoliage, shortFeatures);
        TreeFeatureConfig.Builder shortYellowMapleTree = new TreeFeatureConfig.Builder(mapleLogs, shortTrunk, yellowLeaves, shortFoliage, shortFeatures);
        TreeFeatureConfig.Builder shortRedMapleTree = new TreeFeatureConfig.Builder(mapleLogs, shortTrunk, redLeaves, shortFoliage, shortFeatures);
        TreeFeatureConfig.Builder shortMulticoloredMapleTree = new TreeFeatureConfig.Builder(mapleLogs, shortTrunk, multicoloredLeaves, shortFoliage, shortFeatures);

        /* SAPLING-GENERATED */
        ModConfiguredFeatures.register(context, TALL_MULTICOLORED_MAPLE_KEY, Feature.TREE, tallMulticoloredMapleTree.ignoreVines().build());
        ModConfiguredFeatures.register(context, SHORT_MULTICOLORED_MAPLE_KEY, Feature.TREE, shortMulticoloredMapleTree.ignoreVines().build());
        ModConfiguredFeatures.register(context, TALL_MULTICOLORED_MAPLE_BEES_005_KEY, Feature.TREE, tallMulticoloredMapleTree.ignoreVines().decorators(List.of(beehiveTreeDecorator005)).build());
        ModConfiguredFeatures.register(context, SHORT_MULTICOLORED_MAPLE_BEES_005_KEY, Feature.TREE, shortMulticoloredMapleTree.ignoreVines().decorators(List.of(beehiveTreeDecorator005)).build());

        /* FOREST / WATER */
        ModConfiguredFeatures.register(context, TALL_GREEN_MAPLE_BEES_0002_LEAF_LITTER_KEY, Feature.TREE, tallGreenMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator0002, placeOnGroundTreeDecorator, placeOnGroundTreeDecorator2)).build());
        ModConfiguredFeatures.register(context, SHORT_GREEN_MAPLE_BEES_0002_LEAF_LITTER_KEY, Feature.TREE, shortGreenMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator0002, placeOnGroundTreeDecorator, placeOnGroundTreeDecorator2)).build());
        ModConfiguredFeatures.register(context, TALL_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_KEY, Feature.TREE, tallYellowMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator0002, placeOnGroundTreeDecorator, placeOnGroundTreeDecorator2)).build());
        ModConfiguredFeatures.register(context, SHORT_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_KEY, Feature.TREE, shortYellowMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator0002, placeOnGroundTreeDecorator, placeOnGroundTreeDecorator2)).build());

        /* PLAINS */
        ModConfiguredFeatures.register(context, TALL_GREEN_MAPLE_BEES_005_KEY, Feature.TREE, tallGreenMapleTree.ignoreVines().decorators(List.of(beehiveTreeDecorator005)).build());
        ModConfiguredFeatures.register(context, SHORT_GREEN_MAPLE_BEES_005_KEY, Feature.TREE, shortGreenMapleTree.ignoreVines().decorators(List.of(beehiveTreeDecorator005)).build());
        ModConfiguredFeatures.register(context, TALL_YELLOW_MAPLE_BEES_005_KEY, Feature.TREE, tallYellowMapleTree.ignoreVines().decorators(List.of(beehiveTreeDecorator005)).build());
        ModConfiguredFeatures.register(context, SHORT_YELLOW_MAPLE_BEES_005_KEY, Feature.TREE, shortYellowMapleTree.ignoreVines().decorators(List.of(beehiveTreeDecorator005)).build());

        /* FLOWER FOREST */
        ModConfiguredFeatures.register(context, TALL_YELLOW_MAPLE_BEES_002_KEY, Feature.TREE, tallYellowMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator002)).build());
        ModConfiguredFeatures.register(context, SHORT_YELLOW_MAPLE_BEES_002_KEY, Feature.TREE, shortYellowMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator002)).build());
        ModConfiguredFeatures.register(context, TALL_GREEN_MAPLE_BEES_002_KEY, Feature.TREE, tallGreenMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator002)).build());
        ModConfiguredFeatures.register(context, SHORT_GREEN_MAPLE_BEES_002_KEY, Feature.TREE, shortGreenMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator002)).build());
        ModConfiguredFeatures.register(context, TALL_RED_MAPLE_BEES_002_KEY, Feature.TREE, tallRedMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator002)).build());
        ModConfiguredFeatures.register(context, SHORT_RED_MAPLE_BEES_002_KEY, Feature.TREE, shortRedMapleTree.ignoreVines().decorators(ImmutableList.of(beehiveTreeDecorator002)).build());

        /* SNOWY / GROVE */
        ModConfiguredFeatures.register(context, TALL_RED_MAPLE_KEY, Feature.TREE, tallRedMapleTree.ignoreVines().build());
        ModConfiguredFeatures.register(context, SHORT_RED_MAPLE_KEY, Feature.TREE, shortRedMapleTree.ignoreVines().build());
        ModConfiguredFeatures.register(context, TALL_YELLOW_MAPLE_KEY, Feature.TREE, tallYellowMapleTree.ignoreVines().build());
        ModConfiguredFeatures.register(context, SHORT_YELLOW_MAPLE_KEY, Feature.TREE, shortYellowMapleTree.ignoreVines().build());

        /* WINDSWEPT HILLS */
        ModConfiguredFeatures.register(context, SHORT_GREEN_MAPLE_KEY, Feature.TREE, shortGreenMapleTree.ignoreVines().build());
        ModConfiguredFeatures.register(context, TALL_GREEN_MAPLE_KEY, Feature.TREE, tallGreenMapleTree.ignoreVines().build());

        /* FALLEN MAPLE TREE */
        ModConfiguredFeatures.register(context, FALLEN_MAPLE_TREE_KEY, Feature.FALLEN_TREE,
                new FallenTreeFeatureConfig.Builder(mapleLogs, UniformIntProvider.create(6, 8))
                        .logDecorators(
                                ImmutableList.of(
                                        new AttachedToLogsTreeDecorator(
                                                0.1F,
                                                new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 2).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)),
                                                List.of(Direction.UP)
                                        )
                                )
                        ).stumpDecorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());
        ModConfiguredFeatures.register(context, FALLEN_SNOWY_MAPLE_KEY, Feature.FALLEN_TREE,
                new FallenTreeFeatureConfig.Builder(mapleLogs, UniformIntProvider.create(6, 8))
                .logDecorators(
                        ImmutableList.of(
                                new AttachedToLogsTreeDecorator(
                                        0.1F,
                                        new WeightedBlockStateProvider(Pool.<BlockState>builder()
                                                .add(Blocks.SNOW.getDefaultState(), 5)
                                                .add(Blocks.RED_MUSHROOM.getDefaultState(), 1)
                                                .add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)
                                        ),
                                        List.of(Direction.UP)
                                )
                        )
                ).build());
    }

}
