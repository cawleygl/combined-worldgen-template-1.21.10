package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.entity.ModDataComponentTypes;
import bluesteel42.combinedworldgen.entity.ModLootTables;
import bluesteel42.combinedworldgen.entity.moobloom.MoobloomEntity;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.component.ComponentMapPredicate;
import net.minecraft.predicate.component.ComponentsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModShearingLootTableProvider extends SimpleFabricLootTableProvider {
    public ModShearingLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.SHEARING);
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        lootTableBiConsumer.accept(ModLootTables.WHITE_PUMPKIN_SNOW_GOLEM_SHEARING, LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN))));
        lootTableBiConsumer.accept(ModLootTables.GREEN_PUMPKIN_SNOW_GOLEM_SHEARING, LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN))));
        lootTableBiConsumer.accept(
                ModLootTables.MOOBLOOM_SHEARING,
                LootTable.builder().pool(LootPool.builder().with(AlternativeEntry.builder(
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_DANDELION_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.DANDELION)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_POPPY_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.POPPY)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_CORNFLOWER_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.CORNFLOWER)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_ALLIUM_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.ALLIUM)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_BLUE_ORCHID_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.BLUE_ORCHID)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_OXEYE_DAISY_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.OXEYE_DAISY)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_AZURE_BLUET_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.AZURE_BLUET)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_RED_TULIP_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.RED_TULIP)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_ORANGE_TULIP_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.ORANGE_TULIP)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_WHITE_TULIP_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.WHITE_TULIP)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_PINK_TULIP_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.PINK_TULIP)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_LILY_OF_THE_VALLEY_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.LILY_OF_THE_VALLEY)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_LILAC_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.LILAC)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_PEONY_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.PEONY)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_ROSE_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.ROSE)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_SUNFLOWER_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.SUNFLOWER)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_TORCHFLOWER_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.TORCHFLOWER)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_PITCHER_PLANT_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.PITCHER_PLANT)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_OPEN_EYEBLOSSOM_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.OPEN_EYEBLOSSOM)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_CLOSED_EYEBLOSSOM_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.CLOSED_EYEBLOSSOM)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_WITHER_ROSE_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.WITHER_ROSE)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_CACTUS_FLOWER_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.CACTUS_FLOWER)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_MONSTERA_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.MONSTERA)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_YELLOW_TULIP_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.YELLOW_TULIP)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_PURPLE_TULIP_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.PURPLE_TULIP)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_HELLEBORE_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.HELLEBORE)).build()))),
                    LootTableEntry.builder(ModLootTables.MOOBLOOM_GIANT_PADMA_SHEARING).conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS,EntityPredicate.Builder.create().components(ComponentsPredicate.Builder.create().exact(ComponentMapPredicate.of(ModDataComponentTypes.MOOBLOOM_VARIANT, MoobloomEntity.Variant.GIANT_PADMA)).build()))
        )))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_DANDELION_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.DANDELION))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_POPPY_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.POPPY))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_CORNFLOWER_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.CORNFLOWER))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_ALLIUM_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.ALLIUM))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_BLUE_ORCHID_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.BLUE_ORCHID))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_OXEYE_DAISY_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.OXEYE_DAISY))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_AZURE_BLUET_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.AZURE_BLUET))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_RED_TULIP_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.RED_TULIP))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_ORANGE_TULIP_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.ORANGE_TULIP))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_WHITE_TULIP_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.WHITE_TULIP))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_PINK_TULIP_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.PINK_TULIP))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_LILY_OF_THE_VALLEY_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.LILY_OF_THE_VALLEY))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_LILAC_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.LILAC))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_PEONY_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.PEONY))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_ROSE_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.ROSE_BUSH))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_SUNFLOWER_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.SUNFLOWER))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_TORCHFLOWER_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.TORCHFLOWER))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_PITCHER_PLANT_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.PITCHER_PLANT))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_OPEN_EYEBLOSSOM_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.OPEN_EYEBLOSSOM))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_CLOSED_EYEBLOSSOM_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.CLOSED_EYEBLOSSOM))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_WITHER_ROSE_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.WITHER_ROSE))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_CACTUS_FLOWER_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(Items.CACTUS_FLOWER))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_MONSTERA_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(ModFloraBlocks.MONSTERA.asItem()))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_YELLOW_TULIP_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(ModFloraBlocks.YELLOW_TULIP.asItem()))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_PURPLE_TULIP_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(ModFloraBlocks.PURPLE_TULIP.asItem()))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_HELLEBORE_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(ModFloraBlocks.HELLEBORE.asItem()))));
        lootTableBiConsumer.accept(ModLootTables.MOOBLOOM_GIANT_PADMA_SHEARING, LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(5.0F)).with(ItemEntry.builder(ModFloraBlocks.GIANT_PADMA.asItem()))));

        lootTableBiConsumer.accept(ModLootTables.CLUCKSHROOM_SHEARING, LootTable.builder()
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(2.0F))
                                .with(ItemEntry.builder(Items.BROWN_MUSHROOM).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))
                                .with(ItemEntry.builder(Items.RED_MUSHROOM).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F))))
                ));

    }
}
