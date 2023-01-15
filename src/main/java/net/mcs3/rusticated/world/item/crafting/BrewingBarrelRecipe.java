package net.mcs3.rusticated.world.item.crafting;

import com.google.gson.JsonObject;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.RusticatedClient;
import net.mcs3.rusticated.world.item.BoozeItem;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;

import java.util.HashMap;
import java.util.Map;

public class BrewingBarrelRecipe implements Recipe<Container> {
    private final ResourceLocation id;
    private final ItemStack outputItem;
    private final boolean primerUsed;
    private final Fluid inputFluid;
    private final Fluid primerFluid;

    public static Map<ResourceLocation, BrewingBarrelRecipe> recipes = new HashMap<>();

    public BrewingBarrelRecipe(ResourceLocation id, ItemStack outputItem, boolean primerUsed, Fluid inputFluid, Fluid primerFluid) {
        this.id = id;
        this.outputItem = outputItem;
        this.primerUsed = primerUsed;
        this.inputFluid = inputFluid;
        this.primerFluid = primerFluid;
    }

    @Override
    public boolean matches(Container container, Level level) {
        if(level.isClientSide) {
            return false;
        }
        return true;
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
        return outputItem.copy();
    }

    public Fluid getInputFluid() {
        return inputFluid;
    }

    public ItemStack getInputFluidBucket() {return inputFluid.getBucket().getDefaultInstance();}

    public boolean isPrimerUsed() {
        return primerUsed;
    }

    public Fluid getPrimerFluid() {
        return primerFluid;
    }

    public Fluid getResultFluid() {return ((BoozeItem) (this.getResultItem().getItem())).getFluidType();}

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return BrewingBarrelRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return BrewingBarrelRecipe.Type.INSTANCE;
    }

    public static class Type implements RecipeType<BrewingBarrelRecipe> {
        private Type(){}
        public static final Type INSTANCE = new Type();
        public static final String ID = "brewing_barrel";
    }

    public static class Serializer<T extends BrewingBarrelRecipe> implements RecipeSerializer<BrewingBarrelRecipe>
    {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "brewing_barrel";

        @Override
        public BrewingBarrelRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject)
        {
            ItemStack output = new ItemStack(ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result")).getItem());
            boolean primerUsed = GsonHelper.getAsBoolean(jsonObject, "primer_used");
            Fluid inputFluid = Registry.FLUID.get(new ResourceLocation(GsonHelper.getAsString(jsonObject, "input_fluid")));
            Fluid primerFluid = null;

            if(primerUsed) {
                String primer = GsonHelper.getAsString(jsonObject, "primer_fluid");
                ResourceLocation resourceLocation = new ResourceLocation(primer);
                primerFluid = Registry.FLUID.get(resourceLocation);
                Rusticated.LOGGER.info(primer);
//                primerFluid = Registry.FLUID.get(new ResourceLocation(GsonHelper.getAsJsonObject(jsonObject, "primer").get("fluid").toString()));
//                primerFluid = Registry.FLUID.get(new ResourceLocation(GsonHelper.getAsString(jsonObject, "primer_fluid")));
            }

            return new BrewingBarrelRecipe(recipeId, output, primerUsed, inputFluid, primerFluid);
        }

        @Override
        public BrewingBarrelRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer)
        {
            ItemStack output = buffer.readItem();
            boolean primerUsed = buffer.readBoolean();
            Fluid inputFluid = Registry.FLUID.byId(buffer.readVarInt());
            Fluid primerFluid = null;
//            Fluid primerFluid = Registry.FLUID.byId(buffer.readVarInt());

            if(primerUsed) {
                primerFluid = Registry.FLUID.byId(buffer.readVarInt());
            }

            return new BrewingBarrelRecipe(recipeId, output, primerUsed, inputFluid, primerFluid);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, BrewingBarrelRecipe recipe)
        {
            buffer.writeItem(recipe.outputItem);
            buffer.writeBoolean(recipe.primerUsed);
            buffer.writeVarInt(Registry.FLUID.getId(recipe.inputFluid));
            if(recipe.primerUsed){
                buffer.writeVarInt(Registry.FLUID.getId(recipe.primerFluid));
            }

        }
    }
}
