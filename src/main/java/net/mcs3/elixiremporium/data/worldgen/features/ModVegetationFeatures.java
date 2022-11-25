package net.mcs3.elixiremporium.data.worldgen.features;

import net.mcs3.elixiremporium.data.worldgen.placement.ModTreePlacement;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.world.level.block.crop.AloeVeraBlock;
import net.mcs3.elixiremporium.world.level.block.crop.HerbPerennialBlock;
import net.mcs3.elixiremporium.world.level.block.crop.ModMushroomBlock;
import net.mcs3.elixiremporium.world.level.block.crop.RootBlock;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import java.util.List;

public class ModVegetationFeatures
{
    public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> IRONWOOD_TREE_FILTERED = FeatureUtils.register("ironwood_tree_filtered", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ModTreePlacement.IRONWOOD_TREE_CHECKED, 0.8F)), ModTreePlacement.IRONWOOD_TREE_CHECKED));
    public static Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> OLIVE_TREE_FILTERED = FeatureUtils.register("olive_tree_filtered", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(ModTreePlacement.OLIVE_TREE_CHECKED, 0.5F)), ModTreePlacement.OLIVE_TREE_CHECKED));

    public static Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ALOE_VERA_FEATURE = FeatureUtils.register("aloe_vera_feature", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocks.ALOE_VERA.defaultBlockState().setValue(AloeVeraBlock.AGE, 3)), 4));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> JUNGLE_HERBS = FeatureUtils.register("jungle_herbs", Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.BLOOD_ORCHID.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.HORSETAIL.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.NIGHTSHROOM.defaultBlockState().setValue(ModMushroomBlock.AGE, 3), 2)
            .add(ModBlocks.MARSHMALLOW.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PLAINS_HERBS = FeatureUtils.register("plains_herbs", Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.CHAMOMILE.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.HORSETAIL.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.WIND_THISTLE.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.GINSENG.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> FOREST_HERBS = FeatureUtils.register("forest_herbs", Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.CHAMOMILE.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.COHOSH.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.HORSETAIL.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.GINSENG.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> SWAMP_HERBS = FeatureUtils.register("swamp_herbs", Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.CHAMOMILE.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.HORSETAIL.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.MARSHMALLOW.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MOUNTAINOUS_HERBS = FeatureUtils.register("mountainous_herbs", Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.CLOUD_LILY.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.WIND_THISTLE.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> UNDERGROUND_HERBS = FeatureUtils.register("underground_herbs", Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.NIGHTSHROOM.defaultBlockState().setValue(ModMushroomBlock.AGE, 3), 2)
            .add(ModBlocks.CORE_ROOT.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));
//    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NETHER_HERBS = FeatureUtils.register("nether_herbs", Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
//            .add(ModBlocks.GREEN_SPORED_ASBESTOS.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)), 64));


    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> NETHER_HERBS = FeatureUtils.register("nether_herbs", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GREEN_SPORED_ASBESTOS.defaultBlockState().setValue(ModMushroomBlock.AGE, 3)))));
    //public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_NIGHTSHROOM = FeatureUtils.register("patch_nightshroom", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.NIGHTSHROOM.defaultBlockState().setValue(ModMushroomBlock.AGE, 3)))));






    private static RandomPatchConfiguration grassPatch(BlockStateProvider blockStateProvider, int tries)
    {
        return FeatureUtils.simpleRandomPatchConfiguration(tries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(blockStateProvider)));
    }
}
