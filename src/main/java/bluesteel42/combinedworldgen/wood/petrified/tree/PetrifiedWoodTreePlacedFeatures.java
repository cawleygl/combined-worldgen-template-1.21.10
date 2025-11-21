package bluesteel42.combinedworldgen.wood.petrified.tree;

import bluesteel42.combinedworldgen.world.ModPlacedFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

public class PetrifiedWoodTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> PETRIFIED_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("petrified_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_PETRIFIED_TREE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_petrified_tree");
    public static final RegistryKey<PlacedFeature> PETRIFIED_TREE_ORE_X_PLACED_KEY = ModPlacedFeatures.registerKey("petrified_tree_ore_x");
    public static final RegistryKey<PlacedFeature> PETRIFIED_TREE_ORE_Z_PLACED_KEY = ModPlacedFeatures.registerKey("petrified_tree_ore_z");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        ModPlacedFeatures.register(context, PETRIFIED_TREE_PLACED_KEY, configuredFeatures.getOrThrow(PetrifiedWoodTreeConfiguredFeatures.PETRIFIED_TREE_KEY),
                PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING)
        );
        ModPlacedFeatures.register(context, FALLEN_PETRIFIED_TREE_PLACED_KEY, configuredFeatures.getOrThrow(PetrifiedWoodTreeConfiguredFeatures.FALLEN_PETRIFIED_TREE_KEY),
                PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING)
        );
        ModPlacedFeatures.register(context, PETRIFIED_TREE_ORE_X_PLACED_KEY, configuredFeatures.getOrThrow(PetrifiedWoodTreeConfiguredFeatures.PETRIFIED_TREE_ORE_X_KEY),
                ModPlacedFeatures.modifiersWithRarity(15, HeightRangePlacementModifier.uniform(YOffset.fixed(-16), YOffset.fixed(480)))
        );
        ModPlacedFeatures.register(context, PETRIFIED_TREE_ORE_Z_PLACED_KEY, configuredFeatures.getOrThrow(PetrifiedWoodTreeConfiguredFeatures.PETRIFIED_TREE_ORE_Z_KEY),
                ModPlacedFeatures.modifiersWithRarity(15, HeightRangePlacementModifier.uniform(YOffset.fixed(-16), YOffset.fixed(480)))
        );

    }

}
