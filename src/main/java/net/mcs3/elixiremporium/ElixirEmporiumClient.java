package net.mcs3.elixiremporium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.mcs3.elixiremporium.client.screens.inventory.BarrelScreen;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.mcs3.elixiremporium.world.level.block.storage.liquid_barrel.LiquidBarrelRenderer;
import net.mcs3.elixiremporium.world.menu.BarrelMenu;
import net.mcs3.elixiremporium.world.menu.ModMenuTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class ElixirEmporiumClient implements ClientModInitializer
{

    @Override
    public void onInitializeClient()
    {
        registerRenderTypes();
        registerScreenTypes();
    }

    private static void registerRenderTypes()
    {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHANDELIER_IRON, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHANDELIER_GOLD, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIN_GOLD, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIN_COPPER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIN_EXPOSED_COPPER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIN_WEATHERED_COPPER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIN_OXIDIZED_COPPER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIN_WAXED_COPPER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIN_WAXED_EXPOSED_COPPER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIN_WAXED_WEATHERED_COPPER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAIN_WAXED_OXIDIZED_COPPER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BARREL, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIQUID_BARREL, RenderType.cutout());

        BlockEntityRendererRegistry.register(ModBlockEntityTypes.LIQUID_BARREL_CONTAINER, LiquidBarrelRenderer::new);
    }

    private static void registerScreenTypes()
    {
        ScreenRegistry.register(ModMenuTypes.BARREL_MENU_TYPE, BarrelScreen::new);
        ModMenuTypes.BARREL_MENU_TYPE = ScreenHandlerRegistry.registerSimple(new ResourceLocation(ElixirEmporium.MOD_ID, "barrel_menu"), BarrelMenu::new);
    }

}
