package net.mcs3.rusticated.world.level.block.storage.barrel;

import net.mcs3.rusticated.Rusticated;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.stream.Stream;

public class BarrelBlock extends BaseEntityBlock implements EntityBlock {
//    public static final ResourceLocation CONTENTS;

    public BarrelBlock() {
        super(Properties.of(Material.WOOD)
                .noOcclusion()
                .strength(2.0f, 3.0f)
                .sound(SoundType.WOOD));

    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return SHAPE_BARREL;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof BarrelEntityBlock) {
                player.openMenu((BarrelEntityBlock)blockEntity);
            }

            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BarrelEntityBlock(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
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
    @SuppressWarnings("deprecation")
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    @SuppressWarnings("deprecation")
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    private static final VoxelShape SHAPE_BARREL = Stream.of(
            Block.box(3, 2, 14, 13, 14, 15),
            Block.box(2.75, 14, 14, 13.25, 16, 15.25),
            Block.box(2.75, 0, 14, 13.25, 2, 15.25),
            Block.box(2, 2, 13, 3, 14, 14),
            Block.box(2.75, 11, 15, 13.25, 12, 15.25),
            Block.box(2, 11, 14, 3.25, 12, 14.25),
            Block.box(2.75, 11, 14, 3, 12, 15),
            Block.box(13, 11, 14, 13.25, 12, 15),
            Block.box(1.75, 11, 12.75, 2, 12, 14),
            Block.box(1.75, 0, 13, 3, 2, 14.25),
            Block.box(1.75, 14, 13, 3, 16, 14.25),
            Block.box(3, 2, 1, 13, 14, 2),
            Block.box(2.75, 14, 0.75, 13.25, 16, 2),
            Block.box(2.75, 0, 0.75, 13.25, 2, 2),
            Block.box(13, 2, 2, 14, 14, 3),
            Block.box(2.75, 11, 0.75, 13.25, 12, 1),
            Block.box(12.75, 11, 1.75, 14, 12, 2),
            Block.box(13, 11, 1, 13.25, 12, 2),
            Block.box(2.75, 11, 1, 3, 12, 2),
            Block.box(14, 11, 2, 14.25, 12, 3.25),
            Block.box(13, 0, 1.75, 14.25, 2, 3),
            Block.box(13, 14, 1.75, 14.25, 16, 3),
            Block.box(1, 2, 3, 2, 14, 13),
            Block.box(0.75, 14, 2.75, 2, 16, 13.25),
            Block.box(0.75, 0, 2.75, 2, 2, 13.25),
            Block.box(2, 2, 2, 3, 14, 3),
            Block.box(0.75, 11, 2.75, 1, 12, 13.25),
            Block.box(1.75, 11, 2, 2, 12, 3.25),
            Block.box(1, 11, 2.75, 2, 12, 3),
            Block.box(1, 11, 13, 2, 12, 13.25),
            Block.box(2, 11, 1.75, 3.25, 12, 2),
            Block.box(1.75, 0, 1.75, 3, 2, 3),
            Block.box(1.75, 14, 1.75, 3, 16, 3),
            Block.box(14, 2, 3, 15, 14, 13),
            Block.box(14, 14, 2.75, 15.25, 16, 13.25),
            Block.box(14, 0, 2.75, 15.25, 2, 13.25),
            Block.box(13, 2, 13, 14, 14, 14),
            Block.box(15, 11, 2.75, 15.25, 12, 13.25),
            Block.box(14, 11, 12.75, 14.25, 12, 14),
            Block.box(14, 11, 13, 15, 12, 13.25),
            Block.box(14, 11, 2.75, 15, 12, 3),
            Block.box(12.75, 11, 14, 14, 12, 14.25),
            Block.box(13, 0, 13, 14.25, 2, 14.25),
            Block.box(13, 14, 13, 14.25, 16, 14.25),
            Block.box(2, 14, 2, 14, 15, 14),
            Block.box(2, 1, 2, 14, 2, 14)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
