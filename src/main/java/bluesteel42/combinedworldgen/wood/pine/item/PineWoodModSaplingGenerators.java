package bluesteel42.combinedworldgen.wood.pine.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import bluesteel42.combinedworldgen.wood.pine.PineWoodInitializer;
import net.minecraft.block.SaplingGenerator;

public class PineWoodModSaplingGenerators {
    public static final SaplingGenerator MOD_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":" + PineWoodInitializer.MOD_WOOD_NAME,
            PineWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
            PineWoodInitializer.MOD_SAPLING_MEGA_TREE,
            PineWoodInitializer.MOD_SAPLING_RARE_MEGA_TREE,
            PineWoodInitializer.MOD_SAPLING_STANDARD_TREE,
            PineWoodInitializer.MOD_SAPLING_RARE_TREE,
            PineWoodInitializer.MOD_SAPLING_BEES_TREE,
            PineWoodInitializer.MOD_SAPLING_RARE_BEES_TREE
    );

    /* ADDITIONAL SAPLINGS */
    public static final SaplingGenerator SNOWY_PINE_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":snowy_" + MapleWoodInitializer.MOD_WOOD_NAME,
            PineWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
            PineWoodInitializer.SNOWY_PINE_SAPLING_MEGA_TREE,
            PineWoodInitializer.SNOWY_PINE_SAPLING_RARE_MEGA_TREE,
            PineWoodInitializer.SNOWY_PINE_SAPLING_STANDARD_TREE,
            PineWoodInitializer.SNOWY_PINE_SAPLING_RARE_TREE,
            PineWoodInitializer.SNOWY_PINE_SAPLING_BEES_TREE,
            PineWoodInitializer.SNOWY_PINE_SAPLING_RARE_BEES_TREE
    );
    public static final SaplingGenerator SNOWY_SPRUCE_SAPLING_GENERATOR = new SaplingGenerator(
            CombinedWorldgen.MOD_ID + ":snowy_spruce",
            PineWoodInitializer.MOD_SAPLING_RARE_VARIANT_CHANCE,
            PineWoodInitializer.SNOWY_SPRUCE_SAPLING_MEGA_TREE,
            PineWoodInitializer.SNOWY_SPRUCE_SAPLING_RARE_MEGA_TREE,
            PineWoodInitializer.SNOWY_SPRUCE_SAPLING_STANDARD_TREE,
            PineWoodInitializer.SNOWY_SPRUCE_SAPLING_RARE_TREE,
            PineWoodInitializer.SNOWY_SPRUCE_SAPLING_BEES_TREE,
            PineWoodInitializer.SNOWY_SPRUCE_SAPLING_RARE_BEES_TREE
    );
}
