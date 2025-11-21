package bluesteel42.combinedworldgen.wood.azalea.util;

import bluesteel42.combinedworldgen.util.ModTags;
import bluesteel42.combinedworldgen.wood.azalea.AzaleaWoodInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class AzaleaWoodModTags {
    public static class Blocks {
        public static final TagKey<Block> MOD_BLOCKS = ModTags.Blocks.createTag(AzaleaWoodInitializer.MOD_WOOD_NAME + "_blocks");
        /* ADDITIONAL BLOCKS */
        public static final TagKey<Block> AZALEA_STEMS = ModTags.Blocks.createTag("azalea_stems");

    }

    public static class Items {
        public static final TagKey<Item> MOD_BLOCKS = ModTags.Items.createTag(AzaleaWoodInitializer.MOD_WOOD_NAME + "_blocks");
        /* ADDITIONAL BLOCKS */
        public static final TagKey<Item> AZALEA_STEMS = ModTags.Items.createTag("azalea_stems");

    }
}
