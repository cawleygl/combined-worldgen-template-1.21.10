package bluesteel42.combinedworldgen.wood.maple.block;

import bluesteel42.combinedworldgen.wood.maple.particle.MapleWoodModParticles;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.LeavesBlock;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.particle.TintedParticleEffect;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class TintedParticleMapleLeavesBlock extends LeavesBlock {
    public static final MapCodec<TintedParticleMapleLeavesBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            Codecs.rangedInclusiveFloat(0.0F, 1.0F)
                                    .fieldOf("leaf_particle_chance")
                                    .forGetter(tintedParticleLeavesBlock -> tintedParticleLeavesBlock.leafParticleChance),
                            createSettingsCodec()
                    )
                    .apply(instance, TintedParticleMapleLeavesBlock::new)
    );

    public TintedParticleMapleLeavesBlock(float f, Settings settings) {
        super(f, settings);
    }

    @Override
    protected void spawnLeafParticle(World world, BlockPos pos, Random random) {
        TintedParticleEffect entityEffectParticleEffect = TintedParticleEffect.create(MapleWoodModParticles.GREEN_MAPLE_LEAVES, world.getBlockColor(pos));
        ParticleUtil.spawnParticle(world, pos, random, entityEffectParticleEffect);
    }

    @Override
    public MapCodec<? extends TintedParticleMapleLeavesBlock> getCodec() {
        return CODEC;
    }
}
