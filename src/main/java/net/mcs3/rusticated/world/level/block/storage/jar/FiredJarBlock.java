package net.mcs3.rusticated.world.level.block.storage.jar;

import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.mcs3.rusticated.world.level.block.storage.AbstractStorageBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class FiredJarBlock extends AbstractStorageBlock implements EntityBlock
{
    protected static final VoxelShape JAR_AABB;
    protected static final VoxelShape JAR_SHAPE_1;
    protected static final VoxelShape JAR_SHAPE_2;
    protected static final VoxelShape JAR_SHAPE_3;
    protected static final VoxelShape JAR_SHAPE_4;

    public FiredJarBlock() {
        super(Properties.of(Material.CLAY)
                .noOcclusion()
                .strength(2.0f, 3.0f));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new JarEntityBlock(ModBlockEntityTypes.JAR_CONTAINER, pos, state, 4);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return JAR_AABB;
    }

    @Override
    @SuppressWarnings("deprecation")
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (((JarEntityBlock) level.getBlockEntity(pos)).onPlayerUse(player))
        {
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return super.use(state, level, pos, player, hand, hit);
    }

    static {
        JAR_SHAPE_1 = Shapes.or(box(3.0, 0.0, 3.0, 13.0, 2.0, 13.0), box(2.0, 2.0, 2.0, 14.0, 4.0, 14.0), box(1.0, 4.0, 1.0, 15.0, 8.0, 15.0));
        JAR_SHAPE_2 = Shapes.or(box(2.0, 8.0, 2.0, 14.0, 10.0, 14.0),box(3.0, 10.0, 3.0, 13.0, 11.0, 12.0), box(4.0, 11.0, 4.0, 12.0, 12.0, 12.0));
        JAR_SHAPE_3 = Shapes.or(box(5.0, 12.0, 5.0, 11.0, 13.0, 11.0),box(6.0, 13.0, 6.0, 10.0, 14.0, 10.0), box(5.0, 14.0, 5.0, 11.0, 15.0, 11.0));
        JAR_SHAPE_4 = Shapes.or(box(4.0, 15.0, 4.0, 12.0, 16.0, 12.0));
        JAR_AABB = Shapes.or(JAR_SHAPE_1, JAR_SHAPE_2, JAR_SHAPE_3, JAR_SHAPE_4);
    }
}
