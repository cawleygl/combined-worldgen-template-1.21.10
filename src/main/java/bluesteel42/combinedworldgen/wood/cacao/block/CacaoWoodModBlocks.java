package bluesteel42.combinedworldgen.wood.cacao.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.cacao.CacaoWoodInitializer;
import bluesteel42.combinedworldgen.wood.cacao.item.CacaoWoodModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class CacaoWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.registerLog(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_BARK_COLOR, CacaoWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_WOOD = ModBlocks.registerWood(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_BARK_COLOR, CacaoWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.registerStrippedLog(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.registerStrippedWood(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(CacaoWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_WOOD_TYPE, CacaoWoodInitializer.MOD_FIBER_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR, CacaoWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_FIBER_COLOR);

    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerNaturalBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    public static final Block MOD_LEAVES = ModBlocks.registerTintedLeaves(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodInitializer.MOD_LEAF_COLOR, CacaoWoodInitializer.MOD_LEAF_SOUND);
    public static final Block MOD_SAPLING = ModBlocks.registerSapling(CacaoWoodInitializer.MOD_WOOD_NAME, CacaoWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, CacaoWoodInitializer.MOD_LEAF_COLOR, CacaoWoodInitializer.MOD_SAPLING_SOUND);
    public static final Block POTTED_MOD_SAPLING = ModBlocks.registerPottedSapling(CacaoWoodInitializer.MOD_WOOD_NAME, MOD_SAPLING);

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_WOOD);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_PLANKS);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_STAIRS);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_SLAB);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_FENCE);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_DOOR);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_BUTTON);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.JUNGLE_LEAVES, CacaoWoodModBlocks.MOD_LEAVES);
                    itemGroup.addBefore(Items.JUNGLE_LOG, CacaoWoodModBlocks.MOD_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.JUNGLE_SHELF, CacaoWoodModBlocks.MOD_SHELF);
                });
    }
}
