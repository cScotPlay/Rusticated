package net.mcs3.rusticated.world.item;

import net.mcs3.rusticated.world.effect.BoozeEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OliveOilFoodItem extends Item {
    private int nutrition;
    private float saturation;
    public OliveOilFoodItem(Properties properties) {
        super(properties);
        this.nutrition = getFoodProperties().getNutrition();
        this.saturation = getFoodProperties().getSaturationModifier();
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        super.finishUsingItem(stack, level, livingEntity);
        Player playerEntity = (Player) livingEntity;
        float updatedSaturation = saturation * 2F;

        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
        }

        if (!level.isClientSide && this.isEdible()) {
            playerEntity.getFoodData().eat(nutrition, updatedSaturation);
            stack.shrink(1);
        }

        return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        MutableComponent amountQuality = Component.translatable("tooltip.rusticated.oiled_food");
        tooltipComponents.add(amountQuality.withStyle(ChatFormatting.GREEN));
    }
}
