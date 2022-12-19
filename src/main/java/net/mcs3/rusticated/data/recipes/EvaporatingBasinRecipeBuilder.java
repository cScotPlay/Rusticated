package net.mcs3.rusticated.data.recipes;

import com.google.gson.JsonObject;
import net.mcs3.rusticated.world.item.crafting.EvaporatingBasinRecipe;
import net.mcs3.rusticated.world.item.crafting.ModRecipes;
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
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class EvaporatingBasinRecipeBuilder implements RecipeBuilder {
    private final ItemStack result;
    private final ItemStack bucketItem;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final RecipeSerializer<? extends EvaporatingBasinRecipe.Serializer> serializer;

    private EvaporatingBasinRecipeBuilder(ItemStack result, ItemStack bucketItem, RecipeSerializer<? extends EvaporatingBasinRecipe.Serializer> evaporatingBasinSerializer) {
        this.serializer = evaporatingBasinSerializer;
        this.result = result;
        this.bucketItem = bucketItem;
    }

    public static EvaporatingBasinRecipeBuilder processor(ItemStack result, ItemStack bucketItem, RecipeSerializer<? extends EvaporatingBasinRecipe.Serializer> serializer) {
        return new EvaporatingBasinRecipeBuilder(result, bucketItem, serializer);
    }

    public static EvaporatingBasinRecipeBuilder evaporating(ItemStack result, ItemStack bucketItem) {
        return EvaporatingBasinRecipeBuilder.processor(result, bucketItem, ModRecipes.EVAPORATING_RECIPE_SERIALIZER);
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
        finishedRecipeConsumer.accept(new EvaporatingBasinRecipeBuilder.Result(recipeId, this.group == null ? "" : this.group, this.bucketItem, this.result, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.result.getItem().getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath()), this.serializer));
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
        private final ItemStack bucketItem;
        private final ItemStack result;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<? extends EvaporatingBasinRecipe.Serializer> serializer;

        public Result(ResourceLocation resourceLocation, String string, ItemStack bucketItem, ItemStack result, Advancement.Builder builder, ResourceLocation resourceLocation2, RecipeSerializer<? extends EvaporatingBasinRecipe.Serializer> recipeSerializer) {
            this.id = resourceLocation;
            this.group = string;
            this.bucketItem = bucketItem;
            this.result = result;
            this.advancement = builder;
            this.advancementId = resourceLocation2;
            this.serializer = recipeSerializer;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            ItemStack itemResult = this.result;
            ItemStack bucketItem = this.bucketItem;

            JsonObject jsonObjectBucket = new JsonObject();
            jsonObjectBucket.addProperty("item", Registry.ITEM.getKey(bucketItem.getItem()).toString());
            json.add("fluidbucket", jsonObjectBucket);

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
            return ModRecipes.EVAPORATING_RECIPE_SERIALIZER;
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
