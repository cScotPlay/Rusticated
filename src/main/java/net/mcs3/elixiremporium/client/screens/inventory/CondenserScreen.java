package net.mcs3.elixiremporium.client.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.client.screens.renderer.FluidStackRenderer;
import net.mcs3.elixiremporium.fluid.FluidStack;
import net.mcs3.elixiremporium.world.inventory.CondenserMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CondenserScreen extends AbstractContainerScreen<CondenserMenu>
{
    private static final ResourceLocation CONDENSER_GUI_TEXTURE = new ResourceLocation(ElixirEmporium.MOD_ID,"textures/gui/container/condenser.png");
    private static final int[] BUBBLELENGTHS = new int[]{29, 24, 20, 16, 11, 6, 0};
    private FluidStackRenderer fluidStackRenderer;

    public CondenserScreen(CondenserMenu abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
        assignFluidStackRenderer();
    }

    @Override //Renders Background
    protected void renderBg(PoseStack poseStack, float partialTick, int mouseX, int mouseY)
    {
        int m;
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, CONDENSER_GUI_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);

        if(menu.isCrafting())
        {
            //Draws Progress Arrow in GUI
            blit(poseStack, i + 45, j + 30, 176, 14, menu.getScaledProgress(), 28);
            //Draws Bubbles in GUI
            m = menu.getScaledProgress();
            int n = (int)(28.0f * (1.0f - (float)m / 72.0f));
            if ((n = BUBBLELENGTHS[m / 2 % 7]) > 0) {
                this.blit(poseStack, i + 74, j + 14 + 28 - n, 176, 71 - n, 11, n);
            }
        }

        if(menu.hasFuel())
        {
            blit(poseStack, i + 71, j + 46 + 14 - menu.getScaledFuelProgress(), 176,
                    14 - menu.getScaledFuelProgress(), 14, menu.getScaledFuelProgress());
        }

        //Draws Fluid in GUI
        fluidStackRenderer.drawFluid(poseStack, menu.fluidStack, i + 134, j + 27, 16, 32,
                FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 8);


    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTick);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }

    private void assignFluidStackRenderer() {
        fluidStackRenderer = new FluidStackRenderer(FluidStack.convertDropletsToMb(FluidConstants.BUCKET) * 8,
                true, 16, 32);
    }
}
