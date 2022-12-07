package net.mcs3.elixiremporium.world.item.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModItems;
import net.mcs3.elixiremporium.world.item.alchmey.ElixirItem;
import net.mcs3.elixiremporium.world.item.alchmey.Elixirs;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class CondenserRecipe implements Recipe<Container>
{
    private final ResourceLocation id;
    private final ItemStack outputItem;
    private final Potion potion;
    private final NonNullList<Ingredient> recipeItems;

    public CondenserRecipe(ResourceLocation id, Potion inputPotion, NonNullList<Ingredient> recipeItems)
    {
        this.id = id;
        this.outputItem = getOutputItem();
        this.potion = inputPotion;
        this.recipeItems = recipeItems;
    }

    public Potion getPotion() {
        return this.potion;
    }

    public ItemStack getOutputItem() {
        return PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR), potion);
    }

    @Override
    public boolean matches(Container container, Level level) {
        if (level.isClientSide()){return false;}

        if(recipeItems.get(0).test(container.getItem(0)))
        {
            return recipeItems.get(1).test(container.getItem(1));
        }
        return false;
    }

    @Override
    public ItemStack assemble(Container container) {
        return outputItem;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
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

    public static class Type implements RecipeType<CondenserRecipe>
    {
        private Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = "condenser";

    }
    public static class Serializer<T extends CondenserRecipe> implements RecipeSerializer<CondenserRecipe>
    {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "condenser";

        @Override
        public CondenserRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject)
        {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
            String tagOutput = GsonHelper.getAsString(jsonObject, "potion");

            Potion potion = Potion.byName(tagOutput);

            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredient");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);  //set size number to amount of input items

            for (int i = 0; i < inputs.size(); i++)
            {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new CondenserRecipe(recipeId, potion, inputs);
        }

        @Override
        public CondenserRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer)
        {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++)
            {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }

            Potion potion = PotionUtils.getPotion(buffer.readNbt());

            ItemStack output = buffer.readItem();
            return new CondenserRecipe(recipeId, potion, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, CondenserRecipe recipe)
        {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients())
            {
                ingredient.toNetwork(buffer);
            }
            buffer.writeNbt(recipe.outputItem.getTag());
            buffer.writeItem(recipe.outputItem);
        }
    }
}
