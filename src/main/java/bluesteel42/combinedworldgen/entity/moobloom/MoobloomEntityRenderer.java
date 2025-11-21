package bluesteel42.combinedworldgen.entity.moobloom;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.entity.ModEntityModelLayers;
import com.google.common.collect.Maps;
import net.minecraft.client.render.entity.AgeableMobEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class MoobloomEntityRenderer extends AgeableMobEntityRenderer<MoobloomEntity, MoobloomEntityRenderState, MoobloomEntityModel> {
    private static final Map<MoobloomEntity.Variant, Identifier> TEXTURES = Util.make(Maps.<MoobloomEntity.Variant, Identifier>newHashMap(), map -> {
        map.put(MoobloomEntity.Variant.DANDELION, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/dandelion_moobloom.png"));
        map.put(MoobloomEntity.Variant.POPPY, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/poppy_moobloom.png"));
        map.put(MoobloomEntity.Variant.CORNFLOWER, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/cornflower_moobloom.png"));
        map.put(MoobloomEntity.Variant.ALLIUM, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/allium_moobloom.png"));
        map.put(MoobloomEntity.Variant.BLUE_ORCHID, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/blue_orchid_moobloom.png"));
        map.put(MoobloomEntity.Variant.OXEYE_DAISY, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/oxeye_daisy_moobloom.png"));
        map.put(MoobloomEntity.Variant.AZURE_BLUET, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/azure_bluet_moobloom.png"));
        map.put(MoobloomEntity.Variant.RED_TULIP, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/red_tulip_moobloom.png"));
        map.put(MoobloomEntity.Variant.ORANGE_TULIP, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/orange_tulip_moobloom.png"));
        map.put(MoobloomEntity.Variant.WHITE_TULIP, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/white_tulip_moobloom.png"));
        map.put(MoobloomEntity.Variant.PINK_TULIP, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/pink_tulip_moobloom.png"));
        map.put(MoobloomEntity.Variant.LILY_OF_THE_VALLEY, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/lily_of_the_valley_moobloom.png"));
        map.put(MoobloomEntity.Variant.LILAC, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/lilac_moobloom.png"));
        map.put(MoobloomEntity.Variant.PEONY, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/peony_moobloom.png"));
        map.put(MoobloomEntity.Variant.ROSE, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/rose_moobloom.png"));
        map.put(MoobloomEntity.Variant.SUNFLOWER, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/sunflower_moobloom.png"));
        map.put(MoobloomEntity.Variant.TORCHFLOWER, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/torchflower_moobloom.png"));
        map.put(MoobloomEntity.Variant.PITCHER_PLANT, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/pitcher_plant_moobloom.png"));
        map.put(MoobloomEntity.Variant.OPEN_EYEBLOSSOM, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/eyeblossom_moobloom.png"));
        map.put(MoobloomEntity.Variant.CLOSED_EYEBLOSSOM, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/eyeblossom_moobloom.png"));
        map.put(MoobloomEntity.Variant.WITHER_ROSE, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/wither_rose_moobloom.png"));
        map.put(MoobloomEntity.Variant.CACTUS_FLOWER, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/cactus_flower_moobloom.png"));
        map.put(MoobloomEntity.Variant.MONSTERA, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/monstera_moobloom.png"));
        map.put(MoobloomEntity.Variant.YELLOW_TULIP, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/yellow_tulip_moobloom.png"));
        map.put(MoobloomEntity.Variant.PURPLE_TULIP, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/purple_tulip_moobloom.png"));
        map.put(MoobloomEntity.Variant.HELLEBORE, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/hellebore_moobloom.png"));
        map.put(MoobloomEntity.Variant.GIANT_PADMA, Identifier.of(CombinedWorldgen.MOD_ID, "textures/entity/cow/giant_padma_moobloom.png"));
    });

    public MoobloomEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new MoobloomEntityModel(context.getPart(ModEntityModelLayers.MOOBLOOM_MAIN_MODEL_LAYER)), new MoobloomEntityModel(context.getPart(ModEntityModelLayers.MOOBLOOM_BABY_MAIN_MODEL_LAYER)), 0.7F);
        this.addFeature(new MoobloomFlowerFeatureRenderer(this, context.getBlockRenderManager()));
    }

    public Identifier getTexture(MoobloomEntityRenderState moobloomEntityRenderState) {
        return (Identifier)TEXTURES.get(moobloomEntityRenderState.type);
    }

    public MoobloomEntityRenderState createRenderState() {
        return new MoobloomEntityRenderState();
    }

    public void updateRenderState(MoobloomEntity moobloomEntity, MoobloomEntityRenderState moobloomEntityRenderState, float f) {
        super.updateRenderState(moobloomEntity, moobloomEntityRenderState, f);
        moobloomEntityRenderState.flowerSpreading = moobloomEntity.getSpreadingFlowersState();
        moobloomEntityRenderState.headAngle = moobloomEntity.getHeadAngle(f);
        moobloomEntityRenderState.neckAngle = moobloomEntity.getNeckAngle(f);
        moobloomEntityRenderState.type = moobloomEntity.getVariant();
    }
}
