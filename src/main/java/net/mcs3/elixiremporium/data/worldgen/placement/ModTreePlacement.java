package net.mcs3.elixiremporium.data.worldgen.placement;

import net.mcs3.elixiremporium.data.worldgen.features.ModTreeFeatures;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;

import net.minecraft.world.level.levelgen.placement.*;


public class ModTreePlacement
{
    public static Holder<PlacedFeature> IRONWOOD_TREE_CHECKED = PlacementUtils.register("ironwood_tree_checked", ModTreeFeatures.IRONWOOD_TREE_FEATURE, new PlacementModifier[]{PlacementUtils.filteredByBlockSurvival(ModBlocks.IRONWOOD_SAPLING)});
    public static Holder<PlacedFeature> OLIVE_TREE_CHECKED = PlacementUtils.register("olive_tree_checked", ModTreeFeatures.OLIVE_TREE_FEATURE, new PlacementModifier[]{PlacementUtils.filteredByBlockSurvival(ModBlocks.OLIVE_SAPLING)});

}
