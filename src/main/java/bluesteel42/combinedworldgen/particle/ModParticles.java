package bluesteel42.combinedworldgen.particle;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {
    public static <T extends ParticleEffect> ParticleType<T> register(String path, ParticleType<T> particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(CombinedWorldgen.MOD_ID, path), particleType);
    }

    public static SimpleParticleType register(String path, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(CombinedWorldgen.MOD_ID, path), particleType);
    }

}
