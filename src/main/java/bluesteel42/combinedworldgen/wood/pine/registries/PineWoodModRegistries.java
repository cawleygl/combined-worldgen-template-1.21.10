package bluesteel42.combinedworldgen.wood.pine.registries;

import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import bluesteel42.combinedworldgen.wood.pine.entity.PineWoodModBoats;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class PineWoodModRegistries {

    public static void registerStrippables() {
        StrippableBlockRegistry.register(PineWoodModBlocks.MOD_WOOD, PineWoodModBlocks.STRIPPED_MOD_WOOD);
        StrippableBlockRegistry.register(PineWoodModBlocks.MOD_LOG, PineWoodModBlocks.STRIPPED_MOD_LOG);
    }

    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(PineWoodModBlocks.MOD_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(PineWoodModBlocks.MOD_SAPLING, 0.3F);

        /* ADDITIONAL BLOCKS */
        CompostingChanceRegistry.INSTANCE.add(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(PineWoodModBlocks.SNOWY_PINE_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(PineWoodModBlocks.SNOWY_SPRUCE_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(PineWoodModBlocks.SNOWY_PINE_SAPLING, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(PineWoodModBlocks.SNOWY_SPRUCE_SAPLING, 0.3F);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.MOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.MOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.STRIPPED_MOD_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.STRIPPED_MOD_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.MOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.MOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.MOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.MOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.MOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.MOD_LEAVES, 30, 60);

        /* ADDITIONAL BLOCKS */
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.SNOWY_PINE_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(PineWoodModBlocks.SNOWY_SPRUCE_LEAVES, 30, 60);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
                (entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 5),
                    new ItemStack(PineWoodModBlocks.MOD_SAPLING.asItem(), 1),
                    8,  1, 5)
            );
        });

        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL,
                (entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(PineWoodModBlocks.MOD_LOG.asItem(), 8),
                    4,  1, 1)
            );
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(PineWoodModBoats.MOD_BOAT, 1),
                            new ItemStack(Items.EMERALD, 1),
                            12,  30, 0.05f));
                });

        /* ADDITIONAL BLOCKS */
        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
                    (entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 5),
                            new ItemStack(PineWoodModBlocks.SNOWY_PINE_SAPLING.asItem(), 1),
                            8, 1, 5)
            );
        });

        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
                    (entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 5),
                            new ItemStack(PineWoodModBlocks.SNOWY_SPRUCE_SAPLING.asItem(), 1),
                            8, 1, 5)
            );
        });

    }
}
