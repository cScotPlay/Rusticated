package net.mcs3.rusticated.world.inventory.slots;

import net.mcs3.rusticated.world.item.FluidBottleItem;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModBucketBottleSlot extends Slot {
    public ModBucketBottleSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }
    @Override
    public boolean mayPlace(ItemStack stack) {
        return mayPlaceItem(stack);
    }

    public static boolean mayPlaceItem(ItemStack stack) {
        return stack.getItem() instanceof BucketItem || stack.getItem() instanceof FluidBottleItem || stack.is(Items.GLASS_BOTTLE);
        //return stack.is(Items.GLASS_BOTTLE);
    }

}
