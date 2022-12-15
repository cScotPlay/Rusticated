package net.mcs3.elixiremporium.data.recipes;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModItems;
import net.mcs3.elixiremporium.world.item.crafting.AdvCondenserRecipe;
import net.mcs3.elixiremporium.world.item.crafting.CondenserRecipe;
import net.mcs3.elixiremporium.world.item.crafting.ModRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class AdvCondenserRecipeBuilder implements RecipeBuilder {
    private final ItemStack result;
    private final List<Ingredient> ingredients;
    private final Potion elixirEffect;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final RecipeSerializer<? extends AdvCondenserRecipe.Serializer> serializer;

    private AdvCondenserRecipeBuilder(Potion elixir, List<Ingredient> ingredients, RecipeSerializer<? extends AdvCondenserRecipe.Serializer> condenserCookingSerializer) {
        this.elixirEffect = elixir;
        this.ingredients = Lists.newArrayList(ingredients);
        this.serializer = condenserCookingSerializer;
        this.result = PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), elixir);
    }

    public static AdvCondenserRecipeBuilder cooking(List<Ingredient> ingredient, Potion elixirEffect, RecipeSerializer<? extends AdvCondenserRecipe.Serializer> serializer) {
        return new AdvCondenserRecipeBuilder(elixirEffect, ingredient, serializer);
    }

    public static AdvCondenserRecipeBuilder condenser(List<Ingredient> ingredient, Potion elixirEffect) {
        return AdvCondenserRecipeBuilder.cooking(ingredient, elixirEffect, ModRecipes.ADV_CONDENSER_RECIPE_SERIALIZER);
    }

    @Override
    public RecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        this.advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    @Override
    public Item getResult() {
        return this.result.getItem();
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        this.ensureValid(recipeId);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);
        finishedRecipeConsumer.accept(new AdvCondenserRecipeBuilder.Result(recipeId, this.group == null ? "" : this.group, this.ingredients, this.elixirEffect, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.result.getItem().getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath()), this.serializer));
    }

    /**
     * Makes sure that this obtainable.
     */
    private void ensureValid(ResourceLocation id) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final List<Ingredient> ingredients;
        private final ItemStack result;
        private final Potion elixir;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<? extends AdvCondenserRecipe.Serializer> serializer;

        public Result(ResourceLocation resourceLocation, String string, List<Ingredient> ingredients, Potion elixir, Advancement.Builder builder, ResourceLocation resourceLocation2, RecipeSerializer<? extends AdvCondenserRecipe.Serializer> recipeSerializer) {
            this.id = resourceLocation;
            this.group = string;
            this.ingredients = ingredients;
            this.elixir = elixir;
            this.result = PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), elixir);;
            this.advancement = builder;
            this.advancementId = resourceLocation2;
            this.serializer = recipeSerializer;
        }


        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }
            JsonArray jsonArray = new JsonArray();
            for (Ingredient ingredient : this.ingredients) {
                json.add("ingredient", ingredient.toJson());
            }

            ItemStack itemResult = this.result;

            String potionText = itemResult.getTag().toString().substring(9, itemResult.getTag().toString().length() - 2);
            ElixirEmporium.LOGGER.info(potionText);
            json.addProperty("potion", potionText);

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("item", Registry.ITEM.getKey(itemResult.getItem()).toString());
            json.add("result", jsonObject);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ModRecipes.ADV_CONDENSER_RECIPE_SERIALIZER;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
