package net.mcs3.rusticated.compat.patchouli.processor;

import net.mcs3.rusticated.world.item.crafting.BrewingBarrelRecipe;
import net.mcs3.rusticated.world.item.crafting.ModRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

import java.util.List;

public class BrewingBarrelRecipeProcessor implements IComponentProcessor {
    private BrewingBarrelRecipe recipe;


    @Override
    public void setup(IVariableProvider variables) {
        ResourceLocation id = new ResourceLocation(variables.get("recipes").asString());
        List<BrewingBarrelRecipe> recipes = Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipes.BREWING_RECIPE_TYPE);
        for(BrewingBarrelRecipe r : recipes) {
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

        if (key.equals("output")) {
            return IVariable.from(recipe.getResultItem());
        }
        if(key.equals("input")) {
            return IVariable.from(recipe.getInputFluidBucket());
        }
        return null;
    }
}
