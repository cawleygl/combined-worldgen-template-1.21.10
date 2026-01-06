package bluesteel42.combinedworldgen.wood.petrified.registries;

import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class PetrifiedWoodModRegistries {
    public static void registerStrippables() {
        StrippableBlockRegistry.register(PetrifiedWoodModBlocks.MOD_WOOD, PetrifiedWoodModBlocks.STRIPPED_MOD_WOOD);
        StrippableBlockRegistry.register(PetrifiedWoodModBlocks.MOD_LOG, PetrifiedWoodModBlocks.STRIPPED_MOD_LOG);
    }

}
