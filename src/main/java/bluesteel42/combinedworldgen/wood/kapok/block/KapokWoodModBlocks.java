package bluesteel42.combinedworldgen.wood.kapok.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.kapok.KapokWoodInitializer;
import bluesteel42.combinedworldgen.wood.kapok.item.KapokWoodModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class KapokWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.registerLog(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BARK_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_WOOD = ModBlocks.registerWood(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_BARK_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.registerStrippedLog(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.registerStrippedWood(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(KapokWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_WOOD_TYPE, KapokWoodInitializer.MOD_FIBER_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_FIBER_COLOR, KapokWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(KapokWoodInitializer.MOD_WOOD_NAME);

    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerNaturalBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    public static final Block MOD_LEAVES = ModBlocks.registerTintedLeaves(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodInitializer.MOD_LEAF_COLOR, KapokWoodInitializer.MOD_LEAF_SOUND);
    /* USES VANILLA JUNGLE SAPLING */
//    public static final Block MOD_SAPLING = ModBlocks.registerSapling(KapokWoodInitializer.MOD_WOOD_NAME, KapokWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, KapokWoodInitializer.MOD_LEAF_COLOR, KapokWoodInitializer.MOD_SAPLING_SOUND);
//    public static final Block POTTED_MOD_SAPLING = ModBlocks.registerPottedSapling(KapokWoodInitializer.MOD_WOOD_NAME, MOD_SAPLING);


    /* ADDITIONAL BLOCKS */
    public static final Block CACAO_LEAVES = ModBlocks.registerTintedLeaves(KapokWoodInitializer.CACAO_WOOD_NAME, MapColor.DARK_GREEN, BlockSoundGroup.GRASS);
    public static final Block CACAO_SAPLING = ModBlocks.registerSapling(KapokWoodInitializer.CACAO_WOOD_NAME, KapokWoodModSaplingGenerators.CACAO_SAPLING_GENERATOR, MapColor.DARK_GREEN, BlockSoundGroup.GRASS);
    public static final Block POTTED_CACAO_SAPLING = ModBlocks.registerPottedSapling(KapokWoodInitializer.CACAO_WOOD_NAME, CACAO_SAPLING);

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_WOOD);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_PLANKS);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_STAIRS);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_SLAB);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_FENCE);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_DOOR);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_BUTTON);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.JUNGLE_LEAVES, KapokWoodModBlocks.MOD_LEAVES);
                    itemGroup.addBefore(Items.JUNGLE_LOG, KapokWoodModBlocks.MOD_LOG);

                    /* ADDITIONAL BLOCKS */
                    itemGroup.addAfter(Items.JUNGLE_LEAVES, KapokWoodModBlocks.CACAO_LEAVES);
                    itemGroup.addAfter(Items.JUNGLE_SAPLING, KapokWoodModBlocks.CACAO_SAPLING);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.JUNGLE_SHELF, KapokWoodModBlocks.MOD_SHELF);
                });
    }
}
