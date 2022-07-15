package net.mcs3.elixiremporium.world.level.block;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class ChandelierBlock extends FallingBlock
{
    protected static final VoxelShape BASE = Block.box(0, 0, 0, 16, 04, 16);
    protected static final VoxelShape TOP_CONNECTOR = Block.box(4.5, 13, 4.5, 11.5, 14, 11.5);
    protected static final VoxelShape CHAIN_NORTH = Block.box(6.25, 4, 11.25, 9.75, 13, 16);
    protected static final VoxelShape CHAIN_EAST = Block.box(11.25, 4, 6.25, 15.5, 13, 9.75);
    protected static final VoxelShape CHAIN_WEST = Block.box(0.0, 4, 6.25, 4.75, 13, 9.75);
    protected static final VoxelShape CHAIN_SOUTH = Block.box(6.25, 4, 0.5, 9.75, 13, 4.75);

    protected static final VoxelShape AABB = Shapes.or(BASE, TOP_CONNECTOR, CHAIN_NORTH, CHAIN_EAST, CHAIN_WEST, CHAIN_SOUTH);


    public ChandelierBlock(Properties properties) {
        super(properties);
    }

//    @Override
//    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
//    {
//        return AABB;
//    }
//
//    @Override
//    public boolean isCollisionShapeFullBlock(BlockState state, BlockGetter level, BlockPos pos) {
//        return true;
//    }

    @Override
    protected void falling(FallingBlockEntity entity) {
        entity.setHurtsEntities(2.0F, 400);
    }

    public void onLand(Level level, BlockPos pos, BlockState blockState, BlockState blockState2, FallingBlockEntity fallingBlock) {
        if (!fallingBlock.isSilent()) {
            level.levelEvent(1031, pos, 0);
        }
    }

    @Override
    public void onBrokenAfterFall(Level level, BlockPos pos, FallingBlockEntity fallingBlock) {
        if (!fallingBlock.isSilent()) {
            level.levelEvent(1031, pos, 0);
        }

    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random)
    {
        if (isFree(level.getBlockState(pos.below())) && pos.getY() >= level.getMinBuildHeight() && !suspended(level, pos)) {
            FallingBlockEntity fallingBlockEntity = FallingBlockEntity.fall(level, pos, state);
            ElixirEmporium.LOGGER.info("This should Fall");
            this.falling(fallingBlockEntity);
        }
    }


    private boolean suspended (Level level, BlockPos pos)
    {
        BlockState blockState = level.getBlockState(pos.above());

        if (!(blockState == Blocks.AIR.defaultBlockState()))
        {
            return true;
        }
        if (blockState.getBlock() instanceof ChainBlock && blockState.getValue(ChainBlock.AXIS) == Direction.Axis.Y)
        {
            return true;
        }
        return false;
    }
}
