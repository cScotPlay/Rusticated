package net.mcs3.rusticated.world.level.levelgen.generation;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcs3.rusticated.data.worldgen.placement.ModVegetationPlacement;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class VegetationGeneration
{
    public static void generateVegetation()
    {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_IRONWOOD.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_BADLANDS), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_IRONWOOD.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DESERT), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_IRONWOOD.unwrapKey().get());

        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_OLIVE_FOREST.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_TAIGA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_OLIVE.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.PLAINS), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.TREES_OLIVE.unwrapKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DESERT), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.ALOE_VERA_DESERT.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_BADLANDS), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.ALOE_VERA_DESERT.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_SAVANNA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.ALOE_VERA_DESERT.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_JUNGLE), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.JUNGLE_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.PLAINS), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.PLAINS_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_FOREST), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.FOREST_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_TAIGA), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.FOREST_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.SWAMP), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.SWAMP_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.MANGROVE_SWAMP), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.SWAMP_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_MOUNTAIN), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.MOUNTAINOUS_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.NETHER_HERBS.unwrapKey().get());
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.VEGETAL_DECORATION, ModVegetationPlacement.UNDERGROUND_HERBS.unwrapKey().get());
    }
}
