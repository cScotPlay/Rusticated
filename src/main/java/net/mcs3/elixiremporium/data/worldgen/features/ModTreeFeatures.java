package net.mcs3.elixiremporium.data.worldgen.features;

import net.mcs3.elixiremporium.init.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class ModTreeFeatures
{
    public static Holder<ConfiguredFeature<TreeConfiguration, ?>> IRONWOOD_TREE_FEATURE;

    public static void init()
    {
        IRONWOOD_TREE_FEATURE = FeatureUtils.register("ironwood_tree_feature", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.ACACIA_LOG),
                new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(ModBlocks.IRONWOOD_LEAVES),
                new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
    }
}

