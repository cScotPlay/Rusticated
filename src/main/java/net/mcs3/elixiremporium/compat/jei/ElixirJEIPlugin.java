package net.mcs3.elixiremporium.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.*;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.client.screens.inventory.AdvCondenserScreen;
import net.mcs3.elixiremporium.client.screens.inventory.CondenserScreen;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModItems;
import net.mcs3.elixiremporium.world.item.crafting.AdvCondenserRecipe;
import net.mcs3.elixiremporium.world.item.crafting.CondenserRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
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
                new CondenserRecipeCategory(guiHelper),
                new AdvCondenserRecipeCategory(guiHelper)
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<CondenserRecipe> condenserRecipes = rm.getAllRecipesFor(CondenserRecipe.Type.INSTANCE);
        registration.addRecipes(CondenserRecipeCategory.TYPE, condenserRecipes);

        List<AdvCondenserRecipe> advCondenserRecipes = rm.getAllRecipesFor(AdvCondenserRecipe.Type.INSTANCE);
        registration.addRecipes(AdvCondenserRecipeCategory.TYPE, advCondenserRecipes);
    }


    @Override
    @SuppressWarnings("Deprecated")
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CONDENSER), CondenserRecipeCategory.UID);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ADV_CONDENSER), AdvCondenserRecipeCategory.UID);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CondenserScreen.class, 44, 29, 50, 28, CondenserRecipeCategory.TYPE);
        registration.addRecipeClickArea(AdvCondenserScreen.class, 44, 29, 50, 28, AdvCondenserRecipeCategory.TYPE);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }
}
