package bluesteel42.combinedworldgen.wood.maple;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.maple.block.MapleWoodModBlocks;
import bluesteel42.combinedworldgen.wood.maple.entity.MapleWoodModBoats;
import bluesteel42.combinedworldgen.wood.maple.item.MapleWoodModItems;
import bluesteel42.combinedworldgen.wood.maple.particle.MapleWoodModParticles;
import bluesteel42.combinedworldgen.wood.maple.registries.MapleWoodModRegistries;
import bluesteel42.combinedworldgen.wood.maple.tree.MapleWoodTreeConfiguredFeatures;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.MapColor;
import net.minecraft.block.WoodType;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.particle.LeavesParticle;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.FoliageColors;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Optional;

public class MapleWoodInitializer {
    public static String MOD_WOOD_NAME = "maple";
    public static MapColor MOD_BARK_COLOR = MapColor.TERRACOTTA_PURPLE;
    public static MapColor MOD_FIBER_COLOR = MapColor.OAK_TAN;
    public static MapColor MOD_LEAF_COLOR = MapColor.DARK_GREEN;
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.WOOD;
    public static BlockSoundGroup MOD_LEAF_SOUND = BlockSoundGroup.GRASS;
    public static boolean TINTED_LEAVES = true;
    public static int MOD_LEAF_TINT_COLOR = FoliageColors.DEFAULT;
    public static boolean BIOME_LEAF_TINT = true && MapleWoodInitializer.TINTED_LEAVES;
    public static float[] MOD_SAPLING_DROP_CHANCE = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    public static final BlockSetType MOD_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, MapleWoodInitializer.MOD_WOOD_NAME));
    public static final WoodType MOD_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, MapleWoodInitializer.MOD_WOOD_NAME), MapleWoodInitializer.MOD_BLOCK_SET_TYPE);

    public static float MOD_SAPLING_RARE_VARIANT_CHANCE = 0.1F;
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_STANDARD_TREE = Optional.of(MapleWoodTreeConfiguredFeatures.TALL_MULTICOLORED_MAPLE_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_TREE = Optional.of(MapleWoodTreeConfiguredFeatures.SHORT_MULTICOLORED_MAPLE_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_BEES_TREE = Optional.of(MapleWoodTreeConfiguredFeatures.TALL_MULTICOLORED_MAPLE_BEES_005_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_BEES_TREE = Optional.of(MapleWoodTreeConfiguredFeatures.SHORT_MULTICOLORED_MAPLE_BEES_005_KEY);

    public static void initializeWood() {
        MapleWoodModBlocks.initialize();
        MapleWoodModItems.initialize();
        MapleWoodModBoats.initialize();
        MapleWoodModRegistries.registerStrippables();
        MapleWoodModRegistries.registerCompostables();
        MapleWoodModRegistries.registerFlammables();
        MapleWoodModRegistries.registerTrades();
        // Initialize Custom Particles
        MapleWoodModParticles.initialize();
    }

    public static void initializeWoodClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(MapleWoodModBoats.MOD_BOATS_ID);

        // Color Leaves + Additional
        if (MapleWoodInitializer.BIOME_LEAF_TINT) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
                if (view == null || pos == null) {
                    return MOD_LEAF_TINT_COLOR;
                }
                return BiomeColors.getFoliageColor(view, pos);
            }, MapleWoodModBlocks.MOD_LEAVES, MapleWoodModBlocks.MIXED_MAPLE_LEAVES);
        } else if (MapleWoodInitializer.TINTED_LEAVES) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> MOD_LEAF_TINT_COLOR, MapleWoodModBlocks.MOD_LEAVES, MapleWoodModBlocks.MIXED_MAPLE_LEAVES);
        }

        // Register Leaf Particle Effect
        ParticleFactoryRegistry.getInstance().register(MapleWoodModParticles.GREEN_MAPLE_LEAVES, LeavesParticle.TintedLeavesFactory::new);
        ParticleFactoryRegistry.getInstance().register(MapleWoodModParticles.RED_MAPLE_LEAVES, LeavesParticle.CherryLeavesFactory::new);
        ParticleFactoryRegistry.getInstance().register(MapleWoodModParticles.YELLOW_MAPLE_LEAVES, LeavesParticle.CherryLeavesFactory::new);
    }
}
