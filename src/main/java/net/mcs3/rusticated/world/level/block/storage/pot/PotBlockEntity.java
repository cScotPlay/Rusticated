package net.mcs3.rusticated.world.level.block.storage.pot;

import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class PotBlockEntity extends RusticatedBaseBlockEntity {

    private int stackCapacity;
    private int containerAmount;
    private long lastClickTime;
    private UUID lastClickUUID;
    private NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);

    public PotBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntityTypes.POT_BLOCK_ENTITY, pos, state);
    }

    public PotBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public PotBlockEntity(BlockPos pos, BlockState state, int stackCapacity) {
        this(ModBlockEntityTypes.POT_BLOCK_ENTITY, pos, state);
        this.stackCapacity = stackCapacity;
    }


    @Override
    public void setChanged() {
        PotBlockEntity.this.markUpdated();
    }

    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    public int getContainerAmount() {
        return containerAmount;
    }

    public int getMaxCapacity() {
        return stackCapacity * this.inventory.get(0).getMaxStackSize();
    }

    public void insertItems(Player player, InteractionHand hand) {
        ItemStack playerItemStack = player.getItemInHand(hand).copy();
        ItemStack containerItemStack = inventory.get(0);
        int totalItemCount = playerItemStack.getCount() + containerAmount;

        if(getLevel() == null) { return; }

        if(playerItemStack.getMaxStackSize() > 1 && !playerItemStack.isEmpty()) {
            /**
             * if item in pots match or is empty
             **/
            if(playerItemStack.getItem().equals(containerItemStack.getItem()) || containerItemStack.isEmpty()) {
                if(totalItemCount <= getMaxCapacity()){
                    if(getLevel().getGameTime() - lastClickTime < 10 && player.getUUID().equals(lastClickUUID)) {
                        for(int i = 0, n = player.getInventory().getContainerSize(); i < n; i++) {
                            ItemStack subStack = player.getInventory().getItem(i).copy();
                            if(subStack.getItem().equals(containerItemStack.getItem())) {
                                if(subStack.getCount() + containerAmount <= getMaxCapacity()){
                                    inventory.set(0, new ItemStack(subStack.getItem()));
                                    containerAmount = containerAmount + subStack.getCount();
                                    player.getInventory().setItem(i, ItemStack.EMPTY);
                                    level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
                                }
                            }
                        }
                    } else {
                        if(!playerItemStack.isEmpty()) {
                            inventory.set(0, new ItemStack(playerItemStack.getItem()));
                            containerAmount = containerAmount + 1;
                            player.setItemInHand(hand, new ItemStack(playerItemStack.getItem(), playerItemStack.getCount() - 1));

                            level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
                        }
                    }
                }
            }
        }
        setChanged();

        lastClickTime = getLevel().getGameTime();
        lastClickUUID = player.getUUID();

    }

    @NotNull
    public ItemStack takeItemsFromContainer(int count) {
        if(inventory.isEmpty()) {
            return ItemStack.EMPTY;
        }

        ItemStack itemStack = inventory.get(0);
        int itemAmount = Math.min(count, containerAmount);

        itemStack.setCount(itemAmount);

        containerAmount = containerAmount - itemAmount;

        if(containerAmount == 0){
            inventory.clear();
            level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        } else {
            inventory.set(0, new ItemStack(itemStack.getItem()));
            level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
        setChanged();

        return itemStack;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.loadFromTag(tag);
        if(this.inventory.isEmpty()) {
            containerAmount = 0;
        }
        containerAmount = tag.getInt("amount");
        stackCapacity = tag.getInt("stackcapacity");
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.inventory, false);
        tag.putInt("amount", containerAmount);
        tag.putInt("stackcapacity", stackCapacity);
    }

    public void loadFromTag(CompoundTag tag) {
        NonNullList.withSize(inventory.size(), ItemStack.EMPTY);
        if(tag.contains("Items", 9)) {
            ContainerHelper.loadAllItems(tag, this.inventory);
        }
    }
}
