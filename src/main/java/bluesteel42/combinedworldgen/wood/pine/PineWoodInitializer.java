package bluesteel42.combinedworldgen.wood.pine;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.pine.block.PineWoodModBlocks;
import bluesteel42.combinedworldgen.wood.pine.entity.PineWoodModBoats;
import bluesteel42.combinedworldgen.wood.pine.item.PineWoodModItems;
import bluesteel42.combinedworldgen.wood.pine.particle.PineWoodModParticles;
import bluesteel42.combinedworldgen.wood.pine.registries.PineWoodModRegistries;
import bluesteel42.combinedworldgen.wood.pine.tree.PineWoodTreeConfiguredFeatures;
import bluesteel42.combinedworldgen.wood.pine.particle.TintedNeedlesFactory;
import bluesteel42.combinedworldgen.wood.pine.particle.UntintedNeedlesFactory;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
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
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.Optional;

public class PineWoodInitializer {
    public static String MOD_WOOD_NAME = "pine";
    public static MapColor MOD_BARK_COLOR = MapColor.TERRACOTTA_RED;
    public static MapColor MOD_FIBER_COLOR = MapColor.TERRACOTTA_WHITE;
    public static MapColor MOD_LEAF_COLOR = MapColor.DARK_GREEN;
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.WOOD;
    public static BlockSoundGroup MOD_LEAF_SOUND = BlockSoundGroup.GRASS;
    public static boolean TINTED_LEAVES = true;
    public static int MOD_LEAF_TINT_COLOR = FoliageColors.DEFAULT;
    public static boolean BIOME_LEAF_TINT = true && PineWoodInitializer.TINTED_LEAVES;
    public static float[] MOD_SAPLING_DROP_CHANCE = new float[]{0.1F, 0.125F, 0.166666667F, 0.2F};

    public static final BlockSetType MOD_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, PineWoodInitializer.MOD_WOOD_NAME));
    public static final WoodType MOD_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, PineWoodInitializer.MOD_WOOD_NAME), PineWoodInitializer.MOD_BLOCK_SET_TYPE);

    public static float MOD_SAPLING_RARE_VARIANT_CHANCE = 0.5F;
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_STANDARD_TREE = Optional.of(TreeConfiguredFeatures.PINE);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_MEGA_TREE = Optional.of(PineWoodTreeConfiguredFeatures.MEGA_PINE_HIGH_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_MEGA_TREE = Optional.of(PineWoodTreeConfiguredFeatures.MEGA_PINE_LOW_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_BEES_TREE = Optional.of(PineWoodTreeConfiguredFeatures.PINE_BEES_005_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_BEES_TREE = Optional.empty();

    /* ADDITIONAL SAPLINGS */
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_PINE_SAPLING_STANDARD_TREE = Optional.of(PineWoodTreeConfiguredFeatures.SNOWY_PINE_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_PINE_SAPLING_RARE_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_PINE_SAPLING_MEGA_TREE = Optional.of(PineWoodTreeConfiguredFeatures.MEGA_SNOWY_PINE_HIGH_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_PINE_SAPLING_RARE_MEGA_TREE = Optional.of(PineWoodTreeConfiguredFeatures.MEGA_SNOWY_PINE_LOW_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_PINE_SAPLING_BEES_TREE = Optional.of(PineWoodTreeConfiguredFeatures.SNOWY_PINE_BEES_005_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_PINE_SAPLING_RARE_BEES_TREE = Optional.empty();

    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_SPRUCE_SAPLING_STANDARD_TREE = Optional.of(PineWoodTreeConfiguredFeatures.SNOWY_SPRUCE_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_SPRUCE_SAPLING_RARE_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_SPRUCE_SAPLING_MEGA_TREE = Optional.of(PineWoodTreeConfiguredFeatures.MEGA_SNOWY_SPRUCE_LOW_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_SPRUCE_SAPLING_RARE_MEGA_TREE = Optional.of(PineWoodTreeConfiguredFeatures.MEGA_SNOWY_SPRUCE_HIGH_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_SPRUCE_SAPLING_BEES_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> SNOWY_SPRUCE_SAPLING_RARE_BEES_TREE = Optional.empty();

    public static void initializeWood() {
        PineWoodModBlocks.initialize();
        PineWoodModItems.initialize();
        PineWoodModBoats.initialize();
        PineWoodModRegistries.registerStrippables();
        PineWoodModRegistries.registerCompostables();
        PineWoodModRegistries.registerFlammables();
        PineWoodModRegistries.registerTrades();
        // Initialize Custom Particles
        PineWoodModParticles.initialize();
    }

    public static void initializeWoodClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(PineWoodModBoats.MOD_BOATS_ID);

        // Color Leaves
        if (PineWoodInitializer.BIOME_LEAF_TINT) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
                if (view == null || pos == null) {
                    return MOD_LEAF_TINT_COLOR;
                }
                return BiomeColors.getFoliageColor(view, pos);
            }, PineWoodModBlocks.MOD_LEAVES);
        } else if (PineWoodInitializer.TINTED_LEAVES) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> MOD_LEAF_TINT_COLOR, PineWoodModBlocks.MOD_LEAVES);
        }

        /* ADDITIONAL BLOCKS */
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> FoliageColors.SPRUCE, PineWoodModBlocks.SPRUCE_LEAVES_FALLING_NEEDLES);

        // Register Leaf Particle Effect
        ParticleFactoryRegistry.getInstance().register(PineWoodModParticles.PINE_NEEDLES, TintedNeedlesFactory::new);
        ParticleFactoryRegistry.getInstance().register(PineWoodModParticles.SPRUCE_NEEDLES, TintedNeedlesFactory::new);
        ParticleFactoryRegistry.getInstance().register(PineWoodModParticles.SNOWY_PINE_NEEDLES, UntintedNeedlesFactory::new);
        ParticleFactoryRegistry.getInstance().register(PineWoodModParticles.SNOWY_SPRUCE_NEEDLES, UntintedNeedlesFactory::new);
    }
}
