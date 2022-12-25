package net.mcs3.rusticated.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class WitherWardEffect extends MobEffect {
    protected WitherWardEffect(MobEffectCategory mobEffectCategory, int i) {
        super(mobEffectCategory, i);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if(livingEntity != null && !livingEntity.level.isClientSide) {
            MobEffectInstance wither = livingEntity.getEffect(MobEffects.WITHER);
            if(wither != null) {
                livingEntity.removeEffect(MobEffects.WITHER);
            }
        }

    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 1 == 0;
    }
}
