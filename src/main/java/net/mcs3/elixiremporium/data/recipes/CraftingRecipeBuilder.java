package net.mcs3.elixiremporium.data.recipes;

import com.google.common.collect.BiMap;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModItems;
import net.mcs3.elixiremporium.util.CopperStateMap;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CraftingRecipeBuilder extends FabricRecipeProvider
{
    public CraftingRecipeBuilder(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<FinishedRecipe> exporter)
    {
        ////////////////////////////////////////////////////
        /////                 BLOCKS                   /////
        ////////////////////////////////////////////////////
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
        pathRecipe(exporter, ModBlocks.ANDESITE_PATH, Blocks.STONE_SLAB, Blocks.GRANITE);
        pathRecipe(exporter, ModBlocks.DIORITE_PATH, Blocks.DIORITE_SLAB, Blocks.DIORITE);
        pathRecipe(exporter, ModBlocks.COBBLED_DEEPSLATE_PATH, Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.COBBLED_DEEPSLATE);
        pathRecipe(exporter, ModBlocks.BLACKSTONE_PATH, Blocks.BLACKSTONE_SLAB, Blocks.BLACKSTONE);
        pathRecipe(exporter, ModBlocks.NETHER_BRICKS_PATH, Blocks.NETHER_BRICK_SLAB, Blocks.NETHER_BRICKS);

        ShapedRecipeBuilder.shaped(ModBlocks.CHANDELIER_IRON, 2).define('#', Items.IRON_INGOT).define('X', Items.CHAIN).pattern(" # ").pattern("X X").pattern("###").unlockedBy("has_iron", has(Items.IRON_INGOT)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.CHANDELIER_GOLD, 2).define('#', Items.GOLD_INGOT).define('X', ModBlocks.CHAIN_GOLD.asItem()).pattern(" # ").pattern("X X").pattern("###").unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.CHANDELIER_COPPER, 2).define('#', Items.COPPER_INGOT).define('X', ModBlocks.CHAIN_COPPER.asItem()).pattern(" # ").pattern("X X").pattern("###").unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.CHAIN_GOLD).define('#', Items.GOLD_INGOT).define('X', Items.GOLD_NUGGET).pattern("X").pattern("#").pattern("X").unlockedBy("has_gold", has(Items.GOLD_INGOT)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.CHAIN_COPPER).define('#', Items.COPPER_INGOT).define('X', ModItems.COPPER_NUGGET).pattern("X").pattern("#").pattern("X").unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);

        ShapelessRecipeBuilder.shapeless(ModBlocks.CHAIN_WAXED_COPPER).requires(ModBlocks.CHAIN_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHAIN_WAXED_EXPOSED_COPPER).requires(ModBlocks.CHAIN_EXPOSED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHAIN_WAXED_WEATHERED_COPPER).requires(ModBlocks.CHAIN_WEATHERED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHAIN_WAXED_OXIDIZED_COPPER).requires(ModBlocks.CHAIN_OXIDIZED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHANDELIER_WAXED_COPPER).requires(ModBlocks.CHANDELIER_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHANDELIER_WAXED_EXPOSED_COPPER).requires(ModBlocks.CHANDELIER_EXPOSED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHANDELIER_WAXED_WEATHERED_COPPER).requires(ModBlocks.CHANDELIER_WEATHERED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModBlocks.CHANDELIER_WAXED_OXIDIZED_COPPER).requires(ModBlocks.CHANDELIER_OXIDIZED_COPPER).requires(Items.HONEYCOMB).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter);

        ShapedRecipeBuilder.shaped(ModBlocks.BARREL).define('#', Items.IRON_INGOT).define('X', ItemTags.SLABS).define('P', ItemTags.PLANKS).pattern("PXP").pattern("# #").pattern("PXP").unlockedBy("has_wood", has(Blocks.OAK_PLANKS)).save(exporter);
        ShapedRecipeBuilder.shaped(ModBlocks.LIQUID_BARREL).define('#', Items.IRON_INGOT).define('X', ItemTags.SLABS).define('P', ItemTags.PLANKS).pattern("P P").pattern("# #").pattern("PXP").unlockedBy("has_wood", has(Blocks.OAK_PLANKS)).save(exporter);


        ////////////////////////////////////////////////////
        /////                  ITEMS                   /////
        ////////////////////////////////////////////////////
        ShapedRecipeBuilder.shaped(ModItems.CATALOG).define('#', Items.BOOK).define('X', Items.IRON_NUGGET).define('T', ModItems.OLIVES).pattern(" T ").pattern("X#X").pattern(" X ").unlockedBy("has_catalog", has(ModItems.CATALOG)).save(exporter);
        ShapelessRecipeBuilder.shapeless(ModItems.COPPER_NUGGET, 9).requires(Items.COPPER_INGOT).unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(exporter, new ResourceLocation("copper_nugget_from_copper_ingot"));
        ShapedRecipeBuilder.shaped(Items.COPPER_INGOT).define('#', ModItems.COPPER_NUGGET).pattern("###").pattern("###").pattern("###").unlockedBy("has_catalog", has(ModItems.CATALOG)).save(exporter, new ResourceLocation("copper_ingot_from_copper_nugget"));


    }

    public static void coloredWoodRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input) {
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.PLANKS).define('X', input).pattern("###").pattern("#X#").pattern("###").group("painted_wood").unlockedBy("has_plank", has(Blocks.OAK_PLANKS)).save(exporter);
    }

    public static void coloredStairsRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, ItemLike dyeInput, @Nullable String dyedRecipeName)
    {
        stairBuilder(output, Ingredient.of(new ItemLike[]{input})).group("painted_stairs").unlockedBy("has_stairs", has(Blocks.OAK_PLANKS)).save(exporter);
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.WOODEN_STAIRS).define('X', dyeInput).pattern("###").pattern("#X#").pattern("###").group("painted_stairs").unlockedBy("has_stair", has(Blocks.OAK_PLANKS)).save(exporter, new ResourceLocation(dyedRecipeName));
    }

    public static void coloredSlabRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, ItemLike dyeInput, @Nullable String dyedRecipeName)
    {
        slab(exporter, output, input);
        ShapedRecipeBuilder.shaped(output, 8).define('#', ItemTags.WOODEN_SLABS).define('X', dyeInput).pattern("###").pattern("#X#").pattern("###").group("painted_slabs").unlockedBy("has_slab", has(Blocks.OAK_PLANKS)).save(exporter, new ResourceLocation(dyedRecipeName));
    }

    public static void pathRecipe(Consumer<FinishedRecipe> exporter, ItemLike output, ItemLike input, ItemLike inputCutter)
    {
        stonecutterResultFromBase(exporter, output, inputCutter, 16);
        ShapedRecipeBuilder.shaped(output, 16).define('#', input).pattern("# #").pattern(" # ").pattern("###").group("path_blocks").unlockedBy("is_path", has(Blocks.STONE)).save(exporter);
    }
}
