package bluesteel42.combinedworldgen.entity.moobloom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BabyModelTransformer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.ModelTransformer;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.entity.state.SheepEntityRenderState;
import net.minecraft.util.math.MathHelper;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class MoobloomEntityModel extends QuadrupedEntityModel<MoobloomEntityRenderState> {
    public static final ModelTransformer BABY_TRANSFORMER = new BabyModelTransformer(false, 8.0F, 6.0F, Set.of("head"));
    private static final int field_56493 = 12;

    public MoobloomEntityModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = getModelData();
        return TexturedModelData.of(modelData, 64, 64);
    }

    public static ModelData getModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(
                EntityModelPartNames.HEAD,
                ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F)
                        .uv(1, 33)
                        .cuboid(-3.0F, 1.0F, -7.0F, 6.0F, 3.0F, 1.0F)
                        .uv(22, 0)
                        .cuboid(EntityModelPartNames.RIGHT_HORN, -5.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F)
                        .uv(22, 0)
                        .cuboid(EntityModelPartNames.LEFT_HORN, 4.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F),
                ModelTransform.origin(0.0F, 4.0F, -8.0F)
        );
        modelPartData.addChild(
                EntityModelPartNames.BODY,
                ModelPartBuilder.create().uv(18, 4).cuboid(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F).uv(52, 0).cuboid(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F),
                ModelTransform.of(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
        );
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().mirrored().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        ModelPartBuilder modelPartBuilder2 = ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
        modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG, modelPartBuilder2, ModelTransform.origin(-4.0F, 12.0F, 7.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG, modelPartBuilder, ModelTransform.origin(4.0F, 12.0F, 7.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, modelPartBuilder2, ModelTransform.origin(-4.0F, 12.0F, -5.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG, modelPartBuilder, ModelTransform.origin(4.0F, 12.0F, -5.0F));
        return modelData;
    }

    public void setAngles(MoobloomEntityRenderState moobloomEntityRenderState) {
        super.setAngles(moobloomEntityRenderState);
        this.head.originY = this.head.originY + moobloomEntityRenderState.neckAngle * 9.0F * moobloomEntityRenderState.ageScale;

        if (moobloomEntityRenderState.flowerSpreading) {
            float speed = 0.4F;
            this.head.yaw = 0.15F * MathHelper.sin(speed * moobloomEntityRenderState.age);
            this.head.roll = 0.15F * MathHelper.sin(speed * moobloomEntityRenderState.age);
            this.rightFrontLeg.pitch = -0.25F * MathHelper.sin(speed * moobloomEntityRenderState.age);
            this.leftFrontLeg.pitch = 0.25F * MathHelper.sin(speed * moobloomEntityRenderState.age);
        }
    }

    public ModelPart getHead() {
        return this.head;
    }
}
