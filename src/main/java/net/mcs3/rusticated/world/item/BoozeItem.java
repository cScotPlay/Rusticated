package net.mcs3.rusticated.world.item;

import net.mcs3.rusticated.world.effect.BoozeEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BoozeItem extends Item {
    public float fluidQuality;
    private float inebriationChance = 0.5F;
    private Fluid fluidType;
    public BoozeItem(Properties properties, Fluid inputFluid) {
        super(properties);
        this.fluidType = inputFluid;
    }

    public boolean isEdible() {
        return false;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        super.finishUsingItem(stack, level, livingEntity);
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
        }
        float brewedQuality = stack.getOrCreateTag().getFloat("rusticated.fluid_quality");

        if (!level.isClientSide) {
            BoozeEffects.drinkBooze(livingEntity, stack, brewedQuality);
            BoozeEffects.inebriate(level, livingEntity, inebriationChance, brewedQuality);
            stack.shrink(1);

        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        }
        if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
            ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
            Player player = (Player)livingEntity;
            if (!player.getInventory().add(itemStack)) {
                player.drop(itemStack, false);
            }
        }
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 40;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.WITCH_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.WITCH_DRINK;
    }

    public void addCompoundTag(ItemStack stack, float quality) {
        CompoundTag qualityTag = new CompoundTag();
        qualityTag.putFloat("rusticated.result_quality", quality);
        stack.setTag(qualityTag);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level level, Player player) {
        super.onCraftedBy(stack, level, player);
        addCompoundTag(stack, fluidQuality);
    }

    public Fluid getFluidType() {return this.fluidType;}

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        return ItemUtils.startUsingInstantly(level, player, usedHand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        float fluid_quality = stack.getOrCreateTag().getFloat("rusticated.fluid_quality");

        MutableComponent amountQuality = Component.translatable("tooltip.rusticated.primer.quality", fluid_quality);
        tooltipComponents.add(amountQuality.withStyle(ChatFormatting.GOLD));
    }
}
