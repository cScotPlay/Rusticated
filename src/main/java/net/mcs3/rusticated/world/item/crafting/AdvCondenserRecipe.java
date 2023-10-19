package net.mcs3.rusticated.world.item.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.mcs3.rusticated.init.ModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class AdvCondenserRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final ItemStack outputItem;
    private final Potion potion;
    private final NonNullList<Ingredient> recipeItems;
    private final int arraySize;

    public AdvCondenserRecipe(ResourceLocation id, Potion inputPotion, NonNullList<Ingredient> recipeItems, int arraySize)
    {
        this.id = id;
        this.potion = inputPotion;
        this.recipeItems = recipeItems;
        this.outputItem = PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), inputPotion);
        this.arraySize = arraySize;
    }

    public Potion getPotion() {
        return potion;
    }

    public ItemStack getOutputItem() {
        return outputItem;
    }

    public CompoundTag getTag() {
        return getOutputItem().getOrCreateTag();
    }

    public int getArraySize() {
        return arraySize;
    }

    @Override
    public boolean matches(Container container, Level level) {
        if (level.isClientSide()){return false;}

        if(arraySize == 3) {
            if(recipeItems.get(2).test(container.getItem(2))) {
                if(recipeItems.get(0).test(container.getItem(0))) {
                    return recipeItems.get(1).test(container.getItem(1));
                }
        }
//        if(!container.getItem(2).isEmpty()) {
//            if(recipeItems.get(2).test(container.getItem(2))) {
//                if(recipeItems.get(0).test(container.getItem(0))) {
//                    return recipeItems.get(1).test(container.getItem(1));
//                }
//            }
        }else if(arraySize == 2) {
            if(recipeItems.get(0).test(container.getItem(0))) {
                return recipeItems.get(1).test(container.getItem(1));
            }
        }
//        if(container.getItem(2).is(Blocks.AIR.asItem()))
//        {
//            if(recipeItems.get(0).test(container.getItem(0))) {
//                return recipeItems.get(1).test(container.getItem(1));
//            }
//        }else {
//            if(recipeItems.get(0).test(container.getItem(0))) {
//                if(recipeItems.get(1).test(container.getItem(1))) {
//                    return recipeItems.get(2).test(container.getItem(2));
//                }
//            }
//        }
        return false;
    }

    @Override
    public ItemStack assemble(Container container, RegistryAccess registryAccess) {
        return outputItem;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return outputItem.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ADV_CONDENSER_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ADV_CONDENSER_RECIPE_TYPE;
    }

    public static class Type implements RecipeType<AdvCondenserRecipe>
    {
        public static final AdvCondenserRecipe.Type INSTANCE = new Type();
        public static final String ID = "adv_condenser";

    }

    public static class Serializer implements RecipeSerializer<AdvCondenserRecipe>
    {
        public static final AdvCondenserRecipe.Serializer INSTANCE = new Serializer();
        public static final String ID = "adv_condenser";

        public Serializer() {}

        @Override
        public AdvCondenserRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject)
        {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
            String tagOutput = GsonHelper.getAsString(jsonObject, "potion");

            Potion potion = Potion.byName(tagOutput);

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredient");

            int arraySize = GsonHelper.getAsJsonArray(jsonObject, "ingredient").size();
            NonNullList<Ingredient> inputs = NonNullList.withSize(3, Ingredient.EMPTY);  //set size number to amount of input items

            if(arraySize == 2)
            {
                inputs.set(0, Ingredient.fromJson(ingredients.get(0)));
                inputs.set(1, Ingredient.fromJson(ingredients.get(1)));
                inputs.set(2, Ingredient.of(Blocks.AIR.asItem()));

            }else {
                for (int i = 0; i < inputs.size(); i++)
                {
                    inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
                }
            }

            return new AdvCondenserRecipe(recipeId, potion, inputs, arraySize);
        }

        @Override
        public AdvCondenserRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer)
        {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);
            int arraySize = buffer.readInt();
//            int arraySize = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY).size();

            if(arraySize == 2) {
                inputs.set(0, Ingredient.fromNetwork(buffer));
                inputs.set(1, Ingredient.fromNetwork(buffer));
//                inputs.set(2, Ingredient.of(Blocks.AIR.asItem()));
            }else {
                for (int i = 0; i < inputs.size(); i++)
                {
                    inputs.set(i, Ingredient.fromNetwork(buffer));
                }
            }

            Potion potion = PotionUtils.getPotion(buffer.readNbt());

            ItemStack output = buffer.readItem();
            return new AdvCondenserRecipe(recipeId, potion, inputs, arraySize);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, AdvCondenserRecipe recipe)
        {
            buffer.writeInt(recipe.getIngredients().size());
            buffer.writeInt(recipe.arraySize);


            if(recipe.arraySize == 2){
                Ingredient ingredient0 = recipe.getIngredients().get(0);
                Ingredient ingredient1 = recipe.getIngredients().get(1);
//                Ingredient ingredient2 = Ingredient.of(Blocks.AIR.asItem());

                ingredient0.toNetwork(buffer);
                ingredient1.toNetwork(buffer);
//                ingredient2.toNetwork(buffer);
//                buffer.writeItem(recipe.getIngredients().get(0));
//                Ingredient ingredient;
//                ingredient.toNetwork(recipe.getIngredients().get(0));
            }else if (recipe.arraySize == 3) {
                for (Ingredient ingredient : recipe.getIngredients()) {
                    ingredient.toNetwork(buffer);
                }
            }
            buffer.writeNbt(recipe.getOutputItem().getTag());
            buffer.writeItem(recipe.getOutputItem());
        }
    }
}
