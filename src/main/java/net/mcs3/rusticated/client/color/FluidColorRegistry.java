package net.mcs3.rusticated.client.color;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.mcs3.rusticated.world.level.material.ModFluids;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class FluidColorRegistry {

    public static void registerClientFluids() {
        registerFluidColors();
        registerRenderTypes();
    }

    private static void registerFluidColors() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_OLIVE_OIL, ModFluids.FLOWING_OLIVE_OIL,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA7C4CB56
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_IRONBERRY_JUICE, ModFluids.FLOWING_IRONBERRY_JUICE,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA84C4C4C
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_SWEET_BERRY_JUICE, ModFluids.FLOWING_SWEET_BERRY_JUICE,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA870181E
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_GRAPE_JUICE, ModFluids.FLOWING_GRAPE_JUICE,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA8661285
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_APPLE_JUICE, ModFluids.FLOWING_APPLE_JUICE,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA7AC7128
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_ALE_WORT, ModFluids.FLOWING_ALE_WORT,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA85C3500
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_HONEY, ModFluids.FLOWING_HONEY,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA7FF9116
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_ALE, ModFluids.FLOWING_ALE,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA99D7E38
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_CIDER, ModFluids.FLOWING_CIDER,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA6AA6720
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_IRON_WINE, ModFluids.FLOWING_IRON_WINE,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA9323232
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_MEAD, ModFluids.FLOWING_MEAD,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA6FFC052
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_SWEET_BERRY_WINE, ModFluids.FLOWING_SWEET_BERRY_WINE,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA88B0028
                ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SOURCE_WINE, ModFluids.FLOWING_WINE,
                new SimpleFluidRenderHandler(
                        new ResourceLocation("minecraft:block/water_still"),
                        new ResourceLocation("minecraft:block/water_flow"),
                        0XA93B0028
                ));
    }

    private static void registerRenderTypes() {
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_OLIVE_OIL, ModFluids.FLOWING_OLIVE_OIL);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_IRONBERRY_JUICE, ModFluids.FLOWING_IRONBERRY_JUICE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_SWEET_BERRY_JUICE, ModFluids.FLOWING_SWEET_BERRY_JUICE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_GRAPE_JUICE, ModFluids.FLOWING_GRAPE_JUICE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_APPLE_JUICE, ModFluids.FLOWING_APPLE_JUICE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_ALE_WORT, ModFluids.FLOWING_ALE_WORT);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_HONEY, ModFluids.FLOWING_HONEY);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_ALE, ModFluids.FLOWING_ALE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_CIDER, ModFluids.FLOWING_CIDER);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_IRON_WINE, ModFluids.FLOWING_IRON_WINE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_MEAD, ModFluids.FLOWING_MEAD);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_SWEET_BERRY_WINE, ModFluids.FLOWING_SWEET_BERRY_WINE);
        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(), ModFluids.SOURCE_WINE, ModFluids.FLOWING_WINE);
    }
}
