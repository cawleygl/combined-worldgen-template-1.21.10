package bluesteel42.combinedworldgen.wood.cacao.tree;

import bluesteel42.combinedworldgen.wood.cacao.block.CacaoWoodModBlocks;
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
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.FallenTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class CacaoWoodTreeConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CACAO_TREE_KEY = ModConfiguredFeatures.registerKey("cacao_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_CACAO_TREE_KEY = ModConfiguredFeatures.registerKey("fallen_cacao_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        ModConfiguredFeatures.register(context, CACAO_TREE_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(CacaoWoodModBlocks.MOD_LOG),
                        new StraightTrunkPlacer(5, 2, 0),
                        BlockStateProvider.of(CacaoWoodModBlocks.MOD_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(ImmutableList.of(new CocoaTreeDecorator(0.2F), TrunkVineTreeDecorator.INSTANCE, new LeavesVineTreeDecorator(0.25F))).ignoreVines().build()
        );

        ModConfiguredFeatures.register(context, FALLEN_CACAO_TREE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(CacaoWoodModBlocks.MOD_LOG), UniformIntProvider.create(4, 6))
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
