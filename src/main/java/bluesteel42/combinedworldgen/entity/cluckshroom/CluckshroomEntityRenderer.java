package bluesteel42.combinedworldgen.entity.cluckshroom;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.entity.ModEntityModelLayers;
import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class CluckshroomEntityRenderer extends AgeableMobEntityRenderer<CluckshroomEntity, CluckshroomEntityRenderState, CluckshroomEntityModel> {
        private static final Map<CluckshroomEntity.Variant, Identifier> TEXTURES = Util.make(Maps.<CluckshroomEntity.Variant, Identifier>newHashMap(), map -> {
        map.put(CluckshroomEntity.Variant.BROWN, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/chicken/brown_cluckshroom.png"));
        map.put(CluckshroomEntity.Variant.RED, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/chicken/red_cluckshroom.png"));
    });
//    private static final Identifier TEXTURE = Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/chicken/red_cluckshroom.png");

    public CluckshroomEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new CluckshroomEntityModel(context.getPart(ModEntityModelLayers.CLUCKSHROOM_MAIN_MODEL_LAYER)), new CluckshroomEntityModel(context.getPart(ModEntityModelLayers.CLUCKSHROOM_BABY_MAIN_MODEL_LAYER)), 0.3F);
        this.addFeature(new CluckshroomMushroomFeatureRenderer(this, context.getBlockRenderManager()));
    }

    public Identifier getTexture(CluckshroomEntityRenderState cluckshroomEntityRenderState) {
//        return TEXTURE;
        return (Identifier)TEXTURES.get(cluckshroomEntityRenderState.type);
    }

    public CluckshroomEntityRenderState createRenderState() {
        return new CluckshroomEntityRenderState();
    }

    public void updateRenderState(CluckshroomEntity cluckshroomEntity, CluckshroomEntityRenderState cluckshroomEntityRenderState, float f) {
        super.updateRenderState(cluckshroomEntity, cluckshroomEntityRenderState, f);
        cluckshroomEntityRenderState.type = cluckshroomEntity.getVariant();
        cluckshroomEntityRenderState.flapProgress = MathHelper.lerp(f, cluckshroomEntity.prevFlapProgress, cluckshroomEntity.flapProgress);
        cluckshroomEntityRenderState.maxWingDeviation = MathHelper.lerp(f, cluckshroomEntity.prevMaxWingDeviation, cluckshroomEntity.maxWingDeviation);
    }
}
