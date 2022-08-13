package net.mcs3.elixiremporium.data.worldgen.features;

import net.mcs3.elixiremporium.data.worldgen.placement.ModTreePlacement;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;

import java.util.List;

public class ModVegetationFeatures
{
    public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> IRONWOOD_TREE_FILTERED = FeatureUtils.register("ironwood_tree_filtered", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ModTreePlacement.IRONWOOD_TREE_CHECKED, 0.8F)), ModTreePlacement.IRONWOOD_TREE_CHECKED));

}
