package bluesteel42.combinedworldgen.entity;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityModelLayers {
    public static final EntityModelLayer WHITE_MAIN_MODEL_LAYER = createMain("white_pumpkin_snow_golem");
    public static final EntityModelLayer GREEN_MAIN_MODEL_LAYER = createMain("green_pumpkin_snow_golem");
    public static final EntityModelLayer MOOBLOOM_MAIN_MODEL_LAYER = createMain("moobloom");
    public static final EntityModelLayer MOOBLOOM_BABY_MAIN_MODEL_LAYER = createMain("moobloom_baby");
    public static final EntityModelLayer CLUCKSHROOM_MAIN_MODEL_LAYER = createMain("cluckshroom");
    public static final EntityModelLayer CLUCKSHROOM_BABY_MAIN_MODEL_LAYER = createMain("cluckshroom_baby");

    private static EntityModelLayer createMain(String id) {
        return create(id, "main");
    }
    private static EntityModelLayer create(String id, String layer) {
        return new EntityModelLayer(Identifier.of(CombinedWorldgen.MOD_ID, id), layer);
    }

}
