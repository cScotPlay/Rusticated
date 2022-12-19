package net.mcs3.rusticated.world.level.material;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class WildberryFluid extends BaseFluid {
    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_WILDBERRY_JUICE;
    }

    @Override
    public Fluid getSource() {
        return ModFluids.SOURCE_WILDBERRY_JUICE;
    }

    @Override
    public Item getBucket() {
        return ModFluids.WILDBERRY_JUICE_BUCKET;
    }

    @Override
    protected BlockState createLegacyBlock(FluidState state) {
        return ModFluids.WILDBERRY_JUICE_BLOCK.defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(state));
    }

    protected static int getLegacyLevel(FluidState state) {
        if (state.isSource()) {
            return 0;
        }
        return 8 - Math.min(state.getAmount(), 8) + (state.getValue(FALLING) != false ? 8 : 0);
    }

    public static class Flowing extends WildberryFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends WildberryFluid {
        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
