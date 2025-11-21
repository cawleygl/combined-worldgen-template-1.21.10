package bluesteel42.combinedworldgen.wood.maple.block;

import bluesteel42.combinedworldgen.wood.maple.particle.MapleWoodModParticles;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.particle.TintedParticleEffect;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class MixedParticleMapleLeavesBlock extends LeavesBlock {
    public static final MapCodec<MixedParticleMapleLeavesBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            Codecs.rangedInclusiveFloat(0.0F, 1.0F)
                                    .fieldOf("leaf_particle_chance")
                                    .forGetter(mixedParticleMapleLeavesBlock -> mixedParticleMapleLeavesBlock.leafParticleChance),
                            ParticleTypes.TYPE_CODEC.fieldOf("red_leaf_particle").forGetter(untintedParticleLeavesBlock -> untintedParticleLeavesBlock.redLeafParticleEffect),
                            ParticleTypes.TYPE_CODEC.fieldOf("yellow_leaf_particle").forGetter(untintedParticleLeavesBlock -> untintedParticleLeavesBlock.yellowLeafParticleEffect),
                            createSettingsCodec()
                    )
                    .apply(instance, MixedParticleMapleLeavesBlock::new)
    );
    protected final ParticleEffect redLeafParticleEffect;
    protected final ParticleEffect yellowLeafParticleEffect;

    public MixedParticleMapleLeavesBlock(float f, ParticleEffect redLeafParticleEffect, ParticleEffect yellowLeafParticleEffect,Settings settings) {
        super(f, settings);
        this.redLeafParticleEffect = redLeafParticleEffect;
        this.yellowLeafParticleEffect = yellowLeafParticleEffect;
    }

    @Override
    protected void spawnLeafParticle(World world, BlockPos pos, Random random) {
        switch (random.nextInt(3)) {
            case 1:
                ParticleUtil.spawnParticle(world, pos, random, this.redLeafParticleEffect);
                break;
            case 2:
                ParticleUtil.spawnParticle(world, pos, random, this.yellowLeafParticleEffect);
                break;
            default:
                TintedParticleEffect entityEffectParticleEffect = TintedParticleEffect.create(MapleWoodModParticles.GREEN_MAPLE_LEAVES, world.getBlockColor(pos));
                ParticleUtil.spawnParticle(world, pos, random, entityEffectParticleEffect);
                break;
        }
    }

    @Override
    public MapCodec<? extends MixedParticleMapleLeavesBlock> getCodec() {
        return CODEC;
    }
}
