package net.mcs3.rusticated.data.recipes;

import com.google.gson.JsonObject;
import net.mcs3.rusticated.world.item.crafting.BrewingBarrelRecipe;
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
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class BrewingBarrelRecipeBuilder implements RecipeBuilder {
    private final ItemStack resultItem;
    private final Fluid inputFluid;
    private final Fluid primerFluid;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    @Nullable
    private String group;
    private final RecipeSerializer<? extends BrewingBarrelRecipe.Serializer> serializer;

    public BrewingBarrelRecipeBuilder(ItemStack resultItem, Fluid inputFluid, Fluid primerFluid, RecipeSerializer<? extends BrewingBarrelRecipe.Serializer> serializer) {
        this.resultItem = resultItem;
        this.inputFluid = inputFluid;
        this.primerFluid = primerFluid;
        this.serializer = serializer;
    }

    public static BrewingBarrelRecipeBuilder brewing (ItemStack resultItem, Fluid inputFluid, Fluid primerFluid) {
        return new BrewingBarrelRecipeBuilder(resultItem, inputFluid, primerFluid, ModRecipes.BREWING_RECIPE_SERIALIZER);
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
        return this.resultItem.getItem();
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        this.ensureValid(recipeId);
        this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).requirements(RequirementsStrategy.OR);
        finishedRecipeConsumer.accept(new BrewingBarrelRecipeBuilder.Result(recipeId, this.group == null ? "" : this.group, this.resultItem, this.inputFluid, this.primerFluid, this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/" + this.resultItem.getItem().getItemCategory().getRecipeFolderName() + "/" + recipeId.getPath()), this.serializer));

        ResourceLocation primedRecipeID = new ResourceLocation(recipeId.toString() + "_primed");
        this.ensureValid(primedRecipeID);
        //this.advancement.parent(new ResourceLocation("recipes/root")).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(primedRecipeID)).rewards(AdvancementRewards.Builder.recipe(primedRecipeID)).requirements(RequirementsStrategy.OR);
        finishedRecipeConsumer.accept(new BrewingBarrelRecipeBuilder.ResultNoPrimer(primedRecipeID, this.group == null ? "" : this.group, this.resultItem, this.inputFluid, this.primerFluid, this.advancement, new ResourceLocation(primedRecipeID.getNamespace(), "recipes/" + this.resultItem.getItem().getItemCategory().getRecipeFolderName() + "/" + primedRecipeID.getPath()), this.serializer));
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
        private final ItemStack resultItem;
        private final Fluid inputFluid;
        private final Fluid primerFluid;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<? extends BrewingBarrelRecipe.Serializer> serializer;

        public Result(ResourceLocation resourceLocation, String string, ItemStack resultItem, Fluid inputFluid, Fluid primerFluid, Advancement.Builder builder, ResourceLocation resourceLocation2, RecipeSerializer<? extends BrewingBarrelRecipe.Serializer> recipeSerializer) {
            this.id = resourceLocation;
            this.group = string;
            this.resultItem = resultItem;
            this.inputFluid = inputFluid;
            this.primerFluid = primerFluid;
            this.advancement = builder;
            this.advancementId = resourceLocation2;
            this.serializer = recipeSerializer;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            ItemStack resultItem = this.resultItem;


            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("item", Registry.ITEM.getKey(resultItem.getItem()).toString());
            json.add("result", jsonObject);

            json.addProperty("primerused", true);
            json.addProperty("inputfluid", String.valueOf(Registry.FLUID.getKey(this.inputFluid)));
            json.addProperty("primerfluid", String.valueOf(Registry.FLUID.getKey(this.primerFluid)));
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ModRecipes.BREWING_RECIPE_SERIALIZER;
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

    public static class ResultNoPrimer implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final ItemStack resultItem;
        private final Fluid inputFluid;
        private final Fluid primerFluid;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<? extends BrewingBarrelRecipe.Serializer> serializer;

        public ResultNoPrimer(ResourceLocation resourceLocation, String string, ItemStack resultItem, Fluid inputFluid, Fluid primerFluid, Advancement.Builder builder, ResourceLocation resourceLocation2, RecipeSerializer<? extends BrewingBarrelRecipe.Serializer> recipeSerializer) {
            this.id = resourceLocation;
            this.group = string;
            this.resultItem = resultItem;
            this.inputFluid = inputFluid;
            this.primerFluid = primerFluid;
            this.advancement = builder;
            this.advancementId = resourceLocation2;
            this.serializer = recipeSerializer;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            ItemStack resultItem = this.resultItem;


            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("item", Registry.ITEM.getKey(resultItem.getItem()).toString());
            json.add("result", jsonObject);

            json.addProperty("primer_used", false);
            json.addProperty("input_fluid", String.valueOf(Registry.FLUID.getKey(this.inputFluid)));
//            json.addProperty("primer_fluid", String.valueOf(Registry.FLUID.getKey(this.primerFluid)));
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ModRecipes.BREWING_RECIPE_SERIALIZER;
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
