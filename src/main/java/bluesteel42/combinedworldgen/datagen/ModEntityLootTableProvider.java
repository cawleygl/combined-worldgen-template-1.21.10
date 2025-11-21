package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.entity.ModEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantedCountIncreaseLootFunction;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEntityLootTableProvider extends FabricEntityLootTableProvider {

    public ModEntityLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        this.register(
                ModEntities.CLUCKSHROOM,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(Items.FEATHER)
                                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                        )
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(Items.CHICKEN)
                                                        .apply(FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition()))
                                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                        )
                        )
        );
        this.register(
                ModEntities.MOOBLOOM,
                LootTable.builder()
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(Items.LEATHER)
                                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 2.0F)))
                                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                        )
                        )
                        .pool(
                                LootPool.builder()
                                        .rolls(ConstantLootNumberProvider.create(1.0F))
                                        .with(
                                                ItemEntry.builder(Items.BEEF)
                                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))
                                                        .apply(FurnaceSmeltLootFunction.builder().conditionally(this.createSmeltLootCondition()))
                                                        .apply(EnchantedCountIncreaseLootFunction.builder(this.registries, UniformLootNumberProvider.create(0.0F, 1.0F)))
                                        )
                        )
        );
    }
}
