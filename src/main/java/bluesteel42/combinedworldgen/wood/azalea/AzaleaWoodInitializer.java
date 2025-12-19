package bluesteel42.combinedworldgen.wood.azalea;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.azalea.block.AzaleaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.azalea.entity.AzaleaWoodModRafts;
import bluesteel42.combinedworldgen.wood.azalea.item.AzaleaWoodModItems;
import bluesteel42.combinedworldgen.wood.azalea.registries.AzaleaWoodModRegistries;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.MapColor;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class AzaleaWoodInitializer {
    /* COMBINED WOOD */
    public static String MOD_WOOD_NAME = "azalea";
    public static MapColor MOD_UNSTRIPPED_COLOR = MapColor.TERRACOTTA_LIME;
    public static MapColor MOD_STRIPPED_COLOR = MapColor.PINK;
    
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.BAMBOO_WOOD;
    public static final BlockSetType MOD_BLOCK_SET = BlockSetTypeBuilder.copyOf(AzaleaWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.BAMBOO_WOOD ? BlockSetType.BAMBOO : BlockSetType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, AzaleaWoodInitializer.MOD_WOOD_NAME));
    public static final WoodType MOD_WOOD_TYPE = WoodTypeBuilder.copyOf(AzaleaWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.BAMBOO_WOOD ? WoodType.BAMBOO : WoodType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, AzaleaWoodInitializer.MOD_WOOD_NAME), AzaleaWoodInitializer.MOD_BLOCK_SET);

    public static void initializeWood() {
        AzaleaWoodModBlocks.initialize();
        AzaleaWoodModItems.initialize();
        AzaleaWoodModRafts.initialize();
        AzaleaWoodModRegistries.registerStrippables();
        AzaleaWoodModRegistries.registerFlammables();
        AzaleaWoodModRegistries.registerTrades();
        AzaleaWoodModRegistries.registerFuels();
    }

    public static void initializeWoodClient() {
        // Register Raft Models
        TerraformBoatClientHelper.registerModelLayers(AzaleaWoodModRafts.MOD_RAFTS_ID);
    }
}
