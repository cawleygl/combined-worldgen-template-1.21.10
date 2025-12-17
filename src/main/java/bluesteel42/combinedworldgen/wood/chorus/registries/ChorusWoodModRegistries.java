package bluesteel42.combinedworldgen.wood.chorus.registries;

import bluesteel42.combinedworldgen.wood.chorus.block.ChorusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.chorus.entity.ChorusWoodModRafts;
import bluesteel42.combinedworldgen.wood.chorus.util.ChorusWoodModTags;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ChorusWoodModRegistries {

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ChorusWoodModBlocks.MOD_BLOCK, ChorusWoodModBlocks.STRIPPED_MOD_BLOCK);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.MOD_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.STRIPPED_MOD_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.MOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.MOD_MOSAIC, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.MOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.MOD_MOSAIC_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.MOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.MOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.MOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChorusWoodModBlocks.MOD_MOSAIC_STAIRS, 5, 20);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ChorusWoodModRafts.MOD_RAFT, 1),
                            new ItemStack(Items.EMERALD, 1),
                            12,  30, 0.05f));
                });
    }

    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ChorusWoodModTags.Items.MOD_BLOCKS, 300);
            builder.add(ChorusWoodModBlocks.MOD_MOSAIC, 300);
            builder.add(ChorusWoodModBlocks.MOD_MOSAIC_SLAB, 150);
            builder.add(ChorusWoodModBlocks.MOD_MOSAIC_STAIRS, 300);
        });
    }
}
