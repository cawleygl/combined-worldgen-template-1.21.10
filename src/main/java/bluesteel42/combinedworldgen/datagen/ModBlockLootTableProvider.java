package bluesteel42.combinedworldgen.datagen;

import bluesteel42.combinedworldgen.block.ModBlocks;
import bluesteel42.combinedworldgen.block.building.ModBuildingBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.item.ModItems;
import bluesteel42.combinedworldgen.property.ModProperties;
import bluesteel42.combinedworldgen.wood.azalea.block.AzaleaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.baobab.BaobabWoodInitializer;
import bluesteel42.combinedworldgen.wood.baobab.block.BaobabWoodModBlocks;
import bluesteel42.combinedworldgen.wood.cacao.CacaoWoodInitializer;
import bluesteel42.combinedworldgen.wood.cacao.block.CacaoWoodModBlocks;
import bluesteel42.combinedworldgen.wood.cholla.block.ChollaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.chorus.block.ChorusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.citrus.CitrusWoodInitializer;
import bluesteel42.combinedworldgen.wood.citrus.block.CitrusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.citrus.block.FloweringOrangeLeavesBlock;
import bluesteel42.combinedworldgen.wood.dogwood.DogwoodWoodInitializer;
import bluesteel42.combinedworldgen.wood.dogwood.block.DogwoodWoodModBlocks;
import bluesteel42.combinedworldgen.wood.kapok.KapokWoodInitializer;
import bluesteel42.combinedworldgen.wood.kapok.block.KapokWoodModBlocks;
import bluesteel42.combinedworldgen.wood.maple.MapleWoodInitializer;
import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import bluesteel42.combinedworldgen.wood.pine.PineWoodInitializer;
import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import bluesteel42.combinedworldgen.wood.willow.WillowWoodInitializer;
import bluesteel42.combinedworldgen.wood.willow.block.WillowWoodModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.StringIdentifiable;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }
//    public LootTable.Builder leafyAzaleaStemDrops(Block drop) {
//        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
//        return this.dropsWithSilkTouch(
//                drop,
//                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
//                        drop,
//                        ItemEntry.builder(Items.RAW_COPPER)
//                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
//                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
//                )
//        );
//    }

//    public LootTable.Builder chorusPlantDrops(ItemConvertible block, ItemConvertible drop, LootNumberProvider count) {
//        return this.dropsWithSilkTouch(
//                        (Block) block,
//                        (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
//                                drop,
//                                ItemEntry.builder(drop)
//                                        .apply(SetCountLootFunction.builder(count))
//                        )
//                );
//    }

    public void generateNaturalWoodBlockLootTables(
            Block log,
            Block wood,
            Block strippedLog,
            Block strippedWood,
            Block planks,
            Block stairs,
            Block slab,
            Block button,
            Block fence,
            Block fenceGate,
            Block pressurePlate,
            Block door,
            Block trapdoor,
            Block leaves,
            Block sapling,
            float[] saplingDropChance,
            Block pottedSapling,
            Block standingSign,
            Block wallSign,
            Block hangingSign,
            Block wallHangingSign,
            Block shelf
    ) {
        addDrop(log);
        addDrop(wood);
        addDrop(strippedLog);
        addDrop(strippedWood);

        addDrop(planks);
        addDrop(stairs);
        addDrop(button);
        addDrop(fenceGate);
        addDrop(fence);
        addDrop(pressurePlate);
        addDrop(trapdoor);
        addDrop(door, doorDrops(door));
        addDrop(slab, slabDrops(slab));

        addDrop(standingSign);
        addDrop(wallSign);
        addDrop(hangingSign);
        addDrop(wallHangingSign);

        addDrop(shelf);

        addDrop(sapling);
        addPottedPlantDrops(pottedSapling);
        addDrop(leaves, leavesDrops(leaves, sapling, saplingDropChance));

    }

    // USE VANILLA SAPLING WITH NEW LEAVES (KAPOK WOOD)
    public void generateNaturalWoodBlockLootTablesWithVanillaSapling(
            Block log,
            Block wood,
            Block strippedLog,
            Block strippedWood,
            Block planks,
            Block stairs,
            Block slab,
            Block button,
            Block fence,
            Block fenceGate,
            Block pressurePlate,
            Block door,
            Block trapdoor,
            Block leaves,
            Block vanillaSapling,
            float[] saplingDropChance,
            Block standingSign,
            Block wallSign,
            Block hangingSign,
            Block wallHangingSign,
            Block shelf
    ) {
        addDrop(log);
        addDrop(wood);
        addDrop(strippedLog);
        addDrop(strippedWood);

        addDrop(planks);
        addDrop(stairs);
        addDrop(button);
        addDrop(fenceGate);
        addDrop(fence);
        addDrop(pressurePlate);
        addDrop(trapdoor);
        addDrop(door, doorDrops(door));
        addDrop(slab, slabDrops(slab));

        addDrop(standingSign);
        addDrop(wallSign);
        addDrop(hangingSign);
        addDrop(wallHangingSign);

        addDrop(shelf);
        addDrop(leaves, leavesDrops(leaves, vanillaSapling, saplingDropChance));
    }

    public void generateCombinedWoodBlockLootTables(
            Block log,
            Block strippedLog,
            Block planks,
            Block mosaic,
            Block stairs,
            Block mosaicStairs,
            Block slab,
            Block mosaicSlab,
            Block button,
            Block fence,
            Block fenceGate,
            Block pressurePlate,
            Block door,
            Block trapdoor,
            Block standingSign,
            Block wallSign,
            Block hangingSign,
            Block wallHangingSign,
            Block shelf
    ) {
        addDrop(log);
        addDrop(strippedLog);

        addDrop(planks);
        addDrop(mosaic);
        addDrop(stairs);
        addDrop(mosaicStairs);
        addDrop(button);
        addDrop(fenceGate);
        addDrop(fence);
        addDrop(pressurePlate);
        addDrop(trapdoor);
        addDrop(door, doorDrops(door));
        addDrop(slab, slabDrops(slab));
        addDrop(mosaicSlab, slabDrops(mosaicSlab));

        addDrop(standingSign);
        addDrop(wallSign);
        addDrop(hangingSign);
        addDrop(wallHangingSign);

        addDrop(shelf);

    }

    public void generateAzaleaWoodLootTables() {
        generateCombinedWoodBlockLootTables(
                AzaleaWoodModBlocks.MOD_BLOCK,
                AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK,
                AzaleaWoodModBlocks.MOD_PLANKS,
                AzaleaWoodModBlocks.MOD_MOSAIC,
                AzaleaWoodModBlocks.MOD_STAIRS,
                AzaleaWoodModBlocks.MOD_MOSAIC_STAIRS,
                AzaleaWoodModBlocks.MOD_SLAB,
                AzaleaWoodModBlocks.MOD_MOSAIC_SLAB,
                AzaleaWoodModBlocks.MOD_BUTTON,
                AzaleaWoodModBlocks.MOD_FENCE,
                AzaleaWoodModBlocks.MOD_FENCE_GATE,
                AzaleaWoodModBlocks.MOD_PRESSURE_PLATE,
                AzaleaWoodModBlocks.MOD_DOOR,
                AzaleaWoodModBlocks.MOD_TRAPDOOR,
                AzaleaWoodModBlocks.MOD_STANDING_SIGN,
                AzaleaWoodModBlocks.MOD_WALL_SIGN,
                AzaleaWoodModBlocks.MOD_HANGING_SIGN,
                AzaleaWoodModBlocks.MOD_WALL_HANGING_SIGN,
                AzaleaWoodModBlocks.MOD_SHELF
        );
        /* ADDITIONAL BLOCKS */
        addDrop(AzaleaWoodModBlocks.AZALEA_STEM);
        addPottedPlantDrops(AzaleaWoodModBlocks.POTTED_AZALEA_STEM);
        addDrop(AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM);
        addPottedPlantDrops(AzaleaWoodModBlocks.POTTED_STRIPPED_AZALEA_STEM);
        addDrop(AzaleaWoodModBlocks.LEAFY_AZALEA_STEM, block -> this.drops(AzaleaWoodModBlocks.LEAFY_AZALEA_STEM, AzaleaWoodModBlocks.AZALEA_STEM));
    }
    public void generateBaobabWoodLootTables() {
        generateNaturalWoodBlockLootTables(
                BaobabWoodModBlocks.MOD_LOG,
                BaobabWoodModBlocks.MOD_WOOD,
                BaobabWoodModBlocks.STRIPPED_MOD_LOG,
                BaobabWoodModBlocks.STRIPPED_MOD_WOOD,
                BaobabWoodModBlocks.MOD_PLANKS,
                BaobabWoodModBlocks.MOD_STAIRS,
                BaobabWoodModBlocks.MOD_SLAB,
                BaobabWoodModBlocks.MOD_BUTTON,
                BaobabWoodModBlocks.MOD_FENCE,
                BaobabWoodModBlocks.MOD_FENCE_GATE,
                BaobabWoodModBlocks.MOD_PRESSURE_PLATE,
                BaobabWoodModBlocks.MOD_DOOR,
                BaobabWoodModBlocks.MOD_TRAPDOOR,
                BaobabWoodModBlocks.MOD_LEAVES,
                BaobabWoodModBlocks.MOD_SAPLING,
                BaobabWoodInitializer.MOD_SAPLING_DROP_CHANCE,
                BaobabWoodModBlocks.POTTED_MOD_SAPLING,
                BaobabWoodModBlocks.MOD_STANDING_SIGN,
                BaobabWoodModBlocks.MOD_WALL_SIGN,
                BaobabWoodModBlocks.MOD_HANGING_SIGN,
                BaobabWoodModBlocks.MOD_WALL_HANGING_SIGN,
                BaobabWoodModBlocks.MOD_SHELF
        );
    }
    public void generateCacaoWoodLootTables() {
        generateNaturalWoodBlockLootTables(
                CacaoWoodModBlocks.MOD_LOG,
                CacaoWoodModBlocks.MOD_WOOD,
                CacaoWoodModBlocks.STRIPPED_MOD_LOG,
                CacaoWoodModBlocks.STRIPPED_MOD_WOOD,
                CacaoWoodModBlocks.MOD_PLANKS,
                CacaoWoodModBlocks.MOD_STAIRS,
                CacaoWoodModBlocks.MOD_SLAB,
                CacaoWoodModBlocks.MOD_BUTTON,
                CacaoWoodModBlocks.MOD_FENCE,
                CacaoWoodModBlocks.MOD_FENCE_GATE,
                CacaoWoodModBlocks.MOD_PRESSURE_PLATE,
                CacaoWoodModBlocks.MOD_DOOR,
                CacaoWoodModBlocks.MOD_TRAPDOOR,
                CacaoWoodModBlocks.MOD_LEAVES,
                CacaoWoodModBlocks.MOD_SAPLING,
                CacaoWoodInitializer.MOD_SAPLING_DROP_CHANCE,
                CacaoWoodModBlocks.POTTED_MOD_SAPLING,
                CacaoWoodModBlocks.MOD_STANDING_SIGN,
                CacaoWoodModBlocks.MOD_WALL_SIGN,
                CacaoWoodModBlocks.MOD_HANGING_SIGN,
                CacaoWoodModBlocks.MOD_WALL_HANGING_SIGN,
                CacaoWoodModBlocks.MOD_SHELF
        );
    }
    public void generateChollaWoodLootTables() {
        generateCombinedWoodBlockLootTables(
                ChollaWoodModBlocks.MOD_BLOCK,
                ChollaWoodModBlocks.STRIPPED_MOD_BLOCK,
                ChollaWoodModBlocks.MOD_PLANKS,
                ChollaWoodModBlocks.MOD_MOSAIC,
                ChollaWoodModBlocks.MOD_STAIRS,
                ChollaWoodModBlocks.MOD_MOSAIC_STAIRS,
                ChollaWoodModBlocks.MOD_SLAB,
                ChollaWoodModBlocks.MOD_MOSAIC_SLAB,
                ChollaWoodModBlocks.MOD_BUTTON,
                ChollaWoodModBlocks.MOD_FENCE,
                ChollaWoodModBlocks.MOD_FENCE_GATE,
                ChollaWoodModBlocks.MOD_PRESSURE_PLATE,
                ChollaWoodModBlocks.MOD_DOOR,
                ChollaWoodModBlocks.MOD_TRAPDOOR,
                ChollaWoodModBlocks.MOD_STANDING_SIGN,
                ChollaWoodModBlocks.MOD_WALL_SIGN,
                ChollaWoodModBlocks.MOD_HANGING_SIGN,
                ChollaWoodModBlocks.MOD_WALL_HANGING_SIGN,
                ChollaWoodModBlocks.MOD_SHELF
        );
        /* ADDITIONAL BLOCKS */
        addDrop(ChollaWoodModBlocks.DRIED_CHOLLA);
        addPottedPlantDrops(ChollaWoodModBlocks.POTTED_DRIED_CHOLLA);
        addDrop(ChollaWoodModBlocks.STRIPPED_DRIED_CHOLLA);
        addPottedPlantDrops(ChollaWoodModBlocks.POTTED_STRIPPED_DRIED_CHOLLA);
    }
    public void generateChorusWoodLootTables() {
        generateCombinedWoodBlockLootTables(
                ChorusWoodModBlocks.MOD_BLOCK,
                ChorusWoodModBlocks.STRIPPED_MOD_BLOCK,
                ChorusWoodModBlocks.MOD_PLANKS,
                ChorusWoodModBlocks.MOD_MOSAIC,
                ChorusWoodModBlocks.MOD_STAIRS,
                ChorusWoodModBlocks.MOD_MOSAIC_STAIRS,
                ChorusWoodModBlocks.MOD_SLAB,
                ChorusWoodModBlocks.MOD_MOSAIC_SLAB,
                ChorusWoodModBlocks.MOD_BUTTON,
                ChorusWoodModBlocks.MOD_FENCE,
                ChorusWoodModBlocks.MOD_FENCE_GATE,
                ChorusWoodModBlocks.MOD_PRESSURE_PLATE,
                ChorusWoodModBlocks.MOD_DOOR,
                ChorusWoodModBlocks.MOD_TRAPDOOR,
                ChorusWoodModBlocks.MOD_STANDING_SIGN,
                ChorusWoodModBlocks.MOD_WALL_SIGN,
                ChorusWoodModBlocks.MOD_HANGING_SIGN,
                ChorusWoodModBlocks.MOD_WALL_HANGING_SIGN,
                ChorusWoodModBlocks.MOD_SHELF
        );
//        addDrop(Blocks.CHORUS_PLANT, chorusPlantDrops(Blocks.CHORUS_PLANT, Items.CHORUS_FRUIT, UniformLootNumberProvider.create(0.0F, 1.0F)));
    }
    public void generateCitrusWoodLootTables() {
        generateNaturalWoodBlockLootTables(
                CitrusWoodModBlocks.MOD_LOG,
                CitrusWoodModBlocks.MOD_WOOD,
                CitrusWoodModBlocks.STRIPPED_MOD_LOG,
                CitrusWoodModBlocks.STRIPPED_MOD_WOOD,
                CitrusWoodModBlocks.MOD_PLANKS,
                CitrusWoodModBlocks.MOD_STAIRS,
                CitrusWoodModBlocks.MOD_SLAB,
                CitrusWoodModBlocks.MOD_BUTTON,
                CitrusWoodModBlocks.MOD_FENCE,
                CitrusWoodModBlocks.MOD_FENCE_GATE,
                CitrusWoodModBlocks.MOD_PRESSURE_PLATE,
                CitrusWoodModBlocks.MOD_DOOR,
                CitrusWoodModBlocks.MOD_TRAPDOOR,
                CitrusWoodModBlocks.MOD_LEAVES,
                CitrusWoodModBlocks.MOD_SAPLING,
                CitrusWoodInitializer.MOD_SAPLING_DROP_CHANCE,
                CitrusWoodModBlocks.POTTED_MOD_SAPLING,
                CitrusWoodModBlocks.MOD_STANDING_SIGN,
                CitrusWoodModBlocks.MOD_WALL_SIGN,
                CitrusWoodModBlocks.MOD_HANGING_SIGN,
                CitrusWoodModBlocks.MOD_WALL_HANGING_SIGN,
                CitrusWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        addDrop(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES, fruitedLeavesDrops(CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES, CitrusWoodModBlocks.MOD_SAPLING, SAPLING_DROP_CHANCE));
    }
    public void generateDogwoodWoodLootTables() {
        generateNaturalWoodBlockLootTables(
                DogwoodWoodModBlocks.MOD_LOG,
                DogwoodWoodModBlocks.MOD_WOOD,
                DogwoodWoodModBlocks.STRIPPED_MOD_LOG,
                DogwoodWoodModBlocks.STRIPPED_MOD_WOOD,
                DogwoodWoodModBlocks.MOD_PLANKS,
                DogwoodWoodModBlocks.MOD_STAIRS,
                DogwoodWoodModBlocks.MOD_SLAB,
                DogwoodWoodModBlocks.MOD_BUTTON,
                DogwoodWoodModBlocks.MOD_FENCE,
                DogwoodWoodModBlocks.MOD_FENCE_GATE,
                DogwoodWoodModBlocks.MOD_PRESSURE_PLATE,
                DogwoodWoodModBlocks.MOD_DOOR,
                DogwoodWoodModBlocks.MOD_TRAPDOOR,
                DogwoodWoodModBlocks.MOD_LEAVES,
                DogwoodWoodModBlocks.MOD_SAPLING,
                DogwoodWoodInitializer.MOD_SAPLING_DROP_CHANCE,
                DogwoodWoodModBlocks.POTTED_MOD_SAPLING,
                DogwoodWoodModBlocks.MOD_STANDING_SIGN,
                DogwoodWoodModBlocks.MOD_WALL_SIGN,
                DogwoodWoodModBlocks.MOD_HANGING_SIGN,
                DogwoodWoodModBlocks.MOD_WALL_HANGING_SIGN,
                DogwoodWoodModBlocks.MOD_SHELF
        );
    }
    public void generateKapokWoodLootTables() {
        generateNaturalWoodBlockLootTablesWithVanillaSapling(
                KapokWoodModBlocks.MOD_LOG,
                KapokWoodModBlocks.MOD_WOOD,
                KapokWoodModBlocks.STRIPPED_MOD_LOG,
                KapokWoodModBlocks.STRIPPED_MOD_WOOD,
                KapokWoodModBlocks.MOD_PLANKS,
                KapokWoodModBlocks.MOD_STAIRS,
                KapokWoodModBlocks.MOD_SLAB,
                KapokWoodModBlocks.MOD_BUTTON,
                KapokWoodModBlocks.MOD_FENCE,
                KapokWoodModBlocks.MOD_FENCE_GATE,
                KapokWoodModBlocks.MOD_PRESSURE_PLATE,
                KapokWoodModBlocks.MOD_DOOR,
                KapokWoodModBlocks.MOD_TRAPDOOR,
                KapokWoodModBlocks.MOD_LEAVES,
                Blocks.JUNGLE_SAPLING,
                KapokWoodInitializer.MOD_SAPLING_DROP_CHANCE,
                KapokWoodModBlocks.MOD_STANDING_SIGN,
                KapokWoodModBlocks.MOD_WALL_SIGN,
                KapokWoodModBlocks.MOD_HANGING_SIGN,
                KapokWoodModBlocks.MOD_WALL_HANGING_SIGN,
                KapokWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        addDrop(KapokWoodModBlocks.MOD_LEAVES, leavesDrops(KapokWoodModBlocks.MOD_LEAVES, Blocks.JUNGLE_SAPLING, KapokWoodInitializer.MOD_SAPLING_DROP_CHANCE));
    }
    public void generateMapleWoodLootTables() {
        generateNaturalWoodBlockLootTables(
                MapleWoodModBlocks.MOD_LOG,
                MapleWoodModBlocks.MOD_WOOD,
                MapleWoodModBlocks.STRIPPED_MOD_LOG,
                MapleWoodModBlocks.STRIPPED_MOD_WOOD,
                MapleWoodModBlocks.MOD_PLANKS,
                MapleWoodModBlocks.MOD_STAIRS,
                MapleWoodModBlocks.MOD_SLAB,
                MapleWoodModBlocks.MOD_BUTTON,
                MapleWoodModBlocks.MOD_FENCE,
                MapleWoodModBlocks.MOD_FENCE_GATE,
                MapleWoodModBlocks.MOD_PRESSURE_PLATE,
                MapleWoodModBlocks.MOD_DOOR,
                MapleWoodModBlocks.MOD_TRAPDOOR,
                MapleWoodModBlocks.MOD_LEAVES,
                MapleWoodModBlocks.MOD_SAPLING,
                MapleWoodInitializer.MOD_SAPLING_DROP_CHANCE,
                MapleWoodModBlocks.POTTED_MOD_SAPLING,
                MapleWoodModBlocks.MOD_STANDING_SIGN,
                MapleWoodModBlocks.MOD_WALL_SIGN,
                MapleWoodModBlocks.MOD_HANGING_SIGN,
                MapleWoodModBlocks.MOD_WALL_HANGING_SIGN,
                MapleWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        addDrop(MapleWoodModBlocks.MIXED_MAPLE_LEAVES, leavesDrops(MapleWoodModBlocks.MIXED_MAPLE_LEAVES, MapleWoodModBlocks.MOD_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(MapleWoodModBlocks.RED_MAPLE_LEAVES, leavesDrops(MapleWoodModBlocks.RED_MAPLE_LEAVES, MapleWoodModBlocks.MOD_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES, leavesDrops(MapleWoodModBlocks.YELLOW_MAPLE_LEAVES, MapleWoodModBlocks.MOD_SAPLING, SAPLING_DROP_CHANCE));
    }
    public void generatePineWoodLootTables() {
        generateNaturalWoodBlockLootTables(
                PineWoodModBlocks.MOD_LOG,
                PineWoodModBlocks.MOD_WOOD,
                PineWoodModBlocks.STRIPPED_MOD_LOG,
                PineWoodModBlocks.STRIPPED_MOD_WOOD,
                PineWoodModBlocks.MOD_PLANKS,
                PineWoodModBlocks.MOD_STAIRS,
                PineWoodModBlocks.MOD_SLAB,
                PineWoodModBlocks.MOD_BUTTON,
                PineWoodModBlocks.MOD_FENCE,
                PineWoodModBlocks.MOD_FENCE_GATE,
                PineWoodModBlocks.MOD_PRESSURE_PLATE,
                PineWoodModBlocks.MOD_DOOR,
                PineWoodModBlocks.MOD_TRAPDOOR,
                PineWoodModBlocks.MOD_LEAVES,
                PineWoodModBlocks.MOD_SAPLING,
                PineWoodInitializer.MOD_SAPLING_DROP_CHANCE,
                PineWoodModBlocks.POTTED_MOD_SAPLING,
                PineWoodModBlocks.MOD_STANDING_SIGN,
                PineWoodModBlocks.MOD_WALL_SIGN,
                PineWoodModBlocks.MOD_HANGING_SIGN,
                PineWoodModBlocks.MOD_WALL_HANGING_SIGN,
                PineWoodModBlocks.MOD_SHELF
        );

        /* ADDITIONAL BLOCKS */
        addDrop(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, leavesDrops(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, Blocks.SPRUCE_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(PineWoodModBlocks.SNOWY_PINE_LEAVES, leavesDrops(PineWoodModBlocks.SNOWY_PINE_LEAVES, PineWoodModBlocks.SNOWY_PINE_SAPLING, PineWoodInitializer.MOD_SAPLING_DROP_CHANCE));
        addDrop(PineWoodModBlocks.SNOWY_SPRUCE_LEAVES, leavesDrops(PineWoodModBlocks.SNOWY_SPRUCE_LEAVES, PineWoodModBlocks.SNOWY_SPRUCE_SAPLING, SAPLING_DROP_CHANCE));
        addDrop(PineWoodModBlocks.SNOWY_PINE_SAPLING);
        addPottedPlantDrops(PineWoodModBlocks.POTTED_SNOWY_PINE_SAPLING);
        addDrop(PineWoodModBlocks.SNOWY_SPRUCE_SAPLING);
        addPottedPlantDrops(PineWoodModBlocks.POTTED_SNOWY_SPRUCE_SAPLING);
    }
    public void generateWillowWoodLootTables() {
        generateNaturalWoodBlockLootTables(
                WillowWoodModBlocks.MOD_LOG,
                WillowWoodModBlocks.MOD_WOOD,
                WillowWoodModBlocks.STRIPPED_MOD_LOG,
                WillowWoodModBlocks.STRIPPED_MOD_WOOD,
                WillowWoodModBlocks.MOD_PLANKS,
                WillowWoodModBlocks.MOD_STAIRS,
                WillowWoodModBlocks.MOD_SLAB,
                WillowWoodModBlocks.MOD_BUTTON,
                WillowWoodModBlocks.MOD_FENCE,
                WillowWoodModBlocks.MOD_FENCE_GATE,
                WillowWoodModBlocks.MOD_PRESSURE_PLATE,
                WillowWoodModBlocks.MOD_DOOR,
                WillowWoodModBlocks.MOD_TRAPDOOR,
                WillowWoodModBlocks.MOD_LEAVES,
                WillowWoodModBlocks.MOD_SAPLING,
                WillowWoodInitializer.MOD_SAPLING_DROP_CHANCE,
                WillowWoodModBlocks.POTTED_MOD_SAPLING,
                WillowWoodModBlocks.MOD_STANDING_SIGN,
                WillowWoodModBlocks.MOD_WALL_SIGN,
                WillowWoodModBlocks.MOD_HANGING_SIGN,
                WillowWoodModBlocks.MOD_WALL_HANGING_SIGN,
                WillowWoodModBlocks.MOD_SHELF
        );
    }

    public void generatePetrifiedWoodLootTables() {
        addDrop(PetrifiedWoodModBlocks.MOD_LOG);
        addDrop(PetrifiedWoodModBlocks.MOD_WOOD);
        addDrop(PetrifiedWoodModBlocks.STRIPPED_MOD_LOG);
        addDrop(PetrifiedWoodModBlocks.STRIPPED_MOD_WOOD);
        addDrop(PetrifiedWoodModBlocks.MOD_PLANKS);
        addDrop(PetrifiedWoodModBlocks.MOD_STAIRS);
        addDrop(PetrifiedWoodModBlocks.MOD_BUTTON);
        addDrop(PetrifiedWoodModBlocks.MOD_FENCE);
        addDrop(PetrifiedWoodModBlocks.MOD_FENCE_GATE);
        addDrop(PetrifiedWoodModBlocks.MOD_PRESSURE_PLATE);
        addDrop(PetrifiedWoodModBlocks.MOD_TRAPDOOR);
        addDrop(PetrifiedWoodModBlocks.MOD_DOOR, doorDrops(PetrifiedWoodModBlocks.MOD_DOOR));
        addDrop(PetrifiedWoodModBlocks.MOD_SLAB, slabDrops(PetrifiedWoodModBlocks.MOD_SLAB));
        addDrop(PetrifiedWoodModBlocks.MOD_STANDING_SIGN);
        addDrop(PetrifiedWoodModBlocks.MOD_WALL_SIGN);
        addDrop(PetrifiedWoodModBlocks.MOD_HANGING_SIGN);
        addDrop(PetrifiedWoodModBlocks.MOD_WALL_HANGING_SIGN);
        addDrop(PetrifiedWoodModBlocks.MOD_SHELF);
    }

    public <T extends Comparable<T> & StringIdentifiable> LootTable.Builder trunkAttachedMushroomBlockDrops(Block attachedMushroom, Block mushroomItem) {
        return LootTable.builder().pool(
                LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(mushroomItem)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3))
                                    .conditionally(BlockStatePropertyLootCondition.builder(attachedMushroom).properties(StatePredicate.Builder.create().exactMatch(ModProperties.MUSHROOMS, 3))))
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2))
                                    .conditionally(BlockStatePropertyLootCondition.builder(attachedMushroom).properties(StatePredicate.Builder.create().exactMatch(ModProperties.MUSHROOMS, 2))))
                                .apply(ExplosionDecayLootFunction.builder())
                        )
        );
    }

    public LootTable.Builder fruitedLeavesDrops(Block leaves, Block sapling, float... saplingChance) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.leavesDrops(leaves, sapling, saplingChance)
                .pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1.0F))
                                .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                                .with(
                                        ((LeafEntry.Builder)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(ModItems.ORANGE)
                                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F)))
                                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                                                .conditionally(BlockStatePropertyLootCondition.builder(leaves).properties(StatePredicate.Builder.create().exactMatch(FloweringOrangeLeavesBlock.AGE, 3)))
                                        ))
                                )
                );
    }

    public LootTable.Builder smallCactusDrops(Block withShears, ItemConvertible withoutShears) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithShears(
                withShears,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        withShears, ItemEntry.builder(withoutShears)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    public LootTable.Builder wildCropDrops(Block withShears, Item crop) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithShears(
                withShears,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        withShears,
                        ItemEntry.builder(crop)
                                .conditionally(RandomChanceLootCondition.builder(0.125F))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 2))
                )
        );
    }

    @Override
    public void generate() {
        generateAzaleaWoodLootTables();
        generateBaobabWoodLootTables();
        generateCacaoWoodLootTables();
        generateChollaWoodLootTables();
        generateChorusWoodLootTables();
        generateCitrusWoodLootTables();
        generateDogwoodWoodLootTables();
        generateKapokWoodLootTables();
        generateMapleWoodLootTables();
        generatePetrifiedWoodLootTables();
        generatePineWoodLootTables();
        generateWillowWoodLootTables();

        addDrop(ModBlocks.QUEEN_ANNES_LACE,  (block) -> wildCropDrops(block, Items.CARROT));
        addDrop(ModBlocks.SEA_BEET, (block) -> wildCropDrops(block, Items.BEETROOT_SEEDS));
        addDrop(ModBlocks.TUBERED_DIRT, block -> this.oreDrops(block, Items.POTATO));

        addDrop(ModBuildingBlocks.MOSSY_BRICKS);
        addDrop(ModBuildingBlocks.MOSSY_BRICK_STAIRS);
        addDrop(ModBuildingBlocks.MOSSY_BRICK_SLAB, slabDrops(ModBuildingBlocks.MOSSY_BRICK_SLAB));
        addDrop(ModBuildingBlocks.MOSSY_BRICK_WALL);

        addDrop(ModBuildingBlocks.MOSSY_TUFF_BRICKS);
        addDrop(ModBuildingBlocks.MOSSY_TUFF_BRICK_STAIRS);
        addDrop(ModBuildingBlocks.MOSSY_TUFF_BRICK_SLAB, slabDrops(ModBuildingBlocks.MOSSY_TUFF_BRICK_SLAB));
        addDrop(ModBuildingBlocks.MOSSY_TUFF_BRICK_WALL);

        addDrop(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICKS);
        addDrop(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS);
        addDrop(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_SLAB, slabDrops(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_SLAB));
        addDrop(ModBuildingBlocks.MOSSY_DEEPSLATE_BRICK_WALL);

        addDrop(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE);
        addDrop(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS);
        addDrop(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB, slabDrops(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB));
        addDrop(ModBuildingBlocks.MOSSY_COBBLED_DEEPSLATE_WALL);

        addDrop(ModBuildingBlocks.SMOOTH_DEEPSLATE);
        addDrop(ModBuildingBlocks.SMOOTH_DEEPSLATE_SLAB, slabDrops(ModBuildingBlocks.SMOOTH_DEEPSLATE_SLAB));

        addDrop(ModBuildingBlocks.PACKED_SNOW);
        addDrop(ModBuildingBlocks.SNOW_BRICKS);
        addDrop(ModBuildingBlocks.CHISELED_SNOW_BRICKS);
        addDrop(ModBuildingBlocks.SNOW_BRICK_STAIRS);
        addDrop(ModBuildingBlocks.SNOW_BRICK_SLAB, slabDrops(ModBuildingBlocks.SNOW_BRICK_SLAB));
        addDrop(ModBuildingBlocks.SNOW_BRICK_WALL);

        addDrop(ModBuildingBlocks.POLISHED_ANDESITE_WALL);
        addDrop(ModBuildingBlocks.POLISHED_DIORITE_WALL);
        addDrop(ModBuildingBlocks.POLISHED_GRANITE_WALL);

        addDrop(ModFloraBlocks.TRUNK_ATTACHED_BROWN_MUSHROOM, trunkAttachedMushroomBlockDrops(ModFloraBlocks.TRUNK_ATTACHED_BROWN_MUSHROOM, Blocks.BROWN_MUSHROOM));

        addDrop(ModBlocks.LOOSE_DIRT);

        addDrop(ModFloraBlocks.CLOVER, this.segmentedDrops(ModFloraBlocks.CLOVER));
        addDrop(ModFloraBlocks.VIOLET, this.segmentedDrops(ModFloraBlocks.VIOLET));
        addDrop(ModFloraBlocks.FORGET_ME_NOT, this.segmentedDrops(ModFloraBlocks.FORGET_ME_NOT));

        addDrop(ModFloraBlocks.YELLOW_TULIP);
        addPottedPlantDrops(ModFloraBlocks.POTTED_YELLOW_TULIP);
        addDrop(ModFloraBlocks.PURPLE_TULIP);
        addPottedPlantDrops(ModFloraBlocks.POTTED_PURPLE_TULIP);
        addDrop(ModFloraBlocks.HELLEBORE);
        addPottedPlantDrops(ModFloraBlocks.POTTED_HELLEBORE);

        addDrop(ModFloraBlocks.GIANT_PADMA);
        addDrop(ModFloraBlocks.MONSTERA, block -> this.dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));

        addPottedPlantDrops(ModFloraBlocks.POTTED_CACTUS_FLOWER);
        addPottedPlantDrops(ModFloraBlocks.POTTED_ROSE);
        addPottedPlantDrops(ModFloraBlocks.POTTED_PEONY);
        addPottedPlantDrops(ModFloraBlocks.POTTED_LILAC);
        addPottedPlantDrops(ModFloraBlocks.POTTED_SUGAR_CANE);
        addPottedPlantDrops(ModFloraBlocks.POTTED_SUNFLOWER);
        addPottedPlantDrops(ModFloraBlocks.POTTED_MONSTERA);

        addDrop(ModFloraBlocks.WHITE_WATER_LILY);
        addDrop(ModFloraBlocks.BLUE_WATER_LILY);
        addDrop(ModFloraBlocks.PINK_WATER_LILY);
        addDrop(ModFloraBlocks.PURPLE_WATER_LILY);

        addDrop(ModPumpkinBlocks.WHITE_PUMPKIN);
        addDrop(ModPumpkinBlocks.CARVED_WHITE_PUMPKIN);
        addDrop(ModPumpkinBlocks.WHITE_JACK_O_LANTERN);
        addDrop(ModPumpkinBlocks.SOUL_JACK_O_LANTERN);
        addDrop(ModPumpkinBlocks.WHITE_PUMPKIN_STEM, cropStemDrops(ModPumpkinBlocks.WHITE_PUMPKIN_STEM, ModItems.WHITE_PUMPKIN_SEEDS));
        addDrop(ModPumpkinBlocks.ATTACHED_WHITE_PUMPKIN_STEM, attachedCropStemDrops(ModPumpkinBlocks.ATTACHED_WHITE_PUMPKIN_STEM, ModItems.WHITE_PUMPKIN_SEEDS));
        addDrop(ModPumpkinBlocks.GREEN_PUMPKIN);
        addDrop(ModPumpkinBlocks.CARVED_GREEN_PUMPKIN);
        addDrop(ModPumpkinBlocks.GREEN_JACK_O_LANTERN);
        addDrop(ModPumpkinBlocks.GREEN_PUMPKIN_STEM, cropStemDrops(ModPumpkinBlocks.GREEN_PUMPKIN_STEM, ModItems.GREEN_PUMPKIN_SEEDS));
        addDrop(ModPumpkinBlocks.ATTACHED_GREEN_PUMPKIN_STEM, attachedCropStemDrops(ModPumpkinBlocks.ATTACHED_GREEN_PUMPKIN_STEM, ModItems.GREEN_PUMPKIN_SEEDS));

        addDrop(ModFloraBlocks.SNOWY_FERN, this::shortPlantDrops);
        addDrop(ModFloraBlocks.SNOWY_SHORT_GRASS, this::shortPlantDrops);
        addDrop(ModFloraBlocks.SNOWY_BUSH, this::dropsWithSilkTouchOrShears);
        addPottedPlantDrops(ModFloraBlocks.POTTED_SNOWY_FERN);

        addDrop(ModFloraBlocks.SMALL_CACTUS, block -> this.smallCactusDrops(block, ModItems.CACTUS_PAD));
        addPottedPlantDrops(ModFloraBlocks.POTTED_SMALL_CACTUS);

    }
}
