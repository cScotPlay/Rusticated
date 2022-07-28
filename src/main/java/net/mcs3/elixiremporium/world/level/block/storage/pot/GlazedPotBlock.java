package net.mcs3.elixiremporium.world.level.block.storage.pot;

import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.item.PlayerInventoryStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageUtil;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.mcs3.elixiremporium.world.level.block.storage.AbstractStorageBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class GlazedPotBlock extends AbstractStorageBlock implements EntityBlock
{
    protected static final VoxelShape JAR_AABB;
    protected static final VoxelShape JAR_SHAPE_1;
    protected static final VoxelShape JAR_SHAPE_2;

    public GlazedPotBlock() {
        super(Properties.of(Material.CLAY)
                .noOcclusion()
                .strength(2.0f, 3.0f));
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        Block block = state.getBlock();
        if(block == ModBlocks.GLAZED_POT_0)
        {
            return new PotEntityBlock(ModBlockEntityTypes.GLAZED_POT_0_CONTAINER, pos, state, 16);
        }
        if(block == ModBlocks.GLAZED_POT_1)
        {
            return new PotEntityBlock(ModBlockEntityTypes.GLAZED_POT_1_CONTAINER, pos, state, 16);
        }
        if(block == ModBlocks.GLAZED_POT_2)
        {
            return new PotEntityBlock(ModBlockEntityTypes.GLAZED_POT_2_CONTAINER, pos, state, 16);
        }
        if(block == ModBlocks.GLAZED_POT_3)
        {
            return new PotEntityBlock(ModBlockEntityTypes.GLAZED_POT_3_CONTAINER, pos, state, 16);
        }
        if(block == ModBlocks.GLAZED_POT_4)
        {
            return new PotEntityBlock(ModBlockEntityTypes.GLAZED_POT_4_CONTAINER, pos, state, 16);
        }
        return null;//new PotEntityBlock(ModBlockEntityTypes.GLAZED_POT_0_CONTAINER, pos, state, 16);
    }

    static {
        JAR_SHAPE_1 = Shapes.or(box(3.0, 0.0, 3.0, 13.0, 2.0, 13.0), box(1.0, 2.0, 1.0, 15.0, 12.0, 15.0));
        JAR_SHAPE_2 = Shapes.or(box(4.0, 12.0, 4.0, 12.0, 14.0, 12.0), box(2.0, 14.0, 2.0, 14.0, 16.0, 14.0));
        JAR_AABB = Shapes.or(JAR_SHAPE_1, JAR_SHAPE_2);

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.getBlockEntity(hitResult.getBlockPos()) instanceof PotEntityBlock potEntity && hitResult.getDirection().getAxis().isVertical()) {
                if (!player.isShiftKeyDown()) {
                    if (StorageUtil.move(PlayerInventoryStorage.of(player).getSlots().get(player.getInventory().selected), potEntity,
                            (itemVariant) -> true, Long.MAX_VALUE, null) > 0) {
                        return InteractionResult.sidedSuccess(world.isClientSide);
                    }
                } else {
                    ItemVariant currentInHand = ItemVariant.of(player.getMainHandItem());
                    if (StorageUtil.move(PlayerInventoryStorage.of(player), potEntity, (itemVariant) -> itemVariant.equals(currentInHand),
                            Long.MAX_VALUE, null) > 0) {
                        return InteractionResult.sidedSuccess(world.isClientSide);
                    }
                }
            }
            return InteractionResult.PASS;
        });

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (world.getBlockEntity(pos) instanceof PotEntityBlock potEntity && direction.getAxis().isVertical()) {
                if (!potEntity.isEmpty()) {
                    try (Transaction transaction = Transaction.openOuter()) {
                        ItemVariant extractedResource = potEntity.getResource();

                        long extracted = potEntity.extract(potEntity.getResource(),
                                player.isShiftKeyDown() ? 1 : potEntity.getResource().getItem().getMaxStackSize(),
                                transaction);

                        PlayerInventoryStorage.of(player).offerOrDrop(extractedResource, extracted, transaction);

                        transaction.commit();
                        if (world.isClientSide()) {
                            updateDestroyDelay();
                        }
                    }
                    return InteractionResult.sidedSuccess(world.isClientSide);
                }
            }
            return InteractionResult.PASS;
        });
    }

    private static void updateDestroyDelay() {
        // Add a 5 tick delay like vanilla.
        Minecraft.getInstance().gameMode.destroyDelay = 5;
    }
}
