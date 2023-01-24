package net.mcs3.rusticated.world.item;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantItemStorage;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.util.FluidUtility;
import net.mcs3.rusticated.util.NbtUtility;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class JarItem extends BlockItem
{
    public final long capacity;

    public JarItem(Block block, long capacity) {
        super(block, new Item.Properties().tab(Rusticated.ITEMGROUPDECO));
        this.capacity = FluidConstants.BUCKET * capacity;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        InteractionResult interactionResult = this.place(new BlockPlaceContext(context));
        if (!interactionResult.consumesAction() && this.isEdible()) {
            InteractionResult interactionResult2 = this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult();
            return interactionResult2 == InteractionResult.CONSUME ? InteractionResult.CONSUME_PARTIAL : interactionResult2;
        } else {
            return interactionResult;
        }
    }

    public void registerItemApi() {
        FluidStorage.ITEM.registerForItems(JarItem.JarItemStorage::new, this);
    }

    public boolean isEmpty(ItemStack stack) {
        return stack.getTagElement("BlockEntityTag") == null;
    }

    public FluidVariant getFluid(ItemStack stack) {
        return NbtUtility.getFluidCompatible(stack.getTagElement("BlockEntityTag"), "fluidVariant");
    }

    private void setFluid(ItemStack stack, FluidVariant fluid) {
        NbtUtility.putFluid(stack.getOrCreateTagElement("BlockEntityTag"), "fluidVariant", fluid);
    }

    public long getAmount(ItemStack stack) {
        if (getFluid(stack).isBlank()) {
            return 0;
        }
        CompoundTag tag = stack.getTagElement("BlockEntityTag");
        if (tag == null)
            return 0;
        else
            return tag.getLong("fluidLevel");
    }

    private void setAmount(ItemStack stack, long amount) {
        stack.getOrCreateTagElement("BlockEntityTag").putLong("fluidLevel", amount);
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag context) {
        if (isEmpty(stack)) {
            tooltip.addAll(FluidUtility.getTooltipForFluidStorage(FluidVariant.blank(), 0, capacity));
        } else {
            long amount = stack.getOrCreateTagElement("BlockEntityTag").getLong("fluidLevel");
            FluidVariant fluidVariant = FluidVariant.fromNbt((CompoundTag) stack.getOrCreateTagElement("BlockEntityTag").get("fluidVariant"));

            tooltip.add(FluidVariantAttributes.getName(fluidVariant));
            tooltip.add(new TranslatableComponent(amount + " / " + (capacity / 81) + " mB"));

        }
    }

    class JarItemStorage extends SingleVariantItemStorage<FluidVariant> {
        public JarItemStorage(ItemStack stack, ContainerItemContext context) {
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
            return JarItem.this.getAmount(currentVariant.toStack());
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
