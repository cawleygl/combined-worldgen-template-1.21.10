package bluesteel42.combinedworldgen.wood.citrus.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.citrus.CitrusWoodInitializer;
import bluesteel42.combinedworldgen.wood.citrus.item.CitrusWoodModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class CitrusWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.register(CitrusWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BARK_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_WOOD = ModBlocks.register(CitrusWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(CitrusWoodInitializer.MOD_BARK_COLOR, CitrusWoodInitializer.MOD_BARK_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.register("stripped_" + CitrusWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.register("stripped_" + CitrusWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_PLANKS = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(CitrusWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(CitrusWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(CitrusWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(CitrusWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR)
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
            CitrusWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(CitrusWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(CitrusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(CitrusWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(CitrusWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );

    public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(CitrusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(CitrusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(CitrusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(CitrusWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(CitrusWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_SHELF = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F),
            true,
            false
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = BlockFamilies.register(CitrusWoodModBlocks.MOD_PLANKS)
            .button(CitrusWoodModBlocks.MOD_BUTTON)
            .door(CitrusWoodModBlocks.MOD_DOOR)
            .fence(CitrusWoodModBlocks.MOD_FENCE)
            .fenceGate(CitrusWoodModBlocks.MOD_FENCE_GATE)
            .sign(CitrusWoodModBlocks.MOD_STANDING_SIGN, CitrusWoodModBlocks.MOD_WALL_SIGN)
            .slab(CitrusWoodModBlocks.MOD_SLAB)
            .stairs(CitrusWoodModBlocks.MOD_STAIRS)
            .pressurePlate(CitrusWoodModBlocks.MOD_PRESSURE_PLATE)
            .trapdoor(CitrusWoodModBlocks.MOD_TRAPDOOR)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block MOD_LEAVES = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_leaves",
            settings -> new TintedParticleLeavesBlock(0.01F, settings),
            AbstractBlock.Settings.create()
                    .mapColor(CitrusWoodInitializer.MOD_LEAF_COLOR)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(CitrusWoodInitializer.MOD_LEAF_SOUND)
                    .nonOpaque()
                    .allowsSpawning(Blocks::canSpawnOnLeaves)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .solidBlock(Blocks::never),
            true,
            true
    );
    public static final Block MOD_SAPLING = ModBlocks.register(
            CitrusWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new SaplingBlock(CitrusWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, settings),
            AbstractBlock.Settings.copy(CitrusWoodInitializer.MOD_LEAF_SOUND == BlockSoundGroup.CHERRY_LEAVES ? Blocks.CHERRY_SAPLING : Blocks.OAK_SAPLING),
            true,
            true
    );
    public static final Block POTTED_MOD_SAPLING = ModBlocks.register(
            "potted_" + CitrusWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new FlowerPotBlock(MOD_SAPLING, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    /* ADDITIONAL BLOCKS */
    public static final Block FLOWERING_ORANGE_LEAVES = ModBlocks.register(
            "flowering_orange_leaves",
            settings -> new FloweringOrangeLeavesBlock(0.01F, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS),
            true,
            true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_WOOD);
                    itemGroup.addAfter(Items.JUNGLE_BUTTON, CitrusWoodModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.JUNGLE_LOG, CitrusWoodModBlocks.MOD_LOG);
                    itemGroup.addAfter(Items.JUNGLE_LEAVES, CitrusWoodModBlocks.MOD_LEAVES);
                    itemGroup.addAfter(Items.JUNGLE_SAPLING, CitrusWoodModBlocks.MOD_SAPLING);
                    /* ADDITIONAL BLOCKS */
                    itemGroup.addAfter(CitrusWoodModBlocks.MOD_LEAVES, CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.JUNGLE_SHELF, CitrusWoodModBlocks.MOD_SHELF);
                });
    }
}
