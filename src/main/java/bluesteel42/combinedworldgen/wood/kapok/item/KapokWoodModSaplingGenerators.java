package bluesteel42.combinedworldgen.wood.kapok.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.kapok.KapokWoodInitializer;
import net.minecraft.block.SaplingGenerator;

public class KapokWoodModSaplingGenerators {
    public static final SaplingGenerator CACAO_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":" + KapokWoodInitializer.CACAO_WOOD_NAME,
            KapokWoodInitializer.CACAO_SAPLING_RARE_VARIANT_CHANCE,
            KapokWoodInitializer.CACAO_SAPLING_MEGA_TREE,
            KapokWoodInitializer.CACAO_SAPLING_RARE_MEGA_TREE,
            KapokWoodInitializer.CACAO_SAPLING_STANDARD_TREE,
            KapokWoodInitializer.CACAO_SAPLING_RARE_TREE,
            KapokWoodInitializer.CACAO_SAPLING_BEES_TREE,
            KapokWoodInitializer.CACAO_SAPLING_RARE_BEES_TREE
    );
}
