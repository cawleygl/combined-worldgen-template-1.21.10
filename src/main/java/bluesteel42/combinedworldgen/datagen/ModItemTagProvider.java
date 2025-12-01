package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.block.building.ModBuildingBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.item.ModItems;
import bluesteel42.combinedworldgen.util.ModTags;
import bluesteel42.combinedworldgen.wood.azalea.block.AzaleaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.azalea.entity.AzaleaWoodModRafts;
import bluesteel42.combinedworldgen.wood.azalea.item.AzaleaWoodModItems;
import bluesteel42.combinedworldgen.wood.azalea.util.AzaleaWoodModTags;
import bluesteel42.combinedworldgen.wood.baobab.block.BaobabWoodModBlocks;
import bluesteel42.combinedworldgen.wood.baobab.entity.BaobabWoodModBoats;
import bluesteel42.combinedworldgen.wood.baobab.item.BaobabWoodModItems;
import bluesteel42.combinedworldgen.wood.baobab.util.BaobabWoodModTags;
import bluesteel42.combinedworldgen.wood.cholla.block.ChollaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.cholla.entity.ChollaWoodModRafts;
import bluesteel42.combinedworldgen.wood.cholla.item.ChollaWoodModItems;
import bluesteel42.combinedworldgen.wood.cholla.util.ChollaWoodModTags;
import bluesteel42.combinedworldgen.wood.citrus.block.CitrusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.citrus.entity.CitrusWoodModBoats;
import bluesteel42.combinedworldgen.wood.citrus.item.CitrusWoodModItems;
import bluesteel42.combinedworldgen.wood.citrus.util.CitrusWoodModTags;
import bluesteel42.combinedworldgen.wood.dogwood.block.DogwoodWoodModBlocks;
import bluesteel42.combinedworldgen.wood.dogwood.entity.DogwoodWoodModBoats;
import bluesteel42.combinedworldgen.wood.dogwood.item.DogwoodWoodModItems;
import bluesteel42.combinedworldgen.wood.dogwood.util.DogwoodWoodModTags;
import bluesteel42.combinedworldgen.wood.kapok.block.KapokWoodModBlocks;
import bluesteel42.combinedworldgen.wood.kapok.entity.KapokWoodModBoats;
import bluesteel42.combinedworldgen.wood.kapok.item.KapokWoodModItems;
import bluesteel42.combinedworldgen.wood.kapok.util.KapokWoodModTags;
import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
import bluesteel42.combinedworldgen.wood.maple.entity.MapleWoodModBoats;
import bluesteel42.combinedworldgen.wood.maple.item.MapleWoodModItems;
import bluesteel42.combinedworldgen.wood.maple.util.MapleWoodModTags;
import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import bluesteel42.combinedworldgen.wood.petrified.util.PetrifiedWoodModTags;
import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import bluesteel42.combinedworldgen.wood.pine.entity.PineWoodModBoats;
import bluesteel42.combinedworldgen.wood.pine.item.PineWoodModItems;
import bluesteel42.combinedworldgen.wood.pine.util.PineWoodModTags;
import bluesteel42.combinedworldgen.wood.willow.block.WillowWoodModBlocks;
import bluesteel42.combinedworldgen.wood.willow.entity.WillowWoodModBoats;
import bluesteel42.combinedworldgen.wood.willow.item.WillowWoodModItems;
import bluesteel42.combinedworldgen.wood.willow.util.WillowWoodModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    public void generateNaturalWoodItemTags(
            TagKey<Item> logTag,
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
            Item sign,
            Item hangingSign,
            Item boat,
            Item chestBoat,
            Block shelf
    ) {
        valueLookupBuilder(logTag).add(log.asItem()).add(strippedLog.asItem());
        valueLookupBuilder(logTag).add(wood.asItem()).add(strippedWood.asItem());
        valueLookupBuilder(ItemTags.LOGS_THAT_BURN).addTag(logTag);
        valueLookupBuilder(ItemTags.PLANKS).add(planks.asItem());
        valueLookupBuilder(ItemTags.WOODEN_STAIRS).add(stairs.asItem());
        valueLookupBuilder(ItemTags.WOODEN_SLABS).add(slab.asItem());
        valueLookupBuilder(ItemTags.WOODEN_DOORS).add(door.asItem());
        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS).add(trapdoor.asItem());
        valueLookupBuilder(ItemTags.WOODEN_FENCES).add(fence.asItem());
        valueLookupBuilder(ItemTags.FENCE_GATES).add(fenceGate.asItem());
        valueLookupBuilder(ItemTags.WOODEN_BUTTONS).add(button.asItem());
        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(pressurePlate.asItem());
        valueLookupBuilder(ItemTags.SIGNS).add(sign);
        valueLookupBuilder(ItemTags.HANGING_SIGNS).add(hangingSign);
        valueLookupBuilder(ItemTags.BOATS).add(boat);
        valueLookupBuilder(ItemTags.CHEST_BOATS).add(chestBoat);
        valueLookupBuilder(ItemTags.WOODEN_SHELVES).add(shelf.asItem());
        valueLookupBuilder(ItemTags.LEAVES).add(leaves.asItem());
        valueLookupBuilder(ItemTags.SAPLINGS).add(sapling.asItem());
    }
    public void generateCombinedWoodItemTags(
            TagKey<Item> logTag,
            Block log,
            Block strippedLog,
            Block planks,
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
            Item sign,
            Item hangingSign,
            Item boat,
            Item chestBoat,
            Block shelf
    ) {
        valueLookupBuilder(logTag).add(log.asItem()).add(strippedLog.asItem());
        valueLookupBuilder(ItemTags.PLANKS).add(planks.asItem());
        valueLookupBuilder(ItemTags.WOODEN_STAIRS).add(stairs.asItem());
        valueLookupBuilder(ItemTags.STAIRS).add(mosaicStairs.asItem());
        valueLookupBuilder(ItemTags.WOODEN_SLABS).add(slab.asItem());
        valueLookupBuilder(ItemTags.SLABS).add(mosaicSlab.asItem());
        valueLookupBuilder(ItemTags.WOODEN_DOORS).add(door.asItem());
        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS).add(trapdoor.asItem());
        valueLookupBuilder(ItemTags.WOODEN_FENCES).add(fence.asItem());
        valueLookupBuilder(ItemTags.FENCE_GATES).add(fenceGate.asItem());
        valueLookupBuilder(ItemTags.WOODEN_BUTTONS).add(button.asItem());
        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(pressurePlate.asItem());
        valueLookupBuilder(ItemTags.SIGNS).add(sign);
        valueLookupBuilder(ItemTags.HANGING_SIGNS).add(hangingSign);
        valueLookupBuilder(ItemTags.BOATS).add(boat);
        valueLookupBuilder(ItemTags.CHEST_BOATS).add(chestBoat);
        valueLookupBuilder(ItemTags.WOODEN_SHELVES).add(shelf.asItem());
    }

    public void generateAzaleaItemTags() {
        generateCombinedWoodItemTags(
                AzaleaWoodModTags.Items.MOD_BLOCKS,
                AzaleaWoodModBlocks.MOD_BLOCK,
                AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK,
                AzaleaWoodModBlocks.MOD_PLANKS,
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
                AzaleaWoodModItems.MOD_SIGN,
                AzaleaWoodModItems.MOD_HANGING_SIGN,
                AzaleaWoodModRafts.MOD_RAFT,
                AzaleaWoodModRafts.MOD_CHEST_RAFT,
                AzaleaWoodModBlocks.MOD_SHELF
        );
        valueLookupBuilder(AzaleaWoodModTags.Items.AZALEA_STEMS)
                .add(AzaleaWoodModBlocks.AZALEA_STEM.asItem())
                .add(AzaleaWoodModBlocks.LEAFY_AZALEA_STEM.asItem())
                .add(AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM.asItem());
        valueLookupBuilder(ItemTags.LOGS).addTag(AzaleaWoodModTags.Items.AZALEA_STEMS);
    }
    public void generateBaobabItemTags() {
        generateNaturalWoodItemTags(
                BaobabWoodModTags.Items.MOD_LOGS,
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
                BaobabWoodModItems.MOD_SIGN,
                BaobabWoodModItems.MOD_HANGING_SIGN,
                BaobabWoodModBoats.MOD_BOAT,
                BaobabWoodModBoats.MOD_CHEST_BOAT,
                BaobabWoodModBlocks.MOD_SHELF
        );
    }
    public void generateChollaItemTags() {
        generateCombinedWoodItemTags(
                ChollaWoodModTags.Items.MOD_BLOCKS,
                ChollaWoodModBlocks.MOD_BLOCK,
                ChollaWoodModBlocks.STRIPPED_MOD_BLOCK,
                ChollaWoodModBlocks.MOD_PLANKS,
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
                ChollaWoodModItems.MOD_SIGN,
                ChollaWoodModItems.MOD_HANGING_SIGN,
                ChollaWoodModRafts.MOD_RAFT,
                ChollaWoodModRafts.MOD_CHEST_RAFT,
                ChollaWoodModBlocks.MOD_SHELF
        );
    }
    public void generateCitrusItemTags() {
        generateNaturalWoodItemTags(
                CitrusWoodModTags.Items.MOD_LOGS,
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
                CitrusWoodModItems.MOD_SIGN,
                CitrusWoodModItems.MOD_HANGING_SIGN,
                CitrusWoodModBoats.MOD_BOAT,
                CitrusWoodModBoats.MOD_CHEST_BOAT,
                CitrusWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(ItemTags.BEE_FOOD).add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES.asItem());
        valueLookupBuilder(ItemTags.FLOWERS).add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES.asItem());
        valueLookupBuilder(ItemTags.LEAVES).add(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES.asItem());

    }
    public void generateDogwoodItemTags() {
        generateNaturalWoodItemTags(
                DogwoodWoodModTags.Items.MOD_LOGS,
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
                DogwoodWoodModItems.MOD_SIGN,
                DogwoodWoodModItems.MOD_HANGING_SIGN,
                DogwoodWoodModBoats.MOD_BOAT,
                DogwoodWoodModBoats.MOD_CHEST_BOAT,
                DogwoodWoodModBlocks.MOD_SHELF
        );
        /* FLOWER LEAVES */
        valueLookupBuilder(ItemTags.BEE_FOOD).add(DogwoodWoodModBlocks.MOD_LEAVES.asItem());
        valueLookupBuilder(ItemTags.FLOWERS).add(DogwoodWoodModBlocks.MOD_LEAVES.asItem());
    }
    public void generateKapokItemTags() {
        generateNaturalWoodItemTags(
                KapokWoodModTags.Items.MOD_LOGS,
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
                KapokWoodModItems.MOD_SIGN,
                KapokWoodModItems.MOD_HANGING_SIGN,
                KapokWoodModBoats.MOD_BOAT,
                KapokWoodModBoats.MOD_CHEST_BOAT,
                KapokWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(ItemTags.LEAVES).add(KapokWoodModBlocks.MOD_LEAVES.asItem());
    }
    public void generateMapleItemTags() {
        generateNaturalWoodItemTags(
                MapleWoodModTags.Items.MOD_LOGS,
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
                MapleWoodModItems.MOD_SIGN,
                MapleWoodModItems.MOD_HANGING_SIGN,
                MapleWoodModBoats.MOD_BOAT,
                MapleWoodModBoats.MOD_CHEST_BOAT,
                MapleWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(ItemTags.LEAVES).add(MapleWoodModBlocks.MIXED_MAPLE_LEAVES.asItem());
        valueLookupBuilder(ItemTags.LEAVES).add(MapleWoodModBlocks.RED_MAPLE_LEAVES.asItem());
        valueLookupBuilder(ItemTags.LEAVES).add(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES.asItem());
    }
    public void generatePineItemTags() {
        generateNaturalWoodItemTags(
                PineWoodModTags.Items.MOD_LOGS,
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
                PineWoodModItems.MOD_SIGN,
                PineWoodModItems.MOD_HANGING_SIGN,
                PineWoodModBoats.MOD_BOAT,
                PineWoodModBoats.MOD_CHEST_BOAT,
                PineWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        valueLookupBuilder(ItemTags.LEAVES).add(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES.asItem());
        valueLookupBuilder(ItemTags.LEAVES).add(PineWoodModBlocks.SNOWY_PINE_LEAVES.asItem());
        valueLookupBuilder(ItemTags.LEAVES).add(PineWoodModBlocks.SNOWY_SPRUCE_LEAVES.asItem());
        valueLookupBuilder(ItemTags.SAPLINGS).add(PineWoodModBlocks.SNOWY_PINE_SAPLING.asItem());
        valueLookupBuilder(ItemTags.SAPLINGS).add(PineWoodModBlocks.SNOWY_SPRUCE_SAPLING.asItem());
    }
    public void generateWillowItemTags() {
        generateNaturalWoodItemTags(
                WillowWoodModTags.Items.MOD_LOGS,
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
                WillowWoodModItems.MOD_SIGN,
                WillowWoodModItems.MOD_HANGING_SIGN,
                WillowWoodModBoats.MOD_BOAT,
                WillowWoodModBoats.MOD_CHEST_BOAT,
                WillowWoodModBlocks.MOD_SHELF
        );
    }

    public void generatePetrifiedItemTags() {
        /* NON-FLAMMABLE + PICKAXE MINEABLE */
        valueLookupBuilder(PetrifiedWoodModTags.Items.MOD_LOGS)
                .add(PetrifiedWoodModBlocks.MOD_LOG.asItem())
                .add(PetrifiedWoodModBlocks.MOD_WOOD.asItem());

        valueLookupBuilder(ItemTags.COMPLETES_FIND_TREE_TUTORIAL).addTag(PetrifiedWoodModTags.Items.MOD_LOGS);
        valueLookupBuilder(ItemTags.STONE_TOOL_MATERIALS).add(PetrifiedWoodModBlocks.MOD_PLANKS.asItem());
        valueLookupBuilder(ItemTags.STAIRS).add(PetrifiedWoodModBlocks.MOD_STAIRS.asItem());
        valueLookupBuilder(ItemTags.SLABS).add(PetrifiedWoodModBlocks.MOD_SLAB.asItem());
        valueLookupBuilder(ItemTags.DOORS).add(PetrifiedWoodModBlocks.MOD_DOOR.asItem());
        valueLookupBuilder(ItemTags.TRAPDOORS).add(PetrifiedWoodModBlocks.MOD_TRAPDOOR.asItem());
        valueLookupBuilder(ItemTags.FENCES).add(PetrifiedWoodModBlocks.MOD_FENCE.asItem());
        valueLookupBuilder(ItemTags.STONE_BUTTONS).add(PetrifiedWoodModBlocks.MOD_BUTTON.asItem());

        valueLookupBuilder(ItemTags.NON_FLAMMABLE_WOOD)
                .addTag(PetrifiedWoodModTags.Items.MOD_LOGS)
                .add(PetrifiedWoodModBlocks.MOD_PLANKS.asItem())
                .add(PetrifiedWoodModBlocks.MOD_STAIRS.asItem())
                .add(PetrifiedWoodModBlocks.MOD_SLAB.asItem())
                .add(PetrifiedWoodModBlocks.MOD_DOOR.asItem())
                .add(PetrifiedWoodModBlocks.MOD_TRAPDOOR.asItem())
                .add(PetrifiedWoodModBlocks.MOD_FENCE.asItem())
                .add(PetrifiedWoodModBlocks.MOD_BUTTON.asItem())
                .add(PetrifiedWoodModBlocks.MOD_PRESSURE_PLATE.asItem());
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        generateAzaleaItemTags();
        generateBaobabItemTags();
        generateChollaItemTags();
        generateCitrusItemTags();
        generateDogwoodItemTags();
        generateKapokItemTags();
        generateMapleItemTags();
        generatePetrifiedItemTags();
        generatePineItemTags();
        generateWillowItemTags();

        valueLookupBuilder(ItemTags.STAIRS).add(ModBuildingBlocks.MOSSY_BRICK_STAIRS.asItem());
        valueLookupBuilder(ItemTags.SLABS).add(ModBuildingBlocks.MOSSY_BRICK_SLAB.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBuildingBlocks.MOSSY_BRICK_WALL.asItem());

        valueLookupBuilder(ItemTags.STAIRS).add(ModBuildingBlocks.MOSSY_TUFF_BRICK_STAIRS.asItem());
        valueLookupBuilder(ItemTags.SLABS).add(ModBuildingBlocks.MOSSY_TUFF_BRICK_SLAB.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBuildingBlocks.MOSSY_TUFF_BRICK_WALL.asItem());

        valueLookupBuilder(ItemTags.STAIRS).add(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.asItem());
        valueLookupBuilder(ItemTags.SLABS).add(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_SLAB.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_WALL.asItem());

        valueLookupBuilder(ItemTags.STAIRS).add(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.asItem());
        valueLookupBuilder(ItemTags.SLABS).add(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_WALL.asItem());

        valueLookupBuilder(ItemTags.SLABS).add(ModBuildingBlocks.SMOOTH_DEEPSLATE_SLAB.asItem());

        valueLookupBuilder(ItemTags.STAIRS).add(ModBuildingBlocks.SNOW_BRICK_STAIRS.asItem());
        valueLookupBuilder(ItemTags.SLABS).add(ModBuildingBlocks.SNOW_BRICK_SLAB.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBuildingBlocks.SNOW_BRICK_WALL.asItem());

        valueLookupBuilder(ItemTags.WALLS).add(ModBuildingBlocks.POLISHED_ANDESITE_WALL.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBuildingBlocks.POLISHED_DIORITE_WALL.asItem());
        valueLookupBuilder(ItemTags.WALLS).add(ModBuildingBlocks.POLISHED_GRANITE_WALL.asItem());

        valueLookupBuilder(ItemTags.FLOWERS).add(ModFloraBlocks.VIOLET.asItem());
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModFloraBlocks.VIOLET.asItem());
        valueLookupBuilder(ItemTags.FLOWERS).add(ModFloraBlocks.FORGET_ME_NOT.asItem());
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModFloraBlocks.FORGET_ME_NOT.asItem());
        valueLookupBuilder(ItemTags.SMALL_FLOWERS).add(ModFloraBlocks.YELLOW_TULIP.asItem());
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModFloraBlocks.YELLOW_TULIP.asItem());
        valueLookupBuilder(ItemTags.SMALL_FLOWERS).add(ModFloraBlocks.PURPLE_TULIP.asItem());
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModFloraBlocks.PURPLE_TULIP.asItem());
        valueLookupBuilder(ItemTags.SMALL_FLOWERS).add(ModFloraBlocks.HELLEBORE.asItem());
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModFloraBlocks.HELLEBORE.asItem());
        valueLookupBuilder(ItemTags.SMALL_FLOWERS).add(ModFloraBlocks.GIANT_PADMA.asItem());
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModFloraBlocks.GIANT_PADMA.asItem());

        valueLookupBuilder(ItemTags.DIRT).add(ModBlocks.LOOSE_DIRT.asItem());
        valueLookupBuilder(ItemTags.DIRT).add(ModBlocks.TUBERED_DIRT.asItem());

        valueLookupBuilder(ModTags.Items.WATER_LILIES).add(ModFloraBlocks.WHITE_WATER_LILY.asItem());
        valueLookupBuilder(ModTags.Items.WATER_LILIES).add(ModFloraBlocks.BLUE_WATER_LILY.asItem());
        valueLookupBuilder(ModTags.Items.WATER_LILIES).add(ModFloraBlocks.PINK_WATER_LILY.asItem());
        valueLookupBuilder(ModTags.Items.WATER_LILIES).add(ModFloraBlocks.PURPLE_WATER_LILY.asItem());

        valueLookupBuilder(ItemTags.FLOWERS).addTag(ModTags.Items.WATER_LILIES);
        valueLookupBuilder(ItemTags.BEE_FOOD).addTag(ModTags.Items.WATER_LILIES);

        valueLookupBuilder(ModTags.Items.PUMPKINS).add(Blocks.PUMPKIN.asItem());
        valueLookupBuilder(ModTags.Items.PUMPKINS).add(ModPumpkinBlocks.WHITE_PUMPKIN.asItem());
        valueLookupBuilder(ModTags.Items.PUMPKINS).add(ModPumpkinBlocks.GREEN_PUMPKIN.asItem());
        valueLookupBuilder(ItemTags.PIGLIN_REPELLENTS).add(ModPumpkinBlocks.SOUL_JACK_O_LANTERN.asItem());

        valueLookupBuilder(ItemTags.CHICKEN_FOOD).add(ModItems.WHITE_PUMPKIN_SEEDS);
        valueLookupBuilder(ItemTags.PARROT_FOOD).add(ModItems.WHITE_PUMPKIN_SEEDS);
        valueLookupBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN.asItem());
        valueLookupBuilder(ItemTags.VANISHING_ENCHANTABLE).add(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN.asItem());
        valueLookupBuilder(ItemTags.GAZE_DISGUISE_EQUIPMENT).add(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN.asItem());
        valueLookupBuilder(ItemTags.MAP_INVISIBILITY_EQUIPMENT).add(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN.asItem());

        valueLookupBuilder(ItemTags.CHICKEN_FOOD).add(ModItems.GREEN_PUMPKIN_SEEDS);
        valueLookupBuilder(ItemTags.PARROT_FOOD).add(ModItems.GREEN_PUMPKIN_SEEDS);
        valueLookupBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE).add(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN.asItem());
        valueLookupBuilder(ItemTags.VANISHING_ENCHANTABLE).add(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN.asItem());
        valueLookupBuilder(ItemTags.GAZE_DISGUISE_EQUIPMENT).add(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN.asItem());
        valueLookupBuilder(ItemTags.MAP_INVISIBILITY_EQUIPMENT).add(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN.asItem());

        valueLookupBuilder(ItemTags.PARROT_FOOD).add(ModItems.ORANGE);
        valueLookupBuilder(ItemTags.PARROT_POISONOUS_FOOD).add(ModItems.CHOCOLATE_ORANGE);

        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModFloraBlocks.MONSTERA.asItem());
        valueLookupBuilder(ItemTags.FLOWERS).add(ModFloraBlocks.MONSTERA.asItem());

        valueLookupBuilder(ItemTags.EGGS).add(ModItems.SPOTTED_EGG);
        valueLookupBuilder(ItemTags.EGGS).add(ModItems.UMAMI_EGG);

        valueLookupBuilder(ItemTags.CAMEL_FOOD).add(ModFloraBlocks.SMALL_CACTUS.asItem());

        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.WITHER_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.HASTE_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.POISON_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.JUMP_BOOST_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.REGENERATION_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.WEAKNESS_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.FIRE_RESISTANCE_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.NIGHT_VISION_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.NAUSEA_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.BLINDNESS_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.SATURATION_FLORAL_MILK_BOTTLE);
        valueLookupBuilder(ModTags.Items.FLORAL_MILK).add(ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE);
    }
}
