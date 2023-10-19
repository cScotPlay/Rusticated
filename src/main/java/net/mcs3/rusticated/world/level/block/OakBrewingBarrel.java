package net.mcs3.rusticated.world.level.block;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.world.level.block.entity.BrewingBarrelBlockEntity;
import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class OakBrewingBarrel extends BaseEntityBlock implements EntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final ResourceLocation CONTENTS;


    public OakBrewingBarrel() {
        super(Properties.of().mapColor(MapColor.WOOD).requiresCorrectToolForDrops().strength(1.5F).sound(SoundType.WOOD));
        this.registerDefaultState(((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
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
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
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
        builder.add(FACING);
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BrewingBarrelBlockEntity blockEntity = (BrewingBarrelBlockEntity) level.getBlockEntity(pos);

        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            if(player.isCrouching() && player.getMainHandItem().isEmpty()) { //Remove All Fluids
                if(blockEntity.primerFluidStorage.amount != 0) {
                    blockEntity.extractFluids(blockEntity, blockEntity.primerFluidStorage, blockEntity.primerFluidStorage.variant, blockEntity.primerFluidStorage.amount);
                }
                if(blockEntity.inputFluidStorage.amount != 0) {
                    blockEntity.extractFluids(blockEntity, blockEntity.inputFluidStorage, blockEntity.inputFluidStorage.variant, blockEntity.inputFluidStorage.amount);
                }
                if(blockEntity.resultFluidStorage.amount != 0) {
                    blockEntity.extractFluids(blockEntity, blockEntity.resultFluidStorage, blockEntity.resultFluidStorage.variant, blockEntity.resultFluidStorage.amount);
                }
            }
            this.openContainer(level, pos, player);
            return InteractionResult.CONSUME;
        }
    }

    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof BrewingBarrelBlockEntity) {
            player.openMenu((MenuProvider)blockEntity);
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof Container) {
                Containers.dropContents(level, pos, (Container)blockEntity);
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BrewingBarrelBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, ModBlockEntityTypes.BREWING_BARREL_CONTAINER, BrewingBarrelBlockEntity::serverTick);
    }

    static {
        CONTENTS = new ResourceLocation(Rusticated.MOD_ID,"contents");
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(10, 0, 2, 12, 1, 6),
            Block.box(14, 3, 1, 15, 13, 16),
            Block.box(10, 0, 11, 12, 1, 15),
            Block.box(4, 0, 2, 6, 1, 6),
            Block.box(4, 0, 11, 6, 1, 15),
            Block.box(2, 3, 2, 14, 13, 15),
            Block.box(2, 13, 1, 3, 14, 16),
            Block.box(1, 3, 1, 2, 13, 16),
            Block.box(3, 2, 2, 13, 3, 15),
            Block.box(3, 13, 2, 13, 14, 15),
            Block.box(2, 2, 1, 3, 3, 16),
            Block.box(13, 2, 1, 14, 3, 16),
            Block.box(13, 13, 1, 14, 14, 16),
            Block.box(3, 14, 1, 13, 15, 16),
            Block.box(3, 1, 1, 13, 2, 16),
            Block.box(0.5, 2.5, 3, 1.5, 13.5, 5),
            Block.box(14.5, 2.5, 12, 15.5, 13.5, 14),
            Block.box(1.5, 12.5, 12, 3.5, 14.5, 14),
            Block.box(1.5, 1.5, 12, 3.5, 3.5, 14),
            Block.box(12.5, 12.5, 12, 14.5, 14.5, 14),
            Block.box(12.5, 1.5, 12, 14.5, 3.5, 14),
            Block.box(2.5, 14.5, 12, 13.5, 15.5, 14),
            Block.box(2.5, 0.5, 12, 13.5, 1.5, 14),
            Block.box(7, 3, 0, 9, 5, 2),
            Block.box(0.5, 2.5, 12, 1.5, 13.5, 14),
            Block.box(14.5, 2.5, 3, 15.5, 13.5, 5),
            Block.box(1.5, 12.5, 3, 3.5, 14.5, 5),
            Block.box(1.5, 1.5, 3, 3.5, 3.5, 5),
            Block.box(12.5, 12.5, 3, 14.5, 14.5, 5),
            Block.box(12.5, 1.5, 3, 14.5, 3.5, 5),
            Block.box(2.5, 14.5, 3, 13.5, 15.5, 5),
            Block.box(2.5, 0.5, 3, 13.5, 1.5, 5),
            Block.box(7, 15, 9, 9, 16, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(10, 0, 10, 14, 1, 12),
            Block.box(0, 3, 14, 15, 13, 15),
            Block.box(1, 0, 10, 5, 1, 12),
            Block.box(10, 0, 4, 14, 1, 6),
            Block.box(1, 0, 4, 5, 1, 6),
            Block.box(1, 3, 2, 14, 13, 14),
            Block.box(0, 13, 2, 15, 14, 3),
            Block.box(0, 3, 1, 15, 13, 2),
            Block.box(1, 2, 3, 14, 3, 13),
            Block.box(1, 13, 3, 14, 14, 13),
            Block.box(0, 2, 2, 15, 3, 3),
            Block.box(0, 2, 13, 15, 3, 14),
            Block.box(0, 13, 13, 15, 14, 14),
            Block.box(0, 14, 3, 15, 15, 13),
            Block.box(0, 1, 3, 15, 2, 13),
            Block.box(11, 2.5, 0.5, 13, 13.5, 1.5),
            Block.box(2, 2.5, 14.5, 4, 13.5, 15.5),
            Block.box(2, 12.5, 1.5, 4, 14.5, 3.5),
            Block.box(2, 1.5, 1.5, 4, 3.5, 3.5),
            Block.box(2, 12.5, 12.5, 4, 14.5, 14.5),
            Block.box(2, 1.5, 12.5, 4, 3.5, 14.5),
            Block.box(2, 14.5, 2.5, 4, 15.5, 13.5),
            Block.box(2, 0.5, 2.5, 4, 1.5, 13.5),
            Block.box(14, 3, 7, 16, 5, 9),
            Block.box(2, 2.5, 0.5, 4, 13.5, 1.5),
            Block.box(11, 2.5, 14.5, 13, 13.5, 15.5),
            Block.box(11, 12.5, 1.5, 13, 14.5, 3.5),
            Block.box(11, 1.5, 1.5, 13, 3.5, 3.5),
            Block.box(11, 12.5, 12.5, 13, 14.5, 14.5),
            Block.box(11, 1.5, 12.5, 13, 3.5, 14.5),
            Block.box(11, 14.5, 2.5, 13, 15.5, 13.5),
            Block.box(11, 0.5, 2.5, 13, 1.5, 13.5),
            Block.box(5, 15, 7, 7, 16, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(4, 0, 10, 6, 1, 14),
            Block.box(1, 3, 0, 2, 13, 15),
            Block.box(4, 0, 1, 6, 1, 5),
            Block.box(10, 0, 10, 12, 1, 14),
            Block.box(10, 0, 1, 12, 1, 5),
            Block.box(2, 3, 1, 14, 13, 14),
            Block.box(13, 13, 0, 14, 14, 15),
            Block.box(14, 3, 0, 15, 13, 15),
            Block.box(3, 2, 1, 13, 3, 14),
            Block.box(3, 13, 1, 13, 14, 14),
            Block.box(13, 2, 0, 14, 3, 15),
            Block.box(2, 2, 0, 3, 3, 15),
            Block.box(2, 13, 0, 3, 14, 15),
            Block.box(3, 14, 0, 13, 15, 15),
            Block.box(3, 1, 0, 13, 2, 15),
            Block.box(14.5, 2.5, 11, 15.5, 13.5, 13),
            Block.box(0.5, 2.5, 2, 1.5, 13.5, 4),
            Block.box(12.5, 12.5, 2, 14.5, 14.5, 4),
            Block.box(12.5, 1.5, 2, 14.5, 3.5, 4),
            Block.box(1.5, 12.5, 2, 3.5, 14.5, 4),
            Block.box(1.5, 1.5, 2, 3.5, 3.5, 4),
            Block.box(2.5, 14.5, 2, 13.5, 15.5, 4),
            Block.box(2.5, 0.5, 2, 13.5, 1.5, 4),
            Block.box(7, 3, 14, 9, 5, 16),
            Block.box(14.5, 2.5, 2, 15.5, 13.5, 4),
            Block.box(0.5, 2.5, 11, 1.5, 13.5, 13),
            Block.box(12.5, 12.5, 11, 14.5, 14.5, 13),
            Block.box(12.5, 1.5, 11, 14.5, 3.5, 13),
            Block.box(1.5, 12.5, 11, 3.5, 14.5, 13),
            Block.box(1.5, 1.5, 11, 3.5, 3.5, 13),
            Block.box(2.5, 14.5, 11, 13.5, 15.5, 13),
            Block.box(2.5, 0.5, 11, 13.5, 1.5, 13),
            Block.box(7, 15, 5, 9, 16, 7)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(2, 0, 4, 6, 1, 6),
            Block.box(1, 3, 1, 16, 13, 2),
            Block.box(11, 0, 4, 15, 1, 6),
            Block.box(2, 0, 10, 6, 1, 12),
            Block.box(11, 0, 10, 15, 1, 12),
            Block.box(2, 3, 2, 15, 13, 14),
            Block.box(1, 13, 13, 16, 14, 14),
            Block.box(1, 3, 14, 16, 13, 15),
            Block.box(2, 2, 3, 15, 3, 13),
            Block.box(2, 13, 3, 15, 14, 13),
            Block.box(1, 2, 13, 16, 3, 14),
            Block.box(1, 2, 2, 16, 3, 3),
            Block.box(1, 13, 2, 16, 14, 3),
            Block.box(1, 14, 3, 16, 15, 13),
            Block.box(1, 1, 3, 16, 2, 13),
            Block.box(3, 2.5, 14.5, 5, 13.5, 15.5),
            Block.box(12, 2.5, 0.5, 14, 13.5, 1.5),
            Block.box(12, 12.5, 12.5, 14, 14.5, 14.5),
            Block.box(12, 1.5, 12.5, 14, 3.5, 14.5),
            Block.box(12, 12.5, 1.5, 14, 14.5, 3.5),
            Block.box(12, 1.5, 1.5, 14, 3.5, 3.5),
            Block.box(12, 14.5, 2.5, 14, 15.5, 13.5),
            Block.box(12, 0.5, 2.5, 14, 1.5, 13.5),
            Block.box(0, 3, 7, 2, 5, 9),
            Block.box(12, 2.5, 14.5, 14, 13.5, 15.5),
            Block.box(3, 2.5, 0.5, 5, 13.5, 1.5),
            Block.box(3, 12.5, 12.5, 5, 14.5, 14.5),
            Block.box(3, 1.5, 12.5, 5, 3.5, 14.5),
            Block.box(3, 12.5, 1.5, 5, 14.5, 3.5),
            Block.box(3, 1.5, 1.5, 5, 3.5, 3.5),
            Block.box(3, 14.5, 2.5, 5, 15.5, 13.5),
            Block.box(3, 0.5, 2.5, 5, 1.5, 13.5),
            Block.box(9, 15, 7, 11, 16, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
