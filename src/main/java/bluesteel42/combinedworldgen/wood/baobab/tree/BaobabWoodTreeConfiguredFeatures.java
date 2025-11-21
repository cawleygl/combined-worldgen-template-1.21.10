package bluesteel42.combinedworldgen.wood.baobab.tree;

import bluesteel42.combinedworldgen.wood.baobab.block.BaobabWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModConfiguredFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;

import java.util.OptionalInt;

public class BaobabWoodTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> BAOBAB_TREE_KEY = ModConfiguredFeatures.registerKey("baobab_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        ModConfiguredFeatures.register(context, BAOBAB_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(BaobabWoodModBlocks.MOD_LOG),
                new DarkOakTrunkPlacer(8, 2, 4),
                BlockStateProvider.of(BaobabWoodModBlocks.MOD_LEAVES),
                new AcaciaFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()
                )).build());
    }

}
