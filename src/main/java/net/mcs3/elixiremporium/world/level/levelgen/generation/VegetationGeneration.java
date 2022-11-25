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
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.PLAINS, Biome.BiomeCategory.TAIGA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_OLIVE.unwrapKey().get());

        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.DESERT, Biome.BiomeCategory.MESA, Biome.BiomeCategory.SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.ALOE_VERA_DESERT.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.JUNGLE), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.JUNGLE_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.PLAINS), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PLAINS_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.FOREST, Biome.BiomeCategory.TAIGA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.FOREST_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.SWAMP), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.SWAMP_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.MOUNTAIN, Biome.BiomeCategory.EXTREME_HILLS), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.MOUNTAINOUS_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.categories(Biome.BiomeCategory.NETHER), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.NETHER_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.UNDERGROUND_HERBS.unwrapKey().get());
    }
}
