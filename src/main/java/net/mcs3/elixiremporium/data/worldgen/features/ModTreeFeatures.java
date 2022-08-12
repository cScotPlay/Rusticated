package net.mcs3.elixiremporium.data.worldgen.features;

import net.mcs3.elixiremporium.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class ModTreeFeatures
{
    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> IRONWOOD_TREE_FEATURE;

    public static void init()
    {
        IRONWOOD_TREE_FEATURE = FeatureUtils.register("ironwood_tree_feature", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.IRONWOOD_LOG),
                new ForkingTrunkPlacer(4, 3, 4),
                BlockStateProvider.simple(ModBlocks.IRONWOOD_LEAVES),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 100),
                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
    }
}

