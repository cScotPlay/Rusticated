package net.mcs3.elixiremporium.world.item.crafting;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;


public class ModRecipes
{
    private static String MOD_ID = ElixirEmporium.MOD_ID;

    public static final CondenserRecipe.Serializer CONDENSER_RECIPE_SERIALIZER = CondenserRecipe.Serializer.INSTANCE;
    public static final RecipeType<CondenserRecipe> CONDENSER_RECIPE_TYPE = CondenserRecipe.Type.INSTANCE;

    public static void onRecipeRegistry()
    {
        Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(MOD_ID, CondenserRecipe.Serializer.ID), CONDENSER_RECIPE_SERIALIZER);
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(MOD_ID, CondenserRecipe.Type.ID), CondenserRecipe.Type.INSTANCE);
    }
}
