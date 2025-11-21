package bluesteel42.combinedworldgen.entity.snow_golem;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;

@Environment(EnvType.CLIENT)
public class WhitePumpkinSnowGolemEntityRenderState extends LivingEntityRenderState {
    public boolean hasPumpkin;
}
