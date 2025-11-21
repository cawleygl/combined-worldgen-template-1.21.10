package bluesteel42.combinedworldgen.wood.maple.tree;

import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
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

public class MapleWoodTreePlacedFeatures {
    /* FOREST */
    public static final RegistryKey<PlacedFeature> TALL_GREEN_MAPLE_BEES_0002_LEAF_LITTER_PLACED_KEY = ModPlacedFeatures.registerKey("tall_green_maple_bees_0002_leaf_litter");
    public static final RegistryKey<PlacedFeature> SHORT_GREEN_MAPLE_BEES_0002_LEAF_LITTER_PLACED_KEY = ModPlacedFeatures.registerKey("short_green_maple_bees_0002_leaf_litter");
    public static final RegistryKey<PlacedFeature> TALL_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_PLACED_KEY = ModPlacedFeatures.registerKey("tall_yellow_maple_bees_0002_leaf_litter");
    public static final RegistryKey<PlacedFeature> SHORT_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_PLACED_KEY = ModPlacedFeatures.registerKey("short_yellow_maple_bees_0002_leaf_litter");

    /* PLAINS */
    public static final RegistryKey<PlacedFeature> TALL_GREEN_MAPLE_PLACED_BEES_005_KEY = ModPlacedFeatures.registerKey("tall_green_maple_bees_005");
    public static final RegistryKey<PlacedFeature> SHORT_GREEN_MAPLE_PLACED_BEES_005_KEY = ModPlacedFeatures.registerKey("short_green_maple_bees_005");
    public static final RegistryKey<PlacedFeature> TALL_YELLOW_MAPLE_PLACED_BEES_005_KEY = ModPlacedFeatures.registerKey("tall_yellow_maple_bees_005");
    public static final RegistryKey<PlacedFeature> SHORT_YELLOW_MAPLE_PLACED_BEES_005_KEY = ModPlacedFeatures.registerKey("short_yellow_maple_bees_005");

    /* FLOWER FOREST */
    public static final RegistryKey<PlacedFeature> TALL_YELLOW_MAPLE_BEES_002_PLACED_KEY = ModPlacedFeatures.registerKey("tall_yellow_maple_bees_002");
    public static final RegistryKey<PlacedFeature> SHORT_YELLOW_MAPLE_BEES_002_PLACED_KEY = ModPlacedFeatures.registerKey("short_yellow_maple_bees_002");
    public static final RegistryKey<PlacedFeature> TALL_GREEN_MAPLE_BEES_002_PLACED_KEY = ModPlacedFeatures.registerKey("tall_green_maple_bees_002");
    public static final RegistryKey<PlacedFeature> SHORT_GREEN_MAPLE_BEES_002_PLACED_KEY = ModPlacedFeatures.registerKey("short_green_maple_bees_002");
    public static final RegistryKey<PlacedFeature> TALL_RED_MAPLE_BEES_002_PLACED_KEY = ModPlacedFeatures.registerKey("tall_red_maple_bees_002");
    public static final RegistryKey<PlacedFeature> SHORT_RED_MAPLE_BEES_002_PLACED_KEY = ModPlacedFeatures.registerKey("short_red_maple_bees_002");

    /* GROVE */
    public static final RegistryKey<PlacedFeature> TALL_RED_MAPLE_ON_SNOW_PLACED_KEY = ModPlacedFeatures.registerKey("tall_red_maple_on_snow");
    public static final RegistryKey<PlacedFeature> SHORT_RED_MAPLE_ON_SNOW_PLACED_KEY = ModPlacedFeatures.registerKey("short_red_maple_on_snow");
    public static final RegistryKey<PlacedFeature> TALL_YELLOW_MAPLE_ON_SNOW_PLACED_KEY = ModPlacedFeatures.registerKey("tall_yellow_maple_on_snow");
    public static final RegistryKey<PlacedFeature> SHORT_YELLOW_MAPLE_ON_SNOW_PLACED_KEY = ModPlacedFeatures.registerKey("short_yellow_maple_on_snow");

    /* SNOWY TAIGA  */
    public static final RegistryKey<PlacedFeature> SHORT_RED_MAPLE_PLACED_KEY = ModPlacedFeatures.registerKey("short_red_maple");
    public static final RegistryKey<PlacedFeature> TALL_RED_MAPLE_PLACED_KEY = ModPlacedFeatures.registerKey("tall_red_maple");
    public static final RegistryKey<PlacedFeature> SHORT_YELLOW_MAPLE_PLACED_KEY = ModPlacedFeatures.registerKey("short_yellow_maple");
    public static final RegistryKey<PlacedFeature> TALL_YELLOW_MAPLE_PLACED_KEY = ModPlacedFeatures.registerKey("tall_yellow_maple");

    /* WINDSWEPT HILLS */
    public static final RegistryKey<PlacedFeature> SHORT_GREEN_MAPLE_PLACED_KEY = ModPlacedFeatures.registerKey("short_green_maple");
    public static final RegistryKey<PlacedFeature> TALL_GREEN_MAPLE_PLACED_KEY = ModPlacedFeatures.registerKey("tall_green_maple");

    /* FALLEN MAPLE TREE */
    public static final RegistryKey<PlacedFeature> FALLEN_MAPLE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_maple_tree");
    public static final RegistryKey<PlacedFeature> FALLEN_SNOWY_MAPLE_PLACED_KEY = ModPlacedFeatures.registerKey("fallen_snowy_maple_tree");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        /* FOREST */
        ModPlacedFeatures.register(context, TALL_GREEN_MAPLE_BEES_0002_LEAF_LITTER_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_GREEN_MAPLE_BEES_0002_LEAF_LITTER_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, SHORT_GREEN_MAPLE_BEES_0002_LEAF_LITTER_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_GREEN_MAPLE_BEES_0002_LEAF_LITTER_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, TALL_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, SHORT_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_YELLOW_MAPLE_BEES_0002_LEAF_LITTER_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));

        /* PLAINS */
        ModPlacedFeatures.register(context, SHORT_GREEN_MAPLE_PLACED_BEES_005_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_GREEN_MAPLE_BEES_005_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, TALL_GREEN_MAPLE_PLACED_BEES_005_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_GREEN_MAPLE_BEES_005_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, SHORT_YELLOW_MAPLE_PLACED_BEES_005_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_YELLOW_MAPLE_BEES_005_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, TALL_YELLOW_MAPLE_PLACED_BEES_005_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_YELLOW_MAPLE_BEES_005_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));

        /* FLOWER FOREST */
        ModPlacedFeatures.register(context, TALL_YELLOW_MAPLE_BEES_002_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_YELLOW_MAPLE_BEES_002_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, SHORT_YELLOW_MAPLE_BEES_002_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_YELLOW_MAPLE_BEES_002_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, TALL_GREEN_MAPLE_BEES_002_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_GREEN_MAPLE_BEES_002_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, SHORT_GREEN_MAPLE_BEES_002_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_GREEN_MAPLE_BEES_002_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, TALL_RED_MAPLE_BEES_002_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_RED_MAPLE_BEES_002_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, SHORT_RED_MAPLE_BEES_002_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_RED_MAPLE_BEES_002_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));

        /* GROVE */
        BlockPredicate blockPredicate = BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW);
        List<PlacementModifier> list = List.of(
                EnvironmentScanPlacementModifier.of(Direction.UP, BlockPredicate.not(BlockPredicate.matchingBlocks(Blocks.POWDER_SNOW)), 8),
                BlockFilterPlacementModifier.of(blockPredicate)
        );
        ModPlacedFeatures.register(context, SHORT_RED_MAPLE_ON_SNOW_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_RED_MAPLE_KEY), list);
        ModPlacedFeatures.register(context, TALL_RED_MAPLE_ON_SNOW_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_RED_MAPLE_KEY), list);
        ModPlacedFeatures.register(context, SHORT_YELLOW_MAPLE_ON_SNOW_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_YELLOW_MAPLE_KEY), list);
        ModPlacedFeatures.register(context, TALL_YELLOW_MAPLE_ON_SNOW_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_YELLOW_MAPLE_KEY), list);

        /* SNOWY TAIGA */
        ModPlacedFeatures.register(context, TALL_RED_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_RED_MAPLE_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, SHORT_RED_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_RED_MAPLE_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, TALL_YELLOW_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_YELLOW_MAPLE_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, SHORT_YELLOW_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_YELLOW_MAPLE_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));

        /* WINDSWEPT HILLS */
        ModPlacedFeatures.register(context, SHORT_GREEN_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.SHORT_GREEN_MAPLE_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, TALL_GREEN_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.TALL_GREEN_MAPLE_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));

        /* FALLEN MAPLE TREE */
        ModPlacedFeatures.register(context, FALLEN_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.FALLEN_MAPLE_TREE_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));
        ModPlacedFeatures.register(context, FALLEN_SNOWY_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(MapleWoodTreeConfiguredFeatures.FALLEN_SNOWY_MAPLE_KEY), PlacedFeatures.wouldSurvive(MapleWoodModBlocks.MOD_SAPLING));

    }

}
