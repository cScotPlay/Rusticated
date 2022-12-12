package net.mcs3.elixiremporium.compat.patchouli.processor;

import net.mcs3.elixiremporium.world.item.crafting.CondenserRecipe;
import net.mcs3.elixiremporium.world.item.crafting.ModRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

import java.util.List;

public class CondenserRecipeProcessor implements IComponentProcessor {
    private CondenserRecipe recipe;


    @Override
    public void setup(IVariableProvider variables) {
        ResourceLocation id = new ResourceLocation(variables.get("recipes").asString());
        List<CondenserRecipe> recipes = Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipes.CONDENSER_RECIPE_TYPE);
        for(CondenserRecipe r : recipes) {
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
        Ingredient itemInput0 = recipe.getIngredients().get(0);
        Ingredient itemInput1 = recipe.getIngredients().get(1);

        if (key.equals("output")) {
            return IVariable.from(recipe.getOutputItem());
        } else if(key.equals("input0")) {
            return IVariable.from(itemInput0);
        } else if(key.equals("input1")) {
            return IVariable.from(itemInput1);
        }
        return null;
    }
}
