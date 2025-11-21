package bluesteel42.combinedworldgen.wood.willow.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.willow.WillowWoodInitializer;
import net.minecraft.block.SaplingGenerator;

public class WillowWoodModSaplingGenerators {
    public static final SaplingGenerator MOD_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":" + WillowWoodInitializer.MOD_WOOD_NAME,
            WillowWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
            WillowWoodInitializer.MOD_SAPLING_MEGA_TREE,
            WillowWoodInitializer.MOD_SAPLING_RARE_MEGA_TREE,
            WillowWoodInitializer.MOD_SAPLING_STANDARD_TREE,
            WillowWoodInitializer.MOD_SAPLING_RARE_TREE,
            WillowWoodInitializer.MOD_SAPLING_BEES_TREE,
            WillowWoodInitializer.MOD_SAPLING_RARE_BEES_TREE
    );
}
