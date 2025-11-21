package bluesteel42.combinedworldgen.wood.citrus.tree;

import bluesteel42.combinedworldgen.wood.citrus.block.CitrusWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.*;

public class CitrusWoodTreePlacedFeatures {
    public static final RegistryKey<PlacedFeature> ORANGE_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("orange_tree");
    public static final RegistryKey<PlacedFeature> ORANGE_BUSH_PLACED_KEY = ModPlacedFeatures.registerKey("orange_bush");
    public static final RegistryKey<PlacedFeature> FALLEN_ORANGE_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_orange_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(context, ORANGE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(CitrusWoodTreeConfiguredFeatures.ORANGE_TREE),
                PlacedFeatures.wouldSurvive(CitrusWoodModBlocks.MOD_SAPLING)
        );
        ModPlacedFeatures.register(context, ORANGE_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(CitrusWoodTreeConfiguredFeatures.ORANGE_BUSH),
                PlacedFeatures.wouldSurvive(CitrusWoodModBlocks.MOD_SAPLING)
        );
        ModPlacedFeatures.register(context, FALLEN_ORANGE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(CitrusWoodTreeConfiguredFeatures.FALLEN_ORANGE_TREE),
                PlacedFeatures.wouldSurvive(CitrusWoodModBlocks.MOD_SAPLING)
        );
    }

}
