package net.mcs3.elixiremporium.world.level.block.alchemy;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class RetortBlock extends Block {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public RetortBlock() {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(2.0f).sound(SoundType.STONE).noOcclusion());
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        switch (state.getValue(FACING))
            {
                case NORTH:
                    return MODEL_SHAPE_N;
                case EAST:
                    return MODEL_SHAPE_E;
                case SOUTH:
                    return MODEL_SHAPE_S;
                case WEST:
                    return MODEL_SHAPE_W;
                default:
                    return MODEL_SHAPE_N;
            }
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.BLOCK;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        if (blockPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockPos.above()).canBeReplaced(context)) {
            return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
        }
        return null;
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return (BlockState)state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    private static final VoxelShape MODEL_SHAPE_N = Stream.of(
            Block.box(4, 0, 4, 12, 4, 12),
            Block.box(6, 14, 6, 10, 15, 10),
            Block.box(4, 13, 4, 12, 16, 6),
            Block.box(4, 13, 10, 12, 16, 12),
            Block.box(4, 13, 6, 6, 16, 10),
            Block.box(10, 13, 6, 12, 16, 10),
            Block.box(5, 4, 5, 11, 13, 9),
            Block.box(5, 8, 9, 11, 13, 11),
            Block.box(5, 4, 9, 11, 6, 11),
            Block.box(5, 6, 9, 7, 8, 11),
            Block.box(9, 6, 9, 11, 8, 11),
            Block.box(7, 6, 9, 9, 8, 10),
            Block.box(7, 10, 0, 9, 12, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape MODEL_SHAPE_E = Stream.of(
            Block.box(4, 0, 4, 12, 4, 12),
            Block.box(6, 14, 6, 10, 15, 10),
            Block.box(10, 13, 4, 12, 16, 12),
            Block.box(4, 13, 4, 6, 16, 12),
            Block.box(6, 13, 4, 10, 16, 6),
            Block.box(6, 13, 10, 10, 16, 12),
            Block.box(7, 4, 5, 11, 13, 11),
            Block.box(5, 8, 5, 7, 13, 11),
            Block.box(5, 4, 5, 7, 6, 11),
            Block.box(5, 6, 5, 7, 8, 7),
            Block.box(5, 6, 9, 7, 8, 11),
            Block.box(6, 6, 7, 7, 8, 9),
            Block.box(11, 10, 7, 16, 12, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape MODEL_SHAPE_S = Stream.of(
            Block.box(4, 0, 4, 12, 4, 12),
            Block.box(6, 14, 6, 10, 15, 10),
            Block.box(4, 13, 10, 12, 16, 12),
            Block.box(4, 13, 4, 12, 16, 6),
            Block.box(10, 13, 6, 12, 16, 10),
            Block.box(4, 13, 6, 6, 16, 10),
            Block.box(5, 4, 7, 11, 13, 11),
            Block.box(5, 8, 5, 11, 13, 7),
            Block.box(5, 4, 5, 11, 6, 7),
            Block.box(9, 6, 5, 11, 8, 7),
            Block.box(5, 6, 5, 7, 8, 7),
            Block.box(7, 6, 6, 9, 8, 7),
            Block.box(7, 10, 11, 9, 12, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    private static final VoxelShape MODEL_SHAPE_W = Stream.of(
            Block.box(4, 0, 4, 12, 4, 12),
            Block.box(6, 14, 6, 10, 15, 10),
            Block.box(4, 13, 4, 6, 16, 12),
            Block.box(10, 13, 4, 12, 16, 12),
            Block.box(6, 13, 10, 10, 16, 12),
            Block.box(6, 13, 4, 10, 16, 6),
            Block.box(5, 4, 5, 9, 13, 11),
            Block.box(9, 8, 5, 11, 13, 11),
            Block.box(9, 4, 5, 11, 6, 11),
            Block.box(9, 6, 9, 11, 8, 11),
            Block.box(9, 6, 5, 11, 8, 7),
            Block.box(9, 6, 7, 10, 8, 9),
            Block.box(0, 10, 7, 5, 12, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
