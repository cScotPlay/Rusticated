package net.mcs3.rusticated.data.worldgen.placement;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.data.worldgen.features.ModTreeFeatures;
import net.mcs3.rusticated.data.worldgen.features.ModVegetationFeatures;
import net.mcs3.rusticated.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModVegetationPlacement {

    public static ResourceKey<PlacedFeature> TREES_IRONWOOD = registerKey("trees_ironwood");
    public static ResourceKey<PlacedFeature> TREES_OLIVE = registerKey("trees_olive");

    public static ResourceKey<PlacedFeature> ALOE_VERA_DESERT = registerKey("aloe_vera_desert");
    public static ResourceKey<PlacedFeature> JUNGLE_HERBS = registerKey("jungle_herbs");
    public static ResourceKey<PlacedFeature> PLAINS_HERBS = registerKey("plains_herbs");
    public static ResourceKey<PlacedFeature> FOREST_HERBS = registerKey("forest_herbs");
    public static ResourceKey<PlacedFeature> SWAMP_HERBS = registerKey("swamp_herbs");
    public static ResourceKey<PlacedFeature> MOUNTAINOUS_HERBS = registerKey("mountainous_herbs");
    public static ResourceKey<PlacedFeature> NETHER_HERBS = registerKey("nether_herbs");
    public static ResourceKey<PlacedFeature> UNDERGROUND_HERBS = registerKey("underground_herbs");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        PlacementModifier placementModifier = SurfaceWaterDepthFilter.forMaxDepth(0);
        var configuredFeatureResourceKeyLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, TREES_IRONWOOD, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.IRONWOOD_TREE_FILTERED),
                new PlacementModifier[]{PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), placementModifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.IRONWOOD_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()});

        register(context, TREES_OLIVE, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.OLIVE_TREE_FILTERED),
                new PlacementModifier[]{PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), placementModifier, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(ModBlocks.OLIVE_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()});

        register(context, ALOE_VERA_DESERT, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.ALOE_VERA_FEATURE),
                new PlacementModifier[]{RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});

        register(context,JUNGLE_HERBS, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.JUNGLE_HERBS),
                new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});

        register(context, PLAINS_HERBS, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.PLAINS_HERBS),
                new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});

        register(context, FOREST_HERBS, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.FOREST_HERBS),
                new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});

        register(context, SWAMP_HERBS, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.SWAMP_HERBS),
                new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});

        register(context, MOUNTAINOUS_HERBS, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.MOUNTAINOUS_HERBS),
                new PlacementModifier[]{RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()});

        register(context, NETHER_HERBS, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.NETHER_HERBS),
                new PlacementModifier[]{RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()});

        register(context, UNDERGROUND_HERBS, configuredFeatureResourceKeyLookup.getOrThrow(ModVegetationFeatures.UNDERGROUND_HERBS),
                new PlacementModifier[]{CountPlacement.of(5), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                        InSquarePlacement.spread(),
                        SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, -2147483648, -13),
                        BiomeFilter.biome()});
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Rusticated.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                          Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                          PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
