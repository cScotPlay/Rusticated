package net.mcs3.rusticated.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class RemoveMagicEffect extends MobEffect {
    protected RemoveMagicEffect(MobEffectCategory mobEffectCategory, int i) {
        super(mobEffectCategory, i);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if(livingEntity != null && !livingEntity.level().isClientSide) {
            for(MobEffectInstance mobEffect : livingEntity.getActiveEffects()) {
                if(!mobEffect.getEffect().equals(ModEffects.MAGIC_RESISTANCE) && !mobEffect.getEffect().isBeneficial()) {
                    livingEntity.removeEffect(mobEffect.getEffect());
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 1 == 0;
    }
}
