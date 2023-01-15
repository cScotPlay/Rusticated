package net.mcs3.rusticated.client.screens.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.mcs3.rusticated.util.RenderUtility;
import net.mcs3.rusticated.world.level.block.entity.CrushingTubBlockEntity;
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


public class CrushingTubRenderer implements BlockEntityRenderer<CrushingTubBlockEntity> {

    private final ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
    public CrushingTubRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(CrushingTubBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        CrushingTubBlockEntity basin = blockEntity;
        SingleVariantStorage<FluidVariant> fluidStorage = basin.fluidStorage;

        ItemStack resultItem = blockEntity.getRenderStack();

        if(!resultItem.isEmpty()) {
            renderItems(blockEntity, resultItem, poseStack, bufferSource);
        }
        if (!fluidStorage.variant.isBlank() && fluidStorage.amount > 0) {
            RenderUtility.drawFluidInTank(blockEntity, poseStack, bufferSource, fluidStorage.variant, (float) (fluidStorage.amount / fluidStorage.getCapacity()) / 2);
        }
    }

    private void renderItems(CrushingTubBlockEntity blockEntity, ItemStack resultItem, PoseStack poseStack, MultiBufferSource bufferSource){
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.55f, 0.5f);
        poseStack.scale(0.6f, 0.6f, 0.6f);
        int count = Math.max(1, resultItem.getCount() / 8);
        for(int i = 1; i <= count; i++) {
            poseStack.translate(0.0, -0.03125f, 0.0);
            poseStack.pushPose();
            poseStack.mulPose(Vector3f.YP.rotationDegrees(i * 3));
            poseStack.mulPose(Vector3f.XP.rotationDegrees(-90));
            itemRenderer.renderStatic(resultItem, ItemTransforms.TransformType.GUI, getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos()), OverlayTexture.WHITE_OVERLAY_V, poseStack, bufferSource, 1);
            poseStack.popPose();
        }
        poseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
