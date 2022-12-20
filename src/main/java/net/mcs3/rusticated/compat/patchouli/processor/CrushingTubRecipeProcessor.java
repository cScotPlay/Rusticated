package net.mcs3.rusticated.compat.patchouli.processor;

import net.mcs3.rusticated.world.item.crafting.CrushingTubRecipe;
import net.mcs3.rusticated.world.item.crafting.EvaporatingBasinRecipe;
import net.mcs3.rusticated.world.item.crafting.ModRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

import java.util.List;

public class CrushingTubRecipeProcessor implements IComponentProcessor {
    private CrushingTubRecipe recipe;


    @Override
    public void setup(IVariableProvider variables) {
        ResourceLocation id = new ResourceLocation(variables.get("recipes").asString());
        List<CrushingTubRecipe> recipes = Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipes.CRUSHING_RECIPE_TYPE);
        for(CrushingTubRecipe r : recipes) {
            if(!r.getId().getPath().equals(id.getPath())) continue; {
                recipe = r;
            }
        }
        if(recipe == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public IVariable process(String key) {

        if (key.equals("ingredient")) {
            return IVariable.from(recipe.getResultItem());
        }
        if(key.equals("fluidbucket")) {
            return IVariable.from(recipe.getBucketItem());
        }
        if(key.equals("fluidbottle")) {
            return IVariable.from(recipe.getBottleItem());
        }
        return null;
    }
}
