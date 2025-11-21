package bluesteel42.combinedworldgen.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.RemoveEffectsConsumeEffect;

public class ModFoodComponents {
    public static final FoodComponent ORANGE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build();
    public static final FoodComponent CHOCOLATE_ORANGE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final ConsumableComponent ORANGE_JUICE_EFFECTS = ConsumableComponents.drink().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 0))).build();
    public static final FoodComponent ORANGE_JUICE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.1F).alwaysEdible().build();

    public static final FoodComponent CACTUS_PAD = new FoodComponent.Builder().nutrition(1).saturationModifier(0.3F).build();
    public static final FoodComponent COOKED_CACTUS_PAD = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3F).build();
    public static final FoodComponent CACTUS_SALAD = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6F).build();

    public static final ConsumableComponent FLORAL_MILK_REMOVE_LONGEST = ConsumableComponents.drink().consumeEffect(RemoveLongestEffectConsumeEffect.INSTANCE).build();
    public static final ConsumableComponent FLORAL_MILK_FIRE_RESISTANCE = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.FIRE_RESISTANCE)).build();
    public static final ConsumableComponent FLORAL_MILK_BLINDNESS = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.BLINDNESS)).build();
    public static final ConsumableComponent FLORAL_MILK_SATURATION = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.SATURATION)).build();
    public static final ConsumableComponent FLORAL_MILK_JUMP_BOOST = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.JUMP_BOOST)).build();
    public static final ConsumableComponent FLORAL_MILK_POISON = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.POISON)).build();
    public static final ConsumableComponent FLORAL_MILK_REGENERATION = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.REGENERATION)).build();
    public static final ConsumableComponent FLORAL_MILK_NIGHT_VISION = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.NIGHT_VISION)).build();
    public static final ConsumableComponent FLORAL_MILK_WEAKNESS = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.WEAKNESS)).build();
    public static final ConsumableComponent FLORAL_MILK_WITHER = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.WITHER)).build();
    public static final ConsumableComponent FLORAL_MILK_NAUSEA = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.NAUSEA)).build();
    public static final ConsumableComponent FLORAL_MILK_HASTE = ConsumableComponents.drink().consumeEffect(new RemoveEffectsConsumeEffect(StatusEffects.HASTE)).build();

}
