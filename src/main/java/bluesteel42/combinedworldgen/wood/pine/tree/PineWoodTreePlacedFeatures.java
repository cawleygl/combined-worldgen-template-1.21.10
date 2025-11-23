package bluesteel42.combinedworldgen.wood.pine.tree;

import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModPlacedFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.EnvironmentScanPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class PineWoodTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> PINE_BEES_005_PLACED_KEY = ModPlacedFeatures.registerKey("pine_bees_005");
    public static final RegistryKey<PlacedFeature> PINE_BEES_0002_PLACED_KEY = ModPlacedFeatures.registerKey("pine_bees_0002");
    public static final RegistryKey<PlacedFeature> MEGA_PINE_HIGH_PLACED_KEY = ModPlacedFeatures.registerKey("mega_pine_high");
    public static final RegistryKey<PlacedFeature> MEGA_PINE_LOW_PLACED_KEY = ModPlacedFeatures.registerKey("mega_pine_low");
    public static final RegistryKey<PlacedFeature> FALLEN_PINE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_pine_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_SNOWY_PINE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_snowy_pine_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_SNOWY_SPRUCE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_snowy_spruce_tree");
    public static final RegistryKey<PlacedFeature> SNOWY_PINE_PLACED_KEY = ModPlacedFeatures.registerKey("snowy_pine");
    public static final RegistryKey<PlacedFeature> SNOWY_SPRUCE_PLACED_KEY = ModPlacedFeatures.registerKey("snowy_spruce");
    public static final RegistryKey<PlacedFeature> SNOWY_SPRUCE_ON_SNOW_PLACED_KEY = ModPlacedFeatures.registerKey("snowy_spruce_on_snow");
    public static final RegistryKey<PlacedFeature> TREES_SNOWY_TAIGA_PLACED_KEY = ModPlacedFeatures.registerKey("trees_snowy_taiga");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(context, PINE_BEES_005_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.PINE_BEES_005_KEY),
                PlacedFeatures.wouldSurvive(PineWoodModBlocks.MOD_SAPLING)
        );
        ModPlacedFeatures.register(context, PINE_BEES_0002_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.PINE_BEES_0002_KEY),
                PlacedFeatures.wouldSurvive(PineWoodModBlocks.MOD_SAPLING)
        );
        ModPlacedFeatures.register(context, MEGA_PINE_HIGH_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.MEGA_PINE_HIGH_KEY),
                PlacedFeatures.wouldSurvive(PineWoodModBlocks.MOD_SAPLING)
        );
        ModPlacedFeatures.register(context, MEGA_PINE_LOW_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.MEGA_PINE_LOW_KEY),
                PlacedFeatures.wouldSurvive(PineWoodModBlocks.MOD_SAPLING)
        );
        ModPlacedFeatures.register(context, FALLEN_PINE_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.FALLEN_PINE_TREE_KEY),
                PlacedFeatures.wouldSurvive(PineWoodModBlocks.MOD_SAPLING)
        );
        ModPlacedFeatures.register(context, FALLEN_SNOWY_PINE_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.FALLEN_SNOWY_PINE_KEY),
                PlacedFeatures.wouldSurvive(PineWoodModBlocks.SNOWY_PINE_SAPLING)
        );
        ModPlacedFeatures.register(context, FALLEN_SNOWY_SPRUCE_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.FALLEN_SNOWY_SPRUCE_KEY),
                PlacedFeatures.wouldSurvive(PineWoodModBlocks.SNOWY_SPRUCE_SAPLING)
        );
        ModPlacedFeatures.register(context, SNOWY_PINE_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.SNOWY_PINE_KEY),
                PlacedFeatures.wouldSurvive(PineWoodModBlocks.SNOWY_PINE_SAPLING)
        );
        ModPlacedFeatures.register(context, SNOWY_SPRUCE_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.SNOWY_SPRUCE_KEY),
                PlacedFeatures.wouldSurvive(PineWoodModBlocks.SNOWY_SPRUCE_SAPLING)
        );
        ModPlacedFeatures.register(context, TREES_SNOWY_TAIGA_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.TREES_SNOWY_TAIGA_KEY),
                VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(10, 0.1F, 1))
        );

        BlockPredicate blockPredicate = BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW);
        List<PlacementModifier> snowPredicates = List.of(
                EnvironmentScanPlacementModifier.of(Direction.UP, BlockPredicate.not(BlockPredicate.matchingBlocks(Blocks.POWDER_SNOW)), 8),
                BlockFilterPlacementModifier.of(blockPredicate)
        );
        ModPlacedFeatures.register(context, SNOWY_SPRUCE_ON_SNOW_PLACED_KEY, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.SNOWY_SPRUCE_KEY), snowPredicates);
    }
}
