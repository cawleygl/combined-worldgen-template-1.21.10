package bluesteel42.combinedworldgen.wood.cholla.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.cholla.ChollaWoodInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class ChollaWoodModBlocks {
    public static final Block MOD_BLOCK = ModBlocks.register(ChollaWoodInitializer.MOD_WOOD_NAME + "_block", PillarBlock::new, Blocks.createLogSettings(ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_UNSTRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_BLOCK = ModBlocks.register("stripped_" + ChollaWoodInitializer.MOD_WOOD_NAME + "_block", PillarBlock::new, Blocks.createLogSettings(ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_PLANKS = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChollaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_MOSAIC = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_mosaic",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChollaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_MOSAIC_STAIRS = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_mosaic_stairs",
            settings -> new StairsBlock(MOD_MOSAIC.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_MOSAIC),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChollaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_MOSAIC_SLAB = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_mosaic_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChollaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(BlockSetType.BAMBOO, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(0.5F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_FENCE = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChollaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(ChollaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );

     public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(ChollaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_SIGN).mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(ChollaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_SIGN).mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(ChollaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_HANGING_SIGN).mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(ChollaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_HANGING_SIGN).mapColor(ChollaWoodInitializer.MOD_STRIPPED_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_SHELF = ModBlocks.register(
            ChollaWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F),
            true,
            false
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = BlockFamilies.register(ChollaWoodModBlocks.MOD_PLANKS)
            .button(ChollaWoodModBlocks.MOD_BUTTON)
            .mosaic(ChollaWoodModBlocks.MOD_MOSAIC)
            .door(ChollaWoodModBlocks.MOD_DOOR)
            .fence(ChollaWoodModBlocks.MOD_FENCE)
            .fenceGate(ChollaWoodModBlocks.MOD_FENCE_GATE)
            .sign(ChollaWoodModBlocks.MOD_STANDING_SIGN, ChollaWoodModBlocks.MOD_WALL_SIGN)
            .slab(ChollaWoodModBlocks.MOD_SLAB)
            .stairs(ChollaWoodModBlocks.MOD_STAIRS)
            .pressurePlate(ChollaWoodModBlocks.MOD_PRESSURE_PLATE)
            .trapdoor(ChollaWoodModBlocks.MOD_TRAPDOOR)
            .group("wooden").unlockCriterionName("has_planks").build();

    /* ADDITIONAL BLOCKS */
    public static final Block DRIED_CHOLLA = ModBlocks.register(
            "dried_" + ChollaWoodInitializer.MOD_WOOD_NAME,
            DriedChollaBlock::new,
            Blocks.createLogSettings(ChollaWoodInitializer.MOD_UNSTRIPPED_COLOR, ChollaWoodInitializer.MOD_UNSTRIPPED_COLOR, BlockSoundGroup.BAMBOO_WOOD),
            true,
            false
    );
    public static final Block POTTED_DRIED_CHOLLA = ModBlocks.register(
            "potted_dried_" + ChollaWoodInitializer.MOD_WOOD_NAME,
            settings -> new FlowerPotBlock(DRIED_CHOLLA, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_MOSAIC_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_MOSAIC_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_MOSAIC);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.STRIPPED_MOD_BLOCK);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_BLOCK);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.CACTUS, ChollaWoodModBlocks.DRIED_CHOLLA);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_SHELF, ChollaWoodModBlocks.MOD_SHELF);
                });
    }
}
