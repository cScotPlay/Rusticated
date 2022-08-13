package net.mcs3.elixiremporium.world.level.levelgen.generation;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcs3.elixiremporium.data.worldgen.placement.ModVegetationPlacement;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;

public class VegetationGeneration
{
    public static void generateVegetation()
    {
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_IRONWOOD.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.MESA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_IRONWOOD.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.DESERT), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_IRONWOOD.unwrapKey().get());
    }
}
