package bluesteel42.combinedworldgen.wood.baobab.tree;

import bluesteel42.combinedworldgen.wood.baobab.block.BaobabWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModPlacedFeatures;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.*;

public class BaobabWoodTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> BAOBAB_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("baobab_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(context, BAOBAB_TREE_PLACED_KEY, configuredFeatures.getOrThrow(BaobabWoodTreeConfiguredFeatures.BAOBAB_TREE_KEY),
                PlacedFeatures.wouldSurvive(BaobabWoodModBlocks.MOD_SAPLING)
        );
    }

}
