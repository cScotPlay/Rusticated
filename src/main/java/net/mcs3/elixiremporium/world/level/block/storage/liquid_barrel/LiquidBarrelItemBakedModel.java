package net.mcs3.elixiremporium.world.level.block.storage.liquid_barrel;

import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributes;
import net.mcs3.elixiremporium.world.item.LiquidBarrelItem;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LiquidBarrelItemBakedModel implements FabricBakedModel, BakedModel {
    private final BakedModel blockModel;
    private final RenderMaterial translucentMaterial;

    public LiquidBarrelItemBakedModel(BakedModel blockModel, RenderMaterial translucentMaterial) {
        this.blockModel = blockModel;
        this.translucentMaterial = translucentMaterial;
    }

    @Override
    public boolean isVanillaAdapter() {
        return false;
    }

    @Override
    public void emitBlockQuads(BlockAndTintGetter blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context) {
    }

    @Override
    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context) {
        context.fallbackConsumer().accept(blockModel);

        Item it = stack.getItem();
        if (it instanceof LiquidBarrelItem item) {
            if (!item.isEmpty(stack)) {
                float fillFraction = (float) item.getAmount(stack) / item.capacity;
                drawFluid(context.getEmitter(), fillFraction, item.getFluid(stack));
            }
        }
    }

    private void drawFluid(QuadEmitter emitter, float fillFraction, FluidVariant fluid) {
        TextureAtlasSprite stillSprite = FluidVariantRendering.getSprite(fluid);
        int color = FluidVariantRendering.getColor(fluid) | 255 << 24;
        for (Direction direction : Direction.values()) {
            float topSpace, depth, bottomSpace;
            if (FluidVariantAttributes.isLighterThanAir(fluid)) {
                bottomSpace = direction.getAxis().isHorizontal() ? 1 - fillFraction + 0.01f : 0;
                depth = direction == Direction.DOWN ? fillFraction : 0;
                topSpace = 0;
            } else {
                bottomSpace = 0;
                topSpace = direction.getAxis().isHorizontal() ? 1 - fillFraction + 0.01f : 0;
                depth = direction == Direction.UP ? 1 - fillFraction : 0;
            }
            emitter.material(translucentMaterial);
            emitter.square(direction, 0, bottomSpace, 1, 1 - topSpace, depth + 0.01f);
            emitter.spriteBake(0, stillSprite, MutableQuadView.BAKE_LOCK_UV);
            emitter.spriteColor(0, color, color, color, color);
            emitter.emit();
        }
    }

    @Override
    public List<BakedQuad> getQuads(BlockState state, Direction face, Random random) {
        return Collections.emptyList();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return false;
    }

    @Override
    public boolean usesBlockLight() {
        return true;
    }

    @Override
    public boolean isCustomRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return blockModel.getParticleIcon();
    }

    @Override
    public ItemTransforms getTransforms() {
        return blockModel.getTransforms();
    }

    @Override
    public ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }
}
