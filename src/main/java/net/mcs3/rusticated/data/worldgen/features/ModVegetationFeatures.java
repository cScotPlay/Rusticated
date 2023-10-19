package net.mcs3.rusticated.data.worldgen.features;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.world.level.block.crop.AloeVeraBlock;
import net.mcs3.rusticated.world.level.block.crop.HerbPerennialBlock;
import net.mcs3.rusticated.world.level.block.crop.ModMushroomBlock;
import net.mcs3.rusticated.world.level.block.crop.RootBlock;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModVegetationFeatures {

    public static ResourceKey<ConfiguredFeature<?, ?>> IRONWOOD_TREE_FILTERED = resourceKey("ironwood_tree_filtered");
    public static ResourceKey<ConfiguredFeature<?, ?>> OLIVE_TREE_FILTERED = resourceKey("olive_tree_filtered");

    public static ResourceKey<ConfiguredFeature<?, ?>> ALOE_VERA_FEATURE = resourceKey("aloe_vera_feature");
    public static ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_HERBS = resourceKey("jungle_herbs");
    public static ResourceKey<ConfiguredFeature<?, ?>> PLAINS_HERBS = resourceKey("plains_herbs");
    public static ResourceKey<ConfiguredFeature<?, ?>> FOREST_HERBS = resourceKey("forest_herbs");
    public static ResourceKey<ConfiguredFeature<?, ?>> SWAMP_HERBS = resourceKey("swamp_herbs");
    public static ResourceKey<ConfiguredFeature<?, ?>> MOUNTAINOUS_HERBS = resourceKey("mountainous_herbs");
    public static ResourceKey<ConfiguredFeature<?, ?>> NETHER_HERBS = resourceKey("nether_herbs");
    public static ResourceKey<ConfiguredFeature<?, ?>> UNDERGROUND_HERBS = resourceKey("underground_herbs");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context) {

        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> IRONWOOD_TREE = holderGetter.getOrThrow(ModTreeFeatures.IRONWOOD_TREE_FEATURE);
        Holder<ConfiguredFeature<?, ?>> OLIVE_TREE = holderGetter.getOrThrow(ModTreeFeatures.OLIVE_TREE_FEATURE);

        register(context, IRONWOOD_TREE_FILTERED, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(IRONWOOD_TREE, new PlacementModifier[0]), 0.33333334F)), PlacementUtils.inlinePlaced(IRONWOOD_TREE, new PlacementModifier[0])));
        register(context, OLIVE_TREE_FILTERED, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(OLIVE_TREE, new PlacementModifier[0]), 0.33333334F)), PlacementUtils.inlinePlaced(OLIVE_TREE, new PlacementModifier[0])));

        register(context, ALOE_VERA_FEATURE, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocks.ALOE_VERA.defaultBlockState().setValue(AloeVeraBlock.AGE, 3)), 4));

        register(context, JUNGLE_HERBS, Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.BLOOD_ORCHID.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.HORSETAIL.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.NIGHTSHROOM.defaultBlockState().setValue(ModMushroomBlock.AGE, 3), 2)
            .add(ModBlocks.MARSHMALLOW.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));

        register(context, PLAINS_HERBS, Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.CHAMOMILE.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.HORSETAIL.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.WIND_THISTLE.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.GINSENG.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));

        register(context, FOREST_HERBS, Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.CHAMOMILE.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.COHOSH.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.HORSETAIL.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.GINSENG.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));

        register(context, SWAMP_HERBS, Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.CHAMOMILE.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.HORSETAIL.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.MARSHMALLOW.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));

        register(context, MOUNTAINOUS_HERBS, Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.CLOUD_LILY.defaultBlockState().setValue(HerbPerennialBlock.AGE, 3), 2)
            .add(ModBlocks.WIND_THISTLE.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));

        register(context, NETHER_HERBS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.GREEN_SPORED_ASBESTOS.defaultBlockState().setValue(ModMushroomBlock.AGE, 3)))));

        register(context, UNDERGROUND_HERBS, Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.NIGHTSHROOM.defaultBlockState().setValue(ModMushroomBlock.AGE, 3), 2)
            .add(ModBlocks.CORE_ROOT.defaultBlockState().setValue(RootBlock.AGE, 3), 2)), 64));
    }

    public static ResourceKey<ConfiguredFeature<?,?>> resourceKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Rusticated.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider blockStateProvider, int tries) {
        return FeatureUtils.simpleRandomPatchConfiguration(tries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(blockStateProvider)));
    }
}
