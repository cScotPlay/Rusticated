package net.mcs3.elixiremporium.world.level.block.storage.liquid_barrel;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageUtil;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.mcs3.elixiremporium.util.NbtUtility;
import net.mcs3.elixiremporium.world.level.block.storage.AbstractStorageBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class LiquidBarrelEntityBlock extends AbstractStorageBlockEntity<FluidVariant>
{
    final long capacity;

    public LiquidBarrelEntityBlock(BlockEntityType<?> type, BlockPos blockPos, BlockState blockState, long capacity) {
        super(type, blockPos, blockState);
        this.capacity = FluidConstants.BUCKET * capacity;
    }

    @Override
    public void setChanged() {
        super.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        NbtUtility.putFluid(tag, "fluid", getResource());
        tag.putLong("amt", amount);
    }

    @Override
    public void load(CompoundTag tag) {
        resource = NbtUtility.getFluidCompatible(tag, "fluid");
        amount = tag.getLong("amt");
        if (resource.isBlank()) {
            amount = 0;
        }
    }

    public boolean onPlayerUse(Player player) {
        Storage<FluidVariant> handIo = ContainerItemContext.ofPlayerHand(player, InteractionHand.MAIN_HAND).find(FluidStorage.ITEM);
        if (handIo != null) {
            // move from hand into this tank
            if (StorageUtil.move(handIo, this, f -> true, Long.MAX_VALUE, null) > 0)
                return true;
            // move from this tank into hand
            if (StorageUtil.move(this, handIo, f -> true, Long.MAX_VALUE, null) > 0)
                return true;
        }
        return false;
    }

    @Override
    public FluidVariant getBlankResource() {
        return FluidVariant.blank();
    }

    @Override
    public long getCapacityForResource(FluidVariant resource) {
        return capacity;
    }
}
