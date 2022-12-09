package net.mcs3.elixiremporium.client.screens.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mcs3.elixiremporium.world.effect.ModEffects;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;


@Environment(value= EnvType.CLIENT)
public class IronSkinLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {

    private static final ResourceLocation IRON_SKIN_OVERLAY = new ResourceLocation("textures/block/iron_block.png");

    public IronSkinLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, AbstractClientPlayer livingEntity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {

        if (livingEntity.hasEffect(ModEffects.IRON_SKIN_EFFECT) && !livingEntity.isInvisible()) {
            EntityModel entityModel = this.getParentModel();
            entityModel.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTick);
            this.getParentModel().copyPropertiesTo(entityModel);
            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucentCull(IRON_SKIN_OVERLAY));
            entityModel.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            entityModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.WHITE_OVERLAY_V, 0.0F, 0.0F, 0.0F, 0.4F);

        }
    }
}
