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
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class BarrelEntityBlock extends BlockEntity implements MenuProvider, ModContainer
{
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(27, ItemStack.EMPTY);

    public BarrelEntityBlock(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.BARREL_CONTAINER, blockPos, blockState);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return ChestMenu.threeRows(i, inventory, this);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.rusticated.storage_barrel");
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, inventory);

    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        ContainerHelper.saveAllItems(tag, inventory);
        super.saveAdditional(tag);
    }
}
