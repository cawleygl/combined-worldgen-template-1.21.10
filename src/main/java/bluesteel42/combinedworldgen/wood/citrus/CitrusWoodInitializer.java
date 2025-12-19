package bluesteel42.combinedworldgen.wood.citrus;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.citrus.block.CitrusWoodModBlocks;
import bluesteel42.combinedworldgen.wood.citrus.entity.CitrusWoodModBoats;
import bluesteel42.combinedworldgen.wood.citrus.item.CitrusWoodModItems;
import bluesteel42.combinedworldgen.wood.citrus.registries.CitrusWoodModRegistries;
import bluesteel42.combinedworldgen.wood.citrus.tree.CitrusWoodTreeConfiguredFeatures;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.MapColor;
import net.minecraft.block.WoodType;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.FoliageColors;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Optional;

public class CitrusWoodInitializer {
    public static String MOD_WOOD_NAME = "citrus";
    public static MapColor MOD_BARK_COLOR = MapColor.TERRACOTTA_ORANGE;
    public static MapColor MOD_FIBER_COLOR = MapColor.PALE_GREEN;
    public static MapColor MOD_LEAF_COLOR = MapColor.DARK_GREEN;
    
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.CHERRY_WOOD; 
    public static final BlockSetType MOD_BLOCK_SET = BlockSetTypeBuilder.copyOf(CitrusWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, CitrusWoodInitializer.MOD_WOOD_NAME));
    public static final WoodType MOD_WOOD_TYPE = WoodTypeBuilder.copyOf(CitrusWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? WoodType.CHERRY : WoodType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, CitrusWoodInitializer.MOD_WOOD_NAME), CitrusWoodInitializer.MOD_BLOCK_SET);

    public static BlockSoundGroup MOD_LEAF_SOUND = BlockSoundGroup.GRASS;
    public static BlockSoundGroup MOD_SAPLING_SOUND = CitrusWoodInitializer.MOD_LEAF_SOUND == BlockSoundGroup.CHERRY_LEAVES ? BlockSoundGroup.CHERRY_SAPLING : BlockSoundGroup.GRASS;
    public static boolean TINTED_LEAVES = true;
    public static int MOD_LEAF_TINT_COLOR = FoliageColors.DEFAULT;
    public static boolean BIOME_LEAF_TINT = true && CitrusWoodInitializer.TINTED_LEAVES;
    public static float[] MOD_SAPLING_DROP_CHANCE = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    
    public static float MOD_SAPLING_RARE_VARIANT_CHANCE = 0.3F;
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_STANDARD_TREE = Optional.of(CitrusWoodTreeConfiguredFeatures.ORANGE_TREE);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_TREE = Optional.of(CitrusWoodTreeConfiguredFeatures.ORANGE_BUSH);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_BEES_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_BEES_TREE = Optional.empty();

    public static void initializeWood() {
        CitrusWoodModBlocks.initialize();
        CitrusWoodModItems.initialize();
        CitrusWoodModBoats.initialize();
        CitrusWoodModRegistries.registerStrippables();
        CitrusWoodModRegistries.registerCompostables();
        CitrusWoodModRegistries.registerFlammables();
        CitrusWoodModRegistries.registerTrades();
    }

    public static void initializeWoodClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(CitrusWoodModBoats.MOD_BOATS_ID);

        // Color Leaves
        if (CitrusWoodInitializer.BIOME_LEAF_TINT) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
                if (view == null || pos == null) {
                    return MOD_LEAF_TINT_COLOR;
                }
                return BiomeColors.getFoliageColor(view, pos);
                // ADDITIONAL BLOCKS
            }, CitrusWoodModBlocks.MOD_LEAVES, CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES);
        } else if (CitrusWoodInitializer.TINTED_LEAVES) {
                ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> MOD_LEAF_TINT_COLOR, CitrusWoodModBlocks.MOD_LEAVES, CitrusWoodModBlocks.FLOWERING_ORANGE_LEAVES);
        }
    }
}
