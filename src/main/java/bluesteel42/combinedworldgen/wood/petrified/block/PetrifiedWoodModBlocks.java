package bluesteel42.combinedworldgen.wood.petrified.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.petrified.PetrifiedWoodInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.util.math.Direction;

public class PetrifiedWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.register(PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_log", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? PetrifiedWoodInitializer.MOD_FIBER_COLOR : PetrifiedWoodInitializer.MOD_BARK_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND),
            true,
            false
    );
    public static final Block MOD_WOOD = ModBlocks.register(PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_wood", PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_BARK_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND),
            true,
            false
    );
    public static final Block MOD_PLANKS = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND),
            true,
            false
    );
    public static final Block MOD_STAIRS = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_stairs",
            settings -> new StairsBlock(MOD_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(MOD_PLANKS),
            true,
            false
    );
    public static final Block MOD_SLAB = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND),
            true,
            false
    );
    public static final Block MOD_BUTTON = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_button",
            settings -> new ButtonBlock(BlockSetType.STONE, 20, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.STONE, settings),
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .solid()
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND),
            true,
            false
    );
    public static final Block MOD_FENCE = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(PetrifiedWoodInitializer.MOD_FIBER_COLOR)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(2.0F, 6.0F)
                    .sounds(PetrifiedWoodInitializer.MOD_BLOCK_SOUND),
            true,
            false
    );
    public static final Block MOD_DOOR = ModBlocks.register(
            PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_door",
            settings -> new DoorBlock(BlockSetType.STONE, settings),
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
            PetrifiedWoodInitializer.MOD_WOOD_TYPE + "_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.STONE, settings),
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

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_WOOD);
                    itemGroup.addAfter(Items.CHISELED_TUFF_BRICKS, PetrifiedWoodModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.POINTED_DRIPSTONE, PetrifiedWoodModBlocks.MOD_LOG);
                });
    }
}
