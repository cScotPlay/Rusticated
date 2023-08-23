package net.mcs3.rusticated.compat.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.world.item.crafting.CondenserRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CondenserREI {

    public static final CategoryIdentifier<? extends CondenserDisplay> CATEGORY_IDENTIFIER = CategoryIdentifier.of(CondenserRecipe.Type.ID);

    public static class CondenserCategory implements DisplayCategory<CondenserDisplay> {

        @Override
        public CategoryIdentifier<? extends CondenserDisplay> getCategoryIdentifier() {
            return CATEGORY_IDENTIFIER;
        }

        @Override
        public Component getTitle() {
            return Component.translatable("block.rusticated.condenser");
        }

        @Override
        public Renderer getIcon() {
            return EntryStacks.of(ModBlocks.CONDENSER);
        }

        @Override
        public List<Widget> setupDisplay(CondenserDisplay display, Rectangle bounds) {
            Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
            final var widgets = new ArrayList<Widget>();

            // The base background of the display
            widgets.add(Widgets.createRecipeBase(bounds));

            // The gray arrow
            widgets.add(Widgets.createArrow(new Point(startPoint.x + 47, startPoint.y + 4)));

            // We create a result slot background AND
            // disable the actual background of the slots, so the result slot can look bigger
            widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 81, startPoint.y + 5)));
            widgets.add(Widgets.createSlot(new Point(startPoint.x + 81, startPoint.y + 5))
                    .entries(display.getOutputEntries().get(0)) // Get the first output ingredient
                    .disableBackground() // Disable the background because we have our bigger background
                    .markOutput()); // Mark this as the output for REI to identify

            // We add the input slot
            widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 5))
                    .entries(display.getInputEntries().get(0)) // Get the first input ingredient
                    .markInput()); // Mark this as the input for REI to identify

            // We add the input slot
            widgets.add(Widgets.createSlot(new Point(startPoint.x + 24, startPoint.y + 5))
                    .entries(display.getInputEntries().get(1)) // Get the first input ingredient
                    .markInput()); // Mark this as the input for REI to identify

            // We return the list of widgets for REI to display
            return widgets;
        }
    }

    public static class CondenserDisplay implements Display {

        private final List<EntryIngredient> inputs;
        private final EntryIngredient output;
        private final Optional<ResourceLocation> location;

        public CondenserDisplay(CondenserRecipe recipe) {
            this(EntryIngredients.ofIngredients(recipe.getIngredients()), EntryIngredients.of(recipe.getResultItem()), Optional.ofNullable(recipe.getId()));
        }

        public CondenserDisplay(List<EntryIngredient> inputs, EntryIngredient output, Optional<ResourceLocation> location) {
            this.inputs = inputs;
            this.output = output;
            this.location = location;
        }

        @Override
        public List<EntryIngredient> getInputEntries() {
            return inputs;
        }

        @Override
        public List<EntryIngredient> getOutputEntries() {
            return Collections.singletonList(output);
        }

        @Override
        public CategoryIdentifier<?> getCategoryIdentifier() {
            return CATEGORY_IDENTIFIER;
        }

        public Optional<ResourceLocation> getLocation() {
            return location;
        }
    }
}