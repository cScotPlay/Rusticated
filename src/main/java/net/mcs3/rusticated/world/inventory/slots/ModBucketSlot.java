package net.mcs3.rusticated.world.inventory.slots;

import net.mcs3.rusticated.world.item.BoozeItem;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;

public class ModBucketSlot extends Slot {
    public ModBucketSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }
    @Override
    public boolean mayPlace(ItemStack stack) {
        return mayPlaceItem(stack);
    }

    public static boolean mayPlaceItem(ItemStack stack) {
        return stack.getItem() instanceof BucketItem;
        //return stack.is(Items.GLASS_BOTTLE);
    }

}
