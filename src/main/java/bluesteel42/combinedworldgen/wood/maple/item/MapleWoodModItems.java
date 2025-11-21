package bluesteel42.combinedworldgen.wood.maple.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class MapleWoodModItems {
    public static final Item MOD_SIGN = registerSignItem(MapleWoodInitializer.MOD_WOOD_NAME + "_sign");
    public static final Item MOD_HANGING_SIGN = registerHangingSignItem(MapleWoodInitializer.MOD_WOOD_NAME + "_hanging_sign");

    public static Item registerSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CombinedWorldgen.MOD_ID, path));
        final Item item = new SignItem(
                MapleWoodModBlocks.MOD_STANDING_SIGN,
                MapleWoodModBlocks.MOD_WALL_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static Item registerHangingSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CombinedWorldgen.MOD_ID, path));
        final Item item = new HangingSignItem(
                MapleWoodModBlocks.MOD_HANGING_SIGN,
                MapleWoodModBlocks.MOD_WALL_HANGING_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.OAK_HANGING_SIGN, MapleWoodModItems.MOD_HANGING_SIGN);
                    itemGroup.addAfter(Items.OAK_HANGING_SIGN, MapleWoodModItems.MOD_SIGN);
                });

    }
}
