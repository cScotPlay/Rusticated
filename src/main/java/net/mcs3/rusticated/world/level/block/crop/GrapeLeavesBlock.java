package net.mcs3.rusticated.world.level.block.crop;

import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModItems;
import net.mcs3.rusticated.world.level.block.LatticeBlock;
import net.mcs3.rusticated.world.level.block.RopeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class GrapeLeavesBlock extends RopeBlock implements BonemealableBlock
{
    public static final BooleanProperty GRAPES = BooleanProperty.create("grapes");
    public static final IntegerProperty DISTANCE = IntegerProperty.create("distance", 0, 1);
    private static final VoxelShape[] SHAPE_BY_DIST = new VoxelShape[]{
            Shapes.or(box(0.0, 1.0, 0.0, 16.0, 15.0, 16.0), box(6.0, 0.0, 6.0, 10.0, 6.0, 10.0)),
            Block.box(3.0, 3.0, 0.0, 13.0, 3.0, 16.0)};
    private static final VoxelShape SHAPE_DIST_0 = Shapes.or(box(0.0, 1.0, 0.0, 16.0, 15.0, 16.0), box(6.0, 0.0, 6.0, 10.0, 6.0, 10.0));
    private static final VoxelShape SHAPE_DIST_1_X = Shapes.or(box(0.0, 3.0, 3.0, 16.0, 13.0, 13.0));
    private static final VoxelShape SHAPE_DIST_1_Z = Shapes.or(box(3.0, 3.0, 0.0, 13.0, 13.0, 16.0));

    public GrapeLeavesBlock()
    {
        super(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS));
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(WATERLOGGED, false).setValue(getDistanceProperty(), 0).setValue(DISTANCE, 0).setValue(AXIS, Direction.Axis.X).setValue(GRAPES, false));
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        if(state.getValue(DISTANCE) == 0) return SHAPE_DIST_0;
        if(state.getValue(DISTANCE) == 1 && state.getValue(AXIS) == Direction.Axis.X)
        {
            return SHAPE_DIST_1_X;
        }
        else
        {
            return SHAPE_DIST_1_Z;
        }
    }

    public IntegerProperty getDistanceProperty() {
        return DISTANCE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        //return super.use(state, level, pos, player, hand, hit);
        if (state.getValue(GRAPES) == true)
        {
            Direction.Axis axis = state.getValue(AXIS);
            level.setBlock(pos, ModBlocks.GRAPE_LEAVES.defaultBlockState().setValue(AXIS, axis).setValue(DISTANCE, 1).setValue(GRAPES,false), 3);
            Block.popResource(level,pos, ModItems.GRAPES.getDefaultInstance());
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state, level, pos, random);
        if (!this.isBlockSupported(level, pos, state))
        {
            level.destroyBlock(pos, false);
        }
        if(level.getRawBrightness(pos, 0) >= 9)
        {
            int distance = state.getValue(DISTANCE);
            float f;
            if(distance > 0 && !state.getValue(GRAPES) && level.getBlockState(pos.below()).getBlock() == Blocks.AIR)
            {
                if(random.nextInt((int)(25.0f / (f = getGrowthSpeed(this, level, pos))) + 1) == 0)
                {
                    Direction.Axis axis = state.getValue(AXIS);
                    level.setBlock(pos, ModBlocks.GRAPE_LEAVES.defaultBlockState().setValue(AXIS, axis).setValue(DISTANCE, 1).setValue(GRAPES,true), 3);
                }
            }
            else if(distance < 1 && canSpread(level, pos, state))
            {
                if(random.nextInt((int)(25.0f / (f = getGrowthSpeed(this, level, pos))) + 1) == 0)
                {
                    spread(level, pos, state);
                }
            }
        }
    }

    public boolean isBlockSupported(Level level, BlockPos pos, BlockState state) {
        if (state.getValue(AXIS) == Direction.Axis.X) {
            return this.isSideSupported(level, pos, state, Direction.WEST) || this.isSideSupported(level, pos, state, Direction.EAST);
        } else if (state.getValue(AXIS) == Direction.Axis.Z) {
            return this.isSideSupported(level, pos, state, Direction.NORTH) || this.isSideSupported(level, pos, state, Direction.SOUTH);
        }
        return false;
    }

    public boolean isSideSupported(Level level, BlockPos pos, BlockState state, Direction direction) {
        BlockState testState = level.getBlockState(pos.relative(direction));

        boolean isSame = testState.getBlock() == state.getBlock() && (testState.getValue(AXIS) == state.getValue(AXIS));
        boolean isRope = testState.getBlock() == ModBlocks.ROPE && state.getValue(AXIS) == testState.getValue(RopeBlock.AXIS);
        boolean isSideSolid = Block.canSupportCenter(level, pos.relative(direction), direction.getOpposite());
        boolean isTiedStake = testState.getBlock() == ModBlocks.TIED_STAKE;
        boolean isLattice = testState.getBlock() instanceof LatticeBlock;

        return isSame || isRope || isSideSolid || isTiedStake || isLattice;
    }

    protected static float getGrowthSpeed(Block block, BlockGetter level, BlockPos pos)
    {
        return 3F;
    }

    @SuppressWarnings("incomplete-switch")
    public boolean canSpread(Level level, BlockPos pos, BlockState state) {
        if (state.getValue(DISTANCE) == 0) {
            switch (state.getValue(AXIS)) {
                case X:
                    return (level.getBlockState(pos.west()).getBlock() == ModBlocks.ROPE
                            && level.getBlockState(pos.west()).getValue(RopeBlock.AXIS) == state.getValue(AXIS))
                            || (level.getBlockState(pos.east()).getBlock() == ModBlocks.ROPE
                            && level.getBlockState(pos.east()).getValue(RopeBlock.AXIS) == state.getValue(AXIS));
                case Z:
                    return (level.getBlockState(pos.north()).getBlock() == ModBlocks.ROPE
                            && level.getBlockState(pos.north()).getValue(RopeBlock.AXIS) == state.getValue(AXIS))
                            || (level.getBlockState(pos.south()).getBlock() == ModBlocks.ROPE
                            && level.getBlockState(pos.south()).getValue(RopeBlock.AXIS) == state.getValue(AXIS));
            }
        }
        return false;
    }

    @SuppressWarnings("incomplete-switch")
    public void spread(Level level, BlockPos pos, BlockState state) {
        if (state.getValue(DISTANCE) < 1) {
            switch (state.getValue(AXIS)) {
                case X:
                    boolean westRope = level.getBlockState(pos.west()).getBlock() == ModBlocks.ROPE
                            && level.getBlockState(pos.west()).getValue(RopeBlock.AXIS) == state.getValue(AXIS);
                    boolean eastRope = level.getBlockState(pos.east()).getBlock() == ModBlocks.ROPE
                            && level.getBlockState(pos.east()).getValue(RopeBlock.AXIS) == state.getValue(AXIS);
                    if (westRope && eastRope) {
                        spreadToValidRope(level, pos, (level.random.nextFloat() < 0.5) ? pos.west() : pos.east(), state);
                    } else if (westRope) {
                        spreadToValidRope(level, pos, pos.west(), state);
                    } else if (eastRope) {
                        spreadToValidRope(level, pos, pos.east(), state);
                    }
                    break;
                case Z:
                    boolean northRope = level.getBlockState(pos.north()).getBlock() == ModBlocks.ROPE
                            && level.getBlockState(pos.north()).getValue(RopeBlock.AXIS) == state.getValue(AXIS);
                    boolean southRope = level.getBlockState(pos.south()).getBlock() == ModBlocks.ROPE
                            && level.getBlockState(pos.south()).getValue(RopeBlock.AXIS) == state.getValue(AXIS);
                    if (northRope && southRope) {
                        spreadToValidRope(level, pos, (level.random.nextFloat() < 0.5) ? pos.north() : pos.south(), state);
                    } else if (northRope) {
                        spreadToValidRope(level, pos, pos.north(), state);
                    } else if (southRope) {
                        spreadToValidRope(level, pos, pos.south(), state);
                    }
                    break;
            }
        }
    }

    private void spreadToValidRope(Level level, BlockPos origPos, BlockPos newPos, BlockState state) {
        Direction.Axis axis = level.getBlockState(newPos).getValue(RopeBlock.AXIS);
        level.setBlock(newPos, state.setValue(AXIS, axis).setValue(DISTANCE, 1), 2);
    }

    public void growCrops(Level level, BlockPos pos, BlockState state)
    {
        if(state.getValue(DISTANCE) > 0)
        {
            level.setBlock(pos, state.setValue(GRAPES, true), 3);
        }else
        {
            spread(level, pos, state);
        }

    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, Random random, BlockPos pos, BlockState state) {
        this.growCrops(level, pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, AXIS, DISTANCE, GRAPES);
    }
}
