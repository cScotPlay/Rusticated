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
import net.mcs3.rusticated.world.item.crafting.AdvCondenserRecipe;
import net.mcs3.rusticated.world.item.crafting.EvaporatingBasinRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class EvaporatingBasingRecipeCategory implements IRecipeCategory<EvaporatingBasinRecipe> {

    public final static RecipeType<EvaporatingBasinRecipe> TYPE = RecipeType.create(Rusticated.MOD_ID, "evaporating_basin", EvaporatingBasinRecipe.class);
    public final static ResourceLocation UID = new ResourceLocation(Rusticated.MOD_ID, "evaporating_basin");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Rusticated.MOD_ID, "textures/gui/container/jei_evaporating_basin.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated progress;


    public EvaporatingBasingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.EVAPORATING_BASIN.asItem()));

        IDrawableStatic progressDrawable = helper.drawableBuilder(TEXTURE, 176, 0, 27, 15).addPadding(36, 0, 74, 0).build();
        this.progress = helper.createAnimatedDrawable(progressDrawable, 80, IDrawableAnimated.StartDirection.LEFT, false);

    }

    @Override
    public RecipeType<EvaporatingBasinRecipe> getRecipeType() {
        return TYPE;
    }
    @Override
    public Component getTitle() {
        return Component.translatable("block.rusticated.evaporating_basin");
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
    public void draw(EvaporatingBasinRecipe recipe, IRecipeSlotsView recipeSlotsView, PoseStack stack, double mouseX, double mouseY) {
        this.progress.draw(stack);
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull EvaporatingBasinRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 36).addItemStack(recipe.getBucketItem());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 109, 36).addItemStack(recipe.getResultItem());
    }
}
