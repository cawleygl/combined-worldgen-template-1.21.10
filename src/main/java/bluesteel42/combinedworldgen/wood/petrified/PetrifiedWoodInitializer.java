package bluesteel42.combinedworldgen.wood.petrified;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.baobab.block.BaobabWoodModBlocks;
import bluesteel42.combinedworldgen.wood.baobab.entity.BaobabWoodModBoats;
import bluesteel42.combinedworldgen.wood.baobab.item.BaobabWoodModItems;
import bluesteel42.combinedworldgen.wood.baobab.registries.BaobabWoodModRegistries;
import bluesteel42.combinedworldgen.wood.petrified.block.PetrifiedWoodModBlocks;
import bluesteel42.combinedworldgen.wood.petrified.item.PetrifiedWoodModItems;
import bluesteel42.combinedworldgen.wood.petrified.registries.PetrifiedWoodModRegistries;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.MapColor;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class PetrifiedWoodInitializer {
    /* STONE QUALITIES, NOT FLAMMABLE OR FUEL, NO LEAVES OR SAPLING */
    public static String MOD_WOOD_NAME = "petrified";
    public static MapColor MOD_BARK_COLOR = MapColor.DARK_CRIMSON;
    public static MapColor MOD_FIBER_COLOR = MapColor.DEEPSLATE_GRAY;
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.STONE;

    public static final BlockSetType MOD_BLOCK_SET = BlockSetTypeBuilder
            .copyOf(BlockSetType.STONE)
            .doorOpenSound(SoundEvents.BLOCK_STONE_HIT)
            .doorCloseSound(SoundEvents.BLOCK_STONE_HIT)
            .trapdoorOpenSound(SoundEvents.BLOCK_STONE_HIT)
            .trapdoorCloseSound(SoundEvents.BLOCK_STONE_HIT)
            .register(Identifier.of(CombinedWorldgen.MOD_ID, PetrifiedWoodInitializer.MOD_WOOD_NAME));

    public static final WoodType MOD_WOOD_TYPE = new WoodTypeBuilder()
            .soundGroup(BlockSoundGroup.STONE)
            .hangingSignSoundGroup(BlockSoundGroup.CHAIN)
            .fenceGateCloseSound(SoundEvents.BLOCK_STONE_HIT)
            .fenceGateOpenSound(SoundEvents.BLOCK_STONE_HIT)
            .register(Identifier.of(CombinedWorldgen.MOD_ID, PetrifiedWoodInitializer.MOD_WOOD_NAME), PetrifiedWoodInitializer.MOD_BLOCK_SET);

    public static void initializeWood() {
        PetrifiedWoodModBlocks.initialize();
        PetrifiedWoodModItems.initialize();
        PetrifiedWoodModRegistries.registerStrippables();
    }

    public static void initializeWoodClient() {}
}
