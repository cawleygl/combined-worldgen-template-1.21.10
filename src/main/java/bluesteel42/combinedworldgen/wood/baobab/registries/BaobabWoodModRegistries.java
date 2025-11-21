package bluesteel42.combinedworldgen.wood.baobab.registries;

import bluesteel42.combinedworldgen.wood.baobab.block.BaobabWoodModBlocks;
import bluesteel42.combinedworldgen.wood.baobab.entity.BaobabWoodModBoats;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class BaobabWoodModRegistries {

    public static void registerStrippables() {
        StrippableBlockRegistry.register(BaobabWoodModBlocks.MOD_WOOD, BaobabWoodModBlocks.STRIPPED_MOD_WOOD);
        StrippableBlockRegistry.register(BaobabWoodModBlocks.MOD_LOG, BaobabWoodModBlocks.STRIPPED_MOD_LOG);
    }

    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(BaobabWoodModBlocks.MOD_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(BaobabWoodModBlocks.MOD_SAPLING, 0.3F);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.MOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.MOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.STRIPPED_MOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.STRIPPED_MOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.MOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.MOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.MOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.MOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.MOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(BaobabWoodModBlocks.MOD_LEAVES, 30, 60);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
                (entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 5),
                    new ItemStack(BaobabWoodModBlocks.MOD_SAPLING.asItem(), 1),
                    8,  1, 5)
            );
        });

        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL,
                (entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(BaobabWoodModBlocks.MOD_LOG.asItem(), 8),
                    4,  1, 1)
            );
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(BaobabWoodModBoats.MOD_BOAT, 1),
                            new ItemStack(Items.EMERALD, 1),
                            12,  30, 0.05f));
                });
    }
}
