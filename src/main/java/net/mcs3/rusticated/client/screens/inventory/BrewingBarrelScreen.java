package net.mcs3.rusticated.client.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.client.screens.renderer.FluidStackRenderer;
import net.mcs3.rusticated.fluid.FluidStack;
import net.mcs3.rusticated.util.MouseUtil;
import net.mcs3.rusticated.world.inventory.BrewingBarrelMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.Optional;

public class BrewingBarrelScreen extends AbstractContainerScreen<BrewingBarrelMenu> {
    private static final ResourceLocation BREWING_GUI_TEXTURE = new ResourceLocation(Rusticated.MOD_ID,"textures/gui/container/brewing.png");
    private FluidStackRenderer primerFluidStackRenderer, inputFluidStackRenderer, resultFluidStackRenderer;
    private static final int[] BUBBLELENGTHS = new int[]{29, 24, 20, 16, 11, 6, 0};

    public BrewingBarrelScreen(BrewingBarrelMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        assignFluidStackRenderer();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    private void assignFluidStackRenderer() {
        primerFluidStackRenderer = new FluidStackRenderer(FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 1,
                16, 16, menu.getPrimerQuality());

        inputFluidStackRenderer = new FluidStackRenderer(FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 8,
                true, 16, 32);

        resultFluidStackRenderer = new FluidStackRenderer(FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 8,
                16, 32, menu.getResultQuality());
    }

    @Override
    protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        renderFluidAreaTooltips(poseStack, mouseX, mouseY, x, y, menu.primerFluidStack, 26, 35, primerFluidStackRenderer, menu.getPrimerQuality());
        renderFluidAreaTooltips(poseStack, mouseX, mouseY, x, y, menu.inputFluidStack, 62, 27, inputFluidStackRenderer, 0);
        renderFluidAreaTooltips(poseStack, mouseX, mouseY, x, y, menu.resultFluidStack, 134, 27, resultFluidStackRenderer, menu.getResultQuality());
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY) {
        int m;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, BREWING_GUI_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);

        if(menu.isBrewing())
        {
            //Draws Progress Arrow in GUI
            blit(poseStack, i + 85, j + 39, 176, 28, menu.getScaledProgress(), 15);
            //Draw + sign
            blit(poseStack, i + 47, j + 38, 176, 43, menu.getScaledProgress() / 4, 10);
            //Draws Bubbles in GUI
            m = menu.getScaledProgress();
//            int n = (int)(28.0f * (1.0f - (float)m / 72.0f));
            int n;
            if ((n = BUBBLELENGTHS[m / 2 % 7]) > 0) {
                this.blit(poseStack, i + 100, j + 14 + 28 - n, 176, 0 - n, 11, n);
            }
        }

        primerFluidStackRenderer.drawFluid(poseStack, menu.primerFluidStack, i + 26, j + 35, 16, 16,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 1);

        inputFluidStackRenderer.drawFluid(poseStack, menu.inputFluidStack, i + 62, j + 27, 16, 32,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 8);

        resultFluidStackRenderer.drawFluid(poseStack, menu.resultFluidStack, i + 134, j + 27, 16, 32,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 8);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTick);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }

    private void renderFluidAreaTooltips(PoseStack pPoseStack, int pMouseX, int pMouseY, int x, int y, FluidStack fluidStack, int offsetX, int offsetY, FluidStackRenderer renderer, int fluidQuality) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, offsetX, offsetY, renderer)) {
            renderTooltip(pPoseStack, renderer.getFluidTooltip(fluidStack, fluidQuality), Optional.empty(),pMouseX - x, pMouseY - y);
        }
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidStackRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }
}
