package net.mcs3.rusticated.world.level.block.storage.liquid_barrel;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcs3.rusticated.util.RenderUtility;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;

public class LiquidBarrelRenderer implements BlockEntityRenderer<BlockEntity> {
    public LiquidBarrelRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(BlockEntity entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        LiquidBarrelEntityBlock barrel = (LiquidBarrelEntityBlock) entity;
        if (!barrel.getResource().isBlank() && barrel.getAmount() > 0) {
            RenderUtility.drawFluidInTank(entity, matrices, vertexConsumers, barrel.getResource(), (float) barrel.getAmount() / barrel.getCapacity());
        }
    }
}
