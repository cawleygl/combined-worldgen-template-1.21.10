package bluesteel42.combinedworldgen.wood.maple.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import bluesteel42.combinedworldgen.wood.maple.item.MapleWoodModSaplingGenerators;
import bluesteel42.combinedworldgen.wood.maple.particle.MapleWoodModParticles;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class MapleWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.register(MapleWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BARK_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_WOOD = ModBlocks.register(MapleWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(MapleWoodInitializer.MOD_BARK_COLOR, MapleWoodInitializer.MOD_BARK_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.register("stripped_" + MapleWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.register("stripped_" + MapleWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_PLANKS = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapleWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(MapleWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapleWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(MapleWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(MapleWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(MapleWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapleWoodInitializer.MOD_FIBER_COLOR)
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
            MapleWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapleWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(MapleWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(MapleWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapleWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(MapleWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapleWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(MapleWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapleWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );
    
    public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(MapleWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(MapleWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(MapleWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(MapleWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(MapleWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapleWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(MapleWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapleWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_SHELF = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F),
            true,
            false
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = BlockFamilies.register(MapleWoodModBlocks.MOD_PLANKS)
            .button(MapleWoodModBlocks.MOD_BUTTON)
            .door(MapleWoodModBlocks.MOD_DOOR)
            .fence(MapleWoodModBlocks.MOD_FENCE)
            .fenceGate(MapleWoodModBlocks.MOD_FENCE_GATE)
            .sign(MapleWoodModBlocks.MOD_STANDING_SIGN, MapleWoodModBlocks.MOD_WALL_SIGN)
            .slab(MapleWoodModBlocks.MOD_SLAB)
            .stairs(MapleWoodModBlocks.MOD_STAIRS)
            .pressurePlate(MapleWoodModBlocks.MOD_PRESSURE_PLATE)
            .trapdoor(MapleWoodModBlocks.MOD_TRAPDOOR)
            .group("wooden").unlockCriterionName("has_planks").build();

    /* Custom Particles */
    public static final Block MOD_LEAVES = ModBlocks.register(
            MapleWoodInitializer.MOD_WOOD_NAME + "_leaves",
            settings -> new TintedParticleMapleLeavesBlock(0.01F, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapleWoodInitializer.MOD_LEAF_COLOR)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(MapleWoodInitializer.MOD_LEAF_SOUND)
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
            MapleWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new SaplingBlock(MapleWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, settings),
            AbstractBlock.Settings.copy(MapleWoodInitializer.MOD_LEAF_SOUND == BlockSoundGroup.CHERRY_LEAVES ? Blocks.CHERRY_SAPLING : Blocks.OAK_SAPLING),
            true,
            true
    );
    public static final Block POTTED_MOD_SAPLING = ModBlocks.register(
            "potted_" + MapleWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new FlowerPotBlock(MOD_SAPLING, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    /* ADDITIONAL BLOCKS */
    public static final Block RED_MAPLE_LEAVES = ModBlocks.register(
            "red_" + MapleWoodInitializer.MOD_WOOD_NAME + "_leaves",
            settings -> new UntintedParticleLeavesBlock(0.01F, MapleWoodModParticles.RED_MAPLE_LEAVES, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS), true, true
    );
    public static final Block YELLOW_MAPLE_LEAVES = ModBlocks.register(
            "yellow_" + MapleWoodInitializer.MOD_WOOD_NAME + "_leaves",
            settings -> new UntintedParticleLeavesBlock(0.01F, MapleWoodModParticles.YELLOW_MAPLE_LEAVES, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS), true, true
    );
    public static final Block MIXED_MAPLE_LEAVES = ModBlocks.register(
            "mixed_" + MapleWoodInitializer.MOD_WOOD_NAME + "_leaves",
            settings -> new MixedParticleMapleLeavesBlock(0.01F, MapleWoodModParticles.RED_MAPLE_LEAVES, MapleWoodModParticles.YELLOW_MAPLE_LEAVES, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS), true, true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_WOOD);
                    itemGroup.addAfter(Items.OAK_BUTTON, MapleWoodModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.OAK_LOG, MapleWoodModBlocks.MOD_LOG);
                    itemGroup.addAfter(Items.OAK_LEAVES, MapleWoodModBlocks.MOD_LEAVES);
                    itemGroup.addAfter(Items.OAK_SAPLING, MapleWoodModBlocks.MOD_SAPLING);

                    /* ADDITIONAL BLOCKS */
                    itemGroup.addAfter(MapleWoodModBlocks.MOD_LEAVES, MapleWoodModBlocks.MIXED_MAPLE_LEAVES);
                    itemGroup.addAfter(MapleWoodModBlocks.MOD_LEAVES, MapleWoodModBlocks.RED_MAPLE_LEAVES);
                    itemGroup.addAfter(MapleWoodModBlocks.MOD_LEAVES, MapleWoodModBlocks.YELLOW_MAPLE_LEAVES);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.OAK_SHELF, MapleWoodModBlocks.MOD_SHELF);
                });
    }
}
