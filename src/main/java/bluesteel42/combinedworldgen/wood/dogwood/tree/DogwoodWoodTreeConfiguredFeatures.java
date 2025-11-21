package bluesteel42.combinedworldgen.wood.dogwood.tree;

import bluesteel42.combinedworldgen.wood.dogwood.block.DogwoodWoodModBlocks;
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
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class DogwoodWoodTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> DOGWOOD_TREE_KEY = ModConfiguredFeatures.registerKey("dogwood_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_DOGWOOD_TREE_KEY = ModConfiguredFeatures.registerKey("fallen_dogwood_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        ModConfiguredFeatures.register(context, DOGWOOD_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(DogwoodWoodModBlocks.MOD_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.of(DogwoodWoodModBlocks.MOD_LEAVES),
                new LargeOakFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(2, 0, 2)
        ).build());

        ModConfiguredFeatures.register(context, FALLEN_DOGWOOD_TREE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(DogwoodWoodModBlocks.MOD_LOG), UniformIntProvider.create(4, 6))
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
