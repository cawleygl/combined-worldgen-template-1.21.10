package bluesteel42.combinedworldgen.wood.cholla.registries;

import bluesteel42.combinedworldgen.wood.cholla.block.ChollaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.cholla.entity.ChollaWoodModRafts;
import bluesteel42.combinedworldgen.wood.cholla.util.ChollaWoodModTags;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ChollaWoodModRegistries {

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ChollaWoodModBlocks.MOD_BLOCK, ChollaWoodModBlocks.STRIPPED_MOD_BLOCK);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.MOD_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.STRIPPED_MOD_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.MOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.MOD_MOSAIC, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.MOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.MOD_MOSAIC_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.MOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.MOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.MOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.MOD_MOSAIC_STAIRS, 5, 20);
        /* ADDITIONAL BLOCKS */
        FlammableBlockRegistry.getDefaultInstance().add(ChollaWoodModBlocks.DRIED_CHOLLA, 60, 60);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ChollaWoodModRafts.MOD_RAFT, 1),
                            new ItemStack(Items.EMERALD, 1),
                            12,  30, 0.05f));
                });
    }

    /* ADDITIONAL BLOCKS */
    public static void registerFuels() {
        // Set Dried Cholla and Cholla Blocks as a fuel (Other blocks added through tags)
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ChollaWoodModTags.Items.MOD_BLOCKS, 300);
            builder.add(ChollaWoodModBlocks.MOD_MOSAIC, 300);
            builder.add(ChollaWoodModBlocks.MOD_MOSAIC_SLAB, 150);
            builder.add(ChollaWoodModBlocks.MOD_MOSAIC_STAIRS, 300);

            /* ADDITIONAL BLOCKS*/
            builder.add(ChollaWoodModBlocks.DRIED_CHOLLA, 50);
        });
    }
}
