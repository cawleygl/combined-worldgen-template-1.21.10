package bluesteel42.combinedworldgen.wood.baobab.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.baobab.BaobabWoodInitializer;
import bluesteel42.combinedworldgen.wood.baobab.item.BaobabWoodModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class BaobabWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.registerLog(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BARK_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_WOOD = ModBlocks.registerWood(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_BARK_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.registerStrippedLog(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.registerStrippedWood(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(BaobabWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_WOOD_TYPE, BaobabWoodInitializer.MOD_FIBER_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_FIBER_COLOR, BaobabWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(BaobabWoodInitializer.MOD_WOOD_NAME);

    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerNaturalBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    public static final Block MOD_LEAVES = ModBlocks.registerTintedLeaves(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodInitializer.MOD_LEAF_COLOR, BaobabWoodInitializer.MOD_LEAF_SOUND);
    public static final Block MOD_SAPLING = ModBlocks.registerSapling(BaobabWoodInitializer.MOD_WOOD_NAME, BaobabWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, BaobabWoodInitializer.MOD_LEAF_COLOR, BaobabWoodInitializer.MOD_SAPLING_SOUND);
    public static final Block POTTED_MOD_SAPLING = ModBlocks.registerPottedSapling(BaobabWoodInitializer.MOD_WOOD_NAME, MOD_SAPLING);

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
