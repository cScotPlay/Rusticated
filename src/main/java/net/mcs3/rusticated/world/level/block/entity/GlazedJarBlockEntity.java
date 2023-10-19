package net.mcs3.rusticated.world.level.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.mcs3.rusticated.data.tags.ModItemTags;
import net.mcs3.rusticated.fluid.FluidStack;
import net.mcs3.rusticated.init.ModFluids;
import net.mcs3.rusticated.network.ModNetworkSync;
import net.mcs3.rusticated.util.FastBlockEntity;
import net.mcs3.rusticated.world.item.BoozeItem;
import net.mcs3.rusticated.world.item.FluidBottleItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

public class GlazedJarBlockEntity extends FastBlockEntity {

    long capacity = 8;

    public GlazedJarBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.GLAZED_JAR_CONTAINER, blockPos, blockState);
    }

    public void givePlayerFluid(GlazedJarBlockEntity blockEntity, Player player, InteractionHand hand, ItemStack fluidContainer) {
        if(this.level == null) return;

        BlockPos pos = blockEntity.getBlockPos();
        Fluid entityFluid = blockEntity.fluidStorage.variant.getFluid();

        if(entityFluid == ModFluids.SOURCE_HONEY.getSource()) {
            player.setItemInHand(hand, ItemUtils.createFilledResult(fluidContainer, player, new ItemStack(Items.HONEY_BOTTLE)));
            return;
        }

        if(entityFluid == Fluids.WATER.getSource()) {
            player.setItemInHand(hand, ItemUtils.createFilledResult(fluidContainer, player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)));
            return;
        }

        for(Item fluidItem : BuiltInRegistries.ITEM.stream().toList()) {
            if(fluidItem.getDefaultInstance().is(ModItemTags.FLUID_BOTTLES)) {
                if(fluidItem instanceof BoozeItem) {
                    BoozeItem boozeItem = (BoozeItem) fluidItem;
                    if(boozeItem.getFluidType() == entityFluid) {
                        player.setItemInHand(hand, ItemUtils.createFilledResult(fluidContainer, player, new ItemStack(boozeItem)));
                        return;
                    }
                }else if (fluidItem instanceof FluidBottleItem) {
                    FluidBottleItem fluidBottleItem = (FluidBottleItem) fluidItem;
                    if(fluidBottleItem.getFluidType() == entityFluid) {
                        player.setItemInHand(hand, ItemUtils.createFilledResult(fluidContainer, player, new ItemStack(fluidBottleItem)));
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void setChanged() {
        super.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("fluidVariant", fluidStorage.variant.toNbt());
        tag.putLong("fluidLevel", fluidStorage.amount);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.fluidStorage.variant = FluidVariant.fromNbt((CompoundTag) tag.get("fluidVariant"));
        this.fluidStorage.amount = tag.getLong("fluidLevel");
    }

    public void onChanged() {
        setChanged();
        if (!level.isClientSide)
            sync();
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }

    private void sendFluidPacket() {
        FriendlyByteBuf data = PacketByteBufs.create();
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeBlockPos(getBlockPos());

        for (ServerPlayer player : PlayerLookup.tracking((ServerLevel) level, getBlockPos())) {
            ServerPlayNetworking.send(player, ModNetworkSync.JAR_SYNC, data);
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void update() {
        if(this.level == null) return;
        this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    /////FLUID HANDLING///////////
    public final SingleVariantStorage<FluidVariant> fluidStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return FluidStack.convertDropletsToMb(FluidConstants.BUCKET * capacity);  // 8 Buckets or 8000mb of fluid
        }

        @Override
        protected void onFinalCommit() {
            onChanged();
            if(!level.isClientSide()) {
                sendFluidPacket();
            }
        }
    };

    public void setFluidLevel(FluidVariant fluidVariant, long fluidLevel) {
        this.fluidStorage.variant = fluidVariant;
        this.fluidStorage.amount = fluidLevel;
    }

    public boolean atCapacity(GlazedJarBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= blockEntity.fluidStorage.getCapacity();
    }

    public void transferFluidToFluidStorage(GlazedJarBlockEntity entity, FluidVariant fluidVariant, long fluidAmount) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.insert(fluidVariant,
                    fluidAmount, transaction);
            transaction.commit();
            entity.update();
        }
    }

    public void removeFluidFromFluidStorage(GlazedJarBlockEntity entity, long amount) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(entity.fluidStorage.variant,
                    amount, transaction);
            transaction.commit();
            entity.update();
        }
    }
    public boolean isEmpty() {
        return fluidStorage.amount == 0;
    }
}
