package bluesteel42.combinedworldgen.wood.dogwood;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.wood.dogwood.block.DogwoodWoodModBlocks;
import bluesteel42.combinedworldgen.wood.dogwood.entity.DogwoodWoodModBoats;
import bluesteel42.combinedworldgen.wood.dogwood.item.DogwoodWoodModItems;
import bluesteel42.combinedworldgen.wood.dogwood.particle.DogwoodLeavesFactory;
import bluesteel42.combinedworldgen.wood.dogwood.particle.DogwoodWoodModParticles;
import bluesteel42.combinedworldgen.wood.dogwood.registries.DogwoodWoodModRegistries;
import bluesteel42.combinedworldgen.wood.dogwood.tree.DogwoodWoodTreeConfiguredFeatures;
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
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Optional;

public class DogwoodWoodInitializer {
    /* CHERRY-LIKE (FLOWER) LEAVES */
    public static String MOD_WOOD_NAME = "dogwood";
    public static MapColor MOD_BARK_COLOR = MapColor.DARK_GREEN;
    public static MapColor MOD_FIBER_COLOR = MapColor.TERRACOTTA_CYAN;
    public static MapColor MOD_LEAF_COLOR = MapColor.WHITE;
    
    public static BlockSoundGroup MOD_BLOCK_SOUND = BlockSoundGroup.WOOD;
    public static final BlockSetType MOD_BLOCK_SET = BlockSetTypeBuilder.copyOf(DogwoodWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? BlockSetType.CHERRY : BlockSetType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, DogwoodWoodInitializer.MOD_WOOD_NAME));
    public static final WoodType MOD_WOOD_TYPE = WoodTypeBuilder.copyOf(DogwoodWoodInitializer.MOD_BLOCK_SOUND == BlockSoundGroup.CHERRY_WOOD ? WoodType.CHERRY : WoodType.OAK).register(Identifier.of(CombinedWorldgen.MOD_ID, DogwoodWoodInitializer.MOD_WOOD_NAME), DogwoodWoodInitializer.MOD_BLOCK_SET);

    public static BlockSoundGroup MOD_LEAF_SOUND = BlockSoundGroup.CHERRY_LEAVES;
    public static BlockSoundGroup MOD_SAPLING_SOUND = DogwoodWoodInitializer.MOD_LEAF_SOUND == BlockSoundGroup.CHERRY_LEAVES ? BlockSoundGroup.CHERRY_SAPLING : BlockSoundGroup.GRASS;
    public static boolean TINTED_LEAVES = false;
    public static int MOD_LEAF_TINT_COLOR = 0;
    public static boolean BIOME_LEAF_TINT = false && DogwoodWoodInitializer.TINTED_LEAVES;
    public static float[] MOD_SAPLING_DROP_CHANCE = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    
    public static float MOD_SAPLING_RARE_VARIANT_CHANCE = 0.1F;
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_STANDARD_TREE = Optional.of(DogwoodWoodTreeConfiguredFeatures.DOGWOOD_TREE_KEY);
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_MEGA_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_BEES_TREE = Optional.empty();
    public static Optional<RegistryKey<ConfiguredFeature<?, ?>>> MOD_SAPLING_RARE_BEES_TREE = Optional.empty();

    public static void initializeWood() {
        DogwoodWoodModBlocks.initialize();
        DogwoodWoodModItems.initialize();
        DogwoodWoodModBoats.initialize();
        DogwoodWoodModParticles.initialize();
        DogwoodWoodModRegistries.registerStrippables();
        DogwoodWoodModRegistries.registerCompostables();
        DogwoodWoodModRegistries.registerFlammables();
        DogwoodWoodModRegistries.registerTrades();
    }

    public static void initializeWoodClient() {
        // Register Boat Models
        TerraformBoatClientHelper.registerModelLayers(DogwoodWoodModBoats.MOD_BOATS_ID);

        // Color Leaves
        if (DogwoodWoodInitializer.BIOME_LEAF_TINT) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
                if (view == null || pos == null) {
                    return MOD_LEAF_TINT_COLOR;
                }
                return BiomeColors.getFoliageColor(view, pos);
            }, DogwoodWoodModBlocks.MOD_LEAVES);
        } else if (DogwoodWoodInitializer.TINTED_LEAVES) {
            ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> MOD_LEAF_TINT_COLOR, DogwoodWoodModBlocks.MOD_LEAVES);
        }
        
        // Register Custom Leaves Particle
        ParticleFactoryRegistry.getInstance().register(DogwoodWoodModParticles.DOGWOOD_LEAVES, DogwoodLeavesFactory::new);

    }
}
