package net.mcs3.rusticated.world.level.block;

import net.fabricmc.fabric.mixin.transfer.BucketItemAccessor;
import net.mcs3.rusticated.world.level.block.entity.EvaporatingBasinBlockEntity;
import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class EvaporatingBasinBlock extends BaseEntityBlock implements EntityBlock {


    public EvaporatingBasinBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).mapColor(MapColor.COLOR_ORANGE)
                .requiresCorrectToolForDrops()
                .strength(1.25f, 4.2f)
                .sound(SoundType.STONE));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        EvaporatingBasinBlockEntity blockEntity = (EvaporatingBasinBlockEntity) level.getBlockEntity(pos);

//        if(!level.isClientSide) {
            if(player.isCrouching() && player.getMainHandItem().isEmpty() && blockEntity.fluidStorage.amount != 0) {
                blockEntity.emptyBasin(blockEntity);
            }
            if (player.getMainHandItem().isEmpty() && !blockEntity.getItem(0).isEmpty() && !player.isCrouching()) {
                player.getInventory().add(new ItemStack(blockEntity.getItem(0).getItem(), blockEntity.getItem(0).getCount()));
                blockEntity.removeItemNoUpdate(0);
                blockEntity.update();
                //return InteractionResult.sidedSuccess(level.isClientSide);
            }
            if (blockEntity.getBlockState().getBlock() instanceof EvaporatingBasinBlock && itemStack.getItem() instanceof BucketItem bucketItem) {
                if(itemStack.getItem() == Items.BUCKET && blockEntity.fluidStorage.amount != 0 && blockEntity.canPullFluid(blockEntity)) {
                    Fluid entityFluid = blockEntity.fluidStorage.variant.getFluid();
                    blockEntity.onPlayerRemoveFluid(blockEntity, entityFluid);
                    level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                    player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(entityFluid.getBucket())));
                    blockEntity.update();
                    //return InteractionResult.sidedSuccess(level.isClientSide);

                } else if (blockEntity.fluidStorage.amount != blockEntity.fluidStorage.getCapacity() && itemStack.getItem() != Items.BUCKET){
                    Fluid bucketFluid = ((BucketItemAccessor) bucketItem).fabric_getFluid();
                    blockEntity.onPlayerAddFluid(bucketFluid);
                    level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
                    player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.BUCKET)));
                    blockEntity.update();
                    //return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
//        }
        blockEntity.update();
        level.blockEntityChanged(pos);
        return InteractionResult.SUCCESS;
        }

    @Override
    @SuppressWarnings("deprecation")
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof EvaporatingBasinBlockEntity) {
                Containers.dropContents(level, pos, (Container)blockEntity);
                level.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EvaporatingBasinBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, ModBlockEntityTypes.EVAPORATING_BASIN_CONTAINER, EvaporatingBasinBlockEntity::serverTick);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(13, 1, 2, 14, 2, 3),
            Block.box(3, 0, 3, 13, 1, 13),
            Block.box(3, 1, 1, 13, 2, 3),
            Block.box(3, 1, 13, 13, 2, 15),
            Block.box(1, 1, 3, 3, 2, 13),
            Block.box(13, 1, 3, 14, 2, 13),
            Block.box(1, 2, 1, 3, 4, 3),
            Block.box(13, 2, 1, 15, 4, 3),
            Block.box(1, 2, 13, 3, 4, 15),
            Block.box(13, 2, 13, 15, 4, 15),
            Block.box(3, 2, 0, 13, 4, 2),
            Block.box(3, 2, 14, 13, 4, 16),
            Block.box(0, 2, 3, 2, 4, 13),
            Block.box(14, 2, 3, 16, 4, 13),
            Block.box(2, 1, 2, 3, 2, 3),
            Block.box(2, 1, 13, 3, 2, 14),
            Block.box(13, 1, 13, 14, 2, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
