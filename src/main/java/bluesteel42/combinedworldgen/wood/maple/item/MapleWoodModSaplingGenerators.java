package bluesteel42.combinedworldgen.wood.maple.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import net.minecraft.block.SaplingGenerator;

public class MapleWoodModSaplingGenerators {
    public static final SaplingGenerator MOD_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":" + MapleWoodInitializer.MOD_WOOD_NAME,
            MapleWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
            MapleWoodInitializer.MOD_SAPLING_MEGA_TREE,
            MapleWoodInitializer.MOD_SAPLING_RARE_MEGA_TREE,
            MapleWoodInitializer.MOD_SAPLING_STANDARD_TREE,
            MapleWoodInitializer.MOD_SAPLING_RARE_TREE,
            MapleWoodInitializer.MOD_SAPLING_BEES_TREE,
            MapleWoodInitializer.MOD_SAPLING_RARE_BEES_TREE
    );

//    /* ADDITIONAL SAPLINGS */
//    public static final SaplingGenerator RED_MAPLE_SAPLING_GENERATOR = new SaplingGenerator(
//            CombinedWorldgen.MOD_ID + ":red_" + MapleWoodInitializer.MOD_WOOD_TYPE,
//            MapleWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
//            MapleWoodInitializer.RED_MAPLE_SAPLING_MEGA_TREE,
//            MapleWoodInitializer.RED_MAPLE_SAPLING_RARE_MEGA_TREE,
//            MapleWoodInitializer.RED_MAPLE_SAPLING_STANDARD_TREE,
//            MapleWoodInitializer.RED_MAPLE_SAPLING_RARE_TREE,
//            MapleWoodInitializer.RED_MAPLE_SAPLING_BEES_TREE,
//            MapleWoodInitializer.RED_MAPLE_SAPLING_RARE_BEES_TREE
//    );
//    public static final SaplingGenerator YELLOW_MAPLE_SAPLING_GENERATOR = new SaplingGenerator(
//            CombinedWorldgen.MOD_ID + ":yellow_" + MapleWoodInitializer.MOD_WOOD_TYPE,
//            MapleWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
//            MapleWoodInitializer.YELLOW_MAPLE_SAPLING_MEGA_TREE,
//            MapleWoodInitializer.YELLOW_MAPLE_SAPLING_RARE_MEGA_TREE,
//            MapleWoodInitializer.YELLOW_MAPLE_SAPLING_STANDARD_TREE,
//            MapleWoodInitializer.YELLOW_MAPLE_SAPLING_RARE_TREE,
//            MapleWoodInitializer.YELLOW_MAPLE_SAPLING_BEES_TREE,
//            MapleWoodInitializer.YELLOW_MAPLE_SAPLING_RARE_BEES_TREE
//    );

}
