package net.mcs3.rusticated.world.item;

import com.google.common.base.Preconditions;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.StoragePreconditions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;

public interface ItemContainingItemHandler
{
    long getStackCapacity();

    default boolean canDirectInsert(ItemStack stack) {
        return stack.getItem().canFitInsideContainerItems();
    }

    default boolean isEmpty(ItemStack stack) {
        return stack.getTagElement("BlockEntityTag") == null;
    }

    default ItemVariant getItemVariant(ItemStack stack) {
        if (isEmpty(stack)) {
            return ItemVariant.blank();
        } else {
            return ItemVariant.fromNbt(stack.getTagElement("BlockEntityTag").getCompound("item"));
        }
    }

    private void setItemVariant(ItemStack stack, ItemVariant item) {
        stack.getOrCreateTagElement("BlockEntityTag").put("item", item.toNbt());
    }

    default long insert(ItemStack stackPot, ItemVariant inserted, long maxAmount) {
        StoragePreconditions.notBlankNotNegative(inserted, maxAmount);

        if (this.isEmpty(stackPot) || this.getItemVariant(stackPot).equals(inserted)) {
            long maxInsert = getCapacity(inserted) - getAmount(stackPot);
            long insertedAmount = Math.min(maxAmount, maxInsert);

            if (insertedAmount > 0) {
                setAmount(stackPot, getAmount(stackPot) + insertedAmount);
                setItemVariant(stackPot, inserted);
            }
            return insertedAmount;
        }
        return 0;
    }

    default long getAmount(ItemStack stack) {
        if (getItemVariant(stack).isBlank()) {
            return 0;
        }
        CompoundTag tag = stack.getTagElement("BlockEntityTag");
        if (tag == null)
            return 0;
        else
            return tag.getLong("amt");
    }

    default void setAmount(ItemStack stack, long amount) {
        Preconditions.checkArgument(amount >= 0, "Can not set a pot item to a negative amount");

        stack.getOrCreateTagElement("BlockEntityTag").putLong("amt", amount);
        if (amount == 0) {
            stack.removeTagKey("BlockEntityTag");
        }
    }

    default long getCapacity(ItemVariant variant) {
        return getStackCapacity() * variant.getItem().getMaxStackSize();
    }

    default long getCurrentCapacity(ItemStack barrelStack) {
        return getStackCapacity() * getItemVariant(barrelStack).getItem().getMaxStackSize();
    }

    default boolean handleStackedOnOther(ItemStack stackPot, Slot slot, ClickAction clickType, Player player) {
        if (clickType == ClickAction.SECONDARY && slot.allowModification(player)) {
            Mutable<ItemStack> ref = new MutableObject<>(slot.getItem());
            boolean result = handleClick(stackPot, ref);
            slot.set(ref.getValue());
            return result;
        } else {
            return false;
        }
    }

    default boolean handleOtherStackedOnMe(ItemStack stackPot, ItemStack itemStack, Slot slot, ClickAction clickType, Player player,
                                           SlotAccess cursorStackReference) {
        if (clickType == ClickAction.SECONDARY && slot.allowModification(player)) {
            Mutable<ItemStack> ref = new MutableObject<>(itemStack);
            boolean result = handleClick(stackPot, ref);
            cursorStackReference.set(ref.getValue());
            slot.setChanged();
            return result;
        } else {
            return false;
        }
    }

    private boolean handleClick(ItemStack stackPot, Mutable<ItemStack> otherStack) {
        ItemStack other = otherStack.getValue().copy();
        // Try to put into barrel
        if ((isEmpty(stackPot) || getItemVariant(stackPot).matches(other)) && !other.isEmpty() && canDirectInsert(other)) {
            other.shrink((int) insert(stackPot, ItemVariant.of(other), other.getCount()));
            otherStack.setValue(other);
            return true;
        } else if (!isEmpty(stackPot) && other.isEmpty()) {
            int amount = (int) Math.min(getAmount(stackPot), getItemVariant(stackPot).getItem().getMaxStackSize());
            ItemStack newStack = getItemVariant(stackPot).toStack(amount);
            otherStack.setValue(newStack);
            setAmount(stackPot, getAmount(stackPot) - amount);
            return true;
        } else {
            return !isEmpty(stackPot) || !other.isEmpty();
        }
    }
}
