package bluesteel42.combinedworldgen.wood.petrified.tree;

import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModConfiguredFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class PetrifiedWoodTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE_KEY = ModConfiguredFeatures.registerKey("petrified_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_PETRIFIED_TREE_KEY = ModConfiguredFeatures.registerKey("fallen_petrified_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE_ORE_X_KEY = ModConfiguredFeatures.registerKey("petrified_tree_ore_x");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PETRIFIED_TREE_ORE_Z_KEY = ModConfiguredFeatures.registerKey("petrified_tree_ore_z");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        ModConfiguredFeatures.register(context, PETRIFIED_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(PetrifiedWoodModBlocks.MOD_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.of(Blocks.AIR),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build());

        ModConfiguredFeatures.register(context, FALLEN_PETRIFIED_TREE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(PetrifiedWoodModBlocks.MOD_LOG), UniformIntProvider.create(4, 7)).build());

        ModConfiguredFeatures.register(context, PETRIFIED_TREE_ORE_X_KEY, Feature.ORE, new OreFeatureConfig(
                        new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), PetrifiedWoodModBlocks.MOD_LOG.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.X), 5)
        );
        ModConfiguredFeatures.register(context, PETRIFIED_TREE_ORE_Z_KEY, Feature.ORE, new OreFeatureConfig(
                        new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), PetrifiedWoodModBlocks.MOD_LOG.getDefaultState().with(PillarBlock.AXIS, Direction.Axis.Z), 5)
        );

    }

}
