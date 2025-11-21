package bluesteel42.combinedworldgen.wood.willow.registries;

import bluesteel42.combinedworldgen.wood.willow.block.WillowWoodModBlocks;
import bluesteel42.combinedworldgen.wood.willow.entity.WillowWoodModBoats;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class WillowWoodModRegistries {

    public static void registerStrippables() {
        StrippableBlockRegistry.register(WillowWoodModBlocks.MOD_WOOD, WillowWoodModBlocks.STRIPPED_MOD_WOOD);
        StrippableBlockRegistry.register(WillowWoodModBlocks.MOD_LOG, WillowWoodModBlocks.STRIPPED_MOD_LOG);
    }

    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(WillowWoodModBlocks.MOD_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(WillowWoodModBlocks.MOD_SAPLING, 0.3F);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.MOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.MOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.STRIPPED_MOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.STRIPPED_MOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.MOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.MOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.MOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.MOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.MOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(WillowWoodModBlocks.MOD_LEAVES, 30, 60);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
                (entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 5),
                    new ItemStack(WillowWoodModBlocks.MOD_SAPLING.asItem(), 1),
                    8,  1, 5)
            );
        });

        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL,
                (entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(WillowWoodModBlocks.MOD_LOG.asItem(), 8),
                    4,  1, 1)
            );
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(WillowWoodModBoats.MOD_BOAT, 1),
                            new ItemStack(Items.EMERALD, 1),
                            12,  30, 0.05f));
                });
    }
}
