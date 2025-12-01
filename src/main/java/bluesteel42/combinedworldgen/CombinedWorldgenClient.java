package bluesteel42.combinedworldgen;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.entity.ModEntities;
import bluesteel42.combinedworldgen.entity.cluckshroom.CluckshroomEntityModel;
import bluesteel42.combinedworldgen.entity.cluckshroom.CluckshroomEntityRenderer;
import bluesteel42.combinedworldgen.entity.moobloom.MoobloomEntityModel;
import bluesteel42.combinedworldgen.entity.moobloom.MoobloomEntityRenderer;
import bluesteel42.combinedworldgen.entity.snow_golem.GreenPumpkinSnowGolemEntityModel;
import bluesteel42.combinedworldgen.entity.snow_golem.GreenPumpkinSnowGolemEntityRenderer;
import bluesteel42.combinedworldgen.entity.snow_golem.WhitePumpkinSnowGolemEntityModel;
import bluesteel42.combinedworldgen.entity.snow_golem.WhitePumpkinSnowGolemEntityRenderer;
import bluesteel42.combinedworldgen.wood.AllWoodInitializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.StemBlock;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.EntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.biome.GrassColors;

import static bluesteel42.combinedworldgen.entity.ModEntityModelLayers.*;
import static bluesteel42.combinedworldgen.entity.ModEntityModelLayers.CLUCKSHROOM_BABY_MAIN_MODEL_LAYER;

public class CombinedWorldgenClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AllWoodInitializer.initializeWoodTypesClient();
        // Color Grass
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getDefaultColor(), ModBlocks.QUEEN_ANNES_LACE, ModBlocks.SEA_BEET);

        // Color Flowerbed Stems
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getDefaultColor();
            } else {
                return -1;
            }
        }, ModFloraBlocks.VIOLET, ModFloraBlocks.CLOVER, ModFloraBlocks.FORGET_ME_NOT);

        // Color Water Lilies
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BlockColors.PLACED_LILY_PAD, ModFloraBlocks.WHITE_WATER_LILY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BlockColors.PLACED_LILY_PAD, ModFloraBlocks.BLUE_WATER_LILY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BlockColors.PLACED_LILY_PAD, ModFloraBlocks.PINK_WATER_LILY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BlockColors.PLACED_LILY_PAD, ModFloraBlocks.PURPLE_WATER_LILY);

        // Color Pumpkin Stems
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            int i = (Integer)state.get(StemBlock.AGE);
            return ColorHelper.getArgb(i * 32, 255 - i * 8, i * 4);
        }, ModPumpkinBlocks.GREEN_PUMPKIN_STEM);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> -2046180, ModPumpkinBlocks.ATTACHED_GREEN_PUMPKIN_STEM);

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            int i = (Integer)state.get(StemBlock.AGE);
            return ColorHelper.getArgb(120 + (i * 65) / 7, 141 + (i * 44) / 7,  59  + (i * 126) / 7);
        }, ModPumpkinBlocks.WHITE_PUMPKIN_STEM);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> ColorHelper.getArgb(185, 185, 185), ModPumpkinBlocks.ATTACHED_WHITE_PUMPKIN_STEM);

        // Register Mobs
        EntityRendererFactories.register(ModEntities.WHITE_PUMPKIN_SNOW_GOLEM, WhitePumpkinSnowGolemEntityRenderer::new);
        EntityRendererFactories.register(ModEntities.GREEN_PUMPKIN_SNOW_GOLEM, GreenPumpkinSnowGolemEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(WHITE_MAIN_MODEL_LAYER, WhitePumpkinSnowGolemEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(GREEN_MAIN_MODEL_LAYER, GreenPumpkinSnowGolemEntityModel::getTexturedModelData);

        EntityRendererFactories.register(ModEntities.MOOBLOOM, MoobloomEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MOOBLOOM_MAIN_MODEL_LAYER, MoobloomEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(MOOBLOOM_BABY_MAIN_MODEL_LAYER,
                () -> TexturedModelData.of(MoobloomEntityModel.BABY_TRANSFORMER.apply(MoobloomEntityModel.getModelData()),64, 64)
        );
        EntityRendererFactories.register(ModEntities.CLUCKSHROOM, CluckshroomEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CLUCKSHROOM_MAIN_MODEL_LAYER, CluckshroomEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(CLUCKSHROOM_BABY_MAIN_MODEL_LAYER,
                () -> TexturedModelData.of(CluckshroomEntityModel.BABY_TRANSFORMER.apply(CluckshroomEntityModel.getModelData()),64, 32)
        );
        EntityRendererFactories.register(ModEntities.CLUCKSHROOM_EGG, FlyingItemEntityRenderer::new);

    }
}
