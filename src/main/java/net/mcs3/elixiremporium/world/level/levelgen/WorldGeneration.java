package net.mcs3.elixiremporium.world.level.levelgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.mcs3.elixiremporium.data.worldgen.placement.ModVegetationPlacement;
import net.mcs3.elixiremporium.world.level.levelgen.generation.VegetationGeneration;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;

public class WorldGeneration
{
    public static void generateWorld()
    {
        VegetationGeneration.generateVegetation();
    }

}
