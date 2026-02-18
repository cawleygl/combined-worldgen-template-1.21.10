package bluesteel42.combinedworldgen.wood.cacao.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.cacao.CacaoWoodInitializer;
import net.minecraft.block.SaplingGenerator;

public class CacaoWoodModSaplingGenerators {
    public static final SaplingGenerator MOD_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":" + CacaoWoodInitializer.MOD_WOOD_NAME,
            CacaoWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
            CacaoWoodInitializer.MOD_SAPLING_MEGA_TREE,
            CacaoWoodInitializer.MOD_SAPLING_RARE_MEGA_TREE,
            CacaoWoodInitializer.MOD_SAPLING_STANDARD_TREE,
            CacaoWoodInitializer.MOD_SAPLING_RARE_TREE,
            CacaoWoodInitializer.MOD_SAPLING_BEES_TREE,
            CacaoWoodInitializer.MOD_SAPLING_RARE_BEES_TREE
    );
}
