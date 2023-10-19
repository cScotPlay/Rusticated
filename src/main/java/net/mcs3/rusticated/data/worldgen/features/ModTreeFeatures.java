package net.mcs3.rusticated.data.worldgen.features;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.init.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModTreeFeatures {

    public static ResourceKey<ConfiguredFeature<?, ?>> IRONWOOD_TREE_FEATURE = resourceKey("ironwood_tree_feature");
    public static ResourceKey<ConfiguredFeature<?, ?>> OLIVE_TREE_FEATURE = resourceKey("olive_tree_feature");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context) {
        register(context, IRONWOOD_TREE_FEATURE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.IRONWOOD_LOG),
                new ForkingTrunkPlacer(4, 2, 2),
                BlockStateProvider.simple(ModBlocks.IRONWOOD_LEAVES),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 100),
                new TwoLayersFeatureSize(3, 0, 2)).ignoreVines().build());

        register(context, OLIVE_TREE_FEATURE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.OLIVE_LOG),
                new StraightTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ModBlocks.OLIVE_LEAVES),
                new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(4), UniformInt.of(6, 7)),
                new TwoLayersFeatureSize(3, 0, 2)).ignoreVines().build());
    }

    public static ResourceKey<ConfiguredFeature<?,?>> resourceKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Rusticated.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

