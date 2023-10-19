package net.mcs3.rusticated.world.level.block.storage.pot;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RusticatedBaseBlockEntity extends BlockEntity {

    public RusticatedBaseBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        writePacketNBT(tag);
    }

    @NotNull
    @Override
    public CompoundTag getUpdateTag() {
        var tag = new CompoundTag();
        writePacketNBT(tag);
        return tag;
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        readPacketNBT(tag);
    }

    public void writePacketNBT(CompoundTag cmp) {}

    public void readPacketNBT(CompoundTag cmp) {}

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    @Override
    public void setChanged() {
        if (this.level != null) {
            this.level.blockEntityChanged(this.worldPosition);
        }
    }

    public void markUpdated() {
        if(this.level != null) {
            this.level.blockEntityChanged(this.worldPosition);
            final BlockState state = this.getBlockState();
            this.level.sendBlockUpdated(this.worldPosition, state, state, Block.UPDATE_ALL);
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.worldPosition, GameEvent.Context.of(state));
            level.updateNeighborsAt(this.worldPosition, this.getBlockState().getBlock());
        }
    }

    public void sync() {
        if (!(level instanceof ServerLevel serverWorld)) {
            throw new IllegalStateException("Cannot call sync() on the logical client! Did you check world.isClient first?");
        }
        serverWorld.getChunkSource().blockChanged(this.getBlockPos());
    }
}
