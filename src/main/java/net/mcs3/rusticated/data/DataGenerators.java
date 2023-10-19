package net.mcs3.rusticated.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.mcs3.rusticated.data.loottables.LootTableGenerator;
import net.mcs3.rusticated.data.models.BlockStateGenerator;
import net.mcs3.rusticated.data.recipes.CraftingRecipeBuilder;
import net.mcs3.rusticated.data.tags.BlockTagGenerator;
import net.mcs3.rusticated.data.tags.FluidTagGenerator;
import net.mcs3.rusticated.data.tags.ItemTagGenerator;
import net.mcs3.rusticated.data.worldgen.WorldGenerator;
import net.mcs3.rusticated.data.worldgen.features.ModTreeFeatures;
import net.mcs3.rusticated.data.worldgen.features.ModVegetationFeatures;
import net.mcs3.rusticated.data.worldgen.placement.ModVegetationPlacement;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class DataGenerators implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FabricDataGenerator.Pack pack = dataGenerator.createPack();

        pack.addProvider(CraftingRecipeBuilder::new);
        pack.addProvider(BlockStateGenerator::new);
        pack.addProvider(LootTableGenerator::new);
        pack.addProvider(BlockTagGenerator::new);
        pack.addProvider(ItemTagGenerator::new);
        pack.addProvider(FluidTagGenerator::new);
        pack.addProvider(WorldGenerator::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModTreeFeatures::bootstrap);
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModVegetationFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModVegetationPlacement::bootstrap);
    }
}
