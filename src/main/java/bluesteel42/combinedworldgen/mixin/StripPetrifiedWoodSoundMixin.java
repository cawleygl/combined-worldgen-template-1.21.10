package bluesteel42.combinedworldgen.mixin;

import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(AxeItem.class)
public class StripPetrifiedWoodSoundMixin {
    @Inject(at = @At("HEAD"), method = "tryStrip", cancellable = true)
    private void init(
            World world, BlockPos pos, @Nullable PlayerEntity player, BlockState state, CallbackInfoReturnable<Optional<BlockState>> cir
    ) {
        if (state.isOf(PetrifiedWoodModBlocks.MOD_LOG) || state.isOf(PetrifiedWoodModBlocks.MOD_WOOD)) {
            STRIPPED_BLOCKSAccessor strippedBlocksAccessor = (STRIPPED_BLOCKSAccessor) (Object) this;
            Optional<BlockState> optional = Optional.ofNullable((BlockState) strippedBlocksAccessor.getSTRIPPED_BLOCKS().get(state.getBlock()).getDefaultState());
            if (optional.isPresent()) {
                world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                cir.setReturnValue(optional);
                cir.cancel();
            }
        }
    }
}
