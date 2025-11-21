package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.block.building.ModBuildingBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.item.ModItems;
import bluesteel42.combinedworldgen.wood.azalea.block.AzaleaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.azalea.entity.AzaleaWoodModRafts;
import bluesteel42.combinedworldgen.wood.baobab.BaobabWoodInitializer;
import bluesteel42.combinedworldgen.wood.baobab.block.BaobabWoodModBlocks;
import bluesteel42.combinedworldgen.wood.baobab.entity.BaobabWoodModBoats;
import bluesteel42.combinedworldgen.wood.cholla.block.ChollaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.cholla.entity.ChollaWoodModRafts;
import bluesteel42.combinedworldgen.wood.citrus.CitrusWoodInitializer;
import bluesteel42.combinedworldgen.wood.citrus.block.CitrusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.citrus.entity.CitrusWoodModBoats;
import bluesteel42.combinedworldgen.wood.dogwood.DogwoodWoodInitializer;
import bluesteel42.combinedworldgen.wood.dogwood.block.DogwoodWoodModBlocks;
import bluesteel42.combinedworldgen.wood.dogwood.entity.DogwoodWoodModBoats;
import bluesteel42.combinedworldgen.wood.kapok.KapokWoodInitializer;
import bluesteel42.combinedworldgen.wood.kapok.block.KapokWoodModBlocks;
import bluesteel42.combinedworldgen.wood.kapok.entity.KapokWoodModBoats;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
import bluesteel42.combinedworldgen.wood.maple.entity.MapleWoodModBoats;
import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import bluesteel42.combinedworldgen.wood.pine.PineWoodInitializer;
import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import bluesteel42.combinedworldgen.wood.pine.entity.PineWoodModBoats;
import bluesteel42.combinedworldgen.wood.willow.WillowWoodInitializer;
import bluesteel42.combinedworldgen.wood.willow.block.WillowWoodModBlocks;
import bluesteel42.combinedworldgen.wood.willow.entity.WillowWoodModBoats;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.FoliageColors;

import java.util.Map;

import static net.minecraft.client.data.BlockStateModelGenerator.createWallBlockState;
import static net.minecraft.client.data.BlockStateModelGenerator.createWeightedVariant;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void generateNaturalWoodBlockModels(BlockStateModelGenerator blockStateModelGenerator,
            BlockFamily blockFamily,
            Block log,
            Block wood,
            Block strippedLog,
            Block strippedWood,
            Block hangingSign,
            Block wallHangingSign,
            Item boat,
            Item chestBoat,
            Block leaves,
            boolean tintedLeaves,
            int leavesTintColor,
            Block sapling,
            Block pottedSapling,
            Block shelf
    ) {
        blockStateModelGenerator.createLogTexturePool(log).log(log).wood(wood);
        blockStateModelGenerator.createLogTexturePool(strippedLog).log(strippedLog).wood(strippedWood);
        blockStateModelGenerator.registerCubeAllModelTexturePool(blockFamily.getBaseBlock()).family(blockFamily);
        blockStateModelGenerator.registerHangingSign(strippedLog, hangingSign, wallHangingSign);
        blockStateModelGenerator.registerItemModel(boat);
        blockStateModelGenerator.registerItemModel(chestBoat);
        blockStateModelGenerator.registerShelf(shelf, strippedLog);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(sapling, pottedSapling, BlockStateModelGenerator.CrossType.NOT_TINTED);
        if (tintedLeaves) {
            blockStateModelGenerator.registerTintedBlockAndItem(leaves, TexturedModel.LEAVES, leavesTintColor);
        } else {
            blockStateModelGenerator.registerSingleton(leaves, TexturedModel.LEAVES);
        }
    }
    public void generateCombinedWoodBlockModels(BlockStateModelGenerator blockStateModelGenerator,
            BlockFamily blockFamily,
            Block block,
            Block strippedBlock,
            Block mosaic,
            Block mosaicStairs,
            Block mosaicSlab,
            Block hangingSign,
            Block wallHangingSign,
            Item raft,
            Item chestRaft,
            Block shelf
    ) {
        blockStateModelGenerator.createLogTexturePool(block).uvLockedLog(block);
        blockStateModelGenerator.createLogTexturePool(strippedBlock).uvLockedLog(strippedBlock);
        blockStateModelGenerator.registerCubeAllModelTexturePool(blockFamily.getBaseBlock()).family(blockFamily);
        blockStateModelGenerator.registerHangingSign(strippedBlock, hangingSign, wallHangingSign);
        BlockStateModelGenerator.BlockTexturePool mosaicPool = blockStateModelGenerator.registerCubeAllModelTexturePool(mosaic);
        mosaicPool.stairs(mosaicStairs);
        mosaicPool.slab(mosaicSlab);
        blockStateModelGenerator.registerItemModel(raft);
        blockStateModelGenerator.registerItemModel(chestRaft);
        blockStateModelGenerator.registerShelf(shelf, strippedBlock);
    }

    private void generateAzaleaBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateCombinedWoodBlockModels(blockStateModelGenerator,
                AzaleaWoodModBlocks.MOD_BLOCK_FAMILY,
                AzaleaWoodModBlocks.MOD_BLOCK,
                AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK,
                AzaleaWoodModBlocks.MOD_MOSAIC,
                AzaleaWoodModBlocks.MOD_MOSAIC_STAIRS,
                AzaleaWoodModBlocks.MOD_MOSAIC_SLAB,
                AzaleaWoodModBlocks.MOD_HANGING_SIGN,
                AzaleaWoodModBlocks.MOD_WALL_HANGING_SIGN,
                AzaleaWoodModRafts.MOD_RAFT,
                AzaleaWoodModRafts.MOD_CHEST_RAFT,
                AzaleaWoodModBlocks.MOD_SHELF
        );
    }
    private void generateBaobabBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateNaturalWoodBlockModels(blockStateModelGenerator,
                BaobabWoodModBlocks.MOD_BLOCK_FAMILY,
                BaobabWoodModBlocks.MOD_LOG,
                BaobabWoodModBlocks.MOD_WOOD,
                BaobabWoodModBlocks.STRIPPED_MOD_LOG,
                BaobabWoodModBlocks.STRIPPED_MOD_WOOD,
                BaobabWoodModBlocks.MOD_HANGING_SIGN,
                BaobabWoodModBlocks.MOD_WALL_HANGING_SIGN,
                BaobabWoodModBoats.MOD_BOAT,
                BaobabWoodModBoats.MOD_CHEST_BOAT,
                BaobabWoodModBlocks.MOD_LEAVES,
                BaobabWoodInitializer.TINTED_LEAVES,
                BaobabWoodInitializer.MOD_LEAF_TINT_COLOR,
                BaobabWoodModBlocks.MOD_SAPLING,
                BaobabWoodModBlocks.POTTED_MOD_SAPLING,
                BaobabWoodModBlocks.MOD_SHELF
        );
    }
    private void generateChollaBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateCombinedWoodBlockModels(blockStateModelGenerator,
                ChollaWoodModBlocks.MOD_BLOCK_FAMILY,
                ChollaWoodModBlocks.MOD_BLOCK,
                ChollaWoodModBlocks.STRIPPED_MOD_BLOCK,
                ChollaWoodModBlocks.MOD_MOSAIC,
                ChollaWoodModBlocks.MOD_MOSAIC_STAIRS,
                ChollaWoodModBlocks.MOD_MOSAIC_SLAB,
                ChollaWoodModBlocks.MOD_HANGING_SIGN,
                ChollaWoodModBlocks.MOD_WALL_HANGING_SIGN,
                ChollaWoodModRafts.MOD_RAFT,
                ChollaWoodModRafts.MOD_CHEST_RAFT,
                ChollaWoodModBlocks.MOD_SHELF
        );
    }
    private void generateCitrusBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateNaturalWoodBlockModels(blockStateModelGenerator,
                CitrusWoodModBlocks.MOD_BLOCK_FAMILY,
                CitrusWoodModBlocks.MOD_LOG,
                CitrusWoodModBlocks.MOD_WOOD,
                CitrusWoodModBlocks.STRIPPED_MOD_LOG,
                CitrusWoodModBlocks.STRIPPED_MOD_WOOD,
                CitrusWoodModBlocks.MOD_HANGING_SIGN,
                CitrusWoodModBlocks.MOD_WALL_HANGING_SIGN,
                CitrusWoodModBoats.MOD_BOAT,
                CitrusWoodModBoats.MOD_CHEST_BOAT,
                CitrusWoodModBlocks.MOD_LEAVES,
                CitrusWoodInitializer.TINTED_LEAVES,
                CitrusWoodInitializer.MOD_LEAF_TINT_COLOR,
                CitrusWoodModBlocks.MOD_SAPLING,
                CitrusWoodModBlocks.POTTED_MOD_SAPLING,
                CitrusWoodModBlocks.MOD_SHELF
        );
    }
    private void generateDogwoodBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateNaturalWoodBlockModels(blockStateModelGenerator,
                DogwoodWoodModBlocks.MOD_BLOCK_FAMILY,
                DogwoodWoodModBlocks.MOD_LOG,
                DogwoodWoodModBlocks.MOD_WOOD,
                DogwoodWoodModBlocks.STRIPPED_MOD_LOG,
                DogwoodWoodModBlocks.STRIPPED_MOD_WOOD,
                DogwoodWoodModBlocks.MOD_HANGING_SIGN,
                DogwoodWoodModBlocks.MOD_WALL_HANGING_SIGN,
                DogwoodWoodModBoats.MOD_BOAT,
                DogwoodWoodModBoats.MOD_CHEST_BOAT,
                DogwoodWoodModBlocks.MOD_LEAVES,
                DogwoodWoodInitializer.TINTED_LEAVES,
                DogwoodWoodInitializer.MOD_LEAF_TINT_COLOR,
                DogwoodWoodModBlocks.MOD_SAPLING,
                DogwoodWoodModBlocks.POTTED_MOD_SAPLING,
                DogwoodWoodModBlocks.MOD_SHELF
        );
    }
    private void generateKapokBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateNaturalWoodBlockModels(blockStateModelGenerator,
                KapokWoodModBlocks.MOD_BLOCK_FAMILY,
                KapokWoodModBlocks.MOD_LOG,
                KapokWoodModBlocks.MOD_WOOD,
                KapokWoodModBlocks.STRIPPED_MOD_LOG,
                KapokWoodModBlocks.STRIPPED_MOD_WOOD,
                KapokWoodModBlocks.MOD_HANGING_SIGN,
                KapokWoodModBlocks.MOD_WALL_HANGING_SIGN,
                KapokWoodModBoats.MOD_BOAT,
                KapokWoodModBoats.MOD_CHEST_BOAT,
                KapokWoodModBlocks.MOD_LEAVES,
                KapokWoodInitializer.TINTED_LEAVES,
                KapokWoodInitializer.MOD_LEAF_TINT_COLOR,
                KapokWoodModBlocks.CACAO_SAPLING,
                KapokWoodModBlocks.POTTED_CACAO_SAPLING,
                KapokWoodModBlocks.MOD_SHELF
        );
        blockStateModelGenerator.registerTintedBlockAndItem(KapokWoodModBlocks.CACAO_LEAVES, TexturedModel.LEAVES, KapokWoodInitializer.MOD_LEAF_TINT_COLOR);
    }
    private void generateMapleBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateNaturalWoodBlockModels(blockStateModelGenerator,
                MapleWoodModBlocks.MOD_BLOCK_FAMILY,
                MapleWoodModBlocks.MOD_LOG,
                MapleWoodModBlocks.MOD_WOOD,
                MapleWoodModBlocks.STRIPPED_MOD_LOG,
                MapleWoodModBlocks.STRIPPED_MOD_WOOD,
                MapleWoodModBlocks.MOD_HANGING_SIGN,
                MapleWoodModBlocks.MOD_WALL_HANGING_SIGN,
                MapleWoodModBoats.MOD_BOAT,
                MapleWoodModBoats.MOD_CHEST_BOAT,
                MapleWoodModBlocks.MOD_LEAVES,
                MapleWoodInitializer.TINTED_LEAVES,
                MapleWoodInitializer.MOD_LEAF_TINT_COLOR,
                MapleWoodModBlocks.MOD_SAPLING,
                MapleWoodModBlocks.POTTED_MOD_SAPLING,
                MapleWoodModBlocks.MOD_SHELF
        );
        /* ADDITIONAL BLOCKS*/
        blockStateModelGenerator.registerSimpleCubeAll(MapleWoodModBlocks.RED_MAPLE_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES);
    }
    private void generatePineBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateNaturalWoodBlockModels(blockStateModelGenerator,
                PineWoodModBlocks.MOD_BLOCK_FAMILY,
                PineWoodModBlocks.MOD_LOG,
                PineWoodModBlocks.MOD_WOOD,
                PineWoodModBlocks.STRIPPED_MOD_LOG,
                PineWoodModBlocks.STRIPPED_MOD_WOOD,
                PineWoodModBlocks.MOD_HANGING_SIGN,
                PineWoodModBlocks.MOD_WALL_HANGING_SIGN,
                PineWoodModBoats.MOD_BOAT,
                PineWoodModBoats.MOD_CHEST_BOAT,
                PineWoodModBlocks.MOD_LEAVES,
                PineWoodInitializer.TINTED_LEAVES,
                PineWoodInitializer.MOD_LEAF_TINT_COLOR,
                PineWoodModBlocks.MOD_SAPLING,
                PineWoodModBlocks.POTTED_MOD_SAPLING,
                PineWoodModBlocks.MOD_SHELF
        );
        /* ADDITIONAL BLOCKS*/
        blockStateModelGenerator.registerTintedBlockAndItem(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, TexturedModel.LEAVES, FoliageColors.SPRUCE);
        blockStateModelGenerator.registerSimpleCubeAll(PineWoodModBlocks.SNOWY_PINE_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(PineWoodModBlocks.SNOWY_SPRUCE_LEAVES);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(PineWoodModBlocks.SNOWY_PINE_SAPLING, PineWoodModBlocks.POTTED_SNOWY_PINE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(PineWoodModBlocks.SNOWY_SPRUCE_SAPLING, PineWoodModBlocks.POTTED_SNOWY_SPRUCE_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
    }
    private void generateWillowBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateNaturalWoodBlockModels(blockStateModelGenerator,
                WillowWoodModBlocks.MOD_BLOCK_FAMILY,
                WillowWoodModBlocks.MOD_LOG,
                WillowWoodModBlocks.MOD_WOOD,
                WillowWoodModBlocks.STRIPPED_MOD_LOG,
                WillowWoodModBlocks.STRIPPED_MOD_WOOD,
                WillowWoodModBlocks.MOD_HANGING_SIGN,
                WillowWoodModBlocks.MOD_WALL_HANGING_SIGN,
                WillowWoodModBoats.MOD_BOAT,
                WillowWoodModBoats.MOD_CHEST_BOAT,
                WillowWoodModBlocks.MOD_LEAVES,
                WillowWoodInitializer.TINTED_LEAVES,
                WillowWoodInitializer.MOD_LEAF_TINT_COLOR,
                WillowWoodModBlocks.MOD_SAPLING,
                WillowWoodModBlocks.POTTED_MOD_SAPLING,
                WillowWoodModBlocks.MOD_SHELF
        );
    }

    private void generatePetrifiedBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.createLogTexturePool(PetrifiedWoodModBlocks.MOD_LOG).log(PetrifiedWoodModBlocks.MOD_LOG).wood(PetrifiedWoodModBlocks.MOD_WOOD);
        BlockStateModelGenerator.BlockTexturePool plankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(PetrifiedWoodModBlocks.MOD_PLANKS);
        plankPool.stairs(PetrifiedWoodModBlocks.MOD_STAIRS);
        plankPool.slab(PetrifiedWoodModBlocks.MOD_SLAB);
        plankPool.button(PetrifiedWoodModBlocks.MOD_BUTTON);
        plankPool.fence(PetrifiedWoodModBlocks.MOD_FENCE);
        plankPool.pressurePlate(PetrifiedWoodModBlocks.MOD_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(PetrifiedWoodModBlocks.MOD_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(PetrifiedWoodModBlocks.MOD_TRAPDOOR);
    }

    private void generateWaterLilyModels(BlockStateModelGenerator blockStateModelGenerator, Block lily) {
        blockStateModelGenerator.registerItemModel(lily.asItem());
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(lily, BlockStateModelGenerator.modelWithYRotation(BlockStateModelGenerator.createModelVariant(ModelIds.getBlockModelId(lily)))));
    }
    private void registerPumpkinModels(BlockStateModelGenerator blockStateModelGenerator, Block pumpkin, Block carvedPumpkin, Block jackOLantern, Block pumpkinStem, Block attachedPumpkinStem) {
        blockStateModelGenerator.registerGourd(pumpkinStem, attachedPumpkinStem);
        TextureMap textureMap = TextureMap.sideEnd(pumpkin);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(pumpkin, createWeightedVariant(ModelIds.getBlockModelId(pumpkin))));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(carvedPumpkin, textureMap);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(jackOLantern, textureMap);

        // Build the model ID (e.g. yourmod:block/white_pumpkin)
        Identifier modelId = ModelIds.getBlockModelId(pumpkin);

        // Create model JSON manually
        JsonObject modelJson = new JsonObject();
        modelJson.addProperty("parent", "minecraft:block/cube_column");

        JsonObject textures = new JsonObject();
        textures.addProperty("end", CombinedWorldgen.MOD_ID + ":" + ModelIds.getBlockSubModelId(pumpkin, "_top").getPath());
        textures.addProperty("side", CombinedWorldgen.MOD_ID + ":" + ModelIds.getBlockSubModelId(pumpkin, "_side").getPath());
        modelJson.add("textures", textures);

        // Add "display" section
        JsonObject display = new JsonObject();
        JsonObject firstPerson = new JsonObject();
        firstPerson.add("rotation", createJsonArray(0f, 135f, 0f));
        firstPerson.add("translation", createJsonArray(0f, 0f, 0f));
        firstPerson.add("scale", createJsonArray(0.4f, 0.4f, 0.4f));
        display.add("firstperson_righthand", firstPerson);
        modelJson.add("display", display);

        // Register the model manually
        blockStateModelGenerator.modelCollector.accept(modelId, () -> modelJson);
    }

    private JsonArray createJsonArray(float x, float y, float z) {
        JsonArray array = new JsonArray();
        array.add(x);
        array.add(y);
        array.add(z);
        return array;
    }

    private void generateStoneBlockModels(BlockStateModelGenerator blockStateModelGenerator, Block block, Block stairs, Block slab, Block wall) {
        BlockStateModelGenerator.BlockTexturePool plankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        plankPool.stairs(stairs);
        plankPool.slab(slab);
        plankPool.wall(wall);
    }

    private void generateBlockAndSlabModels(BlockStateModelGenerator blockStateModelGenerator, Block block, Block slab) {
        BlockStateModelGenerator.BlockTexturePool plankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(block);
        plankPool.slab(slab);
    }

    private static void generateWallFromVanillaBlock(BlockStateModelGenerator blockStateModelGenerator, Block block, Block wall) {
        TextureMap textureMap = TextureMap.all(block);

        WeightedVariant postModel = createWeightedVariant(
                Models.TEMPLATE_WALL_POST.upload(wall, textureMap, blockStateModelGenerator.modelCollector)
        );
        WeightedVariant lowSideModel = createWeightedVariant(
                Models.TEMPLATE_WALL_SIDE.upload(wall, textureMap, blockStateModelGenerator.modelCollector)
        );
        WeightedVariant tallSideModel = createWeightedVariant(
                Models.TEMPLATE_WALL_SIDE_TALL.upload(wall, textureMap, blockStateModelGenerator.modelCollector)
        );

        blockStateModelGenerator.blockStateCollector.accept(
                createWallBlockState(wall, postModel, lowSideModel, tallSideModel)
        );

        Identifier inventoryModel = Models.WALL_INVENTORY.upload(
                wall, textureMap, blockStateModelGenerator.modelCollector
        );
        blockStateModelGenerator.registerParentedItemModel(wall, inventoryModel);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateAzaleaBlockModels(blockStateModelGenerator);
        generateBaobabBlockModels(blockStateModelGenerator);
        generateChollaBlockModels(blockStateModelGenerator);
        generateCitrusBlockModels(blockStateModelGenerator);
        generateDogwoodBlockModels(blockStateModelGenerator);
        generateKapokBlockModels(blockStateModelGenerator);
        generateMapleBlockModels(blockStateModelGenerator);
        generatePetrifiedBlockModels(blockStateModelGenerator);
        generatePineBlockModels(blockStateModelGenerator);
        generateWillowBlockModels(blockStateModelGenerator);

//        blockStateModelGenerator.registerFlowerPotPlant(Blocks.CACTUS_FLOWER, ModFloraBlocks.POTTED_CACTUS_FLOWER, BlockStateModelGenerator.CrossType.NOT_TINTED);
//        blockStateModelGenerator.registerFlowerPotPlant(Blocks.SUGAR_CANE, ModFloraBlocks.POTTED_SUGAR_CANE, BlockStateModelGenerator.CrossType.NOT_TINTED);
//        blockStateModelGenerator.registerFlowerPotPlant(Blocks.ROSE_BUSH, ModFloraBlocks.POTTED_ROSE, BlockStateModelGenerator.CrossType.NOT_TINTED);
//        blockStateModelGenerator.registerFlowerPotPlant(Blocks.PEONY, ModFloraBlocks.POTTED_PEONY, BlockStateModelGenerator.CrossType.NOT_TINTED);
//        blockStateModelGenerator.registerFlowerPotPlant(Blocks.LILAC, ModFloraBlocks.POTTED_LILAC, BlockStateModelGenerator.CrossType.NOT_TINTED);
//        blockStateModelGenerator.registerFlowerPotPlant(Blocks.SUNFLOWER, ModFloraBlocks.POTTED_SUNFLOWER, BlockStateModelGenerator.CrossType.NOT_TINTED);
//        blockStateModelGenerator.registerFlowerPotPlant(ModFloraBlocks.MONSTERA, ModFloraBlocks.POTTED_MONSTERA, BlockStateModelGenerator.CrossType.NOT_TINTED);

        generateBlockAndSlabModels(blockStateModelGenerator, ModBuildingBlocks.SMOOTH_DEEPSLATE, ModBuildingBlocks.SMOOTH_DEEPSLATE_SLAB);

        generateStoneBlockModels(blockStateModelGenerator, ModBuildingBlocks.MOSSY_BRICKS, ModBuildingBlocks.MOSSY_BRICK_STAIRS, ModBuildingBlocks.MOSSY_BRICK_SLAB, ModBuildingBlocks.MOSSY_BRICK_WALL);
        generateStoneBlockModels(blockStateModelGenerator, ModBuildingBlocks.MOSSY_TUFF_BRICKS, ModBuildingBlocks.MOSSY_TUFF_BRICK_STAIRS, ModBuildingBlocks.MOSSY_TUFF_BRICK_SLAB, ModBuildingBlocks.MOSSY_TUFF_BRICK_WALL);
        generateStoneBlockModels(blockStateModelGenerator, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICKS, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_SLAB, ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_WALL);
        generateStoneBlockModels(blockStateModelGenerator, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB, ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_WALL);
        generateStoneBlockModels(blockStateModelGenerator, ModBuildingBlocks.SNOW_BRICKS, ModBuildingBlocks.SNOW_BRICK_STAIRS, ModBuildingBlocks.SNOW_BRICK_SLAB, ModBuildingBlocks.SNOW_BRICK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBuildingBlocks.PACKED_SNOW);
        blockStateModelGenerator.registerSimpleCubeAll(ModBuildingBlocks.CHISELED_SNOW_BRICKS);

        generateWallFromVanillaBlock(blockStateModelGenerator, Blocks.POLISHED_ANDESITE, ModBuildingBlocks.POLISHED_ANDESITE_WALL);
        generateWallFromVanillaBlock(blockStateModelGenerator, Blocks.POLISHED_ANDESITE, ModBuildingBlocks.POLISHED_DIORITE_WALL);
        generateWallFromVanillaBlock(blockStateModelGenerator, Blocks.POLISHED_ANDESITE, ModBuildingBlocks.POLISHED_GRANITE_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LOOSE_DIRT);

        generateWaterLilyModels(blockStateModelGenerator, ModFloraBlocks.WHITE_WATER_LILY);
        generateWaterLilyModels(blockStateModelGenerator, ModFloraBlocks.BLUE_WATER_LILY);
        generateWaterLilyModels(blockStateModelGenerator, ModFloraBlocks.PINK_WATER_LILY);
        generateWaterLilyModels(blockStateModelGenerator, ModFloraBlocks.PURPLE_WATER_LILY);

        registerPumpkinModels(blockStateModelGenerator, ModPumpkinBlocks.WHITE_PUMPKIN, ModPumpkinBlocks.CARVED_WHITE_PUMPKIN, ModPumpkinBlocks.WHITE_JACK_O_LANTERN, ModPumpkinBlocks.WHITE_PUMPKIN_STEM, ModPumpkinBlocks.ATTACHED_WHITE_PUMPKIN_STEM);
        registerPumpkinModels(blockStateModelGenerator, ModPumpkinBlocks.GREEN_PUMPKIN, ModPumpkinBlocks.CARVED_GREEN_PUMPKIN, ModPumpkinBlocks.GREEN_JACK_O_LANTERN, ModPumpkinBlocks.GREEN_PUMPKIN_STEM, ModPumpkinBlocks.ATTACHED_GREEN_PUMPKIN_STEM);

        TextureMap textureMap = TextureMap.sideEnd(ModPumpkinBlocks.WHITE_PUMPKIN);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(ModPumpkinBlocks.SOUL_JACK_O_LANTERN, textureMap);

        blockStateModelGenerator.registerItemModel(ModItems.GREEN_PUMPKIN_SNOW_GOLEM_SPAWN_EGG);
        blockStateModelGenerator.registerItemModel(ModItems.WHITE_PUMPKIN_SNOW_GOLEM_SPAWN_EGG);

        blockStateModelGenerator.registerTintableCross(ModFloraBlocks.SNOWY_SHORT_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModFloraBlocks.SNOWY_FERN, ModFloraBlocks.POTTED_SNOWY_FERN, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModFloraBlocks.SNOWY_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerItemModel(ModItems.ORANGE);
        blockStateModelGenerator.registerItemModel(ModItems.CHOCOLATE_ORANGE);
        blockStateModelGenerator.registerItemModel(ModItems.ORANGE_JUICE);

        blockStateModelGenerator.registerItemModel(ModItems.CACTUS_PAD);
        blockStateModelGenerator.registerItemModel(ModItems.COOKED_CACTUS_PAD);
        blockStateModelGenerator.registerItemModel(ModItems.CACTUS_SALAD);

        blockStateModelGenerator.registerItemModel(ModItems.MOOBLOOM_SPAWN_EGG);
        blockStateModelGenerator.registerTintableCross(ModFloraBlocks.SMALL_ROSE, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModFloraBlocks.SMALL_LILAC, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModFloraBlocks.SMALL_PEONY, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModFloraBlocks.SMALL_SUNFLOWER, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModFloraBlocks.SMALL_PITCHER_PLANT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModFloraBlocks.SMALL_MONSTERA, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerDoubleBlockAndItem(ModFloraBlocks.MONSTERA, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerbed(ModFloraBlocks.VIOLET);
        blockStateModelGenerator.registerFlowerbed(ModFloraBlocks.FORGET_ME_NOT);
        blockStateModelGenerator.registerFlowerbed(ModFloraBlocks.CLOVER);

        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModFloraBlocks.YELLOW_TULIP, ModFloraBlocks.POTTED_YELLOW_TULIP, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModFloraBlocks.PURPLE_TULIP, ModFloraBlocks.POTTED_PURPLE_TULIP, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModFloraBlocks.HELLEBORE, ModFloraBlocks.POTTED_HELLEBORE, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerItemModel(ModItems.CLUCKSHROOM_SPAWN_EGG);
        blockStateModelGenerator.registerItemModel(ModItems.CLUCKSHROOM_EGG);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {}
}
