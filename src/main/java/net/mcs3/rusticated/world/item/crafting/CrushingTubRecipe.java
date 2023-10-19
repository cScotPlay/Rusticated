package net.mcs3.rusticated.world.item.crafting;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.mixin.transfer.BucketItemAccessor;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;

public class CrushingTubRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final ItemStack inputItem;
    private final ItemStack bucketItem;
    private final ItemStack bottleItem;
    private final ItemStack extraOutputItem;
    private final Fluid inputFluid;

    public CrushingTubRecipe(ResourceLocation id, ItemStack inputItem, ItemStack fluidBucket, ItemStack fluidBottle, ItemStack optionalOutputItem) {
        this.id = id;
        this.inputItem = inputItem;
        this.bucketItem = fluidBucket;
        this.bottleItem = fluidBottle;
        this.inputFluid = getInputFluid(fluidBucket);
        this.extraOutputItem = optionalOutputItem;
    }

    public Fluid getInputFluid(ItemStack bucketItem) {
        return ((BucketItemAccessor) bucketItem.getItem()).fabric_getFluid();
    }

    public ItemStack getBucketItem() {return this.bucketItem;}

    public ItemStack getBottleItem() {return this.bottleItem;}

    public ItemStack getExtraOutputItem() {return this.extraOutputItem;}

    public Fluid getFluid() {return this.inputFluid;}

    @Override
    public boolean matches(Container container, Level level) {
        if(level.isClientSide()) {return false;}

        if(inputItem.getItem() == container.getItem(0).getItem()) {
            return true;
        }else if (container.getItem(0).getItem() == bucketItem.getItem()) {
            return true;
        }
        return false;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return inputItem;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return inputItem;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return CrushingTubRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return CrushingTubRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<CrushingTubRecipe> {
        private Type(){}
        public static final CrushingTubRecipe.Type INSTANCE = new CrushingTubRecipe.Type();
        public static final String ID = "crushing_tub";
    }

    public static class Serializer<T extends CrushingTubRecipe> implements RecipeSerializer<CrushingTubRecipe>
    {
        public static final CrushingTubRecipe.Serializer INSTANCE = new CrushingTubRecipe.Serializer();
        public static final String ID = "crushing_tub";

        @Override
        public CrushingTubRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject)
        {
            ItemStack inputItem = new ItemStack(ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "ingredient")).getItem());
            ItemStack fluidBucket = new ItemStack(ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "fluidbucket")).getItem());
            ItemStack fluidBottle = new ItemStack(ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "fluidbottle")).getItem());

            ItemStack extraItem = airCheck(jsonObject);

            return new CrushingTubRecipe(recipeId, inputItem, fluidBucket, fluidBottle, extraItem);
        }

        public ItemStack airCheck(JsonObject jsonObject) {
            String checkString = jsonObject.get("output").toString().replace("{\"item\":\"minecraft:air\"}", "air");
            if(checkString.matches("air")) {
                return new ItemStack(Items.AIR);
            }else {
                return new ItemStack(ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "output")).getItem());
                }
        }

        @Override
        public CrushingTubRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer)
        {
            ItemStack fluidBucket = buffer.readItem();
            ItemStack inputItem = buffer.readItem();
            ItemStack fluidBottle = buffer.readItem();
            ItemStack extraOutputItem = buffer.readItem();

            return new CrushingTubRecipe(recipeId, inputItem, fluidBucket, fluidBottle, extraOutputItem);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, CrushingTubRecipe recipe)
        {
            buffer.writeItem(recipe.bucketItem);
            buffer.writeItem(recipe.inputItem);
            buffer.writeItem(recipe.bottleItem);
            buffer.writeItem(recipe.extraOutputItem);
        }
    }
}
