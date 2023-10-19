package net.mcs3.rusticated.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.init.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluid;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public class FluidTagGenerator extends FabricTagProvider.FluidTagProvider{

    protected final Predicate<Fluid> BLOCKS = registry -> Rusticated.MOD_ID.equals(registry.defaultFluidState().toString());

    public FluidTagGenerator(FabricDataOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {

        getOrCreateTagBuilder(FluidTags.WATER).add(
                ModFluids.SOURCE_ALE_WORT,
                ModFluids.FLOWING_ALE_WORT,
                ModFluids.SOURCE_APPLE_JUICE,
                ModFluids.FLOWING_APPLE_JUICE,
                ModFluids.SOURCE_GRAPE_JUICE,
                ModFluids.FLOWING_GRAPE_JUICE,
                ModFluids.SOURCE_HONEY,
                ModFluids.FLOWING_HONEY,
                ModFluids.SOURCE_IRONBERRY_JUICE,
                ModFluids.FLOWING_IRONBERRY_JUICE,
                ModFluids.SOURCE_OLIVE_OIL,
                ModFluids.FLOWING_OLIVE_OIL,
                ModFluids.SOURCE_SWEET_BERRY_JUICE,
                ModFluids.FLOWING_SWEET_BERRY_JUICE
        );

    }
}
