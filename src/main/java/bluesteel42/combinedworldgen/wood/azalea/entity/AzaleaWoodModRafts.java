package bluesteel42.combinedworldgen.wood.azalea.entity;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.azalea.AzaleaWoodInitializer;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class AzaleaWoodModRafts {
    public static final Identifier MOD_RAFTS_ID = Identifier.of(CombinedWorldgen.MOD_ID, AzaleaWoodInitializer.MOD_WOOD_NAME);

    public static final Item MOD_RAFT = registerRaftItem(AzaleaWoodInitializer.MOD_WOOD_NAME + "_raft", AzaleaWoodModRafts.MOD_RAFTS_ID, false, true);
    public static final Item MOD_CHEST_RAFT = registerRaftItem(AzaleaWoodInitializer.MOD_WOOD_NAME + "_chest_raft", AzaleaWoodModRafts.MOD_RAFTS_ID, true, true);

    public static Item registerRaftItem(String path, Identifier boatId, boolean chest, boolean raft) {
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
                    itemGroup.addAfter(Items.BAMBOO_CHEST_RAFT, AzaleaWoodModRafts.MOD_CHEST_RAFT);
                    itemGroup.addAfter(Items.BAMBOO_CHEST_RAFT, AzaleaWoodModRafts.MOD_RAFT);
                });

    }
}
