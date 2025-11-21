package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.block.building.ModBuildingBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.item.ModItems;
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
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.recipe.CookingRecipeJsonBuilder.createSmelting;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            private void generateNaturalWoodRecipes(
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
                    Item sign,
                    Item hangingSign,
                    Item boat,
                    Item chestBoat,
                    Block shelf
            ) {
                offerBarkBlockRecipe(wood, log);
                offerBarkBlockRecipe(strippedWood, strippedLog);
                offerPlanksRecipe(planks, logTag, 4);
                createShaped(RecipeCategory.BUILDING_BLOCKS, stairs, 4).pattern("#  ").pattern("## ").pattern("###").input('#', planks).group("wooden_stairs").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, slab, 6).pattern("###").input('#', planks).group("wooden_slab").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShapeless(RecipeCategory.REDSTONE, button, 1).input(planks).group("wooden_button").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, pressurePlate, 1).pattern("##").input('#', planks).group("wooden_pressure_plate").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.DECORATIONS, fence, 3).pattern("W#W").pattern("W#W").input('#', Items.STICK).input('W', planks).group("wooden_fence").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, fenceGate, 1).pattern("#W#").pattern("#W#").input('#', Items.STICK).input('W', planks).group("wooden_fence_gate").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, door, 3).pattern("##").pattern("##").pattern("##").input('#', planks).group("wooden_door").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, trapdoor, 2).pattern("###").pattern("###").input('#', planks).group("wooden_trapdoor").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.DECORATIONS, sign, 3).pattern("###").pattern("###").pattern(" X ").input('#', planks).input('X', Items.STICK).group("wooden_sign").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                offerHangingSignRecipe(hangingSign, strippedLog);
                offerBoatRecipe(boat, planks);
                offerChestBoatRecipe(chestBoat, boat);
                offerShelfRecipe(shelf, strippedLog);
            }
            private void generateCombinedWoodRecipes(
                    TagKey<Item> logTag,
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
                    Item sign,
                    Item hangingSign,
                    Item boat,
                    Item chestBoat,
                    Block shelf
            ) {
                offerPlanksRecipe(planks, logTag, 2);
                offerMosaicRecipe(RecipeCategory.DECORATIONS, mosaic, slab);
                createShaped(RecipeCategory.BUILDING_BLOCKS, stairs, 4).pattern("#  ").pattern("## ").pattern("###").input('#', planks).group("wooden_stairs").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, mosaicStairs, 4).pattern("#  ").pattern("## ").pattern("###").input('#', mosaic).criterion("has_" + getItemPath(mosaic.asItem()), conditionsFromItem(mosaic)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, slab, 6).pattern("###").input('#', planks).group("wooden_slab").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, mosaicSlab, 6).pattern("###").input('#', planks).group("wooden_slab").criterion("has_" + getItemPath(mosaic.asItem()), conditionsFromItem(planks)).offerTo(exporter);
                createShapeless(RecipeCategory.REDSTONE, button, 1).input(planks).group("wooden_button").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, pressurePlate, 1).pattern("##").input('#', planks).group("wooden_pressure_plate").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.DECORATIONS, fence, 3).pattern("W#W").pattern("W#W").input('#', Items.STICK).input('W', planks).group("wooden_fence").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, fenceGate, 1).pattern("#W#").pattern("#W#").input('#', Items.STICK).input('W', planks).group("wooden_fence_gate").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, door, 3).pattern("##").pattern("##").pattern("##").input('#', planks).group("wooden_door").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, trapdoor, 2).pattern("###").pattern("###").input('#', planks).group("wooden_trapdoor").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                createShaped(RecipeCategory.DECORATIONS, sign, 3).pattern("###").pattern("###").pattern(" X ").input('#', planks).input('X', Items.STICK).group("wooden_sign").criterion("has_planks", conditionsFromItem(planks)).offerTo(exporter);
                offerHangingSignRecipe(hangingSign, strippedLog);
                offerBoatRecipe(boat, planks);
                offerChestBoatRecipe(chestBoat, boat);
                offerShelfRecipe(shelf, strippedLog);
            }

            private void offerStandardRecipe(CraftingRecipeJsonBuilder recipe, ItemConvertible input) {
                recipe.criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter);
            }
            private void offerSecondaryRecipe(CraftingRecipeJsonBuilder recipe, ItemConvertible input, ItemConvertible output) {
                recipe.criterion(hasItem(input), conditionsFromItem(input)).offerTo(exporter, convertBetween(output, input));
            }

            private void offerStickFromCombinedWoodOriginItemRecipe(Block block, Block origin){
                createShaped(RecipeCategory.MISC, Items.STICK, 1).input('#', origin).pattern("#").pattern("#").group("sticks").criterion("has_" + getItemPath(origin.asItem()), conditionsFromItem(origin)).offerTo(exporter, "stick_from_" + getItemPath(origin) + "_item");
            }

            private void offerDyeFromPlantRecipes(ItemConvertible dye, ItemConvertible plant) {
                offerShapelessRecipe(dye, plant, getItemPath(dye), 1);
            }
            private void offerPumpkinRecipes(ItemConvertible pumpkin, ItemConvertible carvedPumpkin, ItemConvertible jackOLantern, ItemConvertible seeds) {
                createShaped(RecipeCategory.BUILDING_BLOCKS, jackOLantern, 1)
                        .pattern("A")
                        .pattern("B")
                        .input('A', carvedPumpkin)
                        .input('B', Blocks.TORCH)
                        .criterion(hasItem(carvedPumpkin), conditionsFromItem(carvedPumpkin))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, seeds, 4)
                        .input(pumpkin)
                        .group(getRecipeName(seeds))
                        .criterion(hasItem(pumpkin), conditionsFromItem(pumpkin))
                        .offerTo(exporter, convertBetween(seeds, pumpkin));

            }

            private void offerSlabBlockRecipes(ItemConvertible baseBlock, ItemConvertible slabBlock) {
                offerStandardRecipe(createShaped(RecipeCategory.BUILDING_BLOCKS, slabBlock, 6).input('#', baseBlock).pattern("###"), baseBlock);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, slabBlock, baseBlock, 2);
            }
            private void offerStairsBlockRecipes(ItemConvertible baseBlock, ItemConvertible stairsBlock) {
                offerStandardRecipe(createShaped(RecipeCategory.BUILDING_BLOCKS, stairsBlock, 4).input('#', baseBlock).pattern("#  ").pattern("## ").pattern("###"), baseBlock);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, stairsBlock, baseBlock, 1);
            }
            private void offerWallBlockRecipes(ItemConvertible baseBlock, ItemConvertible wallBlock) {
                offerStandardRecipe(createShaped(RecipeCategory.DECORATIONS, wallBlock, 6).input('#', baseBlock).pattern("###").pattern("###"), baseBlock);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, wallBlock, baseBlock, 1);
            }

            private void offerTransitiveBrickBlockSetStonecuttingRecipes(ItemConvertible originBaseBlock, ItemConvertible intermediateBaseBlock, ItemConvertible slabBlock, ItemConvertible stairsBlock, ItemConvertible wallBlock) {
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, intermediateBaseBlock, originBaseBlock, 1);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, slabBlock, originBaseBlock, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, stairsBlock, originBaseBlock, 1);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, wallBlock, originBaseBlock, 1);
            }
            private void offerBrickBlockSetRecipes(ItemConvertible baseBlock, ItemConvertible slabBlock, ItemConvertible stairsBlock, ItemConvertible wallBlock) {
                offerSlabBlockRecipes(baseBlock, slabBlock);
                offerStairsBlockRecipes(baseBlock, stairsBlock);
                offerWallBlockRecipes(baseBlock, wallBlock);
            }
            private void offerMossifyBlockRecipes(ItemConvertible baseBlock, ItemConvertible mossyBlock) {
                offerSecondaryRecipe(createShapeless(RecipeCategory.BUILDING_BLOCKS, mossyBlock, 1).group(getItemPath(mossyBlock)).input(baseBlock).input(Blocks.MOSS_BLOCK), Blocks.MOSS_BLOCK, mossyBlock);
                offerSecondaryRecipe(createShapeless(RecipeCategory.BUILDING_BLOCKS, mossyBlock, 1).group(getItemPath(mossyBlock)).input(baseBlock).input(Items.VINE), Items.VINE, mossyBlock);
            }
            private void offerPolishedStoneWallBlockRecipes(ItemConvertible baseBlock, ItemConvertible polishedBaseBlock, ItemConvertible wallBlock) {
                offerStandardRecipe(createShaped(RecipeCategory.DECORATIONS, wallBlock, 6).input('#', polishedBaseBlock).pattern("###").pattern("###"), polishedBaseBlock);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, wallBlock, baseBlock, 1);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, wallBlock, polishedBaseBlock, 1);
            }
            private void offerChiseledBrickRecipes(ItemConvertible slabBlock, ItemConvertible baseBlock, ItemConvertible chiseledBlock) {
                offerStandardRecipe(createShaped(RecipeCategory.BUILDING_BLOCKS, chiseledBlock, 1).input('#', slabBlock).pattern("#").pattern("#"), slabBlock);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, chiseledBlock, baseBlock, 1);
            }
            private void offerSmoothStoneRecipes(ItemConvertible baseBlock, ItemConvertible smoothBlock, ItemConvertible slabBlock) {
                offerSmelting(Arrays.asList(baseBlock), RecipeCategory.BUILDING_BLOCKS, smoothBlock, 0.1f, 200, "");
                offerStandardRecipe(createShaped(RecipeCategory.BUILDING_BLOCKS, slabBlock, 6).input('#', smoothBlock).pattern("###"), smoothBlock);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, slabBlock, smoothBlock, 2);
            }
            private ShapedRecipeJsonBuilder createCondense9X9BlockRecipe(ItemConvertible material, ItemConvertible block) {
                return createShaped(RecipeCategory.BUILDING_BLOCKS, block, 1).input('#', material).pattern("###").pattern("###").pattern("###");
            }

            private void offerSnowyBlockRecipes(ItemConvertible baseBlock, ItemConvertible snowyBlock) {
                createShapeless(RecipeCategory.MISC, snowyBlock, 1)
                        .input(baseBlock)
                        .input(Items.SNOWBALL)
                        .criterion(hasItem(snowyBlock), conditionsFromItem(snowyBlock))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.MISC, baseBlock, 1)
                        .input(snowyBlock)
                        .criterion(hasItem(snowyBlock), conditionsFromItem(snowyBlock))
                        .offerTo(exporter, getItemPath(baseBlock) + "_from_" + getItemPath(snowyBlock));
            }


            private void generateAzaleaRecipes() {
                generateCombinedWoodRecipes(
                        AzaleaWoodModTags.Items.MOD_BLOCKS,
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
                        AzaleaWoodModItems.MOD_SIGN,
                        AzaleaWoodModItems.MOD_HANGING_SIGN,
                        AzaleaWoodModRafts.MOD_RAFT,
                        AzaleaWoodModRafts.MOD_CHEST_RAFT,
                        AzaleaWoodModBlocks.MOD_SHELF
                );
                /*  ADDITIONAL BLOCKS */
                offerStickFromCombinedWoodOriginItemRecipe(AzaleaWoodModBlocks.MOD_BLOCK, AzaleaWoodModBlocks.AZALEA_STEM);
                offerCompactingRecipe(RecipeCategory.BUILDING_BLOCKS, AzaleaWoodModBlocks.MOD_BLOCK, AzaleaWoodModBlocks.AZALEA_STEM);
                offerStickFromCombinedWoodOriginItemRecipe(AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK, AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM);
                offerCompactingRecipe(RecipeCategory.BUILDING_BLOCKS, AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK, AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM);
            }
            private void generateBaobabRecipes() {
                generateNaturalWoodRecipes(
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
                        BaobabWoodModItems.MOD_SIGN,
                        BaobabWoodModItems.MOD_HANGING_SIGN,
                        BaobabWoodModBoats.MOD_BOAT,
                        BaobabWoodModBoats.MOD_CHEST_BOAT,
                        BaobabWoodModBlocks.MOD_SHELF
                );
            }
            private void generateChollaRecipes() {
                generateCombinedWoodRecipes(
                        ChollaWoodModTags.Items.MOD_BLOCKS,
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
                        ChollaWoodModItems.MOD_SIGN,
                        ChollaWoodModItems.MOD_HANGING_SIGN,
                        ChollaWoodModRafts.MOD_RAFT,
                        ChollaWoodModRafts.MOD_CHEST_RAFT,
                        ChollaWoodModBlocks.MOD_SHELF
                );
                offerStickFromCombinedWoodOriginItemRecipe(ChollaWoodModBlocks.MOD_BLOCK, ChollaWoodModBlocks.DRIED_CHOLLA);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ChollaWoodModBlocks.MOD_BLOCK, ChollaWoodModBlocks.DRIED_CHOLLA);
            }
            private void generateCitrusRecipes() {
                generateNaturalWoodRecipes(
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
                        CitrusWoodModItems.MOD_SIGN,
                        CitrusWoodModItems.MOD_HANGING_SIGN,
                        CitrusWoodModBoats.MOD_BOAT,
                        CitrusWoodModBoats.MOD_CHEST_BOAT,
                        CitrusWoodModBlocks.MOD_SHELF
                );
            }
            private void generateDogwoodRecipes() {
                generateNaturalWoodRecipes(
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
                        DogwoodWoodModItems.MOD_SIGN,
                        DogwoodWoodModItems.MOD_HANGING_SIGN,
                        DogwoodWoodModBoats.MOD_BOAT,
                        DogwoodWoodModBoats.MOD_CHEST_BOAT,
                        DogwoodWoodModBlocks.MOD_SHELF
                );
            }
            private void generateKapokRecipes() {
                generateNaturalWoodRecipes(
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
                        KapokWoodModItems.MOD_SIGN,
                        KapokWoodModItems.MOD_HANGING_SIGN,
                        KapokWoodModBoats.MOD_BOAT,
                        KapokWoodModBoats.MOD_CHEST_BOAT,
                        KapokWoodModBlocks.MOD_SHELF
                );
                createShapeless(RecipeCategory.BUILDING_BLOCKS, KapokWoodModBlocks.MOD_LEAVES, 1)
                        .input(Blocks.JUNGLE_LEAVES)
                        .criterion(hasItem(Blocks.JUNGLE_LEAVES), conditionsFromItem(Blocks.JUNGLE_LEAVES))
                        .offerTo(exporter, "kapok_leaves_from_vanilla_jungle_leaves");
            }
            private void generateMapleRecipes() {
                generateNaturalWoodRecipes(
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
                        MapleWoodModItems.MOD_SIGN,
                        MapleWoodModItems.MOD_HANGING_SIGN,
                        MapleWoodModBoats.MOD_BOAT,
                        MapleWoodModBoats.MOD_CHEST_BOAT,
                        MapleWoodModBlocks.MOD_SHELF
                );
                /*  ADDITIONAL BLOCKS */
                createShapeless(RecipeCategory.BUILDING_BLOCKS, MapleWoodModBlocks.MIXED_MAPLE_LEAVES, 3)
                        .input(MapleWoodModBlocks.MOD_LEAVES)
                        .input(MapleWoodModBlocks.RED_MAPLE_LEAVES)
                        .input(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES)
                        .criterion(hasItem(MapleWoodModBlocks.MOD_LEAVES), conditionsFromItem(MapleWoodModBlocks.MOD_LEAVES))
                        .criterion(hasItem(MapleWoodModBlocks.RED_MAPLE_LEAVES), conditionsFromItem(MapleWoodModBlocks.RED_MAPLE_LEAVES))
                        .criterion(hasItem(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES), conditionsFromItem(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES))
                        .offerTo(exporter);
            }
            private void generatePineRecipes() {
                generateNaturalWoodRecipes(
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
                        PineWoodModItems.MOD_SIGN,
                        PineWoodModItems.MOD_HANGING_SIGN,
                        PineWoodModBoats.MOD_BOAT,
                        PineWoodModBoats.MOD_CHEST_BOAT,
                        PineWoodModBlocks.MOD_SHELF
                );
                /*  ADDITIONAL BLOCKS */
                createShapeless(RecipeCategory.BUILDING_BLOCKS, PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, 1)
                        .input(Blocks.SPRUCE_LEAVES)
                        .criterion(hasItem(Blocks.SPRUCE_LEAVES), conditionsFromItem(Blocks.SPRUCE_LEAVES))
                        .offerTo(exporter, "modded_spruce_leaves_from_vanilla");
                offerSnowyBlockRecipes(PineWoodModBlocks.MOD_LEAVES, PineWoodModBlocks.SNOWY_PINE_LEAVES);
                offerSnowyBlockRecipes(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, PineWoodModBlocks.SNOWY_SPRUCE_LEAVES);
                offerSnowyBlockRecipes(PineWoodModBlocks.MOD_SAPLING, PineWoodModBlocks.SNOWY_PINE_SAPLING);
                offerSnowyBlockRecipes(Blocks.SPRUCE_SAPLING, PineWoodModBlocks.SNOWY_SPRUCE_SAPLING);
            }
            private void generateWillowRecipes() {
                generateNaturalWoodRecipes(
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
                        WillowWoodModItems.MOD_SIGN,
                        WillowWoodModItems.MOD_HANGING_SIGN,
                        WillowWoodModBoats.MOD_BOAT,
                        WillowWoodModBoats.MOD_CHEST_BOAT,
                        WillowWoodModBlocks.MOD_SHELF
                );
            }

            private void generatePetrifiedRecipes() {
                offerBarkBlockRecipe(PetrifiedWoodModBlocks.MOD_WOOD, PetrifiedWoodModBlocks.MOD_LOG);
                offerPlanksRecipe(PetrifiedWoodModBlocks.MOD_PLANKS, PetrifiedWoodModTags.Items.MOD_LOGS, 4);
                createShaped(RecipeCategory.BUILDING_BLOCKS, PetrifiedWoodModBlocks.MOD_STAIRS, 4).pattern("#  ").pattern("## ").pattern("###").input('#', PetrifiedWoodModBlocks.MOD_PLANKS).group("wooden_stairs").criterion("has_planks", conditionsFromItem(PetrifiedWoodModBlocks.MOD_PLANKS)).offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, PetrifiedWoodModBlocks.MOD_SLAB, 6).pattern("###").input('#', PetrifiedWoodModBlocks.MOD_PLANKS).group("wooden_slab").criterion("has_planks", conditionsFromItem(PetrifiedWoodModBlocks.MOD_PLANKS)).offerTo(exporter);
                createShapeless(RecipeCategory.REDSTONE, PetrifiedWoodModBlocks.MOD_BUTTON, 1).input(PetrifiedWoodModBlocks.MOD_PLANKS).group("wooden_button").criterion("has_planks", conditionsFromItem(PetrifiedWoodModBlocks.MOD_PLANKS)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, PetrifiedWoodModBlocks.MOD_PRESSURE_PLATE, 1).pattern("##").input('#', PetrifiedWoodModBlocks.MOD_PLANKS).group("wooden_pressure_plate").criterion("has_planks", conditionsFromItem(PetrifiedWoodModBlocks.MOD_PLANKS)).offerTo(exporter);
                createShaped(RecipeCategory.DECORATIONS, PetrifiedWoodModBlocks.MOD_FENCE, 3).pattern("W#W").pattern("W#W").input('#', Items.STONE).input('W', PetrifiedWoodModBlocks.MOD_PLANKS).group("wooden_fence").criterion("has_planks", conditionsFromItem(PetrifiedWoodModBlocks.MOD_PLANKS)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, PetrifiedWoodModBlocks.MOD_DOOR, 3).pattern("##").pattern("##").pattern("##").input('#', PetrifiedWoodModBlocks.MOD_PLANKS).group("wooden_door").criterion("has_planks", conditionsFromItem(PetrifiedWoodModBlocks.MOD_PLANKS)).offerTo(exporter);
                createShaped(RecipeCategory.REDSTONE, PetrifiedWoodModBlocks.MOD_TRAPDOOR, 2).pattern("###").pattern("###").input('#', PetrifiedWoodModBlocks.MOD_PLANKS).group("wooden_trapdoor").criterion("has_planks", conditionsFromItem(PetrifiedWoodModBlocks.MOD_PLANKS)).offerTo(exporter);
            }

            @Override
            public void generate() {
                generateAzaleaRecipes();
                generateBaobabRecipes();
                generateChollaRecipes();
                generateCitrusRecipes();
                generateDogwoodRecipes();
                generateKapokRecipes();
                generateMapleRecipes();
                generatePetrifiedRecipes();
                generatePineRecipes();
                generateWillowRecipes();

                offerSmoothStoneRecipes(Blocks.DEEPSLATE, ModBuildingBlocks.SMOOTH_DEEPSLATE, ModBuildingBlocks.SMOOTH_DEEPSLATE_SLAB);

                offerChiseledBrickRecipes(ModBuildingBlocks.SNOW_BRICK_SLAB, ModBuildingBlocks.SNOW_BRICKS, ModBuildingBlocks.CHISELED_SNOW_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBuildingBlocks.CHISELED_SNOW_BRICKS, ModBuildingBlocks.PACKED_SNOW, 1);

                offerPolishedStoneWallBlockRecipes(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE, ModBuildingBlocks.POLISHED_ANDESITE_WALL);
                offerPolishedStoneWallBlockRecipes(Blocks.DIORITE, Blocks.POLISHED_DIORITE, ModBuildingBlocks.POLISHED_DIORITE_WALL);
                offerPolishedStoneWallBlockRecipes(Blocks.GRANITE, Blocks.POLISHED_GRANITE, ModBuildingBlocks.POLISHED_GRANITE_WALL);

                offerMossifyBlockRecipes(Blocks.BRICKS, ModBuildingBlocks.MOSSY_BRICKS);
                offerBrickBlockSetRecipes(ModBuildingBlocks.MOSSY_BRICKS, ModBuildingBlocks.MOSSY_BRICK_SLAB, ModBuildingBlocks.MOSSY_BRICK_STAIRS, ModBuildingBlocks.MOSSY_BRICK_WALL);
                offerMossifyBlockRecipes(Blocks.COBBLED_DEEPSLATE, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE);
                offerBrickBlockSetRecipes(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_WALL);
                offerMossifyBlockRecipes(Blocks.DEEPSLATE_BRICKS, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICKS);
                offerBrickBlockSetRecipes(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICKS, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_SLAB, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_WALL);
                offerMossifyBlockRecipes(Blocks.TUFF_BRICKS, ModBuildingBlocks.MOSSY_TUFF_BRICKS);
                offerBrickBlockSetRecipes(ModBuildingBlocks.MOSSY_TUFF_BRICKS, ModBuildingBlocks.MOSSY_TUFF_BRICK_SLAB, ModBuildingBlocks.MOSSY_TUFF_BRICK_STAIRS, ModBuildingBlocks.MOSSY_TUFF_BRICK_WALL);

                offerStandardRecipe(createCondense9X9BlockRecipe(Blocks.SNOW_BLOCK, ModBuildingBlocks.PACKED_SNOW), Blocks.SNOW_BLOCK);
                offerStandardRecipe(createShaped(RecipeCategory.BUILDING_BLOCKS, ModBuildingBlocks.SNOW_BRICKS, 4).input('#', ModBuildingBlocks.PACKED_SNOW).pattern("##").pattern("##"), ModBuildingBlocks.PACKED_SNOW);
                offerBrickBlockSetRecipes(ModBuildingBlocks.SNOW_BRICKS, ModBuildingBlocks.SNOW_BRICK_SLAB, ModBuildingBlocks.SNOW_BRICK_STAIRS, ModBuildingBlocks.SNOW_BRICK_WALL);
                offerTransitiveBrickBlockSetStonecuttingRecipes(ModBuildingBlocks.PACKED_SNOW, ModBuildingBlocks.SNOW_BRICKS, ModBuildingBlocks.SNOW_BRICK_SLAB, ModBuildingBlocks.SNOW_BRICK_STAIRS, ModBuildingBlocks.SNOW_BRICK_WALL);

                offerDyeFromPlantRecipes(Items.PURPLE_DYE, ModFloraBlocks.VIOLET);
                offerDyeFromPlantRecipes(Items.LIGHT_BLUE_DYE, ModFloraBlocks.FORGET_ME_NOT);
                offerDyeFromPlantRecipes(Items.GREEN_DYE, ModFloraBlocks.CLOVER);
                offerDyeFromPlantRecipes(Items.GREEN_DYE, ModFloraBlocks.MONSTERA);
                offerDyeFromPlantRecipes(Items.YELLOW_DYE, ModFloraBlocks.YELLOW_TULIP);
                offerDyeFromPlantRecipes(Items.PURPLE_DYE, ModFloraBlocks.PURPLE_TULIP);
                offerDyeFromPlantRecipes(Items.LIME_DYE, ModFloraBlocks.HELLEBORE);
                offerDyeFromPlantRecipes(Items.BROWN_DYE, ModFloraBlocks.GIANT_PADMA);

                offerDyeFromPlantRecipes(Items.WHITE_DYE, ModFloraBlocks.WHITE_WATER_LILY);
                offerDyeFromPlantRecipes(Items.BLUE_DYE, ModFloraBlocks.BLUE_WATER_LILY);
                offerDyeFromPlantRecipes(Items.PINK_DYE, ModFloraBlocks.PINK_WATER_LILY);
                offerDyeFromPlantRecipes(Items.PURPLE_DYE, ModFloraBlocks.PURPLE_WATER_LILY);
                offerDyeFromPlantRecipes(Items.ORANGE_DYE, ModItems.ORANGE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LOOSE_DIRT, 4)
                        .pattern("DL")
                        .pattern("LD")
                        .input('D', Blocks.DIRT)
                        .input('L', Blocks.LEAF_LITTER)
                        .criterion(hasItem(Blocks.LEAF_LITTER), conditionsFromItem(Blocks.LEAF_LITTER))
                        .offerTo(exporter);

                offerPumpkinRecipes(ModPumpkinBlocks.WHITE_PUMPKIN, ModPumpkinBlocks.CARVED_WHITE_PUMPKIN, ModPumpkinBlocks.WHITE_JACK_O_LANTERN, ModItems.WHITE_PUMPKIN_SEEDS);
                offerPumpkinRecipes(ModPumpkinBlocks.GREEN_PUMPKIN, ModPumpkinBlocks.CARVED_GREEN_PUMPKIN, ModPumpkinBlocks.GREEN_JACK_O_LANTERN, ModItems.GREEN_PUMPKIN_SEEDS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModPumpkinBlocks.SOUL_JACK_O_LANTERN, 1)
                        .pattern("A")
                        .pattern("B")
                        .input('A', ModPumpkinBlocks.CARVED_WHITE_PUMPKIN)
                        .input('B', Blocks.SOUL_TORCH)
                        .criterion(hasItem(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN), conditionsFromItem(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.ORANGE_JUICE, 1)
                        .input(ModItems.ORANGE)
                        .input(Items.SUGAR)
                        .input(Items.GLASS_BOTTLE)
                        .criterion(hasItem(ModItems.ORANGE), conditionsFromItem(ModItems.ORANGE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.FOOD, ModItems.CHOCOLATE_ORANGE, 1)
                        .pattern("CCC")
                        .pattern("COC")
                        .pattern("CCC")
                        .input('O', ModItems.ORANGE)
                        .input('C', Items.COCOA_BEANS)
                        .criterion(hasItem(ModItems.ORANGE), conditionsFromItem(ModItems.ORANGE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.CACTUS_PAD, 3)
                        .input(Items.CACTUS)
                        .criterion(hasItem(Items.CACTUS), conditionsFromItem(Items.CACTUS))
                        .offerTo(exporter);

                createSmelting(Ingredient.ofItem(ModItems.CACTUS_PAD), RecipeCategory.FOOD, ModItems.COOKED_CACTUS_PAD, 0.35F, 200)
                        .criterion(hasItem(ModItems.CACTUS_PAD), conditionsFromItem(ModItems.CACTUS_PAD))
                        .offerTo(exporter);
                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new, 100, ModItems.CACTUS_PAD, ModItems.COOKED_CACTUS_PAD, 0.35F);
                offerFoodCookingRecipe("campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600, ModItems.CACTUS_PAD, ModItems.COOKED_CACTUS_PAD, 0.35F);

                createShapeless(RecipeCategory.FOOD, ModItems.CACTUS_SALAD, 1)
                        .input(ModItems.COOKED_CACTUS_PAD)
                        .input(Items.BEETROOT)
                        .input(Items.BROWN_MUSHROOM)
                        .input(Items.BOWL)
                        .criterion(hasItem(ModItems.COOKED_CACTUS_PAD), conditionsFromItem(ModItems.COOKED_CACTUS_PAD))
                        .offerTo(exporter, "cactus_salad_from_brown_mushroom");

                createShapeless(RecipeCategory.FOOD, ModItems.CACTUS_SALAD, 1)
                        .input(ModItems.COOKED_CACTUS_PAD)
                        .input(Items.BEETROOT)
                        .input(Items.RED_MUSHROOM)
                        .input(Items.BOWL)
                        .criterion(hasItem(ModItems.COOKED_CACTUS_PAD), conditionsFromItem(ModItems.COOKED_CACTUS_PAD))
                        .offerTo(exporter, "cactus_salad_from_red_mushroom");

                offerDyeFromPlantRecipes(Items.GREEN_DYE, ModItems.COOKED_CACTUS_PAD);

                offerSnowyBlockRecipes(Blocks.SHORT_GRASS, ModFloraBlocks.SNOWY_SHORT_GRASS);
                offerSnowyBlockRecipes(Blocks.FERN, ModFloraBlocks.SNOWY_FERN);
                offerSnowyBlockRecipes(Blocks.BUSH, ModFloraBlocks.SNOWY_BUSH);

            }
        };
    }

    @Override
    public String getName() {
        return CombinedWorldgen.MOD_ID + " recipes";
    }
}
