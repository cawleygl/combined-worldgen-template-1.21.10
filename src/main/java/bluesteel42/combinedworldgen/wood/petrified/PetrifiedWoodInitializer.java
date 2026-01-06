package bluesteel42.combinedworldgen.wood.petrified;

import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import bluesteel42.combinedworldgen.wood.petrified.registries.PetrifiedWoodModRegistries;
import net.minecraft.block.MapColor;
import net.minecraft.sound.BlockSoundGroup;

public class PetrifiedWoodInitializer {
    /* STONE QUALITIES, NOT FLAMMABLE OR FUEL, NO LEAVES OR SAPLING */
    public static String MOD_WOOD_TYPE = "petrified";
    public static MapColor MOD_BARK_COLOR = MapColor.DARK_CRIMSON;
    public static MapColor MOD_FIBER_COLOR = MapColor.DEEPSLATE_GRAY;
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.STONE;

    public static void initializeWood() {
        PetrifiedWoodModBlocks.initialize();
        PetrifiedWoodModRegistries.registerStrippables();
    }

    public static void initializeWoodClient() {}
}
