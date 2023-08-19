package net.mcs3.rusticated.world.level.block.storage;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.mixin.transfer.BucketItemAccessor;
import net.mcs3.rusticated.world.item.BoozeItem;
import net.mcs3.rusticated.world.item.FluidBottleItem;
import net.mcs3.rusticated.world.level.block.entity.LiquidBarrelBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
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

public class LiquidBarrelBlock extends BaseEntityBlock implements EntityBlock {

    public LiquidBarrelBlock() {
        super(Properties.of(Material.WOOD)
                .noOcclusion()
                .strength(2.0f, 3.0f)
                .sound(SoundType.WOOD));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LiquidBarrelBlockEntity(pos, state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return BARREL_AABB;
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
        LiquidBarrelBlockEntity blockEntity = (LiquidBarrelBlockEntity) level.getBlockEntity(pos);

        if(blockEntity.getBlockState().getBlock() instanceof LiquidBarrelBlock) {
            if(itemStack.is(Items.GLASS_BOTTLE) && blockEntity.fluidStorage.amount >= 250) {
                blockEntity.givePlayerFluid(blockEntity, player, hand, itemStack);
                blockEntity.removeFluidFromFluidStorage(blockEntity, 250);
                level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
                level.gameEvent(player, GameEvent.FLUID_PICKUP, pos);
                return InteractionResult.sidedSuccess(level.isClientSide);

            }
            else if (itemStack.getItem() instanceof FluidBottleItem || itemStack.getItem() instanceof BoozeItem) {
                if(!((LiquidBarrelBlockEntity) level.getBlockEntity(pos)).atCapacity(blockEntity) &&
                        (blockEntity.fluidStorage.getCapacity() - blockEntity.fluidStorage.amount) > 250) {
                    if(itemStack.getItem() instanceof FluidBottleItem) {
                        FluidBottleItem fluidBottleItem = (FluidBottleItem) itemStack.getItem();
                        Fluid fluid = fluidBottleItem.getFluidType();
                        blockEntity.transferFluidToFluidStorage(blockEntity, FluidVariant.of(fluid), 250);
                        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_EMPTY, SoundSource.NEUTRAL, 1.0F, 1.0F);
                        player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.GLASS_BOTTLE)));
                        return InteractionResult.sidedSuccess(level.isClientSide);

                    } else if (itemStack.getItem() instanceof BoozeItem) {
                        BoozeItem boozeItem = (BoozeItem) itemStack.getItem();
                        Fluid fluid = boozeItem.getFluidType();
                        blockEntity.transferFluidToFluidStorage(blockEntity, FluidVariant.of(fluid), 250);
                        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_EMPTY, SoundSource.NEUTRAL, 1.0F, 1.0F);
                        player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.GLASS_BOTTLE)));
                        return InteractionResult.sidedSuccess(level.isClientSide);
                    }
                }
            }
            else if(itemStack.is(Items.BUCKET) && blockEntity.fluidStorage.amount >= 1000) {
                blockEntity.removeFluidFromFluidStorage(blockEntity, 1000);
                level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.WATER_BUCKET)));
                return InteractionResult.sidedSuccess(level.isClientSide);

            } else if(itemStack.getItem() instanceof BucketItem && !itemStack.is(Items.BUCKET) &&
                    !((LiquidBarrelBlockEntity) level.getBlockEntity(pos)).atCapacity(blockEntity) &&
                    (blockEntity.fluidStorage.getCapacity() - blockEntity.fluidStorage.amount) >= 1000) {
                BucketItem bucketItem = (BucketItem) itemStack.getItem();
                Fluid fluid = ((BucketItemAccessor) bucketItem).fabric_getFluid();
                blockEntity.transferFluidToFluidStorage(blockEntity, FluidVariant.of(fluid), 1000);
                level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, new ItemStack(Items.BUCKET)));
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        blockEntity.update();
        level.blockEntityChanged(pos);
        return InteractionResult.PASS;
    }

    protected static boolean shouldHandlePrecipitation(Level level, Biome.Precipitation precipitation) {
        if (precipitation == Biome.Precipitation.RAIN) {
            return level.getRandom().nextFloat() < 0.05F;
        } else if (precipitation == Biome.Precipitation.SNOW) {
            return level.getRandom().nextFloat() < 0.1F;
        } else {
            return false;
        }
    }

    @Override
    public void handlePrecipitation(BlockState state, Level level, BlockPos pos, Biome.Precipitation precipitation) {
        if(shouldHandlePrecipitation(level, precipitation)) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof LiquidBarrelBlockEntity) {
                LiquidBarrelBlockEntity barrelEntity = (LiquidBarrelBlockEntity) blockEntity;
                if (barrelEntity.fluidStorage.variant == FluidVariant.of(Fluids.WATER) &&
                        !((LiquidBarrelBlockEntity) level.getBlockEntity(pos)).atCapacity(barrelEntity) &&
                        (barrelEntity.fluidStorage.getCapacity() - barrelEntity.fluidStorage.amount) > 1000) {
                    barrelEntity.transferFluidToFluidStorage(barrelEntity, FluidVariant.of(Fluids.WATER), 100);
                }
            }
        }
    }

    protected ItemStack getStack(BlockEntity entity) {
        var storageBlockEntity = (LiquidBarrelBlockEntity) entity;
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
    protected static final VoxelShape BARREL_AABB = Stream.of(
            Block.box(2, 1, 2, 14, 2, 14),
            Block.box(13.95, 2, 3, 15, 14, 13),
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
            Block.box(1, 2, 3, 2.05, 14, 13),
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
            Block.box(3, 2, 1, 13, 14, 2.05),
            Block.box(2.75, 14, 0.75, 13.25, 16, 2),
            Block.box(2.75, 0, 0.75, 13.25, 2, 2),
            Block.box(13, 2, 2, 14, 14, 3),
            Block.box(2.75, 11, 0.75, 13.25, 12, 1),
            Block.box(12.75, 11, 1.75, 14, 12, 2),
            Block.box(13, 11, 1, 13.25, 12, 2),
            Block.box(2.75, 11, 1, 3, 12, 2),
            Block.box(14, 11, 2, 14.25, 12, 3.25),
            Block.box(3, 2, 13.95, 13, 14, 15),
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
            Block.box(13, 0, 1.75, 14.25, 2, 3),
            Block.box(13, 14, 1.75, 14.25, 16, 3)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
}
