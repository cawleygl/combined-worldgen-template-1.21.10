package bluesteel42.combinedworldgen.wood.dogwood.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.dogwood.DogwoodWoodInitializer;
import bluesteel42.combinedworldgen.wood.dogwood.item.DogwoodWoodModSaplingGenerators;
import bluesteel42.combinedworldgen.wood.dogwood.particle.DogwoodWoodModParticles;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class DogwoodWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.register(DogwoodWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BARK_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_WOOD = ModBlocks.register(DogwoodWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(DogwoodWoodInitializer.MOD_BARK_COLOR, DogwoodWoodInitializer.MOD_BARK_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.register("stripped_" + DogwoodWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.register("stripped_" + DogwoodWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_PLANKS = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(DogwoodWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(DogwoodWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(DogwoodWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(DogwoodWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR)
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
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(DogwoodWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(DogwoodWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(DogwoodWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(DogwoodWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );

    public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(DogwoodWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(DogwoodWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(DogwoodWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(DogwoodWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(DogwoodWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_SHELF = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F),
            true,
            true
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = BlockFamilies.register(DogwoodWoodModBlocks.MOD_PLANKS)
            .button(DogwoodWoodModBlocks.MOD_BUTTON)
            .door(DogwoodWoodModBlocks.MOD_DOOR)
            .fence(DogwoodWoodModBlocks.MOD_FENCE)
            .fenceGate(DogwoodWoodModBlocks.MOD_FENCE_GATE)
            .sign(DogwoodWoodModBlocks.MOD_STANDING_SIGN, DogwoodWoodModBlocks.MOD_WALL_SIGN)
            .slab(DogwoodWoodModBlocks.MOD_SLAB)
            .stairs(DogwoodWoodModBlocks.MOD_STAIRS)
            .pressurePlate(DogwoodWoodModBlocks.MOD_PRESSURE_PLATE)
            .trapdoor(DogwoodWoodModBlocks.MOD_TRAPDOOR)
            .group("wooden").unlockCriterionName("has_planks").build();

    // CUSTOM PARTICLES - FLOWER LEAVES
    public static final Block MOD_LEAVES = ModBlocks.register(
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_leaves",
            settings -> new UntintedParticleLeavesBlock(0.1F, DogwoodWoodModParticles.DOGWOOD_LEAVES, settings),
            AbstractBlock.Settings.create()
                    .mapColor(DogwoodWoodInitializer.MOD_LEAF_COLOR)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(DogwoodWoodInitializer.MOD_LEAF_SOUND)
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
            DogwoodWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new SaplingBlock(DogwoodWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, settings),
            AbstractBlock.Settings.copy(DogwoodWoodInitializer.MOD_LEAF_SOUND == BlockSoundGroup.CHERRY_LEAVES ? Blocks.CHERRY_SAPLING : Blocks.OAK_SAPLING),
            true,
            true
    );
    public static final Block POTTED_MOD_SAPLING = ModBlocks.register(
            "potted_" + DogwoodWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new FlowerPotBlock(MOD_SAPLING, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_WOOD);
                    itemGroup.addAfter(Items.DARK_OAK_BUTTON, DogwoodWoodModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.DARK_OAK_LOG, DogwoodWoodModBlocks.MOD_LOG);
                    itemGroup.addAfter(Items.DARK_OAK_LEAVES, DogwoodWoodModBlocks.MOD_LEAVES);
                    itemGroup.addAfter(Items.DARK_OAK_SAPLING, DogwoodWoodModBlocks.MOD_SAPLING);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.DARK_OAK_SHELF, DogwoodWoodModBlocks.MOD_SHELF);
                });
    }
}
