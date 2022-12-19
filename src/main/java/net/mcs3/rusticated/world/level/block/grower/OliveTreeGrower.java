package net.mcs3.rusticated.world.level.block.grower;

import net.mcs3.rusticated.data.worldgen.features.ModTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class OliveTreeGrower extends AbstractTreeGrower
{
    public OliveTreeGrower() {}

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean largeHive) {
        return ModTreeFeatures.OLIVE_TREE_FEATURE;
    }

}
