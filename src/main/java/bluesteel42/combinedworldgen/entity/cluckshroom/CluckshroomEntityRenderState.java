package bluesteel42.combinedworldgen.entity.cluckshroom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.passive.MooshroomEntity;

@Environment(EnvType.CLIENT)
public class CluckshroomEntityRenderState extends LivingEntityRenderState {
    public CluckshroomEntity.Variant type = CluckshroomEntity.Variant.RED;
    public float flapProgress;
    public float maxWingDeviation;
}
