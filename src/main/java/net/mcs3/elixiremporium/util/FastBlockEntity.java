package net.mcs3.elixiremporium.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FastBlockEntity extends BlockEntity
{
    public FastBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public void setChanged() {
        if (this.level != null) {
            this.level.blockEntityChanged(this.worldPosition);
        }
    }

    public void sync() {
        if (!(level instanceof ServerLevel serverWorld)) {
            throw new IllegalStateException("Cannot call sync() on the logical client! Did you check world.isClient first?");
        }

        serverWorld.getChunkSource().blockChanged(this.getBlockPos());
    }
}
