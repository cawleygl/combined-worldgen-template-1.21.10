package bluesteel42.combinedworldgen.wood.citrus.entity;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.citrus.CitrusWoodInitializer;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class CitrusWoodModBoats {
    public static final Identifier MOD_BOATS_ID = Identifier.of(CombinedWorldgen.MOD_ID, CitrusWoodInitializer.MOD_WOOD_NAME);

    public static final Item MOD_BOAT = registerBoatItem(CitrusWoodInitializer.MOD_WOOD_NAME + "_boat", CitrusWoodModBoats.MOD_BOATS_ID, false, false);
    public static final Item MOD_CHEST_BOAT = registerBoatItem(CitrusWoodInitializer.MOD_WOOD_NAME + "_chest_boat", CitrusWoodModBoats.MOD_BOATS_ID, true, false);

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
                    itemGroup.addAfter(Items.JUNGLE_CHEST_BOAT, CitrusWoodModBoats.MOD_CHEST_BOAT);
                    itemGroup.addAfter(Items.JUNGLE_CHEST_BOAT, CitrusWoodModBoats.MOD_BOAT);
                });

    }
}
