package bluesteel42.combinedworldgen.item;

import bluesteel42.combinedworldgen.CombinedWorldgen;
import bluesteel42.combinedworldgen.block.flora.ModFloraBlocks;
import bluesteel42.combinedworldgen.block.pumpkin.ModPumpkinBlocks;
import bluesteel42.combinedworldgen.entity.ModDataComponentTypes;
import bluesteel42.combinedworldgen.entity.ModEntities;
import bluesteel42.combinedworldgen.entity.cluckshroom.CluckshroomEntity;
import bluesteel42.combinedworldgen.util.ModTags;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ModItems {
    public static final Item WHITE_WATER_LILY = Items.register(ModFloraBlocks.WHITE_WATER_LILY, PlaceableOnWaterItem::new);
    public static final Item PINK_WATER_LILY = Items.register(ModFloraBlocks.PINK_WATER_LILY, PlaceableOnWaterItem::new);
    public static final Item BLUE_WATER_LILY = Items.register(ModFloraBlocks.BLUE_WATER_LILY, PlaceableOnWaterItem::new);
    public static final Item PURPLE_WATER_LILY = Items.register(ModFloraBlocks.PURPLE_WATER_LILY, PlaceableOnWaterItem::new);
    public static final Item WHITE_PUMPKIN_SEEDS = Items.register(ModItemKeys.WHITE_PUMPKIN_SEEDS_KEY, createBlockItemWithUniqueName(ModPumpkinBlocks.WHITE_PUMPKIN_STEM));
    public static final Item GREEN_PUMPKIN_SEEDS = Items.register(ModItemKeys.GREEN_PUMPKIN_SEEDS_KEY, createBlockItemWithUniqueName(ModPumpkinBlocks.GREEN_PUMPKIN_STEM));

    public static final String SPAWN_EGG_PATH = "_spawn_egg";
    public static final Item WHITE_PUMPKIN_SNOW_GOLEM_SPAWN_EGG = register(ModEntities.WHITE_PUMPKIN_SNOW_GOLEM_PATH + ModItems.SPAWN_EGG_PATH, SpawnEggItem::new, new Item.Settings().spawnEgg(ModEntities.WHITE_PUMPKIN_SNOW_GOLEM));
    public static final Item GREEN_PUMPKIN_SNOW_GOLEM_SPAWN_EGG = register(ModEntities.GREEN_PUMPKIN_SNOW_GOLEM_PATH + ModItems.SPAWN_EGG_PATH, SpawnEggItem::new, new Item.Settings().spawnEgg(ModEntities.GREEN_PUMPKIN_SNOW_GOLEM));
    public static final Item MOOBLOOM_SPAWN_EGG = register(ModEntities.MOOBLOOM_PATH + ModItems.SPAWN_EGG_PATH, SpawnEggItem::new, new Item.Settings().spawnEgg(ModEntities.MOOBLOOM));
    public static final Item CLUCKSHROOM_SPAWN_EGG = register(ModEntities.CLUCKSHROOM_PATH + ModItems.SPAWN_EGG_PATH, SpawnEggItem::new, new Item.Settings().spawnEgg(ModEntities.CLUCKSHROOM));

    public static final Item REMOVE_LONGEST_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_remove_longest", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_REMOVE_LONGEST));
    public static final Item SATURATION_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_saturation", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_SATURATION));
    public static final Item BLINDNESS_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_blindness", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_BLINDNESS));
    public static final Item NAUSEA_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_nausea", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_NAUSEA));
    public static final Item NIGHT_VISION_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_night_vision", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_NIGHT_VISION));
    public static final Item FIRE_RESISTANCE_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_fire_resistance", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_FIRE_RESISTANCE));
    public static final Item WEAKNESS_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_weakness", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_WEAKNESS));
    public static final Item REGENERATION_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_regeneration", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_REGENERATION));
    public static final Item JUMP_BOOST_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_jump_boost", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_JUMP_BOOST));
    public static final Item POISON_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_poison", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_POISON));
    public static final Item WITHER_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_wither", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_WITHER));
    public static final Item HASTE_FLORAL_MILK_BOTTLE = register("floral_milk_bottle_haste", createFloralMilkSettings(ModFoodComponents.FLORAL_MILK_HASTE));

    public static final Item SPOTTED_EGG = register("spotted_egg", CluckshroomEggItem::new, new Item.Settings().maxCount(16).component(ModDataComponentTypes.CLUCKSHROOM_VARIANT, CluckshroomEntity.Variant.RED));
    public static final Item UMAMI_EGG = register("umami_egg", CluckshroomEggItem::new, new Item.Settings().maxCount(16).component(ModDataComponentTypes.CLUCKSHROOM_VARIANT, CluckshroomEntity.Variant.BROWN));

    private static Item.Settings createFloralMilkSettings(ConsumableComponent component) {
        return new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).component(DataComponentTypes.CONSUMABLE, component).useRemainder(Items.GLASS_BOTTLE).maxCount(1);
    }

    public static final Item CARVED_WHITE_PUMPKIN = Items.register(
            ModPumpkinBlocks.CARVED_WHITE_PUMPKIN,
            (UnaryOperator<Item.Settings>)(settings -> settings.component(
                    DataComponentTypes.EQUIPPABLE,
                    EquippableComponent.builder(EquipmentSlot.HEAD).swappable(false).cameraOverlay(Identifier.of(CombinedWorldgen.MOD_ID, "misc/white_pumpkinblur")).build()
            ))
    );

    public static final Item CARVED_GREEN_PUMPKIN = Items.register(
            ModPumpkinBlocks.CARVED_GREEN_PUMPKIN,
            (UnaryOperator<Item.Settings>)(settings -> settings.component(
                    DataComponentTypes.EQUIPPABLE,
                    EquippableComponent.builder(EquipmentSlot.HEAD).swappable(false).cameraOverlay(Identifier.of(CombinedWorldgen.MOD_ID,"misc/green_pumpkinblur")).build()
            ))
    );

    public static final Item ORANGE = register("orange", new Item.Settings().food(ModFoodComponents.ORANGE));
    public static final Item CHOCOLATE_ORANGE = register("chocolate_orange", new Item.Settings().food(ModFoodComponents.CHOCOLATE_ORANGE));
    public static final Item ORANGE_JUICE = register("orange_juice",
            new Item.Settings()
                    .recipeRemainder(Items.GLASS_BOTTLE)
                    .food(ModFoodComponents.ORANGE_JUICE, ModFoodComponents.ORANGE_JUICE_EFFECTS)
                    .useRemainder(Items.GLASS_BOTTLE)
                    .maxCount(16));

    /* CACTUS */
    public static final Item CACTUS_PAD = register("cactus_pad", new Item.Settings().food(ModFoodComponents.CACTUS_PAD));
    public static final Item COOKED_CACTUS_PAD = register("cooked_cactus_pad", new Item.Settings().food(ModFoodComponents.COOKED_CACTUS_PAD));
    public static final Item CACTUS_SALAD = register("cactus_salad", new Item.Settings().food(ModFoodComponents.CACTUS_SALAD).useRemainder(Items.BOWL));

    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }

    public static Item registerSignItem(String path, Block sign, Block wallSign) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CombinedWorldgen.MOD_ID, path));
        final Item item = new SignItem(sign, wallSign, new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static Item registerHangingSignItem(String path, Block hangingSign, Block hangingWallSign) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CombinedWorldgen.MOD_ID, path));
        final Item item = new HangingSignItem(hangingSign, hangingWallSign, new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    private static Item register(String path, Function<Item.Settings, Item> factory) {
        return register(path, factory, new Item.Settings());
    }

    private static Item register(String path, Item.Settings settings) {
        return register(path, Item::new, settings);
    }

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final Identifier identifier = Identifier.of(CombinedWorldgen.MOD_ID, path);
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, identifier);

        return Items.register(registryKey, factory, settings);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.SNOW_GOLEM_SPAWN_EGG, ModItems.WHITE_PUMPKIN_SNOW_GOLEM_SPAWN_EGG);
                    itemGroup.addAfter(Items.SNOW_GOLEM_SPAWN_EGG, ModItems.GREEN_PUMPKIN_SNOW_GOLEM_SPAWN_EGG);
                    itemGroup.addBefore(Items.MOOSHROOM_SPAWN_EGG, ModItems.MOOBLOOM_SPAWN_EGG);
                    itemGroup.addBefore(Items.COD_SPAWN_EGG, ModItems.CLUCKSHROOM_SPAWN_EGG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.APPLE, ModItems.CHOCOLATE_ORANGE);
                    itemGroup.addAfter(Items.APPLE, ModItems.ORANGE_JUICE);
                    itemGroup.addAfter(Items.APPLE, ModItems.ORANGE);
                    itemGroup.addAfter(Items.DRIED_KELP, ModItems.COOKED_CACTUS_PAD);
                    itemGroup.addAfter(Items.DRIED_KELP, ModItems.CACTUS_PAD);
                    itemGroup.addAfter(Items.RABBIT_STEW, ModItems.CACTUS_SALAD);

                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.WITHER_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.HASTE_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.POISON_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.JUMP_BOOST_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.REGENERATION_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.WEAKNESS_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.FIRE_RESISTANCE_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.NIGHT_VISION_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.NAUSEA_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.BLINDNESS_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.SATURATION_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE);

                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.WITHER_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.HASTE_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.POISON_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.JUMP_BOOST_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.REGENERATION_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.WEAKNESS_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.FIRE_RESISTANCE_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.NIGHT_VISION_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.NAUSEA_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.BLINDNESS_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.SATURATION_FLORAL_MILK_BOTTLE);
                    itemGroup.addAfter(Items.MILK_BUCKET, ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BLUE_EGG, ModItems.UMAMI_EGG);
                    itemGroup.addAfter(Items.BLUE_EGG, ModItems.SPOTTED_EGG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.BLUE_EGG, ModItems.UMAMI_EGG);
                    itemGroup.addAfter(Items.BLUE_EGG, ModItems.SPOTTED_EGG);
                });

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isIn(ModTags.Items.FLORAL_MILK)) {
                list.add(Text.of(""));
                list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle.tooltip").formatted(Formatting.DARK_PURPLE));
                if (itemStack.isOf(ModItems.REMOVE_LONGEST_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_remove_longest.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.WITHER_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_wither.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.HASTE_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_haste.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.POISON_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_poison.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.JUMP_BOOST_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_jump_boost.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.REGENERATION_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_regeneration.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.WEAKNESS_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_weakness.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.FIRE_RESISTANCE_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_fire_resistance.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.NIGHT_VISION_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_night_vision.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.NAUSEA_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_nausea.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.BLINDNESS_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_blindness.tooltip").formatted(Formatting.RED));
                if (itemStack.isOf(ModItems.SATURATION_FLORAL_MILK_BOTTLE))
                    list.add(Text.translatable("item.combined-worldgen.floral_milk_bottle_saturation.tooltip").formatted(Formatting.RED));
            }
        });
    }
}
