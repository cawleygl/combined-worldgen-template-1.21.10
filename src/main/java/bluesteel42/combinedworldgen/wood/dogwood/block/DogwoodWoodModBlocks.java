package bluesteel42.combinedworldgen.wood.dogwood.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.dogwood.DogwoodWoodInitializer;
import bluesteel42.combinedworldgen.wood.dogwood.item.DogwoodWoodModSaplingGenerators;
import bluesteel42.combinedworldgen.wood.dogwood.particle.DogwoodWoodModParticles;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class DogwoodWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.registerLog(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BARK_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_WOOD = ModBlocks.registerWood(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_BARK_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.registerStrippedLog(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.registerStrippedWood(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(DogwoodWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_WOOD_TYPE, DogwoodWoodInitializer.MOD_FIBER_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_FIBER_COLOR, DogwoodWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(DogwoodWoodInitializer.MOD_WOOD_NAME);

    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerNaturalBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    /* CUSTOM PARTICLES */
    public static final Block MOD_LEAVES = ModBlocks.registerUntintedLeaves(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodInitializer.MOD_LEAF_COLOR, DogwoodWoodInitializer.MOD_LEAF_SOUND, DogwoodWoodModParticles.DOGWOOD_LEAVES);
    public static final Block MOD_SAPLING = ModBlocks.registerSapling(DogwoodWoodInitializer.MOD_WOOD_NAME, DogwoodWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, DogwoodWoodInitializer.MOD_LEAF_COLOR, DogwoodWoodInitializer.MOD_SAPLING_SOUND);
    public static final Block POTTED_MOD_SAPLING = ModBlocks.registerPottedSapling(DogwoodWoodInitializer.MOD_WOOD_NAME, MOD_SAPLING);

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_WOOD);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_PLANKS);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_STAIRS);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_SLAB);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_FENCE);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_DOOR);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_BUTTON);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.MANGROVE_LOG, DogwoodWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.MANGROVE_LEAVES, DogwoodWoodModBlocks.MOD_LEAVES);
                    itemGroup.addBefore(Items.MANGROVE_PROPAGULE, DogwoodWoodModBlocks.MOD_SAPLING);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.MANGROVE_SHELF, DogwoodWoodModBlocks.MOD_SHELF);
                });
    }
}
