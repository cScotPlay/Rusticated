package net.mcs3.elixiremporium.compat.jei;

import com.terraformersmc.modmenu.util.mod.Mod;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.*;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.client.screens.inventory.CondenserScreen;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModItems;
import net.mcs3.elixiremporium.world.item.alchmey.Elixirs;
import net.mcs3.elixiremporium.world.item.crafting.CondenserRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.*;

public class ElixirJEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation(ElixirEmporium.MOD_ID, "main");

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registry) {
        registry.useNbtForSubtypes(ModItems.ELIXIR);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {

        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(
                new CondenserRecipeCategory(guiHelper)
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<CondenserRecipe> recipes = rm.getAllRecipesFor(CondenserRecipe.Type.INSTANCE);
        registration.addRecipes(CondenserRecipeCategory.TYPE, recipes);
//        IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
//        registration.addRecipes(CondenserRecipeCategory.TYPE, getElixirBrewingRecipe(factory, List.of(
//                        ModItems.CHAMOMILE.getDefaultInstance(),
//                        Items.BEEF.getDefaultInstance()),
//                        PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR),
//                        PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR)));
//        registration.addRecipes(CondenserRecipeCategory.TYPE, List.of(
//                getElixirBrewingRecipe(factory, List.of(
//                        ModItems.CHAMOMILE.getDefaultInstance(),
//                        Items.BEEF.getDefaultInstance()),
//                        PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR),
//                        PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR)),
//                getElixirBrewingRecipe(factory, List.of(
//                        ModItems.CHAMOMILE.getDefaultInstance(),
//                        Items.BEEF.getDefaultInstance()),
//                        PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR),
//                        PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR))
//                ));
////        registration.addRecipes(CondenserRecipeCategory.TYPE, List.of(
////                getElixirBrewingRecipe(factory, List.of(
////                        ModItems.CHAMOMILE.getDefaultInstance(),
////                        Items.BEEF.getDefaultInstance()),
////                PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR),
////                PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR));
//
////        registration.addRecipes(CondenserRecipeCategory.TYPE, List.of(
////                getElixirBrewingRecipe(factory, List.of(),
////                        PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR),
////                PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), Elixirs.HEALING_ELIXIR))
////        ));
    }


    @Override
    @SuppressWarnings("Deprecated")
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CONDENSER), CondenserRecipeCategory.UID);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CondenserScreen.class, 44, 29, 50, 28, CondenserRecipeCategory.TYPE);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    private static IJeiBrewingRecipe getElixirBrewingRecipe(IVanillaRecipeFactory factory, List<ItemStack> ingredients , ItemStack inputPotion, ItemStack outputPotion)
    {
        return factory.createBrewingRecipe(
                ingredients.stream().toList(),
                inputPotion,
                outputPotion);
    }
}
