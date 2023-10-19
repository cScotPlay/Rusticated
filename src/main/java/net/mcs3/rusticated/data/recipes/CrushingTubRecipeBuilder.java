package net.mcs3.rusticated.data.recipes;

import com.google.gson.JsonObject;
import net.mcs3.rusticated.world.item.crafting.CrushingTubRecipe;

import net.mcs3.rusticated.world.item.crafting.ModRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CrushingTubRecipeBuilder implements RecipeBuilder {
    private final ItemStack ingredient;
    private final ItemStack bucketItem;
    private final ItemStack bottleItem;
    private final ItemStack extraItems;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final RecipeSerializer<? extends CrushingTubRecipe.Serializer> serializer;

    private CrushingTubRecipeBuilder(ItemStack ingredient, ItemStack bucketItem, ItemStack bottleItem, ItemStack extraItems, RecipeSerializer<? extends CrushingTubRecipe.Serializer> crushingTubSerializer) {
        this.serializer = crushingTubSerializer;
        this.ingredient = ingredient;
        this.bucketItem = bucketItem;
        this.bottleItem = bottleItem;
        this.extraItems = extraItems;
    }

    public static CrushingTubRecipeBuilder processor(ItemStack ingredient, ItemStack bucketItem, ItemStack bottleItem, ItemStack extraItems, RecipeSerializer<? extends CrushingTubRecipe.Serializer> serializer) {
        return new CrushingTubRecipeBuilder(ingredient, bucketItem, bottleItem, extraItems, serializer);
    }

    public static CrushingTubRecipeBuilder crushing(ItemStack ingredient, ItemStack bucketItem, ItemStack bottleItem, ItemStack extraItems) {
        return CrushingTubRecipeBuilder.processor(ingredient, bucketItem, bottleItem, extraItems, ModRecipes.CRUSHING_RECIPE_SERIALIZER);
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
        return this.ingredient.getItem();
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        this.ensureValid(recipeId);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);
        finishedRecipeConsumer.accept(new CrushingTubRecipeBuilder.Result(recipeId, this.group == null ? "" : this.group, this.ingredient, this.bucketItem, this.bottleItem, this.extraItems, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + recipeId.getPath()), this.serializer));
//        finishedRecipeConsumer.accept(new CrushingTubRecipeBuilder.Result(recipeId, this.group == null ? "" : this.group, this.ingredient, this.bucketItem, this.bottleItem, this.extraItems, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.ingredient.getItem().getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath()), this.serializer));
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
        private final ItemStack ingredient;
        private final ItemStack bucketItem;
        private final ItemStack bottleItem;
        private final ItemStack extraItems;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<? extends CrushingTubRecipe.Serializer> serializer;

        public Result(ResourceLocation resourceLocation, String string, ItemStack ingredient, ItemStack bucketItem, ItemStack bottleItem, ItemStack extraItems, Advancement.Builder builder, ResourceLocation resourceLocation2, RecipeSerializer<? extends CrushingTubRecipe.Serializer> recipeSerializer) {
            this.id = resourceLocation;
            this.group = string;
            this.ingredient = ingredient;
            this.bucketItem = bucketItem;
            this.bottleItem = bottleItem;
            this.extraItems = extraItems;
            this.advancement = builder;
            this.advancementId = resourceLocation2;
            this.serializer = recipeSerializer;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            ItemStack itemIngredient = this.ingredient;
            ItemStack bucketItem = this.bucketItem;
            ItemStack bottleItem = this.bottleItem;
            ItemStack extraItems = this.extraItems;

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("item", BuiltInRegistries.ITEM.getKey(itemIngredient.getItem()).toString());
            json.add("ingredient", jsonObject);

            JsonObject jsonObjectBucket = new JsonObject();
            jsonObjectBucket.addProperty("item", BuiltInRegistries.ITEM.getKey(bucketItem.getItem()).toString());
            json.add("fluidbucket", jsonObjectBucket);

            JsonObject jsonObjectBottle = new JsonObject();
            jsonObjectBottle.addProperty("item", BuiltInRegistries.ITEM.getKey(bottleItem.getItem()).toString());
            json.add("fluidbottle", jsonObjectBottle);

            JsonObject jsonObjectExtra = new JsonObject();
            jsonObjectExtra.addProperty("item", BuiltInRegistries.ITEM.getKey(extraItems.getItem()).toString());
            json.add("output", jsonObjectExtra);


        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ModRecipes.CRUSHING_RECIPE_SERIALIZER;
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
