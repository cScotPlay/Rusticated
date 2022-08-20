package net.mcs3.elixiremporium.data.worldgen.placement;

import net.mcs3.elixiremporium.data.worldgen.features.ModVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModVegetationPlacement
{
    public static final Holder<PlacedFeature> TREES_IRONWOOD = PlacementUtils.register("trees_ironwood", ModVegetationFeatures.IRONWOOD_TREE_FILTERED, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(75)));
    public static final Holder<PlacedFeature> TREES_OLIVE = PlacementUtils.register("trees_olive", ModVegetationFeatures.OLIVE_TREE_FILTERED, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100)));
    public static final Holder<PlacedFeature> TREES_OLIVE_FOREST = PlacementUtils.register("trees_olive_forest", ModVegetationFeatures.OLIVE_TREE_FILTERED, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(25)));
}
