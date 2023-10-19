package net.mcs3.rusticated.world.level.block.storage.pot;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class PotBlock extends Block implements EntityBlock {


    public static final ResourceLocation CONTENTS = new ResourceLocation(Rusticated.MOD_ID,"contents");
    protected static final VoxelShape POT_AABB;
    protected final int stackCapacity;

    public PotBlock(int stackCapacity) {
        super(Properties.of().mapColor(MapColor.CLAY)
                .noOcclusion()
                .strength(2.0f, 3.0f));
        this.stackCapacity = stackCapacity;
    }
    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return POT_AABB;
    }

    @Override
    public RenderShape getRenderShape(BlockState state)
    {
        return RenderShape.MODEL;
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PotBlockEntity(pos, state, stackCapacity);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (world.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        ItemStack item = player.getItemInHand(hand);
        if(hand == InteractionHand.OFF_HAND) {
            return InteractionResult.PASS;
        }

        if (!(world.getBlockEntity(hitResult.getBlockPos()) instanceof PotBlockEntity potBlockEntity)) {
            return InteractionResult.FAIL;
        }

        if (item.isEmpty()) {
            player.setItemInHand(hand, ItemStack.EMPTY);
        }

        potBlockEntity.insertItems(player, hand);
        world.blockEntityChanged(pos);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void attack(BlockState state, Level world, BlockPos pos, Player player) {
        interactTakeItems(state, world, pos, player);
    }

    public boolean interactTakeItems(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player) {
        if (!(state.getBlock() instanceof PotBlock))
            return false;

        PotBlockEntity potBlockEntity = (PotBlockEntity) level.getBlockEntity(blockPos);
        if (potBlockEntity == null)
            return false;

        ItemStack itemStack;

        if (player.isShiftKeyDown())
            itemStack = potBlockEntity.takeItemsFromContainer(potBlockEntity.getItems().get(0).getMaxStackSize());
        else
            itemStack = potBlockEntity.takeItemsFromContainer(1);

        if (!itemStack.isEmpty()) {
            if (!player.getInventory().add(itemStack)) {
                dropItemStack(level, blockPos.above(), player, itemStack);
                level.sendBlockUpdated(blockPos, state, state, Block.UPDATE_ALL);
            }
            else
                level.playSound(null, blockPos, SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, .2f, ((level.random.nextFloat() - level.random.nextFloat()) * .7f + 1) * 2);
        }
        level.sendBlockUpdated(blockPos, state, state, Block.UPDATE_ALL);
        return true;
    }

    private void dropItemStack (@NotNull Level world, @NotNull BlockPos pos, @NotNull Player player, @NotNull ItemStack stack) {
        ItemEntity entity = new ItemEntity(world, pos.getX() + .5f, pos.getY() + .3f, pos.getZ() + .5f, stack);
        Vec3 motion = entity.getDeltaMovement();
        entity.push(-motion.x, -motion.y, -motion.z);
        world.addFreshEntity(entity);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        PotBlockEntity blockEntity = (PotBlockEntity) world.getBlockEntity(pos);
        if (blockEntity == null)
            return;

        CompoundTag tag = stack.getTagElement("entity");
        if (tag != null) {
            blockEntity.load(tag);
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder params) {
        List<ItemStack> items = new ArrayList<>();
        items.add(getMainDrop(state, (PotBlockEntity)params.getOptionalParameter(LootContextParams.BLOCK_ENTITY)));
        return items;
    }

    protected ItemStack getMainDrop (BlockState state, PotBlockEntity tile) {
        ItemStack drop = new ItemStack(this);
        if (tile == null)
            return drop;

        CompoundTag data = drop.getTag();
        if (data == null)
            data = new CompoundTag();

        boolean hasContents = false;
        if (!tile.getItems().get(0).isEmpty()) {
            hasContents = true;
        }
        if (hasContents) {
            CompoundTag tiledata = tile.saveWithoutMetadata();

            data.put("entity", tiledata);
            drop.setTag(data);
        }
        return drop;
    }

    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        CompoundTag compoundTag = stack.getTag();
//        CompoundTag compoundTag = BlockItem.getBlockEntityData(stack);
        if (compoundTag != null) {
            if (compoundTag.contains("LootTable", 8)) {
                tooltip.add(Component.literal("???????"));
            }
            if (compoundTag.contains("Items", 9)) {
                NonNullList<ItemStack> nonNullList = NonNullList.withSize(1, ItemStack.EMPTY);
                ContainerHelper.loadAllItems(compoundTag, nonNullList);
                int i = 0;
                int j = 0;
                Iterator var9 = nonNullList.iterator();

                while (var9.hasNext()) {
                    ItemStack itemStack = (ItemStack) var9.next();
                    if (!itemStack.isEmpty()) {
                        ++j;
                        if (i <= 4) {
                            ++i;
                            MutableComponent mutableComponent = itemStack.getHoverName().copy();
                            mutableComponent.append(" x").append(String.valueOf(itemStack.getCount()));
                            tooltip.add(mutableComponent.withStyle(ChatFormatting.DARK_GRAY));
                        }
                    }
                }
                if (j - i > 0) {
                    tooltip.add(Component.translatable("tooltip.rusticated.storage_barrel.items", new Object[]{j - i}).withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.GRAY));
                }
            }
        }
    }

    static {
        POT_AABB = Stream.of(
                Block.box(3, 0, 3, 13, 2, 13),
                Block.box(1, 2, 1, 15, 12, 15),
                Block.box(4, 12, 4, 12, 14, 12),
                Block.box(12, 14, 4, 14, 16, 12),
                Block.box(2, 14, 4, 4, 16, 12),
                Block.box(2, 14, 12, 14, 16, 14),
                Block.box(2, 14, 2, 14, 16, 4)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    }
}
