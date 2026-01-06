package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.block.building.ModBuildingBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.util.ModTags;
import bluesteel42.combinedworldgen.wood.azalea.block.AzaleaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.azalea.util.AzaleaWoodModTags;
import bluesteel42.combinedworldgen.wood.baobab.block.BaobabWoodModBlocks;
import bluesteel42.combinedworldgen.wood.baobab.util.BaobabWoodModTags;
import bluesteel42.combinedworldgen.wood.cholla.block.ChollaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.cholla.util.ChollaWoodModTags;
import bluesteel42.combinedworldgen.wood.chorus.block.ChorusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.chorus.util.ChorusWoodModTags;
import bluesteel42.combinedworldgen.wood.citrus.block.CitrusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.citrus.util.CitrusWoodModTags;
import bluesteel42.combinedworldgen.wood.dogwood.block.DogwoodWoodModBlocks;
import bluesteel42.combinedworldgen.wood.dogwood.util.DogwoodWoodModTags;
import bluesteel42.combinedworldgen.wood.kapok.block.KapokWoodModBlocks;
import bluesteel42.combinedworldgen.wood.kapok.util.KapokWoodModTags;
import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
import bluesteel42.combinedworldgen.wood.maple.util.MapleWoodModTags;
import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import bluesteel42.combinedworldgen.wood.petrified.util.PetrifiedWoodModTags;
import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import bluesteel42.combinedworldgen.wood.pine.util.PineWoodModTags;
import bluesteel42.combinedworldgen.wood.willow.block.WillowWoodModBlocks;
import bluesteel42.combinedworldgen.wood.willow.util.WillowWoodModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public void generateNaturalWoodBlockTags(
            TagKey<Block> logTag,
            Block log,
            Block wood,
            Block strippedLog,
            Block strippedWood,
            Block planks,
            Block stairs,
            Block slab,
            Block button,
            Block fence,
            Block fenceGate,
            Block pressurePlate,
            Block door,
            Block trapdoor,
            Block leaves,
            Block sapling,
            Block pottedSapling,
            Block standingSign,
            Block wallSign,
            Block hangingSign,
            Block wallHangingSign,
            Block shelf
    ) {
        valueLookupBuilder(logTag).add(log).add(strippedLog);
        valueLookupBuilder(logTag).add(wood).add(strippedWood);
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN).addTag(logTag);
        valueLookupBuilder(BlockTags.PLANKS).add(planks);
        valueLookupBuilder(BlockTags.WOODEN_STAIRS).add(stairs);
        valueLookupBuilder(BlockTags.WOODEN_SLABS).add(slab);
        valueLookupBuilder(BlockTags.WOODEN_DOORS).add(door);
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS).add(trapdoor);
        valueLookupBuilder(BlockTags.WOODEN_FENCES).add(fence);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(fenceGate);
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS).add(button);
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(pressurePlate);
        valueLookupBuilder(BlockTags.STANDING_SIGNS).add(standingSign);
        valueLookupBuilder(BlockTags.WALL_SIGNS).add(wallSign);
        valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS).add(hangingSign);
        valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS).add(wallHangingSign);
        valueLookupBuilder(BlockTags.WOODEN_SHELVES).add(shelf);
        valueLookupBuilder(BlockTags.LEAVES).add(leaves);
        valueLookupBuilder(BlockTags.SAPLINGS).add(sapling);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(pottedSapling);
    }
    public void generateCombinedWoodBlockTags(
            TagKey<Block> logTag,
            Block log,
            Block strippedLog,
            Block planks,
            Block mosaic,
            Block stairs,
            Block mosaicStairs,
            Block slab,
            Block mosaicSlab,
            Block button,
            Block fence,
            Block fenceGate,
            Block pressurePlate,
            Block door,
            Block trapdoor,
            Block standingSign,
            Block wallSign,
            Block hangingSign,
            Block wallHangingSign,
            Block shelf
    ) {
        valueLookupBuilder(logTag).add(log).add(strippedLog);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).addTag(logTag);
        valueLookupBuilder(BlockTags.PLANKS).add(planks);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(mosaic);
        valueLookupBuilder(BlockTags.WOODEN_STAIRS).add(stairs);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(mosaicStairs);
        valueLookupBuilder(BlockTags.STAIRS).add(mosaicStairs);
        valueLookupBuilder(BlockTags.WOODEN_SLABS).add(slab);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(mosaicSlab);
        valueLookupBuilder(BlockTags.SLABS).add(mosaicSlab);
        valueLookupBuilder(BlockTags.WOODEN_DOORS).add(door);
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS).add(trapdoor);
        valueLookupBuilder(BlockTags.WOODEN_FENCES).add(fence);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(fenceGate);
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS).add(button);
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(pressurePlate);
        valueLookupBuilder(BlockTags.STANDING_SIGNS).add(standingSign);
        valueLookupBuilder(BlockTags.WALL_SIGNS).add(wallSign);
        valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS).add(hangingSign);
        valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS).add(wallHangingSign);
        valueLookupBuilder(BlockTags.WOODEN_SHELVES).add(shelf);
    }

    public void generateAzaleaBlockTags() {
        generateCombinedWoodBlockTags(
                AzaleaWoodModTags.Blocks.MOD_BLOCKS,
                AzaleaWoodModBlocks.MOD_BLOCK,
                AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK,
                AzaleaWoodModBlocks.MOD_PLANKS,
                AzaleaWoodModBlocks.MOD_MOSAIC,
                AzaleaWoodModBlocks.MOD_STAIRS,
                AzaleaWoodModBlocks.MOD_MOSAIC_STAIRS,
                AzaleaWoodModBlocks.MOD_SLAB,
                AzaleaWoodModBlocks.MOD_MOSAIC_SLAB,
                AzaleaWoodModBlocks.MOD_BUTTON,
                AzaleaWoodModBlocks.MOD_FENCE,
                AzaleaWoodModBlocks.MOD_FENCE_GATE,
                AzaleaWoodModBlocks.MOD_PRESSURE_PLATE,
                AzaleaWoodModBlocks.MOD_DOOR,
                AzaleaWoodModBlocks.MOD_TRAPDOOR,
                AzaleaWoodModBlocks.MOD_STANDING_SIGN,
                AzaleaWoodModBlocks.MOD_WALL_SIGN,
                AzaleaWoodModBlocks.MOD_HANGING_SIGN,
                AzaleaWoodModBlocks.MOD_WALL_HANGING_SIGN,
                AzaleaWoodModBlocks.MOD_SHELF
        );
        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(AzaleaWoodModTags.Blocks.AZALEA_STEMS)
                .add(AzaleaWoodModBlocks.AZALEA_STEM)
                .add(AzaleaWoodModBlocks.LEAFY_AZALEA_STEM)
                .add(AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM);
        valueLookupBuilder(BlockTags.LOGS).addTag(AzaleaWoodModTags.Blocks.AZALEA_STEMS);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(AzaleaWoodModBlocks.POTTED_AZALEA_STEM);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(AzaleaWoodModBlocks.POTTED_STRIPPED_AZALEA_STEM);
    }
    public void generateBaobabBlockTags() {
        generateNaturalWoodBlockTags(
                BaobabWoodModTags.Blocks.MOD_LOGS,
                BaobabWoodModBlocks.MOD_LOG,
                BaobabWoodModBlocks.MOD_WOOD,
                BaobabWoodModBlocks.STRIPPED_MOD_LOG,
                BaobabWoodModBlocks.STRIPPED_MOD_WOOD,
                BaobabWoodModBlocks.MOD_PLANKS,
                BaobabWoodModBlocks.MOD_STAIRS,
                BaobabWoodModBlocks.MOD_SLAB,
                BaobabWoodModBlocks.MOD_BUTTON,
                BaobabWoodModBlocks.MOD_FENCE,
                BaobabWoodModBlocks.MOD_FENCE_GATE,
                BaobabWoodModBlocks.MOD_PRESSURE_PLATE,
                BaobabWoodModBlocks.MOD_DOOR,
                BaobabWoodModBlocks.MOD_TRAPDOOR,
                BaobabWoodModBlocks.MOD_LEAVES,
                BaobabWoodModBlocks.MOD_SAPLING,
                BaobabWoodModBlocks.POTTED_MOD_SAPLING,
                BaobabWoodModBlocks.MOD_STANDING_SIGN,
                BaobabWoodModBlocks.MOD_WALL_SIGN,
                BaobabWoodModBlocks.MOD_HANGING_SIGN,
                BaobabWoodModBlocks.MOD_WALL_HANGING_SIGN,
                BaobabWoodModBlocks.MOD_SHELF
        );
    }
    public void generateChollaBlockTags() {
        generateCombinedWoodBlockTags(
                ChollaWoodModTags.Blocks.MOD_BLOCKS,
                ChollaWoodModBlocks.MOD_BLOCK,
                ChollaWoodModBlocks.STRIPPED_MOD_BLOCK,
                ChollaWoodModBlocks.MOD_PLANKS,
                ChollaWoodModBlocks.MOD_MOSAIC,
                ChollaWoodModBlocks.MOD_STAIRS,
                ChollaWoodModBlocks.MOD_MOSAIC_STAIRS,
                ChollaWoodModBlocks.MOD_SLAB,
                ChollaWoodModBlocks.MOD_MOSAIC_SLAB,
                ChollaWoodModBlocks.MOD_BUTTON,
                ChollaWoodModBlocks.MOD_FENCE,
                ChollaWoodModBlocks.MOD_FENCE_GATE,
                ChollaWoodModBlocks.MOD_PRESSURE_PLATE,
                ChollaWoodModBlocks.MOD_DOOR,
                ChollaWoodModBlocks.MOD_TRAPDOOR,
                ChollaWoodModBlocks.MOD_STANDING_SIGN,
                ChollaWoodModBlocks.MOD_WALL_SIGN,
                ChollaWoodModBlocks.MOD_HANGING_SIGN,
                ChollaWoodModBlocks.MOD_WALL_HANGING_SIGN,
                ChollaWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ChollaWoodModBlocks.DRIED_CHOLLA);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ChollaWoodModBlocks.POTTED_DRIED_CHOLLA);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ChollaWoodModBlocks.STRIPPED_DRIED_CHOLLA);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ChollaWoodModBlocks.POTTED_STRIPPED_DRIED_CHOLLA);
    }
    public void generateChorusBlockTags() {
        generateCombinedWoodBlockTags(
                ChorusWoodModTags.Blocks.MOD_BLOCKS,
                ChorusWoodModBlocks.MOD_BLOCK,
                ChorusWoodModBlocks.STRIPPED_MOD_BLOCK,
                ChorusWoodModBlocks.MOD_PLANKS,
                ChorusWoodModBlocks.MOD_MOSAIC,
                ChorusWoodModBlocks.MOD_STAIRS,
                ChorusWoodModBlocks.MOD_MOSAIC_STAIRS,
                ChorusWoodModBlocks.MOD_SLAB,
                ChorusWoodModBlocks.MOD_MOSAIC_SLAB,
                ChorusWoodModBlocks.MOD_BUTTON,
                ChorusWoodModBlocks.MOD_FENCE,
                ChorusWoodModBlocks.MOD_FENCE_GATE,
                ChorusWoodModBlocks.MOD_PRESSURE_PLATE,
                ChorusWoodModBlocks.MOD_DOOR,
                ChorusWoodModBlocks.MOD_TRAPDOOR,
                ChorusWoodModBlocks.MOD_STANDING_SIGN,
                ChorusWoodModBlocks.MOD_WALL_SIGN,
                ChorusWoodModBlocks.MOD_HANGING_SIGN,
                ChorusWoodModBlocks.MOD_WALL_HANGING_SIGN,
                ChorusWoodModBlocks.MOD_SHELF
        );
    }
    public void generateCitrusBlockTags() {
        generateNaturalWoodBlockTags(
                CitrusWoodModTags.Blocks.MOD_LOGS,
                CitrusWoodModBlocks.MOD_LOG,
                CitrusWoodModBlocks.MOD_WOOD,
                CitrusWoodModBlocks.STRIPPED_MOD_LOG,
                CitrusWoodModBlocks.STRIPPED_MOD_WOOD,
                CitrusWoodModBlocks.MOD_PLANKS,
                CitrusWoodModBlocks.MOD_STAIRS,
                CitrusWoodModBlocks.MOD_SLAB,
                CitrusWoodModBlocks.MOD_BUTTON,
                CitrusWoodModBlocks.MOD_FENCE,
                CitrusWoodModBlocks.MOD_FENCE_GATE,
                CitrusWoodModBlocks.MOD_PRESSURE_PLATE,
                CitrusWoodModBlocks.MOD_DOOR,
                CitrusWoodModBlocks.MOD_TRAPDOOR,
                CitrusWoodModBlocks.MOD_LEAVES,
                CitrusWoodModBlocks.MOD_SAPLING,
                CitrusWoodModBlocks.POTTED_MOD_SAPLING,
                CitrusWoodModBlocks.MOD_STANDING_SIGN,
                CitrusWoodModBlocks.MOD_WALL_SIGN,
                CitrusWoodModBlocks.MOD_HANGING_SIGN,
                CitrusWoodModBlocks.MOD_WALL_HANGING_SIGN,
                CitrusWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(BlockTags.LEAVES).add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES);
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES);
        valueLookupBuilder(BlockTags.FLOWERS).add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES);
    }
    public void generateDogwoodBlockTags() {
        generateNaturalWoodBlockTags(
                DogwoodWoodModTags.Blocks.MOD_LOGS,
                DogwoodWoodModBlocks.MOD_LOG,
                DogwoodWoodModBlocks.MOD_WOOD,
                DogwoodWoodModBlocks.STRIPPED_MOD_LOG,
                DogwoodWoodModBlocks.STRIPPED_MOD_WOOD,
                DogwoodWoodModBlocks.MOD_PLANKS,
                DogwoodWoodModBlocks.MOD_STAIRS,
                DogwoodWoodModBlocks.MOD_SLAB,
                DogwoodWoodModBlocks.MOD_BUTTON,
                DogwoodWoodModBlocks.MOD_FENCE,
                DogwoodWoodModBlocks.MOD_FENCE_GATE,
                DogwoodWoodModBlocks.MOD_PRESSURE_PLATE,
                DogwoodWoodModBlocks.MOD_DOOR,
                DogwoodWoodModBlocks.MOD_TRAPDOOR,
                DogwoodWoodModBlocks.MOD_LEAVES,
                DogwoodWoodModBlocks.MOD_SAPLING,
                DogwoodWoodModBlocks.POTTED_MOD_SAPLING,
                DogwoodWoodModBlocks.MOD_STANDING_SIGN,
                DogwoodWoodModBlocks.MOD_WALL_SIGN,
                DogwoodWoodModBlocks.MOD_HANGING_SIGN,
                DogwoodWoodModBlocks.MOD_WALL_HANGING_SIGN,
                DogwoodWoodModBlocks.MOD_SHELF
        );
        /* FLOWER LEAVES */
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(DogwoodWoodModBlocks.MOD_LEAVES);
        valueLookupBuilder(BlockTags.FLOWERS).add(DogwoodWoodModBlocks.MOD_LEAVES);
    }
    public void generateKapokBlockTags() {
        generateNaturalWoodBlockTags(
                KapokWoodModTags.Blocks.MOD_LOGS,
                KapokWoodModBlocks.MOD_LOG,
                KapokWoodModBlocks.MOD_WOOD,
                KapokWoodModBlocks.STRIPPED_MOD_LOG,
                KapokWoodModBlocks.STRIPPED_MOD_WOOD,
                KapokWoodModBlocks.MOD_PLANKS,
                KapokWoodModBlocks.MOD_STAIRS,
                KapokWoodModBlocks.MOD_SLAB,
                KapokWoodModBlocks.MOD_BUTTON,
                KapokWoodModBlocks.MOD_FENCE,
                KapokWoodModBlocks.MOD_FENCE_GATE,
                KapokWoodModBlocks.MOD_PRESSURE_PLATE,
                KapokWoodModBlocks.MOD_DOOR,
                KapokWoodModBlocks.MOD_TRAPDOOR,
                KapokWoodModBlocks.CACAO_LEAVES,
                KapokWoodModBlocks.CACAO_SAPLING,
                KapokWoodModBlocks.POTTED_CACAO_SAPLING,
                KapokWoodModBlocks.MOD_STANDING_SIGN,
                KapokWoodModBlocks.MOD_WALL_SIGN,
                KapokWoodModBlocks.MOD_HANGING_SIGN,
                KapokWoodModBlocks.MOD_WALL_HANGING_SIGN,
                KapokWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(BlockTags.LEAVES).add(CitrusWoodModBlocks.MOD_LEAVES);
    }
    public void generateMapleBlockTags() {
        generateNaturalWoodBlockTags(
                MapleWoodModTags.Blocks.MOD_LOGS,
                MapleWoodModBlocks.MOD_LOG,
                MapleWoodModBlocks.MOD_WOOD,
                MapleWoodModBlocks.STRIPPED_MOD_LOG,
                MapleWoodModBlocks.STRIPPED_MOD_WOOD,
                MapleWoodModBlocks.MOD_PLANKS,
                MapleWoodModBlocks.MOD_STAIRS,
                MapleWoodModBlocks.MOD_SLAB,
                MapleWoodModBlocks.MOD_BUTTON,
                MapleWoodModBlocks.MOD_FENCE,
                MapleWoodModBlocks.MOD_FENCE_GATE,
                MapleWoodModBlocks.MOD_PRESSURE_PLATE,
                MapleWoodModBlocks.MOD_DOOR,
                MapleWoodModBlocks.MOD_TRAPDOOR,
                MapleWoodModBlocks.MOD_LEAVES,
                MapleWoodModBlocks.MOD_SAPLING,
                MapleWoodModBlocks.POTTED_MOD_SAPLING,
                MapleWoodModBlocks.MOD_STANDING_SIGN,
                MapleWoodModBlocks.MOD_WALL_SIGN,
                MapleWoodModBlocks.MOD_HANGING_SIGN,
                MapleWoodModBlocks.MOD_WALL_HANGING_SIGN,
                MapleWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(BlockTags.LEAVES).add(MapleWoodModBlocks.MIXED_MAPLE_LEAVES);
        valueLookupBuilder(BlockTags.LEAVES).add(MapleWoodModBlocks.RED_MAPLE_LEAVES);
        valueLookupBuilder(BlockTags.LEAVES).add(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES);
    }
    public void generatePineBlockTags() {
        generateNaturalWoodBlockTags(
                PineWoodModTags.Blocks.MOD_LOGS,
                PineWoodModBlocks.MOD_LOG,
                PineWoodModBlocks.MOD_WOOD,
                PineWoodModBlocks.STRIPPED_MOD_LOG,
                PineWoodModBlocks.STRIPPED_MOD_WOOD,
                PineWoodModBlocks.MOD_PLANKS,
                PineWoodModBlocks.MOD_STAIRS,
                PineWoodModBlocks.MOD_SLAB,
                PineWoodModBlocks.MOD_BUTTON,
                PineWoodModBlocks.MOD_FENCE,
                PineWoodModBlocks.MOD_FENCE_GATE,
                PineWoodModBlocks.MOD_PRESSURE_PLATE,
                PineWoodModBlocks.MOD_DOOR,
                PineWoodModBlocks.MOD_TRAPDOOR,
                PineWoodModBlocks.MOD_LEAVES,
                PineWoodModBlocks.MOD_SAPLING,
                PineWoodModBlocks.POTTED_MOD_SAPLING,
                PineWoodModBlocks.MOD_STANDING_SIGN,
                PineWoodModBlocks.MOD_WALL_SIGN,
                PineWoodModBlocks.MOD_HANGING_SIGN,
                PineWoodModBlocks.MOD_WALL_HANGING_SIGN,
                PineWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(BlockTags.LEAVES).add(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES);
        valueLookupBuilder(BlockTags.LEAVES).add(PineWoodModBlocks.SNOWY_PINE_LEAVES);
        valueLookupBuilder(BlockTags.LEAVES).add(PineWoodModBlocks.SNOWY_SPRUCE_LEAVES);
        valueLookupBuilder(BlockTags.SAPLINGS).add(PineWoodModBlocks.SNOWY_PINE_SAPLING);
        valueLookupBuilder(BlockTags.SAPLINGS).add(PineWoodModBlocks.SNOWY_SPRUCE_SAPLING);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(PineWoodModBlocks.POTTED_SNOWY_PINE_SAPLING);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(PineWoodModBlocks.POTTED_SNOWY_SPRUCE_SAPLING);
    }
    public void generateWillowBlockTags() {
        generateNaturalWoodBlockTags(
                WillowWoodModTags.Blocks.MOD_LOGS,
                WillowWoodModBlocks.MOD_LOG,
                WillowWoodModBlocks.MOD_WOOD,
                WillowWoodModBlocks.STRIPPED_MOD_LOG,
                WillowWoodModBlocks.STRIPPED_MOD_WOOD,
                WillowWoodModBlocks.MOD_PLANKS,
                WillowWoodModBlocks.MOD_STAIRS,
                WillowWoodModBlocks.MOD_SLAB,
                WillowWoodModBlocks.MOD_BUTTON,
                WillowWoodModBlocks.MOD_FENCE,
                WillowWoodModBlocks.MOD_FENCE_GATE,
                WillowWoodModBlocks.MOD_PRESSURE_PLATE,
                WillowWoodModBlocks.MOD_DOOR,
                WillowWoodModBlocks.MOD_TRAPDOOR,
                WillowWoodModBlocks.MOD_LEAVES,
                WillowWoodModBlocks.MOD_SAPLING,
                WillowWoodModBlocks.POTTED_MOD_SAPLING,
                WillowWoodModBlocks.MOD_STANDING_SIGN,
                WillowWoodModBlocks.MOD_WALL_SIGN,
                WillowWoodModBlocks.MOD_HANGING_SIGN,
                WillowWoodModBlocks.MOD_WALL_HANGING_SIGN,
                WillowWoodModBlocks.MOD_SHELF
        );
    }

    public void generatePetrifiedBlockTags() {
        /* NON-FLAMMABLE + PICKAXE MINEABLE */
        valueLookupBuilder(PetrifiedWoodModTags.Blocks.MOD_LOGS)
                .add(PetrifiedWoodModBlocks.MOD_LOG)
                .add(PetrifiedWoodModBlocks.MOD_WOOD)
                .add(PetrifiedWoodModBlocks.STRIPPED_MOD_LOG)
                .add(PetrifiedWoodModBlocks.STRIPPED_MOD_WOOD);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).addTag(PetrifiedWoodModTags.Blocks.MOD_LOGS);
        valueLookupBuilder(BlockTags.COMPLETES_FIND_TREE_TUTORIAL).addTag(PetrifiedWoodModTags.Blocks.MOD_LOGS);
        valueLookupBuilder(BlockTags.LAVA_POOL_STONE_CANNOT_REPLACE).addTag(PetrifiedWoodModTags.Blocks.MOD_LOGS);
        valueLookupBuilder(BlockTags.PARROTS_SPAWNABLE_ON).addTag(PetrifiedWoodModTags.Blocks.MOD_LOGS);
        valueLookupBuilder(BlockTags.SNAPS_GOAT_HORN).addTag(PetrifiedWoodModTags.Blocks.MOD_LOGS);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(PetrifiedWoodModBlocks.MOD_PLANKS);

        valueLookupBuilder(BlockTags.STAIRS).add(PetrifiedWoodModBlocks.MOD_STAIRS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(PetrifiedWoodModBlocks.MOD_STAIRS);

        valueLookupBuilder(BlockTags.SLABS).add(PetrifiedWoodModBlocks.MOD_SLAB);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(PetrifiedWoodModBlocks.MOD_SLAB);

        valueLookupBuilder(BlockTags.DOORS).add(PetrifiedWoodModBlocks.MOD_DOOR);
        valueLookupBuilder(BlockTags.MOB_INTERACTABLE_DOORS).add(PetrifiedWoodModBlocks.MOD_DOOR);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(PetrifiedWoodModBlocks.MOD_DOOR);

        valueLookupBuilder(BlockTags.TRAPDOORS).add(PetrifiedWoodModBlocks.MOD_TRAPDOOR);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(PetrifiedWoodModBlocks.MOD_TRAPDOOR);

        valueLookupBuilder(BlockTags.FENCES).add(PetrifiedWoodModBlocks.MOD_FENCE);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(PetrifiedWoodModBlocks.MOD_FENCE);

        valueLookupBuilder(BlockTags.STONE_BUTTONS).add(PetrifiedWoodModBlocks.MOD_BUTTON);

        valueLookupBuilder(BlockTags.STONE_PRESSURE_PLATES).add(PetrifiedWoodModBlocks.MOD_PRESSURE_PLATE);

    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        generateAzaleaBlockTags();
        generateBaobabBlockTags();
        generateChollaBlockTags();
        generateChorusBlockTags();
        generateCitrusBlockTags();
        generateDogwoodBlockTags();
        generateKapokBlockTags();
        generateMapleBlockTags();
        generatePetrifiedBlockTags();
        generatePineBlockTags();
        generateWillowBlockTags();

        valueLookupBuilder(BlockTags.DIRT).add(ModBlocks.LOOSE_DIRT);
        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE).add(ModBlocks.LOOSE_DIRT);
        valueLookupBuilder(BlockTags.BIG_DRIPLEAF_PLACEABLE).add(ModBlocks.LOOSE_DIRT);
        valueLookupBuilder(BlockTags.CONVERTABLE_TO_MUD).add(ModBlocks.LOOSE_DIRT);
        valueLookupBuilder(BlockTags.FOXES_SPAWNABLE_ON).add(ModBlocks.LOOSE_DIRT);
        valueLookupBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(ModBlocks.LOOSE_DIRT);
        valueLookupBuilder(BlockTags.WOLVES_SPAWNABLE_ON).add(ModBlocks.LOOSE_DIRT);
        valueLookupBuilder(BlockTags.DIRT).add(ModBlocks.TUBERED_DIRT);
        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE).add(ModBlocks.TUBERED_DIRT);
        valueLookupBuilder(BlockTags.BIG_DRIPLEAF_PLACEABLE).add(ModBlocks.TUBERED_DIRT);
        valueLookupBuilder(BlockTags.CONVERTABLE_TO_MUD).add(ModBlocks.TUBERED_DIRT);
        valueLookupBuilder(BlockTags.FOXES_SPAWNABLE_ON).add(ModBlocks.TUBERED_DIRT);
        valueLookupBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(ModBlocks.TUBERED_DIRT);
        valueLookupBuilder(BlockTags.WOLVES_SPAWNABLE_ON).add(ModBlocks.TUBERED_DIRT);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_MUSHROOMS).add(ModBlocks.QUEEN_ANNES_LACE);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_TREES).add(ModBlocks.QUEEN_ANNES_LACE);
        valueLookupBuilder(BlockTags.REPLACEABLE).add(ModBlocks.QUEEN_ANNES_LACE);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_MUSHROOMS).add(ModBlocks.SEA_BEET);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_TREES).add(ModBlocks.SEA_BEET);
        valueLookupBuilder(BlockTags.REPLACEABLE).add(ModBlocks.SEA_BEET);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_BRICKS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_BRICK_SLAB);
        valueLookupBuilder(BlockTags.STAIRS).add(ModBuildingBlocks.MOSSY_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.SLABS).add(ModBuildingBlocks.MOSSY_BRICK_SLAB);
        valueLookupBuilder(BlockTags.WALLS).add(ModBuildingBlocks.MOSSY_BRICK_WALL);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_TUFF_BRICKS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_TUFF_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_TUFF_BRICK_SLAB);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_TUFF_BRICK_WALL);
        valueLookupBuilder(BlockTags.STAIRS).add(ModBuildingBlocks.MOSSY_TUFF_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.SLABS).add(ModBuildingBlocks.MOSSY_TUFF_BRICK_SLAB);
        valueLookupBuilder(BlockTags.WALLS).add(ModBuildingBlocks.MOSSY_TUFF_BRICK_WALL);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICKS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_SLAB);
        valueLookupBuilder(BlockTags.STAIRS).add(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.SLABS).add(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_SLAB);
        valueLookupBuilder(BlockTags.WALLS).add(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_WALL);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB);
        valueLookupBuilder(BlockTags.STAIRS).add(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS);
        valueLookupBuilder(BlockTags.SLABS).add(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB);
        valueLookupBuilder(BlockTags.WALLS).add(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_WALL);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.SMOOTH_DEEPSLATE);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.SMOOTH_DEEPSLATE_SLAB);
        valueLookupBuilder(BlockTags.SLABS).add(ModBuildingBlocks.SMOOTH_DEEPSLATE_SLAB);

        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.PACKED_SNOW);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.SNOW_BRICKS);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBuildingBlocks.CHISELED_SNOW_BRICKS);
        valueLookupBuilder(BlockTags.SLABS).add(ModBuildingBlocks.SNOW_BRICK_SLAB);
        valueLookupBuilder(BlockTags.STAIRS).add(ModBuildingBlocks.SNOW_BRICK_STAIRS);
        valueLookupBuilder(BlockTags.WALLS).add(ModBuildingBlocks.SNOW_BRICK_WALL);

        valueLookupBuilder(BlockTags.WALLS).add(ModBuildingBlocks.POLISHED_ANDESITE_WALL);
        valueLookupBuilder(BlockTags.WALLS).add(ModBuildingBlocks.POLISHED_DIORITE_WALL);
        valueLookupBuilder(BlockTags.WALLS).add(ModBuildingBlocks.POLISHED_GRANITE_WALL);

        valueLookupBuilder(BlockTags.REPLACEABLE_BY_MUSHROOMS).add(ModFloraBlocks.TRUNK_ATTACHED_BROWN_MUSHROOM);

        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_CACTUS_FLOWER);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_ROSE);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_PEONY);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_LILAC);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_SUGAR_CANE);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_SUNFLOWER);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_MONSTERA);

        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(ModFloraBlocks.VIOLET);
        valueLookupBuilder(BlockTags.FLOWERS).add(ModFloraBlocks.VIOLET);
        valueLookupBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(ModFloraBlocks.VIOLET);
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(ModFloraBlocks.FORGET_ME_NOT);
        valueLookupBuilder(BlockTags.FLOWERS).add(ModFloraBlocks.FORGET_ME_NOT);
        valueLookupBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(ModFloraBlocks.FORGET_ME_NOT);
        valueLookupBuilder(BlockTags.EDIBLE_FOR_SHEEP).add(ModFloraBlocks.CLOVER);
        valueLookupBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(ModFloraBlocks.CLOVER);
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(ModFloraBlocks.MONSTERA);
        valueLookupBuilder(BlockTags.FLOWERS).add(ModFloraBlocks.MONSTERA);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_MUSHROOMS).add(ModFloraBlocks.MONSTERA);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_TREES).add(ModFloraBlocks.MONSTERA);
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(ModFloraBlocks.YELLOW_TULIP);
        valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModFloraBlocks.YELLOW_TULIP);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_YELLOW_TULIP);
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(ModFloraBlocks.PURPLE_TULIP);
        valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModFloraBlocks.PURPLE_TULIP);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_PURPLE_TULIP);
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(ModFloraBlocks.HELLEBORE);
        valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModFloraBlocks.HELLEBORE);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_HELLEBORE);
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(ModFloraBlocks.GIANT_PADMA);
        valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModFloraBlocks.GIANT_PADMA);

        valueLookupBuilder(ModTags.Blocks.WATER_LILIES).add(ModFloraBlocks.WHITE_WATER_LILY);
        valueLookupBuilder(ModTags.Blocks.WATER_LILIES).add(ModFloraBlocks.BLUE_WATER_LILY);
        valueLookupBuilder(ModTags.Blocks.WATER_LILIES).add(ModFloraBlocks.PINK_WATER_LILY);
        valueLookupBuilder(ModTags.Blocks.WATER_LILIES).add(ModFloraBlocks.PURPLE_WATER_LILY);

        valueLookupBuilder(BlockTags.FROG_PREFER_JUMP_TO).addTag(ModTags.Blocks.WATER_LILIES);
        valueLookupBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).addTag(ModTags.Blocks.WATER_LILIES);
        valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).addTag(ModTags.Blocks.WATER_LILIES);
        valueLookupBuilder(BlockTags.FLOWERS).addTag(ModTags.Blocks.WATER_LILIES);

        valueLookupBuilder(ModTags.Blocks.PUMPKINS).add(Blocks.PUMPKIN);
        valueLookupBuilder(ModTags.Blocks.CARVED_PUMPKINS).add(Blocks.CARVED_PUMPKIN);
        valueLookupBuilder(ModTags.Blocks.JACK_O_LANTERNS).add(Blocks.JACK_O_LANTERN);
        valueLookupBuilder(ModTags.Blocks.PUMPKINS).add(ModPumpkinBlocks.WHITE_PUMPKIN);
        valueLookupBuilder(ModTags.Blocks.CARVED_PUMPKINS).add(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN);
        valueLookupBuilder(ModTags.Blocks.JACK_O_LANTERNS).add(ModPumpkinBlocks.WHITE_JACK_O_LANTERN);
        valueLookupBuilder(ModTags.Blocks.JACK_O_LANTERNS).add(ModPumpkinBlocks.SOUL_JACK_O_LANTERN);
        valueLookupBuilder(ModTags.Blocks.PUMPKINS).add(ModPumpkinBlocks.GREEN_PUMPKIN);
        valueLookupBuilder(ModTags.Blocks.CARVED_PUMPKINS).add(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN);
        valueLookupBuilder(ModTags.Blocks.JACK_O_LANTERNS).add(ModPumpkinBlocks.GREEN_JACK_O_LANTERN);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModPumpkinBlocks.WHITE_PUMPKIN);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModPumpkinBlocks.WHITE_JACK_O_LANTERN);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModPumpkinBlocks.SOUL_JACK_O_LANTERN);
        valueLookupBuilder(BlockTags.PIGLIN_REPELLENTS).add(ModPumpkinBlocks.SOUL_JACK_O_LANTERN);
        valueLookupBuilder(BlockTags.CROPS).add(ModPumpkinBlocks.WHITE_PUMPKIN_STEM);
        valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE).add(ModPumpkinBlocks.WHITE_PUMPKIN);
        valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE).add(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN);
        valueLookupBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModPumpkinBlocks.WHITE_PUMPKIN_STEM);
        valueLookupBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModPumpkinBlocks.ATTACHED_WHITE_PUMPKIN_STEM);
        valueLookupBuilder(BlockTags.SWORD_EFFICIENT).add(ModPumpkinBlocks.WHITE_PUMPKIN);
        valueLookupBuilder(BlockTags.SWORD_EFFICIENT).add(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN);
        valueLookupBuilder(BlockTags.SWORD_EFFICIENT).add(ModPumpkinBlocks.WHITE_JACK_O_LANTERN);
        valueLookupBuilder(BlockTags.SWORD_EFFICIENT).add(ModPumpkinBlocks.SOUL_JACK_O_LANTERN);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModPumpkinBlocks.GREEN_PUMPKIN);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN);
        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModPumpkinBlocks.GREEN_JACK_O_LANTERN);
        valueLookupBuilder(BlockTags.CROPS).add(ModPumpkinBlocks.GREEN_PUMPKIN_STEM);
        valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE).add(ModPumpkinBlocks.GREEN_PUMPKIN);
        valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE).add(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN);
        valueLookupBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModPumpkinBlocks.GREEN_PUMPKIN_STEM);
        valueLookupBuilder(BlockTags.MAINTAINS_FARMLAND).add(ModPumpkinBlocks.ATTACHED_GREEN_PUMPKIN_STEM);
        valueLookupBuilder(BlockTags.SWORD_EFFICIENT).add(ModPumpkinBlocks.GREEN_PUMPKIN);
        valueLookupBuilder(BlockTags.SWORD_EFFICIENT).add(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN);
        valueLookupBuilder(BlockTags.SWORD_EFFICIENT).add(ModPumpkinBlocks.GREEN_JACK_O_LANTERN);

        valueLookupBuilder(BlockTags.EDIBLE_FOR_SHEEP).add(ModFloraBlocks.SNOWY_SHORT_GRASS);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_MUSHROOMS).add(ModFloraBlocks.SNOWY_SHORT_GRASS);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_TREES).add(ModFloraBlocks.SNOWY_SHORT_GRASS);
        valueLookupBuilder(BlockTags.REPLACEABLE).add(ModFloraBlocks.SNOWY_SHORT_GRASS);
        valueLookupBuilder(BlockTags.EDIBLE_FOR_SHEEP).add(ModFloraBlocks.SNOWY_FERN);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_MUSHROOMS).add(ModFloraBlocks.SNOWY_FERN);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_TREES).add(ModFloraBlocks.SNOWY_FERN);
        valueLookupBuilder(BlockTags.REPLACEABLE).add(ModFloraBlocks.SNOWY_FERN);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_SNOWY_FERN);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_MUSHROOMS).add(ModFloraBlocks.SNOWY_BUSH);
        valueLookupBuilder(BlockTags.REPLACEABLE_BY_TREES).add(ModFloraBlocks.SNOWY_BUSH);
        valueLookupBuilder(BlockTags.REPLACEABLE).add(ModFloraBlocks.SNOWY_BUSH);

        valueLookupBuilder(BlockTags.ENDERMAN_HOLDABLE).add(ModFloraBlocks.SMALL_CACTUS);
        valueLookupBuilder(BlockTags.HAPPY_GHAST_AVOIDS).add(ModFloraBlocks.SMALL_CACTUS);
        valueLookupBuilder(BlockTags.FALL_DAMAGE_RESETTING).add(ModFloraBlocks.SMALL_CACTUS);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModFloraBlocks.POTTED_SMALL_CACTUS);

        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.DANDELION);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.POPPY);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.CORNFLOWER);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.ALLIUM);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.BLUE_ORCHID);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.OXEYE_DAISY);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.AZURE_BLUET);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.RED_TULIP);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.ORANGE_TULIP);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.WHITE_TULIP);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.PINK_TULIP);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.LILY_OF_THE_VALLEY);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.LILAC);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.PEONY);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.ROSE_BUSH);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.SUNFLOWER);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.TORCHFLOWER);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.PITCHER_PLANT);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.OPEN_EYEBLOSSOM);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.CLOSED_EYEBLOSSOM);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.WITHER_ROSE);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(Blocks.CACTUS_FLOWER);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(ModFloraBlocks.MONSTERA);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(ModFloraBlocks.YELLOW_TULIP);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(ModFloraBlocks.PURPLE_TULIP);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(ModFloraBlocks.HELLEBORE);
        valueLookupBuilder(ModTags.Blocks.MOOBLOOM_VARIANT_FLOWERS).add(ModFloraBlocks.GIANT_PADMA);

    }
}
