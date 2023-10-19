package net.mcs3.rusticated.world.level.block.grower;

import net.mcs3.rusticated.data.worldgen.features.ModTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class OliveTreeGrower extends AbstractTreeGrower {

    public OliveTreeGrower() {}

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
        return ModTreeFeatures.OLIVE_TREE_FEATURE;
    }
}
