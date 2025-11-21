package bluesteel42.combinedworldgen.entity.cluckshroom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.random.Random;

@Environment(EnvType.CLIENT)
public class CluckshroomMushroomFeatureRenderer extends FeatureRenderer<CluckshroomEntityRenderState, CluckshroomEntityModel> {
    private final BlockRenderManager blockRenderManager;

    public CluckshroomMushroomFeatureRenderer(FeatureRendererContext<CluckshroomEntityRenderState, CluckshroomEntityModel> context, BlockRenderManager blockRenderManager) {
        super(context);
        this.blockRenderManager = blockRenderManager;
    }

    public void render(
            MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, CluckshroomEntityRenderState cluckshroomEntityRenderState, float f, float g
    ) {
        if (!cluckshroomEntityRenderState.baby) {
            boolean bl = cluckshroomEntityRenderState.hasOutline() && cluckshroomEntityRenderState.invisible;
            if (!cluckshroomEntityRenderState.invisible || bl) {
                int j = LivingEntityRenderer.getOverlay(cluckshroomEntityRenderState, 0.0F);
                BlockState backBlockState = cluckshroomEntityRenderState.backMushroom;
                BlockStateModel backBlockStateModel = this.blockRenderManager.getModel(backBlockState);
                matrixStack.push();
                matrixStack.scale(-0.525F, -0.525F, 0.525F);
                matrixStack.translate(-0.625F, -1.55F, -0.35F);
                this.renderMushroom(matrixStack, orderedRenderCommandQueue, i, bl, cluckshroomEntityRenderState.outlineColor, backBlockState, j, backBlockStateModel);
                matrixStack.pop();
                matrixStack.push();
                BlockState headBlockState = cluckshroomEntityRenderState.headMushroom;
                BlockStateModel headBlockStateModel = this.blockRenderManager.getModel(headBlockState);
                this.getContextModel().getHead().applyTransform(matrixStack);
                matrixStack.scale(-0.525F, -0.525F, 0.525F);
                matrixStack.translate(-0.4F, 0.65F, -0.5F);
                this.renderMushroom(matrixStack, orderedRenderCommandQueue, i, bl, cluckshroomEntityRenderState.outlineColor, headBlockState, j, headBlockStateModel);
                matrixStack.pop();
            }
        }
    }

    private void renderMushroom(
            MatrixStack matrices,
            OrderedRenderCommandQueue orderedRenderCommandQueue,
            int light,
            boolean renderAsModel,
            int i,
            BlockState blockState,
            int j,
            BlockStateModel blockStateModel
    ) {
        if (renderAsModel) {
            orderedRenderCommandQueue.submitBlockStateModel(
                    matrices, RenderLayer.getOutline(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE), blockStateModel, 0.0F, 0.0F, 0.0F, light, j, i
            );
        } else {
            orderedRenderCommandQueue.submitBlock(matrices, blockState, light, j, i);
        }
    }
}
