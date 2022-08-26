package net.mcs3.elixiremporium.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class RopeBlock extends ChainBlock
{
    public static final BooleanProperty DANGLE = BooleanProperty.create("dangle");
    protected static final VoxelShape Y_AXIS_AABB = Block.box(7.0, 0.0, 7.0, 9.0, 16.0, 9.0);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(7.0, 7.0, 0.0, 9.0, 9.0, 16.0);
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0, 7.0, 7.0, 16.0, 9.0, 9.0);

    public RopeBlock()
    {
        super(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).strength(0.5F).instabreak().sound(SoundType.WOOL));
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(WATERLOGGED, false)).setValue(AXIS, Direction.Axis.Y).setValue(DANGLE, false));
    }

    public RopeBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch ((Direction.Axis)state.getValue(AXIS)) {
            default: {
                return X_AXIS_AABB;
            }
            case Z: {
                return Z_AXIS_AABB;
            }
            case Y:
        }
        return Y_AXIS_AABB;
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        ItemStack heldItemStack = player.getMainHandItem();
        Item heldItem = heldItemStack.getItem();
        Item chain = this.asItem();

        if(heldItem == chain){
            Boolean isRope = true;
            Block currentBlock = this;
            BlockPos currentPos = pos;
            while (isRope)
            {
                currentPos = currentPos.below();
                currentBlock = level.getBlockState(currentPos).getBlock();

                if(currentBlock != this)
                {
                    isRope = false;
                }
            }
            if (currentBlock != Blocks.AIR)
                return InteractionResult.FAIL;
            else
            {
                int heldItemStackCount = heldItemStack.getCount() - 1;
                ItemStack newHeldItemStack = new ItemStack(heldItem, heldItemStackCount);
                level.setBlockAndUpdate(currentPos, this.defaultBlockState());
                level.playSound(player, pos, SoundType.WOOL.getPlaceSound(), SoundSource.BLOCKS, soundType.getVolume() + 1.0F, soundType.getPitch() * 0.8F);
                player.setItemInHand(hand, newHeldItemStack);
                return InteractionResult.CONSUME;
            }
        }
        else
            return InteractionResult.FAIL;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        for (Direction direction : context.getNearestLookingDirections()) {
            BlockState blockState;
            BlockPos blockPos = context.getClickedPos();

            if(direction.getAxis() == Direction.Axis.X)
            {
                BlockPos north = blockPos.north();
                BlockPos south = blockPos.south();
                Block blockNorth = context.getLevel().getBlockState(north).getBlock();
                Block blockSouth = context.getLevel().getBlockState(south).getBlock();

                if(blockNorth instanceof RopeBlock || blockSouth instanceof RopeBlock) return null;

                else return this.defaultBlockState().setValue(AXIS, Direction.Axis.X);
            }
            else if(direction.getAxis() == Direction.Axis.Z)
            {
                BlockPos east = blockPos.east();
                BlockPos west = blockPos.west();
                Block blockEast = context.getLevel().getBlockState(east).getBlock();
                Block blockWest = context.getLevel().getBlockState(west).getBlock();

                if(blockEast instanceof RopeBlock || blockWest instanceof RopeBlock) return null;

                else return this.defaultBlockState().setValue(AXIS, Direction.Axis.Z);
            }
            else if(direction.getAxis() == Direction.Axis.Y)
            {
                return this.defaultBlockState().setValue(AXIS, Direction.Axis.Y);
            }
        }
        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED).add(AXIS).add(DANGLE);
    }


    /**
     * Update the provided state given the provided neighbor direction and neighbor state, returning a new state.
     * This is to be used to create the knot in the rope.
     */
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos)
    {
        if (!state.canSurvive(level, currentPos))
        {
            state.setValue(DANGLE, false);
            return Blocks.AIR.defaultBlockState();
        }
        else if(state.getValue(AXIS) != Direction.Axis.Y && level.getBlockState(currentPos.below()).getBlock() instanceof RopeBlock && level.getBlockState(currentPos.below()).getValue(AXIS) == Direction.Axis.Y)
        {
            return super.updateShape(state.setValue(DANGLE, true), direction, neighborState, level, currentPos, neighborPos);
        }
        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }


    @Override
    @SuppressWarnings("deprecation")
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        int xPos = pos.getX();
        int yPos = pos.getY() + 1;
        int zPos = pos.getZ();
        BlockPos blockAbove = new BlockPos(xPos, yPos, zPos);
        Block block = level.getBlockState(blockAbove).getBlock();

        if(state.getValue(AXIS) == Direction.Axis.X || state.getValue(AXIS) == Direction.Axis.Z) return true;
//        {
//            if(state.getValue(AXIS) == Direction.Axis.X)
//            {
//                BlockPos north = pos.north();
//                BlockPos south = pos.south();
//                Block blockNorth = level.getBlockState(north).getBlock();
//                Block blockSouth = level.getBlockState(south).getBlock();
//                if(blockNorth instanceof RopeBlock || blockSouth instanceof RopeBlock && ) return false;
//            }
//
//
//        }
        else if(block == Blocks.AIR) return false;


        return true;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(level instanceof ServerLevel && entity instanceof Projectile)
        {
            level.destroyBlock(new BlockPos(pos), true, entity);
            entity.discard();
        }
        super.entityInside(state, level, pos, entity);
    }
}
