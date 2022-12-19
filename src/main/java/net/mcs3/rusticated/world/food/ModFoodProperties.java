package net.mcs3.rusticated.world.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodProperties
{
    public static final FoodProperties OLIVES = new FoodProperties.Builder().nutrition(1).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 0.95F).build();
    public static final FoodProperties IRONBERRIES = new FoodProperties.Builder().nutrition(2).saturationMod(0.4F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.JUMP, 200, 250), 0.95F)
            .alwaysEat().build();
    public static final FoodProperties GRAPES = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties CLOUD_LILY = new FoodProperties.Builder().nutrition(0).saturationMod(0.0F).effect(new MobEffectInstance(MobEffects.LEVITATION, 400, 1), 1F).build();
    public static final FoodProperties CORE_ROOT = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();
    public static final FoodProperties GINSENG = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build();
    public static final FoodProperties MARSHMALLOW = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build();

    public static final FoodProperties OLIVE_OIL = new FoodProperties.Builder().nutrition(1).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 1), 0.95F).build();
    public static final FoodProperties IRONBERRY_JUICE = new FoodProperties.Builder().nutrition(2).saturationMod(0.8F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 600, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 600, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 600, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.JUMP, 600, 250), 0.95F)
            .alwaysEat().build();
    public static final FoodProperties WILDBERRY_JUICE = new FoodProperties.Builder().nutrition(1).saturationMod(1F).effect(new MobEffectInstance(MobEffects.REGENERATION, 75, 1), 0.95F).build();
    public static final FoodProperties GRAPE_JUICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.9F).build();
    public static final FoodProperties APPLE_JUICE = new FoodProperties.Builder().nutrition(1).saturationMod(1.2F).build();
    public static final FoodProperties ALE_WORT = new FoodProperties.Builder().nutrition(1).saturationMod(2F).effect(new MobEffectInstance(MobEffects.CONFUSION, 400, 1), 0.95F).build();
}
