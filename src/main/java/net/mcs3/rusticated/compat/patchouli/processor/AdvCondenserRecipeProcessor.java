package net.mcs3.rusticated.compat.patchouli.processor;

import net.mcs3.rusticated.world.item.crafting.AdvCondenserRecipe;
import net.mcs3.rusticated.world.item.crafting.ModRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import vazkii.patchouli.api.IComponentProcessor;
import vazkii.patchouli.api.IVariable;
import vazkii.patchouli.api.IVariableProvider;

import java.util.List;

public class AdvCondenserRecipeProcessor implements IComponentProcessor {
    private AdvCondenserRecipe recipe;

    @Override
    public void setup(Level level, IVariableProvider variables) {
        ResourceLocation id = new ResourceLocation(variables.get("recipes").asString());
        List<AdvCondenserRecipe> recipes = Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(ModRecipes.ADV_CONDENSER_RECIPE_TYPE);
        for(AdvCondenserRecipe r : recipes) {
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
        Ingredient itemInput0 = recipe.getIngredients().get(0);
        Ingredient itemInput1 = recipe.getIngredients().get(1);
        Ingredient itemInput2 = recipe.getIngredients().get(2);

        if (key.equals("output")) {
            return IVariable.from(recipe.getOutputItem());
        } else if(key.equals("input0")) {
            return IVariable.from(itemInput0);
        } else if(key.equals("input1")) {
            return IVariable.from(itemInput1);
        } else if(key.equals("input2")) {
            return IVariable.from(itemInput2);
        }
        return null;
    }
}
