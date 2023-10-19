package net.mcs3.rusticated.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class TipsyEffect extends MobEffect {
    private LivingEntity player;
    protected TipsyEffect(MobEffectCategory mobEffectCategory, int i) {
        super(mobEffectCategory, i);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if(livingEntity != null && !livingEntity.level().isClientSide && amplifier > 1) {
            MobEffectInstance confusion = livingEntity.getEffect(MobEffects.CONFUSION);
            MobEffectInstance blindness = livingEntity.getEffect(MobEffects.BLINDNESS);
            MobEffectInstance slowdown = livingEntity.getEffect(MobEffects.MOVEMENT_SLOWDOWN);
            MobEffectInstance tipsy = livingEntity.getEffect(ModEffects.TIPSY);

            if(confusion != null) livingEntity.removeEffect(MobEffects.CONFUSION);
            if(blindness != null) livingEntity.removeEffect(MobEffects.BLINDNESS);

            if(amplifier > 2) {
                if(slowdown != null) livingEntity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, 1, false, false, false));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 600, 0, false, false, false));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 1, false, false, false));
                if(tipsy != null) livingEntity.removeEffect(ModEffects.TIPSY);

            } else {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 0, false, false, false));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 400, 0, false, false, false));
                if(tipsy != null) livingEntity.removeEffect(ModEffects.TIPSY);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {

        if(amplifier > 2) {
            for(int i = 600; i > 0; i--){
                return i % 1 == 0;
            }
        }
        else if (amplifier <= 2 && amplifier >= 1){
            for(int i = 400; i > 0; i--){
                return i % 1 == 0;
            }
        }
        return false;
    }
}
