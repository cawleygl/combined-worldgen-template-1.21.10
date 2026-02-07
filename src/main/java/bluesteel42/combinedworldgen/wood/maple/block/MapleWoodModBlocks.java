package bluesteel42.combinedworldgen.wood.maple.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import bluesteel42.combinedworldgen.wood.maple.item.MapleWoodModSaplingGenerators;
import bluesteel42.combinedworldgen.wood.maple.particle.MapleWoodModParticles;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class MapleWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.registerLog(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BARK_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_WOOD = ModBlocks.registerWood(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_BARK_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.registerStrippedLog(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.registerStrippedWood(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(MapleWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_WOOD_TYPE, MapleWoodInitializer.MOD_FIBER_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_FIBER_COLOR, MapleWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(MapleWoodInitializer.MOD_WOOD_NAME);

    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerNaturalBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    /* Custom Particles */
    public static final Block MOD_LEAVES = ModBlocks.registerLeavesWithCustomParticles(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_LEAF_COLOR, MapleWoodInitializer.MOD_LEAF_SOUND, settings -> new TintedParticleMapleLeavesBlock(0.01F, settings));

    public static final Block MOD_SAPLING = ModBlocks.registerSapling(MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, MapleWoodInitializer.MOD_LEAF_COLOR, MapleWoodInitializer.MOD_SAPLING_SOUND);
    public static final Block POTTED_MOD_SAPLING = ModBlocks.registerPottedSapling(MapleWoodInitializer.MOD_WOOD_NAME, MOD_SAPLING);

    /* ADDITIONAL BLOCKS */
    public static final Block RED_MAPLE_LEAVES = ModBlocks.registerLeavesWithCustomParticles("red_" + MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_LEAF_COLOR, MapleWoodInitializer.MOD_LEAF_SOUND, settings -> new UntintedParticleLeavesBlock(0.01F, MapleWoodModParticles.RED_MAPLE_LEAVES, settings));
    public static final Block YELLOW_MAPLE_LEAVES = ModBlocks.registerLeavesWithCustomParticles("yellow_" + MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_LEAF_COLOR, MapleWoodInitializer.MOD_LEAF_SOUND, settings -> new UntintedParticleLeavesBlock(0.01F, MapleWoodModParticles.YELLOW_MAPLE_LEAVES, settings));
    public static final Block MIXED_MAPLE_LEAVES = ModBlocks.registerLeavesWithCustomParticles("mixed_" + MapleWoodInitializer.MOD_WOOD_NAME, MapleWoodInitializer.MOD_LEAF_COLOR, MapleWoodInitializer.MOD_LEAF_SOUND, settings -> new MixedParticleMapleLeavesBlock(0.01F, MapleWoodModParticles.RED_MAPLE_LEAVES, MapleWoodModParticles.YELLOW_MAPLE_LEAVES, settings));

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_WOOD);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_PLANKS);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_STAIRS);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_SLAB);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_FENCE);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_DOOR);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_BUTTON);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.SPRUCE_LOG, MapleWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.SPRUCE_LEAVES, MapleWoodModBlocks.MOD_LEAVES);
                    itemGroup.addBefore(Items.SPRUCE_SAPLING, MapleWoodModBlocks.MOD_SAPLING);

                    /* ADDITIONAL BLOCKS */
                    itemGroup.addAfter(MapleWoodModBlocks.MOD_LEAVES, MapleWoodModBlocks.MIXED_MAPLE_LEAVES);
                    itemGroup.addAfter(MapleWoodModBlocks.MOD_LEAVES, MapleWoodModBlocks.RED_MAPLE_LEAVES);
                    itemGroup.addAfter(MapleWoodModBlocks.MOD_LEAVES, MapleWoodModBlocks.YELLOW_MAPLE_LEAVES);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.SPRUCE_SHELF, MapleWoodModBlocks.MOD_SHELF);
                });
    }
}
