package net.mcs3.elixiremporium.data.worldgen.features;

import net.mcs3.elixiremporium.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModTreeFeatures
{
    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> IRONWOOD_TREE_FEATURE;
    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> OLIVE_TREE_FEATURE;

    public static void init()
    {
        IRONWOOD_TREE_FEATURE = FeatureUtils.register("ironwood_tree_feature", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.IRONWOOD_LOG),
                new ForkingTrunkPlacer(4, 2, 2),
                BlockStateProvider.simple(ModBlocks.IRONWOOD_LEAVES),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 100),
                new TwoLayersFeatureSize(3, 0, 2)).ignoreVines().build());

        OLIVE_TREE_FEATURE = FeatureUtils.register("olive_tree_feature", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.OLIVE_LOG),
                new StraightTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ModBlocks.OLIVE_LEAVES),
                new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(4), UniformInt.of(6, 7)),
                new TwoLayersFeatureSize(3, 0, 2)).ignoreVines().build());
    }
}

