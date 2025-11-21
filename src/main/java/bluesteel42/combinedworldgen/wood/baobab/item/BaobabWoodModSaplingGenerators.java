package bluesteel42.combinedworldgen.wood.baobab.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.baobab.BaobabWoodInitializer;
import net.minecraft.block.SaplingGenerator;

public class BaobabWoodModSaplingGenerators {
    public static final SaplingGenerator MOD_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":" + BaobabWoodInitializer.MOD_WOOD_NAME,
            BaobabWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
            BaobabWoodInitializer.MOD_SAPLING_MEGA_TREE,
            BaobabWoodInitializer.MOD_SAPLING_RARE_MEGA_TREE,
            BaobabWoodInitializer.MOD_SAPLING_STANDARD_TREE,
            BaobabWoodInitializer.MOD_SAPLING_RARE_TREE,
            BaobabWoodInitializer.MOD_SAPLING_BEES_TREE,
            BaobabWoodInitializer.MOD_SAPLING_RARE_BEES_TREE
    );
}
