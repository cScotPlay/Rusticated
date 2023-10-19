package net.mcs3.rusticated.world.level.block.storage.barrel;

import net.mcs3.rusticated.world.ModContainer;
import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class BarrelEntityBlock extends RandomizableContainerBlockEntity implements MenuProvider, ModContainer {

    private NonNullList<ItemStack> inventory = NonNullList.withSize(27, ItemStack.EMPTY);

    public BarrelEntityBlock(BlockPos blockPos, BlockState blockState) {
        this(ModBlockEntityTypes.BARREL_CONTAINER, blockPos, blockState);
    }

    protected BarrelEntityBlock(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.inventory = items;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return ChestMenu.threeRows(i, inventory, this);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.rusticated.storage_barrel");
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.rusticated.storage_barrel");
    }

    public void load(CompoundTag tag) {
        super.load(tag);
        this.loadFromTag(tag);
    }

    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (!this.trySaveLootTable(tag)) {
            ContainerHelper.saveAllItems(tag, this.inventory, false);
        }
    }

    public void loadFromTag(CompoundTag tag) {
        this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(tag) && tag.contains("Items", 9)) {
            ContainerHelper.loadAllItems(tag, this.inventory);
        }
    }

//    private NonNullList<ItemStack> inventory = NonNullList.withSize(27, ItemStack.EMPTY);
//
//    public BarrelEntityBlock(BlockPos blockPos, BlockState blockState) {
//        super(ModBlockEntityTypes.BARREL_CONTAINER, blockPos, blockState);
//    }
//
//    @Override
//    public NonNullList<ItemStack> getItems() {
//        return inventory;
//    }
//
//    @Override
//    protected void setItems(NonNullList<ItemStack> itemStacks) {
//        this.inventory = itemStacks;
//    }
//
//    @Override
//    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
//        return ChestMenu.threeRows(i, inventory, this);
//    }
//
//    @Override
//    public Component getDisplayName() {
//        return Component.translatable("block.rusticated.storage_barrel");
//    }
//
//    @Override
//    protected Component getDefaultName() {
//        return Component.translatable("block.rusticated.storage_barrel");
//    }
//
//    @Override
//    public void load(CompoundTag tag) {
//        super.load(tag);
//        ContainerHelper.loadAllItems(tag, inventory);
//
//    }
//
//    @Override
//    protected void saveAdditional(CompoundTag tag) {
//        ContainerHelper.saveAllItems(tag, inventory);
//        super.saveAdditional(tag);
//    }
}
