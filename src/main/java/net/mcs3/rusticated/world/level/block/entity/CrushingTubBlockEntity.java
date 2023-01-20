package net.mcs3.rusticated.world.level.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.mcs3.rusticated.fluid.FluidStack;
import net.mcs3.rusticated.network.ModNetworkSync;
import net.mcs3.rusticated.util.FastBlockEntity;
import net.mcs3.rusticated.world.ModContainer;
import net.mcs3.rusticated.world.item.crafting.CrushingTubRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CrushingTubBlockEntity extends FastBlockEntity implements ModContainer {

    private final NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);
    private int progress = 0;
    private int maxProgress = 100;

    public CrushingTubBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.CRUSHING_TUB_CONTAINER, blockPos, blockState);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    public ItemStack getRenderStack() {
        return this.getItem(0);
    }

    public void setInventory(NonNullList<ItemStack> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    public boolean canInsertItem(CrushingTubBlockEntity blockEntity, ItemStack itemStack) {
        Level level = blockEntity.level;
        Container container = new SimpleContainer(itemStack);

        assert level != null;
        Optional<CrushingTubRecipe> match = level.getRecipeManager().getRecipeFor(CrushingTubRecipe.Type.INSTANCE, container, level);

        return match.isPresent() && canInsertAmountIntoInputSlot(blockEntity)
                && canInsertItemIntoInputSlot(blockEntity, match.get().getResultItem());
    }

    public void crushItems(CrushingTubBlockEntity blockEntity) {
        if(this.level == null) return;
        this.progress = progress + 50;
        if(progress >= maxProgress) {
            ItemStack itemStack = blockEntity.getItem(0);
            Level level = blockEntity.level;
            Container container = new SimpleContainer(itemStack);

            Optional<CrushingTubRecipe> match = level.getRecipeManager().getRecipeFor(CrushingTubRecipe.Type.INSTANCE, container, level);

            if(match.isPresent() && fluidStorage.amount != fluidStorage.getCapacity() && (fluidStorage.getCapacity() - fluidStorage.amount) >= 500) {
                this.getItem(0).shrink(1);
                ItemStack bucketItem = match.get().getBucketItem();
                Fluid fluid = match.get().getInputFluid(bucketItem);
                addCrushedFluids(blockEntity, fluid);
                Block.popResourceFromFace(level, this.getBlockPos(), Direction.UP, match.get().getExtraOutputItem());
                level.playSound(null, this.getBlockPos(), SoundEvents.SLIME_BLOCK_FALL, SoundSource.BLOCKS, 1.0F, 1.0F);
                resetProgress();
                update();
            }
            resetProgress();
            update();
        }
    }

    private static boolean canInsertAmountIntoInputSlot(Container container)
    {
        return container.getItem(0).getMaxStackSize() > container.getItem(0).getCount();
    }

    private static boolean canInsertItemIntoInputSlot(Container container, ItemStack resultItem)
    {
        return container.getItem(0).getItem() == resultItem.getItem() || container.getItem(0).isEmpty();
    }

    private void resetProgress() {
        if(this.level == null) return;
        this.progress = 0;
    }

    public void givePlayerFluid(CrushingTubBlockEntity blockEntity, Player player, InteractionHand hand, ItemStack fluidContainer) {
        if(this.level == null) return;

        BlockPos pos = blockEntity.getBlockPos();
        Fluid entityFluid = blockEntity.fluidStorage.variant.getFluid();

        Level level = blockEntity.level;
        ItemStack itemStack = blockEntity.getItem(0);
        Container container = new SimpleContainer(2);
        if(itemStack == null){
            container.setItem(0, Items.AIR.getDefaultInstance());
        } else container.setItem(0, new ItemStack(entityFluid.getBucket()));
        container.setItem(1, new ItemStack(entityFluid.getBucket()));

        Optional<CrushingTubRecipe> match = level.getRecipeManager().getRecipeFor(CrushingTubRecipe.Type.INSTANCE, container, level);

        if(match.isPresent()) {
            if(fluidContainer.getItem() == Items.BUCKET) {
                onPlayerRemoveFluid(blockEntity, blockEntity.fluidStorage.variant.getFluid(), 1000);

                level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.setItemInHand(hand, ItemUtils.createFilledResult(fluidContainer, player, new ItemStack(container.getItem(0).getItem())));
            }
            if(fluidContainer.getItem() == Items.GLASS_BOTTLE) {
                onPlayerRemoveFluid(blockEntity, blockEntity.fluidStorage.variant.getFluid(), 250);

                level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                player.setItemInHand(hand, ItemUtils.createFilledResult(fluidContainer, player, new ItemStack(match.get().getBottleItem().getItem())));
            }
        }
    }

    @Override
    public void load(CompoundTag tag)
    {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, inventory);
        this.progress = tag.getInt("Progress");
        this.fluidStorage.variant = FluidVariant.fromNbt((CompoundTag) tag.get("FluidVariant"));
        this.fluidStorage.amount = tag.getLong("FluidLevel");
    }

    @Override
    protected void saveAdditional(CompoundTag tag)
    {
        ContainerHelper.saveAllItems(tag, inventory);
        super.saveAdditional(tag);
        tag.putInt("Progress", this.progress);
        tag.put("FluidVariant", fluidStorage.variant.toNbt());
        tag.putLong("FluidLevel", fluidStorage.amount);
    }

    public void update() {
        if(this.level == null) return;
        this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void onChanged() {
        setChanged();
        if (!level.isClientSide)
            sync();
    }



    /////FLUID HANDLING///////////
    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return FluidStack.convertDropletsToMb(FluidConstants.BUCKET * 8);  // 8 Buckets or 8000mb of fluid
        }

        @Override
        protected void onFinalCommit() {
            onChanged();
            if(!level.isClientSide()) {
                sendCrushingPacket();
            }
        }
    };

    private void sendCrushingPacket() {
        FriendlyByteBuf data = PacketByteBufs.create();
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeInt(inventory.size());
        for(int i = 0; i < inventory.size(); i++) {
            data.writeItem(inventory.get(i));
        }
        data.writeBlockPos(getBlockPos());

        for (ServerPlayer player : PlayerLookup.tracking((ServerLevel) level, getBlockPos())) {
            ServerPlayNetworking.send(player, ModNetworkSync.CRUSHING_SYNC, data);
        }
    }

    public final void onPlayerRemoveFluid(CrushingTubBlockEntity entity, Fluid fluid, int amount)
    {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(FluidVariant.of(fluid),
                    amount, transaction);
            transaction.commit();
        }
    }

    public final void addCrushedFluids(CrushingTubBlockEntity entity, Fluid fluid)
    {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.insert(FluidVariant.of(fluid),
                    500, transaction);
            transaction.commit();
        }
    }

    public void setFluidLevel(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidStorage.variant = fluidVariant;
        this.fluidStorage.amount = fluidLevel;
    }

    public void emptyTub(CrushingTubBlockEntity entity){
        long getFluid = entity.fluidStorage.amount;
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(FluidVariant.of(entity.fluidStorage.variant.getFluid()),
                    getFluid, transaction);
            transaction.commit();
        }
        entity.resetProgress();
    }

    public boolean canPullFluidBucket(CrushingTubBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= 1000;
    }

    public boolean canPullFluidBottle(CrushingTubBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= 250;
    }
}
