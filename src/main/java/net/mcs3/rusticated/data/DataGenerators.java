package net.mcs3.rusticated.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mcs3.rusticated.data.loottables.LootTableGenerator;
import net.mcs3.rusticated.data.models.BlockStateGenerator;
import net.mcs3.rusticated.data.recipes.CraftingRecipeBuilder;
import net.mcs3.rusticated.data.tags.BlockTagGenerator;
import net.mcs3.rusticated.data.tags.FluidTagGenerator;
import net.mcs3.rusticated.data.tags.ItemTagGenerator;

public class DataGenerators implements DataGeneratorEntrypoint
{

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator)
    {
        dataGenerator.addProvider(CraftingRecipeBuilder::new);
        dataGenerator.addProvider(BlockStateGenerator::new);
        dataGenerator.addProvider(LootTableGenerator::new);
        dataGenerator.addProvider(BlockTagGenerator::new);
        dataGenerator.addProvider(ItemTagGenerator::new);
        dataGenerator.addProvider(FluidTagGenerator::new);
    }
}
