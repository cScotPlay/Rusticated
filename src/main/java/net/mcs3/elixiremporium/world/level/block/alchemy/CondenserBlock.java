package net.mcs3.elixiremporium.world.level.block.alchemy;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class CondenserBlock extends Block
{
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;


    public CondenserBlock()
    {
        super(Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.STONE).lightLevel(blockState -> blockState.getValue(BlockStateProperties.LIT) ? 13 : 0).noOcclusion());
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(LIT, false).setValue(BOTTOM, true));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        if (state.getValue(BOTTOM) == true)
        {
         switch (state.getValue(FACING))
         {
             case NORTH:
                 return SHAPE_N;
             case EAST:
                 return SHAPE_E;
             case SOUTH:
                 return SHAPE_S;
             case WEST:
                 return SHAPE_W;
             default:
                 return SHAPE_N;
         }
        }else
            return SHAPE_TOP;

    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player)
    {
        BlockState belowState = level.getBlockState(pos.below());
        BlockState aboveState = level.getBlockState(pos.above());

        if (belowState.getBlock() instanceof CondenserBlock)
        {
            level.setBlock(pos.below(), Blocks.AIR.defaultBlockState(), 35);
            level.levelEvent(player, 2001, pos.below(), Block.getId(belowState));
        } else if (aboveState.getBlock() instanceof CondenserBlock)
        {
            level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 35);
            level.levelEvent(player, 2001, pos.below(), Block.getId(aboveState));
        }

        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos)
    {
        BlockPos lowerBlock = currentPos.below();
        BlockState blockStateDown = level.getBlockState(lowerBlock);
        BlockPos upperBlock = currentPos.above();
        BlockState blockStateUp = level.getBlockState(upperBlock);

        if (!state.getValue(BOTTOM))
        {
            if (!blockStateDown.is(this))
            {
            return Blocks.AIR.defaultBlockState();
            }
        }else if (state.getValue(BOTTOM))
        {
            if (!blockStateUp.is(this))
            {
                return Blocks.AIR.defaultBlockState();
            }
        } return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        level.setBlock(pos.above(), (BlockState)state.setValue(FACING, state.getValue(FACING)).setValue(LIT, false).setValue(BOTTOM, false), 3);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.BLOCK;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
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
        builder.add(FACING, LIT, BOTTOM);
    }

    private static final VoxelShape SHAPE_TOP = Stream.of(
            Block.box(0, 0, 0, 16, 3, 16),
            Block.box(4, 3, 4, 12, 5, 12),
            Block.box(5, 5, 5, 11, 6, 11),
            Block.box(3, 5, 3, 13, 7, 5),
            Block.box(11, 5, 5, 13, 7, 11),
            Block.box(3, 5, 11, 13, 7, 13),
            Block.box(3, 5, 5, 5, 7, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(6, 7, 2, 10, 13, 13),
            Block.box(0, 0, 14, 16, 16, 16),
            Block.box(0.5, 9, 6, 1.5, 13, 10),
            Block.box(0, 0, 0, 4, 5, 4),
            Block.box(0, 5, 0, 2, 9, 2),
            Block.box(0, 9, 0, 4, 13, 4),
            Block.box(0, 13, 0, 2, 16, 2),
            Block.box(0, 0, 12, 1, 5, 14),
            Block.box(0, 9, 12, 1, 13, 14),
            Block.box(15, 0, 12, 16, 5, 14),
            Block.box(12, 0, 0, 16, 5, 4),
            Block.box(14, 13, 0, 16, 16, 2),
            Block.box(12, 9, 0, 16, 13, 4),
            Block.box(15, 9, 12, 16, 13, 14),
            Block.box(14, 5, 0, 16, 9, 2),
            Block.box(14.5, 9, 6, 15.5, 13, 10),
            Block.box(6, 0, 1, 10, 7, 14),
            Block.box(6, 13, 1, 10, 16, 14),
            Block.box(10, 0, 1, 15, 16, 14),
            Block.box(1, 0, 1, 6, 16, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(3, 7, 6, 14, 13, 10),
            Block.box(0, 0, 0, 2, 16, 16),
            Block.box(6, 9, 0.5, 10, 13, 1.5),
            Block.box(12, 0, 0, 16, 5, 4),
            Block.box(14, 5, 0, 16, 9, 2),
            Block.box(12, 9, 0, 16, 13, 4),
            Block.box(14, 13, 0, 16, 16, 2),
            Block.box(2, 0, 0, 4, 5, 1),
            Block.box(2, 9, 0, 4, 13, 1),
            Block.box(2, 0, 15, 4, 5, 16),
            Block.box(12, 0, 12, 16, 5, 16),
            Block.box(14, 13, 14, 16, 16, 16),
            Block.box(12, 9, 12, 16, 13, 16),
            Block.box(2, 9, 15, 4, 13, 16),
            Block.box(14, 5, 14, 16, 9, 16),
            Block.box(6, 9, 14.5, 10, 13, 15.5),
            Block.box(2, 0, 6, 15, 7, 10),
            Block.box(2, 13, 6, 15, 16, 10),
            Block.box(2, 0, 10, 15, 16, 15),
            Block.box(2, 0, 1, 15, 16, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(6, 7, 3, 10, 13, 14),
            Block.box(0, 0, 0, 16, 16, 2),
            Block.box(14.5, 9, 6, 15.5, 13, 10),
            Block.box(12, 0, 12, 16, 5, 16),
            Block.box(14, 5, 14, 16, 9, 16),
            Block.box(12, 9, 12, 16, 13, 16),
            Block.box(14, 13, 14, 16, 16, 16),
            Block.box(15, 0, 2, 16, 5, 4),
            Block.box(15, 9, 2, 16, 13, 4),
            Block.box(0, 0, 2, 1, 5, 4),
            Block.box(0, 0, 12, 4, 5, 16),
            Block.box(0, 13, 14, 2, 16, 16),
            Block.box(0, 9, 12, 4, 13, 16),
            Block.box(0, 9, 2, 1, 13, 4),
            Block.box(0, 5, 14, 2, 9, 16),
            Block.box(0.5, 9, 6, 1.5, 13, 10),
            Block.box(6, 0, 2, 10, 7, 15),
            Block.box(6, 13, 2, 10, 16, 15),
            Block.box(1, 0, 2, 6, 16, 15),
            Block.box(10, 0, 2, 15, 16, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(2, 7, 6, 13, 13, 10),
            Block.box(14, 0, 0, 16, 16, 16),
            Block.box(6, 9, 14.5, 10, 13, 15.5),
            Block.box(0, 0, 12, 4, 5, 16),
            Block.box(0, 5, 14, 2, 9, 16),
            Block.box(0, 9, 12, 4, 13, 16),
            Block.box(0, 13, 14, 2, 16, 16),
            Block.box(12, 0, 15, 14, 5, 16),
            Block.box(12, 9, 15, 14, 13, 16),
            Block.box(12, 0, 0, 14, 5, 1),
            Block.box(0, 0, 0, 4, 5, 4),
            Block.box(0, 13, 0, 2, 16, 2),
            Block.box(0, 9, 0, 4, 13, 4),
            Block.box(12, 9, 0, 14, 13, 1),
            Block.box(0, 5, 0, 2, 9, 2),
            Block.box(6, 9, 0.5, 10, 13, 1.5),
            Block.box(1, 0, 6, 14, 7, 10),
            Block.box(1, 13, 6, 14, 16, 10),
            Block.box(1, 0, 1, 14, 16, 6),
            Block.box(1, 0, 10, 14, 16, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

}
