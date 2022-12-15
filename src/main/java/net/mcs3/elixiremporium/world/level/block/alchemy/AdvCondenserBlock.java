package net.mcs3.elixiremporium.world.level.block.alchemy;

import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.stream.Stream;

public class AdvCondenserBlock extends BaseEntityBlock implements EntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;

    public AdvCondenserBlock() {
        super(Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5f).sound(SoundType.STONE).lightLevel(blockState -> blockState.getValue(BlockStateProperties.LIT) ? 13 : 0).noOcclusion());
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH)).setValue(LIT, false).setValue(BOTTOM, true));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        if (state.getValue(BOTTOM))
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
        }else if (!state.getValue(BOTTOM)) {
            switch (state.getValue(FACING)) {
                case NORTH:
                    return SHAPE_TOP_N;
                case EAST:
                    return SHAPE_TOP_E;
                case SOUTH:
                    return SHAPE_TOP_S;
                case WEST:
                    return SHAPE_TOP_W;
                default:
                    return SHAPE_TOP_N;
            }
        }
            return SHAPE_N;
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
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        if (blockPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockPos.above()).canBeReplaced(context)) {
            return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
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
        builder.add(FACING, LIT, BOTTOM);
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        ItemStack itemStack = player.getItemInHand(hand);
        AdvCondenserBlockEntity blockEntity = (AdvCondenserBlockEntity) level.getBlockEntity(pos);
        AdvCondenserBlockEntity blockEntityBelow = (AdvCondenserBlockEntity) level.getBlockEntity(pos.below());

        if(!level.isClientSide) {
            if(hasRetorts(state, level, pos)) {
                if (state.getValue(BOTTOM) && blockEntity.getBlockState().getBlock() instanceof AdvCondenserBlock) {
                    if (player.getMainHandItem().is(Items.WATER_BUCKET) && !((AdvCondenserBlockEntity) level.getBlockEntity(pos)).atCapacity(blockEntity)) {
                        ((AdvCondenserBlockEntity) level.getBlockEntity(pos)).onPlayerAddFluid();
                        level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
                        player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.BUCKET)));
                    } else {
                        if (player.getMainHandItem().is(Items.BUCKET) && blockEntity.canPullFluid(blockEntity)) {
                            ((AdvCondenserBlockEntity) level.getBlockEntity(pos)).onPlayerRemoveFluid(blockEntity);
                            level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                            player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.WATER_BUCKET)));
                        } else {
                            player.openMenu(blockEntity);
                        }
                    }

                } else if (!state.getValue(BOTTOM) && level.getBlockState(pos).getBlock() instanceof AdvCondenserBlock) {
                    if (player.getMainHandItem().is(Items.WATER_BUCKET) && !((AdvCondenserBlockEntity) level.getBlockEntity(pos.below())).atCapacity(blockEntityBelow)) {
                        ((AdvCondenserBlockEntity) level.getBlockEntity(pos.below())).onPlayerAddFluid();
                        level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
                        player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.BUCKET)));
                    } else {
                        if (player.getMainHandItem().is(Items.BUCKET) && blockEntityBelow.canPullFluid(blockEntityBelow)) {
                            ((AdvCondenserBlockEntity) level.getBlockEntity(pos.below())).onPlayerRemoveFluid(blockEntityBelow);
                            level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                            player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.WATER_BUCKET)));
                        } else {
                            player.openMenu(blockEntityBelow);
                        }
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof AdvCondenserBlockEntity && blockEntity.getBlockState().getValue(BOTTOM)) {
                Containers.dropContents(level, pos, (Container)blockEntity);  //TODO update this for the "BOTTOM" block only  && state.getValue(BOTTOM)
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    public static boolean hasRetorts(BlockState state, Level level, BlockPos pos) {
        BlockPos blockPos;
        if (state.getBlock() != ModBlocks.ADV_CONDENSER) {
            return false;
        }

        if(!state.getValue(BOTTOM)) {
            blockPos = pos.below();
        } else blockPos = pos;

        switch (state.getValue(FACING)) {
            case NORTH:
                if(level.getBlockState(blockPos.east()).getBlock() != ModBlocks.ADV_RETORT || level.getBlockState(blockPos.south()).getBlock() != ModBlocks.ADV_RETORT || level.getBlockState(blockPos.west()).getBlock() != ModBlocks.ADV_RETORT) {
                    return false;
                }

                if(level.getBlockState(blockPos.east()).getValue(FACING) != Direction.WEST || level.getBlockState(blockPos.south()).getValue(FACING) != Direction.NORTH || level.getBlockState(blockPos.west()).getValue(FACING) != Direction.EAST) {
                    return false;
                }
                break;
            case EAST:
                if(level.getBlockState(blockPos.north()).getBlock() != ModBlocks.ADV_RETORT || level.getBlockState(blockPos.west()).getBlock() != ModBlocks.ADV_RETORT || level.getBlockState(blockPos.south()).getBlock() != ModBlocks.ADV_RETORT) {
                    return false;
                }
                if(level.getBlockState(blockPos.north()).getValue(FACING) != Direction.SOUTH || level.getBlockState(blockPos.west()).getValue(FACING) != Direction.EAST || level.getBlockState(blockPos.south()).getValue(FACING) != Direction.NORTH) {
                    return false;
                }
                break;
            case SOUTH:
                if(level.getBlockState(blockPos.east()).getBlock() != ModBlocks.ADV_RETORT || level.getBlockState(blockPos.north()).getBlock() != ModBlocks.ADV_RETORT || level.getBlockState(blockPos.west()).getBlock() != ModBlocks.ADV_RETORT) {
                    return false;
                }
                if(level.getBlockState(blockPos.east()).getValue(FACING) != Direction.WEST || level.getBlockState(blockPos.north()).getValue(FACING) != Direction.SOUTH || level.getBlockState(blockPos.west()).getValue(FACING) != Direction.EAST) {
                    return false;
                }
                break;
            case WEST:
                if(level.getBlockState(blockPos.north()).getBlock() != ModBlocks.ADV_RETORT || level.getBlockState(blockPos.east()).getBlock() != ModBlocks.ADV_RETORT || level.getBlockState(blockPos.south()).getBlock() != ModBlocks.ADV_RETORT) {
                    return false;
                }
                if(level.getBlockState(blockPos.north()).getValue(FACING) != Direction.SOUTH || level.getBlockState(blockPos.east()).getValue(FACING) != Direction.WEST || level.getBlockState(blockPos.south()).getValue(FACING) != Direction.NORTH) {
                    return false;
                }
                break;
        }
        return true;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, ModBlockEntityTypes.ADV_CONDENSER_CONTAINER, AdvCondenserBlockEntity::serverTick);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        if(state.getValue(BOTTOM))
        {
            return new AdvCondenserBlockEntity(pos, state);
        }
        return null;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        if (!state.getValue(LIT))
        {
            if(level.getBlockState(pos.below()).getBlock() instanceof AdvCondenserBlock && level.getBlockState(pos.below()).getValue(LIT))
            {
                double d = (double)pos.getX() + 0.5;
                double e = pos.getY();
                double f = (double)pos.getZ() + 0.5;

                level.addParticle(ParticleTypes.SMOKE, d, e + 0.9, f, 0.0, 0.0, 0.0);
            }
            else return;

            if(level.getBlockState(pos.below()).getValue(LIT) && !level.getBlockState(pos).getValue(BOTTOM)) {
                level.setBlock(pos, state.setValue(LIT, true), 3);
            }
            if(!level.getBlockState(pos.below()).getValue(LIT) && !level.getBlockState(pos).getValue(BOTTOM)) {
                level.setBlock(pos, state.setValue(LIT, false), 3);
            }

        }
        double d = (double)pos.getX() + 0.5;
        double e = pos.getY();
        double f = (double)pos.getZ() + 0.5;
        if (random.nextDouble() < 0.1) {
            level.playLocalSound(d, e, f, SoundEvents.BLASTFURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0f, 1.0f, false);
        }
        Direction direction = state.getValue(FACING);
        Direction.Axis axis = direction.getAxis();
        double g = 0.52;
        double h = random.nextDouble() * 0.6 - 0.3;
        double i = axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52 : h;
        double j = random.nextDouble() * 16.0 / 16.0;
        double k = axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52 : h;
        level.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, 0.0, 0.0, 0.0);
        level.addParticle(ParticleTypes.FLAME, d + i, e + j, f + k, 0.0, 0.0, 0.0);
//TODO UPDATE THIS
        if(direction == Direction.NORTH) {
            level.addParticle(ParticleTypes.SMOKE, d - 1.0D, e + 0.95D, f, 0, 0.125, 0);
            level.addParticle(ParticleTypes.SMOKE, d + 1.0D, e + 0.95D, f, 0, 0.125, 0);
            level.addParticle(ParticleTypes.SMOKE, d, e + 0.95D, f + 1.0D, 0, 0.125, 0);
        } else if (direction == Direction.EAST) {
            level.addParticle(ParticleTypes.SMOKE, d, e + 0.95D, f + 1.0D, 0, 0.125, 0);
            level.addParticle(ParticleTypes.SMOKE, d, e + 0.95D, f - 1.0D, 0, 0.125, 0);
            level.addParticle(ParticleTypes.SMOKE, d - 1.0D, e + 0.95D, f, 0, 0.125, 0);
        } else if(direction == Direction.SOUTH) {
            level.addParticle(ParticleTypes.SMOKE, d - 1.0D, e + 0.95D, f, 0, 0.125, 0);
            level.addParticle(ParticleTypes.SMOKE, d + 1.0D, e + 0.95D, f, 0, 0.125, 0);
            level.addParticle(ParticleTypes.SMOKE, d, e + 0.95D, f - 1.0D, 0, 0.125, 0);
        }else if (direction == Direction.WEST) {
            level.addParticle(ParticleTypes.SMOKE, d, e + 0.95D, f + 1.0D, 0, 0.125, 0);
            level.addParticle(ParticleTypes.SMOKE, d, e + 0.95D, f - 1.0D, 0, 0.125, 0);
            level.addParticle(ParticleTypes.SMOKE, d + 1.0D, e + 0.95D, f, 0, 0.125, 0);
        }
    }


    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(1, 4, 1, 15, 7, 15),
            Block.box(0, 7, 0, 16, 12, 16),
            Block.box(7, 15, 2, 9, 16, 15),
            Block.box(0, 5, 6, 1, 7, 10),
            Block.box(15, 5, 6, 16, 7, 10),
            Block.box(6, 5, 14, 10, 7, 16),
            Block.box(0, 4, 12, 4, 7, 16),
            Block.box(0, 4, 0, 4, 7, 4),
            Block.box(0, 12, 0, 4, 16, 4),
            Block.box(0, 12, 12, 4, 16, 16),
            Block.box(12, 4, 12, 16, 7, 16),
            Block.box(12, 4, 0, 16, 7, 4),
            Block.box(12, 12, 0, 16, 16, 4),
            Block.box(12, 12, 12, 16, 16, 16),
            Block.box(9, 15, 1, 15, 16, 15),
            Block.box(1, 12, 1, 15, 15, 15),
            Block.box(1, 15, 1, 7, 16, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(1, 4, 1, 15, 7, 15),
            Block.box(0, 7, 0, 16, 12, 16),
            Block.box(1, 15, 7, 14, 16, 9),
            Block.box(6, 5, 0, 10, 7, 1),
            Block.box(6, 5, 15, 10, 7, 16),
            Block.box(0, 5, 6, 2, 7, 10),
            Block.box(0, 4, 0, 4, 7, 4),
            Block.box(12, 4, 0, 16, 7, 4),
            Block.box(12, 12, 0, 16, 16, 4),
            Block.box(0, 12, 0, 4, 16, 4),
            Block.box(0, 4, 12, 4, 7, 16),
            Block.box(12, 4, 12, 16, 7, 16),
            Block.box(12, 12, 12, 16, 16, 16),
            Block.box(0, 12, 12, 4, 16, 16),
            Block.box(1, 15, 9, 15, 16, 15),
            Block.box(1, 12, 1, 15, 15, 15),
            Block.box(1, 15, 1, 15, 16, 7)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(1, 4, 1, 15, 7, 15),
            Block.box(0, 7, 0, 16, 12, 16),
            Block.box(7, 15, 1, 9, 16, 14),
            Block.box(15, 5, 6, 16, 7, 10),
            Block.box(0, 5, 6, 1, 7, 10),
            Block.box(6, 5, 0, 10, 7, 2),
            Block.box(12, 4, 0, 16, 7, 4),
            Block.box(12, 4, 12, 16, 7, 16),
            Block.box(12, 12, 12, 16, 16, 16),
            Block.box(12, 12, 0, 16, 16, 4),
            Block.box(0, 4, 0, 4, 7, 4),
            Block.box(0, 4, 12, 4, 7, 16),
            Block.box(0, 12, 12, 4, 16, 16),
            Block.box(0, 12, 0, 4, 16, 4),
            Block.box(1, 15, 1, 7, 16, 15),
            Block.box(1, 12, 1, 15, 15, 15),
            Block.box(9, 15, 1, 15, 16, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(1, 4, 1, 15, 7, 15),
            Block.box(0, 7, 0, 16, 12, 16),
            Block.box(2, 15, 7, 15, 16, 9),
            Block.box(6, 5, 15, 10, 7, 16),
            Block.box(6, 5, 0, 10, 7, 1),
            Block.box(14, 5, 6, 16, 7, 10),
            Block.box(12, 4, 12, 16, 7, 16),
            Block.box(0, 4, 12, 4, 7, 16),
            Block.box(0, 12, 12, 4, 16, 16),
            Block.box(12, 12, 12, 16, 16, 16),
            Block.box(12, 4, 0, 16, 7, 4),
            Block.box(0, 4, 0, 4, 7, 4),
            Block.box(0, 12, 0, 4, 16, 4),
            Block.box(12, 12, 0, 16, 16, 4),
            Block.box(1, 15, 1, 15, 16, 7),
            Block.box(1, 12, 1, 15, 15, 15),
            Block.box(1, 15, 9, 15, 16, 15)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_TOP_N = Stream.of(
            Block.box(7, 3, 2, 9, 4, 15),
            Block.box(6, 0, 2, 10, 3, 15),
            Block.box(4, 10, 4, 12, 12, 12),
            Block.box(0, 7, 0, 16, 10, 16),
            Block.box(5, 12, 5, 11, 13, 11),
            Block.box(3, 12, 5, 5, 14, 11),
            Block.box(3, 12, 11, 13, 14, 13),
            Block.box(11, 12, 5, 13, 14, 11),
            Block.box(3, 12, 3, 13, 14, 5),
            Block.box(0, 0, 14, 2, 3, 16),
            Block.box(0, 0, 0, 2, 3, 2),
            Block.box(0, 3, 12, 4, 7, 16),
            Block.box(0, 3, 0, 4, 7, 4),
            Block.box(1, 0, 1, 6, 3, 15),
            Block.box(10, 0, 1, 15, 3, 15),
            Block.box(1, 3, 1, 7, 4, 15),
            Block.box(9, 3, 1, 15, 4, 15),
            Block.box(1, 4, 1, 15, 7, 15),
            Block.box(14, 0, 14, 16, 3, 16),
            Block.box(14, 0, 0, 16, 3, 2),
            Block.box(12, 3, 12, 16, 7, 16),
            Block.box(12, 3, 0, 16, 7, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_TOP_E = Stream.of(
            Block.box(1, 3, 7, 14, 4, 9),
            Block.box(1, 0, 6, 14, 3, 10),
            Block.box(4, 10, 4, 12, 12, 12),
            Block.box(0, 7, 0, 16, 10, 16),
            Block.box(5, 12, 5, 11, 13, 11),
            Block.box(5, 12, 3, 11, 14, 5),
            Block.box(3, 12, 3, 5, 14, 13),
            Block.box(5, 12, 11, 11, 14, 13),
            Block.box(11, 12, 3, 13, 14, 13),
            Block.box(0, 0, 0, 2, 3, 2),
            Block.box(14, 0, 0, 16, 3, 2),
            Block.box(0, 3, 0, 4, 7, 4),
            Block.box(12, 3, 0, 16, 7, 4),
            Block.box(1, 0, 1, 15, 3, 6),
            Block.box(1, 0, 10, 15, 3, 15),
            Block.box(1, 3, 1, 15, 4, 7),
            Block.box(1, 3, 9, 15, 4, 15),
            Block.box(1, 4, 1, 15, 7, 15),
            Block.box(0, 0, 14, 2, 3, 16),
            Block.box(14, 0, 14, 16, 3, 16),
            Block.box(0, 3, 12, 4, 7, 16),
            Block.box(12, 3, 12, 16, 7, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_TOP_S = Stream.of(
            Block.box(7, 3, 1, 9, 4, 14),
            Block.box(6, 0, 1, 10, 3, 14),
            Block.box(4, 10, 4, 12, 12, 12),
            Block.box(0, 7, 0, 16, 10, 16),
            Block.box(5, 12, 5, 11, 13, 11),
            Block.box(11, 12, 5, 13, 14, 11),
            Block.box(3, 12, 3, 13, 14, 5),
            Block.box(3, 12, 5, 5, 14, 11),
            Block.box(3, 12, 11, 13, 14, 13),
            Block.box(14, 0, 0, 16, 3, 2),
            Block.box(14, 0, 14, 16, 3, 16),
            Block.box(12, 3, 0, 16, 7, 4),
            Block.box(12, 3, 12, 16, 7, 16),
            Block.box(10, 0, 1, 15, 3, 15),
            Block.box(1, 0, 1, 6, 3, 15),
            Block.box(9, 3, 1, 15, 4, 15),
            Block.box(1, 3, 1, 7, 4, 15),
            Block.box(1, 4, 1, 15, 7, 15),
            Block.box(0, 0, 0, 2, 3, 2),
            Block.box(0, 0, 14, 2, 3, 16),
            Block.box(0, 3, 0, 4, 7, 4),
            Block.box(0, 3, 12, 4, 7, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_TOP_W = Stream.of(
            Block.box(7, 3, 1, 9, 4, 14),
            Block.box(6, 0, 1, 10, 3, 14),
            Block.box(4, 10, 4, 12, 12, 12),
            Block.box(0, 7, 0, 16, 10, 16),
            Block.box(5, 12, 5, 11, 13, 11),
            Block.box(11, 12, 5, 13, 14, 11),
            Block.box(3, 12, 3, 13, 14, 5),
            Block.box(3, 12, 5, 5, 14, 11),
            Block.box(3, 12, 11, 13, 14, 13),
            Block.box(14, 0, 0, 16, 3, 2),
            Block.box(14, 0, 14, 16, 3, 16),
            Block.box(12, 3, 0, 16, 7, 4),
            Block.box(12, 3, 12, 16, 7, 16),
            Block.box(10, 0, 1, 15, 3, 15),
            Block.box(1, 0, 1, 6, 3, 15),
            Block.box(9, 3, 1, 15, 4, 15),
            Block.box(1, 3, 1, 7, 4, 15),
            Block.box(1, 4, 1, 15, 7, 15),
            Block.box(0, 0, 0, 2, 3, 2),
            Block.box(0, 0, 14, 2, 3, 16),
            Block.box(0, 3, 0, 4, 7, 4),
            Block.box(0, 3, 12, 4, 7, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
