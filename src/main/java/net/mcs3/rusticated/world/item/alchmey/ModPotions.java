package net.mcs3.rusticated.world.item.alchmey;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.world.effect.ModEffects;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class ModPotions {

    private static String MODID = Rusticated.MOD_ID;

    public static Potion IRON_SKIN;
    public static Potion LONG_IRON_SKIN;
    public static Potion STRONG_IRON_SKIN;
    public static Potion TIPSY;

    public static Potion register(String name, Potion potion){
        return Registry.register(Registry.POTION, new ResourceLocation(MODID, name), potion);
    }

    public static void registerPotions() {
        IRON_SKIN = register("ironskin", new Potion(new MobEffectInstance(ModEffects.IRON_SKIN_EFFECT, 3600)));
        LONG_IRON_SKIN = register("long_ironskin", new Potion(new MobEffectInstance(ModEffects.IRON_SKIN_EFFECT, 9600)));
        STRONG_IRON_SKIN = register("strong_ironskin", new Potion(new MobEffectInstance(ModEffects.IRON_SKIN_EFFECT, 1800, 1)));
    }
}
