package net.mcs3.rusticated.world.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class BoozeItem extends Item {
    public BoozeItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        super.finishUsingItem(stack, level, livingEntity);
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)livingEntity;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
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

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        return ItemUtils.startUsingInstantly(level, player, usedHand);
    }
}
