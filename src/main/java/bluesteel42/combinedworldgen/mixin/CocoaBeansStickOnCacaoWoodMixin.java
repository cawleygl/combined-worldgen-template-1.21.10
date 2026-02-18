package bluesteel42.combinedworldgen.mixin;

import bluesteel42.combinedworldgen.wood.cacao.util.CacaoWoodModTags;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CocoaBlock.class)
public class CocoaBeansStickOnCacaoWoodMixin {
	@Inject(at = @At("HEAD"), method = "canPlaceAt", cancellable = true)
	private void init(BlockState state, WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
		if (world.getBlockState(pos.offset(state.get(HorizontalFacingBlock.FACING))).isIn(CacaoWoodModTags.Blocks.MOD_LOGS)) {
			cir.setReturnValue(true);
			cir.cancel();
		}
	}
}