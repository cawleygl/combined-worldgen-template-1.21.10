package bluesteel42.combinedworldgen.wood.cholla.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.cholla.ChollaWoodInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class ChollaWoodModBlocks {
    public static final Block MOD_BLOCK = ModBlocks.registerCombinedBlock(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_UNSTRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_BLOCK = ModBlocks.registerStrippedCombinedBlock(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_MOSAIC = ModBlocks.registerMosaic(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(ChollaWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_MOSAIC_STAIRS = ModBlocks.registerMosaicStairs(ChollaWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_MOSAIC_SLAB = ModBlocks.registerMosaicSlab(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_WOOD_TYPE, ChollaWoodInitializer.MOD_STRIPPED_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(ChollaWoodInitializer.MOD_WOOD_NAME, ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(ChollaWoodInitializer.MOD_WOOD_NAME);
    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerCombinedBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_MOSAIC, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    /* ADDITIONAL BLOCKS */
    public static final Block DRIED_CHOLLA = ModBlocks.register(
            "dried_" + ChollaWoodInitializer.MOD_WOOD_NAME,
            DriedChollaBlock::new,
            Blocks.createLogSettings(ChollaWoodInitializer.MOD_UNSTRIPPED_COLOR, ChollaWoodInitializer.MOD_UNSTRIPPED_COLOR, BlockSoundGroup.BAMBOO_WOOD)
    );
    public static final Block STRIPPED_DRIED_CHOLLA = ModBlocks.register(
            "stripped_dried_" + ChollaWoodInitializer.MOD_WOOD_NAME,
            DriedChollaBlock::new,
            Blocks.createLogSettings(ChollaWoodInitializer.MOD_STRIPPED_COLOR, ChollaWoodInitializer.MOD_STRIPPED_COLOR, BlockSoundGroup.BAMBOO_WOOD)
    );
    public static final Block POTTED_DRIED_CHOLLA = ModBlocks.register(
            "potted_dried_" + ChollaWoodInitializer.MOD_WOOD_NAME,
            settings -> new FlowerPotBlock(DRIED_CHOLLA, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );
    public static final Block POTTED_STRIPPED_DRIED_CHOLLA = ModBlocks.register(
            "potted_stripped_dried_" + ChollaWoodInitializer.MOD_WOOD_NAME,
            settings -> new FlowerPotBlock(STRIPPED_DRIED_CHOLLA, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_BUTTON);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_DOOR);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_FENCE);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_MOSAIC_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_SLAB);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_MOSAIC_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_STAIRS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_MOSAIC);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_PLANKS);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.STRIPPED_MOD_BLOCK);
                    itemGroup.addAfter(Items.BAMBOO_BUTTON, ChollaWoodModBlocks.MOD_BLOCK);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.CACTUS, ChollaWoodModBlocks.STRIPPED_DRIED_CHOLLA);
                    itemGroup.addAfter(Items.CACTUS, ChollaWoodModBlocks.DRIED_CHOLLA);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO_SHELF, ChollaWoodModBlocks.MOD_SHELF);
                });
    }
}
