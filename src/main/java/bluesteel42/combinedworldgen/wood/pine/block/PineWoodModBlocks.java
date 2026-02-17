package bluesteel42.combinedworldgen.wood.pine.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.pine.PineWoodInitializer;
import bluesteel42.combinedworldgen.wood.pine.item.PineWoodModSaplingGenerators;
import bluesteel42.combinedworldgen.wood.pine.particle.PineWoodModParticles;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class PineWoodModBlocks {
    public static final Block MOD_LOG = ModBlocks.registerLog(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BARK_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_WOOD = ModBlocks.registerWood(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_BARK_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_LOG = ModBlocks.registerStrippedLog(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_WOOD = ModBlocks.registerStrippedWood(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(PineWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_WOOD_TYPE, PineWoodInitializer.MOD_FIBER_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR, PineWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_FIBER_COLOR);

    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerNaturalBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    /* CUSTOM PARTICLES */
    public static final Block MOD_LEAVES = ModBlocks.registerLeavesWithCustomParticles(PineWoodInitializer.MOD_WOOD_NAME, PineWoodInitializer.MOD_LEAF_COLOR, PineWoodInitializer.MOD_LEAF_SOUND, settings -> new TintedParticlePineNeedleLeavesBlock(0.01F, settings));
    public static final Block MOD_SAPLING = ModBlocks.registerSapling(PineWoodInitializer.MOD_WOOD_NAME, PineWoodModSaplingGenerators.MOD_SAPLING_GENERATOR, PineWoodInitializer.MOD_LEAF_COLOR, PineWoodInitializer.MOD_SAPLING_SOUND);
    public static final Block POTTED_MOD_SAPLING = ModBlocks.registerPottedSapling(PineWoodInitializer.MOD_WOOD_NAME, MOD_SAPLING);

    /* ADDITIONAL BLOCKS */
    public static final Block SPRUCE_LEAVES_FALLING_NEEDLES = ModBlocks.registerLeavesWithCustomParticles("spruce", MapColor.DARK_GREEN, BlockSoundGroup.GRASS, settings -> new TintedParticleSpruceNeedleLeavesBlock(0.01F, settings));
    public static final Block SNOWY_SPRUCE_LEAVES = ModBlocks.registerLeavesWithCustomParticles("snowy_spruce", MapColor.WHITE, BlockSoundGroup.GRASS, settings -> new SnowyLeavesBlock(0.01F, PineWoodModParticles.SNOWY_SPRUCE_NEEDLES, settings, PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES));
    public static final Block SNOWY_PINE_LEAVES = ModBlocks.registerLeavesWithCustomParticles("snowy_" + PineWoodInitializer.MOD_WOOD_NAME, MapColor.WHITE, PineWoodInitializer.MOD_LEAF_SOUND, settings -> new SnowyLeavesBlock(0.01F, PineWoodModParticles.SNOWY_PINE_NEEDLES, settings, PineWoodModBlocks.MOD_LEAVES));

    public static final Block SNOWY_PINE_SAPLING = ModBlocks.registerCustomSapling("snowy_" + PineWoodInitializer.MOD_WOOD_NAME, settings -> new SnowySaplingBlock(PineWoodModSaplingGenerators.SNOWY_PINE_SAPLING_GENERATOR, settings, PineWoodModBlocks.MOD_SAPLING), MapColor.WHITE, PineWoodInitializer.MOD_SAPLING_SOUND);
    public static final Block POTTED_SNOWY_PINE_SAPLING = ModBlocks.registerPottedSapling("snowy_" + PineWoodInitializer.MOD_WOOD_NAME, SNOWY_PINE_SAPLING);
    public static final Block SNOWY_SPRUCE_SAPLING = ModBlocks.registerCustomSapling("snowy_spruce", settings -> new SnowySaplingBlock(PineWoodModSaplingGenerators.SNOWY_SPRUCE_SAPLING_GENERATOR, settings, Blocks.SPRUCE_SAPLING), MapColor.WHITE, PineWoodInitializer.MOD_SAPLING_SOUND);
    public static final Block POTTED_SNOWY_SPRUCE_SAPLING = ModBlocks.registerPottedSapling("snowy_spruce", SNOWY_SPRUCE_SAPLING);

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_WOOD);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.STRIPPED_MOD_LOG);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.STRIPPED_MOD_WOOD);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_PLANKS);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_STAIRS);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_SLAB);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_FENCE);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_DOOR);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_BUTTON);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.BIRCH_LOG, PineWoodModBlocks.MOD_LOG);
                    itemGroup.addBefore(Items.BIRCH_LEAVES, PineWoodModBlocks.MOD_LEAVES);
                    itemGroup.addBefore(Items.BIRCH_SAPLING, PineWoodModBlocks.MOD_SAPLING);

                    /* ADDITIONAL BLOCKS */
                    itemGroup.addAfter(PineWoodModBlocks.MOD_LEAVES, PineWoodModBlocks.SNOWY_PINE_LEAVES);
                    itemGroup.addAfter(Items.SPRUCE_LEAVES, PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES);
                    itemGroup.addAfter(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, PineWoodModBlocks.SNOWY_SPRUCE_LEAVES);
                    itemGroup.addAfter(PineWoodModBlocks.MOD_SAPLING, PineWoodModBlocks.SNOWY_PINE_SAPLING);
                    itemGroup.addAfter(Items.SPRUCE_SAPLING, PineWoodModBlocks.SNOWY_SPRUCE_SAPLING);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.BIRCH_SHELF, PineWoodModBlocks.MOD_SHELF);
                });
    }
}
