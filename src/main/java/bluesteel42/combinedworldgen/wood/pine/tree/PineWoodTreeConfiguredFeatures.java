package bluesteel42.combinedworldgen.wood.pine.tree;

import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModConfiguredFeatures;
import com.google.common.collect.ImmutableList;
import com.sun.source.tree.Tree;
import net.minecraft.block.Block;
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
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.MegaPineFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.*;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;

import java.util.List;

public class PineWoodTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PINE_BEES_005_KEY = ModConfiguredFeatures.registerKey("pine_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINE_BEES_0002_KEY = ModConfiguredFeatures.registerKey("pine_bees_0002");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_PINE_HIGH_KEY = ModConfiguredFeatures.registerKey("mega_pine_high");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_PINE_LOW_KEY = ModConfiguredFeatures.registerKey("mega_pine_low");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOWY_PINE_KEY = ModConfiguredFeatures.registerKey("snowy_pine");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOWY_PINE_BEES_005_KEY = ModConfiguredFeatures.registerKey("snowy_pine_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_SNOWY_PINE_HIGH_KEY = ModConfiguredFeatures.registerKey("mega_snowy_pine_high");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_SNOWY_PINE_LOW_KEY = ModConfiguredFeatures.registerKey("mega_snowy_pine_low");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOWY_SPRUCE_KEY = ModConfiguredFeatures.registerKey("snowy_spruce");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_SNOWY_SPRUCE_HIGH_KEY = ModConfiguredFeatures.registerKey("mega_snowy_spruce_high");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MEGA_SNOWY_SPRUCE_LOW_KEY = ModConfiguredFeatures.registerKey("mega_snowy_spruce_low");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_PINE_TREE_KEY = ModConfiguredFeatures.registerKey("fallen_pine_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SNOWY_PINE_KEY = ModConfiguredFeatures.registerKey("fallen_snowy_pine_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SNOWY_SPRUCE_KEY = ModConfiguredFeatures.registerKey("fallen_snowy_spruce_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_SNOWY_TAIGA_KEY = ModConfiguredFeatures.registerKey("trees_snowy_taiga");

    private static final PlaceOnGroundTreeDecorator snowTreeDecorator = new PlaceOnGroundTreeDecorator(
            512, 4, 2, BlockStateProvider.of(Blocks.SNOW)
    );
    private static final AlterGroundTreeDecorator podzolTreeDecorator = new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL));

    private static TreeFeatureConfig.Builder smallTree(Block log, TrunkPlacer trunkPlacer, Block leaves, FoliagePlacer foliagePlacer) {
        return new TreeFeatureConfig.Builder(
                BlockStateProvider.of(log),
                trunkPlacer,
                BlockStateProvider.of(leaves),
                foliagePlacer,
                new TwoLayersFeatureSize(2, 0, 2)
        );
    }
    private static List<TreeDecorator> smallDecorators(boolean snowy, float bees) {
        if (bees > 0 && snowy) {
            return List.of(new BeehiveTreeDecorator(bees), snowTreeDecorator);
        }
        if (bees > 0) {
            return List.of(new BeehiveTreeDecorator(bees));
        }
        if (snowy) {
            return List.of(snowTreeDecorator);
        }
        return List.of();
    }
    private static TreeFeatureConfig.Builder pine(boolean snowy, float bees) {
        return smallTree(
                PineWoodModBlocks.MOD_LOG,
                new StraightTrunkPlacer(6, 4, 0),
                snowy ? PineWoodModBlocks.SNOWY_PINE_LEAVES : PineWoodModBlocks.MOD_LEAVES,
                new PineFoliagePlacer(ConstantIntProvider.create(1), ConstantIntProvider.create(1), UniformIntProvider.create(3, 4))
        ).ignoreVines().decorators(smallDecorators(snowy, bees));
    }
    private static TreeFeatureConfig.Builder spruce(boolean snowy, float bees) {
        return smallTree(
                Blocks.SPRUCE_LOG,
                new StraightTrunkPlacer(5, 2, 1),
                snowy ? PineWoodModBlocks.SNOWY_SPRUCE_LEAVES : PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES,
                new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(0, 2), UniformIntProvider.create(1, 2))
        ).ignoreVines().decorators(smallDecorators(snowy, bees));
    }
    private static TreeFeatureConfig.Builder megaTree(Block log, Block leaves, int foliageMin, int foliageMax) {
        return new TreeFeatureConfig.Builder(
                BlockStateProvider.of(log),
                new GiantTrunkPlacer(13, 2, 14),
                BlockStateProvider.of(leaves),
                new MegaPineFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), UniformIntProvider.create(foliageMin, foliageMax)),
                new TwoLayersFeatureSize(1, 1, 2)
        );
    }
    private static List<TreeDecorator> megaDecorators(boolean snowy) {
        if (snowy) {
            return ImmutableList.of(podzolTreeDecorator, snowTreeDecorator);
        } else {
            return ImmutableList.of(podzolTreeDecorator);
        }
    }
    private static TreeFeatureConfig.Builder megaPine(boolean snowy, boolean high) {
        return megaTree(
                PineWoodModBlocks.MOD_LOG,
                snowy ? PineWoodModBlocks.SNOWY_PINE_LEAVES : PineWoodModBlocks.MOD_LEAVES,
                high ? 3 : 5,
                high ? 6 : 8
        ).decorators(megaDecorators(snowy));
    }
    private static TreeFeatureConfig.Builder megaSpruce(boolean snowy, boolean high) {
        return megaTree(
                Blocks.SPRUCE_LOG,
                snowy ? PineWoodModBlocks.SNOWY_SPRUCE_LEAVES : PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES,
                high ? 12 : 14,
                high ? 15 : 17
        ).decorators(megaDecorators(snowy));
    }
    private static FallenTreeFeatureConfig.Builder fallen(Block log, boolean snowy) {
        return new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(log), UniformIntProvider.create(6, 10))
                .logDecorators(
                        ImmutableList.of(
                                snowy ?
                                    new AttachedToLogsTreeDecorator(
                                            0.1F,
                                            new WeightedBlockStateProvider(Pool.<BlockState>builder()
                                                    .add(Blocks.SNOW.getDefaultState(), 5)
                                                    .add(Blocks.RED_MUSHROOM.getDefaultState(), 1)
                                                    .add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)
                                            ),
                                            List.of(Direction.UP)
                                    )
                                        :
                                    new AttachedToLogsTreeDecorator(
                                            0.1F,
                                            new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 2).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)),
                                            List.of(Direction.UP)
                                    )
                        )
                );
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        ModConfiguredFeatures.register(context, PINE_BEES_005_KEY, Feature.TREE, pine(false, 0.05F).build());
        ModConfiguredFeatures.register(context, PINE_BEES_0002_KEY, Feature.TREE, pine(false, 0.002F).build());

        ModConfiguredFeatures.register(context, MEGA_PINE_HIGH_KEY, Feature.TREE, megaPine(false, true).build());
        ModConfiguredFeatures.register(context, MEGA_PINE_LOW_KEY, Feature.TREE, megaPine(false, false).build());

        ModConfiguredFeatures.register(context, SNOWY_PINE_KEY, Feature.TREE, pine(true, 0).build());
        ModConfiguredFeatures.register(context, SNOWY_PINE_BEES_005_KEY, Feature.TREE, pine(true, 0.05F).build());
        ModConfiguredFeatures.register(context, MEGA_SNOWY_PINE_HIGH_KEY, Feature.TREE, megaPine(true, true).build());
        ModConfiguredFeatures.register(context, MEGA_SNOWY_PINE_LOW_KEY, Feature.TREE, megaPine(true, false).build());

        ModConfiguredFeatures.register(context, SNOWY_SPRUCE_KEY, Feature.TREE, spruce(true, 0).build());
        ModConfiguredFeatures.register(context, MEGA_SNOWY_SPRUCE_HIGH_KEY, Feature.TREE, megaSpruce(true, true).build());
        ModConfiguredFeatures.register(context, MEGA_SNOWY_SPRUCE_LOW_KEY, Feature.TREE, megaSpruce(true, false).build());

        ModConfiguredFeatures.register(context, FALLEN_PINE_TREE_KEY, Feature.FALLEN_TREE, fallen(PineWoodModBlocks.MOD_LOG, false).build());
        ModConfiguredFeatures.register(context, FALLEN_SNOWY_PINE_KEY, Feature.FALLEN_TREE, fallen(PineWoodModBlocks.MOD_LOG, true).build());
        ModConfiguredFeatures.register(context, FALLEN_SNOWY_SPRUCE_KEY, Feature.FALLEN_TREE, fallen(Blocks.SPRUCE_LOG, true).build());

        ModConfiguredFeatures.register(context, TREES_SNOWY_TAIGA_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(
                List.of(
                    new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(PineWoodTreePlacedFeatures.SNOWY_PINE_PLACED_KEY), 0.33333334F),
                    new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(PineWoodTreePlacedFeatures.FALLEN_SNOWY_SPRUCE_PLACED_KEY), 0.00625F),
                    new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(PineWoodTreePlacedFeatures.FALLEN_SNOWY_PINE_PLACED_KEY), 0.00625F)
                ), context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(PineWoodTreePlacedFeatures.SNOWY_SPRUCE_PLACED_KEY)
        ));

    }

}
