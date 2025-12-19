package bluesteel42.combinedworldgen.wood.kapok;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.kapok.block.KapokWoodModBlocks;
import bluesteel42.combinedworldgen.wood.kapok.entity.KapokWoodModBoats;
import bluesteel42.combinedworldgen.wood.kapok.item.KapokWoodModItems;
import bluesteel42.combinedworldgen.wood.kapok.registries.KapokWoodModRegistries;
import bluesteel42.combinedworldgen.wood.kapok.tree.KapokWoodTreeConfiguredFeatures;
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

public class KapokWoodInitializer {
    public static String MOD_WOOD_NAME = "kapok";
    public static MapColor MOD_BARK_COLOR = MapColor.DIRT_BROWN;
    public static MapColor MOD_FIBER_COLOR = MapColor.SPRUCE_BROWN;
    public static MapColor MOD_LEAF_COLOR = MapColor.DARK_GREEN;

    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.WOOD;
    public static final BlockSetType MOD_BLOCK_SET = BlockSetTypeBuilder.copyOf(KapokWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, KapokWoodInitializer.MOD_WOOD_NAME));
    public static final WoodType MOD_WOOD_TYPE = WoodTypeBuilder.copyOf(KapokWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? WoodType.CHERRY : WoodType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, KapokWoodInitializer.MOD_WOOD_NAME), KapokWoodInitializer.MOD_BLOCK_SET);

    public static BlockSoundGroup MOD_LEAF_SOUND = BlockSoundGroup.GRASS;
    public static BlockSoundGroup MOD_SAPLING_SOUND = KapokWoodInitializer.MOD_LEAF_SOUND == BlockSoundGroup.CHERRY_LEAVES ? BlockSoundGroup.CHERRY_SAPLING : BlockSoundGroup.GRASS;
    public static boolean TINTED_LEAVES = true;
    public static int MOD_LEAF_TINT_COLOR = FoliageColors.DEFAULT;
    public static boolean BIOME_LEAF_TINT = true && KapokWoodInitializer.TINTED_LEAVES;
    public static float[] MOD_SAPLING_DROP_CHANCE = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    /* KAPOK TREES USE VANILLA JUNGLE SAPLING */
    public static String CACAO_WOOD_NAME = "cacao";
    public static float CACAO_SAPLING_RARE_VARIANT_CHANCE = 0.3F;
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> CACAO_SAPLING_STANDARD_TREE = Optional.of(KapokWoodTreeConfiguredFeatures.CACAO_TREE_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> CACAO_SAPLING_RARE_TREE =  Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> CACAO_SAPLING_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> CACAO_SAPLING_RARE_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> CACAO_SAPLING_BEES_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> CACAO_SAPLING_RARE_BEES_TREE = Optional.empty();

    public static void initializeWood() {
        KapokWoodModBlocks.initialize();
        KapokWoodModItems.initialize();
        KapokWoodModBoats.initialize();
        KapokWoodModRegistries.registerStrippables();
        KapokWoodModRegistries.registerCompostables();
        KapokWoodModRegistries.registerFlammables();
        KapokWoodModRegistries.registerTrades();
    }

    public static void initializeWoodClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(KapokWoodModBoats.MOD_BOATS_ID);

        // Color Leaves
        if (KapokWoodInitializer.BIOME_LEAF_TINT) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
                if (view == null || pos == null) {
                    return MOD_LEAF_TINT_COLOR;
                }
                return BiomeColors.getFoliageColor(view, pos);
                // ADDITIONAL BLOCKS
            }, KapokWoodModBlocks.MOD_LEAVES, KapokWoodModBlocks.CACAO_LEAVES);
        } else if (KapokWoodInitializer.TINTED_LEAVES) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> MOD_LEAF_TINT_COLOR, KapokWoodModBlocks.MOD_LEAVES, KapokWoodModBlocks.CACAO_LEAVES);
        }
    }
}
