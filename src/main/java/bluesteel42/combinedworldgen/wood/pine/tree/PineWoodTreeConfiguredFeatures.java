package bluesteel42.combinedworldgen.wood.pine.tree;

import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModConfiguredFeatures;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.PlaceOnGroundTreeDecorator;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class PineWoodTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOWY_PINE_KEY = ModConfiguredFeatures.registerKey("snowy_pine");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOWY_PINE_BEES_005_KEY = ModConfiguredFeatures.registerKey("snowy_pine_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_SNOWY_PINE_HIGH_KEY = ModConfiguredFeatures.registerKey("mega_snowy_pine_high");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_SNOWY_PINE_LOW_KEY = ModConfiguredFeatures.registerKey("mega_snowy_pine_low");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOWY_SPRUCE_KEY = ModConfiguredFeatures.registerKey("snowy_spruce");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_SNOWY_SPRUCE_HIGH_KEY = ModConfiguredFeatures.registerKey("mega_snowy_spruce_high");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_SNOWY_SPRUCE_LOW_KEY = ModConfiguredFeatures.registerKey("mega_snowy_spruce_low");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINE_BEES_005_KEY = ModConfiguredFeatures.registerKey("pine_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_PINE_HIGH_KEY = ModConfiguredFeatures.registerKey("mega_pine_high");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_PINE_LOW_KEY = ModConfiguredFeatures.registerKey("mega_pine_low");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_PINE_TREE_KEY = ModConfiguredFeatures.registerKey("fallen_pine_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SNOWY_PINE_KEY = ModConfiguredFeatures.registerKey("fallen_snowy_pine_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SNOWY_SPRUCE_KEY = ModConfiguredFeatures.registerKey("fallen_snowy_spruce_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_SNOWY_TAIGA_KEY = ModConfiguredFeatures.registerKey("trees_snowy_taiga");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        ModConfiguredFeatures.register(context, PINE_BEES_005_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PineWoodModBlocks.MOD_LOG),
                new StraightTrunkPlacer(6, 4, 0),

                BlockStateProvider.of(PineWoodModBlocks.MOD_LEAVES),
                new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(3, 4)),

                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines().decorators(List.of(new BeehiveTreeDecorator(0.05F))).build());

        ModConfiguredFeatures.register(context, MEGA_PINE_HIGH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PineWoodModBlocks.MOD_LOG),
                new GiantTrunkPlacer(13, 2, 14),

                BlockStateProvider.of(PineWoodModBlocks.MOD_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(3, 6)),

                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());

        ModConfiguredFeatures.register(context, MEGA_PINE_LOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PineWoodModBlocks.MOD_LOG),
                new GiantTrunkPlacer(13, 2, 14),

                BlockStateProvider.of(PineWoodModBlocks.MOD_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(5, 8)),

                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).build());


        PlaceOnGroundTreeDecorator placeOnGroundTreeDecorator = new PlaceOnGroundTreeDecorator(
                512, 4, 2, BlockStateProvider.of(Blocks.SNOW)
        );

        ModConfiguredFeatures.register(context, SNOWY_PINE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PineWoodModBlocks.MOD_LOG),
                new StraightTrunkPlacer(6, 4, 0),
                BlockStateProvider.of(PineWoodModBlocks.SNOWY_PINE_LEAVES),
                new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(3, 4)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines().decorators(List.of(placeOnGroundTreeDecorator)).build());

        ModConfiguredFeatures.register(context, SNOWY_PINE_BEES_005_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PineWoodModBlocks.MOD_LOG),
                new StraightTrunkPlacer(6, 4, 0),
                BlockStateProvider.of(PineWoodModBlocks.SNOWY_PINE_LEAVES),
                new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(3, 4)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines().decorators(List.of(new BeehiveTreeDecorator(0.05F), placeOnGroundTreeDecorator)).build());

        ModConfiguredFeatures.register(context, MEGA_SNOWY_PINE_HIGH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PineWoodModBlocks.MOD_LOG),
                new GiantTrunkPlacer(13, 2, 14),
                BlockStateProvider.of(PineWoodModBlocks.SNOWY_PINE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(3, 6)),
                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)), placeOnGroundTreeDecorator)).build());

        ModConfiguredFeatures.register(context, MEGA_SNOWY_PINE_LOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PineWoodModBlocks.MOD_LOG),
                new GiantTrunkPlacer(13, 2, 14),
                BlockStateProvider.of(PineWoodModBlocks.SNOWY_PINE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(5, 8)),
                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)), placeOnGroundTreeDecorator)).build());

        ModConfiguredFeatures.register(context, FALLEN_PINE_TREE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(PineWoodModBlocks.MOD_LOG), UniformIntProvider.create(6, 10))
                .logDecorators(
                        ImmutableList.of(
                                new AttachedToLogsTreeDecorator(
                                        0.1F,
                                        new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 2).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)),
                                        List.of(Direction.UP)
                                )
                        )
                ).build());

        ModConfiguredFeatures.register(context, FALLEN_SNOWY_PINE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(PineWoodModBlocks.MOD_LOG), UniformIntProvider.create(6, 10))
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

        ModConfiguredFeatures.register(context, FALLEN_SNOWY_SPRUCE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(PineWoodModBlocks.MOD_LOG), UniformIntProvider.create(6, 10))
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

        ModConfiguredFeatures.register(context, SNOWY_SPRUCE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_LOG),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.of(PineWoodModBlocks.SNOWY_SPRUCE_LEAVES),
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines().decorators(List.of(placeOnGroundTreeDecorator)).build());

        ModConfiguredFeatures.register(context, MEGA_SNOWY_SPRUCE_HIGH_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_LOG),
                new GiantTrunkPlacer(13, 2, 14),
                BlockStateProvider.of(PineWoodModBlocks.SNOWY_PINE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(12, 15)),
                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)), placeOnGroundTreeDecorator)).build());

        ModConfiguredFeatures.register(context, MEGA_SNOWY_SPRUCE_LOW_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.SPRUCE_LOG),
                new GiantTrunkPlacer(13, 2, 14),
                BlockStateProvider.of(PineWoodModBlocks.SNOWY_PINE_LEAVES),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(14, 17)),
                new TwoLayersFeatureSize(1, 1, 2)
        ).decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)), placeOnGroundTreeDecorator)).build());

        ModConfiguredFeatures.register(context, TREES_SNOWY_TAIGA_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(PineWoodTreePlacedFeatures.SNOWY_PINE_PLACED_KEY), 0.33333334F),
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(PineWoodTreePlacedFeatures.FALLEN_SNOWY_SPRUCE_PLACED_KEY), 0.00625F),
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(PineWoodTreePlacedFeatures.FALLEN_SNOWY_PINE_PLACED_KEY), 0.00625F)
        ), context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(PineWoodTreePlacedFeatures.SNOWY_SPRUCE_PLACED_KEY)
        ));

    }

}
