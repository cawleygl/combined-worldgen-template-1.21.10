package bluesteel42.combinedworldgen.wood.chorus;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.chorus.block.ChorusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.chorus.entity.ChorusWoodModRafts;
import bluesteel42.combinedworldgen.wood.chorus.item.ChorusWoodModItems;
import bluesteel42.combinedworldgen.wood.chorus.registries.ChorusWoodModRegistries;
import bluesteel42.combinedworldgen.wood.petrified.PetrifiedWoodInitializer;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.MapColor;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ChorusWoodInitializer {
    /* COMBINED WOOD */
    public static String MOD_WOOD_NAME = "chorus";
    public static MapColor MOD_UNSTRIPPED_COLOR = MapColor.TERRACOTTA_PURPLE;
    public static MapColor MOD_STRIPPED_COLOR = MapColor.PINK;

    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.WOOD;
    public static final BlockSetType MOD_BLOCK_SET = BlockSetTypeBuilder
            .copyOf(BlockSetType.OAK)
            .doorOpenSound(SoundEvents.BLOCK_ENDER_CHEST_OPEN)
            .doorCloseSound(SoundEvents.BLOCK_ENDER_CHEST_CLOSE)
            .trapdoorOpenSound(SoundEvents.BLOCK_ENDER_CHEST_OPEN)
            .trapdoorCloseSound(SoundEvents.BLOCK_ENDER_CHEST_CLOSE)
            .register(Identifier.of(CombinedWorldgen.MOD_ID, ChorusWoodInitializer.MOD_WOOD_NAME));

    public static final WoodType MOD_WOOD_TYPE = new WoodTypeBuilder()
            .soundGroup(BlockSoundGroup.WOOD)
            .hangingSignSoundGroup(BlockSoundGroup.HANGING_SIGN)
            .fenceGateCloseSound(SoundEvents.BLOCK_ENDER_CHEST_CLOSE)
            .fenceGateOpenSound(SoundEvents.BLOCK_ENDER_CHEST_OPEN)
            .register(Identifier.of(CombinedWorldgen.MOD_ID, ChorusWoodInitializer.MOD_WOOD_NAME), ChorusWoodInitializer.MOD_BLOCK_SET);

    public static void initializeWood() {
        ChorusWoodModBlocks.initialize();
        ChorusWoodModItems.initialize();
        ChorusWoodModRafts.initialize();
        ChorusWoodModRegistries.registerStrippables();
        ChorusWoodModRegistries.registerFlammables();
        ChorusWoodModRegistries.registerTrades();
        ChorusWoodModRegistries.registerFuels();
    }

    public static void initializeWoodClient() {
        // Register Raft Models
        TerraformBoatClientHelper.registerModelLayers(ChorusWoodModRafts.MOD_RAFTS_ID);
    }
}
