package bluesteel42.combinedworldgen.block;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.block.building.ModBuildingBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.particle.SimpleParticleType;
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

    public static Block registerLog(String woodName, MapColor fiberColor, MapColor barkColor, BlockSoundGroup blockSounds) {
        return registerPillarBlock(woodName + "_log", fiberColor, barkColor, blockSounds);
    }
    public static Block registerCombinedBlock(String woodName, MapColor strippedColor, MapColor unstrippedColor, BlockSoundGroup blockSounds) {
        return registerPillarBlock(woodName + "_block", strippedColor, unstrippedColor, blockSounds);
    }
    public static Block registerWood(String woodName, MapColor barkColor, BlockSoundGroup blockSounds) {
        return registerPillarBlock(woodName + "_wood", barkColor, barkColor, blockSounds);
    }
    public static Block registerStrippedLog(String woodName, MapColor fiberColor, BlockSoundGroup blockSounds) {
        return registerPillarBlock("stripped_" + woodName + "_log", fiberColor, fiberColor, blockSounds);
    }
    public static Block registerStrippedCombinedBlock(String woodName, MapColor strippedColor, BlockSoundGroup blockSounds) {
        return registerPillarBlock("stripped_" + woodName + "_block", strippedColor, strippedColor, blockSounds);
    }
    public static Block registerStrippedWood(String woodName, MapColor fiberColor, BlockSoundGroup blockSounds) {
        return registerPillarBlock("stripped_" + woodName + "_wood", fiberColor, fiberColor, blockSounds);
    }
    private static Block registerPillarBlock(String blockName, MapColor topColor, MapColor sideColor, BlockSoundGroup blockSounds) {
        return register(blockName, PillarBlock::new, Blocks.createLogSettings(topColor, sideColor, blockSounds));
    }
    private static AbstractBlock.Settings getPlanksSettings(MapColor fiberColor, BlockSoundGroup blockSounds) {
        return AbstractBlock.Settings.create().mapColor(fiberColor).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(blockSounds).burnable();
    }
    public static Block registerPlanks(String woodName, MapColor fiberColor, BlockSoundGroup blockSounds) {
        return register(woodName + "_planks", getPlanksSettings(fiberColor, blockSounds));
    }
    public static Block registerMosaic(String woodName, MapColor fiberColor, BlockSoundGroup blockSounds) {
        return register(woodName + "_mosaic", getPlanksSettings(fiberColor, blockSounds));
    }
    public static Block registerStairs(String woodName, Block planks) {
        return register(woodName + "_stairs", settings -> new StairsBlock(planks.getDefaultState(), settings), AbstractBlock.Settings.copy(planks));
    }
    public static Block registerMosaicStairs(String woodName, Block planks) {
        return registerStairs(woodName + "_mosaic", planks);
    }
    public static Block registerSlab(String woodName, MapColor fiberColor, BlockSoundGroup blockSounds) {
        return register(woodName + "_slab", SlabBlock::new, AbstractBlock.Settings.create().mapColor(fiberColor).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(blockSounds).burnable());
    }
    public static Block registerMosaicSlab(String woodName, MapColor fiberColor, BlockSoundGroup blockSounds) {
        return registerSlab(woodName + "_mosaic", fiberColor, blockSounds);
    }
    public static Block registerButton(String woodName, BlockSetType blockSet) {
        return register(woodName + "_button", settings -> new ButtonBlock(blockSet, 30, settings), AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY));
    }
    public static Block registerPressurePlate(String woodName, MapColor fiberColor, BlockSetType blockSet) {
        return register(woodName + "_pressure_plate", settings -> new PressurePlateBlock(blockSet, settings), AbstractBlock.Settings.create().mapColor(fiberColor).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY));
    }
    public static Block registerFence(String woodName, MapColor fiberColor, BlockSoundGroup blockSounds) {
        return register(woodName + "_fence", FenceBlock::new, AbstractBlock.Settings.create().mapColor(fiberColor).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(blockSounds).burnable());
    }
    public static Block registerFenceGate(String woodName, WoodType woodType, MapColor fiberColor) {
        return register(woodName + "_fence_gate", settings -> new FenceGateBlock(woodType, settings), AbstractBlock.Settings.create().mapColor(fiberColor).solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).burnable());
    }
    public static Block registerDoor(String woodName, MapColor fiberColor, BlockSetType blockSet) {
        return register(woodName + "_door", settings -> new DoorBlock(blockSet, settings), AbstractBlock.Settings.create().mapColor(fiberColor).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY), true, true);
    }
    public static Block registerTrapdoor(String woodName, MapColor fiberColor, BlockSetType blockSet) {
        return register(woodName + "_trapdoor", settings -> new TrapdoorBlock(blockSet, settings), AbstractBlock.Settings.create().mapColor(fiberColor).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable(), true, true);
    }
    private static AbstractBlock.Settings getSignSettings(MapColor fiberColor) {
        return AbstractBlock.Settings.create().mapColor(fiberColor).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(1.0F).burnable();
    }
    public static Block registerStandingSign(String woodName, MapColor fiberColor, WoodType woodType) {
        return register(woodName + "_sign", settings -> new SignBlock(woodType, settings), getSignSettings(fiberColor), false, false);
    }
    public static Block registerWallSign(String woodName, MapColor fiberColor, WoodType woodType, Block standingSign) {
        return register(woodName + "_wall_sign", settings -> new WallSignBlock(woodType, settings), getSignSettings(fiberColor).lootTable(standingSign.getLootTableKey()).overrideTranslationKey(standingSign.getTranslationKey()), false, false);
    }
    public static Block registerHangingSign(String woodName, MapColor fiberColor, WoodType woodType) {
        return register(woodName + "_hanging_sign", settings -> new HangingSignBlock(woodType, settings), getSignSettings(fiberColor), false, false);
    }
    public static Block registerWallHangingSign(String woodName, MapColor fiberColor, WoodType woodType, Block hangingSign) {
        return register(woodName + "_wall_hanging_sign", settings -> new WallHangingSignBlock(woodType, settings), getSignSettings(fiberColor).lootTable(hangingSign.getLootTableKey()).overrideTranslationKey(hangingSign.getTranslationKey()), false, false);
    }
    public static Block registerShelf(String woodName, MapColor fiberColor) {
        return register(woodName + "_shelf", ShelfBlock::new, AbstractBlock.Settings.create().mapColor(fiberColor).instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.SHELF).burnable().strength(2.0F, 3.0F));
    }
    public static BlockFamily registerNaturalBlockFamily(Block planks, Block button, Block door, Block fence, Block fenceGate, Block standingSign, Block wallSign, Block slab, Block stairs, Block pressurePlate, Block trapdoor) {
        return BlockFamilies.register(planks).button(button).door(door).fence(fence).fenceGate(fenceGate).sign(standingSign, wallSign).slab(slab).stairs(stairs).pressurePlate(pressurePlate).trapdoor(trapdoor).group("wooden").unlockCriterionName("has_planks").build();
    }
    public static BlockFamily registerCombinedBlockFamily(Block planks, Block button, Block mosaic, Block door, Block customFence, Block customFenceGate, Block standingSign, Block wallSign, Block slab, Block stairs, Block pressurePlate, Block trapdoor) {
        return BlockFamilies.register(planks).button(button).mosaic(mosaic).door(door).customFence(customFence).customFenceGate(customFenceGate).sign(standingSign, wallSign).slab(slab).stairs(stairs).pressurePlate(pressurePlate).trapdoor(trapdoor).group("wooden").unlockCriterionName("has_planks").build();
    }
    private static AbstractBlock.Settings getLeavesSettings(MapColor leafColor, BlockSoundGroup leafSounds) {
        return AbstractBlock.Settings.create().mapColor(leafColor).strength(0.2F).ticksRandomly().sounds(leafSounds).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never);
    }
    public static Block registerTintedLeaves(String woodName, MapColor leafColor, BlockSoundGroup leafSounds) {
        return register(woodName + "_leaves", settings -> new TintedParticleLeavesBlock(0.01F, settings), getLeavesSettings(leafColor, leafSounds), true, true);
    }
    public static Block registerUntintedLeaves(String woodName, MapColor leafColor, BlockSoundGroup leafSounds, SimpleParticleType particles) {
        return register(woodName + "_leaves", settings -> new UntintedParticleLeavesBlock(0.1F, particles, settings), getLeavesSettings(leafColor, leafSounds), true, true);
    }
    public static Block registerLeavesWithCustomParticles(String woodName, MapColor leafColor, BlockSoundGroup leafSounds, Function<AbstractBlock.Settings, Block> factory) {
        return register(woodName + "_leaves", factory, getLeavesSettings(leafColor, leafSounds), true, true);
    }
    public static Block registerSapling(String woodName, SaplingGenerator saplingGenerator, MapColor leafColor, BlockSoundGroup saplingSounds) {
        return register(woodName + "_sapling", settings -> new SaplingBlock(saplingGenerator, settings), AbstractBlock.Settings.create().mapColor(leafColor).noCollision().ticksRandomly().breakInstantly().sounds(saplingSounds).pistonBehavior(PistonBehavior.DESTROY), true, true);
    }
    public static Block registerCustomSapling(String woodName, Function<AbstractBlock.Settings, Block> factory, MapColor leafColor, BlockSoundGroup saplingSounds) {
        return register(woodName + "_sapling", factory, AbstractBlock.Settings.create().mapColor(leafColor).noCollision().ticksRandomly().breakInstantly().sounds(saplingSounds).pistonBehavior(PistonBehavior.DESTROY), true, true);
    }
    public static Block registerPottedSapling(String woodName, Block sapling) {
        return register("potted_" + woodName + "_sapling",settings -> new FlowerPotBlock(sapling, settings), Blocks.createFlowerPotSettings(), true, true);
    }

    public static Block register(String id, AbstractBlock.Settings settings) {
        return register(id, Block::new, settings, true, false);
    }
    public static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
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
