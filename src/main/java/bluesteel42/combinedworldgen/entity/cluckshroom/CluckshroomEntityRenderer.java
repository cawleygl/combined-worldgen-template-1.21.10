package bluesteel42.combinedworldgen.entity.cluckshroom;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.entity.ModEntityModelLayers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class CluckshroomEntityRenderer extends AgeableMobEntityRenderer<CluckshroomEntity, CluckshroomEntityRenderState, CluckshroomEntityModel> {
    private static final Identifier TEXTURE = Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/chicken/cluckshroom.png");

    public CluckshroomEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CluckshroomEntityModel(context.getPart(ModEntityModelLayers.CLUCKSHROOM_MAIN_MODEL_LAYER)), new CluckshroomEntityModel(context.getPart(ModEntityModelLayers.CLUCKSHROOM_BABY_MAIN_MODEL_LAYER)), 0.3F);
        this.addFeature(new CluckshroomMushroomFeatureRenderer(this, context.getBlockRenderManager()));
    }

    public Identifier getTexture(CluckshroomEntityRenderState cluckshroomEntityRenderState) {
        return TEXTURE;
    }

    public CluckshroomEntityRenderState createRenderState() {
        return new CluckshroomEntityRenderState();
    }

    public void updateRenderState(CluckshroomEntity cluckshroomEntity, CluckshroomEntityRenderState cluckshroomEntityRenderState, float f) {
        super.updateRenderState(cluckshroomEntity, cluckshroomEntityRenderState, f);
        cluckshroomEntityRenderState.flapProgress = MathHelper.lerp(f, cluckshroomEntity.prevFlapProgress, cluckshroomEntity.flapProgress);
        cluckshroomEntityRenderState.maxWingDeviation = MathHelper.lerp(f, cluckshroomEntity.prevMaxWingDeviation, cluckshroomEntity.maxWingDeviation);
        cluckshroomEntityRenderState.headMushroom = cluckshroomEntity.getHeadMushroomState();
        cluckshroomEntityRenderState.backMushroom = cluckshroomEntity.getBackMushroomState();
    }
}
