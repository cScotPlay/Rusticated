package net.mcs3.elixiremporium.world.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoodProperties
{
    public static final FoodProperties OLIVES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.4F).effect(new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 0.95F).build();
}
