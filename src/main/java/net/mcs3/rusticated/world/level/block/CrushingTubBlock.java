package net.mcs3.rusticated.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class CrushingTubBlock extends BaseEntityBlock implements EntityBlock {

    public CrushingTubBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD)
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }



    private static final VoxelShape SHAPE = Stream.of(
            Block.box(14, 6, 2, 16, 8, 14),
            Block.box(1.5, 0, 1.5, 14.5, 1, 14.5),
            Block.box(0.5, 0, 0.5, 15.5, 9, 1.5),
            Block.box(0.5, 0, 14.5, 15.5, 9, 15.5),
            Block.box(0.5, 0, 1.5, 1.5, 9, 14.5),
            Block.box(14.5, 0, 1.5, 15.5, 9, 14.5),
            Block.box(0, 1, 0, 16, 3, 2),
            Block.box(0, 6, 0, 16, 8, 2),
            Block.box(0, 1, 2, 2, 3, 14),
            Block.box(0, 6, 2, 2, 8, 14),
            Block.box(0, 1, 14, 16, 3, 16),
            Block.box(0, 6, 14, 16, 8, 16),
            Block.box(14, 1, 2, 16, 3, 14)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
