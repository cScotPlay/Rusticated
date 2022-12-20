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
import net.mcs3.rusticated.world.item.crafting.CrushingTubRecipe;
import net.mcs3.rusticated.world.item.crafting.EvaporatingBasinRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class CrushingTubRecipeCategory implements IRecipeCategory<CrushingTubRecipe> {

    public final static RecipeType<CrushingTubRecipe> TYPE = RecipeType.create(Rusticated.MOD_ID, "crushing_tub", CrushingTubRecipe.class);
    public final static ResourceLocation UID = new ResourceLocation(Rusticated.MOD_ID, "crushing_tub");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Rusticated.MOD_ID, "textures/gui/container/jei_crushing_tub.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated progress;


    public CrushingTubRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.CRUSHING_TUB.asItem()));

        IDrawableStatic progressDrawable = helper.drawableBuilder(TEXTURE, 176, 0, 15, 20).addPadding(32, 0, 80, 0).build();
        this.progress = helper.createAnimatedDrawable(progressDrawable, 80, IDrawableAnimated.StartDirection.TOP, false);

    }

    @Override
    @SuppressWarnings("Deprecated")
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    @SuppressWarnings("Deprecated")
    public Class<? extends CrushingTubRecipe> getRecipeClass() {
        return CrushingTubRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TextComponent("Crushing Tub");
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
    public void draw(CrushingTubRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        this.progress.draw(stack);
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull CrushingTubRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 15).addItemStack(recipe.getResultItem());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.getBucketItem());
    }
}
