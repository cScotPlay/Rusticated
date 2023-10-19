package net.mcs3.rusticated.client.screens.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.mcs3.rusticated.util.RenderUtility;
import net.mcs3.rusticated.world.level.block.storage.pot.PotBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.joml.Matrix4f;

public class PotRenderer implements BlockEntityRenderer<PotBlockEntity> {

    public PotRenderer(BlockEntityRendererProvider.Context context){}

    @Override
    public void render(PotBlockEntity potEntityBlock, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {
        var state = potEntityBlock.getBlockState();
        var pos = potEntityBlock.getBlockPos();
        PotBlockEntity potEntity = (PotBlockEntity) potEntityBlock;

        ItemStack item = potEntity.getItems().get(0);
        if (!item.isEmpty()) {
            ItemStack toRender = new ItemStack(item.getItem(), 1);
            for (int i = 0; i < 4; i++) {
                var direction = Direction.from2DDataValue(i);
                if (!Block.shouldRenderFace(state, potEntityBlock.getLevel(), pos, direction, pos.relative(direction))) {
                    continue;
                }
                matrices.pushPose();
                matrices.translate(0.5, 0, 0.5);
                matrices.mulPose(Axis.YP.rotationDegrees(-i * 90F));
                matrices.scale(0.5F, 0.5F, 0.5F);
                matrices.translate(0, 1.88, 0.76);

                matrices.mulPoseMatrix(new Matrix4f().scaling(0.23f, 0.23f, 0.01f));
                matrices.last().normal().getNormalizedRotation(Axis.XN.rotationDegrees(45f));

                    Minecraft.getInstance().getItemRenderer().renderStatic(toRender, ItemDisplayContext.GUI, RenderUtility.FULL_LIGHT,
                            OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, potEntityBlock.getLevel(), 0);

                matrices.popPose();
            }
        }
    }
}
