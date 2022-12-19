package net.mcs3.rusticated.mixin;

import net.mcs3.rusticated.world.level.block.FertileSoilBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;

@Mixin(SugarCaneBlock.class)
public class SugarCaneBlockMixin
{
    @Inject(at = @At("HEAD"), method = "canSurvive", cancellable = true)
    public void canSurvive(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir)
    {
        Boolean cirValue;

        BlockState blockState = level.getBlockState(pos.below());
        if (blockState.is(Blocks.SUGAR_CANE)) {
            cir.setReturnValue(true);
        } else if (blockState.getBlock() instanceof FertileSoilBlock)
        {
            cir.setReturnValue(true);
        } else {
            if (blockState.is(BlockTags.DIRT) || blockState.is(Blocks.SAND) || blockState.is(Blocks.RED_SAND)) {
                BlockPos blockPos = pos.below();
                Iterator var6 = Direction.Plane.HORIZONTAL.iterator();

                while(var6.hasNext()) {
                    Direction direction = (Direction)var6.next();
                    BlockState blockState2 = level.getBlockState(blockPos.relative(direction));
                    FluidState fluidState = level.getFluidState(blockPos.relative(direction));
                    if (fluidState.is(FluidTags.WATER) || blockState2.is(Blocks.FROSTED_ICE)) {
                        cir.setReturnValue(true);
                    }
                }
            }
            cir.setReturnValue(false);
        }
    }
}
