package net.mcs3.rusticated.world.level.block;

import net.mcs3.rusticated.init.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TiedStakeBlock extends Block
{
    protected static final VoxelShape CROP_SHAPE = Shapes.or(box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0), box(5.0, 4.0, 5.0, 11.0, 12.0, 11.0));

    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty WEST = BooleanProperty.create("west");

    public TiedStakeBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(NORTH, false)).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return CROP_SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos)
    {
        boolean n = false;
        boolean e = false;
        boolean s = false;
        boolean w = false;

        BlockState blockState = level.getBlockState(currentPos.north());
        if(blockState.getBlock() instanceof RopeBlock && blockState.getValue(RopeBlock.AXIS) == Direction.Axis.Z)
        {
            n = true;
        }
        if(blockState.getBlock() == this)
        {
            n = true;
        }

        blockState = level.getBlockState(currentPos.east());
        if(blockState.getBlock() instanceof RopeBlock && blockState.getValue(RopeBlock.AXIS) == Direction.Axis.X)
        {
            e = true;
        }
        if(blockState.getBlock() == this)
        {
            e = true;
        }

        blockState = level.getBlockState(currentPos.south());
        if(blockState.getBlock() instanceof RopeBlock && blockState.getValue(RopeBlock.AXIS) == Direction.Axis.Z)
        {
            s = true;
        }
        if(blockState.getBlock() == this)
        {
            s = true;
        }

        blockState = level.getBlockState(currentPos.west());
        if(blockState.getBlock() instanceof RopeBlock && blockState.getValue(RopeBlock.AXIS) == Direction.Axis.X)
        {
            w = true;
        }
        if(blockState.getBlock() == this)
        {
            w = true;
        }

        return this.defaultBlockState().setValue(NORTH, n).setValue(EAST, e).setValue(SOUTH, s).setValue(WEST, w);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(ModBlocks.ROPE);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST);
    }
}
