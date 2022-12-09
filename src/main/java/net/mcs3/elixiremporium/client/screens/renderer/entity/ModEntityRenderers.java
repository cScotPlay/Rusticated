package net.mcs3.elixiremporium.client.screens.renderer.entity;

import net.mcs3.elixiremporium.client.screens.renderer.entity.layers.IronSkinLayer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Consumer;

public class ModEntityRenderers {
    public interface EntityRenderConsumer {
        <E extends Entity> void accept (EntityType<? extends E> entityType, EntityRendererProvider<E> entityRendererProvider);
    }


    public static void addAuxiliaryPlayerRenders(PlayerRenderer renderer,
                                                 Consumer<RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>>> consumer) {
        consumer.accept(new IronSkinLayer(renderer));
    }

    private ModEntityRenderers() {}
}
