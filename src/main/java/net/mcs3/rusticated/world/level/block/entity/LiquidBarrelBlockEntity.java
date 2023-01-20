package net.mcs3.rusticated.world.level.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.ResourceAmount;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.fabricmc.fabric.api.transfer.v1.transaction.base.SnapshotParticipant;
import net.mcs3.rusticated.fluid.FluidStack;
import net.mcs3.rusticated.network.ModNetworkSync;
import net.mcs3.rusticated.util.FastBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LiquidBarrelBlockEntity extends FastBlockEntity implements SingleSlotStorage<FluidVariant> {

    public LiquidBarrelBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.LIQUID_BARREL_CONTAINER, blockPos, blockState);

    }

    public void onChanged() {
        setChanged();
        if (!level.isClientSide)
            sync();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("FluidVariant", fluidStorage.variant.toNbt());
        tag.putLong("FluidLevel", fluidStorage.amount);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.fluidStorage.variant = FluidVariant.fromNbt((CompoundTag) tag.get("FluidVariant"));
        this.fluidStorage.amount = tag.getLong("FluidLevel");
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    private void sendFluidPacket() {
        FriendlyByteBuf data = PacketByteBufs.create();
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeBlockPos(getBlockPos());

        for (ServerPlayer player : PlayerLookup.tracking((ServerLevel) level, getBlockPos())) {
            ServerPlayNetworking.send(player, ModNetworkSync.LIQUID_BARREL_SYNC, data);
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void update() {
        if(this.level == null) return;
        this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
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
                sendFluidPacket();
            }
        }
    };

    public void setFluidLevel(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidStorage.variant = fluidVariant;
        this.fluidStorage.amount = fluidLevel;
    }

    public boolean atCapacity(LiquidBarrelBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= blockEntity.fluidStorage.getCapacity();
    }

    public void transferFluidToFluidStorage(LiquidBarrelBlockEntity entity, FluidVariant fluidVariant, long fluidAmount) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.insert(fluidVariant,
                    FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
            transaction.commit();
            entity.update();
        }
    }

    public void removeFluidFromFluidStorage(LiquidBarrelBlockEntity entity) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(entity.fluidStorage.variant,
                    1000, transaction);
            transaction.commit();
            entity.update();
        }
    }

    @Override
    public long insert(FluidVariant resource, long maxAmount, TransactionContext transaction) {
        return 0;
    }

    @Override
    public long extract(FluidVariant resource, long maxAmount, TransactionContext transaction) {
        return 0;
    }

    @Override
    public boolean isResourceBlank() {
        return this.fluidStorage.isResourceBlank();
    }

    @Override
    public FluidVariant getResource() {
        return fluidStorage.variant;
    }

    @Override
    public long getAmount() {
        return fluidStorage.amount;
    }

    @Override
    public long getCapacity() {
        return this.fluidStorage.getCapacity();
    }
}
