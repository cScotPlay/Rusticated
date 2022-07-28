package net.mcs3.elixiremporium.world.level.block.storage.pot;

import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.mcs3.elixiremporium.world.level.block.storage.AbstractStorageBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PotEntityBlock extends AbstractStorageBlockEntity<ItemVariant>
{
    private final long stackCapacity;

    public PotEntityBlock(BlockEntityType<?> type, BlockPos pos, BlockState state, int stackCapacity) {
        super(type, pos, state);
        this.stackCapacity = stackCapacity;
    }

    @Override
    public ItemVariant getBlankResource() {
        return ItemVariant.blank();
    }

    @Override
    public long getCapacityForResource(ItemVariant resource) {
        return stackCapacity * resource.getItem().getMaxStackSize();
    }

    @Override
    public void load(CompoundTag tag) {
        resource = ItemVariant.fromNbt(tag.getCompound("item"));
        amount = tag.getLong("amt");
        if (resource.isBlank()) {
            amount = 0;
        }
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        tag.put("item", resource.toNbt());
        tag.putLong("amt", amount);
    }
}
