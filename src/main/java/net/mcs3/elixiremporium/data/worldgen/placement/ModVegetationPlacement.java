package net.mcs3.elixiremporium.data.worldgen.placement;

import net.mcs3.elixiremporium.data.worldgen.features.ModVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModVegetationPlacement
{
    public static final Holder<PlacedFeature> TREES_IRONWOOD = PlacementUtils.register("trees_ironwood", ModVegetationFeatures.IRONWOOD_TREE_FILTERED, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1)));
}
