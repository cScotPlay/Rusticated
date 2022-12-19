package net.mcs3.rusticated.world.effect;

import net.mcs3.rusticated.Rusticated;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ModEffects {

    private static String MODID = Rusticated.MOD_ID;

    public static MobEffect IRON_SKIN_EFFECT;

    public static MobEffect register(String name, MobEffect effect){
        return Registry.register(Registry.MOB_EFFECT, new ResourceLocation(MODID, name), effect);
    }

    public static void registerEffects() {
        IRON_SKIN_EFFECT = register("ironskin", new ModMobEffect(MobEffectCategory.BENEFICIAL, 16777148)
                .addAttributeModifier(Attributes.ARMOR, "D666C8fD-8AC4-451D-9A06-777947832156", 3f, AttributeModifier.Operation.ADDITION)
                .addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "D774E354-E3AB-42C4-9716-d2280CD7D988", 2f, AttributeModifier.Operation.ADDITION));
    }
}
