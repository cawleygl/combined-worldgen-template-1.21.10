package bluesteel42.combinedworldgen.wood.pine.util;

import bluesteel42.combinedworldgen.util.ModTags;
import bluesteel42.combinedworldgen.wood.pine.PineWoodInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class PineWoodModTags {
    public static class Blocks {
        public static final TagKey<Block> MOD_LOGS = ModTags.Blocks.createTag(PineWoodInitializer.MOD_WOOD_NAME + "_logs");
    }

    public static class Items {
        public static final TagKey<Item> MOD_LOGS = ModTags.Items.createTag(PineWoodInitializer.MOD_WOOD_NAME + "_logs");
    }
}
