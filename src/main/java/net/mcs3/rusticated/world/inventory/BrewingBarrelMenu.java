package net.mcs3.rusticated.world.inventory;

import net.mcs3.rusticated.fluid.FluidStack;
import net.mcs3.rusticated.world.inventory.slots.ModBottleSlot;
import net.mcs3.rusticated.world.inventory.slots.ModBucketSlot;
import net.mcs3.rusticated.world.inventory.slots.ModCupSlot;
import net.mcs3.rusticated.world.inventory.slots.ModResultSlot;
import net.mcs3.rusticated.world.level.block.entity.BrewingBarrelBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;

public class BrewingBarrelMenu extends AbstractContainerMenu {
    private final Container container;
    private final ContainerData containerData;
    public FluidStack inputFluidStack, resultFluidStack, primerFluidStack;
    public BrewingBarrelBlockEntity blockEntity;


    protected BrewingBarrelMenu(int i, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(i, (BrewingBarrelBlockEntity) inventory.player.level.getBlockEntity(friendlyByteBuf.readBlockPos()), inventory, new SimpleContainer(6), new SimpleContainerData(4));
    }

    public BrewingBarrelMenu(int i, BrewingBarrelBlockEntity blockEntity, Inventory inventory, Container container, ContainerData containerData) {
        super(ModMenuTypes.BREWING_BARREL_MENU_TYPE, i);
        checkContainerSize(container, 6);
        this.container = container;
        container.startOpen(inventory.player);
        this.containerData = containerData;
        this.blockEntity = blockEntity;
        this.primerFluidStack = new FluidStack(blockEntity.primerFluidStorage.variant, blockEntity.primerFluidStorage.amount);
        this.inputFluidStack = new FluidStack(blockEntity.inputFluidStorage.variant, blockEntity.inputFluidStorage.amount);
        this.resultFluidStack = new FluidStack(blockEntity.resultFluidStorage.variant, blockEntity.resultFluidStorage.amount);


        this.addSlot(new ModCupSlot(container, 0, 26, 15));
        this.addSlot(new ModBucketSlot(container, 1, 62, 7));
        this.addSlot(new ModBottleSlot(container, 2, 134, 7));
        this.addSlot(new ModResultSlot(container, 3, 26, 55));
        this.addSlot(new ModResultSlot(container, 4, 62, 63));
        this.addSlot(new ModResultSlot(container, 5, 134, 63));

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

    public boolean isBrewing()
    {
        return containerData.get(0) > 0;
    }

    public int getScaledProgress()
    {
        int progress = this.containerData.get(0);
        int maxProgress = this.containerData.get(1);
        int progressArrowSize = 41;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    public int getPrimerQuality() {
        return this.containerData.get(2);
    }

    public int getResultQuality() {
        return this.containerData.get(3);
    }

    public void setInputFluid(FluidStack stack) {
        inputFluidStack = stack;
    }

    public void setResultFluid(FluidStack stack) {
        resultFluidStack = stack;
    }

    public void setPrimerFluid(FluidStack stack) {
        primerFluidStack = stack;
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
