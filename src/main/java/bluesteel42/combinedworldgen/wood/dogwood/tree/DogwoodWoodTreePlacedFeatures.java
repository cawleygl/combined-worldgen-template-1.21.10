package bluesteel42.combinedworldgen.wood.dogwood.tree;

import bluesteel42.combinedworldgen.wood.dogwood.block.DogwoodWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.List;

public class DogwoodWoodTreePlacedFeatures {
    public static final RegistryKey<PlacedFeature> DOGWOOD_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("dogwood_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_DOGWOOD_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_dogwood_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(context, DOGWOOD_TREE_PLACED_KEY, configuredFeatures.getOrThrow(DogwoodWoodTreeConfiguredFeatures.DOGWOOD_TREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(DogwoodWoodModBlocks.MOD_SAPLING))
        );
        ModPlacedFeatures.register(context, FALLEN_DOGWOOD_TREE_PLACED_KEY, configuredFeatures.getOrThrow(DogwoodWoodTreeConfiguredFeatures.FALLEN_DOGWOOD_TREE_KEY),
                List.of(PlacedFeatures.wouldSurvive(DogwoodWoodModBlocks.MOD_SAPLING))
        );
    }
}
