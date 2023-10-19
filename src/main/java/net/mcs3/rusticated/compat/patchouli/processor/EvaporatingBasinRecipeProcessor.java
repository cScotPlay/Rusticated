package net.mcs3.rusticated.compat.patchouli.processor;

import net.mcs3.rusticated.world.item.crafting.CondenserRecipe;
import net.mcs3.rusticated.world.item.crafting.EvaporatingBasinRecipe;
import net.mcs3.rusticated.world.item.crafting.ModRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

import java.util.List;

public class EvaporatingBasinRecipeProcessor implements IComponentProcessor {
    private EvaporatingBasinRecipe recipe;

    @Override
    public void setup(Level level, IVariableProvider variables) {
        ResourceLocation id = new ResourceLocation(variables.get("recipes").asString());
        List<EvaporatingBasinRecipe> recipes = Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipes.EVAPORATING_RECIPE_TYPE);
        for(EvaporatingBasinRecipe r : recipes) {
            if(!r.getId().getPath().equals(id.getPath())) continue; {
                recipe = r;
            }
        }
        if(recipe == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public IVariable process(Level level, String key) {
        if (key.equals("output")) {
            return IVariable.from(recipe.getResultItem(null));
        }
        if(key.equals("input")) {
            return IVariable.from(recipe.getBucketItem());
        }
        return null;
    }
}
