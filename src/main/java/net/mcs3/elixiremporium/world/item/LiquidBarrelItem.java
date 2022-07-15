package net.mcs3.elixiremporium.world.item;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantItemStorage;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.util.FluidUtility;
import net.mcs3.elixiremporium.util.NbtUtility;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class LiquidBarrelItem extends BlockItem
{
    public final long capacity;

    public LiquidBarrelItem(Block block, long capacity) {
        super(block, new Item.Properties().tab(ElixirEmporium.ITEMGROUPDECO));
        this.capacity = FluidConstants.BUCKET * capacity;
    }

    public void registerItemApi() {
        FluidStorage.ITEM.registerForItems(LiquidBarrelItemStorage::new, this);
    }

    public boolean isEmpty(ItemStack stack) {
        return stack.getTagElement("BlockEntityTag") == null;
    }

    public FluidVariant getFluid(ItemStack stack) {
        return NbtUtility.getFluidCompatible(stack.getTagElement("BlockEntityTag"), "fluid");
    }

    private void setFluid(ItemStack stack, FluidVariant fluid) {
        NbtUtility.putFluid(stack.getOrCreateTagElement("BlockEntityTag"), "fluid", fluid);
    }

    public long getAmount(ItemStack stack) {
        if (getFluid(stack).isBlank()) {
            return 0;
        }
        CompoundTag tag = stack.getTagElement("BlockEntityTag");
        if (tag == null)
            return 0;
        else
            return tag.getLong("amt");
    }

    private void setAmount(ItemStack stack, long amount) {
        stack.getOrCreateTagElement("BlockEntityTag").putLong("amt", amount);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag context) {
        if (isEmpty(stack)) {
            tooltip.addAll(FluidUtility.getTooltipForFluidStorage(FluidVariant.blank(), 0, capacity));
        } else {
            tooltip.addAll(FluidUtility.getTooltipForFluidStorage(getFluid(stack), getAmount(stack), capacity));
        }
    }

    class LiquidBarrelItemStorage extends SingleVariantItemStorage<FluidVariant> {
        public LiquidBarrelItemStorage(ItemStack stack, ContainerItemContext context) {
            super(context);
        }

        @Override
        protected FluidVariant getBlankResource() {
            return FluidVariant.blank();
        }

        @Override
        protected FluidVariant getResource(ItemVariant currentVariant) {
            return getFluid(currentVariant.toStack());
        }

        @Override
        protected long getAmount(ItemVariant currentVariant) {
            return LiquidBarrelItem.this.getAmount(currentVariant.toStack());
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return capacity;
        }

        @Override
        protected ItemVariant getUpdatedVariant(ItemVariant currentVariant, FluidVariant newResource, long newAmount) {
            // TODO: Note that any enchantment or custom name is nuked, fix this?
            ItemStack stack = new ItemStack(currentVariant.getItem());
            if (!newResource.isBlank() && newAmount > 0) {
                setFluid(stack, newResource);
                setAmount(stack, newAmount);
            }
            return ItemVariant.of(stack);
        }
    }
}
