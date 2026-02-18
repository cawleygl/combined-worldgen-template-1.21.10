package bluesteel42.combinedworldgen.wood.kapok.tree;

import bluesteel42.combinedworldgen.wood.kapok.block.KapokWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModConfiguredFeatures;
import com.google.common.collect.ImmutableList;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class KapokWoodTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> KAPOK_TREE_KEY = ModConfiguredFeatures.registerKey("kapok_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        ModConfiguredFeatures.register(context, KAPOK_TREE_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(KapokWoodModBlocks.MOD_LOG),
                        new StraightTrunkPlacer(6, 4, 2),
                        BlockStateProvider.of(KapokWoodModBlocks.MOD_LEAVES),
                        new AcaciaFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1)),
                        new TwoLayersFeatureSize(2, 0, 2)
                ).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25F))).ignoreVines().build()
        );

    }
}
