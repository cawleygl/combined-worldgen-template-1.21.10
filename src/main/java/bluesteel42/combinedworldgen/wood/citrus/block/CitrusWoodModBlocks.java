package bluesteel42.combinedworldgen.wood.citrus.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.citrus.CitrusWoodInitializer;
import bluesteel42.combinedworldgen.wood.citrus.item.CitrusWoodModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class CitrusWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.registerLog(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BARK_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_WOOD = ModBlocks.registerWood(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_BARK_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.registerStrippedLog(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.registerStrippedWood(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(CitrusWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_WOOD_TYPE, CitrusWoodInitializer.MOD_FIBER_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_FIBER_COLOR, CitrusWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(CitrusWoodInitializer.MOD_WOOD_NAME);

    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerNaturalBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    public static final Block MOD_LEAVES = ModBlocks.registerTintedLeaves(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodInitializer.MOD_LEAF_COLOR, CitrusWoodInitializer.MOD_LEAF_SOUND);
    public static final Block MOD_SAPLING = ModBlocks.registerSapling(CitrusWoodInitializer.MOD_WOOD_NAME, CitrusWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, CitrusWoodInitializer.MOD_LEAF_COLOR, CitrusWoodInitializer.MOD_SAPLING_SOUND);
    public static final Block POTTED_MOD_SAPLING = ModBlocks.registerPottedSapling(CitrusWoodInitializer.MOD_WOOD_NAME, MOD_SAPLING);

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
