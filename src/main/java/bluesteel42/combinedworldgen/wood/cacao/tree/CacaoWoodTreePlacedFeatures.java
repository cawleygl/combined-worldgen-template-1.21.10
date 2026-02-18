package bluesteel42.combinedworldgen.wood.cacao.tree;

import bluesteel42.combinedworldgen.wood.cacao.block.CacaoWoodModBlocks;
import bluesteel42.combinedworldgen.world.ModPlacedFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;

public class CacaoWoodTreePlacedFeatures {
    public static final RegistryKey<PlacedFeature> CACAO_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("cacao_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_CACAO_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_cacao_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(context, CACAO_TREE_PLACED_KEY, configuredFeatures.getOrThrow(CacaoWoodTreeConfiguredFeatures.CACAO_TREE_KEY),
                PlacedFeatures.wouldSurvive(CacaoWoodModBlocks.MOD_SAPLING)
        );
        ModPlacedFeatures.register(context, FALLEN_CACAO_TREE_PLACED_KEY, configuredFeatures.getOrThrow(CacaoWoodTreeConfiguredFeatures.FALLEN_CACAO_TREE_KEY),
                PlacedFeatures.wouldSurvive(CacaoWoodModBlocks.MOD_SAPLING)
        );
    }

}
