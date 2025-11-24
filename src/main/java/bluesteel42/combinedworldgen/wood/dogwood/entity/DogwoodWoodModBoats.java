package bluesteel42.combinedworldgen.wood.dogwood.entity;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.dogwood.DogwoodWoodInitializer;
import com.terraformersmc.terraform.boat.api.data.TerraformBoatData;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class DogwoodWoodModBoats {
    public static final Identifier MOD_BOATS_ID = Identifier.of(CombinedWorldgen.MOD_ID, DogwoodWoodInitializer.MOD_WOOD_NAME);

    public static final Item MOD_BOAT = registerBoatItem(DogwoodWoodInitializer.MOD_WOOD_NAME + "_boat", DogwoodWoodModBoats.MOD_BOATS_ID, false, false);
    public static final Item MOD_CHEST_BOAT = registerBoatItem(DogwoodWoodInitializer.MOD_WOOD_NAME + "_chest_boat", DogwoodWoodModBoats.MOD_BOATS_ID, true, false);

    public static final EntityType<BoatEntity> MOD_BOAT_ENTITY = TerraformBoatData.get(MOD_BOATS_ID).boatEntityType();

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
                    itemGroup.addBefore(Items.DARK_OAK_CHEST_BOAT, DogwoodWoodModBoats.MOD_BOAT);
                    itemGroup.addBefore(Items.DARK_OAK_CHEST_BOAT, DogwoodWoodModBoats.MOD_CHEST_BOAT);
                });

    }
}
