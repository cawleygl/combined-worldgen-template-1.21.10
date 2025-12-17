package bluesteel42.combinedworldgen.wood.azalea.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.azalea.AzaleaWoodInitializer;
import bluesteel42.combinedworldgen.wood.cholla.item.ChollaWoodModItems;
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

public class AzaleaWoodModBlocks {
    public static final Block MOD_BLOCK = ModBlocks.register(AzaleaWoodInitializer.MOD_WOOD_NAME + "_block", PillarBlock::new, Blocks.createLogSettings(AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_UNSTRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_BLOCK = ModBlocks.register("stripped_" + AzaleaWoodInitializer.MOD_WOOD_NAME + "_block", PillarBlock::new, Blocks.createLogSettings(AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_PLANKS = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(AzaleaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_MOSAIC = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_mosaic",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(AzaleaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_MOSAIC_STAIRS = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_mosaic_stairs",
            settings -> new StairsBlock(MOD_MOSAIC.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_MOSAIC),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(AzaleaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_MOSAIC_SLAB = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_mosaic_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(AzaleaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(BlockSetType.BAMBOO, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR)
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
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(AzaleaWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(AzaleaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.BAMBOO, settings),
            AbstractBlock.Settings.create()
                    .mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );

    public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(AzaleaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_SIGN).mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(AzaleaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_SIGN).mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(AzaleaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_HANGING_SIGN).mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(AzaleaWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.BAMBOO_HANGING_SIGN).mapColor(AzaleaWoodInitializer.MOD_STRIPPED_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_SHELF = ModBlocks.register(
            AzaleaWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F),
            true,
            false
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = BlockFamilies.register(AzaleaWoodModBlocks.MOD_PLANKS)
            .button(AzaleaWoodModBlocks.MOD_BUTTON)
            .mosaic(AzaleaWoodModBlocks.MOD_MOSAIC)
            .door(AzaleaWoodModBlocks.MOD_DOOR)
            .customFence(AzaleaWoodModBlocks.MOD_FENCE)
            .customFenceGate(AzaleaWoodModBlocks.MOD_FENCE_GATE)
            .sign(AzaleaWoodModBlocks.MOD_STANDING_SIGN, AzaleaWoodModBlocks.MOD_WALL_SIGN)
            .slab(AzaleaWoodModBlocks.MOD_SLAB)
            .stairs(AzaleaWoodModBlocks.MOD_STAIRS)
            .pressurePlate(AzaleaWoodModBlocks.MOD_PRESSURE_PLATE)
            .trapdoor(AzaleaWoodModBlocks.MOD_TRAPDOOR)
            .group("wooden").unlockCriterionName("has_planks").build();

    /* ADDITIONAL BLOCKS */
    public static final Block AZALEA_STEM = ModBlocks.register(
            "azalea_stem",
            AzaleaStemBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .nonOpaque()
                    .burnable(),
            true,
            false

    );
    public static final Block LEAFY_AZALEA_STEM = ModBlocks.register(
            "leafy_azalea_stem",
            settings -> new LeafyAzaleaStemBlock(0.01F, TintedParticleEffect.create(ParticleTypes.TINTED_LEAVES, -9399763), settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .nonOpaque()
                    .burnable(),
            true,
            true
    );
    public static final Block STRIPPED_AZALEA_STEM = ModBlocks.register(
            "stripped_azalea_stem",
            AzaleaStemBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .burnable(),
            true,
            false
    );
    public static final Block POTTED_AZALEA_STEM = ModBlocks.register(
            "potted_azalea_stem",
            settings -> new FlowerPotBlock(AzaleaWoodModBlocks.AZALEA_STEM, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );
    public static final Block POTTED_STRIPPED_AZALEA_STEM = ModBlocks.register(
            "potted_stripped_azalea_stem",
            settings -> new FlowerPotBlock(AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );


    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_MOSAIC_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_MOSAIC_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_MOSAIC);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, AzaleaWoodModBlocks.MOD_BLOCK);
                });
        /* ADDITIONAL BLOCKS */
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO, AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM);
                    itemGroup.addAfter(Items.BAMBOO, AzaleaWoodModBlocks.LEAFY_AZALEA_STEM);
                    itemGroup.addAfter(Items.BAMBOO, AzaleaWoodModBlocks.AZALEA_STEM);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_SHELF, AzaleaWoodModBlocks.MOD_SHELF);
                });
    }
}
