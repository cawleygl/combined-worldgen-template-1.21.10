package bluesteel42.combinedworldgen.item;

import com.mojang.serialization.MapCodec;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.world.World;

import java.util.Iterator;

public record RemoveLongestEffectConsumeEffect() implements ConsumeEffect {
    public static final RemoveLongestEffectConsumeEffect INSTANCE = new RemoveLongestEffectConsumeEffect();
    public static final MapCodec<RemoveLongestEffectConsumeEffect> CODEC = MapCodec.unit(INSTANCE);
    public static final PacketCodec<RegistryByteBuf, RemoveLongestEffectConsumeEffect> PACKET_CODEC = PacketCodec.unit(INSTANCE);

    @Override
    public Type<RemoveLongestEffectConsumeEffect> getType() {
        return ModConsumeEffects.REMOVE_LONGEST_EFFECT;
    }

    private StatusEffectInstance lastsLongerThan(StatusEffectInstance effect1, StatusEffectInstance effect2) {
        return effect1.isInfinite() || (effect1.getDuration() > effect2.getDuration()) ? effect1 : effect2;
    }

    @Override
    public boolean onConsume(World world, ItemStack stack, LivingEntity user) {
        boolean bl = false;
        StatusEffectInstance longestEffect = new StatusEffectInstance(StatusEffects.WITHER);

        Iterator<StatusEffectInstance> iterator = user.getStatusEffects().iterator();

        while (iterator.hasNext()) {
            longestEffect = lastsLongerThan(iterator.next(), longestEffect);
        }

        if (user.removeStatusEffect(longestEffect.getEffectType())) {
            bl = true;
        }

        return bl;
    }
}
