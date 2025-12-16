package bluesteel42.combinedworldgen.block.pumpkin;

import bluesteel42.combinedworldgen.block.*;
import bluesteel42.combinedworldgen.block.building.ModBuildingBlocks;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.item.ModItemKeys;
import bluesteel42.combinedworldgen.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;

public class ModPumpkinBlocks {
    public static final Block WHITE_PUMPKIN_STEM = ModBlocks.register(
            ModPumpkinBlockKeys.WHITE_PUMPKIN_STEM_PATH,
            settings -> new FertilizableStemBlock(ModPumpkinBlockKeys.WHITE_PUMPKIN_KEY, ModPumpkinBlockKeys.ATTACHED_WHITE_PUMPKIN_STEM_KEY, ModItemKeys.WHITE_PUMPKIN_SEEDS_KEY, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STEM)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block ATTACHED_WHITE_PUMPKIN_STEM = ModBlocks.register(
            ModPumpkinBlockKeys.ATTACHED_WHITE_PUMPKIN_STEM_PATH,
            settings -> new AttachedStemBlock(ModPumpkinBlockKeys.WHITE_PUMPKIN_STEM_KEY, ModPumpkinBlockKeys.WHITE_PUMPKIN_KEY, ModItemKeys.WHITE_PUMPKIN_SEEDS_KEY, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WOOD)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block WHITE_PUMPKIN = ModBlocks.register(
            ModPumpkinBlockKeys.WHITE_PUMPKIN_PATH,
            WhitePumpkinBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.OFF_WHITE)
                    .instrument(NoteBlockInstrument.DIDGERIDOO)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block CARVED_WHITE_PUMPKIN = ModBlocks.register(
            "carved_white_pumpkin",
            CarvedWhitePumpkinBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.OFF_WHITE)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .allowsSpawning(Blocks::always)
                    .pistonBehavior(PistonBehavior.DESTROY),
            false,
            false
    );
    public static final Block WHITE_JACK_O_LANTERN = ModBlocks.register(
            "white_jack_o_lantern",
            CarvedWhitePumpkinBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.OFF_WHITE)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .luminance(state -> 15)
                    .allowsSpawning(Blocks::always)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block SOUL_JACK_O_LANTERN = ModBlocks.register(
            "soul_jack_o_lantern",
            CarvedWhitePumpkinBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.OFF_WHITE)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .luminance(state -> 15)
                    .allowsSpawning(Blocks::always)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block GREEN_PUMPKIN_STEM = ModBlocks.register(
            ModPumpkinBlockKeys.GREEN_PUMPKIN_STEM_PATH,
            settings -> new FertilizableStemBlock(ModPumpkinBlockKeys.GREEN_PUMPKIN_KEY, ModPumpkinBlockKeys.ATTACHED_GREEN_PUMPKIN_STEM_KEY, ModItemKeys.GREEN_PUMPKIN_SEEDS_KEY, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.STEM)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block ATTACHED_GREEN_PUMPKIN_STEM = ModBlocks.register(
            ModPumpkinBlockKeys.ATTACHED_GREEN_PUMPKIN_STEM_PATH,
            settings -> new AttachedStemBlock(ModPumpkinBlockKeys.GREEN_PUMPKIN_STEM_KEY, ModPumpkinBlockKeys.GREEN_PUMPKIN_KEY, ModItemKeys.GREEN_PUMPKIN_SEEDS_KEY, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.WOOD)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            true
    );
    public static final Block GREEN_PUMPKIN = ModBlocks.register(
            ModPumpkinBlockKeys.GREEN_PUMPKIN_PATH,
            GreenPumpkinBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .instrument(NoteBlockInstrument.DIDGERIDOO)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );
    public static final Block CARVED_GREEN_PUMPKIN = ModBlocks.register(
            "carved_green_pumpkin",
            CarvedGreenPumpkinBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .allowsSpawning(Blocks::always)
                    .pistonBehavior(PistonBehavior.DESTROY),
            false,
            false
    );
    public static final Block GREEN_JACK_O_LANTERN = ModBlocks.register(
            "green_jack_o_lantern",
            CarvedGreenPumpkinBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .luminance(state -> 15)
                    .allowsSpawning(Blocks::always)
                    .pistonBehavior(PistonBehavior.DESTROY),
            true,
            false
    );

    public static void initialize() {
        ModBuildingBlocks.initialize();
        ModFloraBlocks.initialize();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.JACK_O_LANTERN, ModPumpkinBlocks.SOUL_JACK_O_LANTERN);
                    itemGroup.addAfter(Items.JACK_O_LANTERN, ModPumpkinBlocks.WHITE_JACK_O_LANTERN);
                    itemGroup.addAfter(Items.JACK_O_LANTERN, ModPumpkinBlocks.CARVED_WHITE_PUMPKIN);
                    itemGroup.addAfter(Items.JACK_O_LANTERN, ModPumpkinBlocks.WHITE_PUMPKIN);
                    itemGroup.addAfter(Items.JACK_O_LANTERN, ModPumpkinBlocks.GREEN_JACK_O_LANTERN);
                    itemGroup.addAfter(Items.JACK_O_LANTERN, ModPumpkinBlocks.CARVED_GREEN_PUMPKIN);
                    itemGroup.addAfter(Items.JACK_O_LANTERN, ModPumpkinBlocks.GREEN_PUMPKIN);
                    itemGroup.addAfter(Items.PUMPKIN_SEEDS, ModItems.WHITE_PUMPKIN_SEEDS);
                    itemGroup.addAfter(Items.PUMPKIN_SEEDS, ModItems.GREEN_PUMPKIN_SEEDS);
                });
    }

}
