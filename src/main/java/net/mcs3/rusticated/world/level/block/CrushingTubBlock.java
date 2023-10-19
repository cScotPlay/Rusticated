package net.mcs3.rusticated.world.level.block;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.world.level.block.entity.CrushingTubBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class CrushingTubBlock extends BaseEntityBlock implements EntityBlock {

    public static final ResourceLocation CONTENTS;

    public CrushingTubBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                .requiresCorrectToolForDrops()
                .strength(1.5f, 4.2f)
                .sound(SoundType.WOOD));
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
        CrushingTubBlockEntity blockEntity = (CrushingTubBlockEntity) level.getBlockEntity(pos);

//        if(!level.isClientSide) {
            if(player.isCrouching() && player.getMainHandItem().isEmpty() && blockEntity.fluidStorage.amount != 0) { //Remove All Fluids
                blockEntity.emptyTub(blockEntity);
                blockEntity.update();
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            if (player.getMainHandItem().isEmpty() && !blockEntity.getItem(0).isEmpty() && !player.isCrouching()) {  //Pulls Items from tub
                player.getInventory().add(new ItemStack(blockEntity.getItem(0).getItem(), blockEntity.getItem(0).getCount()));
//                blockEntity.removeItem(0, blockEntity.getItem(0).getCount());
                blockEntity.removeItemNoUpdate(0);
                blockEntity.update();
//                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            if(!player.getMainHandItem().isEmpty() && !itemStack.is(Items.BUCKET) || !itemStack.is(Items.GLASS_BOTTLE)) {
                if(blockEntity.canInsertItem(blockEntity, itemStack)) {
                    int itemCount = player.getItemInHand(hand).getCount();
                    ItemStack addItems = itemStack.copy();
                    blockEntity.setItem(0, addItems);
                    itemStack.shrink(itemCount);
//                    return InteractionResult.sidedSuccess(level.isClientSide);
                }
            }
            if(itemStack.is(Items.BUCKET) || itemStack.is(Items.GLASS_BOTTLE)) {
                blockEntity.givePlayerFluid(blockEntity, player, hand, itemStack);
//                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            blockEntity.update();
            level.blockEntityChanged(pos);
//    }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float f) {
        CrushingTubBlockEntity blockEntity = (CrushingTubBlockEntity) level.getBlockEntity(pos);

        if(!level.isClientSide && entity instanceof Player) {
            if(blockEntity instanceof CrushingTubBlockEntity) {
                blockEntity.crushItems(blockEntity);
            }
        }
        super.fallOn(level, state, pos, entity, f);
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

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        BlockEntity blockEntity = (BlockEntity)params.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof CrushingTubBlockEntity) {
            CrushingTubBlockEntity crushingBlockEntity = (CrushingTubBlockEntity)blockEntity;
            params = params.withDynamicDrop(CONTENTS, (consumer) -> {
                for(int i = 0; i < crushingBlockEntity.getContainerSize(); ++i) {
                    consumer.accept(crushingBlockEntity.getItem(i));
                }

            });
        }
        return super.getDrops(state, params);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CrushingTubBlockEntity(pos, state);
    }

    static {
        CONTENTS = new ResourceLocation(Rusticated.MOD_ID,"contents");
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(14, 6, 2, 16, 8, 14),
            Block.box(1.5, 0, 1.5, 14.5, 1, 14.5),
            Block.box(0.5, 0, 0.5, 15.5, 9, 1.5),
            Block.box(0.5, 0, 14.5, 15.5, 9, 15.5),
            Block.box(0.5, 0, 1.5, 1.5, 9, 14.5),
            Block.box(14.5, 0, 1.5, 15.5, 9, 14.5),
            Block.box(0, 6, 0, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
