package net.mcs3.elixiremporium.world.level.block.storage.pot;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.mcs3.elixiremporium.util.RenderUtility;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class GlazedPotRenderer implements BlockEntityRenderer<BlockEntity> {

    public static void register(BlockEntityType<BlockEntity> type) {
        BlockEntityRendererRegistry.register(type, (BlockEntityRendererProvider.Context context) -> new GlazedPotRenderer());
    }

    private GlazedPotRenderer(){}

    @Override
    public void render(BlockEntity entity, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, int light, int overlay) {

        PotEntityBlock potEntityBlock = (PotEntityBlock) entity;
        var state = potEntityBlock.getBlockState();
        var pos = potEntityBlock.getBlockPos();

        ItemVariant item = potEntityBlock.getResource();
        if (!item.isBlank()) {
            long amount = potEntityBlock.getAmount();
            if (amount > 0) {

                ItemStack toRender = new ItemStack(item.getItem(), 1);

                for (int i = 0; i < 4; i++) {
                    var direction = Direction.from2DDataValue(i);
                    if (!Block.shouldRenderFace(state, potEntityBlock.getLevel(), pos, direction, pos.relative(direction))) {
                        continue;
                    }

                    matrices.pushPose();
                    matrices.translate(0.5, 0, 0.5);
                    matrices.mulPose(Vector3f.YP.rotationDegrees(-i * 90F));
                    matrices.scale(0.5F, 0.5F, 0.5F);
                    matrices.translate(0, 1.88, 0.76);

                    matrices.mulPoseMatrix(Matrix4f.createScaleMatrix(0.23f, 0.23f, 0.01f));
                    matrices.last().normal().mul(Vector3f.XN.rotationDegrees(45f));

                    Minecraft.getInstance().getItemRenderer().renderStatic(toRender, ItemTransforms.TransformType.GUI, RenderUtility.FULL_LIGHT,
                            OverlayTexture.NO_OVERLAY, matrices, vertexConsumers, 0);

                    matrices.popPose();
                }
            }
        }
    }
}
