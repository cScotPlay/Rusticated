package net.mcs3.rusticated.world.effect;

import net.mcs3.rusticated.init.ModFluids;
import net.mcs3.rusticated.world.item.BoozeItem;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BoozeEffects {

    public static void drinkBooze(LivingEntity playerEntity, ItemStack itemStack, float fluidQuality) {
        Item boozeItem = itemStack.getItem();

        if (boozeItem instanceof BoozeItem) {
            if(boozeItem == ModFluids.ALE_CUP) {
                if (fluidQuality >= 0.5F) {
                    float saturation = 4F * fluidQuality;
                    ((Player)playerEntity).getFoodData().eat(2, saturation);
                    int duration = (int) (12000 * (Math.max(Math.abs((fluidQuality - 0.5F) * 2F), 0F)));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.SATURATION, duration));
                } else {
                    int duration = (int) (6000 * Math.max(1 - fluidQuality, 0));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, duration));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration));
                }
            }
            else if (boozeItem == ModFluids.CIDER_CUP) {
                if (fluidQuality >= 0.5F) {
                    float saturation = 2F * fluidQuality;
                    ((Player)playerEntity).getFoodData().eat(1, saturation);
                    int duration = (int) (12000 * (Math.max(Math.abs((fluidQuality - 0.5F) * 2F), 0F)));
                    playerEntity.addEffect(new MobEffectInstance(ModEffects.MAGIC_RESISTANCE, duration));
                } else {
                    int duration = (int) (1200 * Math.max(1 - fluidQuality, 0));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.POISON, duration));
                    duration = (int) (6000 * Math.max(1 - fluidQuality, 0));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration));
                }
            }
            else if (boozeItem == ModFluids.IRON_WINE_CUP) {
                if (fluidQuality >= 0.5F) {
                    float saturation = 2F * fluidQuality;
                    float absorption = 10F * (Math.max((fluidQuality - 0.5F) * 2F, 0F));
                    ((Player)playerEntity).getFoodData().eat(1, saturation);
                    playerEntity.setAbsorptionAmount(Math.max(Math.min(playerEntity.getAbsorptionAmount() + absorption, 20F), playerEntity.getAbsorptionAmount()));
                }
                else {
                    int duration = (int) (6000 * Math.max(1 - fluidQuality, 0));
                    float damage = 10F * (Math.max(Math.abs(fluidQuality - 0.5F) + 0.1F, 0F));
                    Level level = playerEntity.level();
                    playerEntity.hurt(level.damageSources().magic(),damage);
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration));
                }
            }
            else if (boozeItem == ModFluids.MEAD_CUP) {
                if (fluidQuality >= 0.5F) {
                    float saturation = 2F * fluidQuality;
                    ((Player)playerEntity).getFoodData().eat(1, saturation);
                    int duration = (int) (6000 * (Math.max(Math.abs((fluidQuality - 0.5F) * 2F), 0F)));
                    playerEntity.addEffect(new MobEffectInstance(ModEffects.WITHER_WARD, duration));
                }
                else {
                    int duration = (int) (800 * Math.max(1 - fluidQuality, 0));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, duration));
                    duration = (int) (6000 * Math.max(1 - fluidQuality, 0));
                    playerEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration));
                }
            }
            else if (boozeItem == ModFluids.SWEET_BERRY_WINE_CUP) {
                if (fluidQuality >= 0.5F) {
                    float saturation = 2F * fluidQuality;
                    ((Player) playerEntity).getFoodData().eat(1, saturation);
                    for (MobEffectInstance effect : playerEntity.getActiveEffects()) {
                        if (effect.getEffect().isBeneficial() && effect.getAmplifier() < 2) {
                            playerEntity.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier() + 1, effect.isAmbient(), effect.isVisible(), effect.showIcon()));
                        }
                    }
                } else {
                    for(MobEffectInstance effect : playerEntity.getActiveEffects()) {
                        if(effect.getEffect().isBeneficial()) {
                            if(effect.getAmplifier()> 0) {
                                playerEntity.removeEffect(effect.getEffect());
                                playerEntity.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier() + 1, effect.isAmbient(), effect.isVisible(), effect.showIcon()));
                            }
                            else if(effect.getAmplifier() == 0) {
                                playerEntity.removeEffect(effect.getEffect());
                            }
                        }
                    }
                }
            }
            else if (boozeItem == ModFluids.WINE_CUP) {
                if (fluidQuality >= 0.5F) {
                    float saturation = 2F * fluidQuality;
                    ((Player) playerEntity).getFoodData().eat(1, saturation);
                    int durationIncrease  = (int) (2400* (Math.max(Math.abs((fluidQuality - 0.5F) * 2F), 0F)));
                    for (MobEffectInstance effect : playerEntity.getActiveEffects()) {
                        if (effect.getEffect().isBeneficial() && effect.getDuration() < 12000) {
                            int duration  =  Math.max(Math.min(effect.getDuration() + durationIncrease, 12000), effect.getDuration());
                            playerEntity.addEffect(new MobEffectInstance(effect.getEffect(), duration, effect.getAmplifier(), effect.isAmbient(), effect.isVisible(), effect.showIcon()));
                        }
                    }
                }
                else {
                    int durationDecrease  = (int) (2400 * (Math.abs(fluidQuality - 0.5)));
                    for (MobEffectInstance effect : playerEntity.getActiveEffects()) {
                        if (effect.getEffect().isBeneficial()) {
                            int duration = effect.getDuration() - durationDecrease;
                            playerEntity.addEffect(new MobEffectInstance(effect.getEffect(), duration, effect.getAmplifier(), effect.isAmbient(), effect.isVisible(), effect.showIcon()));
                        }
                    }
                }
            }
        }

    }

    public static void inebriate(Level level, LivingEntity playerEntity, float inebriationChance, float fluidQuality) {
        int duration = (int) (12000 * (Math.max(1 - Math.abs(fluidQuality - 0.75F), 0F)));
        float inebriationChanceMod = Math.max(Math.min(1 - Math.abs(0.67F * (fluidQuality - 0.75F)), 1), 0);
        MobEffectInstance tipsyEffect = playerEntity.getEffect(ModEffects.TIPSY);
        if (level.random.nextFloat() < inebriationChance * inebriationChanceMod) {
            if (tipsyEffect == null) {
                playerEntity.addEffect(new MobEffectInstance(ModEffects.TIPSY, duration, 0, false, false, true));
            } else {
                int adjustedAmplifier = level.random.nextInt(0, 4);
                playerEntity.addEffect(new MobEffectInstance(ModEffects.TIPSY, duration, adjustedAmplifier, false, false, true));
            }
        }
    }
}
