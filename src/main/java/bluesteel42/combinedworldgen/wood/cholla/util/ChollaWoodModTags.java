package bluesteel42.combinedworldgen.wood.cholla.util;

import bluesteel42.combinedworldgen.util.ModTags;
import bluesteel42.combinedworldgen.wood.cholla.ChollaWoodInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class ChollaWoodModTags {
    public static class Blocks {
        public static final TagKey<Block> MOD_BLOCKS = ModTags.Blocks.createTag(ChollaWoodInitializer.MOD_WOOD_NAME + "_blocks");
    }

    public static class Items {
        public static final TagKey<Item> MOD_BLOCKS = ModTags.Items.createTag(ChollaWoodInitializer.MOD_WOOD_NAME + "_blocks");
    }
}
