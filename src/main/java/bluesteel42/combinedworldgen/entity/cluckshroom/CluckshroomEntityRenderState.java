package bluesteel42.combinedworldgen.entity.cluckshroom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;

@Environment(EnvType.CLIENT)
public class CluckshroomEntityRenderState extends LivingEntityRenderState {
    public float flapProgress;
    public float maxWingDeviation;
    public BlockState headMushroom = Blocks.RED_MUSHROOM.getDefaultState();
    public BlockState backMushroom = Blocks.RED_MUSHROOM.getDefaultState();
}
