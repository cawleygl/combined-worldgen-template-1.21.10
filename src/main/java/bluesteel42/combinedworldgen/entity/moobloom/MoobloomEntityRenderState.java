package bluesteel42.combinedworldgen.entity.moobloom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;

@Environment(EnvType.CLIENT)
public class MoobloomEntityRenderState extends LivingEntityRenderState {
    public MoobloomEntity.Variant type = MoobloomEntity.Variant.DANDELION;
    public boolean flowerSpreading;
    public float neckAngle;
    public float headAngle;
}
