package net.mcs3.rusticated.client.resources.model;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.material.BlendMode;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.client.resources.model.LiquidBarrelItemBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class LiquidBarrelItemUnbakedModel implements UnbakedModel
{
    private final String blockPath;
    private final ResourceLocation blockModel;

    public LiquidBarrelItemUnbakedModel(String blockPath) {
        this.blockPath = blockPath;
        this.blockModel = new ResourceLocation(Rusticated.MOD_ID,"block/" + blockPath);
    }

    @Override
    public Collection<ResourceLocation> getDependencies() {
        return List.of(blockModel);
    }

    @Override
    public void resolveParents(Function<ResourceLocation, UnbakedModel> function) {

    }

    @Nullable
    @Override
    public BakedModel bake(ModelBaker modelBaker, Function<Material, TextureAtlasSprite> function, ModelState modelState, ResourceLocation resourceLocation) {
        var blockModel = modelBaker.bake(this.blockModel, modelState);
        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        var translucentMaterial = renderer.materialFinder().blendMode(0, BlendMode.TRANSLUCENT).emissive(0, true).find();
        return new LiquidBarrelItemBakedModel(blockModel, translucentMaterial);
    }


//    @Override
//    public Collection<Material> getMaterials(Function<ResourceLocation, UnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors){
//        return modelGetter.apply(blockModel).getMaterials(modelGetter, missingTextureErrors);
//    }


}
