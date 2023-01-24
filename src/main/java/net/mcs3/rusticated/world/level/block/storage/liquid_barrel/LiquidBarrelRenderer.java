package net.mcs3.rusticated.world.level.block.storage.liquid_barrel;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mcs3.rusticated.util.RenderUtility;
import net.mcs3.rusticated.world.level.block.entity.LiquidBarrelBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class LiquidBarrelRenderer implements BlockEntityRenderer<LiquidBarrelBlockEntity> {
    public LiquidBarrelRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(LiquidBarrelBlockEntity entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        LiquidBarrelBlockEntity barrel = (LiquidBarrelBlockEntity) entity;
        if (!barrel.fluidStorage.variant.isBlank() && barrel.fluidStorage.getAmount() > 0) {
            RenderUtility.drawFluidInTank(entity, matrices, vertexConsumers, barrel.fluidStorage.variant, (float) barrel.fluidStorage.getAmount() / barrel.fluidStorage.getCapacity());
        }
    }
}
