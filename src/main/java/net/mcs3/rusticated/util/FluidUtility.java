package net.mcs3.rusticated.util;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.*;
import net.minecraft.world.item.TooltipFlag;

import java.util.ArrayList;
import java.util.List;

public class FluidUtility
{
    public static Component getFluidName(FluidVariant fluid, boolean grayIfEmpty) {
        if (fluid.isBlank()) {
            Style style = grayIfEmpty ? Style.EMPTY.withColor(TextColor.fromRgb(0xa9a9a9)).withItalic(false) : Style.EMPTY;
            return Component.translatable("Empty").setStyle(style);
        } else {
            return FluidVariantAttributes.getName(fluid);
        }
    }

    public static List<Component> getTooltip(FluidVariant fluid, boolean grayIfEmpty) {

        if (fluid.isBlank()) {
            ArrayList<Component> list = new ArrayList();
            list.add(getFluidName(fluid, grayIfEmpty));
            return list;
        }
        return FluidVariantRendering.getTooltip(fluid,
                Minecraft.getInstance().options.advancedItemTooltips ? TooltipFlag.Default.ADVANCED : TooltipFlag.Default.NORMAL);
    }

    public static List<Component> getTooltipForFluidStorage(FluidVariant fluid, long amount, long capacity, boolean grayIfEmpty) {
        List<Component> tooltip = FluidUtility.getTooltip(fluid, grayIfEmpty);
        tooltip.add(FluidUtility.getFluidAmount(amount, capacity));
        return tooltip;
    }

    public static List<Component> getTooltipForFluidStorage(FluidVariant fluid, long amount, long capacity) {
        return getTooltipForFluidStorage(fluid, amount, capacity, true);
    }

    @Environment(EnvType.CLIENT)
    public static MutableComponent getFluidAmount(long amount, long capacity) {
        if (capacity < 100 * FluidConstants.BUCKET || Screen.hasShiftDown()) {
            String text = FluidTextUtility.getUnicodeMillibuckets(amount, false) + " / " + capacity / 81;
            return Component.translatable(text + " mB");
        } else {
            var maxedAmount = TextUtility.getMaxedAmount((double) amount / FluidConstants.BUCKET,
                    (double) capacity / FluidConstants.BUCKET);
            return Component.translatable(maxedAmount.digit() + " / " + maxedAmount.maxDigit() + " " + maxedAmount.unit() + "B");
        }

    }

    @Environment(EnvType.CLIENT)
    public static MutableComponent getFluidAmount(long amount) {
        if (amount < 100 * FluidConstants.BUCKET || Screen.hasShiftDown()) {
            String text = FluidTextUtility.getUnicodeMillibuckets(amount, false);
            return Component.translatable(text + " mB");
        } else {
            var amountUnit = TextUtility.getAmount((double) amount / FluidConstants.BUCKET);
            return Component.translatable(amountUnit.digit() + " " + amountUnit.unit() + "B");
        }
    }

    public static int getColorMinLuminance(int color) {
        int r = (color & 0xFF);
        int g = (color & 0xFF00) >> 8;
        int b = (color & 0xFF0000) >> 16;
        double lum = (0.2126 * r + 0.7152 * g + 0.0722 * b) / 255d;
        if (lum < 0.3) {
            if (lum == 0) {
                return 0x4C4C4C;
            } else {
                r = Math.min((int) (r * 0.3 / lum), 255);
                g = Math.min((int) (g * 0.3 / lum), 255);
                b = Math.min((int) (b * 0.3 / lum), 255);
                return r + (g << 8) + (b << 16);
            }
        } else {
            return color;
        }
    }
}
