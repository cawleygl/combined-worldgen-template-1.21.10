package bluesteel42.combinedworldgen.world;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.baobab.tree.BaobabWoodTreePlacedFeatures;
import bluesteel42.combinedworldgen.wood.cacao.tree.CacaoWoodTreePlacedFeatures;
import bluesteel42.combinedworldgen.wood.citrus.tree.CitrusWoodTreePlacedFeatures;
import bluesteel42.combinedworldgen.wood.dogwood.tree.DogwoodWoodTreePlacedFeatures;
import bluesteel42.combinedworldgen.wood.maple.tree.MapleWoodTreePlacedFeatures;
import bluesteel42.combinedworldgen.wood.petrified.tree.PetrifiedWoodTreePlacedFeatures;
import bluesteel42.combinedworldgen.wood.pine.tree.PineWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.pine.tree.PineWoodTreePlacedFeatures;
import bluesteel42.combinedworldgen.wood.willow.tree.WillowWoodTreePlacedFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ClampedIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ORE_COARSE_DIRT_PLACED_KEY = registerKey("ore_coarse_dirt");
    public static final RegistryKey<PlacedFeature> ORE_LOOSE_DIRT_PLACED_KEY = registerKey("ore_loose_dirt");

    public static final RegistryKey<PlacedFeature> ORE_TUBERED_DIRT_PLACED_KEY = registerKey("ore_tubered_dirt");
    public static final RegistryKey<PlacedFeature> PATCH_QUEEN_ANNES_LACE_PLACED_KEY = registerKey("patch_queen_annes_lace");
    public static final RegistryKey<PlacedFeature> PATCH_SEA_BEET_PLACED_KEY = registerKey("patch_sea_beet");

    public static final RegistryKey<PlacedFeature> PATCH_WHITE_PUMPKIN_PLACED_KEY = registerKey("patch_white_pumpkin");
    public static final RegistryKey<PlacedFeature> PATCH_GREEN_PUMPKIN_PLACED_KEY = registerKey("patch_green_pumpkin");
    public static final RegistryKey<PlacedFeature> PILE_GREEN_PUMPKIN_PLACED_KEY = registerKey("pile_green_pumpkin");

    public static final RegistryKey<PlacedFeature> EXTRA_DIRT_ORE_PLACED_KEY = registerKey("ore_extra_dirt");
    public static final RegistryKey<PlacedFeature> WET_ORE_MUD_PLACED_KEY = registerKey("ore_mud");
    public static final RegistryKey<PlacedFeature> DESERT_ORE_SAND_PLACED_KEY = registerKey("ore_sand");
    public static final RegistryKey<PlacedFeature> BADLANDS_ORE_RED_SAND_PLACED_KEY = registerKey("ore_red_sand");
    public static final RegistryKey<PlacedFeature> FROZEN_ORE_ICE_PLACED_KEY = registerKey("ore_ice");
    public static final RegistryKey<PlacedFeature> SNOWY_ORE_SNOW_PLACED_KEY = registerKey("ore_snow");
    public static final RegistryKey<PlacedFeature> OLD_GROWTH_ORE_MOSSY_COBBLESTONE_PLACED_KEY = registerKey("ore_mossy_cobblestone");
    public static final RegistryKey<PlacedFeature> OLD_GROWTH_ORE_MOSS_PLACED_KEY = registerKey("ore_moss");
    public static final RegistryKey<PlacedFeature> PALE_GARDEN_ORE_MOSS_PLACED_KEY = registerKey("ore_pale_moss");
    public static final RegistryKey<PlacedFeature> MUSHROOM_ORE_BROWN_MUSHROOM_PLACED_KEY = registerKey("ore_brown_mushroom");
    public static final RegistryKey<PlacedFeature> MUSHROOM_ORE_RED_MUSHROOM_PLACED_KEY = registerKey("ore_red_mushroom");

    public static final RegistryKey<PlacedFeature> OLD_GROWTH_BIRCH_VIOLET_PLACED_KEY = registerKey("old_growth_birch_violet");
    public static final RegistryKey<PlacedFeature> OLD_GROWTH_BIRCH_MOSS_PLACED_KEY = registerKey("old_growth_birch_moss");
    public static final RegistryKey<PlacedFeature> BIRCH_FOREST_CLOVER_PLACED_KEY = registerKey("birch_forest_clover");

    public static final RegistryKey<PlacedFeature> FOREST_BIRCH_LEAF_LITTER_PLACED_KEY = registerKey("forest_birch_leaf_litter");
    public static final RegistryKey<PlacedFeature> FOREST_BIRCH_BEES_0002_PLACED_KEY = registerKey("forest_birch_bees_0002");
    public static final RegistryKey<PlacedFeature> FOREST_BIRCH_BEES_0002_LEAF_LITTER_PLACED_KEY = registerKey("forest_birch_bees_0002_leaf_litter");
    public static final RegistryKey<PlacedFeature> FOREST_SUPER_BIRCH_BEES_0002_PLACED_KEY = registerKey("forest_super_birch_bees_0002");
    public static final RegistryKey<PlacedFeature> FOREST_BIRCH_PLACED_KEY = registerKey("forest_birch");
    public static final RegistryKey<PlacedFeature> OLD_GROWTH_SUPER_BIRCH_BEES_0002_PLACED_KEY = registerKey("old_growth_super_birch_bees_0002");
    public static final RegistryKey<PlacedFeature> MOSSY_FALLEN_SUPER_BIRCH_TREE_PLACED_KEY = registerKey("mossy_fallen_super_birch_tree");

    /* SWAMP BIOME */
    public static final RegistryKey<PlacedFeature> SWAMP_WHITE_WATER_LILIES_PLACED_KEY = registerKey("swamp_white_water_lilies");
    public static final RegistryKey<PlacedFeature> SWAMP_PINK_WATER_LILIES_PLACED_KEY = registerKey("swamp_pink_water_lilies");
    public static final RegistryKey<PlacedFeature> SWAMP_BLUE_WATER_LILIES_PLACED_KEY = registerKey("swamp_blue_water_lilies");
    public static final RegistryKey<PlacedFeature> SWAMP_PURPLE_WATER_LILIES_PLACED_KEY = registerKey("swamp_purple_water_lilies");
    public static final RegistryKey<PlacedFeature> SWAMP_SURFACE_MUD_PLACED_KEY = registerKey("swamp_surface_mud");
    public static final RegistryKey<PlacedFeature> SWAMP_MUD_DISK_PLACED_KEY = registerKey("swamp_mud_disk");
    public static final RegistryKey<PlacedFeature> SWAMP_FIREFLIES_PLACED_KEY = registerKey("swamp_fireflies");
    public static final RegistryKey<PlacedFeature> PATCH_TALL_GRASS_BUSH_NEAR_WATER_SWAMP_PLACED_KEY = registerKey("patch_tall_grass_near_water_swamp");

    /* SWAMP BIOME */
    public static final RegistryKey<PlacedFeature> FLOWER_PATCH_CHERRY_PLACED_KEY = registerKey("flower_patch_cherry");
    public static final RegistryKey<PlacedFeature> FALLEN_CHERRY_TREE_PLACED_KEY = registerKey("fallen_cherry_tree");

    /* SNOWY BIOMES */
    public static final RegistryKey<PlacedFeature> PATCH_GRASS_SNOWY_PLAINS_PLACED_KEY = registerKey("patch_grass_snowy_plains");
    public static final RegistryKey<PlacedFeature> PATCH_BUSH_SNOWY_PLAINS_PLACED_KEY = registerKey("patch_bush_snowy_plains");
    public static final RegistryKey<PlacedFeature> PATCH_GRASS_SNOWY_TAIGA_PLACED_KEY = registerKey("patch_grass_snowy_taiga");
    public static final RegistryKey<PlacedFeature> FLOWER_SNOWY_PLACED_KEY = registerKey("flower_snowy");
    public static final RegistryKey<PlacedFeature> VILLAGE_SNOWY_SPRUCE = registerKey("village_snowy_spruce");

    /* SAVANNA BIOME */
    public static final RegistryKey<PlacedFeature> FALLEN_ACACIA_TREE_PLACED_KEY = registerKey("fallen_acacia_tree");
    public static final RegistryKey<PlacedFeature> DRY_FALLEN_BIRCH_TREE_PLACED_KEY = registerKey("dry_fallen_birch_tree");

    /* JUNGLE BIOMES */
    public static final RegistryKey<PlacedFeature> FLOWER_JUNGLE_PLACED_KEY = registerKey("flower_jungle");
    public static final RegistryKey<PlacedFeature> PATCH_GIANT_PADMA_PLACED_KEY = registerKey("patch_giant_padma");

    /* FLOWER BIOMES */
    public static final RegistryKey<PlacedFeature> FLOWERBED_MEADOW_PLACED_KEY = registerKey("flowerbed_meadow");

    /* CLOVER PLAINS */
    public static final RegistryKey<PlacedFeature> CLOVER_PLAINS_PLACED_KEY = registerKey("clover_plains");

    /* DESERT BIOME */
    public static final RegistryKey<PlacedFeature> PATCH_SMALL_CACTUS_DESERT_PLACED_KEY = registerKey("patch_small_cactus_desert");
    public static final RegistryKey<PlacedFeature> PATCH_SMALL_CACTUS_DECORATED_PLACED_KEY = registerKey("patch_small_cactus_decorated");
    public static final RegistryKey<PlacedFeature> PATCH_SMALL_CACTUS_VILLAGE_PLACED_KEY = registerKey("patch_small_cactus_village");

    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        /* TREES */
        BaobabWoodTreePlacedFeatures.bootstrap(context);
        CacaoWoodTreePlacedFeatures.bootstrap(context);
        CitrusWoodTreePlacedFeatures.bootstrap(context);
        DogwoodWoodTreePlacedFeatures.bootstrap(context);
//        KapokWoodTreePlacedFeatures.bootstrap(context);
        MapleWoodTreePlacedFeatures.bootstrap(context);
        PetrifiedWoodTreePlacedFeatures.bootstrap(context);
        PineWoodTreePlacedFeatures.bootstrap(context);
        WillowWoodTreePlacedFeatures.bootstrap(context);

        register(context, ORE_LOOSE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_LOOSE_DIRT_KEY),
                modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, ORE_COARSE_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_COARSE_DIRT_KEY),
                modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, WET_ORE_MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.WET_ORE_MUD_KEY),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, EXTRA_DIRT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EXTRA_DIRT_ORE_KEY),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, DESERT_ORE_SAND_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DESERT_ORE_SAND_KEY),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, BADLANDS_ORE_RED_SAND_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BADLANDS_ORE_RED_SAND_KEY),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, FROZEN_ORE_ICE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FROZEN_ORE_ICE_KEY),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, SNOWY_ORE_SNOW_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SNOWY_ORE_SNOW_KEY),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, OLD_GROWTH_ORE_MOSSY_COBBLESTONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OLD_GROWTH_ORE_MOSSY_COBBLESTONE_KEY),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, OLD_GROWTH_ORE_MOSS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OLD_GROWTH_ORE_MOSS_KEY),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, PALE_GARDEN_ORE_MOSS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALE_GARDEN_ORE_MOSS_KEY),
                modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, MUSHROOM_ORE_BROWN_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALE_GARDEN_ORE_MOSS_KEY),
                modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );
        register(context, MUSHROOM_ORE_RED_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALE_GARDEN_ORE_MOSS_KEY),
                modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(160)))
        );

        register(context, ORE_TUBERED_DIRT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ORE_TUBERED_DIRT_KEY),
                modifiersWithCount(25, HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.getTop()))
        );
        register(context, PATCH_QUEEN_ANNES_LACE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_QUEEN_ANNES_LACE_KEY),
                modifiersWithRarity(6,  PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP)
        );
        register(context, PATCH_SEA_BEET_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_SEA_BEET_KEY),
                modifiersWithRarity(2,  PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP)
        );

        register(context, PILE_GREEN_PUMPKIN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PILE_GREEN_PUMPKIN_KEY));
        register(context,PATCH_GREEN_PUMPKIN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_GREEN_PUMPKIN_KEY),
                RarityFilterPlacementModifier.of(300),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context,PATCH_WHITE_PUMPKIN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_WHITE_PUMPKIN_KEY),
                RarityFilterPlacementModifier.of(20),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        /* SWAMP BIOME */
        register(context, SWAMP_WHITE_WATER_LILIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_WHITE_WATER_LILIES_KEY),
                List.of(RarityFilterPlacementModifier.of(30),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );
        register(context, SWAMP_PINK_WATER_LILIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_PINK_WATER_LILIES_KEY),
                List.of(RarityFilterPlacementModifier.of(125),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );
        register(context, SWAMP_BLUE_WATER_LILIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_BLUE_WATER_LILIES_KEY),
                List.of(RarityFilterPlacementModifier.of(150),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );
        register(context, SWAMP_PURPLE_WATER_LILIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_PURPLE_WATER_LILIES_KEY),
                List.of(RarityFilterPlacementModifier.of(200),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );
        register(context, SWAMP_FIREFLIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_FIREFLIES_KEY),
                List.of(CountPlacementModifier.of(14),
                        NoiseThresholdCountPlacementModifier.of(-0.8, 5, 10),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );
        register(context, SWAMP_MUD_DISK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_MUD_DISK_KEY),
                SquarePlacementModifier.of(),
                PlacedFeatures.OCEAN_FLOOR_WG_HEIGHTMAP,
                BlockFilterPlacementModifier.of(BlockPredicate.matchingFluids(Fluids.WATER)),
                BiomePlacementModifier.of()
        );
        register(context, SWAMP_SURFACE_MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_SURFACE_MUD_KEY),
                CountPlacementModifier.of(1),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_NO_LEAVES_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context, PATCH_TALL_GRASS_BUSH_NEAR_WATER_SWAMP_PLACED_KEY, configuredFeatures.getOrThrow(VegetationConfiguredFeatures.PATCH_TALL_GRASS),
                CountPlacementModifier.of(12),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of(),
                VegetationConfiguredFeatures.wouldSurviveNearWaterModifier(Blocks.TALL_GRASS)
        );

        /* CHERRY BIOME */
        register(context, FLOWER_PATCH_CHERRY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOWER_PATCH_CHERRY_KEY),
                CountPlacementModifier.of(3),
                RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context, FALLEN_CHERRY_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FALLEN_CHERRY_TREE),
                PlacedFeatures.wouldSurvive(Blocks.CHERRY_SAPLING)
        );

        register(context, OLD_GROWTH_BIRCH_VIOLET_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OLD_GROWTH_BIRCH_VIOLET_KEY),
                CountPlacementModifier.of(3),
                RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        register(context, BIRCH_FOREST_CLOVER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BIRCH_FOREST_CLOVER_KEY),
                CountPlacementModifier.of(3),
                RarityFilterPlacementModifier.of(2),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        register(context, OLD_GROWTH_BIRCH_MOSS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OLD_GROWTH_BIRCH_MOSS_BLOCK_KEY),
                CountPlacementModifier.of(1),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_NO_LEAVES_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        register(context, FOREST_BIRCH_LEAF_LITTER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FOREST_BIRCH_LEAF_LITTER_KEY),
                PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING)
        );
        register(context, FOREST_BIRCH_BEES_0002_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FOREST_BIRCH_BEES_0002_KEY),
                PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING)
        );
        register(context, FOREST_BIRCH_BEES_0002_LEAF_LITTER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FOREST_BIRCH_BEES_0002_LEAF_LITTER_KEY),
                PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING)
        );
        register(context, FOREST_SUPER_BIRCH_BEES_0002_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FOREST_SUPER_BIRCH_BEES_0002_KEY),
                PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING)
        );
        register(context, OLD_GROWTH_SUPER_BIRCH_BEES_0002_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OLD_GROWTH_SUPER_BIRCH_BEES_0002_KEY),
                PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING)
        );
        register(context, FOREST_BIRCH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FOREST_BIRCH_KEY),
                PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING)
        );
        register(context, MOSSY_FALLEN_SUPER_BIRCH_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOSSY_FALLEN_SUPER_BIRCH_TREE_KEY),
                PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING)
        );


        /* SNOWY BIOMES */
        register(context,
                PATCH_GRASS_SNOWY_PLAINS_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_SNOWY_GRASS),
                SquarePlacementModifier.of(),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context,
                PATCH_BUSH_SNOWY_PLAINS_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_SNOWY_BUSH),
                RarityFilterPlacementModifier.of(4),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context,
                PATCH_GRASS_SNOWY_TAIGA_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_SNOWY_GRASS_AND_FERNS),
                SquarePlacementModifier.of(),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context,
                FLOWER_SNOWY_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOWER_SNOWY),
                RarityFilterPlacementModifier.of(32),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context, VILLAGE_SNOWY_SPRUCE, configuredFeatures.getOrThrow(PineWoodTreeConfiguredFeatures.SNOWY_SPRUCE_KEY), PlacedFeatures.wouldSurvive(Blocks.SPRUCE_SAPLING));

        /* SAVANNA BIOME */
        register(context, FALLEN_ACACIA_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FALLEN_ACACIA_TREE_KEY),
                PlacedFeatures.wouldSurvive(Blocks.ACACIA_SAPLING)
        );
        register(context, DRY_FALLEN_BIRCH_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DRY_FALLEN_BIRCH_TREE_KEY),
                PlacedFeatures.wouldSurvive(Blocks.BIRCH_SAPLING)
        );

        /* JUNGLE BIOMES */
        register(context, FLOWER_JUNGLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOWER_JUNGLE_KEY),
                RarityFilterPlacementModifier.of(16),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context, PATCH_GIANT_PADMA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_GIANT_PADMA_KEY),
                RarityFilterPlacementModifier.of(64),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        /* FLOWER BIOMES */
        register(context, FLOWERBED_MEADOW_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLOWERBED_MEADOW_KEY),
                CountPlacementModifier.of(9),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                CountPlacementModifier.of(ClampedIntProvider.create(UniformIntProvider.create(-3, 1), 0, 1)),
                BiomePlacementModifier.of()
        );

        /* PLAINS BIOME */
        register(context, CLOVER_PLAINS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CLOVER_PLAINS_KEY),
                RarityFilterPlacementModifier.of(24),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        /* DESERT BIOME */
        register(context, PATCH_SMALL_CACTUS_DESERT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_SMALL_CACTUS_KEY),
                RarityFilterPlacementModifier.of(10),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context, PATCH_SMALL_CACTUS_DECORATED_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_SMALL_CACTUS_KEY),
                RarityFilterPlacementModifier.of(18),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
        register(context, PATCH_SMALL_CACTUS_VILLAGE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PATCH_SMALL_CACTUS_KEY));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(CombinedWorldgen.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                  RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                  PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
