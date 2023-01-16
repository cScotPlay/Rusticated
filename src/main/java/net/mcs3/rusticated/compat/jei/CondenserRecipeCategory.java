package net.mcs3.rusticated.compat.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.world.item.crafting.CondenserRecipe;
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

    public final static RecipeType<CondenserRecipe> TYPE = RecipeType.create(Rusticated.MOD_ID, "condenser", CondenserRecipe.class);
    public final static ResourceLocation UID = new ResourceLocation(Rusticated.MOD_ID, "condenser");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Rusticated.MOD_ID, "textures/gui/container/jei_condenser.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated progress;
    private final IDrawableAnimated fuel;
    private final IDrawableAnimated brewing;

    public CondenserRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.CONDENSER.asItem()));

        IDrawableStatic progressDrawable = helper.drawableBuilder(TEXTURE, 176, 14, 55, 28).addPadding(30, 0, 46, 0).build();
        this.progress = helper.createAnimatedDrawable(progressDrawable, 80, IDrawableAnimated.StartDirection.LEFT, false);

        IDrawableStatic brewingDrawable = helper.drawableBuilder(TEXTURE, 176, 43, 11, 28).addPadding(14, 0, 74, 0).build();
        this.brewing = helper.createAnimatedDrawable(brewingDrawable, 80, IDrawableAnimated.StartDirection.BOTTOM, false);

        IDrawableStatic fuelDrawable = helper.drawableBuilder(TEXTURE, 176, 0, 14, 14).addPadding(47, 0, 72, 0).build();
        this.fuel = helper.createAnimatedDrawable(fuelDrawable, 80, IDrawableAnimated.StartDirection.BOTTOM, false);
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
    public void draw(CondenserRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        this.fuel.draw(stack);
        this.progress.draw(stack);
        this.brewing.draw(stack);
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull CondenserRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 107, 63).addIngredients(Ingredient.of((Items.GLASS_BOTTLE).getDefaultInstance()));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 26, 53).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 71, 63).addIngredients(Ingredient.of((ItemTags.COALS)));
        builder.addSlot(RecipeIngredientRole.INPUT, 134, 55).addFluidStack(Fluids.WATER, 40500L).setFluidRenderer(500L, false, 16, 4);

        builder.addSlot(RecipeIngredientRole.OUTPUT, 107, 35).addItemStack(recipe.getResultItem());
    }
}
