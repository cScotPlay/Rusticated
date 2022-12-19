package net.mcs3.rusticated.world.level.block.storage.pot;

import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

public record PotToolTipData(ItemVariant variant, long amount, long capacity) implements TooltipComponent
{
}
