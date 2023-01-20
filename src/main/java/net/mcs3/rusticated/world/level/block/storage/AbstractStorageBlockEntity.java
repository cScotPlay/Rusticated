package net.mcs3.rusticated.world.level.block.storage;

import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StoragePreconditions;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.storage.TransferVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.ResourceAmount;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.fabricmc.fabric.api.transfer.v1.transaction.base.SnapshotParticipant;
import net.mcs3.rusticated.util.FastBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

public abstract class AbstractStorageBlockEntity<T extends TransferVariant<?>> extends FastBlockEntity implements Storage<T>, StorageView<T>
{
    protected T resource;
    protected long amount;
    private long version;

    private final ResourceParticipant participant = new ResourceParticipant();

    public AbstractStorageBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        resource = getBlankResource();
    }

    public void onChanged() {
        version++;
        setChanged();
        if (!level.isClientSide)
            sync();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Override
    public boolean supportsExtraction() {
        return true;
    }

    @Override
    public long insert(T resource, long maxAmount, TransactionContext transaction) {
        StoragePreconditions.notBlankNotNegative(resource, maxAmount);
        if (this.resource.isBlank() || this.resource.equals(resource)) {
            long inserted = Math.min(maxAmount, getCapacityForResource(resource) - amount);
            if (inserted > 0) {
                participant.updateSnapshots(transaction);
                amount += inserted;
                this.resource = resource;
            }
            return inserted;
        }
        return 0;
    }

    @Override
    public long extract(T resource, long maxAmount, TransactionContext transaction) {
        StoragePreconditions.notBlankNotNegative(resource, maxAmount);
        if (resource.equals(this.resource)) {
            long extracted = Math.min(maxAmount, amount);
            if (extracted > 0) {
                participant.updateSnapshots(transaction);
                amount -= extracted;
                if (amount == 0) {
                    this.resource = getBlankResource();
                }
            }
            return extracted;
        }
        return 0;
    }

    @Override
    public boolean isResourceBlank() {
        return getResource().isBlank();
    }

    public abstract T getBlankResource();

    @Override
    public T getResource() {
        return resource;
    }

    @Override
    public long getAmount() {
        return amount;
    }

    public boolean isEmpty() {
        return amount == 0;
    }

    @Override
    public long getVersion() {
        return version;
    }

    @Override
    public long getCapacity() {
        return this.getCapacityForResource(resource);
    }

    public abstract long getCapacityForResource(T resource);

    @Override  //TODO IteratorLook at if this is needed for storage blocks
    public Iterator<StorageView<T>> iterator() {
        return null;
    }
//
//    @Override
//    public Iterator<StorageView<T>> iterator(TransactionContext transaction) {
//        return SingleViewIterator.create(this, transaction);
//    }



    private class ResourceParticipant extends SnapshotParticipant<ResourceAmount<T>> {
        @Override
        protected ResourceAmount<T> createSnapshot() {
            return new ResourceAmount<>(resource, amount);
        }

        @Override
        protected void readSnapshot(ResourceAmount<T> snapshot) {
            resource = snapshot.resource();
            amount = snapshot.amount();
        }

        @Override
        protected void onFinalCommit() {
            onChanged();
        }
    }
}
