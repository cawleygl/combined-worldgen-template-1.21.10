package bluesteel42.combinedworldgen.wood.chorus.util;

import bluesteel42.combinedworldgen.wood.chorus.ChorusWoodInitializer;
import bluesteel42.combinedworldgen.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class ChorusWoodModTags {
    public static class Blocks {
        public static final TagKey<Block> MOD_BLOCKS = ModTags.Blocks.createTag(ChorusWoodInitializer.MOD_WOOD_NAME + "_blocks");
        /* ADDITIONAL BLOCKS */
        public static final TagKey<Block> AZALEA_STEMS = ModTags.Blocks.createTag("azalea_stems");

    }

    public static class Items {
        public static final TagKey<Item> MOD_BLOCKS = ModTags.Items.createTag(ChorusWoodInitializer.MOD_WOOD_NAME + "_blocks");
        /* ADDITIONAL BLOCKS */
        public static final TagKey<Item> AZALEA_STEMS = ModTags.Items.createTag("azalea_stems");

    }
}
