package bluesteel42.combinedworldgen.mixin;

import bluesteel42.combinedworldgen.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class PreventFenceConnectToPumpkinMixin {
	@Inject(at = @At("HEAD"), method = "cannotConnect", cancellable = true)
	private static void init(BlockState state, CallbackInfoReturnable<Boolean> cir) {
		if (state.isIn(ModTags.Blocks.PUMPKINS)
				|| state.isIn(ModTags.Blocks.CARVED_PUMPKINS)
				|| state.isIn(ModTags.Blocks.JACK_O_LANTERNS)
		) {
			cir.setReturnValue(true);
			cir.cancel();
		}
	}
}