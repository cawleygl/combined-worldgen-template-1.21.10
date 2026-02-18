package bluesteel42.combinedworldgen.world;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.wood.baobab.tree.BaobabWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.cacao.tree.CacaoWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.citrus.tree.CitrusWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.dogwood.tree.DogwoodWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.dogwood.tree.DogwoodWoodTreePlacedFeatures;
import bluesteel42.combinedworldgen.wood.kapok.tree.KapokWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.maple.tree.MapleWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.petrified.tree.PetrifiedWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.pine.tree.PineWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.willow.tree.WillowWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.willow.tree.WillowWoodTreePlacedFeatures;
import bluesteel42.combinedworldgen.world.tree.HangingMushroomTreeDecorator;
import bluesteel42.combinedworldgen.world.tree.NotchedTrunkBeehiveTreeDecorator;
import bluesteel42.combinedworldgen.world.tree.NotchedTrunkPlacer;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.*;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.BlockFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.PredicatedStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;
import net.minecraft.world.gen.treedecorator.PlaceOnGroundTreeDecorator;

import java.util.List;

import static net.minecraft.world.gen.feature.ConfiguredFeatures.createRandomPatchFeatureConfig;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_COARSE_DIRT_KEY = registerKey("ore_coarse_dirt");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_LOOSE_DIRT_KEY = registerKey("ore_loose_dirt");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_TUBERED_DIRT_KEY = registerKey("ore_tubered_dirt");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_QUEEN_ANNES_LACE_KEY = registerKey("patch_queen_annes_lace");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SEA_BEET_KEY = registerKey("patch_sea_beet");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_WHITE_PUMPKIN_KEY = registerKey("patch_white_pumpkin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_GREEN_PUMPKIN_KEY = registerKey("patch_green_pumpkin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PILE_GREEN_PUMPKIN_KEY = registerKey("pile_green_pumpkin");

    public static final RegistryKey<ConfiguredFeature<?, ?>> EXTRA_DIRT_ORE_KEY = registerKey("ore_extra_dirt");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WET_ORE_MUD_KEY = registerKey("ore_mud");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DESERT_ORE_SAND_KEY = registerKey("ore_sand");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BADLANDS_ORE_RED_SAND_KEY = registerKey("ore_red_sand");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FROZEN_ORE_ICE_KEY = registerKey("ore_ice");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SNOWY_ORE_SNOW_KEY = registerKey("ore_snow");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OLD_GROWTH_ORE_MOSSY_COBBLESTONE_KEY = registerKey("ore_mossy_cobblestone");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OLD_GROWTH_ORE_MOSS_KEY = registerKey("ore_moss");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_GARDEN_ORE_MOSS_KEY = registerKey("ore_pale_moss");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_ORE_BROWN_MUSHROOM_KEY = registerKey("ore_brown_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_ORE_RED_MUSHROOM_KEY = registerKey("ore_red_mushroom");

    public static final RegistryKey<ConfiguredFeature<?, ?>> OLD_GROWTH_BIRCH_VIOLET_KEY = registerKey("old_growth_birch_violet");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OLD_GROWTH_BIRCH_MOSS_CARPET_KEY = registerKey("old_growth_birch_moss_carpet");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OLD_GROWTH_BIRCH_MOSS_BLOCK_KEY = registerKey("old_growth_birch_moss_block");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIRCH_FOREST_CLOVER_KEY = registerKey("birch_forest_clover");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPLING_BIRCH_KEY = registerKey("sapling_birch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPLING_BIRCH_BEES_005_KEY = registerKey("sapling_birch_bees_005");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FOREST_BIRCH_LEAF_LITTER_KEY = registerKey("forest_birch_leaf_litter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FOREST_BIRCH_BEES_0002_KEY = registerKey("forest_birch_bees_0002");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FOREST_BIRCH_BEES_0002_LEAF_LITTER_KEY = registerKey("forest_birch_bees_0002_leaf_litter");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FOREST_SUPER_BIRCH_BEES_0002_KEY = registerKey("forest_super_birch_bees_0002");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FOREST_BIRCH_KEY = registerKey("forest_birch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DRY_BIRCH_KEY = registerKey("dry_birch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OLD_GROWTH_SUPER_BIRCH_BEES_0002_KEY = registerKey("old_growth_super_birch_bees_0002");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOSSY_FALLEN_SUPER_BIRCH_TREE_KEY = registerKey("mossy_fallen_super_birch_tree");

    /* SWAMP BIOME */
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_SWAMP_KEY = ModConfiguredFeatures.registerKey("trees_swamp");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_WHITE_WATER_LILIES_KEY = registerKey("swamp_white_water_lilies");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_PINK_WATER_LILIES_KEY = registerKey("swamp_pink_water_lilies");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_BLUE_WATER_LILIES_KEY = registerKey("swamp_blue_water_lilies");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_PURPLE_WATER_LILIES_KEY = registerKey("swamp_purple_water_lilies");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_SURFACE_MUD_KEY = registerKey("swamp_surface_mud");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_SURFACE_MUD_VEGETATION_KEY = registerKey("swamp_surface_mud_vegetation");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_MUD_DISK_KEY = registerKey("swamp_mud_disk");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_FIREFLIES_KEY = registerKey("swamp_fireflies");

    /* CHERRY BIOME */
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_PATCH_CHERRY_KEY = registerKey("flower_patch_cherry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_CHERRY_KEY = registerKey("trees_cherry");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_CHERRY_TREE = registerKey("fallen_cherry_tree");

    /* SNOWY BIOMES */
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SNOWY_GRASS = registerKey("patch_snowy_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SNOWY_BUSH = registerKey("patch_snowy_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SNOWY_GRASS_AND_FERNS = registerKey("patch_snowy_grass_and_ferns");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_SNOWY = registerKey("flower_snowy");

    /* SAVANNA BIOME */
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_ACACIA_TREE_KEY = registerKey("fallen_acacia_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DRY_FALLEN_BIRCH_TREE_KEY = registerKey("dry_fallen_birch_tree");

    /* JUNGLE BIOMES */
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWER_JUNGLE_KEY = registerKey("flower_jungle");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_GIANT_PADMA_KEY = registerKey("patch_giant_padma");

    /* FLOWER BIOMES */
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOWERBED_MEADOW_KEY = registerKey("flowerbed_meadow");

    /* PLAINS BIOME */
    public static final RegistryKey<ConfiguredFeature<?, ?>> CLOVER_PLAINS_KEY = registerKey("clover_plains");

    /* DESERT BIOME */
    public static final RegistryKey<ConfiguredFeature<?, ?>> PATCH_SMALL_CACTUS_KEY = registerKey("patch_small_cactus");

    public static Pool.Builder<BlockState> flowerbed(Block flowerbed) {
        return segmentedBlock(flowerbed, 1, 4, FlowerbedBlock.FLOWER_AMOUNT, FlowerbedBlock.HORIZONTAL_FACING);
    }
    public static Pool.Builder<BlockState> denseFlowerbed(Block flowerbed) {
        return segmentedBlock(flowerbed, 3, 4, FlowerbedBlock.FLOWER_AMOUNT, FlowerbedBlock.HORIZONTAL_FACING);
    }

    public static Pool.Builder<BlockState> segmentedBlock(Block block, int min, int max, IntProperty amountProperty, EnumProperty<Direction> facingProperty) {
        Pool.Builder<BlockState> builder = Pool.builder();

        for (int i = min; i <= max; i++) {
            for (Direction direction : Direction.Type.HORIZONTAL) {
                builder.add(block.getDefaultState().with(amountProperty, i).with(facingProperty, direction), 1);
            }
        }

        return builder;
    }

    public static RandomPatchFeatureConfig createRandomPatchFeatureConfig2(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(block)));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        /* TREES */
        BaobabWoodTreeConfiguredFeatures.bootstrap(context);
        CacaoWoodTreeConfiguredFeatures.bootstrap(context);
        CitrusWoodTreeConfiguredFeatures.bootstrap(context);
        DogwoodWoodTreeConfiguredFeatures.bootstrap(context);
        KapokWoodTreeConfiguredFeatures.bootstrap(context);
        MapleWoodTreeConfiguredFeatures.bootstrap(context);
        PetrifiedWoodTreeConfiguredFeatures.bootstrap(context);
        PineWoodTreeConfiguredFeatures.bootstrap(context);
        WillowWoodTreeConfiguredFeatures.bootstrap(context);

        register(context, ORE_LOOSE_DIRT_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), ModBlocks.LOOSE_DIRT.getDefaultState(),33));
        register(context, ORE_COARSE_DIRT_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.COARSE_DIRT.getDefaultState(),33));

        register(context, ORE_TUBERED_DIRT_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.CONVERTABLE_TO_MUD), ModBlocks.TUBERED_DIRT.getDefaultState(),6));
        register(context, PATCH_QUEEN_ANNES_LACE_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        20, 4, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.QUEEN_ANNES_LACE)))
                )
        );
        register(context, PATCH_SEA_BEET_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                    30, 6, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SEA_BEET)))
                )
        );

        register(context, EXTRA_DIRT_ORE_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.DIRT.getDefaultState(),33));
        register(context, WET_ORE_MUD_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.MUD.getDefaultState(),33));
        register(context, DESERT_ORE_SAND_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.SAND.getDefaultState(),33));
        register(context, BADLANDS_ORE_RED_SAND_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.RED_SAND.getDefaultState(),33));
        register(context, FROZEN_ORE_ICE_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.ICE.getDefaultState(),33));
        register(context, SNOWY_ORE_SNOW_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.SNOW_BLOCK.getDefaultState(),33));
        register(context, OLD_GROWTH_ORE_MOSSY_COBBLESTONE_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.MOSSY_COBBLESTONE.getDefaultState(),33));
        register(context, OLD_GROWTH_ORE_MOSS_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.MOSS_BLOCK.getDefaultState(),33));
        register(context, PALE_GARDEN_ORE_MOSS_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.PALE_MOSS_BLOCK.getDefaultState(),33));
        register(context, MUSHROOM_ORE_BROWN_MUSHROOM_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState(),33));
        register(context, MUSHROOM_ORE_RED_MUSHROOM_KEY, Feature.ORE, new OreFeatureConfig(new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD), Blocks.RED_MUSHROOM_BLOCK.getDefaultState(),33));

        register(context, PILE_GREEN_PUMPKIN_KEY, Feature.BLOCK_PILE,
                new BlockPileFeatureConfig(
                        new WeightedBlockStateProvider(Pool.<BlockState>builder()
                                .add(ModPumpkinBlocks.GREEN_PUMPKIN.getDefaultState(), 13)
                                .add(Blocks.PUMPKIN.getDefaultState(), 6)
                                .add(ModPumpkinBlocks.GREEN_JACK_O_LANTERN.getDefaultState(), 1))
                )
        );
        register(context, PATCH_WHITE_PUMPKIN_KEY, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModPumpkinBlocks.WHITE_PUMPKIN)), List.of(Blocks.GRASS_BLOCK, Blocks.PALE_MOSS_BLOCK, Blocks.SNOW_BLOCK)
                )
        );
        register(context, PATCH_GREEN_PUMPKIN_KEY, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModPumpkinBlocks.GREEN_PUMPKIN)), List.of(Blocks.GRASS_BLOCK, Blocks.MOSS_BLOCK, Blocks.PODZOL, Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS)
                )
        );

        /* SWAMP BIOME */
        ModConfiguredFeatures.register(context, TREES_SWAMP_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(DogwoodWoodTreePlacedFeatures.DOGWOOD_TREE_PLACED_KEY), 0.05F),
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(WillowWoodTreePlacedFeatures.WEEPING_WILLOW_PLACED_KEY), 0.4F),
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(WillowWoodTreePlacedFeatures.HUGE_RED_MUSHROOM_PLACED_KEY), 0.05F),
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(WillowWoodTreePlacedFeatures.HUGE_BROWN_MUSHROOM_PLACED_KEY), 0.05F),
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(WillowWoodTreePlacedFeatures.FALLEN_WILLOW_TREE_PLACED_KEY), 0.0125F),
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(DogwoodWoodTreePlacedFeatures.FALLEN_DOGWOOD_TREE_PLACED_KEY), 0.001F)
        ), context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(WillowWoodTreePlacedFeatures.WILLOW_TREE_PLACED_KEY)
        ));

        register(context, SWAMP_WHITE_WATER_LILIES_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        15, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModFloraBlocks.WHITE_WATER_LILY)))
                )
        );
        register(context, SWAMP_PINK_WATER_LILIES_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        15, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(
                                new WeightedBlockStateProvider(
                                        Pool.<BlockState>builder()
                                                .add(ModFloraBlocks.PINK_WATER_LILY.getDefaultState(), 5)
                                                .add(ModFloraBlocks.WHITE_WATER_LILY.getDefaultState(), 2)
                                )
                        ))
                )
        );
        register(context, SWAMP_BLUE_WATER_LILIES_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        15, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModFloraBlocks.BLUE_WATER_LILY)))
                )
        );
        register(context, SWAMP_PURPLE_WATER_LILIES_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        15, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(
                                new WeightedBlockStateProvider(
                                        Pool.<BlockState>builder()
                                                .add(ModFloraBlocks.PURPLE_WATER_LILY.getDefaultState(), 5)
                                                .add(ModFloraBlocks.BLUE_WATER_LILY.getDefaultState(), 2)
                                )
                        ))
                )
        );

        register(context, SWAMP_FIREFLIES_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.FIREFLY_BUSH.getDefaultState())));

        register(context, SWAMP_MUD_DISK_KEY, Feature.DISK,
                new DiskFeatureConfig(
                        PredicatedStateProvider.of(Blocks.MUD),
                        BlockPredicate.matchingBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK)),
                        UniformIntProvider.create(3, 5),
                        2
                )
        );

        register(context,
                SWAMP_SURFACE_MUD_VEGETATION_KEY,
                Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(
                        new WeightedBlockStateProvider(
                                Pool.<BlockState>builder()
                                        .add(Blocks.SHORT_GRASS.getDefaultState(), 10)
                                        .add(Blocks.TALL_GRASS.getDefaultState(), 6)
                        )
                )
        );

        register(context,
                SWAMP_SURFACE_MUD_KEY,
                Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(
                        BlockTags.DIRT,
                        BlockStateProvider.of(Blocks.MUD),
                        PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(SWAMP_SURFACE_MUD_VEGETATION_KEY)),
                        VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1),
                        0.5F,
                        6,
                        0.2F,
                        UniformIntProvider.create(3, 5),
                        0.75F
                )
        );

        /* CHERRY BIOME */
        ConfiguredFeatures.register(context,
                FLOWER_PATCH_CHERRY_KEY,
                Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        96,
                        6,
                        2,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        new NoiseBlockStateProvider(
                                                2345L,
                                                new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0),
                                                0.020833334F,
                                                List.of(
                                                        Blocks.ALLIUM.getDefaultState(),
                                                        Blocks.AZURE_BLUET.getDefaultState(),
                                                        Blocks.WHITE_TULIP.getDefaultState(),
                                                        Blocks.PINK_TULIP.getDefaultState(),
                                                        Blocks.OXEYE_DAISY.getDefaultState(),
                                                        Blocks.LILY_OF_THE_VALLEY.getDefaultState(),
                                                        Blocks.LILAC.getDefaultState(),
                                                        Blocks.PEONY.getDefaultState(),
                                                        Blocks.ROSE_BUSH.getDefaultState()
                                                )
                                        )
                                )
                        )
                )
        );
        register(context, FALLEN_CHERRY_TREE, Feature.FALLEN_TREE,
                new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.CHERRY_LOG), UniformIntProvider.create(5, 8))
                        .logDecorators(
                                ImmutableList.of(
                                        new AttachedToLogsTreeDecorator(
                                                0.1F,
                                                new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 2).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)),
                                                List.of(Direction.UP)
                                        )
                                )
                        ).build());

        ModConfiguredFeatures.register(context, TREES_CHERRY_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
                new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.FALLEN_CHERRY_TREE_PLACED_KEY), 0.00625F)
            ), context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(TreePlacedFeatures.CHERRY_BEES_005)
        ));

        register(context,
                OLD_GROWTH_BIRCH_VIOLET_KEY,
                Feature.FLOWER,
                new RandomPatchFeatureConfig(64, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(flowerbed(ModFloraBlocks.VIOLET)))))
        );

        register(context,
                BIRCH_FOREST_CLOVER_KEY,
                Feature.FLOWER,
                new RandomPatchFeatureConfig(64, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(denseFlowerbed(ModFloraBlocks.CLOVER)))))
        );

        register(context,
                OLD_GROWTH_BIRCH_MOSS_CARPET_KEY,
                Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(
                        new WeightedBlockStateProvider(
                                Pool.<BlockState>builder()
                                        .add(Blocks.MOSS_CARPET.getDefaultState(), 25)
                                        .add(Blocks.SHORT_GRASS.getDefaultState(), 25)
                                        .add(Blocks.BUSH.getDefaultState(), 15)
                                        .add(Blocks.TALL_GRASS.getDefaultState(), 10)
                        )
                )
        );

        register(context,
                OLD_GROWTH_BIRCH_MOSS_BLOCK_KEY,
                Feature.VEGETATION_PATCH,
                new VegetationPatchFeatureConfig(
                        BlockTags.DIRT,
                        BlockStateProvider.of(Blocks.MOSS_BLOCK),
                        PlacedFeatures.createEntry(registryEntryLookup.getOrThrow(OLD_GROWTH_BIRCH_MOSS_CARPET_KEY)),
                        VerticalSurfaceType.FLOOR,
                        ConstantIntProvider.create(1),
                        0.0F,
                        5,
                        0.3F,
                        UniformIntProvider.create(2, 4),
                        0.75F
                )
        );

        PlaceOnGroundTreeDecorator placeOnGroundTreeDecorator = new PlaceOnGroundTreeDecorator(
                96, 4, 2, new WeightedBlockStateProvider(VegetationConfiguredFeatures.leafLitter(1, 3))
        );
        PlaceOnGroundTreeDecorator placeOnGroundTreeDecorator2 = new PlaceOnGroundTreeDecorator(
                150, 2, 2, new WeightedBlockStateProvider(VegetationConfiguredFeatures.leafLitter(1, 4))
        );

        register(context, SAPLING_BIRCH_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.BIRCH_LOG),
                        new NotchedTrunkPlacer(5, 2, 6),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(ImmutableList.of(new HangingMushroomTreeDecorator(0.1F))).build());

        register(context, SAPLING_BIRCH_BEES_005_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.BIRCH_LOG),
                        new NotchedTrunkPlacer(5, 2, 6),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(ImmutableList.of(new NotchedTrunkBeehiveTreeDecorator(0.05f), new HangingMushroomTreeDecorator(0.1F))).build());

        register(context, FOREST_BIRCH_LEAF_LITTER_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.BIRCH_LOG),
                        new NotchedTrunkPlacer(5, 2, 0),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(ImmutableList.of(new HangingMushroomTreeDecorator(0.05F), placeOnGroundTreeDecorator, placeOnGroundTreeDecorator2)).build());

        register(context, FOREST_BIRCH_BEES_0002_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.BIRCH_LOG),
                        new NotchedTrunkPlacer(5, 2, 0),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(ImmutableList.of(new NotchedTrunkBeehiveTreeDecorator(0.002f), new HangingMushroomTreeDecorator(0.05F))).build());

        register(context, FOREST_BIRCH_BEES_0002_LEAF_LITTER_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.BIRCH_LOG),
                        new NotchedTrunkPlacer(5, 2, 0),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(ImmutableList.of(new NotchedTrunkBeehiveTreeDecorator(0.002f), new HangingMushroomTreeDecorator(0.05F), placeOnGroundTreeDecorator, placeOnGroundTreeDecorator2)).build());

        register(context, FOREST_SUPER_BIRCH_BEES_0002_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.BIRCH_LOG),
                        new NotchedTrunkPlacer(5, 2, 6),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(ImmutableList.of(new NotchedTrunkBeehiveTreeDecorator(0.002f), new HangingMushroomTreeDecorator(0.05F))).build());

        register(context, FOREST_BIRCH_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.BIRCH_LOG),
                        new NotchedTrunkPlacer(5, 2, 0),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(ImmutableList.of(new HangingMushroomTreeDecorator(0.05F))).build());

        register(context, DRY_BIRCH_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.BIRCH_LOG),
                        new NotchedTrunkPlacer(5, 2, 0),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).build());

        register(context, OLD_GROWTH_SUPER_BIRCH_BEES_0002_KEY, Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.BIRCH_LOG),
                        new NotchedTrunkPlacer(9, 2, 2),
                        BlockStateProvider.of(Blocks.BIRCH_LEAVES),
                        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)
                ).decorators(ImmutableList.of(new NotchedTrunkBeehiveTreeDecorator(0.002f), new HangingMushroomTreeDecorator(0.2F))).build());

        register(context, MOSSY_FALLEN_SUPER_BIRCH_TREE_KEY, Feature.FALLEN_TREE,
                new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.BIRCH_LOG), UniformIntProvider.create(5, 11))
                        .logDecorators(
                                ImmutableList.of(
                                        new AttachedToLogsTreeDecorator(
                                                0.6F,
                                                new WeightedBlockStateProvider(Pool.<BlockState>builder()
                                                        .add(Blocks.MOSS_CARPET.getDefaultState(), 5)
                                                        .add(Blocks.RED_MUSHROOM.getDefaultState(), 1)
                                                        .add(Blocks.BROWN_MUSHROOM.getDefaultState(), 1)
                                                ),
                                                List.of(Direction.UP)
                                        )
                                )
                        )
                .build());

        /* SNOWY BIOMES */
        register(context,
                PATCH_SNOWY_GRASS,
                Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig2(BlockStateProvider.of(ModFloraBlocks.SNOWY_SHORT_GRASS), 32)
        );
        register(context,
                PATCH_SNOWY_GRASS_AND_FERNS,
                Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig2(new WeightedBlockStateProvider(Pool.<BlockState>builder().add(ModFloraBlocks.SNOWY_SHORT_GRASS.getDefaultState(), 1).add(ModFloraBlocks.SNOWY_FERN.getDefaultState(), 4)), 32)
        );
        register(context,
                FLOWER_SNOWY,
                Feature.FLOWER,
                createRandomPatchFeatureConfig2(
                        new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.CORNFLOWER.getDefaultState(), 2).add(Blocks.LILY_OF_THE_VALLEY.getDefaultState(), 1)), 64
                )
        );
        register(context,
                PATCH_SNOWY_BUSH,
                Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(24, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModFloraBlocks.SNOWY_BUSH))))
        );

        /* SAVANNA BIOME */
        register(context, FALLEN_ACACIA_TREE_KEY, Feature.FALLEN_TREE,
                new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.ACACIA_LOG), UniformIntProvider.create(6, 10)).build());
        register(context, DRY_FALLEN_BIRCH_TREE_KEY, Feature.FALLEN_TREE,
                new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.BIRCH_LOG), UniformIntProvider.create(5, 8)).build());

        /* JUNGLE BIOME */
        ConfiguredFeatures.register(context, FLOWER_JUNGLE_KEY, Feature.FLOWER,
                createRandomPatchFeatureConfig2(
                        new WeightedBlockStateProvider(Pool.<BlockState>builder().add(ModFloraBlocks.MONSTERA.getDefaultState(), 2).add(ModFloraBlocks.HELLEBORE.getDefaultState(), 1)), 64
                )
        );
        register(context, PATCH_GIANT_PADMA_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModFloraBlocks.GIANT_PADMA)), List.of(Blocks.GRASS_BLOCK)
                )
        );

        /* FLOWER BIOMES */
        register(context, FLOWERBED_MEADOW_KEY, Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfig(
                        RegistryEntryList.of(
                                PlacedFeatures.createEntry(
                                        Feature.RANDOM_PATCH,
                                        ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(flowerbed(Blocks.WILDFLOWERS))))
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.RANDOM_PATCH,
                                        ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(flowerbed(ModFloraBlocks.VIOLET))))
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.RANDOM_PATCH,
                                        ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(flowerbed(ModFloraBlocks.FORGET_ME_NOT))))
                                ),
                                PlacedFeatures.createEntry(
                                        Feature.RANDOM_PATCH,
                                        ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(flowerbed(ModFloraBlocks.CLOVER))))
                                )
                        )
                    )
        );

        /* PLAINS BIOME */
        ConfiguredFeatures.register(context, CLOVER_PLAINS_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        128, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(denseFlowerbed(ModFloraBlocks.CLOVER))))
                )
        );

        /* DESERT BIOME */
        ConfiguredFeatures.register(context, PATCH_SMALL_CACTUS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(24, 5, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModFloraBlocks.SMALL_CACTUS))))
        );
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(CombinedWorldgen.MOD_ID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                  RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
