package bluesteel42.combinedworldgen.wood.baobab.entity;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.baobab.BaobabWoodInitializer;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class BaobabWoodModBoats {
    public static final Identifier MOD_BOATS_ID = Identifier.of(CombinedWorldgen.MOD_ID, BaobabWoodInitializer.MOD_WOOD_NAME);

    public static final Item MOD_BOAT = registerBoatItem(BaobabWoodInitializer.MOD_WOOD_NAME + "_boat", BaobabWoodModBoats.MOD_BOATS_ID, false, false);
    public static final Item MOD_CHEST_BOAT = registerBoatItem(BaobabWoodInitializer.MOD_WOOD_NAME + "_chest_boat", BaobabWoodModBoats.MOD_BOATS_ID, true, false);

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
                    itemGroup.addAfter(Items.ACACIA_CHEST_BOAT, BaobabWoodModBoats.MOD_CHEST_BOAT);
                    itemGroup.addAfter(Items.ACACIA_CHEST_BOAT, BaobabWoodModBoats.MOD_BOAT);
                });

    }
}
