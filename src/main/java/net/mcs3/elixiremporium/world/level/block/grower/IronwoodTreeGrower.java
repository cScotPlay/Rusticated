package net.mcs3.elixiremporium.world.level.block.grower;

import net.mcs3.elixiremporium.data.worldgen.features.ModTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class IronwoodTreeGrower extends AbstractTreeGrower{
    public IronwoodTreeGrower(){}

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean largeHive) {
        return ModTreeFeatures.IRONWOOD_TREE_FEATURE;
    }
}
