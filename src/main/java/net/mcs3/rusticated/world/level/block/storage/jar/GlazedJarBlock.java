package net.mcs3.rusticated.world.level.block.storage.jar;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.mixin.transfer.BucketItemAccessor;
import net.mcs3.rusticated.world.level.block.entity.GlaszedJarBlockEntity;
import net.mcs3.rusticated.world.level.block.entity.JarBlockEntity;
import net.mcs3.rusticated.world.level.block.entity.LiquidBarrelBlockEntity;
import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.mcs3.rusticated.world.level.block.storage.AbstractStorageBlock;
import net.mcs3.rusticated.world.level.block.storage.LiquidBarrelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GlazedJarBlock extends BaseEntityBlock implements EntityBlock {

    public GlazedJarBlock() {
        super(Properties.of(Material.CLAY)
                .noOcclusion()
                .strength(2.0f, 3.0f));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new GlaszedJarBlockEntity(pos, state);
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
        ItemStack itemStack = player.getItemInHand(hand);
        GlaszedJarBlockEntity blockEntity = (GlaszedJarBlockEntity) level.getBlockEntity(pos);

        if(blockEntity.getBlockState().getBlock() instanceof GlazedJarBlock) {
            if(itemStack.is(Items.BUCKET) && blockEntity.fluidStorage.amount >= 1000) {
                Item filledBucketItem = blockEntity.fluidStorage.variant.getFluid().getBucket();
                blockEntity.removeFluidFromFluidStorage(blockEntity);

                player.setItemInHand(hand, filledBucketItem.getDefaultInstance());
                return InteractionResult.sidedSuccess(level.isClientSide);

            } else if(itemStack.getItem() instanceof BucketItem && !itemStack.is(Items.BUCKET) &&
                    !((GlaszedJarBlockEntity) level.getBlockEntity(pos)).atCapacity(blockEntity) &&
                    (blockEntity.fluidStorage.getCapacity() - blockEntity.fluidStorage.amount) > 1000) {
                BucketItem bucketItem = (BucketItem) itemStack.getItem();
                Fluid fluid = ((BucketItemAccessor) bucketItem).fabric_getFluid();
                blockEntity.transferFluidToFluidStorage(blockEntity, FluidVariant.of(fluid), 1000);

                player.setItemInHand(hand, new ItemStack(Items.BUCKET));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        blockEntity.update();
        level.blockEntityChanged(pos);
        return InteractionResult.PASS;
    }

    protected ItemStack getStack(BlockEntity entity) {
        var storageBlockEntity = (GlaszedJarBlockEntity) entity;
        ItemStack stack = new ItemStack(this.asItem());
        if (!storageBlockEntity.isEmpty()) {
            CompoundTag tag = new CompoundTag();
            tag.put("BlockEntityTag", storageBlockEntity.saveWithoutMetadata());
            stack.setTag(tag);
        }
        return stack;
    }

    @SuppressWarnings("deprecation")
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        LootContext lootContext = builder.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
        return Arrays.asList(getStack(lootContext.getParamOrNull(LootContextParams.BLOCK_ENTITY)));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter world, BlockPos pos, BlockState state) {
        return getStack(world.getBlockEntity(pos));
    }

    protected static final VoxelShape JAR_AABB = Stream.of(
            Block.box(4, 15, 4, 12, 16, 12),
            Block.box(3, 0, 3, 13, 2, 13),
            Block.box(2, 2, 2, 14, 4, 14),
            Block.box(3, 10, 3, 13, 11, 13),
            Block.box(5, 12, 5, 11, 13, 11),
            Block.box(5, 14, 5, 11, 15, 11),
            Block.box(1, 4, 1, 15, 8, 15),
            Block.box(2, 8, 2, 14, 10, 14),
            Block.box(4, 11, 4, 12, 12, 12),
            Block.box(6, 13, 6, 10, 14, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
