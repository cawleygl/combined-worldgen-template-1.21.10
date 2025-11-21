package bluesteel42.combinedworldgen.wood.baobab;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.baobab.block.BaobabWoodModBlocks;
import bluesteel42.combinedworldgen.wood.baobab.entity.BaobabWoodModBoats;
import bluesteel42.combinedworldgen.wood.baobab.item.BaobabWoodModItems;
import bluesteel42.combinedworldgen.wood.baobab.registries.BaobabWoodModRegistries;
import bluesteel42.combinedworldgen.wood.baobab.tree.BaobabWoodTreeConfiguredFeatures;
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
import net.minecraft.util.math.ColorHelper;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Optional;

public class BaobabWoodInitializer {
    public static String MOD_WOOD_NAME = "baobab";
    public static MapColor MOD_BARK_COLOR = MapColor.TERRACOTTA_LIGHT_GRAY;
    public static MapColor MOD_FIBER_COLOR = MapColor.TERRACOTTA_YELLOW;
    public static MapColor MOD_LEAF_COLOR = MapColor.DARK_GREEN;
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.CHERRY_WOOD;
    public static BlockSoundGroup MOD_LEAF_SOUND = BlockSoundGroup.GRASS;
    public static boolean TINTED_LEAVES = true;
    public static int MOD_LEAF_TINT_COLOR = ColorHelper.getArgb(109, 115, 33);
    public static boolean BIOME_LEAF_TINT = false && BaobabWoodInitializer.TINTED_LEAVES;
    public static float[] MOD_SAPLING_DROP_CHANCE = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    public static final BlockSetType MOD_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, BaobabWoodInitializer.MOD_WOOD_NAME));
    public static final WoodType MOD_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, BaobabWoodInitializer.MOD_WOOD_NAME), BaobabWoodInitializer.MOD_BLOCK_SET_TYPE);

    public static float MOD_SAPLING_RARE_VARIANT_CHANCE = 0.1F;
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_STANDARD_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_MEGA_TREE = Optional.of(BaobabWoodTreeConfiguredFeatures.BAOBAB_TREE_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_BEES_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_BEES_TREE = Optional.empty();


    public static void initializeWood() {
        BaobabWoodModBlocks.initialize();
        BaobabWoodModItems.initialize();
        BaobabWoodModBoats.initialize();
        BaobabWoodModRegistries.registerStrippables();
        BaobabWoodModRegistries.registerCompostables();
        BaobabWoodModRegistries.registerFlammables();
        BaobabWoodModRegistries.registerTrades();
    }

    public static void initializeWoodClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(BaobabWoodModBoats.MOD_BOATS_ID);

        // Color Leaves
        if (BaobabWoodInitializer.BIOME_LEAF_TINT) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
                if (view == null || pos == null) {
                    return MOD_LEAF_TINT_COLOR;
                }
                return BiomeColors.getFoliageColor(view, pos);
                // ADDITIONAL BLOCKS
            }, BaobabWoodModBlocks.MOD_LEAVES);
        } else if (BaobabWoodInitializer.TINTED_LEAVES) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> MOD_LEAF_TINT_COLOR, BaobabWoodModBlocks.MOD_LEAVES);
        }
    }
}
