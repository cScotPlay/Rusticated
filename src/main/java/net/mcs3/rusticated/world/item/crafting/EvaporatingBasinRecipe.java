package net.mcs3.rusticated.world.item.crafting;

import com.google.gson.JsonObject;
import net.fabricmc.fabric.mixin.transfer.BucketItemAccessor;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;

public class EvaporatingBasinRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final ItemStack outputItem;
    private final ItemStack bucketItem;
    private final Fluid inputFluid;

    public EvaporatingBasinRecipe(ResourceLocation id, ItemStack outputItem, ItemStack fluidBucket) {
        this.id = id;
        this.outputItem = outputItem;
        this.bucketItem = fluidBucket;
        this.inputFluid = getInputFluid(fluidBucket);
    }

    public Fluid getInputFluid(ItemStack bucketItem) {
        return ((BucketItemAccessor) bucketItem.getItem()).fabric_getFluid();
    }

    public ItemStack getBucketItem() {return this.bucketItem;}

    @Override
    public boolean matches(Container container, Level level) {
        if(level.isClientSide()) {return false;}

        ItemStack bucketItem = container.getItem(0);

        if (bucketItem.getItem() != Items.BUCKET && bucketItem.getItem() instanceof BucketItem) {
            Fluid fluid = ((BucketItemAccessor) bucketItem.getItem()).fabric_getFluid();
            if(this.inputFluid == fluid) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return outputItem;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<EvaporatingBasinRecipe> {
        private Type(){}
        public static final EvaporatingBasinRecipe.Type INSTANCE = new EvaporatingBasinRecipe.Type();
        public static final String ID = "evaporating_basin";
    }

    public static class Serializer<T extends EvaporatingBasinRecipe> implements RecipeSerializer<EvaporatingBasinRecipe>
    {
        public static final EvaporatingBasinRecipe.Serializer INSTANCE = new EvaporatingBasinRecipe.Serializer();
        public static final String ID = "evaporating_basin";

        @Override
        public EvaporatingBasinRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject)
        {
            ItemStack output = new ItemStack(ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result")).getItem());
            ItemStack fluidBucket = new ItemStack(ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "fluidbucket")).getItem());

            return new EvaporatingBasinRecipe(recipeId, output, fluidBucket);
        }

        @Override
        public EvaporatingBasinRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer)
        {
            ItemStack bucket = buffer.readItem();
            ItemStack output = buffer.readItem();

            return new EvaporatingBasinRecipe(recipeId, output, bucket);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, EvaporatingBasinRecipe recipe)
        {
            buffer.writeItem(recipe.bucketItem);
            buffer.writeItem(recipe.outputItem);
        }
    }
}
