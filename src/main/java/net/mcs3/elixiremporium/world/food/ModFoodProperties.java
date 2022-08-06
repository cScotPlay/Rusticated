package net.mcs3.elixiremporium.world.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodProperties
{
    public static final FoodProperties OLIVES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 0.95F).build();
    public static final FoodProperties IRONBERRIES = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 15), 0.95F)
            .effect(new MobEffectInstance(MobEffects.JUMP, 200, 250), 0.95F)
            .alwaysEat().build();
}
