package net.mcs3.elixiremporium.world.inventory;

import net.mcs3.elixiremporium.fluid.FluidStack;
import net.mcs3.elixiremporium.world.inventory.slots.ModBottleSlot;
import net.mcs3.elixiremporium.world.inventory.slots.ModFuelSlot;
import net.mcs3.elixiremporium.world.inventory.slots.ModResultSlot;
import net.mcs3.elixiremporium.world.level.block.alchemy.AdvCondenserBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;

public class AdvCondenserMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData containerData;
    public FluidStack fluidStack;
    public AdvCondenserBlockEntity blockEntity;

    protected AdvCondenserMenu(int i, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(i, (AdvCondenserBlockEntity) inventory.player.level.getBlockEntity(friendlyByteBuf.readBlockPos()), inventory, new SimpleContainer(6), new SimpleContainerData(6));
    }

    public AdvCondenserMenu(int i, AdvCondenserBlockEntity blockEntity, Inventory inventory, Container container, ContainerData containerData) {
        super(ModMenuTypes.ADV_CONDENSER_MENU_TYPE, i);
        checkContainerSize(container, 6);
        this.container = container;
        container.startOpen(inventory.player);
        this.containerData = containerData;
        this.blockEntity = blockEntity;
        this.fluidStack = new FluidStack(blockEntity.fluidStorage.variant, blockEntity.fluidStorage.amount);

        this.addSlot(new Slot(container, 0, 26, 16));
        this.addSlot(new Slot(container, 1, 26, 36));
        this.addSlot(new Slot(container, 2, 26, 56));
        this.addSlot(new ModBottleSlot(container, 3, 107, 63));
        this.addSlot(new ModFuelSlot(container, 4, 71, 63));
        this.addSlot(new ModResultSlot(container, 5, 107, 35));

        int j;
        for (j = 0; j < 3; ++j) {
            for (int k = 0; k < 9; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }
        for (j = 0; j < 9; ++j) {
            this.addSlot(new Slot(inventory, j, 8 + j * 18, 142));
        }

        addDataSlots(containerData);
    }

    public boolean isCrafting()
    {
        return containerData.get(0) > 0;
    }

    public boolean hasFuel()
    {
        return containerData.get(2) > 0;
    }

    public void setFluid(FluidStack stack) {
        fluidStack = stack;
    }

    public int getScaledProgress()
    {
        int progress = this.containerData.get(0);
        int maxProgress = this.containerData.get(1);
        int progressArrowSize = 55;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getScaledFuelProgress()
    {
        int fuelProgress = this.containerData.get(2);
        int maxFuelProgress = this.containerData.get(3);
        int fuelProgressSize = 14;

        return maxFuelProgress != 0 ? (int)(((float)fuelProgress / (float)maxFuelProgress) * fuelProgressSize) : 0;
    }

    public int getLitProgress() {
        int i = this.containerData.get(3);
        if (i == 0) {
            i = 200;
        }
        return this.containerData.get(2) * 13 / i;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index)
    {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();
            if (index < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(originalStack, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(originalStack, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return newStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }
}
