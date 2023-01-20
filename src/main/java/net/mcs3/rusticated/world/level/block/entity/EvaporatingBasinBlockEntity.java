package net.mcs3.rusticated.world.level.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.fluid.FluidStack;
import net.mcs3.rusticated.network.ModNetworkSync;
import net.mcs3.rusticated.util.FastBlockEntity;
import net.mcs3.rusticated.world.ModContainer;
import net.mcs3.rusticated.world.item.crafting.EvaporatingBasinRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class EvaporatingBasinBlockEntity extends FastBlockEntity implements ModContainer {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);

    protected final ContainerData dataAccess;
    private int progress = 0;
    private int maxProgress = 124;


    public EvaporatingBasinBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.EVAPORATING_BASIN_CONTAINER, blockPos, blockState);
        this.dataAccess = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: {
                        return EvaporatingBasinBlockEntity.this.progress;
                    }
                    case 1: {
                        return EvaporatingBasinBlockEntity.this.maxProgress;
                    }
                }
                return 0;
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: {
                        EvaporatingBasinBlockEntity.this.progress = value;
                        break;
                    }
                    case 1: {
                        EvaporatingBasinBlockEntity.this.maxProgress = value;
                        break;
                    }
                }
            }
            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, EvaporatingBasinBlockEntity blockEntity) {

        if(hasRecipeFluid(blockEntity)) {
            if(blockEntity.fluidStorage.amount >= 0) {
                evaporateFluid(blockEntity, blockEntity.fluidStorage.variant.getFluid());
                blockEntity.progress++;
                if(blockEntity.progress == blockEntity.maxProgress) {
                    createEvaporatedItems(blockEntity);
                }
            }
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean hasRecipeFluid(EvaporatingBasinBlockEntity blockEntity) {
        Level level = blockEntity.level;
        Container container = new SimpleContainer(1);
        Fluid fluid = blockEntity.fluidStorage.variant.getFluid();
        ItemStack fluidBucket = new ItemStack(fluid.getBucket());

        container.setItem(0, fluidBucket);

        Optional<EvaporatingBasinRecipe> match = level.getRecipeManager().getRecipeFor(EvaporatingBasinRecipe.Type.INSTANCE, container, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(blockEntity)
                && canInsertItemIntoOutputSlot(blockEntity, match.get().getResultItem());
    }

    private static void createEvaporatedItems(EvaporatingBasinBlockEntity blockEntity) {
        Level level = blockEntity.level;
        Container container = new SimpleContainer(1);
        Fluid fluid = blockEntity.fluidStorage.variant.getFluid();
        ItemStack fluidBucket = new ItemStack(fluid.getBucket());

        container.setItem(0, fluidBucket);

        Optional<EvaporatingBasinRecipe> match = level.getRecipeManager().getRecipeFor(EvaporatingBasinRecipe.Type.INSTANCE, container, level);

        if(match.isPresent()) {
            blockEntity.setItem(0, new ItemStack(match.get().getResultItem().getItem(), blockEntity.getItem(0).getCount() + 1));
            blockEntity.resetProgress();
        }

    }
    private static boolean canInsertAmountIntoOutputSlot(Container container)
    {
        return container.getItem(0).getMaxStackSize() > container.getItem(0).getCount();
    }

    private static boolean canInsertItemIntoOutputSlot(Container container, ItemStack resultItem)
    {
        return container.getItem(0).getItem() == resultItem.getItem() || container.getItem(0).isEmpty();
    }

    public ItemStack getRenderStack() {
        return this.getItem(0);
    }

    public void setInventory(NonNullList<ItemStack> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    public void update() {
        if(this.level == null) return;
        this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public void load(CompoundTag tag)
    {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, inventory);
        this.progress = tag.getInt("Progress");
        this.fluidStorage.variant = FluidVariant.fromNbt((CompoundTag) tag.get("FluidVariant"));
        this.fluidStorage.amount = tag.getLong("FluidLevel");
    }

    @Override
    protected void saveAdditional(CompoundTag tag)
    {
        ContainerHelper.saveAllItems(tag, inventory);
        super.saveAdditional(tag);
        tag.putInt("Progress", this.progress);
        tag.put("FluidVariant", fluidStorage.variant.toNbt());
        tag.putLong("FluidLevel", fluidStorage.amount);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void onChanged() {
        setChanged();
        if (!level.isClientSide)
            sync();
    }

    /////FLUID HANDLING///////////
    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return FluidStack.convertDropletsToMb(FluidConstants.BUCKET * 8);  // 8 Buckets or 8000mb of fluid
        }

        @Override
        protected void onFinalCommit() {
            onChanged();
            if(!level.isClientSide()) {
                sendEvaporatingPacket();
            }
        }
    };

    private void sendEvaporatingPacket() {
        FriendlyByteBuf data = PacketByteBufs.create();
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeInt(inventory.size());
        for(int i = 0; i < inventory.size(); i++) {
            data.writeItem(inventory.get(i));
        }
        data.writeBlockPos(getBlockPos());

        for (ServerPlayer player : PlayerLookup.tracking((ServerLevel) level, getBlockPos())) {
            ServerPlayNetworking.send(player, ModNetworkSync.EVAPORATING_SYNC, data);
        }
    }

    public final void onPlayerAddFluid(Fluid fluid) {
        transferFluidToFluidStorage(this, fluid);
    }

    public final void onPlayerRemoveFluid(EvaporatingBasinBlockEntity entity, Fluid fluid)
    {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(FluidVariant.of(fluid),
                    1000, transaction);
            transaction.commit();
        }
    }

    public static void transferFluidToFluidStorage(EvaporatingBasinBlockEntity entity, Fluid fluid) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.insert(FluidVariant.of(fluid),
                    FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
            transaction.commit();

        }
    }

    private static void evaporateFluid(EvaporatingBasinBlockEntity entity, Fluid fluid) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(FluidVariant.of(fluid),
                    1, transaction);
            transaction.commit();
        }
    }

    public void setFluidLevel(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidStorage.variant = fluidVariant;
        this.fluidStorage.amount = fluidLevel;
    }

    public void emptyBasin(EvaporatingBasinBlockEntity entity){
        long getFluid = entity.fluidStorage.amount;
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(FluidVariant.of(entity.fluidStorage.variant.getFluid()),
                    getFluid, transaction);
            transaction.commit();
        }
        entity.resetProgress();
    }

    public boolean canPullFluid(EvaporatingBasinBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= 1000;
    }
}
