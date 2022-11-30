package net.mcs3.elixiremporium.world.item.crafting;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipes
{
    private static String MOD_ID = ElixirEmporium.MOD_ID;

    public static void onRecipeRegistry()
    {
        Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(MOD_ID, CondenserRecipe.Serializer.ID), CondenserRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(MOD_ID, CondenserRecipe.Type.ID), CondenserRecipe.Type.INSTANCE);

    }

//    public static RecipeSerializer<CondenserRecipe> CONDENSER_RECIPE;
//
//    public static RecipeType<CondenserRecipe> CONDENSER_RECIPE_RECIPE_TYPE;
//
//    public static void onRecipeRegistry()
//    {
//        CONDENSER_RECIPE = RecipeSerializer.register(new ResourceLocation(MOD_ID, "condenser").toString(), new CondenserRecipe.Serializer());
//        //Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(MOD_ID, CondenserRecipe.Serializer.ID), CondenserRecipe.Serializer.INSTANCE);
//        //Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(MOD_ID, CondenserRecipe.Type.ID), CondenserRecipe.Type.INSTANCE);
//        CONDENSER_RECIPE_RECIPE_TYPE = RecipeType.register(new ResourceLocation(MOD_ID, "condenser").toString());
//    }
}
