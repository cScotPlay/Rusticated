package net.mcs3.rusticated.world.level.block.storage.pot.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcs3.rusticated.util.TextUtility;
import net.mcs3.rusticated.world.level.block.storage.pot.PotToolTipData;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import org.joml.Matrix4f;

public record PotTooltipComponent(PotToolTipData data) implements ClientTooltipComponent {

    @Override
    public int getHeight() {
        return 30;
    }

    @Override
    public int getWidth(Font textRenderer) {
        return Math.max(textRenderer.width(data.variant().toStack().getHoverName()), 20 + textRenderer.width(getItemNumber()));
    }

    @Override
    public void renderText(Font textRenderer, int x, int y, Matrix4f matrix4f, MultiBufferSource.BufferSource immediate) {

        Style style = Style.EMPTY.withColor(TextColor.fromRgb(0xa9a9a9)).withItalic(false);

        textRenderer.drawInBatch(data.variant().toStack().getHoverName().copy().setStyle(style), (float) x, (float) y, -1, true, matrix4f, immediate, Font.DisplayMode.NORMAL, 0, 15728880);

        textRenderer.drawInBatch(getItemNumber(), x + 20, y + 15, -1, true, matrix4f, immediate, Font.DisplayMode.NORMAL, 0, 15728880);

    }

    public Component getItemNumber() {
        long maxCount = data.variant().getItem().getMaxStackSize();
        long stackCapacity = data.capacity() / maxCount;
        long amount = data.amount();
        long stackNumber = amount / maxCount;
        long rem = amount % maxCount;

        Component itemNumber;

        if (maxCount == 1 || Screen.hasShiftDown()) {
            itemNumber = Component.translatable("tooltip.rusticated.pot.stacks_numbers", stackNumber, stackCapacity).setStyle(TextUtility.GREEN);
        } else {
            itemNumber = Component.translatable("tooltip.rusticated.pot.percent_stacks", amount, stackCapacity * maxCount, stackCapacity)
                    .setStyle(TextUtility.GREEN);
        }
        return itemNumber;
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        guiGraphics.renderItem(data.variant().toStack(), x, y +10);

//        ClientTooltipComponent.super.renderImage(font, x, y, guiGraphics);
    }

//    @Override
//    public void renderImage(Font font, int x, int y, PoseStack poseStack, ItemRenderer itemRenderer) {
//        itemRenderer.renderGuiItem(poseStack, data.variant().toStack(), x, y + 10);
//
//    }
}
