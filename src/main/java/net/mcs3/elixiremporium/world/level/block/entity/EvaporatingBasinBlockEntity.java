package net.mcs3.elixiremporium.world.level.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageUtil;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.fabricmc.fabric.mixin.transfer.BucketItemAccessor;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.fluid.FluidStack;
import net.mcs3.elixiremporium.network.ModNetworkSync;
import net.mcs3.elixiremporium.world.ModContainer;
import net.mcs3.elixiremporium.world.level.block.alchemy.AdvCondenserBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class EvaporatingBasinBlockEntity extends BlockEntity implements ModContainer {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(1, ItemStack.EMPTY);

    protected final ContainerData dataAccess;
    private int progress = 0;
    private int maxProgress = 120;


    public EvaporatingBasinBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.EVAPORATING_BASIN_CONTAINER, blockPos, blockState);
        this.dataAccess = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: {
                        return EvaporatingBasinBlockEntity.this.progress;
                    }
                    case 1: {
                        return EvaporatingBasinBlockEntity.this.maxProgress;
                    }
                }
                return 0;
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: {
                        EvaporatingBasinBlockEntity.this.progress = value;
                        break;
                    }
                    case 1: {
                        EvaporatingBasinBlockEntity.this.maxProgress = value;
                        break;
                    }
                }
            }
            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, EvaporatingBasinBlockEntity blockEntity) {
        //ElixirEmporium.LOGGER.info(blockEntity.fluidStorage.variant + " of " + blockEntity.fluidStorage.amount + " amount");
    }
    public ItemStack getRenderStack() {
        return new ItemStack(Items.IRON_NUGGET);
        //return this.getItem(1);
    }

    public void setInventory(NonNullList<ItemStack> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            this.inventory.set(i, inventory.get(i));
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

    /////FLUID HANDLING///////////
    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return FluidStack.convertDropletsToMb(FluidConstants.BUCKET * 8);  // 6 Buckets or 6000mb of fluid
        }

        @Override
        protected void onFinalCommit() {
            setChanged();
            if(!level.isClientSide()) {
                sendEvaporatingPacket();
            }
        }
    };

    private void sendEvaporatingPacket() {
        FriendlyByteBuf data = PacketByteBufs.create();
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeInt(inventory.size());
        for(int i = 0; i < inventory.size(); i++) {
            data.writeItem(inventory.get(i));
        }
        data.writeBlockPos(getBlockPos());

        for (ServerPlayer player : PlayerLookup.tracking((ServerLevel) level, getBlockPos())) {
            ServerPlayNetworking.send(player, ModNetworkSync.EVAPORATING_SYNC, data); //TODO UPDATE FOR NEW CONTAINER
        }
    }

    public final void onPlayerAddFluid(Fluid fluid) {
        transferFluidToFluidStorage(this, fluid);
    }

    public final void onPlayerRemoveFluid(EvaporatingBasinBlockEntity entity, Fluid fluid)
    {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(FluidVariant.of(fluid),
                    1000, transaction);
            transaction.commit();
        }
    }

    public static void transferFluidToFluidStorage(EvaporatingBasinBlockEntity entity, Fluid fluid) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.insert(FluidVariant.of(fluid),
                    FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
            transaction.commit();

        }
    }

    private static void extractFluid(EvaporatingBasinBlockEntity entity) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(FluidVariant.of(Fluids.WATER),
                    500, transaction);
            transaction.commit();
        }
    }

    public void setFluidLevel(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidStorage.variant = fluidVariant;
        this.fluidStorage.amount = fluidLevel;
    }

    public boolean atCapacity(EvaporatingBasinBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= blockEntity.fluidStorage.getCapacity();
    }

    public boolean canPullFluid(EvaporatingBasinBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= 1000;
    }

    private static boolean hasEnoughFluid(EvaporatingBasinBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= 500;
    }
}
