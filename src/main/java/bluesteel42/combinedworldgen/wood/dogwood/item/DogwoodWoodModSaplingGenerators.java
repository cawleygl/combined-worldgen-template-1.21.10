package bluesteel42.combinedworldgen.wood.dogwood.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.dogwood.DogwoodWoodInitializer;
import net.minecraft.block.SaplingGenerator;

public class DogwoodWoodModSaplingGenerators {
    public static final SaplingGenerator MOD_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":" + DogwoodWoodInitializer.MOD_WOOD_NAME,
            DogwoodWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
            DogwoodWoodInitializer.MOD_SAPLING_MEGA_TREE,
            DogwoodWoodInitializer.MOD_SAPLING_RARE_MEGA_TREE,
            DogwoodWoodInitializer.MOD_SAPLING_STANDARD_TREE,
            DogwoodWoodInitializer.MOD_SAPLING_RARE_TREE,
            DogwoodWoodInitializer.MOD_SAPLING_BEES_TREE,
            DogwoodWoodInitializer.MOD_SAPLING_RARE_BEES_TREE
    );
}
