package bluesteel42.combinedworldgen.wood.chorus.block;

import bluesteel42.combinedworldgen.wood.chorus.ChorusWoodInitializer;
import bluesteel42.combinedworldgen.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.TintedParticleEffect;
import net.minecraft.sound.BlockSoundGroup;

public class ChorusWoodModBlocks {
    public static final Block MOD_BLOCK = ModBlocks.register(ChorusWoodInitializer.MOD_WOOD_NAME + "_block", PillarBlock::new, Blocks.createLogSettings(ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_UNSTRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_BLOCK = ModBlocks.register("stripped_" + ChorusWoodInitializer.MOD_WOOD_NAME + "_block", PillarBlock::new, Blocks.createLogSettings(ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_PLANKS = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChorusWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_MOSAIC = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_mosaic",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChorusWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_MOSAIC_STAIRS = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_mosaic_stairs",
            settings -> new StairsBlock(MOD_MOSAIC.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_MOSAIC),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChorusWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_MOSAIC_SLAB = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_mosaic_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChorusWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(BlockSetType.BAMBOO, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR)
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
            ChorusWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(ChorusWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(ChorusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );

    public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(ChorusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_SIGN).mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(ChorusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_SIGN).mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(ChorusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_HANGING_SIGN).mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(ChorusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_HANGING_SIGN).mapColor(ChorusWoodInitializer.MOD_STRIPPED_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_SHELF = ModBlocks.register(
            ChorusWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F),
            true,
            false
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = BlockFamilies.register(ChorusWoodModBlocks.MOD_PLANKS)
            .button(ChorusWoodModBlocks.MOD_BUTTON)
            .mosaic(ChorusWoodModBlocks.MOD_MOSAIC)
            .door(ChorusWoodModBlocks.MOD_DOOR)
            .customFence(ChorusWoodModBlocks.MOD_FENCE)
            .customFenceGate(ChorusWoodModBlocks.MOD_FENCE_GATE)
            .sign(ChorusWoodModBlocks.MOD_STANDING_SIGN, ChorusWoodModBlocks.MOD_WALL_SIGN)
            .slab(ChorusWoodModBlocks.MOD_SLAB)
            .stairs(ChorusWoodModBlocks.MOD_STAIRS)
            .pressurePlate(ChorusWoodModBlocks.MOD_PRESSURE_PLATE)
            .trapdoor(ChorusWoodModBlocks.MOD_TRAPDOOR)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_MOSAIC_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_MOSAIC_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_MOSAIC);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.STRIPPED_MOD_BLOCK);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_BLOCK);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_SHELF, ChorusWoodModBlocks.MOD_SHELF);
                });
    }
}
