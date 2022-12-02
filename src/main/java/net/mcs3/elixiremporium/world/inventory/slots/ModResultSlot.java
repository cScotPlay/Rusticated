package net.mcs3.elixiremporium.world.inventory.slots;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ModResultSlot extends Slot
{
    public ModResultSlot(Container container, int i, int j, int k) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    @Override
    public int getMaxStackSize() {
        return 16;
    }
}
