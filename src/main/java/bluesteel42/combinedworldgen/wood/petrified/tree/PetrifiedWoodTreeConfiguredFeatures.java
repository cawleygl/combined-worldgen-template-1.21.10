package bluesteel42.combinedworldgen.wood.petrified.tree;

import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class PetrifiedWoodTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE_KEY = ModConfiguredFeatures.registerKey("petrified_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_PETRIFIED_TREE_KEY = ModConfiguredFeatures.registerKey("fallen_petrified_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE_ORE_X_KEY = ModConfiguredFeatures.registerKey("petrified_tree_x_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE_ORE_Y_KEY = ModConfiguredFeatures.registerKey("petrified_tree_y_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE_ORE_Z_KEY = ModConfiguredFeatures.registerKey("petrified_tree_z_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        ModConfiguredFeatures.register(context, PETRIFIED_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PetrifiedWoodModBlocks.MOD_LOG),
                new StraightTrunkPlacer(2, 1, 0),
                BlockStateProvider.of(Blocks.AIR),
                new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        ModConfiguredFeatures.register(context, FALLEN_PETRIFIED_TREE_KEY, Feature.FALLEN_TREE,
                new FallenTreeFeatureConfig.Builder(
                        new WeightedBlockStateProvider(Pool.<BlockState>builder().add(PetrifiedWoodModBlocks.MOD_LOG.getDefaultState(), 2).add(Blocks.AIR.getDefaultState(), 1)),
                        UniformIntProvider.create(3, 5)
                ).build()
        );

        ModConfiguredFeatures.register(context, PETRIFIED_TREE_ORE_X_KEY, Feature.ORE, new OreFeatureConfig(
                        new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD),
                PetrifiedWoodModBlocks.MOD_LOG.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X),
                5, 1.0F)
        );
        ModConfiguredFeatures.register(context, PETRIFIED_TREE_ORE_Y_KEY, Feature.ORE, new OreFeatureConfig(
                        new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD),
                PetrifiedWoodModBlocks.MOD_LOG.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Y),
                5, 1.0F)
        );
        ModConfiguredFeatures.register(context, PETRIFIED_TREE_ORE_Z_KEY, Feature.ORE, new OreFeatureConfig(
                        new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD),
                PetrifiedWoodModBlocks.MOD_LOG.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z),
                5, 1.0F)
        );

    }

}
