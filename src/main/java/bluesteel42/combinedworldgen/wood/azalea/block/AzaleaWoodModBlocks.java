package bluesteel42.combinedworldgen.wood.azalea.block;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.wood.azalea.AzaleaWoodInitializer;
import bluesteel42.combinedworldgen.wood.dogwood.block.DogwoodWoodModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.TintedParticleEffect;
import net.minecraft.sound.BlockSoundGroup;

public class AzaleaWoodModBlocks {
    public static final Block MOD_BLOCK = ModBlocks.registerCombinedBlock(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_UNSTRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block STRIPPED_MOD_BLOCK = ModBlocks.registerStrippedCombinedBlock(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_PLANKS = ModBlocks.registerPlanks(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_MOSAIC = ModBlocks.registerMosaic(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_STAIRS = ModBlocks.registerStairs(AzaleaWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_MOSAIC_STAIRS = ModBlocks.registerMosaicStairs(AzaleaWoodInitializer.MOD_WOOD_NAME, MOD_PLANKS);
    public static final Block MOD_SLAB = ModBlocks.registerSlab(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_MOSAIC_SLAB = ModBlocks.registerMosaicSlab(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_BUTTON = ModBlocks.registerButton(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_PRESSURE_PLATE = ModBlocks.registerPressurePlate(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_FENCE = ModBlocks.registerFence(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SOUND);
    public static final Block MOD_FENCE_GATE = ModBlocks.registerFenceGate(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_WOOD_TYPE, AzaleaWoodInitializer.MOD_STRIPPED_COLOR);
    public static final Block MOD_DOOR = ModBlocks.registerDoor(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SET);
    public static final Block MOD_TRAPDOOR = ModBlocks.registerTrapdoor(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_BLOCK_SET);

    public static final Block MOD_STANDING_SIGN = ModBlocks.registerStandingSign(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_SIGN = ModBlocks.registerWallSign(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_WOOD_TYPE, MOD_STANDING_SIGN);
    public static final Block MOD_HANGING_SIGN = ModBlocks.registerHangingSign(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_WOOD_TYPE);
    public static final Block MOD_WALL_HANGING_SIGN = ModBlocks.registerWallHangingSign(AzaleaWoodInitializer.MOD_WOOD_NAME, AzaleaWoodInitializer.MOD_STRIPPED_COLOR, AzaleaWoodInitializer.MOD_WOOD_TYPE, MOD_HANGING_SIGN);

    public static final Block MOD_SHELF = ModBlocks.registerShelf(AzaleaWoodInitializer.MOD_WOOD_NAME);
    public static final BlockFamily MOD_BLOCK_FAMILY = ModBlocks.registerCombinedBlockFamily(MOD_PLANKS, MOD_BUTTON, MOD_MOSAIC, MOD_DOOR, MOD_FENCE, MOD_FENCE_GATE, MOD_STANDING_SIGN, MOD_WALL_SIGN, MOD_SLAB, MOD_STAIRS, MOD_PRESSURE_PLATE, MOD_TRAPDOOR);

    /* ADDITIONAL BLOCKS */
    public static final Block AZALEA_STEM = ModBlocks.register(
            "azalea_stem",
            AzaleaStemBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .nonOpaque()
                    .burnable(),
            true,
            false

    );
    public static final Block LEAFY_AZALEA_STEM = ModBlocks.register(
            "leafy_azalea_stem",
            settings -> new LeafyAzaleaStemBlock(0.01F, TintedParticleEffect.create(ParticleTypes.TINTED_LEAVES, -9399763), settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .suffocates(Blocks::never)
                    .blockVision(Blocks::never)
                    .nonOpaque()
                    .burnable(),
            true,
            true
    );
    public static final Block STRIPPED_AZALEA_STEM = ModBlocks.register(
            "stripped_azalea_stem",
            AzaleaStemBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.BAMBOO_WOOD)
                    .burnable(),
            true,
            false
    );
    public static final Block POTTED_AZALEA_STEM = ModBlocks.register(
            "potted_azalea_stem",
            settings -> new FlowerPotBlock(AzaleaWoodModBlocks.AZALEA_STEM, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );
    public static final Block POTTED_STRIPPED_AZALEA_STEM = ModBlocks.register(
            "potted_stripped_azalea_stem",
            settings -> new FlowerPotBlock(AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM, settings),
            Blocks.createFlowerPotSettings(),
            true,
            true
    );


    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_BLOCK);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_PLANKS);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_MOSAIC);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_STAIRS);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_MOSAIC_STAIRS);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_SLAB);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_MOSAIC_SLAB);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_FENCE);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_FENCE_GATE);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_DOOR);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_TRAPDOOR);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_PRESSURE_PLATE);
                    itemGroup.addBefore(Items.CRIMSON_STEM, AzaleaWoodModBlocks.MOD_BUTTON);
                });
        /* ADDITIONAL BLOCKS */
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BAMBOO, AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM);
                    itemGroup.addAfter(Items.BAMBOO, AzaleaWoodModBlocks.LEAFY_AZALEA_STEM);
                    itemGroup.addAfter(Items.BAMBOO, AzaleaWoodModBlocks.AZALEA_STEM);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addBefore(Items.CRIMSON_SHELF, AzaleaWoodModBlocks.MOD_SHELF);
                });
    }
}
