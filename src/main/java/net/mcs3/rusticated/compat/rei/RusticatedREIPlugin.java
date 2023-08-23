package net.mcs3.rusticated.compat.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.world.item.crafting.*;

public class RusticatedREIPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CrushingTubREI.CrushingTubCategory());
        registry.add(new CondenserREI.CondenserCategory());
        registry.add(new AdvCondenserREI.AdvCondenserCategory());
        registry.add(new BrewingBarrelREI.BrewingBarrelCategory());
        registry.add(new EvaporatingBasinREI.EvaporatingBasinCategory());

        registry.addWorkstations(CrushingTubREI.CATEGORY_IDENTIFIER, EntryStacks.of(ModBlocks.CRUSHING_TUB));
        registry.addWorkstations(CondenserREI.CATEGORY_IDENTIFIER, EntryStacks.of(ModBlocks.CONDENSER));
        registry.addWorkstations(AdvCondenserREI.CATEGORY_IDENTIFIER, EntryStacks.of(ModBlocks.ADV_CONDENSER));
        registry.addWorkstations(BrewingBarrelREI.CATEGORY_IDENTIFIER, EntryStacks.of(ModBlocks.OAK_BREWING_BARREL));
        registry.addWorkstations(EvaporatingBasinREI.CATEGORY_IDENTIFIER, EntryStacks.of(ModBlocks.EVAPORATING_BASIN));
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {

    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerFiller(CrushingTubRecipe.class, CrushingTubREI.CrushingTubDisplay::new);
        registry.registerFiller(CondenserRecipe.class, CondenserREI.CondenserDisplay::new);
        registry.registerFiller(AdvCondenserRecipe.class, AdvCondenserREI.AdvCondenserDisplay::new);
        registry.registerFiller(BrewingBarrelRecipe.class, BrewingBarrelREI.BrewingBarrelDisplay::new);
        registry.registerFiller(EvaporatingBasinRecipe.class, EvaporatingBasinREI.EvaporatingBasinDisplay::new);

    }
}
