package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.entity.ModLootTables;
import bluesteel42.combinedworldgen.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModHarvestLootTableProvider extends SimpleFabricLootTableProvider {
    public ModHarvestLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.BLOCK_INTERACT);
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        lootTableBiConsumer.accept(
                ModLootTables.WHITE_PUMPKIN_CARVE,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(ItemEntry.builder(ModItems.WHITE_PUMPKIN_SEEDS).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4.0F))))
                        )
        );
        lootTableBiConsumer.accept(
                ModLootTables.GREEN_PUMPKIN_CARVE,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(ItemEntry.builder(ModItems.GREEN_PUMPKIN_SEEDS).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4.0F))))
                        )
        );
    }
}
