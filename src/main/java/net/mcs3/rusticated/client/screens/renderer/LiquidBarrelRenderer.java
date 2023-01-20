package net.mcs3.rusticated.client.screens.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.mcs3.rusticated.util.RenderUtility;
import net.mcs3.rusticated.world.level.block.entity.LiquidBarrelBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;

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
