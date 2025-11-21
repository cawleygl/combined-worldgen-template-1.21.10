package bluesteel42.combinedworldgen.wood.kapok.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.kapok.KapokWoodInitializer;
import bluesteel42.combinedworldgen.wood.kapok.item.KapokWoodModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class KapokWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.register(KapokWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BARK_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_WOOD = ModBlocks.register(KapokWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(KapokWoodInitializer.MOD_BARK_COLOR, KapokWoodInitializer.MOD_BARK_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.register("stripped_" + KapokWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.register("stripped_" + KapokWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_PLANKS = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(KapokWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(KapokWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(KapokWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(KapokWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(KapokWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(KapokWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(KapokWoodInitializer.MOD_FIBER_COLOR)
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
            KapokWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(KapokWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(KapokWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(KapokWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(KapokWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(KapokWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(KapokWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(KapokWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(KapokWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );

    public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(KapokWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(KapokWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(KapokWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(KapokWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(KapokWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(KapokWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(KapokWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(KapokWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_SHELF = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F),
            true,
            false
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = BlockFamilies.register(KapokWoodModBlocks.MOD_PLANKS)
            .button(KapokWoodModBlocks.MOD_BUTTON)
            .door(KapokWoodModBlocks.MOD_DOOR)
            .fence(KapokWoodModBlocks.MOD_FENCE)
            .fenceGate(KapokWoodModBlocks.MOD_FENCE_GATE)
            .sign(KapokWoodModBlocks.MOD_STANDING_SIGN, KapokWoodModBlocks.MOD_WALL_SIGN)
            .slab(KapokWoodModBlocks.MOD_SLAB)
            .stairs(KapokWoodModBlocks.MOD_STAIRS)
            .pressurePlate(KapokWoodModBlocks.MOD_PRESSURE_PLATE)
            .trapdoor(KapokWoodModBlocks.MOD_TRAPDOOR)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block MOD_LEAVES = ModBlocks.register(
            KapokWoodInitializer.MOD_WOOD_NAME + "_leaves",
            settings -> new TintedParticleLeavesBlock(0.01F, settings),
            AbstractBlock.Settings.create()
                    .mapColor(KapokWoodInitializer.MOD_LEAF_COLOR)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(KapokWoodInitializer.MOD_LEAF_SOUND)
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

    /* USES VANILLA JUNGLE SAPLING */

    /* ADDITIONAL BLOCKS */
    public static final Block CACAO_LEAVES = ModBlocks.register(
            "cacao_leaves",
            settings -> new TintedParticleLeavesBlock(0.01F, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS),
            true,
            true
    );
    public static final Block CACAO_SAPLING = ModBlocks.register(
            "cacao_sapling",
            settings -> new SaplingBlock(KapokWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING),
            true,
            true
    );
    public static final Block POTTED_CACAO_SAPLING = ModBlocks.register(
            "potted_cacao_sapling",
            settings -> new FlowerPotBlock(CACAO_SAPLING, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_WOOD);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_PLANKS);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_STAIRS);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_SLAB);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_FENCE);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_DOOR);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_BUTTON);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.JUNGLE_LEAVES, KapokWoodModBlocks.MOD_LEAVES);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_LOG);

                    /* ADDITIONAL BLOCKS */
                    itemGroup.addAfter(Items.JUNGLE_LEAVES, KapokWoodModBlocks.CACAO_LEAVES);
                    itemGroup.addAfter(Items.JUNGLE_SAPLING, KapokWoodModBlocks.CACAO_SAPLING);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.JUNGLE_SHELF, KapokWoodModBlocks.MOD_SHELF);
                });
    }
}
