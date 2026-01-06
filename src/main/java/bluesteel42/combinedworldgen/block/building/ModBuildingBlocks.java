package bluesteel42.combinedworldgen.block.building;

import bluesteel42.combinedworldgen.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class ModBuildingBlocks {

    /* SMOOTH DEEPSLATE */
    public static final Block SMOOTH_DEEPSLATE = ModBlocks.register("smooth_deepslate", Block::new, AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(3.5F, 6.0F), true, false);
    public static final Block SMOOTH_DEEPSLATE_SLAB = ModBlocks.register("smooth_deepslate_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.DEEPSLATE).strength(3.5F, 6.0F), true, false);

    /* MOSSY BRICKS AND COBBLE */
    public static final Block MOSSY_BRICKS = ModBlocks.register("mossy_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.BRICKS), true, false);
    public static final Block MOSSY_BRICK_STAIRS = ModBlocks.register(
            "mossy_brick_stairs",
            settings -> new StairsBlock(Blocks.BRICKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(Blocks.BRICKS),
            true,
            false
    );
    public static final Block MOSSY_BRICK_SLAB = ModBlocks.register(
            "mossy_brick_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(Blocks.BRICKS),
            true,
            false
    );
    public static final Block MOSSY_BRICK_WALL = ModBlocks.register(
            "mossy_brick_wall",
            WallBlock::new,
            AbstractBlock.Settings.copy(Blocks.BRICKS).solid(),
            true,
            false
    );

    public static final Block MOSSY_TUFF_BRICKS = ModBlocks.register("mossy_tuff_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.TUFF_BRICKS), true, false);
    public static final Block MOSSY_TUFF_BRICK_STAIRS = ModBlocks.register(
            "mossy_tuff_brick_stairs",
            settings -> new StairsBlock(Blocks.TUFF_BRICKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(Blocks.TUFF_BRICKS),
            true,
            false
    );
    public static final Block MOSSY_TUFF_BRICK_SLAB = ModBlocks.register(
            "mossy_tuff_brick_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(Blocks.TUFF_BRICKS),
            true,
            false
    );
    public static final Block MOSSY_TUFF_BRICK_WALL = ModBlocks.register(
            "mossy_tuff_brick_wall",
            WallBlock::new,
            AbstractBlock.Settings.copy(Blocks.TUFF_BRICKS).solid(),
            true,
            false
    );

    public static final Block MOSSY_DEEPSLATE_BRICKS = ModBlocks.register("mossy_deepslate_bricks", Block::new, AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS), true, false);
    public static final Block MOSSY_DEEPSLATE_BRICK_STAIRS = ModBlocks.register(
            "mossy_deepslate_brick_stairs",
            settings -> new StairsBlock(Blocks.DEEPSLATE_BRICKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS),
            true,
            false
    );
    public static final Block MOSSY_DEEPSLATE_BRICK_SLAB = ModBlocks.register(
            "mossy_deepslate_brick_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS),
            true,
            false
    );
    public static final Block MOSSY_DEEPSLATE_BRICK_WALL = ModBlocks.register(
            "mossy_deepslate_brick_wall",
            WallBlock::new,
            AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS).solid(),
            true,
            false
    );

    public static final Block MOSSY_COBBLED_DEEPSLATE = ModBlocks.register("mossy_cobbled_deepslate", Block::new, AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE), true, false);
    public static final Block MOSSY_COBBLED_DEEPSLATE_STAIRS = ModBlocks.register(
            "mossy_cobbled_deepslate_stairs",
            settings -> new StairsBlock(Blocks.COBBLED_DEEPSLATE.getDefaultState(), settings),
            AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE),
            true,
            false
    );
    public static final Block MOSSY_COBBLED_DEEPSLATE_SLAB = ModBlocks.register(
            "mossy_cobbled_deepslate_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE),
            true,
            false
    );
    public static final Block MOSSY_COBBLED_DEEPSLATE_WALL = ModBlocks.register(
            "mossy_cobbled_deepslate_wall",
            WallBlock::new,
            AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE).solid(),
            true,
            false
    );

    /* PACKED SNOW AND SNOW BRICKS */
    public static final Block PACKED_SNOW = ModBlocks.register("packed_snow", Block::new,
            AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(1.0F, 3.0F).sounds(BlockSoundGroup.SNOW), true, false
    );
    public static final Block SNOW_BRICKS = ModBlocks.register("snow_bricks", Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 3.0F)
                    .sounds(BlockSoundGroup.SNOW),
            true,
            false
    );
    public static final Block SNOW_BRICK_STAIRS = ModBlocks.register("snow_brick_stairs", settings -> new StairsBlock(ModBuildingBlocks.SNOW_BRICKS.getDefaultState(), settings), AbstractBlock.Settings.copy(ModBuildingBlocks.SNOW_BRICKS), true, false);
    public static final Block SNOW_BRICK_SLAB = ModBlocks.register("snow_brick_slab", SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 3.0F)
                    .sounds(BlockSoundGroup.SNOW),
            true,
            false
    );
    public static final Block SNOW_BRICK_WALL = ModBlocks.register("snow_brick_wall", WallBlock::new, AbstractBlock.Settings.copy(ModBuildingBlocks.SNOW_BRICKS).solid(), true, false);
    public static final Block CHISELED_SNOW_BRICKS = ModBlocks.register("chiseled_snow_bricks", Block::new, AbstractBlock.Settings.copy(ModBuildingBlocks.SNOW_BRICKS),true, false);

    /* POLISHED WALLS */
    public static final Block POLISHED_ANDESITE_WALL = ModBlocks.register(
            "polished_andesite_wall",
            WallBlock::new,
            AbstractBlock.Settings.copy(Blocks.POLISHED_ANDESITE).solid(),
            true,
            false
    );
    public static final Block POLISHED_DIORITE_WALL = ModBlocks.register(
            "polished_diorite_wall",
            WallBlock::new,
            AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE).solid(),
            true,
            false
    );
    public static final Block POLISHED_GRANITE_WALL = ModBlocks.register(
            "polished_granite_wall",
            WallBlock::new,
            AbstractBlock.Settings.copy(Blocks.POLISHED_GRANITE).solid(),
            true,
            false
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BRICK_WALL, ModBuildingBlocks.MOSSY_BRICK_WALL);
                    itemGroup.addAfter(Items.BRICK_WALL, ModBuildingBlocks.MOSSY_BRICK_SLAB);
                    itemGroup.addAfter(Items.BRICK_WALL, ModBuildingBlocks.MOSSY_BRICK_STAIRS);
                    itemGroup.addAfter(Items.BRICK_WALL, ModBuildingBlocks.MOSSY_BRICKS);
                    itemGroup.addAfter(Items.TUFF_BRICK_WALL, ModBuildingBlocks.MOSSY_TUFF_BRICK_WALL);
                    itemGroup.addAfter(Items.TUFF_BRICK_WALL, ModBuildingBlocks.MOSSY_TUFF_BRICK_SLAB);
                    itemGroup.addAfter(Items.TUFF_BRICK_WALL, ModBuildingBlocks.MOSSY_TUFF_BRICK_STAIRS);
                    itemGroup.addAfter(Items.TUFF_BRICK_WALL, ModBuildingBlocks.MOSSY_TUFF_BRICKS);
                    itemGroup.addAfter(Items.DEEPSLATE_BRICK_WALL, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_WALL);
                    itemGroup.addAfter(Items.DEEPSLATE_BRICK_WALL, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_SLAB);
                    itemGroup.addAfter(Items.DEEPSLATE_BRICK_WALL, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS);
                    itemGroup.addAfter(Items.DEEPSLATE_BRICK_WALL, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICKS);
                    itemGroup.addAfter(Items.COBBLED_DEEPSLATE_WALL, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_WALL);
                    itemGroup.addAfter(Items.COBBLED_DEEPSLATE_WALL, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB);
                    itemGroup.addAfter(Items.COBBLED_DEEPSLATE_WALL, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS);
                    itemGroup.addAfter(Items.COBBLED_DEEPSLATE_WALL, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE);
                    itemGroup.addAfter(Items.DEEPSLATE_TILE_WALL, ModBuildingBlocks.SMOOTH_DEEPSLATE_SLAB);
                    itemGroup.addAfter(Items.DEEPSLATE_TILE_WALL, ModBuildingBlocks.SMOOTH_DEEPSLATE);
                    itemGroup.addAfter(Items.POLISHED_ANDESITE_SLAB, ModBuildingBlocks.POLISHED_ANDESITE_WALL);
                    itemGroup.addAfter(Items.POLISHED_DIORITE_SLAB, ModBuildingBlocks.POLISHED_DIORITE_WALL);
                    itemGroup.addAfter(Items.POLISHED_GRANITE_SLAB, ModBuildingBlocks.POLISHED_GRANITE_WALL);
                    itemGroup.addAfter(Items.CUT_RED_SANDSTONE_SLAB, ModBuildingBlocks.SNOW_BRICK_WALL);
                    itemGroup.addAfter(Items.CUT_RED_SANDSTONE_SLAB, ModBuildingBlocks.SNOW_BRICK_SLAB);
                    itemGroup.addAfter(Items.CUT_RED_SANDSTONE_SLAB, ModBuildingBlocks.SNOW_BRICK_STAIRS);
                    itemGroup.addAfter(Items.CUT_RED_SANDSTONE_SLAB, ModBuildingBlocks.CHISELED_SNOW_BRICKS);
                    itemGroup.addAfter(Items.CUT_RED_SANDSTONE_SLAB, ModBuildingBlocks.SNOW_BRICKS);
                    itemGroup.addAfter(Items.CUT_RED_SANDSTONE_SLAB, ModBuildingBlocks.PACKED_SNOW);
                    itemGroup.addAfter(Items.CUT_RED_SANDSTONE_SLAB, Blocks.SNOW_BLOCK);
                });

    }

}
