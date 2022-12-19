package net.mcs3.rusticated.client.screens.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.mcs3.rusticated.util.RenderUtility;
import net.mcs3.rusticated.world.level.block.entity.EvaporatingBasinBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;


public class EvaporationBasinRenderer implements BlockEntityRenderer<EvaporatingBasinBlockEntity> {
    public EvaporationBasinRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(EvaporatingBasinBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        EvaporatingBasinBlockEntity basin = blockEntity;
        SingleVariantStorage<FluidVariant> fluidStorage = basin.fluidStorage;

        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack resultItem = blockEntity.getRenderStack();
        poseStack.pushPose();
        if(fluidStorage.amount == fluidStorage.getCapacity()) {
            poseStack.translate(0.5f, 0.21f, 0.5f);
        } else poseStack.translate(0.5f, 0.11f, 0.5f);

        poseStack.scale(0.6f, 0.6f, 0.6f);
        poseStack.mulPose(Vector3f.XP.rotationDegrees(-90));

        itemRenderer.renderStatic(resultItem, ItemTransforms.TransformType.GUI, getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos()), OverlayTexture.NO_WHITE_U, poseStack, bufferSource, 1);
        poseStack.popPose();

        if (!fluidStorage.variant.isBlank() && fluidStorage.amount > 0) {
            RenderUtility.drawFluidInTank(blockEntity, poseStack, bufferSource, fluidStorage.variant, (float) (fluidStorage.amount / fluidStorage.getCapacity()) / 8);
        }
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
