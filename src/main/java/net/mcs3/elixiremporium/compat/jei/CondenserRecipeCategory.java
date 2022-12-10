package net.mcs3.elixiremporium.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.world.item.crafting.CondenserRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nonnull;

public class CondenserRecipeCategory implements IRecipeCategory<CondenserRecipe> {

    public final static RecipeType<CondenserRecipe> TYPE = RecipeType.create(ElixirEmporium.MOD_ID, "condenser", CondenserRecipe.class);
    public final static ResourceLocation UID = new ResourceLocation(ElixirEmporium.MOD_ID, "condenser");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(ElixirEmporium.MOD_ID, "textures/gui/container/jei_condenser.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CondenserRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.CONDENSER.asItem()));
    }

    @Override
    @SuppressWarnings("Deprecated")
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    @SuppressWarnings("Deprecated")
    public Class<? extends CondenserRecipe> getRecipeClass() {
        return CondenserRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Alchemical Condenser");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull CondenserRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 107, 63).addIngredients(Ingredient.of((Items.GLASS_BOTTLE).getDefaultInstance()));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 53).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 71, 63).addIngredients(Ingredient.of((ItemTags.COALS)));
        builder.addSlot(RecipeIngredientRole.INPUT, 134, 55).addFluidStack(Fluids.WATER, 20250L).setFluidRenderer(250L, false, 16, 4);
        //builder.addSlot(RecipeIngredientRole.INPUT, 103, 18).addIngredients(Ingredient.of(ModItems.GEM_CUTTER_TOOL.get()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 107, 35).addItemStack(recipe.getResultItem());
    }
}
