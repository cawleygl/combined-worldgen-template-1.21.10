package bluesteel42.combinedworldgen.entity;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModLootTables {
    public static final RegistryKey<LootTable> GREEN_PUMPKIN_CARVE = register("carve/green_pumpkin");
    public static final RegistryKey<LootTable> WHITE_PUMPKIN_CARVE = register("carve/white_pumpkin");
    public static final RegistryKey<LootTable> GREEN_PUMPKIN_SNOW_GOLEM_SHEARING = register("shearing/green_pumpkin_snow_golem");
    public static final RegistryKey<LootTable> WHITE_PUMPKIN_SNOW_GOLEM_SHEARING = register("shearing/white_pumpkin_snow_golem");

    public static final RegistryKey<LootTable> MOOBLOOM_SHEARING = register("shearing/moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_DANDELION_SHEARING = register("shearing/dandelion_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_POPPY_SHEARING = register("shearing/poppy_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_CORNFLOWER_SHEARING = register("shearing/cornflower_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_ALLIUM_SHEARING = register("shearing/allium_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_BLUE_ORCHID_SHEARING = register("shearing/blue_orchid_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_OXEYE_DAISY_SHEARING = register("shearing/oxeye_daisy_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_AZURE_BLUET_SHEARING = register("shearing/azure_bluet_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_RED_TULIP_SHEARING = register("shearing/red_tulip_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_ORANGE_TULIP_SHEARING = register("shearing/orange_tulip_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_WHITE_TULIP_SHEARING = register("shearing/white_tulip_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_PINK_TULIP_SHEARING = register("shearing/pink_tulip_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_LILY_OF_THE_VALLEY_SHEARING = register("shearing/lily_of_the_valley_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_LILAC_SHEARING = register("shearing/lilac_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_PEONY_SHEARING = register("shearing/peony_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_ROSE_SHEARING = register("shearing/rose_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_SUNFLOWER_SHEARING = register("shearing/sunflower_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_TORCHFLOWER_SHEARING = register("shearing/torchflower_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_PITCHER_PLANT_SHEARING = register("shearing/pitcher_plant_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_OPEN_EYEBLOSSOM_SHEARING = register("shearing/open_eyeblossom_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_CLOSED_EYEBLOSSOM_SHEARING = register("shearing/closed_eyeblossom_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_WITHER_ROSE_SHEARING = register("shearing/wither_rose_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_CACTUS_FLOWER_SHEARING = register("shearing/cactus_flower_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_MONSTERA_SHEARING = register("shearing/monstera_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_YELLOW_TULIP_SHEARING = register("shearing/yellow_tulip_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_PURPLE_TULIP_SHEARING = register("shearing/purple_tulip_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_HELLEBORE_SHEARING = register("shearing/hellebore_moobloom");
    public static final RegistryKey<LootTable> MOOBLOOM_GIANT_PADMA_SHEARING = register("shearing/giant_padma_moobloom");

    public static RegistryKey<LootTable> CLUCKSHROOM_SHEARING = RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(CombinedWorldgen.MOD_ID, "shearing/cluckshroom"));
    public static RegistryKey<LootTable> CLUCKSHROOM_LAY_GAMEPLAY = RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(CombinedWorldgen.MOD_ID, "gameplay/cluckshroom_lay"));

    private static RegistryKey<LootTable> register(String path) {
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(CombinedWorldgen.MOD_ID, path));
    }
}