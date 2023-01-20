package net.mcs3.rusticated.world.item.alchmey;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.util.NbtUtility;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ElixirItem extends Item {
    public ElixirItem() {
        super(new Item.Properties().stacksTo(16).tab(Rusticated.ITEMGROUPHERB));
    }

    @Override
    public ItemStack getDefaultInstance() {
        return PotionUtils.setPotion(super.getDefaultInstance(), Elixirs.HEALING_ELIXIR);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Player player;
        Player player2 = player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
        }
        if (!level.isClientSide) {
            List<MobEffectInstance> list = PotionUtils.getMobEffects(stack);
            for (MobEffectInstance mobEffectInstance : list) {
                if (mobEffectInstance.getEffect().isInstantenous()) {
                    mobEffectInstance.getEffect().applyInstantenousEffect(player, player, livingEntity, mobEffectInstance.getAmplifier(), 1.0);
                    continue;
                }
                livingEntity.addEffect(new MobEffectInstance(mobEffectInstance));
            }
        }
        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
        if (player == null || !player.getAbilities().instabuild) {
            if (stack.isEmpty()) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }
            if (player != null) {
                player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE));
            }
        }
        livingEntity.gameEvent(GameEvent.DRINK);
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        return ItemUtils.startUsingInstantly(level, player, usedHand);
    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        return PotionUtils.getPotion(stack).getName(this.getDescriptionId() + ".effect.");
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        PotionUtils.addPotionTooltip(stack, tooltipComponents, 1.0f);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return super.isFoil(stack) || !PotionUtils.getMobEffects(stack).isEmpty();
    }

    public static String getCategory(ItemStack stack)
    {
        return NbtUtility.getString(stack, "elixir");
    }

    @NotNull
    public static String getSubtype(ItemStack stack) {
        return stack.hasTag() ? NbtUtility.getString(stack, "elixir", "none") : "none";
    }

    @Override
    public void fillItemCategory(CreativeModeTab category, NonNullList<ItemStack> items) {
        if (this.allowedIn(category)) {
            for (Potion potion : Elixirs.ELIXIRS) {
                if (potion == Potions.EMPTY) continue;{
                    items.add(PotionUtils.setPotion(new ItemStack(this), potion));
                }

            }
        }
    }


}
