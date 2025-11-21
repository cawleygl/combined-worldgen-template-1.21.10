package bluesteel42.combinedworldgen.wood.azalea.registries;

import bluesteel42.combinedworldgen.wood.azalea.block.AzaleaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.azalea.entity.AzaleaWoodModRafts;
import bluesteel42.combinedworldgen.wood.azalea.util.AzaleaWoodModTags;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class AzaleaWoodModRegistries {

    public static void registerStrippables() {
        StrippableBlockRegistry.register(AzaleaWoodModBlocks.MOD_BLOCK, AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK);

        /* ADDITIONAL BLOCKS */
        StrippableBlockRegistry.register(AzaleaWoodModBlocks.AZALEA_STEM, AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM);
        StrippableBlockRegistry.register(AzaleaWoodModBlocks.LEAFY_AZALEA_STEM, AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.MOD_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.STRIPPED_MOD_BLOCK, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.MOD_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.MOD_MOSAIC, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.MOD_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.MOD_MOSAIC_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.MOD_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.MOD_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.MOD_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.MOD_MOSAIC_STAIRS, 5, 20);

        /* ADDITIONAL BLOCKS */
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.AZALEA_STEM, 60, 60);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.LEAFY_AZALEA_STEM, 60, 60);
        FlammableBlockRegistry.getDefaultInstance().add(AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM, 60, 60);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(AzaleaWoodModRafts.MOD_RAFT, 1),
                            new ItemStack(Items.EMERALD, 1),
                            12,  30, 0.05f));
                });
    }

    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(AzaleaWoodModTags.Items.MOD_BLOCKS, 300);
            builder.add(AzaleaWoodModBlocks.MOD_MOSAIC, 300);
            builder.add(AzaleaWoodModBlocks.MOD_MOSAIC_SLAB, 150);
            builder.add(AzaleaWoodModBlocks.MOD_MOSAIC_STAIRS, 300);

            /* ADDITIONAL BLOCKS */
            builder.add(AzaleaWoodModBlocks.AZALEA_STEM, 50);
            builder.add(AzaleaWoodModBlocks.LEAFY_AZALEA_STEM, 50);
            builder.add(AzaleaWoodModBlocks.STRIPPED_AZALEA_STEM, 50);
        });
    }
}
