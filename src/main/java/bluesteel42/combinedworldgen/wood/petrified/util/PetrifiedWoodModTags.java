package bluesteel42.combinedworldgen.wood.petrified.util;

import bluesteel42.combinedworldgen.util.ModTags;
import bluesteel42.combinedworldgen.wood.petrified.PetrifiedWoodInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class PetrifiedWoodModTags {
    public static class Blocks {
        public static final TagKey<Block> MOD_LOGS = ModTags.Blocks.createTag(PetrifiedWoodInitializer.MOD_WOOD_NAME + "_logs");
    }

    public static class Items {
        public static final TagKey<Item> MOD_LOGS = ModTags.Items.createTag(PetrifiedWoodInitializer.MOD_WOOD_NAME + "_logs");
    }
}
