package bluesteel42.combinedworldgen.entity.moobloom;

import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

public class MoobloomFlowerFeatureRenderer extends FeatureRenderer<MoobloomEntityRenderState, MoobloomEntityModel> {
    private final BlockRenderManager blockRenderManager;

    public MoobloomFlowerFeatureRenderer(MoobloomEntityRenderer context, BlockRenderManager blockRenderManager) {
        super(context);
        this.blockRenderManager = blockRenderManager;
    }

    private BlockState handleTallFlowers(BlockState flower) {
        if (flower.isOf(Blocks.ROSE_BUSH)) {
            return ModFloraBlocks.SMALL_ROSE.getDefaultState();
        } else if (flower.isOf(Blocks.LILAC)) {
            return ModFloraBlocks.SMALL_LILAC.getDefaultState();
        } else if (flower.isOf(Blocks.PEONY)) {
            return ModFloraBlocks.SMALL_PEONY.getDefaultState();
        } else if (flower.isOf(Blocks.SUNFLOWER)) {
            return ModFloraBlocks.SMALL_SUNFLOWER.getDefaultState();
        } else if (flower.isOf(Blocks.PITCHER_PLANT)) {
            return ModFloraBlocks.SMALL_PITCHER_PLANT.getDefaultState();
        } else if (flower.isOf(ModFloraBlocks.MONSTERA)) {
            return ModFloraBlocks.SMALL_MONSTERA.getDefaultState();
        } else return flower;
    }

    public void render(
            MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, int i, MoobloomEntityRenderState moobloomEntityRenderState, float f, float g
    ) {
        if (!moobloomEntityRenderState.baby) {
            boolean bl = moobloomEntityRenderState.hasOutline() && moobloomEntityRenderState.invisible;
            if (!moobloomEntityRenderState.invisible || bl) {
                BlockState blockState = handleTallFlowers(moobloomEntityRenderState.type.getFlowerState());
                BlockStateModel blockStateModel = this.blockRenderManager.getModel(blockState);

                int j = LivingEntityRenderer.getOverlay(moobloomEntityRenderState, 0.0F);
                matrixStack.push();
                matrixStack.translate(0.1F, -0.35F, 0.6F);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-48.0F));
                matrixStack.scale(-0.7F, -0.7F, 0.7F);
                matrixStack.translate(-0.3F, -0.7F, -0.4F);
                this.renderFlower(matrixStack, orderedRenderCommandQueue, i, bl, moobloomEntityRenderState.outlineColor, blockState, j, blockStateModel);
                matrixStack.pop();
                matrixStack.push();
                matrixStack.translate(0.4F, -0.35F, 0.3F);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(32.0F));
                matrixStack.translate(0.1F, 0.0F, -0.6F);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-21.0F));
                matrixStack.scale(-0.7F, -0.7F, 0.7F);
                matrixStack.translate(-0.5F, -0.7F, -0.5F);
                this.renderFlower(matrixStack, orderedRenderCommandQueue, i, bl, moobloomEntityRenderState.outlineColor, blockState, j, blockStateModel);
                matrixStack.pop();
                matrixStack.push();
                matrixStack.translate(0.1F, -0.35F, 0.6F);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(42.0F));
                matrixStack.translate(0.1F, 0.0F, -0.6F);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-68.0F));
                matrixStack.scale(-0.7F, -0.7F, 0.7F);
                matrixStack.translate(-0.5F, -0.7F, -0.5F);
                this.renderFlower(matrixStack, orderedRenderCommandQueue, i, bl, moobloomEntityRenderState.outlineColor, blockState, j, blockStateModel);
                matrixStack.pop();
                matrixStack.push();
                this.getContextModel().getHead().applyTransform(matrixStack);
                matrixStack.translate(0.1F, -0.7F, -0.2F);
                matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-78.0F));
                matrixStack.scale(-0.7F, -0.7F, 0.7F);
                matrixStack.translate(-0.5F, -0.7F, -0.4F);
                this.renderFlower(matrixStack, orderedRenderCommandQueue, i, bl, moobloomEntityRenderState.outlineColor, blockState, j, blockStateModel);
                matrixStack.pop();
            }
        }
    }

    private void renderFlower(
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
