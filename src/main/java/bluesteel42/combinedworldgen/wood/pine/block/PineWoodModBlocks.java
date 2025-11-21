package bluesteel42.combinedworldgen.wood.pine.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.pine.PineWoodInitializer;
import bluesteel42.combinedworldgen.wood.pine.item.PineWoodModSaplingGenerators;
import bluesteel42.combinedworldgen.wood.pine.particle.PineWoodModParticles;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class PineWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.register(PineWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BARK_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_WOOD = ModBlocks.register(PineWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(PineWoodInitializer.MOD_BARK_COLOR, PineWoodInitializer.MOD_BARK_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.register("stripped_" + PineWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new, Blocks.createLogSettings(PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.register("stripped_" + PineWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new, Blocks.createLogSettings(PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND), true, false);
    public static final Block MOD_PLANKS = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(PineWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(PineWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PineWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(PineWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(PineWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(PineWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PineWoodInitializer.MOD_FIBER_COLOR)
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
            PineWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PineWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(PineWoodInitializer.MOD_BLOCK_SOUND)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(PineWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PineWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable(),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(PineWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PineWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(PineWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PineWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable(),
            true,
            true
    );
    
    public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(PineWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(PineWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(PineWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(PineWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(PineWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(PineWoodInitializer.MOD_FIBER_COLOR),
            false,
            false
    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(PineWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(PineWoodInitializer.MOD_FIBER_COLOR).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );

    public static final Block MOD_SHELF = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F),
            true,
            false
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = BlockFamilies.register(PineWoodModBlocks.MOD_PLANKS)
            .button(PineWoodModBlocks.MOD_BUTTON)
            .door(PineWoodModBlocks.MOD_DOOR)
            .fence(PineWoodModBlocks.MOD_FENCE)
            .fenceGate(PineWoodModBlocks.MOD_FENCE_GATE)
            .sign(PineWoodModBlocks.MOD_STANDING_SIGN, PineWoodModBlocks.MOD_WALL_SIGN)
            .slab(PineWoodModBlocks.MOD_SLAB)
            .stairs(PineWoodModBlocks.MOD_STAIRS)
            .pressurePlate(PineWoodModBlocks.MOD_PRESSURE_PLATE)
            .trapdoor(PineWoodModBlocks.MOD_TRAPDOOR)
            .group("wooden").unlockCriterionName("has_planks").build();

    // Custom Particles
    public static final Block MOD_LEAVES = ModBlocks.register(
            PineWoodInitializer.MOD_WOOD_NAME + "_leaves",
            settings -> new TintedParticlePineNeedleLeavesBlock(0.01F, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PineWoodInitializer.MOD_LEAF_COLOR)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(PineWoodInitializer.MOD_LEAF_SOUND)
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
            PineWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new SaplingBlock(PineWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, settings),
            AbstractBlock.Settings.copy(PineWoodInitializer.MOD_LEAF_SOUND == BlockSoundGroup.CHERRY_LEAVES ? Blocks.CHERRY_SAPLING : Blocks.OAK_SAPLING),
            true,
            true
    );
    public static final Block POTTED_MOD_SAPLING = ModBlocks.register(
            "potted_" + PineWoodInitializer.MOD_WOOD_NAME + "_sapling",
            settings -> new FlowerPotBlock(MOD_SAPLING, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    /* ADDITIONAL BLOCKS */
    public static final Block SPRUCE_LEAVES_FALLING_NEEDLES = ModBlocks.register(
            "spruce_leaves",
            settings -> new TintedParticleSpruceNeedleLeavesBlock(0.01F, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS),true,true
    );
    public static final Block SNOWY_SPRUCE_LEAVES = ModBlocks.register(
            "snowy_spruce_leaves",
            settings -> new SnowySpruceLeavesBlock(0.01F, PineWoodModParticles.SNOWY_SPRUCE_NEEDLES, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
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
    public static final Block SNOWY_PINE_LEAVES = ModBlocks.register(
            "snowy_pine_leaves",
            settings -> new SnowyPineLeavesBlock(0.01F, PineWoodModParticles.SNOWY_PINE_NEEDLES, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
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
    public static final Block SNOWY_PINE_SAPLING = ModBlocks.register(
            "snowy_pine_sapling",
            settings -> new SnowyPineSaplingBlock(PineWoodModSaplingGenerators.SNOWY_PINE_SAPLING_GENERATOR, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING),
            true,
            true
    );
    public static final Block POTTED_SNOWY_PINE_SAPLING = ModBlocks.register(
            "potted_snowy_pine_sapling",
            settings -> new FlowerPotBlock(SNOWY_PINE_SAPLING, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );
    public static final Block SNOWY_SPRUCE_SAPLING = ModBlocks.register(
            "snowy_spruce_sapling",
            settings -> new SnowySpruceSaplingBlock(PineWoodModSaplingGenerators.SNOWY_SPRUCE_SAPLING_GENERATOR, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING),
            true,
            true
    );
    public static final Block POTTED_SNOWY_SPRUCE_SAPLING = ModBlocks.register(
            "potted_snowy_spruce_sapling",
            settings -> new FlowerPotBlock(SNOWY_SPRUCE_SAPLING, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_WOOD);
                    itemGroup.addAfter(Items.SPRUCE_BUTTON, PineWoodModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.SPRUCE_LOG, PineWoodModBlocks.MOD_LOG);
                    itemGroup.addAfter(Items.SPRUCE_LEAVES, PineWoodModBlocks.MOD_LEAVES);
                    itemGroup.addAfter(Items.SPRUCE_SAPLING, PineWoodModBlocks.MOD_SAPLING);

                    /* ADDITIONAL BLOCKS */
                    itemGroup.addAfter(PineWoodModBlocks.MOD_LEAVES, PineWoodModBlocks.SNOWY_PINE_LEAVES);
                    itemGroup.addAfter(Items.SPRUCE_LEAVES, PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES);
                    itemGroup.addAfter(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, PineWoodModBlocks.SNOWY_SPRUCE_LEAVES);
                    itemGroup.addAfter(PineWoodModBlocks.MOD_SAPLING, PineWoodModBlocks.SNOWY_PINE_SAPLING);
                    itemGroup.addAfter(Items.SPRUCE_SAPLING, PineWoodModBlocks.SNOWY_SPRUCE_SAPLING);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.SPRUCE_SHELF, PineWoodModBlocks.MOD_SHELF);
                });
    }
}
