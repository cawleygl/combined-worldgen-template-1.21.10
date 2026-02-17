package bluesteel42.combinedworldgen.wood.petrified.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.petrified.PetrifiedWoodInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.util.math.Direction;

public class PetrifiedWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.register(PetrifiedWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? PetrifiedWoodInitializer.MOD_FIBER_COLOR : PetrifiedWoodInitializer.MOD_BARK_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
    );
    public static final Block MOD_WOOD = ModBlocks.register(PetrifiedWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_BARK_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
    );
    public static final Block STRIPPED_MOD_LOG = ModBlocks.register("stripped_" + PetrifiedWoodInitializer.MOD_WOOD_NAME + "_log", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
    );
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.register("stripped_" + PetrifiedWoodInitializer.MOD_WOOD_NAME + "_wood", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
    );
    public static final Block MOD_PLANKS = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS)
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_button",
            settings -> new ButtonBlock(PetrifiedWoodInitializer.MOD_BLOCK_SET, 20, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_pressure_plate",
            settings -> new PressurePlateBlock(PetrifiedWoodInitializer.MOD_BLOCK_SET, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
    );
    public static final Block MOD_FENCE = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
    );
    public static final Block MOD_FENCE_GATE = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_fence_gate",
            settings -> new FenceGateBlock(PetrifiedWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_door",
            settings -> new DoorBlock(PetrifiedWoodInitializer.MOD_BLOCK_SET, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3.0F, 6.0F)
                    .requiresTool()
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block MOD_TRAPDOOR = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_trapdoor",
            settings -> new TrapdoorBlock(PetrifiedWoodInitializer.MOD_BLOCK_SET, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .strength(3.0F, 6.0F)
                    .requiresTool()
                    .nonOpaque()
                    .allowsSpawning(Blocks::never),
            true,
            true
    );
    public static final Block MOD_STANDING_SIGN = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_sign",
            settings -> new SignBlock(PetrifiedWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .noCollision()
                    .strength(1.0F),
            false,
            false
    );
    public static final Block MOD_WALL_SIGN = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_wall_sign",
            settings -> new WallSignBlock(PetrifiedWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .noCollision()
                    .strength(1.0F)
                    .lootTable(MOD_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_STANDING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_HANGING_SIGN = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_hanging_sign",
            settings -> new HangingSignBlock(PetrifiedWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .noCollision()
                    .strength(1.0F),
            false,
            false
    );
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_wall_hanging_sign",
            settings -> new WallHangingSignBlock(PetrifiedWoodInitializer.MOD_WOOD_TYPE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .noCollision()
                    .strength(1.0F).lootTable(MOD_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(MOD_HANGING_SIGN.getTranslationKey()),
            false,
            false
    );
    public static final Block MOD_SHELF = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_NAME + "_shelf",
            ShelfBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND)
                    .strength(2.0F, 6.0F)
    );

    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerNaturalBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_WOOD);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.POINTED_DRIPSTONE, PetrifiedWoodModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.WARPED_SHELF, PetrifiedWoodModBlocks.MOD_SHELF);
                });
    }
}
