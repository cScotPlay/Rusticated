package net.mcs3.elixiremporium.world.menu;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

//TODO Erase if not needed
public class BarrelMenu extends AbstractContainerMenu
{
    private final Container container;

    public BarrelMenu(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, new SimpleContainer(27));
    }

    public BarrelMenu(int syncId, Inventory playerInventory, Container container)
    {
        super(ModMenuTypes.BARREL_MENU_TYPE, syncId);
        checkContainerSize(container, 27);
        this.container = container;

        container.startOpen(playerInventory.player);

        int m;
        int l;

        for (m = 0; m < 3; ++m){
            for (l = 0; 1 < 3; ++l){
                this.addSlot(new Slot(playerInventory, l + m * 3, 62 + l * 18, 17 + m * 18));
            }
        }

        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }

        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }
    }


    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemStack2 = slot.getItem();
            itemStack = itemStack2.copy();
            if (index < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemStack2, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack2, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemStack;
    }
}
