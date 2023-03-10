package net.mcs3.rusticated.client.color;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModItems;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.FoliageColor;

public class ModColorProviders
{
    public static void registerBlockColorProviders()
    {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9fffe, ModBlocks.STONE_WHITE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9801d, ModBlocks.STONE_ORANGE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xc74ebd, ModBlocks.STONE_MAGENTA);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3ab3da, ModBlocks.STONE_LIGHT_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xfed83d, ModBlocks.STONE_YELLOW);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x80c71f, ModBlocks.STONE_LIME);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf38baa, ModBlocks.STONE_PINK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x474f52, ModBlocks.STONE_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x9d9d97, ModBlocks.STONE_LIGHT_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x169c9c, ModBlocks.STONE_CYAN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x8932b8, ModBlocks.STONE_PURPLE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3c44aa, ModBlocks.STONE_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x835432, ModBlocks.STONE_BROWN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x5e7c16, ModBlocks.STONE_GREEN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xb02e26, ModBlocks.STONE_RED);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x1d1d21, ModBlocks.STONE_BLACK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9fffe, ModBlocks.STONE_SLAB_WHITE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9801d, ModBlocks.STONE_SLAB_ORANGE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xc74ebd, ModBlocks.STONE_SLAB_MAGENTA);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3ab3da, ModBlocks.STONE_SLAB_LIGHT_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xfed83d, ModBlocks.STONE_SLAB_YELLOW);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x80c71f, ModBlocks.STONE_SLAB_LIME);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf38baa, ModBlocks.STONE_SLAB_PINK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x474f52, ModBlocks.STONE_SLAB_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x9d9d97, ModBlocks.STONE_SLAB_LIGHT_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x169c9c, ModBlocks.STONE_SLAB_CYAN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x8932b8, ModBlocks.STONE_SLAB_PURPLE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3c44aa, ModBlocks.STONE_SLAB_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x835432, ModBlocks.STONE_SLAB_BROWN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x5e7c16, ModBlocks.STONE_SLAB_GREEN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xb02e26, ModBlocks.STONE_SLAB_RED);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x1d1d21, ModBlocks.STONE_SLAB_BLACK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9fffe, ModBlocks.STONE_STAIRS_WHITE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9801d, ModBlocks.STONE_STAIRS_ORANGE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xc74ebd, ModBlocks.STONE_STAIRS_MAGENTA);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3ab3da, ModBlocks.STONE_STAIRS_LIGHT_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xfed83d, ModBlocks.STONE_STAIRS_YELLOW);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x80c71f, ModBlocks.STONE_STAIRS_LIME);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf38baa, ModBlocks.STONE_STAIRS_PINK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x474f52, ModBlocks.STONE_STAIRS_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x9d9d97, ModBlocks.STONE_STAIRS_LIGHT_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x169c9c, ModBlocks.STONE_STAIRS_CYAN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x8932b8, ModBlocks.STONE_STAIRS_PURPLE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3c44aa, ModBlocks.STONE_STAIRS_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x835432, ModBlocks.STONE_STAIRS_BROWN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x5e7c16, ModBlocks.STONE_STAIRS_GREEN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xb02e26, ModBlocks.STONE_STAIRS_RED);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x1d1d21, ModBlocks.STONE_STAIRS_BLACK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9fffe, ModBlocks.COBBLESTONE_WHITE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9801d, ModBlocks.COBBLESTONE_ORANGE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xc74ebd, ModBlocks.COBBLESTONE_MAGENTA);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3ab3da, ModBlocks.COBBLESTONE_LIGHT_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xfed83d, ModBlocks.COBBLESTONE_YELLOW);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x80c71f, ModBlocks.COBBLESTONE_LIME);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf38baa, ModBlocks.COBBLESTONE_PINK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x474f52, ModBlocks.COBBLESTONE_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x9d9d97, ModBlocks.COBBLESTONE_LIGHT_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x169c9c, ModBlocks.COBBLESTONE_CYAN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x8932b8, ModBlocks.COBBLESTONE_PURPLE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3c44aa, ModBlocks.COBBLESTONE_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x835432, ModBlocks.COBBLESTONE_BROWN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x5e7c16, ModBlocks.COBBLESTONE_GREEN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xb02e26, ModBlocks.COBBLESTONE_RED);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x1d1d21, ModBlocks.COBBLESTONE_BLACK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9fffe, ModBlocks.COBBLESTONE_SLAB_WHITE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9801d, ModBlocks.COBBLESTONE_SLAB_ORANGE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xc74ebd, ModBlocks.COBBLESTONE_SLAB_MAGENTA);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3ab3da, ModBlocks.COBBLESTONE_SLAB_LIGHT_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xfed83d, ModBlocks.COBBLESTONE_SLAB_YELLOW);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x80c71f, ModBlocks.COBBLESTONE_SLAB_LIME);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf38baa, ModBlocks.COBBLESTONE_SLAB_PINK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x474f52, ModBlocks.COBBLESTONE_SLAB_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x9d9d97, ModBlocks.COBBLESTONE_SLAB_LIGHT_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x169c9c, ModBlocks.COBBLESTONE_SLAB_CYAN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x8932b8, ModBlocks.COBBLESTONE_SLAB_PURPLE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3c44aa, ModBlocks.COBBLESTONE_SLAB_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x835432, ModBlocks.COBBLESTONE_SLAB_BROWN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x5e7c16, ModBlocks.COBBLESTONE_SLAB_GREEN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xb02e26, ModBlocks.COBBLESTONE_SLAB_RED);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x1d1d21, ModBlocks.COBBLESTONE_SLAB_BLACK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9fffe, ModBlocks.COBBLESTONE_STAIRS_WHITE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9801d, ModBlocks.COBBLESTONE_STAIRS_ORANGE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xc74ebd, ModBlocks.COBBLESTONE_STAIRS_MAGENTA);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3ab3da, ModBlocks.COBBLESTONE_STAIRS_LIGHT_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xfed83d, ModBlocks.COBBLESTONE_STAIRS_YELLOW);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x80c71f, ModBlocks.COBBLESTONE_STAIRS_LIME);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf38baa, ModBlocks.COBBLESTONE_STAIRS_PINK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x474f52, ModBlocks.COBBLESTONE_STAIRS_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x9d9d97, ModBlocks.COBBLESTONE_STAIRS_LIGHT_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x169c9c, ModBlocks.COBBLESTONE_STAIRS_CYAN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x8932b8, ModBlocks.COBBLESTONE_STAIRS_PURPLE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3c44aa, ModBlocks.COBBLESTONE_STAIRS_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x835432, ModBlocks.COBBLESTONE_STAIRS_BROWN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x5e7c16, ModBlocks.COBBLESTONE_STAIRS_GREEN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xb02e26, ModBlocks.COBBLESTONE_STAIRS_RED);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x1d1d21, ModBlocks.COBBLESTONE_STAIRS_BLACK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9fffe, ModBlocks.COBBLESTONE_WALL_WHITE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf9801d, ModBlocks.COBBLESTONE_WALL_ORANGE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xc74ebd, ModBlocks.COBBLESTONE_WALL_MAGENTA);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3ab3da, ModBlocks.COBBLESTONE_WALL_LIGHT_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xfed83d, ModBlocks.COBBLESTONE_WALL_YELLOW);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x80c71f, ModBlocks.COBBLESTONE_WALL_LIME);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xf38baa, ModBlocks.COBBLESTONE_WALL_PINK);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x474f52, ModBlocks.COBBLESTONE_WALL_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x9d9d97, ModBlocks.COBBLESTONE_WALL_LIGHT_GRAY);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x169c9c, ModBlocks.COBBLESTONE_WALL_CYAN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x8932b8, ModBlocks.COBBLESTONE_WALL_PURPLE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3c44aa, ModBlocks.COBBLESTONE_WALL_BLUE);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x835432, ModBlocks.COBBLESTONE_WALL_BROWN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x5e7c16, ModBlocks.COBBLESTONE_WALL_GREEN);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xb02e26, ModBlocks.COBBLESTONE_WALL_RED);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x1d1d21, ModBlocks.COBBLESTONE_WALL_BLACK);

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> {
            return blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor();
        }, ModBlocks.IRON_LATTICE);

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> {
            return blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor();
        }, ModBlocks.IRONWOOD_LEAVES);

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> {
            return blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor();
        }, ModBlocks.OLIVE_LEAVES);

        ColorProviderRegistry.BLOCK.register((blockState, blockAndTintGetter, blockPos, i) -> {
            return blockAndTintGetter != null && blockPos != null ? BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos) : FoliageColor.getDefaultColor();
        }, ModBlocks.GRAPE_LEAVES);


    }

    public static void registerItemColorProviders()
    {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9fffe, ModBlocks.STONE_WHITE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9801d, ModBlocks.STONE_ORANGE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xc74ebd, ModBlocks.STONE_MAGENTA.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3ab3da, ModBlocks.STONE_LIGHT_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xfed83d, ModBlocks.STONE_YELLOW.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x80c71f, ModBlocks.STONE_LIME.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf38baa, ModBlocks.STONE_PINK.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x474f52, ModBlocks.STONE_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x9d9d97, ModBlocks.STONE_LIGHT_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x169c9c, ModBlocks.STONE_CYAN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8932b8, ModBlocks.STONE_PURPLE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3c44aa, ModBlocks.STONE_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x835432, ModBlocks.STONE_BROWN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5e7c16, ModBlocks.STONE_GREEN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xb02e26, ModBlocks.STONE_RED.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x1d1d21, ModBlocks.STONE_BLACK.asItem());

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9fffe, ModBlocks.STONE_SLAB_WHITE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9801d, ModBlocks.STONE_SLAB_ORANGE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xc74ebd, ModBlocks.STONE_SLAB_MAGENTA.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3ab3da, ModBlocks.STONE_SLAB_LIGHT_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xfed83d, ModBlocks.STONE_SLAB_YELLOW.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x80c71f, ModBlocks.STONE_SLAB_LIME.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf38baa, ModBlocks.STONE_SLAB_PINK.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x474f52, ModBlocks.STONE_SLAB_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x9d9d97, ModBlocks.STONE_SLAB_LIGHT_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x169c9c, ModBlocks.STONE_SLAB_CYAN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8932b8, ModBlocks.STONE_SLAB_PURPLE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3c44aa, ModBlocks.STONE_SLAB_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x835432, ModBlocks.STONE_SLAB_BROWN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5e7c16, ModBlocks.STONE_SLAB_GREEN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xb02e26, ModBlocks.STONE_SLAB_RED.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x1d1d21, ModBlocks.STONE_SLAB_BLACK.asItem());

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9fffe, ModBlocks.STONE_STAIRS_WHITE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9801d, ModBlocks.STONE_STAIRS_ORANGE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xc74ebd, ModBlocks.STONE_STAIRS_MAGENTA.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3ab3da, ModBlocks.STONE_STAIRS_LIGHT_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xfed83d, ModBlocks.STONE_STAIRS_YELLOW.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x80c71f, ModBlocks.STONE_STAIRS_LIME.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf38baa, ModBlocks.STONE_STAIRS_PINK.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x474f52, ModBlocks.STONE_STAIRS_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x9d9d97, ModBlocks.STONE_STAIRS_LIGHT_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x169c9c, ModBlocks.STONE_STAIRS_CYAN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8932b8, ModBlocks.STONE_STAIRS_PURPLE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3c44aa, ModBlocks.STONE_STAIRS_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x835432, ModBlocks.STONE_STAIRS_BROWN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5e7c16, ModBlocks.STONE_STAIRS_GREEN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xb02e26, ModBlocks.STONE_STAIRS_RED.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x1d1d21, ModBlocks.STONE_STAIRS_BLACK.asItem());

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9fffe, ModBlocks.COBBLESTONE_WHITE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9801d, ModBlocks.COBBLESTONE_ORANGE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xc74ebd, ModBlocks.COBBLESTONE_MAGENTA.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3ab3da, ModBlocks.COBBLESTONE_LIGHT_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xfed83d, ModBlocks.COBBLESTONE_YELLOW.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x80c71f, ModBlocks.COBBLESTONE_LIME.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf38baa, ModBlocks.COBBLESTONE_PINK.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x474f52, ModBlocks.COBBLESTONE_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x9d9d97, ModBlocks.COBBLESTONE_LIGHT_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x169c9c, ModBlocks.COBBLESTONE_CYAN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8932b8, ModBlocks.COBBLESTONE_PURPLE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3c44aa, ModBlocks.COBBLESTONE_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x835432, ModBlocks.COBBLESTONE_BROWN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5e7c16, ModBlocks.COBBLESTONE_GREEN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xb02e26, ModBlocks.COBBLESTONE_RED.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x1d1d21, ModBlocks.COBBLESTONE_BLACK.asItem());

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9fffe, ModBlocks.COBBLESTONE_SLAB_WHITE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9801d, ModBlocks.COBBLESTONE_SLAB_ORANGE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xc74ebd, ModBlocks.COBBLESTONE_SLAB_MAGENTA.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3ab3da, ModBlocks.COBBLESTONE_SLAB_LIGHT_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xfed83d, ModBlocks.COBBLESTONE_SLAB_YELLOW.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x80c71f, ModBlocks.COBBLESTONE_SLAB_LIME.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf38baa, ModBlocks.COBBLESTONE_SLAB_PINK.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x474f52, ModBlocks.COBBLESTONE_SLAB_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x9d9d97, ModBlocks.COBBLESTONE_SLAB_LIGHT_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x169c9c, ModBlocks.COBBLESTONE_SLAB_CYAN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8932b8, ModBlocks.COBBLESTONE_SLAB_PURPLE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3c44aa, ModBlocks.COBBLESTONE_SLAB_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x835432, ModBlocks.COBBLESTONE_SLAB_BROWN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5e7c16, ModBlocks.COBBLESTONE_SLAB_GREEN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xb02e26, ModBlocks.COBBLESTONE_SLAB_RED.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x1d1d21, ModBlocks.COBBLESTONE_SLAB_BLACK.asItem());

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9fffe, ModBlocks.COBBLESTONE_STAIRS_WHITE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9801d, ModBlocks.COBBLESTONE_STAIRS_ORANGE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xc74ebd, ModBlocks.COBBLESTONE_STAIRS_MAGENTA.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3ab3da, ModBlocks.COBBLESTONE_STAIRS_LIGHT_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xfed83d, ModBlocks.COBBLESTONE_STAIRS_YELLOW.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x80c71f, ModBlocks.COBBLESTONE_STAIRS_LIME.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf38baa, ModBlocks.COBBLESTONE_STAIRS_PINK.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x474f52, ModBlocks.COBBLESTONE_STAIRS_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x9d9d97, ModBlocks.COBBLESTONE_STAIRS_LIGHT_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x169c9c, ModBlocks.COBBLESTONE_STAIRS_CYAN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8932b8, ModBlocks.COBBLESTONE_STAIRS_PURPLE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3c44aa, ModBlocks.COBBLESTONE_STAIRS_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x835432, ModBlocks.COBBLESTONE_STAIRS_BROWN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5e7c16, ModBlocks.COBBLESTONE_STAIRS_GREEN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xb02e26, ModBlocks.COBBLESTONE_STAIRS_RED.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x1d1d21, ModBlocks.COBBLESTONE_STAIRS_BLACK.asItem());

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9fffe, ModBlocks.COBBLESTONE_WALL_WHITE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf9801d, ModBlocks.COBBLESTONE_WALL_ORANGE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xc74ebd, ModBlocks.COBBLESTONE_WALL_MAGENTA.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3ab3da, ModBlocks.COBBLESTONE_WALL_LIGHT_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xfed83d, ModBlocks.COBBLESTONE_WALL_YELLOW.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x80c71f, ModBlocks.COBBLESTONE_WALL_LIME.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xf38baa, ModBlocks.COBBLESTONE_WALL_PINK.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x474f52, ModBlocks.COBBLESTONE_WALL_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x9d9d97, ModBlocks.COBBLESTONE_WALL_LIGHT_GRAY.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x169c9c, ModBlocks.COBBLESTONE_WALL_CYAN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x8932b8, ModBlocks.COBBLESTONE_WALL_PURPLE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x3c44aa, ModBlocks.COBBLESTONE_WALL_BLUE.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x835432, ModBlocks.COBBLESTONE_WALL_BROWN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x5e7c16, ModBlocks.COBBLESTONE_WALL_GREEN.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0xb02e26, ModBlocks.COBBLESTONE_WALL_RED.asItem());
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x1d1d21, ModBlocks.COBBLESTONE_WALL_BLACK.asItem());

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ColorProviderRegistry.BLOCK.get(((BlockItem)stack.getItem()).getBlock()).getColor(((BlockItem)stack.getItem()).getBlock().defaultBlockState(), null, null, tintIndex), ModBlocks.IRONWOOD_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ColorProviderRegistry.BLOCK.get(((BlockItem)stack.getItem()).getBlock()).getColor(((BlockItem)stack.getItem()).getBlock().defaultBlockState(), null, null, tintIndex), ModBlocks.OLIVE_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> ColorProviderRegistry.BLOCK.get(((BlockItem)stack.getItem()).getBlock()).getColor(((BlockItem)stack.getItem()).getBlock().defaultBlockState(), null, null, tintIndex), ModBlocks.GRAPE_LEAVES);

        ColorProviderRegistry.ITEM.register((itemStack, i) -> i > 0 ? -1 : PotionUtils.getColor(itemStack), ModItems.ELIXIR);

    }
}
