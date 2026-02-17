package bluesteel42.combinedworldgen.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LeavesBlock.class)
public interface LeavesBlockDistanceInvoker {
	@Invoker("updateDistanceFromLogs")
	static BlockState invokeUpdateDistanceFromLogs(BlockState state, WorldAccess world, BlockPos pos) {
		throw new AssertionError();
	}
}