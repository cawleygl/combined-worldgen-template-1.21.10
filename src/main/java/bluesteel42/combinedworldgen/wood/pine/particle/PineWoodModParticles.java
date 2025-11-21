package bluesteel42.combinedworldgen.wood.pine.particle;

import bluesteel42.combinedworldgen.particle.ModParticles;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.particle.TintedParticleEffect;

public class PineWoodModParticles {

    public static final ParticleType<TintedParticleEffect> PINE_NEEDLES = ModParticles.register("pine_needles",
             FabricParticleTypes.complex(TintedParticleEffect::createCodec, TintedParticleEffect::createPacketCodec)
    );
    public static final ParticleType<TintedParticleEffect> SPRUCE_NEEDLES = ModParticles.register("spruce_needles",
            FabricParticleTypes.complex(TintedParticleEffect::createCodec, TintedParticleEffect::createPacketCodec)
    );
    public static final SimpleParticleType SNOWY_PINE_NEEDLES = ModParticles.register("snowy_pine_needles", FabricParticleTypes.simple());
    public static final SimpleParticleType SNOWY_SPRUCE_NEEDLES = ModParticles.register("snowy_spruce_needles", FabricParticleTypes.simple());

    public static void initialize() {

    }
}
