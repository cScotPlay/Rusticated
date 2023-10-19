package net.mcs3.rusticated.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.material.BlendMode;
import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.mcs3.rusticated.compat.Sodium.SodiumCompat;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.joml.Matrix4f;

public class RenderUtility
{
    private static final BakedQuad[] OVERLAY_QUADS;
    private static final float W = 0.05f;

    public static void drawOverlay(PoseStack ms, MultiBufferSource vcp, float r, float g, float b, int light, int overlay) {
        VertexConsumer vc = vcp.getBuffer(RenderType.solid());
        for (BakedQuad overlayQuad : OVERLAY_QUADS) {
            vc.putBulkData(ms.last(), overlayQuad, r, g, b, light, overlay);
        }
    }

    static {
        OVERLAY_QUADS = new BakedQuad[24];
        Renderer r = RendererAccess.INSTANCE.getRenderer();
        RenderMaterial material = r.materialFinder().blendMode(0, BlendMode.SOLID).find();
        for (Direction direction : Direction.values()) {
            QuadEmitter emitter;
            emitter = r.meshBuilder().getEmitter();
            emitter.square(direction, 0, 0, 1, W, 0);
            emitter.material(material);
            OVERLAY_QUADS[direction.get3DDataValue() * 4] = emitter.toBakedQuad(0, null, false);
            emitter = r.meshBuilder().getEmitter();
            emitter.square(direction, 0, 1 - W, 1, 1, 0);
            emitter.material(material);
            OVERLAY_QUADS[direction.get3DDataValue() * 4 + 1] = emitter.toBakedQuad(0, null, false);
            emitter = r.meshBuilder().getEmitter();
            emitter.square(direction, 0, W, W, 1 - W, 0);
            emitter.material(material);
            OVERLAY_QUADS[direction.get3DDataValue() * 4 + 2] = emitter.toBakedQuad(0, null, false);
            emitter = r.meshBuilder().getEmitter();
            emitter.square(direction, 1 - W, W, 1, 1 - W, 0);
            emitter.material(material);
            OVERLAY_QUADS[direction.get3DDataValue() * 4 + 3] = emitter.toBakedQuad(0, null, false);
        }
    }

    private static final BakedQuad[] CUBE_QUADS;

    public static void drawCube(PoseStack ms, MultiBufferSource vcp, float r, float g, float b, int light, int overlay) {
        VertexConsumer vc = vcp.getBuffer(RenderType.solid());
        for (BakedQuad cubeQuad : CUBE_QUADS) {
            vc.putBulkData(ms.last(), cubeQuad, r, g, b, light, overlay);
        }
    }

    static {
        CUBE_QUADS = new BakedQuad[6];
        Renderer r = RendererAccess.INSTANCE.getRenderer();
        for (Direction direction : Direction.values()) {
            QuadEmitter emitter;
            emitter = r.meshBuilder().getEmitter();
            emitter.square(direction, 0, 0, 1, 1, 0);
            CUBE_QUADS[direction.get3DDataValue()] = emitter.toBakedQuad(0, null, false);
        }
    }

    private static final float TANK_W = 2 / 16f + 0.001f;
    public static final int FULL_LIGHT = 0x00F0_00F0;

    public static void drawFluidInTank(BlockEntity be, PoseStack ms, MultiBufferSource vcp, FluidVariant fluid, float fill) {
        drawFluidInTank(be.getLevel(), be.getBlockPos(), ms, vcp, fluid, fill);
    }

    public static void drawFluidInTank(Level world, BlockPos pos, PoseStack ms, MultiBufferSource vcp, FluidVariant fluid, float fill) {
        VertexConsumer vc = vcp.getBuffer(RenderType.translucent());
        TextureAtlasSprite sprite = FluidVariantRendering.getSprite(fluid);
        int color = FluidVariantRendering.getColor(fluid, world, pos);
        float r = ((color >> 16) & 255) / 256f;
        float g = ((color >> 8) & 255) / 256f;
        float b = (color & 255) / 256f;

        SodiumCompat.markSpriteActive(sprite);

        // Make sure fill is within [TANK_W, 1 - TANK_W]
        fill = TANK_W + (1 - 2 * TANK_W) * Math.min(1, Math.max(fill, 0));
        // Top and bottom positions of the fluid inside the tank
        float topHeight = fill;
        float bottomHeight = TANK_W;
        // Render gas from top to bottom
        if (FluidVariantAttributes.isLighterThanAir(fluid)) {
            topHeight = 1 - TANK_W;
            bottomHeight = 1 - fill;
        }

        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        for (Direction direction : Direction.values()) {
            QuadEmitter emitter = renderer.meshBuilder().getEmitter();

            if (direction.getAxis().isVertical()) {
                emitter.square(direction, TANK_W, TANK_W, 1 - TANK_W, 1 - TANK_W, direction == Direction.UP ? 1 - topHeight : bottomHeight);
            } else {
                emitter.square(direction, TANK_W, bottomHeight, 1 - TANK_W, topHeight, TANK_W);
            }

            emitter.spriteBake(0, sprite, MutableQuadView.BAKE_LOCK_UV);
            emitter.spriteColor(0, -1, -1, -1, -1);
            vc.putBulkData(ms.last(), emitter.toBakedQuad(0, sprite, false), r, g, b, FULL_LIGHT, OverlayTexture.NO_OVERLAY);
        }
    }

    public static void drawFluidInGui(PoseStack ms, FluidVariant fluid, int i, int j) {
        drawFluidInGui(ms, fluid, i, j, 16, 1);
        RenderSystem.enableDepthTest();
    }

    public static void drawFluidInGui(PoseStack ms, FluidVariant fluid, float i, float j, int scale, float fractionUp) {
        RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);
        TextureAtlasSprite sprite = FluidVariantRendering.getSprite(fluid);
        int color = FluidVariantRendering.getColor(fluid);

        if (sprite == null)
            return;

        float r = ((color >> 16) & 255) / 256f;
        float g = ((color >> 8) & 255) / 256f;
        float b = (color & 255) / 256f;
        RenderSystem.disableDepthTest();

        RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
        BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();
        bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR_TEX);
        float x0 = i;
        float y0 = j;
        float x1 = x0 + scale;
        float y1 = y0 + scale * fractionUp;
        float z = 0.5f;
        float u0 = sprite.getU0();
        float v1 = sprite.getV1();
        float v0 = v1 + (sprite.getV0() - v1) * fractionUp;
        float u1 = sprite.getU1();

        Matrix4f model = ms.last().pose();
        bufferBuilder.vertex(model, x0, y1, z).color(r, g, b, 1).uv(u0, v1).endVertex();
        bufferBuilder.vertex(model, x1, y1, z).color(r, g, b, 1).uv(u1, v1).endVertex();
        bufferBuilder.vertex(model, x1, y0, z).color(r, g, b, 1).uv(u1, v0).endVertex();
        bufferBuilder.vertex(model, x0, y0, z).color(r, g, b, 1).uv(u0, v0).endVertex();
        bufferBuilder.end();
        BufferUploader.draw(bufferBuilder.end()); //TODO Check that this worked

        RenderSystem.enableDepthTest();
    }

    /**
     * Return whether the point is within the passed rectangle.
     */
    public static boolean isPointWithinRectangle(int xStart, int yStart, int width, int height, double pointX, double pointY) {
        return pointX >= (double) (xStart - 1) && pointX < (double) (xStart + width + 1) && pointY >= (double) (yStart - 1)
                && pointY < (double) (yStart + height + 1);
    }

    /**
     * Force chunk remesh.
     */
    public static void forceChunkRemesh(Level world, BlockPos pos) {
        world.sendBlockUpdated(pos, null, null, 0);
    }

    private static final float[] DEFAULT_BRIGHTNESSES = new float[] { 1, 1, 1, 1 };

    public static void fill(PoseStack matrices, int x1, int y1, int x2, int y2, int color) {
        fill(matrices.last().pose(), x1, y1, x2, y2, color);
    }

    private static void fill(Matrix4f matrix, int x1, int y1, int x2, int y2, int color) {
        int j;
        if (x1 < x2) {
            j = x1;
            x1 = x2;
            x2 = j;
        }

        if (y1 < y2) {
            j = y1;
            y1 = y2;
            y2 = j;
        }

        float f = (float) (color >> 24 & 255) / 255.0F;
        float g = (float) (color >> 16 & 255) / 255.0F;
        float h = (float) (color >> 8 & 255) / 255.0F;
        float k = (float) (color & 255) / 255.0F;
        BufferBuilder bufferBuilder = Tesselator.getInstance().getBuilder();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        bufferBuilder.vertex(matrix, (float) x1, (float) y2, 0.0F).color(g, h, k, f).endVertex();
        bufferBuilder.vertex(matrix, (float) x2, (float) y2, 0.0F).color(g, h, k, f).endVertex();
        bufferBuilder.vertex(matrix, (float) x2, (float) y1, 0.0F).color(g, h, k, f).endVertex();
        bufferBuilder.vertex(matrix, (float) x1, (float) y1, 0.0F).color(g, h, k, f).endVertex();
        bufferBuilder.end();
        BufferUploader.draw(bufferBuilder.end());  //TODO Check that this worked
        RenderSystem.disableBlend();
    }

}
