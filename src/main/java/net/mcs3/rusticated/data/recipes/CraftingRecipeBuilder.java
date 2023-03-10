package net.mcs3.rusticated.data.recipes;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModItems;
import net.mcs3.rusticated.data.tags.ModItemTags;
import net.mcs3.rusticated.world.item.alchmey.Elixirs;
import net.mcs3.rusticated.init.ModFluids;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.function.Consumer;

public class CraftingRecipeBuilder extends FabricRecipeProvider {
    public String MODID = Rusticated.MOD_ID;
    public CraftingRecipeBuilder(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<FinishedRecipe> exporter)
    {
        ////////////////////////////////////////////////////
        /////                 BLOCKS                   /////
        ////////////////////////////////////////////////////
        coloredStoneRecipe(exporter, ModBlocks.STONE_WHITE, Items.WHITE_DYE, ModBlocks.COBBLESTONE_WHITE, "stone_white_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_ORANGE, Items.ORANGE_DYE, ModBlocks.COBBLESTONE_ORANGE,"stone_orange_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_MAGENTA, Items.MAGENTA_DYE, ModBlocks.COBBLESTONE_MAGENTA,"stone_magenta_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_LIGHT_BLUE, Items.LIGHT_BLUE_DYE, ModBlocks.COBBLESTONE_LIGHT_BLUE,"stone_light_blue_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_YELLOW, Items.YELLOW_DYE, ModBlocks.COBBLESTONE_YELLOW,"stone_yellow_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_LIME, Items.LIME_DYE, ModBlocks.COBBLESTONE_LIME,"stone_lime_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_PINK, Items.PINK_DYE, ModBlocks.COBBLESTONE_PINK,"stone_pink_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_GRAY, Items.GRAY_DYE, ModBlocks.COBBLESTONE_GRAY,"stone_gray_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_LIGHT_GRAY, Items.LIGHT_GRAY_DYE, ModBlocks.COBBLESTONE_LIGHT_GRAY,"stone_light_gray_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_CYAN, Items.CYAN_DYE, ModBlocks.COBBLESTONE_CYAN,"stone_cyan_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_PURPLE, Items.PURPLE_DYE, ModBlocks.COBBLESTONE_PURPLE,"stone_purple_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_BLUE, Items.BLUE_DYE, ModBlocks.COBBLESTONE_BLUE,"stone_blue_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_BROWN, Items.BROWN_DYE, ModBlocks.COBBLESTONE_BROWN,"stone_brown_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_GREEN, Items.GREEN_DYE, ModBlocks.COBBLESTONE_GREEN,"stone_green_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_RED, Items.RED_DYE, ModBlocks.COBBLESTONE_RED,"stone_red_dyed");
        coloredStoneRecipe(exporter, ModBlocks.STONE_BLACK, Items.BLACK_DYE, ModBlocks.COBBLESTONE_BLACK,"stone_black_dyed");

        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_WHITE, ModBlocks.STONE_WHITE, Items.WHITE_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_white_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_ORANGE, ModBlocks.STONE_ORANGE, Items.ORANGE_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_orange_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_MAGENTA, ModBlocks.STONE_MAGENTA, Items.MAGENTA_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_magenta_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_LIGHT_BLUE, ModBlocks.STONE_LIGHT_BLUE, Items.LIGHT_BLUE_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_light_blue_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_YELLOW, ModBlocks.STONE_YELLOW, Items.YELLOW_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_yellow_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_LIME, ModBlocks.STONE_LIME, Items.LIME_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_lime_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_PINK, ModBlocks.STONE_PINK, Items.PINK_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_pink_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_GRAY, ModBlocks.STONE_GRAY, Items.GRAY_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_gray_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_LIGHT_GRAY, ModBlocks.STONE_LIGHT_GRAY, Items.LIGHT_GRAY_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_light_gray_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_CYAN, ModBlocks.STONE_CYAN, Items.CYAN_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_cyan_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_PURPLE, ModBlocks.STONE_PURPLE, Items.PURPLE_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_purple_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_BLUE, ModBlocks.STONE_BLUE, Items.BLUE_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_blue_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_BROWN, ModBlocks.STONE_BROWN, Items.BROWN_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_brown_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_GREEN, ModBlocks.STONE_GREEN, Items.GREEN_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_gree_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_RED, ModBlocks.STONE_RED, Items.RED_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_red_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.STONE_SLAB_BLACK, ModBlocks.STONE_BLACK, Items.BLACK_DYE, ModItemTags.COLORED_STONE_SLAB, "stone_slab_black_dyed");

        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_WHITE, ModBlocks.STONE_WHITE, Items.WHITE_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_white_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_ORANGE, ModBlocks.STONE_ORANGE, Items.ORANGE_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_orange_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_MAGENTA, ModBlocks.STONE_MAGENTA, Items.MAGENTA_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_magenta_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_LIGHT_BLUE, ModBlocks.STONE_LIGHT_BLUE, Items.LIGHT_BLUE_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_light_blue_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_YELLOW, ModBlocks.STONE_YELLOW, Items.YELLOW_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_yellow_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_LIME, ModBlocks.STONE_LIME, Items.LIME_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_lime_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_PINK, ModBlocks.STONE_PINK, Items.PINK_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_pink_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_GRAY, ModBlocks.STONE_GRAY, Items.GRAY_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_gray_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_LIGHT_GRAY, ModBlocks.STONE_LIGHT_GRAY, Items.LIGHT_GRAY_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_light_gray_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_CYAN, ModBlocks.STONE_CYAN, Items.CYAN_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_cyan_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_PURPLE, ModBlocks.STONE_PURPLE, Items.PURPLE_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_purple_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_BLUE, ModBlocks.STONE_BLUE, Items.BLUE_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_blue_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_BROWN, ModBlocks.STONE_BROWN, Items.BROWN_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_brown_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_GREEN, ModBlocks.STONE_GREEN, Items.GREEN_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_gree_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_RED, ModBlocks.STONE_RED, Items.RED_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_red_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.STONE_STAIRS_BLACK, ModBlocks.STONE_BLACK, Items.BLACK_DYE, ModItemTags.COLORED_STONE_STAIRS, "stone_stairs_black_dyed");

        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_WHITE, Items.WHITE_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_ORANGE, Items.ORANGE_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_MAGENTA, Items.MAGENTA_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_LIGHT_BLUE, Items.LIGHT_BLUE_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_YELLOW, Items.YELLOW_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_LIME, Items.LIME_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_PINK, Items.PINK_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_GRAY, Items.GRAY_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_LIGHT_GRAY, Items.LIGHT_GRAY_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_CYAN, Items.CYAN_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_PURPLE, Items.PURPLE_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_BLUE, Items.BLUE_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_BROWN, Items.BROWN_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_GREEN, Items.GREEN_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_RED, Items.RED_DYE);
        coloredCobbleStoneRecipe(exporter, ModBlocks.COBBLESTONE_BLACK, Items.BLACK_DYE);

        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_WHITE, ModBlocks.COBBLESTONE_WHITE, Items.WHITE_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_white_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_ORANGE, ModBlocks.COBBLESTONE_ORANGE, Items.ORANGE_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_orange_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_MAGENTA, ModBlocks.COBBLESTONE_MAGENTA, Items.MAGENTA_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_magenta_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_LIGHT_BLUE, ModBlocks.COBBLESTONE_LIGHT_BLUE, Items.LIGHT_BLUE_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_light_blue_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_YELLOW, ModBlocks.COBBLESTONE_YELLOW, Items.YELLOW_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_yellow_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_LIME, ModBlocks.COBBLESTONE_LIME, Items.LIME_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_lime_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_PINK, ModBlocks.COBBLESTONE_PINK, Items.PINK_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_pink_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_GRAY, ModBlocks.COBBLESTONE_GRAY, Items.GRAY_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_gray_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_LIGHT_GRAY, ModBlocks.COBBLESTONE_LIGHT_GRAY, Items.LIGHT_GRAY_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_light_gray_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_CYAN, ModBlocks.COBBLESTONE_CYAN, Items.CYAN_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_cyan_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_PURPLE, ModBlocks.COBBLESTONE_PURPLE, Items.PURPLE_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_purple_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_BLUE, ModBlocks.COBBLESTONE_BLUE, Items.BLUE_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_blue_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_BROWN, ModBlocks.COBBLESTONE_BROWN, Items.BROWN_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_brown_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_GREEN, ModBlocks.COBBLESTONE_GREEN, Items.GREEN_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_gree_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_RED, ModBlocks.COBBLESTONE_RED, Items.RED_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_red_dyed");
        coloredStoneSlabRecipe(exporter, ModBlocks.COBBLESTONE_SLAB_BLACK, ModBlocks.COBBLESTONE_BLACK, Items.BLACK_DYE, ModItemTags.COLORED_COBBLESTONE_SLAB, "cobblestone_slab_black_dyed");

        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_WHITE, ModBlocks.COBBLESTONE_WHITE, Items.WHITE_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_white_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_ORANGE, ModBlocks.COBBLESTONE_ORANGE, Items.ORANGE_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_orange_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_MAGENTA, ModBlocks.COBBLESTONE_MAGENTA, Items.MAGENTA_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_magenta_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_LIGHT_BLUE, ModBlocks.COBBLESTONE_LIGHT_BLUE, Items.LIGHT_BLUE_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_light_blue_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_YELLOW, ModBlocks.COBBLESTONE_YELLOW, Items.YELLOW_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_yellow_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_LIME, ModBlocks.COBBLESTONE_LIME, Items.LIME_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_lime_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_PINK, ModBlocks.COBBLESTONE_PINK, Items.PINK_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_pink_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_GRAY, ModBlocks.COBBLESTONE_GRAY, Items.GRAY_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_gray_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_LIGHT_GRAY, ModBlocks.COBBLESTONE_LIGHT_GRAY, Items.LIGHT_GRAY_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_light_gray_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_CYAN, ModBlocks.COBBLESTONE_CYAN, Items.CYAN_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_cyan_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_PURPLE, ModBlocks.COBBLESTONE_PURPLE, Items.PURPLE_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_purple_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_BLUE, ModBlocks.COBBLESTONE_BLUE, Items.BLUE_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_blue_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_BROWN, ModBlocks.COBBLESTONE_BROWN, Items.BROWN_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_brown_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_GREEN, ModBlocks.COBBLESTONE_GREEN, Items.GREEN_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_gree_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_RED, ModBlocks.COBBLESTONE_RED, Items.RED_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_red_dyed");
        coloredStoneStairsRecipe(exporter, ModBlocks.COBBLESTONE_STAIRS_BLACK, ModBlocks.COBBLESTONE_BLACK, Items.BLACK_DYE, ModItemTags.COLORED_COBBLESTONE_STAIRS, "cobblestone_stairs_black_dyed");

        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_WHITE, ModBlocks.COBBLESTONE_WHITE, ModItemTags.COLORED_COBBLESTONE_WALL, Items.WHITE_DYE, Blocks.COBBLESTONE, "cobblestone_wall_white_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_ORANGE, ModBlocks.COBBLESTONE_ORANGE, ModItemTags.COLORED_COBBLESTONE_WALL, Items.ORANGE_DYE, Blocks.COBBLESTONE, "cobblestone_wall_orange_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_MAGENTA, ModBlocks.COBBLESTONE_MAGENTA, ModItemTags.COLORED_COBBLESTONE_WALL, Items.MAGENTA_DYE, Blocks.COBBLESTONE, "cobblestone_wall_magenta_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_LIGHT_BLUE, ModBlocks.COBBLESTONE_LIGHT_BLUE, ModItemTags.COLORED_COBBLESTONE_WALL, Items.LIGHT_BLUE_DYE, Blocks.COBBLESTONE, "cobblestone_wall_light_blue_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_YELLOW, ModBlocks.COBBLESTONE_YELLOW, ModItemTags.COLORED_COBBLESTONE_WALL, Items.YELLOW_DYE, Blocks.COBBLESTONE, "cobblestone_wall_yellow_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_LIME, ModBlocks.COBBLESTONE_LIME, ModItemTags.COLORED_COBBLESTONE_WALL, Items.LIME_DYE, Blocks.COBBLESTONE, "cobblestone_wall_lime_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_PINK, ModBlocks.COBBLESTONE_PINK, ModItemTags.COLORED_COBBLESTONE_WALL, Items.PINK_DYE, Blocks.COBBLESTONE, "cobblestone_wall_pink_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_GRAY, ModBlocks.COBBLESTONE_GRAY, ModItemTags.COLORED_COBBLESTONE_WALL, Items.GRAY_DYE, Blocks.COBBLESTONE, "cobblestone_wall_gray_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_LIGHT_GRAY, ModBlocks.COBBLESTONE_LIGHT_GRAY, ModItemTags.COLORED_COBBLESTONE_WALL, Items.LIGHT_GRAY_DYE, Blocks.COBBLESTONE, "cobblestone_wall_light_gray_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_CYAN, ModBlocks.COBBLESTONE_CYAN, ModItemTags.COLORED_COBBLESTONE_WALL, Items.CYAN_DYE, Blocks.COBBLESTONE, "cobblestone_wall_cyan_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_PURPLE, ModBlocks.COBBLESTONE_PURPLE, ModItemTags.COLORED_COBBLESTONE_WALL, Items.PURPLE_DYE, Blocks.COBBLESTONE, "cobblestone_wall_purple_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_BLUE, ModBlocks.COBBLESTONE_BLUE, ModItemTags.COLORED_COBBLESTONE_WALL, Items.BLUE_DYE, Blocks.COBBLESTONE, "cobblestone_wall_blue_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_BROWN, ModBlocks.COBBLESTONE_BROWN, ModItemTags.COLORED_COBBLESTONE_WALL, Items.BROWN_DYE, Blocks.COBBLESTONE, "cobblestone_wall_brown_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_GREEN, ModBlocks.COBBLESTONE_GREEN, ModItemTags.COLORED_COBBLESTONE_WALL, Items.GREEN_DYE, Blocks.COBBLESTONE, "cobblestone_wall_gree_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_RED, ModBlocks.COBBLESTONE_RED, ModItemTags.COLORED_COBBLESTONE_WALL, Items.RED_DYE, Blocks.COBBLESTONE, "cobblestone_wall_red_dyed");
        coloredStoneWallRecipe(exporter, ModBlocks.COBBLESTONE_WALL_BLACK, ModBlocks.COBBLESTONE_BLACK, ModItemTags.COLORED_COBBLESTONE_WALL, Items.BLACK_DYE, Blocks.COBBLESTONE, "cobblestone_wall_black_dyed");

        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_WHITE, Items.WHITE_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_ORANGE, Items.ORANGE_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_MAGENTA, Items.MAGENTA_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_LIGHT_BLUE, Items.LIGHT_BLUE_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_YELLOW, Items.YELLOW_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_LIME, Items.LIME_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_PINK, Items.PINK_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_GRAY, Items.GRAY_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_LIGHT_GRAY, Items.LIGHT_GRAY_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_CYAN, Items.CYAN_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_PURPLE, Items.PURPLE_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_BLUE, Items.BLUE_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_BROWN, Items.BROWN_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_GREEN, Items.GREEN_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_RED, Items.RED_DYE);
        coloredWoodRecipe(exporter, ModBlocks.PAINTED_PLANKS_BLACK, Items.BLACK_DYE);

        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_WHITE, ModBlocks.PAINTED_PLANKS_WHITE, Items.WHITE_DYE, "painted_stairs_white_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_ORANGE, ModBlocks.PAINTED_PLANKS_ORANGE, Items.ORANGE_DYE, "painted_stairs_orange_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_MAGENTA, ModBlocks.PAINTED_PLANKS_MAGENTA, Items.MAGENTA_DYE, "painted_stairs_magenta_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_LIGHT_BLUE, ModBlocks.PAINTED_PLANKS_LIGHT_BLUE, Items.LIGHT_BLUE_DYE, "painted_stairs_light_blue_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_YELLOW, ModBlocks.PAINTED_PLANKS_YELLOW, Items.YELLOW_DYE, "painted_stairs_yellow_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_LIME, ModBlocks.PAINTED_PLANKS_LIME, Items.LIME_DYE, "painted_stairs_lime_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_PINK, ModBlocks.PAINTED_PLANKS_PINK, Items.PINK_DYE, "painted_stairs_pink_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_GRAY, ModBlocks.PAINTED_PLANKS_GRAY, Items.GRAY_DYE, "painted_stairs_gray_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_LIGHT_GRAY, ModBlocks.PAINTED_PLANKS_LIGHT_GRAY, Items.LIGHT_GRAY_DYE, "painted_stairs_light_gray_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_CYAN, ModBlocks.PAINTED_PLANKS_CYAN, Items.CYAN_DYE, "painted_stairs_cyan_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_PURPLE, ModBlocks.PAINTED_PLANKS_PURPLE, Items.PURPLE_DYE, "painted_stairs_purple_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_BLUE, ModBlocks.PAINTED_PLANKS_BLUE, Items.BLUE_DYE, "painted_stairs_blue_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_BROWN, ModBlocks.PAINTED_PLANKS_BROWN, Items.BROWN_DYE, "painted_stairs_brown_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_GREEN, ModBlocks.PAINTED_PLANKS_GREEN, Items.GREEN_DYE, "painted_stairs_gree_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_RED, ModBlocks.PAINTED_PLANKS_RED, Items.RED_DYE, "painted_stairs_red_dyed");
        coloredStairsRecipe(exporter, ModBlocks.PAINTED_STAIRS_BLACK, ModBlocks.PAINTED_PLANKS_BLACK, Items.BLACK_DYE, "painted_stairs_black_dyed");

        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_WHITE, ModBlocks.PAINTED_PLANKS_WHITE, Items.WHITE_DYE, "painted_slab_white_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_ORANGE, ModBlocks.PAINTED_PLANKS_ORANGE, Items.ORANGE_DYE, "painted_slab_orange_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_MAGENTA, ModBlocks.PAINTED_PLANKS_MAGENTA, Items.MAGENTA_DYE, "painted_slab_magenta_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_LIGHT_BLUE, ModBlocks.PAINTED_PLANKS_LIGHT_BLUE, Items.LIGHT_BLUE_DYE, "painted_slab_light_blue_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_YELLOW, ModBlocks.PAINTED_PLANKS_YELLOW, Items.YELLOW_DYE, "painted_slab_yellow_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_LIME, ModBlocks.PAINTED_PLANKS_LIME, Items.LIME_DYE, "painted_slab_lime_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_PINK, ModBlocks.PAINTED_PLANKS_PINK, Items.PINK_DYE, "painted_slab_pink_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_GRAY, ModBlocks.PAINTED_PLANKS_GRAY, Items.GRAY_DYE, "painted_slab_gray_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_LIGHT_GRAY, ModBlocks.PAINTED_PLANKS_LIGHT_GRAY, Items.LIGHT_GRAY_DYE, "painted_slab_light_gray_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_CYAN, ModBlocks.PAINTED_PLANKS_CYAN, Items.CYAN_DYE, "painted_slab_cyan_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_PURPLE, ModBlocks.PAINTED_PLANKS_PURPLE, Items.PURPLE_DYE, "painted_slab_purple_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_BLUE, ModBlocks.PAINTED_PLANKS_BLUE, Items.BLUE_DYE, "painted_slab_blue_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_BROWN, ModBlocks.PAINTED_PLANKS_BROWN, Items.BROWN_DYE, "painted_slab_brown_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_GREEN, ModBlocks.PAINTED_PLANKS_GREEN, Items.GREEN_DYE, "painted_slab_gree_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_RED, ModBlocks.PAINTED_PLANKS_RED, Items.RED_DYE, "painted_slab_red_dyed");
        coloredSlabRecipe(exporter, ModBlocks.PAINTED_SLAB_BLACK, ModBlocks.PAINTED_PLANKS_BLACK, Items.BLACK_DYE, "painted_slab_black_dyed");

        pathRecipe(exporter, ModBlocks.COBBLESTONE_PATH, Blocks.COBBLESTONE_SLAB, Blocks.COBBLESTONE);
        pathRecipe(exporter, ModBlocks.STONE_PATH, Blocks.STONE_SLAB, Blocks.STONE);
        pathRecipe(exporter, ModBlocks.ANDESITE_PATH, Blocks.STONE_SLAB, Blocks.ANDESITE);
        pathRecipe(exporter, ModBlocks.GRANITE_PATH, Blocks.GRANITE_SLAB, Blocks.GRANITE);
        pathRecipe(exporter, ModBlocks.DIORITE_PATH, Blocks.DIORITE_SLAB, Blocks.DIORITE);
        pathRecipe(exporter, ModBlocks.COBBLED_DEEPSLATE_PATH, Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.COBBLED_DEEPSLATE);
        pathRecipe(exporter, ModBlocks.BLACKSTONE_PATH, Blocks.BLACKSTONE_SLAB, Blocks.BLACKSTONE);
        pathRecipe(exporter, ModBlocks.NETHER_BRICKS_PATH, Blocks.NETHER_BRICK_SLAB, Blocks.NETHER_BRICKS);

        ShapedRecipeBuilder.shaped(ModBlocks.CHANDELIER_IRON, 2).define('#', Items.IRON_INGOT).define('x', Items.CHAIN).pattern(" # ").pattern("x x").pattern("###").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.CHANDELIER_GOLD, 2).define('#', Items.GOLD_INGOT).define('x', ModBlocks.CHAIN_GOLD.asItem()).pattern(" # ").pattern("x x").pattern("###").unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.CHANDELIER_COPPER, 2).define('#', Items.COPPER_INGOT).define('x', ModBlocks.CHAIN_COPPER.asItem()).pattern(" # ").pattern("x x").pattern("###").unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.CHAIN_GOLD).define('#', Items.GOLD_INGOT).define('x', Items.GOLD_NUGGET).pattern("x").pattern("#").pattern("x").unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.CHAIN_COPPER).define('#', Items.COPPER_INGOT).define('x', ModItems.COPPER_NUGGET).pattern("x").pattern("#").pattern("x").unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);

        ShapelessRecipeBuilder.shapeless(ModBlocks.CHAIN_WAXED_COPPER).requires(ModBlocks.CHAIN_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHAIN_WAXED_EXPOSED_COPPER).requires(ModBlocks.CHAIN_EXPOSED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHAIN_WAXED_WEATHERED_COPPER).requires(ModBlocks.CHAIN_WEATHERED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHAIN_WAXED_OXIDIZED_COPPER).requires(ModBlocks.CHAIN_OXIDIZED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHANDELIER_WAXED_COPPER).requires(ModBlocks.CHANDELIER_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHANDELIER_WAXED_EXPOSED_COPPER).requires(ModBlocks.CHANDELIER_EXPOSED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHANDELIER_WAXED_WEATHERED_COPPER).requires(ModBlocks.CHANDELIER_WEATHERED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHANDELIER_WAXED_OXIDIZED_COPPER).requires(ModBlocks.CHANDELIER_OXIDIZED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.STORAGE_BARREL).define('#', Items.IRON_INGOT).define('x', ItemTags.WOODEN_SLABS).define('p', ItemTags.PLANKS).pattern("pxp").pattern("# #").pattern("pxp").unlockedBy("has_wood", has(Blocks.OAK_PLANKS)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.LIQUID_BARREL).define('#', Items.IRON_INGOT).define('x', ItemTags.WOODEN_SLABS).define('p', ItemTags.PLANKS).pattern("p p").pattern("# #").pattern("pxp").unlockedBy("has_wood", has(Blocks.OAK_PLANKS)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.UNFIRED_JAR).define('#', Items.CLAY_BALL).define('x', Items.CLAY).pattern(" # ").pattern("# #").pattern("xxx").unlockedBy("has_clay", has(Blocks.CLAY)).save(exporter);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.UNFIRED_JAR.asItem()), ModBlocks.FIRED_JAR.asItem(), 0.0F, 1600).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.FIRED_JAR.asItem()), ModBlocks.GLAZED_JAR_0.asItem(), 0.0F, 1600).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.JARS), ModBlocks.GLAZED_JAR_0.asItem(), 0.0F, 1600).unlockedBy("has_clay", has(Items.CLAY)).save(exporter, new ResourceLocation("glazed_jar_from_glazed_jar"));
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLAZED_JAR_1).requires(ModItemTags.JARS).requires(Items.WHITE_DYE).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLAZED_JAR_2).requires(ModItemTags.JARS).requires(Items.BLACK_DYE).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLAZED_JAR_3).requires(ModItemTags.JARS).requires(Items.BROWN_DYE).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLAZED_JAR_4).requires(ModItemTags.JARS).requires(Items.GREEN_DYE).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.UNFIRED_POT).define('#', Items.CLAY_BALL).define('x', Items.CLAY).pattern("# #").pattern("x x").pattern("xxx").unlockedBy("has_clay", has(Blocks.CLAY)).save(exporter);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.UNFIRED_POT.asItem()), ModBlocks.FIRED_POT.asItem(), 0.0F, 1600).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.FIRED_POT.asItem()), ModBlocks.GLAZED_POT_0.asItem(), 0.0F, 1600).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItemTags.POTS), ModBlocks.GLAZED_POT_0.asItem(), 0.0F, 1600).unlockedBy("has_clay", has(Items.CLAY)).save(exporter, new ResourceLocation("glazed_pot_from_glazed_pot"));
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLAZED_POT_1).requires(ModItemTags.POTS).requires(Items.WHITE_DYE).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLAZED_POT_2).requires(ModItemTags.POTS).requires(Items.BLACK_DYE).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLAZED_POT_3).requires(ModItemTags.POTS).requires(Items.BROWN_DYE).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.GLAZED_POT_4).requires(ModItemTags.POTS).requires(Items.GREEN_DYE).unlockedBy("has_clay", has(Items.CLAY)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.IRON_LATTICE, 16).define('#', Items.IRON_INGOT).pattern(" # ").pattern("###").pattern(" # ").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(exporter);

        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_WHITE, Items.WHITE_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_ORANGE, Items.ORANGE_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_MAGENTA, Items.MAGENTA_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_LIGHT_BLUE, Items.LIGHT_BLUE_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_YELLOW, Items.YELLOW_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_LIME, Items.LIME_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_PINK, Items.PINK_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_GRAY, Items.GRAY_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_LIGHT_GRAY, Items.LIGHT_GRAY_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_CYAN, Items.CYAN_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_PURPLE, Items.PURPLE_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_BLUE, Items.BLUE_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_BROWN, Items.BROWN_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_GREEN, Items.GREEN_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_RED, Items.RED_WOOL);
        frameWallRecipe(exporter, ModBlocks.FRAMED_WALL_BLACK, Items.BLACK_WOOL);

        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_WHITE, Items.WHITE_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_ORANGE, Items.ORANGE_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_MAGENTA, Items.MAGENTA_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_LIGHT_BLUE, Items.LIGHT_BLUE_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_YELLOW, Items.YELLOW_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_LIME, Items.LIME_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_PINK, Items.PINK_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_GRAY, Items.GRAY_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_LIGHT_GRAY, Items.LIGHT_GRAY_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_CYAN, Items.CYAN_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_PURPLE, Items.PURPLE_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_BLUE, Items.BLUE_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_BROWN, Items.BROWN_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_GREEN, Items.GREEN_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_RED, Items.RED_WOOL);
        frameCrossedRecipe(exporter, ModBlocks.FRAMED_WALL_CROSS_BLACK, Items.BLACK_WOOL);

        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_WHITE, Items.WHITE_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_ORANGE, Items.ORANGE_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_MAGENTA, Items.MAGENTA_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_LIGHT_BLUE, Items.LIGHT_BLUE_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_YELLOW, Items.YELLOW_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_LIME, Items.LIME_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_PINK, Items.PINK_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_GRAY, Items.GRAY_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_LIGHT_GRAY, Items.LIGHT_GRAY_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_CYAN, Items.CYAN_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_PURPLE, Items.PURPLE_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_BLUE, Items.BLUE_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_BROWN, Items.BROWN_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_GREEN, Items.GREEN_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_RED, Items.RED_WOOL);
        frameRtDiagRecipe(exporter, ModBlocks.FRAMED_WALL_RT_DIAG_BLACK, Items.BLACK_WOOL);

        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_WHITE, Items.WHITE_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_ORANGE, Items.ORANGE_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_MAGENTA, Items.MAGENTA_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_LIGHT_BLUE, Items.LIGHT_BLUE_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_YELLOW, Items.YELLOW_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_LIME, Items.LIME_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_PINK, Items.PINK_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_GRAY, Items.GRAY_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_LIGHT_GRAY, Items.LIGHT_GRAY_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_CYAN, Items.CYAN_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_PURPLE, Items.PURPLE_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_BLUE, Items.BLUE_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_BROWN, Items.BROWN_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_GREEN, Items.GREEN_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_RED, Items.RED_WOOL);
        frameLeftDiagRecipe(exporter, ModBlocks.FRAMED_WALL_LEFT_DIAG_BLACK, Items.BLACK_WOOL);

        ShapedRecipeBuilder.shaped(ModBlocks.FERTILE_SOIL).define('#', Blocks.DIRT).define('x', Items.GREEN_DYE).define('t', Items.BONE_MEAL).pattern(" x ").pattern("t#t").unlockedBy("has_dirt", has(Blocks.DIRT)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.IRONWOOD_WOOD).define('#', ModBlocks.IRONWOOD_LOG).pattern("##").pattern("##").unlockedBy("has_log", has(ModBlocks.IRONWOOD_LOG)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.STRIPPED_IRONWOOD_WOOD).define('#', ModBlocks.STRIPPED_IRONWOOD_LOG).pattern("##").pattern("##").unlockedBy("has_log", has(ModBlocks.STRIPPED_IRONWOOD_LOG)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.IRONWOOD_PLANKS, 4).requires(ModBlocks.IRONWOOD_LOG).unlockedBy("has_ironwood", has(ModBlocks.IRONWOOD_LOG)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.IRONWOOD_SLAB, 6).define('#', ModBlocks.IRONWOOD_PLANKS).pattern("###").unlockedBy("has_ironwood", has(ModBlocks.IRONWOOD_PLANKS)).save(exporter);
        stairBuilder(ModBlocks.IRONWOOD_STAIRS, Ingredient.of(new ItemLike[]{ModBlocks.IRONWOOD_PLANKS})).unlockedBy("has_ironwood", has(ModBlocks.IRONWOOD_PLANKS)).save(exporter);
        fenceBuilder(ModBlocks.IRONWOOD_FENCE, Ingredient.of(new ItemLike[]{ModBlocks.IRONWOOD_PLANKS})).unlockedBy("has_ironwood", has(ModBlocks.IRONWOOD_PLANKS)).save(exporter);
        fenceGateBuilder(ModBlocks.IRONWOOD_GATE, Ingredient.of(new ItemLike[]{ModBlocks.IRONWOOD_PLANKS})).unlockedBy("has_ironwood", has(ModBlocks.IRONWOOD_PLANKS)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.OLIVE_WOOD).define('#', ModBlocks.OLIVE_LOG).pattern("##").pattern("##").unlockedBy("has_log", has(ModBlocks.OLIVE_LOG)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.STRIPPED_OLIVE_WOOD).define('#', ModBlocks.STRIPPED_OLIVE_LOG).pattern("##").pattern("##").unlockedBy("has_log", has(ModBlocks.STRIPPED_OLIVE_LOG)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.OLIVE_PLANKS, 4).requires(ModBlocks.OLIVE_LOG).unlockedBy("has_olive", has(ModBlocks.OLIVE_LOG)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.OLIVE_SLAB, 6).define('#', ModBlocks.OLIVE_PLANKS).pattern("###").unlockedBy("has_olive", has(ModBlocks.OLIVE_PLANKS)).save(exporter);
        stairBuilder(ModBlocks.OLIVE_STAIRS, Ingredient.of(new ItemLike[]{ModBlocks.OLIVE_PLANKS})).unlockedBy("has_olive", has(ModBlocks.OLIVE_PLANKS)).save(exporter);
        fenceBuilder(ModBlocks.OLIVE_FENCE, Ingredient.of(new ItemLike[]{ModBlocks.OLIVE_PLANKS})).unlockedBy("has_olive", has(ModBlocks.OLIVE_PLANKS)).save(exporter);
        fenceGateBuilder(ModBlocks.OLIVE_GATE, Ingredient.of(new ItemLike[]{ModBlocks.OLIVE_PLANKS})).unlockedBy("has_olive", has(ModBlocks.OLIVE_PLANKS)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.CROP_STAKE, 4).define('#', ItemTags.PLANKS).pattern(" #").pattern(" #").pattern(" #").unlockedBy("has_planks", has(ItemTags.PLANKS)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.ROPE, 1).define('#', Items.STRING).pattern(" #").pattern(" #").pattern(" #").unlockedBy("has_string", has(Items.STRING)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModItems.GRAPE_SEEDS).requires(ModItems.GRAPES).unlockedBy("has_grapes", has(ModItems.GRAPES)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.CONDENSER).define('#', Blocks.BRICKS).define('^', Blocks.WHITE_TERRACOTTA).define('@', Items.BUCKET).pattern("# #").pattern("^@^").pattern("#^#").unlockedBy("has_bricks", has(Blocks.BRICKS)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.RETORT).define('#', Blocks.BRICKS).define('^', Items.IRON_INGOT).define('@', Items.BUCKET).pattern(" #").pattern("^@").pattern(" #").unlockedBy("has_bricks", has(Blocks.BRICKS)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.ADV_CONDENSER).define('#', Blocks.NETHER_BRICKS).define('^', Blocks.IRON_BLOCK).define('@', Items.BUCKET).pattern("# #").pattern("^@^").pattern("#^#").unlockedBy("has_nether_bricks", has(Blocks.NETHER_BRICKS)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.ADV_RETORT).define('#', Blocks.NETHER_BRICKS).define('^', Items.IRON_INGOT).define('@', Items.BUCKET).pattern(" #").pattern("^@").pattern(" #").unlockedBy("has_nether_bricks", has(Blocks.NETHER_BRICKS)).save(exporter);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.UNFIRED_EVAPORATING_BASIN), ModBlocks.EVAPORATING_BASIN.asItem(), 0.0F, 1600).unlockedBy("has_clay", has(Blocks.CLAY)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.CRUSHING_TUB).define('x', ItemTags.WOODEN_SLABS).define('@', Items.IRON_INGOT).define('^', ItemTags.PLANKS).pattern("^ ^").pattern("@ @").pattern("xxx").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.OAK_BREWING_BARREL).define('x', Items.OAK_SLAB).define('@', Items.IRON_INGOT).define('^', Items.OAK_PLANKS).pattern("^@^").pattern("x x").pattern("^@^").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(exporter);






        ////////////////////////////////////////////////////
        /////                  ITEMS                   /////
        ////////////////////////////////////////////////////
        ShapedRecipeBuilder.shaped(ModItems.CATALOG).define('#', Items.BOOK).define('x', Items.IRON_NUGGET).define('t', ModItems.OLIVES).pattern(" t ").pattern("x#x").pattern(" x ").unlockedBy("has_catalog", has(ModItems.CATALOG)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModItems.COPPER_NUGGET, 9).requires(Items.COPPER_INGOT).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter, new ResourceLocation("copper_nugget_from_copper_ingot"));
        ShapedRecipeBuilder.shaped(Items.COPPER_INGOT).define('#', ModItems.COPPER_NUGGET).pattern("###").pattern("###").pattern("###").unlockedBy("has_catalog", has(ModItems.CATALOG)).save(exporter, new ResourceLocation("copper_ingot_from_copper_nugget"));

        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.ALOE_VERA, Items.BEEF)), Elixirs.HEALING_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.HEALING_ELIXIR.getName("elixir_")));
        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.BLOOD_ORCHID, Items.HONEYCOMB)), Elixirs.REGENERATION_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.REGENERATION_ELIXIR.getName("elixir_")));
        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.NIGHTSHROOM, Items.CARROT)), Elixirs.NIGHT_VISION_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.NIGHT_VISION_ELIXIR.getName("elixir_")));
        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.WIND_THISTLE, Items.SUGAR)), Elixirs.SWIFTNESS_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.SWIFTNESS_ELIXIR.getName("elixir_")));
        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.GREEN_SPORED_ASBESTOS, Items.WEEPING_VINES)), Elixirs.FIRE_RESISTANCE_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.FIRE_RESISTANCE_ELIXIR.getName("elixir_")));
        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.GINSENG, Items.BONE)), Elixirs.STRENGTH_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.STRENGTH_ELIXIR.getName("elixir_")));
        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.CORE_ROOT, Items.KELP)), Elixirs.WATER_BREATHING_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.WATER_BREATHING_ELIXIR.getName("elixir_")));
        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.CLOUD_LILY, Items.FEATHER)), Elixirs.SLOW_FALLING_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.SLOW_FALLING_ELIXIR.getName("elixir_")));
        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.CHAMOMILE, Items.GLOW_BERRIES)), Elixirs.INVISIBILITY_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.INVISIBILITY_ELIXIR.getName("elixir_")));
        CondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.COHOSH, ModItems.IRON_BERRIES)), Elixirs.IRONSKIN_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.IRONSKIN_ELIXIR.getName("elixir_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.ALOE_VERA, Items.BEEF)), Elixirs.HEALING_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.HEALING_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.ALOE_VERA, Items.BEEF, ModItems.HORSETAIL)), Elixirs.HEALING_STRONG_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.HEALING_STRONG_ELIXIR.getName("elixir_adv_strong_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.BLOOD_ORCHID, Items.HONEYCOMB)), Elixirs.REGENERATION_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.REGENERATION_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.BLOOD_ORCHID, Items.HONEYCOMB, ModItems.MARSHMALLOW)), Elixirs.LONG_REGENERATION_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.LONG_REGENERATION_ELIXIR.getName("elixir_adv_long_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.BLOOD_ORCHID, Items.HONEYCOMB, ModItems.HORSETAIL)), Elixirs.STRONG_REGENERATION_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.STRONG_REGENERATION_ELIXIR.getName("elixir_adv_strong_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.NIGHTSHROOM, Items.CARROT)), Elixirs.NIGHT_VISION_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.NIGHT_VISION_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.NIGHTSHROOM, Items.CARROT, ModItems.MARSHMALLOW)), Elixirs.LONG_NIGHT_VISION_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.LONG_NIGHT_VISION_ELIXIR.getName("elixir_adv_long_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.WIND_THISTLE, Items.SUGAR)), Elixirs.SWIFTNESS_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.SWIFTNESS_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.WIND_THISTLE, Items.SUGAR, ModItems.MARSHMALLOW)), Elixirs.LONG_SWIFTNESS_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.LONG_SWIFTNESS_ELIXIR.getName("elixir_adv_long_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.WIND_THISTLE, Items.SUGAR, ModItems.HORSETAIL)), Elixirs.STRONG_SWIFTNESS_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.STRONG_SWIFTNESS_ELIXIR.getName("elixir_adv_strong_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.GREEN_SPORED_ASBESTOS, Items.WEEPING_VINES)), Elixirs.FIRE_RESISTANCE_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.FIRE_RESISTANCE_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.GREEN_SPORED_ASBESTOS, Items.WEEPING_VINES, ModItems.MARSHMALLOW)), Elixirs.LONG_FIRE_RESISTANCE_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.LONG_FIRE_RESISTANCE_ELIXIR.getName("elixir_adv_long_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.GINSENG, Items.BONE)), Elixirs.STRENGTH_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.STRENGTH_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.GINSENG, Items.BONE, ModItems.MARSHMALLOW)), Elixirs.LONG_STRENGTH_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.LONG_STRENGTH_ELIXIR.getName("elixir_adv_long_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.GINSENG, Items.BONE, ModItems.HORSETAIL)), Elixirs.STRONG_STRENGTH_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.STRONG_STRENGTH_ELIXIR.getName("elixir_adv_strong_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.CORE_ROOT, Items.KELP)), Elixirs.WATER_BREATHING_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.WATER_BREATHING_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.CORE_ROOT, Items.KELP, ModItems.MARSHMALLOW)), Elixirs.LONG_WATER_BREATHING_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.LONG_WATER_BREATHING_ELIXIR.getName("elixir_adv_long_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.CLOUD_LILY, Items.FEATHER)), Elixirs.SLOW_FALLING_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.SLOW_FALLING_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.CLOUD_LILY, Items.FEATHER, ModItems.MARSHMALLOW)), Elixirs.LONG_SLOW_FALLING_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.LONG_SLOW_FALLING_ELIXIR.getName("elixir_adv_long_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.CHAMOMILE, Items.GLOW_BERRIES)), Elixirs.INVISIBILITY_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.INVISIBILITY_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.CHAMOMILE, Items.GLOW_BERRIES, ModItems.MARSHMALLOW)), Elixirs.LONG_INVISIBILITY_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.LONG_INVISIBILITY_ELIXIR.getName("elixir_adv_long_")));

        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.COHOSH, ModItems.IRON_BERRIES)), Elixirs.IRONSKIN_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.IRONSKIN_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.COHOSH, ModItems.IRON_BERRIES, ModItems.MARSHMALLOW)), Elixirs.LONG_IRONSKIN_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.LONG_IRONSKIN_ELIXIR.getName("elixir_adv_")));
        AdvCondenserRecipeBuilder.condenser(Collections.singletonList(Ingredient.of(ModItems.COHOSH, ModItems.IRON_BERRIES, ModItems.HORSETAIL)), Elixirs.STRONG_IRONSKIN_ELIXIR).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, Elixirs.STRONG_IRONSKIN_ELIXIR.getName("elixir_adv_")));

        ShapedRecipeBuilder.shaped(ModFluids.ALE_WORT_BUCKET).define('#', Items.BREAD).define('^', Items.SUGAR).define('@', Items.WATER_BUCKET).pattern("#^").pattern("@ ").unlockedBy("has_sugar", has(Items.SUGAR)).save(exporter);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.TINY_IRON_DUST), Items.IRON_NUGGET, 0.0F, 25).unlockedBy("has_tiny_iron", has(ModItems.TINY_IRON_DUST)).save(exporter, new ResourceLocation(Items.IRON_NUGGET.toString() + "_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.TINY_IRON_DUST), Items.IRON_NUGGET, 0.0F, 25).unlockedBy("has_tiny_iron", has(ModItems.TINY_IRON_DUST)).save(exporter, new ResourceLocation(Items.IRON_NUGGET.toString() + "_blasting"));
        ShapedRecipeBuilder.shaped(ModItems.UNFIRED_EVAPORATING_BASIN).define('#', Blocks.CLAY).pattern("# #").pattern(" # ").unlockedBy("has_clay", has(Blocks.CLAY)).save(exporter);

        EvaporatingBasinRecipeBuilder.evaporating(ModItems.TINY_IRON_DUST.getDefaultInstance(), ModFluids.IRONBERRY_JUICE_BUCKET.getDefaultInstance()).unlockedBy("has_bucket", has(Items.BUCKET)).save(exporter, new ResourceLocation(MODID, ModItems.TINY_IRON_DUST.toString() + "_evaporating"));
        EvaporatingBasinRecipeBuilder.evaporating(Blocks.HONEY_BLOCK.asItem().getDefaultInstance(), ModFluids.HONEY_BUCKET.getDefaultInstance()).unlockedBy("has_bucket", has(Items.BUCKET)).save(exporter, new ResourceLocation(MODID, Items.HONEY_BLOCK.toString() + "_evaporating"));


        CrushingTubRecipeBuilder.crushing(ModItems.OLIVES.getDefaultInstance(), ModFluids.OLIVE_OIL_BUCKET.getDefaultInstance(), ModItems.OLIVE_OIL_BOTTLE.getDefaultInstance(), Items.AIR.getDefaultInstance()).unlockedBy("has_olives", has(ModItems.OLIVES)).save(exporter, new ResourceLocation(MODID, ModItems.OLIVES + "_crushed"));
        CrushingTubRecipeBuilder.crushing(ModItems.IRON_BERRIES.getDefaultInstance(), ModFluids.IRONBERRY_JUICE_BUCKET.getDefaultInstance(), ModItems.IRONBERRY_JUICE_BOTTLE.getDefaultInstance(), Items.AIR.getDefaultInstance()).unlockedBy("has_iron_berries", has(ModItems.IRON_BERRIES)).save(exporter, new ResourceLocation(MODID, ModItems.IRON_BERRIES + "_crushed"));
        //CrushingTubRecipeBuilder.crushing(Items.SUGAR_CANE.getDefaultInstance(), Items.WATER_BUCKET.getDefaultInstance(), Items.POTION.getDefaultInstance(), Items.SUGAR.getDefaultInstance()).unlockedBy("has_sugar_cane", has(Items.SUGAR_CANE)).save(exporter, new ResourceLocation(Items.SUGAR_CANE + "_crushed"));
        CrushingTubRecipeBuilder.crushing(Items.SWEET_BERRIES.getDefaultInstance(), ModFluids.SWEET_BERRY_JUICE_BUCKET.getDefaultInstance(), ModItems.SWEET_BERRY_JUICE_BOTTLE.getDefaultInstance(), Items.AIR.getDefaultInstance()).unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES)).save(exporter, new ResourceLocation(MODID, Items.SWEET_BERRIES + "_crushed"));
        CrushingTubRecipeBuilder.crushing(ModItems.GRAPES.getDefaultInstance(), ModFluids.GRAPE_JUICE_BUCKET.getDefaultInstance(), ModItems.GRAPE_JUICE_BOTTLE.getDefaultInstance(), Items.AIR.getDefaultInstance()).unlockedBy("has_grapes", has(ModItems.GRAPES)).save(exporter, new ResourceLocation(MODID, ModItems.GRAPES + "_crushed"));
        CrushingTubRecipeBuilder.crushing(Items.APPLE.getDefaultInstance(), ModFluids.APPLE_JUICE_BUCKET.getDefaultInstance(), ModItems.APPLE_JUICE_BOTTLE.getDefaultInstance(), Items.AIR.getDefaultInstance()).unlockedBy("has_apples", has(Items.APPLE)).save(exporter, new ResourceLocation(MODID, Items.APPLE + "_crushed"));
        CrushingTubRecipeBuilder.crushing(Items.HONEYCOMB.getDefaultInstance(), ModFluids.HONEY_BUCKET.getDefaultInstance(), Items.HONEY_BOTTLE.getDefaultInstance(), Items.AIR.getDefaultInstance()).unlockedBy("has_honey", has(Items.HONEYCOMB)).save(exporter, new ResourceLocation(MODID, Items.HONEYCOMB + "_crushed"));

        BrewingBarrelRecipeBuilder.brewing(ModItems.ALE_CUP.getDefaultInstance(), ModFluids.SOURCE_ALE_WORT.getSource(), ModFluids.SOURCE_ALE.getSource()).unlockedBy("has_iron_berries", has(ModFluids.ALE_WORT_BUCKET)).save(exporter, new ResourceLocation(MODID, "brewed_ale"));
        BrewingBarrelRecipeBuilder.brewing(ModItems.CIDER_CUP.getDefaultInstance(), ModFluids.SOURCE_APPLE_JUICE.getSource(), ModFluids.SOURCE_CIDER.getSource()).unlockedBy("has_apples", has(Items.APPLE)).save(exporter, new ResourceLocation(MODID,"brewed_cider"));
        BrewingBarrelRecipeBuilder.brewing(ModItems.IRON_WINE_CUP.getDefaultInstance(), ModFluids.SOURCE_IRONBERRY_JUICE.getSource(), ModFluids.SOURCE_IRON_WINE.getSource()).unlockedBy("has_iron_berries", has(ModItems.IRON_BERRIES)).save(exporter, new ResourceLocation(MODID,"brewed_iron_wine"));
        BrewingBarrelRecipeBuilder.brewing(ModItems.MEAD_CUP.getDefaultInstance(), ModFluids.SOURCE_HONEY.getSource(), ModFluids.SOURCE_MEAD.getSource()).unlockedBy("has_honey", has(Items.HONEYCOMB)).save(exporter, new ResourceLocation(MODID,"brewed_mead"));
        BrewingBarrelRecipeBuilder.brewing(ModItems.SWEET_BERRY_WINE_CUP.getDefaultInstance(), ModFluids.SOURCE_SWEET_BERRY_JUICE.getSource(), ModFluids.SOURCE_SWEET_BERRY_WINE.getSource()).unlockedBy("has_sweet_berries", has(Items.SWEET_BERRIES)).save(exporter, new ResourceLocation(MODID,"brewed_sweet_berry_wine"));
        BrewingBarrelRecipeBuilder.brewing(ModItems.WINE_CUP.getDefaultInstance(), ModFluids.SOURCE_GRAPE_JUICE.getSource(), ModFluids.SOURCE_WINE.getSource()).unlockedBy("has_grapes", has(ModItems.GRAPES)).save(exporter, new ResourceLocation(MODID,"brewed_wine"));
        ShapelessRecipeBuilder.shapeless(Items.GLASS_BOTTLE).requires(ModItemTags.BOOZE_ITEMS).unlockedBy("has_bottle", has(Items.GLASS_BOTTLE)).save(exporter, new ResourceLocation(MODID, "alcoholic_drink_to_glass_bottle"));

        ShapedRecipeBuilder.shaped(ModItems.OILED_APPLE).define('#', Items.APPLE).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.APPLE));
        ShapedRecipeBuilder.shaped(ModItems.OILED_BAKED_POTATO).define('#', Items.BAKED_POTATO).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.BAKED_POTATO));
        ShapedRecipeBuilder.shaped(ModItems.OILED_BEEF).define('#', Items.BEEF).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.BEEF));
        ShapedRecipeBuilder.shaped(ModItems.OILED_BEETROOT).define('#', Items.BEETROOT).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.BEETROOT));
        ShapedRecipeBuilder.shaped(ModItems.OILED_BEETROOT_SOUP).define('#', Items.BEETROOT_SOUP).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.BEETROOT_SOUP));
        ShapedRecipeBuilder.shaped(ModItems.OILED_BREAD).define('#', Items.BREAD).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.BREAD));
        ShapedRecipeBuilder.shaped(ModItems.OILED_CARROT).define('#', Items.CARROT).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.CARROT));
        ShapedRecipeBuilder.shaped(ModItems.OILED_CHICKEN).define('#', Items.CHICKEN).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.CHICKEN));
        ShapedRecipeBuilder.shaped(ModItems.OILED_CHORUS_FRUIT).define('#', Items.CHORUS_FRUIT).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.CHORUS_FRUIT));
        ShapedRecipeBuilder.shaped(ModItems.OILED_COD).define('#', Items.COD).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.COD));
        ShapedRecipeBuilder.shaped(ModItems.OILED_COOKED_BEEF).define('#', Items.COOKED_BEEF).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.COOKED_BEEF));
        ShapedRecipeBuilder.shaped(ModItems.OILED_COOKED_CHICKEN).define('#', Items.COOKED_CHICKEN).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.COOKED_CHICKEN));
        ShapedRecipeBuilder.shaped(ModItems.OILED_COOKED_COD).define('#', Items.COOKED_COD).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.COOKED_COD));
        ShapedRecipeBuilder.shaped(ModItems.OILED_COOKED_MUTTON).define('#', Items.COOKED_MUTTON).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.COOKED_MUTTON));
        ShapedRecipeBuilder.shaped(ModItems.OILED_COOKED_PORKCHOP).define('#', Items.COOKED_PORKCHOP).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.COOKED_PORKCHOP));
        ShapedRecipeBuilder.shaped(ModItems.OILED_COOKED_RABBIT).define('#', Items.COOKED_RABBIT).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.COOKED_RABBIT));
        ShapedRecipeBuilder.shaped(ModItems.OILED_COOKED_SALMON).define('#', Items.COOKED_SALMON).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.COOKED_SALMON));
        ShapedRecipeBuilder.shaped(ModItems.OILED_COOKIE).define('#', Items.COOKIE).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.COOKIE));
        ShapedRecipeBuilder.shaped(ModItems.OILED_DRIED_KELP).define('#', Items.DRIED_KELP).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.DRIED_KELP));
        ShapedRecipeBuilder.shaped(ModItems.OILED_GOLDEN_APPLE).define('#', Items.GOLDEN_APPLE).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.GOLDEN_APPLE));
        ShapedRecipeBuilder.shaped(ModItems.OILED_GOLDEN_CARROT).define('#', Items.GOLDEN_CARROT).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.GOLDEN_CARROT));
        ShapedRecipeBuilder.shaped(ModItems.OILED_MELON_SLICE).define('#', Items.MELON_SLICE).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.MELON_SLICE));
        ShapedRecipeBuilder.shaped(ModItems.OILED_MUSHROOM_STEW).define('#', Items.MUSHROOM_STEW).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.MUSHROOM_STEW));
        ShapedRecipeBuilder.shaped(ModItems.OILED_MUTTON).define('#', Items.MUTTON).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.MUTTON));
        ShapedRecipeBuilder.shaped(ModItems.OILED_POISONOUS_POTATO).define('#', Items.POISONOUS_POTATO).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.POISONOUS_POTATO));
        ShapedRecipeBuilder.shaped(ModItems.OILED_PORKCHOP).define('#', Items.PORKCHOP).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.PORKCHOP));
        ShapedRecipeBuilder.shaped(ModItems.OILED_POTATO).define('#', Items.POTATO).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.POTATO));
        ShapedRecipeBuilder.shaped(ModItems.OILED_PUFFERFISH).define('#', Items.PUFFERFISH).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.PUFFERFISH));
        ShapedRecipeBuilder.shaped(ModItems.OILED_PUMPKIN_PIE).define('#', Items.PUMPKIN_PIE).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.PUMPKIN_PIE));
        ShapedRecipeBuilder.shaped(ModItems.OILED_RABBIT).define('#', Items.RABBIT).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.RABBIT));
        ShapedRecipeBuilder.shaped(ModItems.OILED_RABBIT_STEW).define('#', Items.RABBIT_STEW).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.RABBIT_STEW));
        ShapedRecipeBuilder.shaped(ModItems.OILED_ROTTEN_FLESH).define('#', Items.ROTTEN_FLESH).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.ROTTEN_FLESH));
        ShapedRecipeBuilder.shaped(ModItems.OILED_SALMON).define('#', Items.SALMON).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.SALMON));
        ShapedRecipeBuilder.shaped(ModItems.OILED_SPIDER_EYE).define('#', Items.SPIDER_EYE).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.SPIDER_EYE));
        ShapedRecipeBuilder.shaped(ModItems.OILED_SUSPICIOUS_STEW).define('#', Items.SUSPICIOUS_STEW).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.SUSPICIOUS_STEW));
        ShapedRecipeBuilder.shaped(ModItems.OILED_SWEET_BERRIES).define('#', Items.SWEET_BERRIES).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.SWEET_BERRIES));
        ShapedRecipeBuilder.shaped(ModItems.OILED_GLOW_BERRIES).define('#', Items.GLOW_BERRIES).define('^', ModItems.OLIVE_OIL_BOTTLE).pattern("#^").unlockedBy("has_olive_oil", has(ModItems.OLIVE_OIL_BOTTLE)).save(exporter, new ResourceLocation("oiled_" + Items.GLOW_BERRIES));
    }

    public static void coloredWoodRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.PLANKS).define('x', input).pattern("###").pattern("#x#").pattern("###").group("painted_wood").unlockedBy("has_plank", has(Blocks.OAK_PLANKS)).save(exporter);
    }

    public static void coloredStairsRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, ItemLike dyeInput, @Nullable String dyedRecipeName)
    {
        stairBuilder(output, Ingredient.of(new ItemLike[]{input})).group("painted_stairs").unlockedBy("has_stairs", has(Blocks.OAK_PLANKS)).save(exporter);
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.WOODEN_STAIRS).define('x', dyeInput).pattern("###").pattern("#x#").pattern("###").group("painted_stairs").unlockedBy("has_stair", has(Blocks.OAK_PLANKS)).save(exporter, new ResourceLocation(dyedRecipeName));
    }

    public static void coloredStoneSlabRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike inputCutter, ItemLike dyeInput,TagKey<Item> itemTagKey, @Nullable String dyedRecipeName)
    {
        ShapedRecipeBuilder.shaped(output, 6).define('#', inputCutter).pattern("###").group("colored_cobblestone").unlockedBy("is_cobblestone", has(Blocks.COBBLESTONE)).save(exporter);
        ShapedRecipeBuilder.shaped(output, 8).define('#', itemTagKey).define('x', dyeInput).pattern("###").pattern("#x#").pattern("###").group("colored_cobblestone").unlockedBy("is_cobblestone", has(Blocks.COBBLESTONE)).save(exporter, new ResourceLocation(dyedRecipeName));
        stonecutterResultFromBase(exporter, output, inputCutter, 2);
    }

    public static void coloredStoneRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike dyeInput, ItemLike cobbleItem, @Nullable String dyedRecipeName)
    {
        ShapedRecipeBuilder.shaped(output, 8).define('#', ModItemTags.COLORED_STONE).define('x', dyeInput).pattern("###").pattern("#x#").pattern("###").group("colored_cobblestone").unlockedBy("is_cobblestone", has(Blocks.COBBLESTONE)).save(exporter, new ResourceLocation(dyedRecipeName));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(cobbleItem), output, 0.0F, 200).unlockedBy("has_stone", has(Items.STONE)).save(exporter);
    }

    public static void coloredCobbleStoneRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike dyeInput)
    {
        ShapedRecipeBuilder.shaped(output, 8).define('#', ModItemTags.COLORED_COBBLESTONE).define('x', dyeInput).pattern("###").pattern("#x#").pattern("###").group("colored_cobblestone").unlockedBy("is_cobblestone", has(Blocks.COBBLESTONE)).save(exporter);
    }

    public static void coloredStoneStairsRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike inputCutter, ItemLike dyeInput, TagKey<Item> itemTagKey, @Nullable String dyedRecipeName)
    {
        ShapedRecipeBuilder.shaped(output, 4).define('#', inputCutter).pattern("#  ").pattern("## ").pattern("###").group("colored_cobblestone").unlockedBy("is_cobblestone", has(Blocks.COBBLESTONE)).save(exporter);
        ShapedRecipeBuilder.shaped(output, 8).define('#', itemTagKey).define('x', dyeInput).pattern("###").pattern("#x#").pattern("###").group("colored_cobblestone").unlockedBy("is_cobblestone", has(Blocks.COBBLESTONE)).save(exporter, new ResourceLocation(dyedRecipeName));
        stonecutterResultFromBase(exporter, output, inputCutter, 1);
    }

    public static void coloredStoneWallRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike inputCutter, TagKey<Item> itemTagKey, ItemLike dyeInput, Block materialBlock, @Nullable String dyedRecipeName)
    {
        ShapedRecipeBuilder.shaped(output, 6).define('#', inputCutter).pattern("###").pattern("###").unlockedBy(getHasName(materialBlock), has(materialBlock)).save(exporter);
        ShapedRecipeBuilder.shaped(output, 8).define('#', itemTagKey).define('x', dyeInput).pattern("###").pattern("#x#").pattern("###").group("colored_cobblestone").unlockedBy(getHasName(materialBlock), has(materialBlock)).save(exporter, new ResourceLocation(dyedRecipeName));
        stonecutterResultFromBase(exporter, output, inputCutter);
    }

    public static void coloredSlabRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, ItemLike dyeInput, @Nullable String dyedRecipeName)
    {
        slab(exporter, output, input);
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.WOODEN_SLABS).define('x', dyeInput).pattern("###").pattern("#x#").pattern("###").group("painted_slabs").unlockedBy("has_slab", has(Blocks.OAK_PLANKS)).save(exporter, new ResourceLocation(dyedRecipeName));
    }

    public static void frameCrossedRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.PLANKS).define('x', input).define('t', Items.STICK).pattern("#t#").pattern("txt").pattern("#t#").group("framed_walls").unlockedBy("has_wool", has(Blocks.OAK_PLANKS)).save(exporter);
    }

    public static void frameRtDiagRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.PLANKS).define('x', input).define('t', Items.STICK).pattern("# #").pattern(" xt").pattern("#t#").group("framed_walls").unlockedBy("has_wool", has(Blocks.OAK_PLANKS)).save(exporter);
    }

    public static void frameLeftDiagRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.PLANKS).define('x', input).define('t', Items.STICK).pattern("# #").pattern("tx ").pattern("#t#").group("framed_walls").unlockedBy("has_wool", has(Blocks.OAK_PLANKS)).save(exporter);
    }

    public static void frameWallRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.PLANKS).define('x', input).pattern("# #").pattern(" x ").pattern("# #").group("framed_walls").unlockedBy("has_wool", has(Blocks.OAK_PLANKS)).save(exporter);
    }

    public static void pathRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, ItemLike inputCutter)
    {
        stonecutterResultFromBase(exporter, output, inputCutter, 16);
        ShapedRecipeBuilder.shaped(output, 16).define('#', input).pattern("# #").pattern(" # ").pattern("###").group("path_blocks").unlockedBy("is_path", has(Blocks.STONE)).save(exporter);
    }
}
