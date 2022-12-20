package net.mcs3.rusticated.world.item.crafting;

import net.mcs3.rusticated.Rusticated;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;


public class ModRecipes
{
    private static String MOD_ID = Rusticated.MOD_ID;

    public static final CondenserRecipe.Serializer CONDENSER_RECIPE_SERIALIZER = CondenserRecipe.Serializer.INSTANCE;
    public static final RecipeType<CondenserRecipe> CONDENSER_RECIPE_TYPE = CondenserRecipe.Type.INSTANCE;


    public static final AdvCondenserRecipe.Serializer ADV_CONDENSER_RECIPE_SERIALIZER = AdvCondenserRecipe.Serializer.INSTANCE;
    public static final RecipeType<AdvCondenserRecipe> ADV_CONDENSER_RECIPE_TYPE = AdvCondenserRecipe.Type.INSTANCE;

    public static final EvaporatingBasinRecipe.Serializer EVAPORATING_RECIPE_SERIALIZER = EvaporatingBasinRecipe.Serializer.INSTANCE;
    public static final RecipeType<EvaporatingBasinRecipe> EVAPORATING_RECIPE_TYPE = EvaporatingBasinRecipe.Type.INSTANCE;

    public static final CrushingTubRecipe.Serializer CRUSHING_RECIPE_SERIALIZER = CrushingTubRecipe.Serializer.INSTANCE;
    public static final RecipeType<CrushingTubRecipe> CRUSHING_RECIPE_TYPE = CrushingTubRecipe.Type.INSTANCE;
    public static void onRecipeRegistry()
    {
        Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(MOD_ID, CondenserRecipe.Serializer.ID), CONDENSER_RECIPE_SERIALIZER);
        Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(MOD_ID, AdvCondenserRecipe.Serializer.ID), ADV_CONDENSER_RECIPE_SERIALIZER);
        Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(MOD_ID, EvaporatingBasinRecipe.Serializer.ID), EVAPORATING_RECIPE_SERIALIZER);
        Registry.register(Registry.RECIPE_SERIALIZER, new ResourceLocation(MOD_ID, CrushingTubRecipe.Serializer.ID), CRUSHING_RECIPE_SERIALIZER);

        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(MOD_ID, CondenserRecipe.Type.ID), CondenserRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(MOD_ID, AdvCondenserRecipe.Type.ID), AdvCondenserRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(MOD_ID, EvaporatingBasinRecipe.Type.ID), EvaporatingBasinRecipe.Type.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(MOD_ID, CrushingTubRecipe.Type.ID), CrushingTubRecipe.Type.INSTANCE);

    }
}
