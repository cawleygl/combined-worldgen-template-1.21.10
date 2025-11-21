package bluesteel42.combinedworldgen.wood.pine.particle;

import bluesteel42.combinedworldgen.particle.ModLeavesParticle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.random.Random;

@Environment(EnvType.CLIENT)
public class UntintedNeedlesFactory implements ParticleFactory<SimpleParticleType> {
    private final SpriteProvider spriteProvider;

    public UntintedNeedlesFactory(SpriteProvider spriteProvider) {
        this.spriteProvider = spriteProvider;
    }

    public Particle createParticle(
            SimpleParticleType simpleParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i, Random random
    ) {
        return new ModLeavesParticle(clientWorld, d, e, f, this.spriteProvider.getSprite(random), 0.75F, 10.0F, true, false, 2.0F, 0.75F);
    }
}