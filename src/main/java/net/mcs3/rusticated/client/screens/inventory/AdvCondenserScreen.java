package net.mcs3.rusticated.client.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.client.screens.renderer.FluidStackRenderer;
import net.mcs3.rusticated.fluid.FluidStack;
import net.mcs3.rusticated.util.MouseUtil;
import net.mcs3.rusticated.world.inventory.AdvCondenserMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.TooltipFlag;

import java.util.Optional;

public class AdvCondenserScreen extends AbstractContainerScreen<AdvCondenserMenu> {
    private static final ResourceLocation ADV_CONDENSER_GUI_TEXTURE = new ResourceLocation(Rusticated.MOD_ID,"textures/gui/container/advcondenser.png");
    private static final int[] BUBBLELENGTHS = new int[]{29, 24, 20, 16, 11, 6, 0};
    private FluidStackRenderer fluidStackRenderer;

    public AdvCondenserScreen(AdvCondenserMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        assignFluidStackRenderer();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderFluidAreaTooltips(guiGraphics, mouseX, mouseY, x, y, menu.fluidStack, 134, 27, fluidStackRenderer);
    }

    private void renderFluidAreaTooltips(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int x, int y, FluidStack fluidStack, int offsetX, int offsetY, FluidStackRenderer renderer) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, offsetX, offsetY, renderer)) {
            renderTooltip(guiGraphics, pMouseX - x, pMouseY - y);
        }
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int m;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, ADV_CONDENSER_GUI_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(ADV_CONDENSER_GUI_TEXTURE, i, j, 0, 0, this.imageWidth, this.imageHeight);

        if(menu.isCrafting())
        {
            //Draws Progress Arrow in GUI
            guiGraphics.blit(ADV_CONDENSER_GUI_TEXTURE, i + 45, j + 23, 176, 14, menu.getScaledProgress(), 43);
            //Draws Bubbles in GUI
            m = menu.getScaledProgress();
            int n = (int)(28.0f * (1.0f - (float)m / 72.0f));
            if ((n = BUBBLELENGTHS[m / 2 % 7]) > 0) {
                guiGraphics.blit(ADV_CONDENSER_GUI_TEXTURE, i + 74, j + 14 + 28 - n, 176, 85 - n, 11, n);
            }
        }

        if(menu.hasFuel())
        {
            guiGraphics.blit(ADV_CONDENSER_GUI_TEXTURE, i + 71, j + 46 + 14 - menu.getScaledFuelProgress(), 176,
                    14 - menu.getScaledFuelProgress(), 14, menu.getScaledFuelProgress());
        }

        //Draws Fluid in GUI
        fluidStackRenderer.drawFluid(guiGraphics, menu.fluidStack, i + 134, j + 27, 16, 32,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 8);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    private void assignFluidStackRenderer() {
        fluidStackRenderer = new FluidStackRenderer(FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 8,
                true, 16, 32);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidStackRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }
}
