package bluesteel42.combinedworldgen.item;

import com.mojang.serialization.MapCodec;
import net.minecraft.item.consume.ConsumeEffect;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModConsumeEffects {

    public static final ConsumeEffect.Type<RemoveLongestEffectConsumeEffect> REMOVE_LONGEST_EFFECT = register(
            "remove_longest_effect", RemoveLongestEffectConsumeEffect.CODEC, RemoveLongestEffectConsumeEffect.PACKET_CODEC
    );

    private static <T extends ConsumeEffect> ConsumeEffect.Type<T> register(String id, MapCodec<T> codec, PacketCodec<RegistryByteBuf, T> packetCodec) {
        return Registry.register(Registries.CONSUME_EFFECT_TYPE, id, new ConsumeEffect.Type<>(codec, packetCodec));
    }

    public static void initialize() {}
}
