package net.mcs3.elixiremporium.world.level.block.storage.jar;

import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.mcs3.elixiremporium.world.level.block.storage.AbstractStorageBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class GlazedJarBlock extends AbstractStorageBlock implements EntityBlock
{
    protected static final VoxelShape JAR_AABB;

    public GlazedJarBlock() {
        super(Properties.of(Material.CLAY)
                .noOcclusion()
                .strength(2.0f, 3.0f));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new JarEntityBlock(ModBlockEntityTypes.JAR_CONTAINER, pos, state, 8);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return JAR_AABB;
    }

    @Override
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
        JAR_AABB = Block.box(1.0, 0.1, 1.0, 15.0, 15.0, 15);
    }
}
