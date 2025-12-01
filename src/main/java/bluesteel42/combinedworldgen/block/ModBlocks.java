package bluesteel42.combinedworldgen.block;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.block.building.ModBuildingBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModBlocks {

    /* ORE DIRT */
    public static final Block LOOSE_DIRT = register("loose_dirt", settings -> new LooseDirtBlock(new ColorCode(9858122), Blocks.MUD, settings), AbstractBlock.Settings.copy(Blocks.DIRT), true, false);

    /* CROP SPAWNS */
    public static final Block TUBERED_DIRT = register(
            "tubered_dirt", AbstractBlock.Settings.create().mapColor(MapColor.DIRT_BROWN).strength(0.5F).sounds(BlockSoundGroup.ROOTED_DIRT)
    );
    public static final Block QUEEN_ANNES_LACE = register(
            "queen_annes_lace",
            QueenAnnesLaceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block SEA_BEET = register(
            "sea_beet",
            SeaBeetBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .replaceable()
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XYZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );

    private static Block register(String id, AbstractBlock.Settings settings) {
        return register(id, Block::new, settings, true, false);
    }

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(id, factory, settings, true, false);
    }

    public static Block register(
            String path,
            Function<AbstractBlock.Settings, Block> factory,
            AbstractBlock.Settings settings,
            boolean registerItem,
            boolean nonOpaqueBlock
    ) {
        final Identifier identifier = Identifier.of(CombinedWorldgen.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);

        if (registerItem) {
            Items.register(block);
        }

        if (nonOpaqueBlock) {
            BlockRenderLayerMap.putBlock(block, BlockRenderLayer.CUTOUT);
        }

        if (block instanceof SignBlock || block instanceof WallSignBlock) {
            BlockEntityType.SIGN.addSupportedBlock(block);
        } else if (block instanceof HangingSignBlock || block instanceof WallHangingSignBlock) {
            BlockEntityType.HANGING_SIGN.addSupportedBlock(block);
        } else if (block instanceof ShelfBlock) {
            BlockEntityType.SHELF.addSupportedBlock(block);
        }

        return block;
    }

    public static void initialize() {
        ModBuildingBlocks.initialize();
        ModFloraBlocks.initialize();
        ModPumpkinBlocks.initialize();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.COARSE_DIRT, ModBlocks.LOOSE_DIRT);
                    itemGroup.addAfter(Items.ROOTED_DIRT, ModBlocks.TUBERED_DIRT);
                    itemGroup.addAfter(Items.DEAD_BUSH, ModBlocks.QUEEN_ANNES_LACE);
                    itemGroup.addAfter(Items.DEAD_BUSH, ModBlocks.SEA_BEET);
                });
    }
}
