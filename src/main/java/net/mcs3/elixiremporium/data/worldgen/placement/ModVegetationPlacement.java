package net.mcs3.elixiremporium.data.worldgen.placement;

import com.google.common.collect.ImmutableList;
import net.mcs3.elixiremporium.data.worldgen.features.ModVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModVegetationPlacement
{
    public static final Holder<PlacedFeature> TREES_IRONWOOD = PlacementUtils.register("trees_ironwood", ModVegetationFeatures.IRONWOOD_TREE_FILTERED, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(75)));
    public static final Holder<PlacedFeature> TREES_OLIVE = PlacementUtils.register("trees_olive", ModVegetationFeatures.OLIVE_TREE_FILTERED, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100)));
    public static final Holder<PlacedFeature> TREES_OLIVE_FOREST = PlacementUtils.register("trees_olive_forest", ModVegetationFeatures.OLIVE_TREE_FILTERED, VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(25)));

    public static final Holder<PlacedFeature> ALOE_VERA_DESERT = PlacementUtils.register("aloe_vera_desert", ModVegetationFeatures.ALOE_VERA_FEATURE, new PlacementModifier[]{RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});
    public static final Holder<PlacedFeature> JUNGLE_HERBS = PlacementUtils.register("jungle_herbs", ModVegetationFeatures.JUNGLE_HERBS, new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});
    public static final Holder<PlacedFeature> PLAINS_HERBS = PlacementUtils.register("plains_herbs", ModVegetationFeatures.PLAINS_HERBS, new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});
    public static final Holder<PlacedFeature> FOREST_HERBS = PlacementUtils.register("forest_herbs", ModVegetationFeatures.FOREST_HERBS, new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});
    public static final Holder<PlacedFeature> SWAMP_HERBS = PlacementUtils.register("swamp_herbs", ModVegetationFeatures.SWAMP_HERBS, new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});
    public static final Holder<PlacedFeature> MOUNTAINOUS_HERBS = PlacementUtils.register("mountainous_herbs", ModVegetationFeatures.MOUNTAINOUS_HERBS, new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});
    public static final Holder<PlacedFeature> NETHER_HERBS = PlacementUtils.register("nether_herbs", ModVegetationFeatures.NETHER_HERBS, new PlacementModifier[]{RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()});
    public static final Holder<PlacedFeature> UNDERGROUND_HERBS= PlacementUtils.register("underground_herbs", ModVegetationFeatures.UNDERGROUND_HERBS, new PlacementModifier[]{CountPlacement.of(10), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, InSquarePlacement.spread(), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, -2147483648, -13), BiomeFilter.biome()});


}
