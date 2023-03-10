package net.mcs3.rusticated.client.screens.renderer;

import com.google.common.base.Preconditions;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.fluid.FluidStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.*;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.material.Fluids;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

// CREDIT: https://github.com/mezz/JustEnoughItems by mezz (Forge Version)
// HIGHLY EDITED VERSION FOR FABRIC by Kaupenjoe
// Under MIT-License: https://github.com/mezz/JustEnoughItems/blob/1.18/LICENSE.txt
public class FluidStackRenderer implements IIngredientRenderer<FluidStack> {
    private static final NumberFormat nf = NumberFormat.getIntegerInstance();
    public final long capacityMb;
    private final TooltipMode tooltipMode;
    private final int width;
    private final int height;
    private final int fluidQuality;



    enum TooltipMode {
        SHOW_AMOUNT,
        SHOW_AMOUNT_AND_CAPACITY,
        ITEM_LIST,
        SHOW_QUALITY
    }

    public FluidStackRenderer() {
        this(FluidStack.convertDropletsToMb(FluidConstants.BUCKET), TooltipMode.SHOW_AMOUNT_AND_CAPACITY, 16, 16);
    }

    public FluidStackRenderer(long capacityMb, boolean showCapacity, int width, int height) {
        this(capacityMb, showCapacity ? TooltipMode.SHOW_AMOUNT_AND_CAPACITY : TooltipMode.SHOW_AMOUNT, width, height);
    }

    public FluidStackRenderer(long capacityMb, int width, int height, int fluidQuality) {
        this(capacityMb, TooltipMode.SHOW_QUALITY, width, height, fluidQuality);
    }

    @SuppressWarnings("DeprecatedIsStillUsed")
    @Deprecated
    public FluidStackRenderer(int capacityMb, boolean showCapacity, int width, int height) {
        this(capacityMb, showCapacity ? TooltipMode.SHOW_AMOUNT_AND_CAPACITY : TooltipMode.SHOW_AMOUNT, width, height);
    }

    private FluidStackRenderer(long capacityMb, TooltipMode tooltipMode, int width, int height) {
        Preconditions.checkArgument(capacityMb > 0, "capacity must be > 0");
        Preconditions.checkArgument(width > 0, "width must be > 0");
        Preconditions.checkArgument(height > 0, "height must be > 0");
        this.capacityMb = capacityMb;
        this.tooltipMode = tooltipMode;
        this.width = width;
        this.height = height;
        this.fluidQuality = 0;
    }

    private FluidStackRenderer(long capacityMb, TooltipMode tooltipMode, int width, int height, int fluidQuality) {
        Preconditions.checkArgument(capacityMb > 0, "capacity must be > 0");
        Preconditions.checkArgument(width > 0, "width must be > 0");
        Preconditions.checkArgument(height > 0, "height must be > 0");
        this.capacityMb = capacityMb;
        this.tooltipMode = tooltipMode;
        this.width = width;
        this.height = height;
        this.fluidQuality = fluidQuality;
    }

    /*
     * METHOD FROM https://github.com/TechReborn/TechReborn
     * UNDER MIT LICENSE: https://github.com/TechReborn/TechReborn/blob/1.19/LICENSE.md
     */
    public void drawFluid(PoseStack matrixStack, FluidStack fluid, int x, int y, int width, int height, long maxCapacity) {
        if (fluid.getFluidVariant().getFluid() == Fluids.EMPTY) {
            return;
        }
        RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);
        y += height;
        final TextureAtlasSprite sprite = FluidVariantRendering.getSprite(fluid.getFluidVariant());
        int color = FluidVariantRendering.getColor(fluid.getFluidVariant());

        final int drawHeight = (int) (fluid.getAmount() / (maxCapacity * 1F) * height);
        final int iconHeight = sprite.getHeight();
        int offsetHeight = drawHeight;

        RenderSystem.setShaderColor((color >> 16 & 255) / 255.0F, (float) (color >> 8 & 255) / 255.0F, (float) (color & 255) / 255.0F, 1F);

        int iteration = 0;
        while (offsetHeight != 0) {
            final int curHeight = offsetHeight < iconHeight ? offsetHeight : iconHeight;

            GuiComponent.blit(matrixStack, x, y - offsetHeight, 0, width, curHeight, sprite);
            offsetHeight -= curHeight;
            iteration++;
            if (iteration > 50) {
                break;
            }
        }
        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
    }

    @Override
    public List<Component> getTooltip(FluidStack fluidStack, TooltipFlag tooltipFlag) {
        List<Component> tooltip = new ArrayList<>();

        FluidVariant fluidType = fluidStack.getFluidVariant();
        try {
            if (fluidType == null) {
                return tooltip;
            }

            fluidType.getFluid().defaultFluidState().createLegacyBlock().getBlock().getDescriptionId();

            Component displayName = Component.translatable(fluidType.getFluid().defaultFluidState().createLegacyBlock().getBlock().getDescriptionId());
            tooltip.add(displayName);

            long amount = fluidStack.getAmount();

            if (tooltipMode == TooltipMode.SHOW_AMOUNT_AND_CAPACITY) {
                MutableComponent amountString = Component.translatable("tooltip.rusticated.liquid.amount.with.capacity", nf.format(amount), nf.format(capacityMb));
                tooltip.add(amountString.withStyle(ChatFormatting.GRAY));
            } else if (tooltipMode == TooltipMode.SHOW_AMOUNT) {
                MutableComponent amountString = Component.translatable("tooltip.rusticated.liquid.amount", nf.format(amount));
                tooltip.add(amountString.withStyle(ChatFormatting.GRAY));
            } else if (tooltipMode == TooltipMode.SHOW_QUALITY) {
                MutableComponent amountString = Component.translatable("tooltip.rusticated.liquid.amount.with.capacity", nf.format(amount), nf.format(capacityMb));
                tooltip.add(amountString.withStyle(ChatFormatting.GRAY));
                if(fluidQuality > 0) {
                    MutableComponent amountQuality = Component.translatable("tooltip.rusticated.liquid.quality", (float) fluidQuality / 100);
                    tooltip.add(amountQuality.withStyle(ChatFormatting.GOLD));}
            }
        } catch (RuntimeException e) {
            Rusticated.LOGGER.error("Failed to get tooltip for fluid: " + e);
        }
        return tooltip;
    }

    public List<Component> getFluidTooltip(FluidStack fluidStack, int quality) {
        List<Component> tooltip = new ArrayList<>();

        FluidVariant fluidType = fluidStack.getFluidVariant();
        try {
            if (fluidType == null) {
                return tooltip;
            }

            fluidType.getFluid().defaultFluidState().createLegacyBlock().getBlock().getDescriptionId();

            Component displayName = Component.translatable(fluidType.getFluid().defaultFluidState().createLegacyBlock().getBlock().getDescriptionId());
            tooltip.add(displayName);

            long amount = fluidStack.getAmount();

            MutableComponent amountString = Component.translatable("tooltip.rusticated.liquid.amount.with.capacity", nf.format(amount), nf.format(capacityMb));
            tooltip.add(amountString.withStyle(ChatFormatting.GRAY));
            if(quality > 0) {
                MutableComponent amountQuality = Component.translatable("tooltip.rusticated.liquid.quality", (float) quality / 100);
                tooltip.add(amountQuality.withStyle(ChatFormatting.GOLD));
            }
        } catch (RuntimeException e) {
            Rusticated.LOGGER.error("Failed to get tooltip for fluid: " + e);
        }
        return tooltip;
    }



    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
