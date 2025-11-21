package bluesteel42.combinedworldgen.wood.baobab.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.baobab.BaobabWoodInitializer;
import bluesteel42.combinedworldgen.wood.baobab.item.BaobabWoodModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class BaobabWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.register(BaobabWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BARK_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_WOOD = ModBlocks.register(BaobabWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(BaobabWoodInitializer.MOD_BARK_COLOR, BaobabWoodInitializer.MOD_BARK_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.register("stripped_" + BaobabWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.register("stripped_" + BaobabWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_PLANKS = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BaobabWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BaobabWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(BaobabWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(BaobabWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR)
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
            BaobabWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BaobabWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(BaobabWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(BaobabWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(BaobabWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );

    public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(BaobabWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR),
               false,
               false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(BaobabWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(BaobabWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR),
            false,
            false

    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(BaobabWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(BaobabWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_SHELF = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F),
            true,
            false
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = BlockFamilies.register(BaobabWoodModBlocks.MOD_PLANKS)
            .button(BaobabWoodModBlocks.MOD_BUTTON)
            .door(BaobabWoodModBlocks.MOD_DOOR)
            .fence(BaobabWoodModBlocks.MOD_FENCE)
            .fenceGate(BaobabWoodModBlocks.MOD_FENCE_GATE)
            .sign(BaobabWoodModBlocks.MOD_STANDING_SIGN, BaobabWoodModBlocks.MOD_WALL_SIGN)
            .slab(BaobabWoodModBlocks.MOD_SLAB)
            .stairs(BaobabWoodModBlocks.MOD_STAIRS)
            .pressurePlate(BaobabWoodModBlocks.MOD_PRESSURE_PLATE)
            .trapdoor(BaobabWoodModBlocks.MOD_TRAPDOOR)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block MOD_LEAVES = ModBlocks.register(
            BaobabWoodInitializer.MOD_WOOD_NAME + "_leaves",
            settings -> new TintedParticleLeavesBlock(0.01F, settings),
            AbstractBlock.Settings.create()
                    .mapColor(BaobabWoodInitializer.MOD_LEAF_COLOR)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BaobabWoodInitializer.MOD_LEAF_SOUND)
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
            BaobabWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new SaplingBlock(BaobabWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, settings),
            AbstractBlock.Settings.copy(BaobabWoodInitializer.MOD_LEAF_SOUND == BlockSoundGroup.CHERRY_LEAVES ? Blocks.CHERRY_SAPLING : Blocks.OAK_SAPLING),
            true,
            true
    );
    public static final Block POTTED_MOD_SAPLING = ModBlocks.register(
            "potted_" + BaobabWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new FlowerPotBlock(MOD_SAPLING, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_WOOD);
                    itemGroup.addAfter(Items.ACACIA_BUTTON, BaobabWoodModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.ACACIA_LOG, BaobabWoodModBlocks.MOD_LOG);
                    itemGroup.addAfter(Items.ACACIA_LEAVES, BaobabWoodModBlocks.MOD_LEAVES);
                    itemGroup.addAfter(Items.ACACIA_SAPLING, BaobabWoodModBlocks.MOD_SAPLING);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.ACACIA_SHELF, BaobabWoodModBlocks.MOD_SHELF);
                });
    }
}
