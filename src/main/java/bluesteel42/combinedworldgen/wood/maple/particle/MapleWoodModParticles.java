package bluesteel42.combinedworldgen.wood.maple.particle;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.particle.TintedParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MapleWoodModParticles {

    // This DefaultParticleType gets called when you want to use your particle in code.
    public static final ParticleType<TintedParticleEffect> GREEN_MAPLE_LEAVES = register("green_maple_leaves",
            FabricParticleTypes.complex(TintedParticleEffect::createCodec, TintedParticleEffect::createPacketCodec)
    );

    public static final SimpleParticleType RED_MAPLE_LEAVES = register("red_maple_leaves", FabricParticleTypes.simple());
    public static final SimpleParticleType YELLOW_MAPLE_LEAVES = register("yellow_maple_leaves", FabricParticleTypes.simple());

    public static <T extends ParticleEffect> ParticleType<T> register(String path, ParticleType<T> particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(CombinedWorldgen.MOD_ID, path), particleType);
    }

    public static SimpleParticleType register(String path, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(CombinedWorldgen.MOD_ID, path), particleType);
    }

    public static void initialize() {}
}
