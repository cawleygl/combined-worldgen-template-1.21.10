package bluesteel42.combinedworldgen.wood.willow.util;

import bluesteel42.combinedworldgen.util.ModTags;
import bluesteel42.combinedworldgen.wood.willow.WillowWoodInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class WillowWoodModTags {
    public static class Blocks {
        public static final TagKey<Block> MOD_LOGS = ModTags.Blocks.createTag(WillowWoodInitializer.MOD_WOOD_NAME + "_logs");
    }

    public static class Items {
        public static final TagKey<Item> MOD_LOGS = ModTags.Items.createTag(WillowWoodInitializer.MOD_WOOD_NAME + "_logs");
    }
}
