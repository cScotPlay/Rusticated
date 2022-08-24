package net.mcs3.elixiremporium.world.level.block;

import com.google.common.collect.ImmutableMap;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Iterator;
import java.util.Map;

public class LatticeBlock extends Block
{
    public static final BooleanProperty UP;
    public static final BooleanProperty DOWN;
    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    public static final BooleanProperty LEAVES;
    public static final VoxelShape BAR_BASE;
    public static final VoxelShape BAR_UP;
    public static final VoxelShape BAR_DOWN;
    public static final VoxelShape BAR_NORTH;
    public static final VoxelShape BAR_EAST;
    public static final VoxelShape BAR_SOUTH;
    public static final VoxelShape BAR_WEST;
    public static final VoxelShape LEAVES_BASE;
    public static final VoxelShape LEAVES_UP;
    public static final VoxelShape LEAVES_DOWN;
    public static final VoxelShape LEAVES_NORTH;
    public static final VoxelShape LEAVES_EAST;
    public static final VoxelShape LEAVES_SOUTH;
    public static final VoxelShape LEAVES_WEST;
    private final Map<BlockState, VoxelShape> shapeByIndex;
    private final Map<BlockState, VoxelShape> collisionShapeByIndex;


    public LatticeBlock() {
        super(Properties.of(Material.METAL, MaterialColor.NONE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion());
        this.registerDefaultState((this.stateDefinition.any()).setValue(LEAVES, false).setValue(DOWN, true).setValue(UP, false));
        this.shapeByIndex = this.makeShapes();
        this.collisionShapeByIndex = this.makeShapes();
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getMainHandItem();
        Block heldBlock = Block.byItem(heldItem.getItem());
        if(heldBlock != null && heldBlock instanceof LeavesBlock && !state.getValue(LEAVES)){

            ElixirEmporium.LOGGER.info("Set Leave State");
            level.setBlockAndUpdate(pos, state.setValue(LEAVES, true));
            player.getMainHandItem().shrink(1);
            return InteractionResult.CONSUME;
        }else if (heldItem.is(Items.SHEARS) && state.getValue(LEAVES)) {

            ElixirEmporium.LOGGER.info("Remove Leave State");
            level.setBlockAndUpdate(pos, state.setValue(LEAVES, false));
            return InteractionResult.CONSUME;
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return (VoxelShape)this.shapeByIndex.get(state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    private Map<BlockState, VoxelShape> makeShapes()
    {
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();

        Iterator varDown = DOWN.getPossibleValues().iterator();

        while(varDown.hasNext()) {
            Boolean sideDown = (Boolean) varDown.next();
            Iterator varEast = EAST.getPossibleValues().iterator();

            while (varEast.hasNext()) {
                Boolean sideEast = (Boolean) varEast.next();
                Iterator varNorth = NORTH.getPossibleValues().iterator();

                while (varNorth.hasNext()) {
                    Boolean sideNorth = (Boolean) varNorth.next();
                    Iterator varWest = WEST.getPossibleValues().iterator();

                    while (varWest.hasNext()) {
                        Boolean sideWest = (Boolean) varWest.next();
                        Iterator varSouth = SOUTH.getPossibleValues().iterator();

                        while (varSouth.hasNext()) {
                            Boolean sideSouth = (Boolean) varSouth.next();
                            Iterator varUp = UP.getPossibleValues().iterator();

                            while (varUp.hasNext()) {
                                Boolean sideUp = (Boolean) varUp.next();
                                Iterator leaves = LEAVES.getPossibleValues().iterator();

                                while (leaves.hasNext()){
                                    Boolean leavesCheck = (Boolean) leaves.next();

                                    VoxelShape voxelShapeBase = Shapes.empty();

                                    voxelShapeBase = applyLeaveShape(voxelShapeBase, leavesCheck, true, BAR_BASE, LEAVES_BASE);  //Sets the Base
                                    voxelShapeBase = applyLeaveShape(voxelShapeBase, leavesCheck, sideDown, BAR_DOWN, LEAVES_DOWN);   //Sets Down Shape
                                    voxelShapeBase = applyLeaveShape(voxelShapeBase, leavesCheck, sideEast, BAR_EAST, LEAVES_EAST);  //Sets East Shape
                                    voxelShapeBase = applyLeaveShape(voxelShapeBase, leavesCheck, sideNorth, BAR_NORTH, LEAVES_NORTH);  //Sets North Shape
                                    voxelShapeBase = applyLeaveShape(voxelShapeBase, leavesCheck, sideWest, BAR_WEST, LEAVES_WEST);  //Sets West Shape
                                    voxelShapeBase = applyLeaveShape(voxelShapeBase, leavesCheck, sideSouth, BAR_SOUTH, LEAVES_SOUTH);  //Sets South Shape
                                    voxelShapeBase = applyLeaveShape(voxelShapeBase, leavesCheck, sideUp, BAR_UP, LEAVES_UP);  //Sets Up Shape


                                    BlockState blockState = this.defaultBlockState().setValue(LEAVES, leavesCheck).setValue(DOWN, sideDown).setValue(UP, sideUp).setValue(NORTH, sideNorth).setValue(EAST, sideEast).setValue(SOUTH, sideSouth).setValue(WEST, sideWest);
                                    builder.put((BlockState) blockState, voxelShapeBase);
                                }
                            }
                        }
                    }
                }
            }
        }
        return builder.build();
    }

    private static VoxelShape applyLeaveShape(VoxelShape baseShape, Boolean leaveCheck, Boolean sideCheck, VoxelShape barShape, VoxelShape leavesShape) {
        if (sideCheck){
            if (leaveCheck){
                return Shapes.or(baseShape, leavesShape);
            }
            else
                return Shapes.or(baseShape, barShape);
        }
        else {
            return Shapes.or(baseShape);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        LevelReader levelReader = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockPos blockPosNorth = blockPos.north();
        BlockPos blockPosEast = blockPos.east();
        BlockPos blockPosSouth = blockPos.south();
        BlockPos blockPosWest = blockPos.west();
        BlockPos blockPosUp = blockPos.above();
        BlockPos blockPosDown = blockPos.below();

        BlockState blockStateNorth = levelReader.getBlockState(blockPosNorth);
        BlockState blockStateEast = levelReader.getBlockState(blockPosEast);
        BlockState blockStateSouth = levelReader.getBlockState(blockPosSouth);
        BlockState blockStateWest = levelReader.getBlockState(blockPosWest);
        BlockState blockStateUp = levelReader.getBlockState(blockPosUp);
        BlockState blockStateDown = levelReader.getBlockState(blockPosDown);

        boolean connectedNorth = this.connectsTo(blockStateNorth, blockStateNorth.isFaceSturdy(levelReader, blockPosNorth, Direction.SOUTH));
        boolean connectedEast = this.connectsTo(blockStateEast, blockStateEast.isFaceSturdy(levelReader, blockPosEast, Direction.WEST));
        boolean connectedSouth = this.connectsTo(blockStateSouth, blockStateSouth.isFaceSturdy(levelReader, blockPosSouth, Direction.NORTH));
        boolean connectedWest = this.connectsTo(blockStateWest, blockStateWest.isFaceSturdy(levelReader, blockPosWest, Direction.EAST));
        boolean connectedUp = this.connectsTo(blockStateUp, blockStateUp.isFaceSturdy(levelReader, blockPosUp, Direction.DOWN));
        boolean connectedDown = this.connectsTo(blockStateDown, blockStateDown.isFaceSturdy(levelReader, blockPosDown, Direction.UP));

        BlockState blockState6 = this.defaultBlockState();
        return (BlockState)blockState6.setValue(LEAVES, false).setValue(DOWN, connectedDown).setValue(NORTH, connectedNorth).setValue(EAST, connectedEast).setValue(SOUTH, connectedSouth).setValue(WEST, connectedWest).setValue(UP, connectedUp);
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        return this.checkStateofPlacement(level, currentPos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {

        Boolean leaveStatus = state.getValue(LEAVES);
        return (VoxelShape)this.collisionShapeByIndex.get(state);//.setValue(LEAVES, leaveStatus));
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState rotate(BlockState state, Rotation rotation) {
        switch(rotation) {
            case CLOCKWISE_180:
                return (BlockState)((BlockState)((BlockState)((BlockState)state.setValue(NORTH, (Boolean)state.getValue(SOUTH))).setValue(EAST, (Boolean)state.getValue(WEST))).setValue(SOUTH, (Boolean)state.getValue(NORTH))).setValue(WEST, (Boolean)state.getValue(EAST));
            case COUNTERCLOCKWISE_90:
                return (BlockState)((BlockState)((BlockState)((BlockState)state.setValue(NORTH, (Boolean)state.getValue(EAST))).setValue(EAST, (Boolean)state.getValue(SOUTH))).setValue(SOUTH, (Boolean)state.getValue(WEST))).setValue(WEST, (Boolean)state.getValue(NORTH));
            case CLOCKWISE_90:
                return (BlockState)((BlockState)((BlockState)((BlockState)state.setValue(NORTH, (Boolean)state.getValue(WEST))).setValue(EAST, (Boolean)state.getValue(NORTH))).setValue(SOUTH, (Boolean)state.getValue(EAST))).setValue(WEST, (Boolean)state.getValue(SOUTH));
            default:
                return state;
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, Mirror mirror) {
        switch(mirror) {
            case LEFT_RIGHT:
                return (BlockState)((BlockState)state.setValue(NORTH, (Boolean) state.getValue(SOUTH))).setValue(SOUTH, (Boolean) state.getValue(NORTH));
            case FRONT_BACK:
                return (BlockState)((BlockState)state.setValue(EAST, (Boolean)state.getValue(WEST))).setValue(WEST, (Boolean)state.getValue(EAST));
            default:
                return super.mirror(state, mirror);
        }
    }

    private BlockState checkStateofPlacement(LevelReader level, BlockPos blockPos)
    {
        BlockPos blockPosNorth = blockPos.north();
        BlockPos blockPosEast = blockPos.east();
        BlockPos blockPosSouth = blockPos.south();
        BlockPos blockPosWest = blockPos.west();
        BlockPos blockPosUp = blockPos.above();
        BlockPos blockPosDown = blockPos.below();

        Boolean leaveCheck = level.getBlockState(blockPos).getValue(LEAVES);

        BlockState blockStateNorth =  level.getBlockState(blockPosNorth);
        BlockState blockStateEast = level.getBlockState(blockPosEast);
        BlockState blockStateSouth = level.getBlockState(blockPosSouth);
        BlockState blockStateWest = level.getBlockState(blockPosWest);
        BlockState blockStateUp = level.getBlockState(blockPosUp);
        BlockState blockStateDown = level.getBlockState(blockPosDown);

        boolean connectedNorth = this.connectsTo(blockStateNorth, blockStateNorth.isFaceSturdy(level, blockPosNorth, Direction.SOUTH));
        boolean connectedEast = this.connectsTo(blockStateEast, blockStateEast.isFaceSturdy(level, blockPosEast, Direction.WEST));
        boolean connectedSouth = this.connectsTo(blockStateSouth, blockStateSouth.isFaceSturdy(level, blockPosSouth, Direction.NORTH));
        boolean connectedWest = this.connectsTo(blockStateWest, blockStateWest.isFaceSturdy(level, blockPosWest, Direction.EAST));
        boolean connectedUp = this.connectsTo(blockStateUp, blockStateUp.isFaceSturdy(level, blockPosUp, Direction.DOWN));
        boolean connectedDown = this.connectsTo(blockStateDown, blockStateDown.isFaceSturdy(level, blockPosDown, Direction.UP));

        BlockState blockStateUpdate = this.defaultBlockState();
        return (BlockState)blockStateUpdate.setValue(LEAVES, leaveCheck).setValue(DOWN, connectedDown).setValue(NORTH, connectedNorth).setValue(EAST, connectedEast).setValue(SOUTH, connectedSouth).setValue(WEST, connectedWest).setValue(UP, connectedUp);
    }

    private boolean connectsTo(BlockState state, boolean sideSolid) {
        Block block = state.getBlock();
        return !isExceptionForConnection(state) && sideSolid || block instanceof LatticeBlock || block instanceof IronBarsBlock || block instanceof RopeBlock;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    protected void createBlockStateDefinition(net.minecraft.world.level.block.state.StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LEAVES, UP, DOWN, NORTH, EAST, SOUTH, WEST});
    }

    static {

        UP = BlockStateProperties.UP;
        DOWN = BlockStateProperties.DOWN;
        NORTH = BlockStateProperties.NORTH;
        EAST = BlockStateProperties.EAST;
        SOUTH = BlockStateProperties.SOUTH;
        WEST = BlockStateProperties.WEST;
        LEAVES = BooleanProperty.create("leaves");

        BAR_BASE = Block.box(7.0, 7.0, 7.0, 9.0, 9.0, 9.0);
        BAR_UP = Block.box(7.0, 9.0, 7.0, 9.0, 16.0, 9.0);
        BAR_DOWN = Block.box(7.0, 0.0, 7.0, 9.0, 7.0, 9.0);
        BAR_NORTH = Block.box(7.0, 7.0, 0.0, 9.0, 9.0, 7.0);
        BAR_EAST = Block.box(9.0, 7.0, 7.0, 16.0, 9.0, 9.0);
        BAR_SOUTH = Block.box(7.0, 7.0, 9.0, 9.0, 9.0, 16.0);
        BAR_WEST = Block.box(0.0, 7.0, 7.0, 7.0, 9.0, 9.0);

        LEAVES_BASE = Block.box(5.5, 5.5, 5.5, 10.5, 10.5, 10.5);
        LEAVES_UP = Block.box(5.5, 10.5, 5.5, 10.5, 16.0, 10.5);
        LEAVES_DOWN = Block.box(5.5, 0.0, 5.5, 10.5, 5.5, 10.5);
        LEAVES_NORTH = Block.box(5.5, 5.5, 0.0, 10.5, 10.5, 5.5);
        LEAVES_EAST = Block.box(10.5, 5.5, 5.5, 16.0, 10.5, 10.5);
        LEAVES_SOUTH = Block.box(5.5, 5.5, 10.5, 10.5, 10.5, 16.0);
        LEAVES_WEST = Block.box(0.0, 5.5, 5.5, 5.5, 10.5, 10.5);
    }
}
