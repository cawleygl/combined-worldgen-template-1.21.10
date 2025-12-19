package bluesteel42.combinedworldgen.wood.cholla;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.cholla.block.ChollaWoodModBlocks;
import bluesteel42.combinedworldgen.wood.cholla.entity.ChollaWoodModRafts;
import bluesteel42.combinedworldgen.wood.cholla.item.ChollaWoodModItems;
import bluesteel42.combinedworldgen.wood.cholla.registries.ChollaWoodModRegistries;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.MapColor;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ChollaWoodInitializer {
    /* COMBINED WOOD */
    public static String MOD_WOOD_NAME = "cholla";
    public static MapColor MOD_UNSTRIPPED_COLOR = MapColor.DEEPSLATE_GRAY;
    public static MapColor MOD_STRIPPED_COLOR = MapColor.DARK_GREEN;
    
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.BAMBOO_WOOD;
    public static final BlockSetType MOD_BLOCK_SET = BlockSetTypeBuilder.copyOf(ChollaWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.BAMBOO_WOOD ? BlockSetType.BAMBOO : BlockSetType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, ChollaWoodInitializer.MOD_WOOD_NAME));
    public static final WoodType MOD_WOOD_TYPE = WoodTypeBuilder.copyOf(ChollaWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.BAMBOO_WOOD ? WoodType.BAMBOO : WoodType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, ChollaWoodInitializer.MOD_WOOD_NAME), ChollaWoodInitializer.MOD_BLOCK_SET);
    
    public static void initializeWood() {
        ChollaWoodModBlocks.initialize();
        ChollaWoodModItems.initialize();
        ChollaWoodModRafts.initialize();
        ChollaWoodModRegistries.registerStrippables();
        ChollaWoodModRegistries.registerFlammables();
        ChollaWoodModRegistries.registerTrades();
        ChollaWoodModRegistries.registerFuels();
    }

    public static void initializeWoodClient() {
        // Register Raft Models
        TerraformBoatClientHelper.registerModelLayers(ChollaWoodModRafts.MOD_RAFTS_ID);
    }
}
