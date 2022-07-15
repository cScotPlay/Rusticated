package net.mcs3.elixiremporium.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mcs3.elixiremporium.data.loottables.LootTableGenerator;
import net.mcs3.elixiremporium.data.models.BlockStateGenerator;
import net.mcs3.elixiremporium.data.recipes.CraftingRecipeBuilder;
import net.mcs3.elixiremporium.data.tags.BlockTagGenerator;

public class DataGenerators implements DataGeneratorEntrypoint
{

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator)
    {
        dataGenerator.addProvider(CraftingRecipeBuilder::new);
        dataGenerator.addProvider(BlockStateGenerator::new);
        dataGenerator.addProvider(LootTableGenerator::new);
        dataGenerator.addProvider(BlockTagGenerator::new);

    }
}
