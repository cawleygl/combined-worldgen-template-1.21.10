package bluesteel42.combinedworldgen.registries;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.item.ModItems;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class ModRegistries {
    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.TRUNK_ATTACHED_BROWN_MUSHROOM, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.VIOLET, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.CLOVER, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.MONSTERA, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.YELLOW_TULIP, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.PURPLE_TULIP, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.HELLEBORE, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.GIANT_PADMA, 0.65F);

        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.WHITE_WATER_LILY, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.PINK_WATER_LILY, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.BLUE_WATER_LILY, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.PURPLE_WATER_LILY, 0.3F);

        CompostingChanceRegistry.INSTANCE.add(ModItems.CACTUS_PAD, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.COOKED_CACTUS_PAD, 0.5F);

        CompostingChanceRegistry.INSTANCE.add(ModItems.ORANGE, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CHOCOLATE_ORANGE, 0.85F);

        CompostingChanceRegistry.INSTANCE.add(ModItems.WHITE_PUMPKIN_SEEDS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModPumpkinBlocks.WHITE_PUMPKIN, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CARVED_WHITE_PUMPKIN, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.GREEN_PUMPKIN_SEEDS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModPumpkinBlocks.GREEN_PUMPKIN, 0.65F);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CARVED_GREEN_PUMPKIN, 0.65F);

        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.SNOWY_SHORT_GRASS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModFloraBlocks.SNOWY_FERN, 0.65F);

    }
}
