package bluesteel42.combinedworldgen.wood.chorus.block;

import bluesteel42.combinedworldgen.wood.chorus.ChorusWoodInitializer;
import bluesteel42.combinedworldgen.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class ChorusWoodModBlocks {
    public static final Block MOD_BLOCK = ModBlocks.registerCombinedBlock(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_UNSTRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_BLOCK = ModBlocks.registerStrippedCombinedBlock(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_MOSAIC = ModBlocks.registerMosaic(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(ChorusWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_MOSAIC_STAIRS = ModBlocks.registerMosaicStairs(ChorusWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_MOSAIC_SLAB = ModBlocks.registerMosaicSlab(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_WOOD_TYPE, ChorusWoodInitializer.MOD_STRIPPED_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(ChorusWoodInitializer.MOD_WOOD_NAME, ChorusWoodInitializer.MOD_STRIPPED_COLOR, ChorusWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(ChorusWoodInitializer.MOD_WOOD_NAME);
    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerCombinedBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_MOSAIC, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_MOSAIC_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_MOSAIC_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_MOSAIC);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.STRIPPED_MOD_BLOCK);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChorusWoodModBlocks.MOD_BLOCK);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_SHELF, ChorusWoodModBlocks.MOD_SHELF);
                });
    }
}
