package bluesteel42.combinedworldgen.wood.willow.tree;

import bluesteel42.combinedworldgen.wood.willow.block.WillowWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class WillowWoodTreePlacedFeatures {
    public static final RegistryKey<PlacedFeature> WILLOW_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("willow_tree");
    public static final RegistryKey<PlacedFeature> WILLOW_TREE_LEAF_LITTER_PLACED_KEY = ModPlacedFeatures.registerKey("willow_tree_leaf_litter");
    public static final RegistryKey<PlacedFeature> WEEPING_WILLOW_PLACED_KEY = ModPlacedFeatures.registerKey("weeping_willow");
    public static final RegistryKey<PlacedFeature> HUGE_RED_MUSHROOM_PLACED_KEY = ModPlacedFeatures.registerKey("swamp_huge_red_mushroom");
    public static final RegistryKey<PlacedFeature> HUGE_BROWN_MUSHROOM_PLACED_KEY = ModPlacedFeatures.registerKey("swamp_huge_brown_mushroom");
    public static final RegistryKey<PlacedFeature> FALLEN_WILLOW_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_willow_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(context, WILLOW_TREE_PLACED_KEY, configuredFeatures.getOrThrow(WillowWoodTreeConfiguredFeatures.WILLOW_TREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(WillowWoodModBlocks.MOD_SAPLING))
        );
        ModPlacedFeatures.register(context, WILLOW_TREE_LEAF_LITTER_PLACED_KEY, configuredFeatures.getOrThrow(WillowWoodTreeConfiguredFeatures.WILLOW_TREE_LEAF_LITTER_KEY),
                List.of(PlacedFeatures.wouldSurvive(WillowWoodModBlocks.MOD_SAPLING))
        );
        ModPlacedFeatures.register(context, WEEPING_WILLOW_PLACED_KEY, configuredFeatures.getOrThrow(WillowWoodTreeConfiguredFeatures.WEEPING_WILLOW_KEY),
                List.of(PlacedFeatures.wouldSurvive(WillowWoodModBlocks.MOD_SAPLING))
        );
        ModPlacedFeatures.register(context, HUGE_RED_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM),
                List.of(PlacedFeatures.wouldSurvive(WillowWoodModBlocks.MOD_SAPLING))
        );
        ModPlacedFeatures.register(context, HUGE_BROWN_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM),
                List.of(PlacedFeatures.wouldSurvive(WillowWoodModBlocks.MOD_SAPLING))
        );
        ModPlacedFeatures.register(context, FALLEN_WILLOW_TREE_PLACED_KEY, configuredFeatures.getOrThrow(WillowWoodTreeConfiguredFeatures.FALLEN_WILLOW_TREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(WillowWoodModBlocks.MOD_SAPLING))
        );
    }
}
