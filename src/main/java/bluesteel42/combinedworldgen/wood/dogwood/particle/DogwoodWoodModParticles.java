package bluesteel42.combinedworldgen.wood.dogwood.particle;

import bluesteel42.combinedworldgen.particle.ModParticles;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;

public class DogwoodWoodModParticles {

    public static final SimpleParticleType DOGWOOD_LEAVES = ModParticles.register("dogwood_leaves",FabricParticleTypes.simple());

    public static void initialize() {}
}
