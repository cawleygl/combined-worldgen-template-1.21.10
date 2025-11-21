package bluesteel42.combinedworldgen.wood.cholla.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class DriedChollaBlock extends PillarBlock {
    public DriedChollaBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        switch(state.get(Properties.AXIS).getId()) {
            case "x":
                return VoxelShapes.cuboid(0f, 0.0625f, 0.0625f, 1f, 0.9375f, 0.9375f);
            case "z":
                return VoxelShapes.cuboid(0.0625f, 0.0625f, 0f, 0.9375f, 0.9375f, 1f);
            default:
                return VoxelShapes.cuboid(0.0625f, 0f, 0.0625f, 0.9375f, 1f, 0.9375f);
        }

    }
}
