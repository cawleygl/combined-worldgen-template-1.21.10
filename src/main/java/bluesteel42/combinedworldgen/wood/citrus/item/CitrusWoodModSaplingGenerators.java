package bluesteel42.combinedworldgen.wood.citrus.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.citrus.CitrusWoodInitializer;
import net.minecraft.block.SaplingGenerator;

public class CitrusWoodModSaplingGenerators {
    public static final SaplingGenerator MOD_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":" + CitrusWoodInitializer.MOD_WOOD_NAME,
            CitrusWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
            CitrusWoodInitializer.MOD_SAPLING_MEGA_TREE,
            CitrusWoodInitializer.MOD_SAPLING_RARE_MEGA_TREE,
            CitrusWoodInitializer.MOD_SAPLING_STANDARD_TREE,
            CitrusWoodInitializer.MOD_SAPLING_RARE_TREE,
            CitrusWoodInitializer.MOD_SAPLING_BEES_TREE,
            CitrusWoodInitializer.MOD_SAPLING_RARE_BEES_TREE
    );
}
