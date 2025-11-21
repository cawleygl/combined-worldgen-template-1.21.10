package bluesteel42.combinedworldgen.wood.pine.particle;

import bluesteel42.combinedworldgen.particle.ModLeavesParticle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.TintedParticleEffect;
import net.minecraft.util.math.random.Random;

@Environment(EnvType.CLIENT)
public class TintedNeedlesFactory implements ParticleFactory<TintedParticleEffect> {
    private final SpriteProvider spriteProvider;

    public TintedNeedlesFactory(SpriteProvider spriteProvider) {
        this.spriteProvider = spriteProvider;
    }

    public Particle createParticle(
            TintedParticleEffect tintedParticleEffect, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i, Random random
    ) {
        ModLeavesParticle needlesParticle = new ModLeavesParticle(clientWorld, d, e, f, this.spriteProvider.getSprite(random), 0.75F, 10.0F, true, false, 2.0F, 0.75F);
        needlesParticle.setColor(tintedParticleEffect.getRed(), tintedParticleEffect.getGreen(), tintedParticleEffect.getBlue());
        return needlesParticle;
    }
}