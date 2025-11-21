package bluesteel42.combinedworldgen.block.flora;

import bluesteel42.combinedworldgen.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

import static net.minecraft.block.Blocks.createFlowerPotSettings;

public class ModFloraBlocks {

    /* NEW VANILLA POTTED PLANTS */
    public static final Block POTTED_CACTUS_FLOWER = ModBlocks.register(
            "potted_cactus_flower",
            settings -> new FlowerPotBlock(Blocks.CACTUS_FLOWER, settings),
            Blocks.createFlowerPotSettings(),
            false,
            true
    );
    public static final Block POTTED_ROSE = ModBlocks.register(
            "potted_rose",
            settings -> new FlowerPotBlock(Blocks.ROSE_BUSH, settings),
            Blocks.createFlowerPotSettings(),
            false,
            true
    );
    public static final Block POTTED_PEONY = ModBlocks.register(
            "potted_peony",
            settings -> new FlowerPotBlock(Blocks.PEONY, settings),
            Blocks.createFlowerPotSettings(),
            false,
            true
    );
    public static final Block POTTED_LILAC = ModBlocks.register(
            "potted_lilac",
            settings -> new FlowerPotBlock(Blocks.LILAC, settings),
            Blocks.createFlowerPotSettings(),
            false,
            true
    );
    public static final Block POTTED_SUNFLOWER = ModBlocks.register(
            "potted_sunflower",
            settings -> new FlowerPotBlock(Blocks.SUNFLOWER, settings),
            Blocks.createFlowerPotSettings(),
            false,
            true
    );
    public static final Block POTTED_MONSTERA = ModBlocks.register(
            "potted_monstera",
            settings -> new FlowerPotBlock(ModFloraBlocks.MONSTERA, settings),
            Blocks.createFlowerPotSettings(),
            false,
            true
    );
    public static final Block POTTED_SUGAR_CANE = ModBlocks.register(
            "potted_sugar_cane",
            settings -> new FlowerPotBlock(Blocks.SUGAR_CANE, settings),
            Blocks.createFlowerPotSettings(),
            false,
            true
    );


    /* BIRCH BIOMES */
    public static final Block TRUNK_ATTACHED_BROWN_MUSHROOM = ModBlocks.register(
            "trunk_attached_brown_mushroom",
            TrunkAttachedMushroomBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BROWN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .luminance(state -> 1)
                    .postProcess(Blocks::always)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );

    /* NEW FLOWERS */
    public static final Block YELLOW_TULIP = ModBlocks.register("yellow_tulip", settings -> new FlowerBlock(StatusEffects.WEAKNESS, 7.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block POTTED_YELLOW_TULIP = ModBlocks.register("potted_yellow_tulip", settings -> new FlowerPotBlock(ModFloraBlocks.YELLOW_TULIP, settings), createFlowerPotSettings(), true, true);

    public static final Block PURPLE_TULIP = ModBlocks.register("purple_tulip", settings -> new FlowerBlock(StatusEffects.WEAKNESS, 7.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block POTTED_PURPLE_TULIP = ModBlocks.register("potted_purple_tulip", settings -> new FlowerPotBlock(ModFloraBlocks.PURPLE_TULIP, settings), createFlowerPotSettings(), true, true);

    public static final Block HELLEBORE = ModBlocks.register("hellebore", settings -> new FlowerBlock(StatusEffects.POISON, 11.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block POTTED_HELLEBORE = ModBlocks.register("potted_hellebore", settings -> new FlowerPotBlock(ModFloraBlocks.HELLEBORE, settings), createFlowerPotSettings(), true, true);

    public static final Block GIANT_PADMA = ModBlocks.register("giant_padma", settings -> new GiantPadmaBlock(StatusEffects.HASTE, 10.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.BROWN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);

    public static final Block VIOLET = ModBlocks.register("violet", FlowerbedBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().sounds(BlockSoundGroup.FLOWERBED).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block CLOVER = ModBlocks.register("clover", FlowerbedBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().sounds(BlockSoundGroup.FLOWERBED).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block FORGET_ME_NOT = ModBlocks.register("forget_me_not", FlowerbedBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().sounds(BlockSoundGroup.FLOWERBED).pistonBehavior(PistonBehavior.DESTROY), true, true);

    public static final Block MONSTERA = ModBlocks.register("monstera", TallFlowerBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );

    /* MOOBLOOM BACK FLOWERS */
    public static final Block SMALL_ROSE = ModBlocks.register("small_rose",settings -> new FlowerBlock(StatusEffects.STRENGTH, 0.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block SMALL_LILAC = ModBlocks.register("small_lilac",settings -> new FlowerBlock(StatusEffects.STRENGTH, 0.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block SMALL_PEONY = ModBlocks.register("small_peony",settings -> new FlowerBlock(StatusEffects.STRENGTH, 0.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block SMALL_SUNFLOWER = ModBlocks.register("small_sunflower",settings -> new FlowerBlock(StatusEffects.STRENGTH, 0.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block SMALL_PITCHER_PLANT = ModBlocks.register("small_pitcher_plant",settings -> new FlowerBlock(StatusEffects.STRENGTH, 0.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);
    public static final Block SMALL_MONSTERA = ModBlocks.register("small_monstera",settings -> new FlowerBlock(StatusEffects.STRENGTH, 0.0F, settings), AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY), true, true);

    /* SWAMP BIOME */
    public static final Block WHITE_WATER_LILY = ModBlocks.register("white_water_lily", WaterLilyBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .breakInstantly()
                    .sounds(BlockSoundGroup.LILY_PAD)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY),
            false,
            true
    );
    public static final Block PINK_WATER_LILY = ModBlocks.register("pink_water_lily", WaterLilyBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PINK)
                    .breakInstantly()
                    .sounds(BlockSoundGroup.LILY_PAD)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY),
            false,
            true
    );    public static final Block BLUE_WATER_LILY = ModBlocks.register("blue_water_lily", WaterLilyBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLUE)
                    .breakInstantly()
                    .sounds(BlockSoundGroup.LILY_PAD)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY),
            false,
            true
    );    public static final Block PURPLE_WATER_LILY = ModBlocks.register("purple_water_lily", WaterLilyBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.PURPLE)
                    .breakInstantly()
                    .sounds(BlockSoundGroup.LILY_PAD)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY),
            false,
            true
    );

    /* SNOWY BIOMES */
    public static final Block SNOWY_SHORT_GRASS = ModBlocks.register(
            "snowy_short_grass",
            SnowyShortPlantBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block SNOWY_FERN = ModBlocks.register(
            "snowy_fern",
            SnowyShortPlantBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block POTTED_SNOWY_FERN = ModBlocks.register("potted_snowy_fern", settings -> new FlowerPotBlock(ModFloraBlocks.SNOWY_FERN, settings), createFlowerPotSettings(),true, true);
    public static final Block SNOWY_BUSH = ModBlocks.register(
            "snowy_bush",
            SnowyBushBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BROWN_MUSHROOM, ModFloraBlocks.TRUNK_ATTACHED_BROWN_MUSHROOM);
                    itemGroup.addBefore(Items.WILDFLOWERS, ModFloraBlocks.CLOVER);
                    itemGroup.addAfter(Items.WILDFLOWERS, ModFloraBlocks.VIOLET);
                    itemGroup.addAfter(Items.WILDFLOWERS, ModFloraBlocks.FORGET_ME_NOT);
                    itemGroup.addAfter(Items.LILY_PAD, ModFloraBlocks.BLUE_WATER_LILY);
                    itemGroup.addAfter(Items.LILY_PAD, ModFloraBlocks.PURPLE_WATER_LILY);
                    itemGroup.addAfter(Items.LILY_PAD, ModFloraBlocks.PINK_WATER_LILY);
                    itemGroup.addAfter(Items.LILY_PAD, ModFloraBlocks.WHITE_WATER_LILY);
                    itemGroup.addAfter(Items.PEONY, ModFloraBlocks.MONSTERA);
                    itemGroup.addAfter(Items.PINK_TULIP, ModFloraBlocks.PURPLE_TULIP);
                    itemGroup.addAfter(Items.PINK_TULIP, ModFloraBlocks.YELLOW_TULIP);
                    itemGroup.addAfter(Items.LILY_OF_THE_VALLEY, ModFloraBlocks.GIANT_PADMA);
                    itemGroup.addAfter(Items.LILY_OF_THE_VALLEY, ModFloraBlocks.HELLEBORE);
                    itemGroup.addAfter(Items.SHORT_GRASS, ModFloraBlocks.SNOWY_SHORT_GRASS);
                    itemGroup.addAfter(Items.FERN, ModFloraBlocks.SNOWY_FERN);
                    itemGroup.addAfter(Items.BUSH, ModFloraBlocks.SNOWY_BUSH);
                });
    }


}
