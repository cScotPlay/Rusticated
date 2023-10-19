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
import net.mcs3.rusticated.world.item.crafting.BrewingBarrelRecipe;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class BrewingBarrelRecipeCategory implements IRecipeCategory<BrewingBarrelRecipe> {

    public final static RecipeType<BrewingBarrelRecipe> TYPE = RecipeType.create(Rusticated.MOD_ID, "brewing_barrel", BrewingBarrelRecipe.class);
    public final static ResourceLocation UID = new ResourceLocation(Rusticated.MOD_ID, "brewing_barrel");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Rusticated.MOD_ID, "textures/gui/container/jei_brewing.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated progress;
    private final IDrawableAnimated plusSign;
    private final IDrawableAnimated brewing;

    public BrewingBarrelRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.OAK_BREWING_BARREL.asItem()));

        IDrawableStatic progressDrawable = helper.drawableBuilder(TEXTURE, 176, 28, 41, 15).addPadding(39, 0, 85, 0).build();
        this.progress = helper.createAnimatedDrawable(progressDrawable, 80, IDrawableAnimated.StartDirection.LEFT, false);

        IDrawableStatic plusSignDrawable = helper.drawableBuilder(TEXTURE, 176, 43, 10, 10).addPadding(38, 0, 47, 0).build();
        this.plusSign = helper.createAnimatedDrawable(plusSignDrawable, 80, IDrawableAnimated.StartDirection.LEFT, false);

        IDrawableStatic bubbleDrawable = helper.drawableBuilder(TEXTURE, 176, 0, 14, 28).addPadding(14, 0, 100, 0).build();
        this.brewing = helper.createAnimatedDrawable(bubbleDrawable, 80, IDrawableAnimated.StartDirection.BOTTOM, false);
    }

    @Override
    public RecipeType<BrewingBarrelRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.rusticated.oak_brewing_barrel");
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
    public void draw(BrewingBarrelRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.plusSign.draw(guiGraphics);
        this.progress.draw(guiGraphics);
        this.brewing.draw(guiGraphics);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BrewingBarrelRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 134, 7).addIngredients(Ingredient.of((Items.GLASS_BOTTLE).getDefaultInstance()));
        builder.addSlot(RecipeIngredientRole.INPUT, 134, 55).addFluidStack(recipe.getResultFluid(), 20250L).setFluidRenderer(250L, false, 16, 4);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 63).addItemStack(recipe.getResultItem(null));

        builder.addSlot(RecipeIngredientRole.INPUT, 62, 7).addIngredients(Ingredient.of(recipe.getInputFluid().getBucket()));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 43).addFluidStack(recipe.getInputFluid(), 81000L).setFluidRenderer(8100L, false, 16, 16);

        if(recipe.isPrimerUsed()){
           builder.addSlot(RecipeIngredientRole.INPUT, 26, 14).addIngredients(Ingredient.of(recipe.getResultItem(null)));
           builder.addSlot(RecipeIngredientRole.INPUT, 26, 35).addFluidStack(recipe.getResultFluid(), 81000L).setFluidRenderer(8100L, false, 16, 16);
        }
    }
}
