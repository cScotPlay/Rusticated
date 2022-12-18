package net.mcs3.elixiremporium;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.mcs3.elixiremporium.client.color.FluidColorRegistry;
import net.mcs3.elixiremporium.client.color.ModColorProviders;
import net.mcs3.elixiremporium.client.screens.inventory.AdvCondenserScreen;
import net.mcs3.elixiremporium.client.screens.inventory.CondenserScreen;
import net.mcs3.elixiremporium.client.screens.renderer.EvaporationBasinRenderer;
import net.mcs3.elixiremporium.client.screens.renderer.entity.ModEntityRenderers;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.network.ModNetworkSync;
import net.mcs3.elixiremporium.world.inventory.ModMenuTypes;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.mcs3.elixiremporium.world.level.block.storage.liquid_barrel.LiquidBarrelRenderer;
import net.mcs3.elixiremporium.world.level.block.storage.pot.GlazedPotRenderer;
import net.mcs3.elixiremporium.world.level.block.storage.pot.PotRenderer;
import net.mcs3.elixiremporium.world.level.block.storage.pot.PotToolTipData;
import net.mcs3.elixiremporium.world.level.block.storage.pot.client.PotTooltipComponent;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

public class ElixirEmporiumClient implements ClientModInitializer
{

    @Override
    public void onInitializeClient()
    {
        registerRenderTypes();
        ModColorProviders.registerBlockColorProviders();
        ModColorProviders.registerItemColorProviders();
        FluidColorRegistry.registerClientFluids();
        ModNetworkSync.registerS2CPackets();
        registerScreenTypes();
        setupTooltips();
        registerLayers();
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
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.UNFIRED_JAR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRED_JAR, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRED_POT, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IRON_LATTICE, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IRONWOOD_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_IRONWOOD_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IRONWOOD_LEAVES, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OLIVE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_OLIVE_SAPLING, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OLIVE_LEAVES, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROPE, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_STEM, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAPE_LEAVES, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALOE_VERA, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOOD_ORCHID, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHAMOMILE, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLOUD_LILY, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COHOSH, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HORSETAIL, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WIND_THISTLE, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NIGHTSHROOM, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_SPORED_ASBESTOS, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORE_ROOT, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GINSENG, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MARSHMALLOW, RenderType.cutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CONDENSER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RETORT, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ADV_CONDENSER, RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ADV_RETORT, RenderType.cutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EVAPORATING_BASIN, RenderType.cutout());


        BlockEntityRendererRegistry.register(ModBlockEntityTypes.LIQUID_BARREL_CONTAINER, LiquidBarrelRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntityTypes.EVAPORATING_BASIN_CONTAINER, EvaporationBasinRenderer::new);

        PotRenderer.register(ModBlockEntityTypes.POT_CONTAINER);
        GlazedPotRenderer.register(ModBlockEntityTypes.GLAZED_POT_0_CONTAINER);
        GlazedPotRenderer.register(ModBlockEntityTypes.GLAZED_POT_1_CONTAINER);
        GlazedPotRenderer.register(ModBlockEntityTypes.GLAZED_POT_2_CONTAINER);
        GlazedPotRenderer.register(ModBlockEntityTypes.GLAZED_POT_3_CONTAINER);
        GlazedPotRenderer.register(ModBlockEntityTypes.GLAZED_POT_4_CONTAINER);

    }

    private static void registerScreenTypes()
    {
        MenuScreens.register(ModMenuTypes.CONDENSER_MENU_TYPE, CondenserScreen::new);
        MenuScreens.register(ModMenuTypes.ADV_CONDENSER_MENU_TYPE, AdvCondenserScreen::new);
    }

    private void registerLayers() {
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register(this::initAuxiliaryRender);

    }

    private static void setupTooltips()
    {
        TooltipComponentCallback.EVENT.register(data -> {
            if (data instanceof PotToolTipData potToolTipData) {
                return new PotTooltipComponent(potToolTipData);
            } return null;
        });
    }

    private void initAuxiliaryRender(EntityType<? extends LivingEntity> type, LivingEntityRenderer<?, ?> renderer,
                                     LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper helper, EntityRendererProvider.Context ctx) {
        if (type == EntityType.PLAYER && renderer instanceof PlayerRenderer playerRenderer) {
            ModEntityRenderers.addAuxiliaryPlayerRenders(playerRenderer, helper::register);
        }
    }
}
