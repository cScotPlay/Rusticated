package net.mcs3.elixiremporium.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.*;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.client.screens.inventory.CondenserScreen;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModItems;
import net.mcs3.elixiremporium.util.NbtUtility;
import net.mcs3.elixiremporium.world.item.alchmey.Elixirs;
import net.mcs3.elixiremporium.world.item.crafting.CondenserRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.*;

public class ElixirJEIPlugin implements IModPlugin {
    private static final ResourceLocation ID = new ResourceLocation(ElixirEmporium.MOD_ID, "main");

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registry) {
//        IIngredientSubtypeInterpreter<ItemStack> interpreter = (stack, ctx) -> ElixirItem.getSubtype(stack);
//        registry.registerSubtypeInterpreter(VanillaTypes.ITEM_STACK, ModItems.ELIXIR, interpreter);
        for (Potion potion : Elixirs.ELIXIRS) {
            if (potion == Potions.EMPTY) continue;{
                ItemStack item = PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), potion);
                registry.registerSubtypeInterpreter(
                        VanillaTypes.ITEM_STACK, item.getItem(), (stack, $) -> NbtUtility.getString(stack, "elixir")
                );
            }
        }
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
    }

    @Override
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
}
