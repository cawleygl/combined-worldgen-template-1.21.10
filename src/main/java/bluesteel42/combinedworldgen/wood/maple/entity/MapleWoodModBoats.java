package bluesteel42.combinedworldgen.wood.maple.entity;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class MapleWoodModBoats {
    public static final Identifier MOD_BOATS_ID = Identifier.of(CombinedWorldgen.MOD_ID, MapleWoodInitializer.MOD_WOOD_NAME);

    public static final Item MOD_BOAT = registerBoatItem(MapleWoodInitializer.MOD_WOOD_NAME + "_boat", MapleWoodModBoats.MOD_BOATS_ID, false, false);
    public static final Item MOD_CHEST_BOAT = registerBoatItem(MapleWoodInitializer.MOD_WOOD_NAME + "_chest_boat", MapleWoodModBoats.MOD_BOATS_ID, true, false);

    public static Item registerBoatItem(String path, Identifier boatId, boolean chest, boolean raft) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CombinedWorldgen.MOD_ID, path));
        return TerraformBoatItemHelper.registerBoatItem(
                boatId,
                new Item.Settings().maxCount(1).registryKey(registryKey),
                chest,
                raft
        );
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.OAK_CHEST_BOAT, MapleWoodModBoats.MOD_CHEST_BOAT);
                    itemGroup.addAfter(Items.OAK_CHEST_BOAT, MapleWoodModBoats.MOD_BOAT);
                });

    }
}
