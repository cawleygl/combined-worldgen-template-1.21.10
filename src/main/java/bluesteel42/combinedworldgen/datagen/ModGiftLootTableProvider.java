package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.entity.ModLootTables;
import bluesteel42.combinedworldgen.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModGiftLootTableProvider extends SimpleFabricLootTableProvider {
    public ModGiftLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.GIFT);
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        lootTableBiConsumer.accept(
                ModLootTables.RED_CLUCKSHROOM_LAY_GAMEPLAY,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(ModItems.SPOTTED_EGG)))
        );
        lootTableBiConsumer.accept(
                ModLootTables.BROWN_CLUCKSHROOM_LAY_GAMEPLAY,
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(ItemEntry.builder(ModItems.UMAMI_EGG)))
        );
    }
}
