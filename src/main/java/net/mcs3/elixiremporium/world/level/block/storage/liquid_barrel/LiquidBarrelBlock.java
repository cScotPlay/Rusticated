package net.mcs3.elixiremporium.world.level.block.storage.liquid_barrel;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.mcs3.elixiremporium.world.level.block.storage.AbstractStorageBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class LiquidBarrelBlock extends AbstractStorageBlock implements EntityBlock
{
    //protected static final VoxelShape BARREL_AABB;

    public LiquidBarrelBlock() {
        super(Properties.of(Material.WOOD)
                .noOcclusion()
                .strength(2.0f, 3.0f)
                .sound(SoundType.WOOD));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LiquidBarrelEntityBlock(ModBlockEntityTypes.LIQUID_BARREL_CONTAINER, pos, state, 16);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return BARREL_AABB;
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (((LiquidBarrelEntityBlock) level.getBlockEntity(pos)).onPlayerUse(player))
        {
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    protected static boolean shouldHandlePrecipitation(Level level, Biome.Precipitation precipitation) {
        if (precipitation == Biome.Precipitation.RAIN) {
            return level.getRandom().nextFloat() < 1.00F;
        } else if (precipitation == Biome.Precipitation.SNOW) {
            return level.getRandom().nextFloat() < 0.1F;
        } else {
            return false;
        }
    }

    @Override
    public void handlePrecipitation(BlockState state, Level level, BlockPos pos, Biome.Precipitation precipitation) {
//        if (shouldHandlePrecipitation(level, precipitation)) {
//            BlockEntity barrel = level.getBlockEntity(pos);
//
//            if (barrel instanceof LiquidBarrelEntityBlock)
//            {
//
//                level.setBlockAndUpdate(pos, ModBlocks.LIQUID_BARREL);
//                ElixirEmporium.LOGGER.info("This is a Liquid Barrel");
//                LiquidBarrelEntityBlock liquidBarrel = (LiquidBarrelEntityBlock) barrel;
//                FluidVariant water = FluidVariant.of(Fluids.WATER);
//
//                if(liquidBarrel.getAmount() < liquidBarrel.getCapacity())
//                {
//                    ElixirEmporium.LOGGER.info(liquidBarrel.getAmount() + " is in Barrel");
//                }
//                liquidBarrel.getCapacity();
//
//                liquidBarrel.insert(water, FluidConstants.BUCKET, null);
//                ElixirEmporium.LOGGER.info(water.getFluid() + " was filed");
//
//            }
////            if (precipitation == Biome.Precipitation.RAIN) {
////                level.setBlockAndUpdate(pos, ModBlocks.LIQUID_BARREL.defaultBlockState());
////                level.gameEvent((Entity)null, GameEvent.FLUID_PLACE, pos);
////            } else if (precipitation == Biome.Precipitation.SNOW) {
////                level.setBlockAndUpdate(pos, ModBlocks.LIQUID_BARREL.defaultBlockState());
////                level.gameEvent((Entity)null, GameEvent.FLUID_PLACE, pos);
////            }
//        }
    }
    protected static final VoxelShape BARREL_AABB = Stream.of(
            Block.box(2, 1, 2, 14, 2, 14),
            Block.box(13.95, 2, 3, 15, 14, 13),
            Block.box(14, 14, 2.75, 15.25, 16, 13.25),
            Block.box(14, 0, 2.75, 15.25, 2, 13.25),
            Block.box(13, 2, 13, 14, 14, 14),
            Block.box(15, 11, 2.75, 15.25, 12, 13.25),
            Block.box(14, 11, 12.75, 14.25, 12, 14),
            Block.box(14, 11, 13, 15, 12, 13.25),
            Block.box(14, 11, 2.75, 15, 12, 3),
            Block.box(12.75, 11, 14, 14, 12, 14.25),
            Block.box(13, 0, 13, 14.25, 2, 14.25),
            Block.box(13, 14, 13, 14.25, 16, 14.25),
            Block.box(1, 2, 3, 2.05, 14, 13),
            Block.box(0.75, 14, 2.75, 2, 16, 13.25),
            Block.box(0.75, 0, 2.75, 2, 2, 13.25),
            Block.box(2, 2, 2, 3, 14, 3),
            Block.box(0.75, 11, 2.75, 1, 12, 13.25),
            Block.box(1.75, 11, 2, 2, 12, 3.25),
            Block.box(1, 11, 2.75, 2, 12, 3),
            Block.box(1, 11, 13, 2, 12, 13.25),
            Block.box(2, 11, 1.75, 3.25, 12, 2),
            Block.box(1.75, 0, 1.75, 3, 2, 3),
            Block.box(1.75, 14, 1.75, 3, 16, 3),
            Block.box(3, 2, 1, 13, 14, 2.05),
            Block.box(2.75, 14, 0.75, 13.25, 16, 2),
            Block.box(2.75, 0, 0.75, 13.25, 2, 2),
            Block.box(13, 2, 2, 14, 14, 3),
            Block.box(2.75, 11, 0.75, 13.25, 12, 1),
            Block.box(12.75, 11, 1.75, 14, 12, 2),
            Block.box(13, 11, 1, 13.25, 12, 2),
            Block.box(2.75, 11, 1, 3, 12, 2),
            Block.box(14, 11, 2, 14.25, 12, 3.25),
            Block.box(3, 2, 13.95, 13, 14, 15),
            Block.box(2.75, 14, 14, 13.25, 16, 15.25),
            Block.box(2.75, 0, 14, 13.25, 2, 15.25),
            Block.box(2, 2, 13, 3, 14, 14),
            Block.box(2.75, 11, 15, 13.25, 12, 15.25),
            Block.box(2, 11, 14, 3.25, 12, 14.25),
            Block.box(2.75, 11, 14, 3, 12, 15),
            Block.box(13, 11, 14, 13.25, 12, 15),
            Block.box(1.75, 11, 12.75, 2, 12, 14),
            Block.box(1.75, 0, 13, 3, 2, 14.25),
            Block.box(1.75, 14, 13, 3, 16, 14.25),
            Block.box(13, 0, 1.75, 14.25, 2, 3),
            Block.box(13, 14, 1.75, 14.25, 16, 3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

//    static {
//        BARREL_AABB = Block.box(1.0, 0.1, 1.0, 15.0, 15.0, 15);
//    }
}
