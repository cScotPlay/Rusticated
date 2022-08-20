package net.mcs3.elixiremporium.world.level.levelgen.generation;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcs3.elixiremporium.data.worldgen.placement.ModVegetationPlacement;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;

public class VegetationGeneration
{
    public static void generateVegetation()
    {
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_IRONWOOD.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.MESA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_IRONWOOD.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.DESERT), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_IRONWOOD.unwrapKey().get());

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_OLIVE_FOREST.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.PLAINS), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_OLIVE.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.TAIGA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_OLIVE.unwrapKey().get());
    }
}
