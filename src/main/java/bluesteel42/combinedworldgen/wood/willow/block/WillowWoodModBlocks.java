package bluesteel42.combinedworldgen.wood.willow.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.willow.WillowWoodInitializer;
import bluesteel42.combinedworldgen.wood.willow.item.WillowWoodModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class WillowWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.registerLog(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_BARK_COLOR, WillowWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_WOOD = ModBlocks.registerWood(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_BARK_COLOR, WillowWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.registerStrippedLog(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.registerStrippedWood(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(WillowWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_WOOD_TYPE, WillowWoodInitializer.MOD_FIBER_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_FIBER_COLOR, WillowWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(WillowWoodInitializer.MOD_WOOD_NAME);

    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerNaturalBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    public static final Block MOD_LEAVES = ModBlocks.registerTintedLeaves(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodInitializer.MOD_LEAF_COLOR, WillowWoodInitializer.MOD_LEAF_SOUND);
    public static final Block MOD_SAPLING = ModBlocks.registerSapling(WillowWoodInitializer.MOD_WOOD_NAME, WillowWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, WillowWoodInitializer.MOD_LEAF_COLOR, WillowWoodInitializer.MOD_SAPLING_SOUND);
    public static final Block POTTED_MOD_SAPLING = ModBlocks.registerPottedSapling(WillowWoodInitializer.MOD_WOOD_NAME, MOD_SAPLING);

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_WOOD);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_PLANKS);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_STAIRS);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_SLAB);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_FENCE);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_DOOR);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addBefore(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_BUTTON);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.MANGROVE_LOG, WillowWoodModBlocks.MOD_LOG);
                    itemGroup.addAfter(Items.MANGROVE_LEAVES, WillowWoodModBlocks.MOD_LEAVES);
                    itemGroup.addAfter(Items.MANGROVE_PROPAGULE, WillowWoodModBlocks.MOD_SAPLING);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.MANGROVE_SHELF, WillowWoodModBlocks.MOD_SHELF);
                });
    }
}
