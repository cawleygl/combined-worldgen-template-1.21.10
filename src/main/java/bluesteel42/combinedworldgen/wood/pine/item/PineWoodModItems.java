package bluesteel42.combinedworldgen.wood.pine.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.pine.PineWoodInitializer;
import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class PineWoodModItems {
    public static final Item MOD_SIGN = registerSignItem(PineWoodInitializer.MOD_WOOD_NAME + "_sign");
    public static final Item MOD_HANGING_SIGN = registerHangingSignItem(PineWoodInitializer.MOD_WOOD_NAME + "_hanging_sign");

    public static Item registerSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CombinedWorldgen.MOD_ID, path));
        final Item item = new SignItem(
                PineWoodModBlocks.MOD_STANDING_SIGN,
                PineWoodModBlocks.MOD_WALL_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static Item registerHangingSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CombinedWorldgen.MOD_ID, path));
        final Item item = new HangingSignItem(
                PineWoodModBlocks.MOD_HANGING_SIGN,
                PineWoodModBlocks.MOD_WALL_HANGING_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.SPRUCE_HANGING_SIGN, PineWoodModItems.MOD_HANGING_SIGN);
                    itemGroup.addAfter(Items.SPRUCE_HANGING_SIGN, PineWoodModItems.MOD_SIGN);
                });

    }
}
