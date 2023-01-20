package net.mcs3.rusticated.world.item;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.util.TextUtility;
import net.mcs3.rusticated.world.level.block.storage.pot.PotToolTipData;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
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
        super(block, new Item.Properties().stacksTo(1).tab(Rusticated.ITEMGROUPDECO));
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
            tooltip.add(Component.translatable("Empty").setStyle(style));
            tooltip.add(Component.translatable("Can store up to " + stackCapacity + " stacks").setStyle(TextUtility.GREEN)); //TODO Look at this for lang file
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
