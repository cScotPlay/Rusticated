package net.mcs3.elixiremporium.world.item;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantItemStorage;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.util.TextUtility;
import net.mcs3.elixiremporium.world.level.block.storage.pot.PotToolTipData;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Optional;

public class PotItem extends BlockItem implements ItemContainingItemHandler
{
    public final long stackCapacity;

    public PotItem(Block block, long stackCapacity) {
        super(block, new Item.Properties().stacksTo(1).tab(ElixirEmporium.ITEMGROUPDECO));
        this.stackCapacity = stackCapacity;
    }

    @Override
    public long getStackCapacity() {
        return stackCapacity;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag context) {
        Style style = Style.EMPTY.withColor(TextColor.fromRgb(0xa9a9a9)).withItalic(false);
        if (isEmpty(stack)) {
            tooltip.add(new TranslatableComponent("Empty").setStyle(style));
            tooltip.add(new TranslatableComponent("Can store up to " + stackCapacity + " stacks").setStyle(TextUtility.GREEN));
        }
    }

    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        if (!isEmpty(stack)) {
            return Optional.of(new PotToolTipData(getItemVariant(stack), getAmount(stack), getCurrentCapacity(stack)));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stackBarrel, Slot slot, ClickAction clickType, Player player) {
        return handleStackedOnOther(stackBarrel, slot, clickType, player);
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack otherStack, Slot slot, ClickAction clickType, Player player,
                                            SlotAccess cursorStackReference) {
        return handleOtherStackedOnMe(stack, otherStack, slot, clickType, player, cursorStackReference);
    }
}
