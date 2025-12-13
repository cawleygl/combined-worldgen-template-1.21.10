package bluesteel42.combinedworldgen.wood.willow;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.willow.block.WillowWoodModBlocks;
import bluesteel42.combinedworldgen.wood.willow.entity.WillowWoodModBoats;
import bluesteel42.combinedworldgen.wood.willow.item.WillowWoodModItems;
import bluesteel42.combinedworldgen.wood.willow.registries.WillowWoodModRegistries;
import bluesteel42.combinedworldgen.wood.willow.tree.WillowWoodTreeConfiguredFeatures;
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

public class WillowWoodInitializer {
    public static String MOD_WOOD_NAME = "willow";
    public static MapColor MOD_BARK_COLOR = MapColor.GREEN;
    public static MapColor MOD_FIBER_COLOR = MapColor.LIGHT_GRAY;
    public static MapColor MOD_LEAF_COLOR = MapColor.DARK_GREEN;
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.WOOD;
    public static BlockSoundGroup MOD_LEAF_SOUND = BlockSoundGroup.GRASS;
    public static boolean TINTED_LEAVES = true;
    public static int MOD_LEAF_TINT_COLOR = FoliageColors.MANGROVE;
    public static boolean BIOME_LEAF_TINT = true && WillowWoodInitializer.TINTED_LEAVES;
    public static float[] MOD_SAPLING_DROP_CHANCE = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    public static final BlockSetType MOD_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, WillowWoodInitializer.MOD_WOOD_NAME));
    public static final WoodType MOD_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, WillowWoodInitializer.MOD_WOOD_NAME), WillowWoodInitializer.MOD_BLOCK_SET_TYPE);

    public static float MOD_SAPLING_RARE_VARIANT_CHANCE = 0.4F;
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_STANDARD_TREE = Optional.of(WillowWoodTreeConfiguredFeatures.WILLOW_TREE_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_TREE = Optional.of(WillowWoodTreeConfiguredFeatures.WEEPING_WILLOW_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_BEES_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_BEES_TREE = Optional.empty();

    public static void initializeWood() {
        WillowWoodModBlocks.initialize();
        WillowWoodModItems.initialize();
        WillowWoodModBoats.initialize();
        WillowWoodModRegistries.registerStrippables();
        WillowWoodModRegistries.registerCompostables();
        WillowWoodModRegistries.registerFlammables();
        WillowWoodModRegistries.registerTrades();
    }

    public static void initializeWoodClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(WillowWoodModBoats.MOD_BOATS_ID);

        // Color Leaves
        if (WillowWoodInitializer.BIOME_LEAF_TINT) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
                if (view == null || pos == null) {
                    return MOD_LEAF_TINT_COLOR;
                }
                return BiomeColors.getFoliageColor(view, pos);
            }, WillowWoodModBlocks.MOD_LEAVES);
        } else if (WillowWoodInitializer.TINTED_LEAVES) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> MOD_LEAF_TINT_COLOR, WillowWoodModBlocks.MOD_LEAVES);
        }
    }
}
