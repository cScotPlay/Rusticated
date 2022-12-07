package net.mcs3.elixiremporium.world.level.block.alchemy;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.mcs3.elixiremporium.fluid.FluidStack;
import net.mcs3.elixiremporium.init.ModItems;
import net.mcs3.elixiremporium.network.ModNetworkSync;
import net.mcs3.elixiremporium.world.ModContainer;
import net.mcs3.elixiremporium.world.inventory.CondenserMenu;
import net.mcs3.elixiremporium.world.item.crafting.CondenserRecipe;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CondenserBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ModContainer //MenuProvider, ModContainer
{
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(5, ItemStack.EMPTY);

    protected final ContainerData dataAccess;
    private int progress = 0;
    private int maxProgress = 200;
    int fuelTime;
    private int maxFuelTime = 0;

    public CondenserBlockEntity(BlockPos blockPos, BlockState blockState)
    {
        super(ModBlockEntityTypes.CONDENSER_CONTAINER, blockPos, blockState);
        this.dataAccess = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: {
                        return CondenserBlockEntity.this.progress;
                    }
                    case 1: {
                        return CondenserBlockEntity.this.maxProgress;
                    }
                    case 2: {
                        return CondenserBlockEntity.this.fuelTime;
                    }
                    case 3: {
                        return CondenserBlockEntity.this.maxFuelTime;
                    }
                }
                return 0;
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: {
                        CondenserBlockEntity.this.progress = value;
                        break;
                    }
                    case 1: {
                        CondenserBlockEntity.this.maxProgress = value;
                        break;
                    }
                    case 2: {
                        CondenserBlockEntity.this.fuelTime = value;
                        break;
                    }
                    case 3: {
                        CondenserBlockEntity.this.maxFuelTime = value;
                        break;
                    }
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Alchemical Condenser");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        sendFluidPacket();
        return new CondenserMenu(i, this, inventory, this, this.dataAccess);
    }

    @Override
    public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
        buf.writeBlockPos(this.getBlockPos());
    }

    @Override
    public void load(CompoundTag tag)
    {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, inventory);
        this.progress = tag.getInt("Progress");
        this.fuelTime = tag.getInt("FuelTime");
        this.maxFuelTime = tag.getInt("MaxFuelTime");
        this.fluidStorage.variant = FluidVariant.fromNbt((CompoundTag) tag.get("FluidVariant"));
        this.fluidStorage.amount = tag.getLong("FluidLevel");
    }

    @Override
    protected void saveAdditional(CompoundTag tag)
    {
        ContainerHelper.saveAllItems(tag, inventory);
        super.saveAdditional(tag);
        tag.putInt("Progress", this.progress);
        tag.putInt("FuelTime", this.fuelTime);
        tag.putInt("MaxFuelTime", this.maxFuelTime);
        tag.put("FluidVariant", fluidStorage.variant.toNbt());
        tag.putLong("FluidLevel", fluidStorage.amount);
    }

    private void consumeFuel() {
        if(!getItem(3).isEmpty()) {
            this.fuelTime = FuelRegistry.INSTANCE.get(this.removeItem(3, 1).getItem());
            this.maxFuelTime = this.fuelTime;
        }
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, CondenserBlockEntity blockEntity)
    {
        if(CondenserBlock.hasRetorts(state, level, pos)) {
            if (isConsumingFuel(blockEntity)) {
                blockEntity.fuelTime--;
                state = (BlockState) state.setValue(CondenserBlock.LIT, isConsumingFuel(blockEntity));
                level.setBlock(pos, state, 3);
            }
            if (hasRecipe(blockEntity)) {
                if (hasFuelInFuelSlot(blockEntity) && !isConsumingFuel(blockEntity) && hasBottleInSlot(blockEntity) && hasEnoughFluid(blockEntity)) {
                    blockEntity.consumeFuel();
                }
                if (isConsumingFuel(blockEntity) && hasBottleInSlot(blockEntity) && hasEnoughFluid(blockEntity)) {
                    blockEntity.progress++;
                    if (blockEntity.progress == blockEntity.maxProgress) {
                        craftItems(blockEntity);
                    }
                }
            } else {
                blockEntity.resetProgress();
            }
        }
    }


    private void resetProgress()
    {
        this.progress = 0;
    }

    private static boolean hasFuelInFuelSlot(CondenserBlockEntity blockEntity)
    {
        return !blockEntity.getItem(3).isEmpty();
    }

    private static boolean hasBottleInSlot(CondenserBlockEntity blockEntity)
    {
        return !blockEntity.getItem(2).isEmpty();
    }

    private static boolean hasRecipe(CondenserBlockEntity blockEntity)
    {
        Level level = blockEntity.level;
        Container container = new SimpleContainer(blockEntity.inventory.size());
        for (int i = 0; i < blockEntity.inventory.size(); i++)
        {
            container.setItem(i, blockEntity.getItem(i));
        }

        Optional<CondenserRecipe> match = level.getRecipeManager().getRecipeFor(CondenserRecipe.Type.INSTANCE, container, level);

        return match.isPresent() && canInsertAmountIntoOutputSlot(container)
                    && canInsertItemIntoOutputSlot(container, match.get().getResultItem());

    }

    private static boolean isConsumingFuel(CondenserBlockEntity blockEntity)
    {
        return blockEntity.fuelTime > 0;
    }

    private static boolean canInsertAmountIntoOutputSlot(Container container)
    {
        return container.getItem(4).getMaxStackSize() > container.getItem(4).getCount();
    }

    private static boolean canInsertItemIntoOutputSlot(Container container, ItemStack resultItem)
    {
        return container.getItem(4).getItem() == resultItem.getItem() || container.getItem(4).isEmpty();
    }

    private static void craftItems(CondenserBlockEntity blockEntity)
    {
        Level level = blockEntity.level;
        Container container = new SimpleContainer(blockEntity.inventory.size());
        BlockPos blockPos = blockEntity.getBlockPos();
        for (int i = 0; i < blockEntity.inventory.size(); i++)
        {
            container.setItem(i, blockEntity.getItem(i));
        }

        Optional<CondenserRecipe> match = level.getRecipeManager()
                .getRecipeFor(CondenserRecipe.Type.INSTANCE, container, level);

        if (match.isPresent())
        {
            blockEntity.removeItem(0, 1);
            blockEntity.removeItem(1, 1);
            blockEntity.removeItem(2, 1);

            extractFluid(blockEntity);

            Potion potion = match.get().getPotion();

            blockEntity.setItem(4, PotionUtils.setPotion(new ItemStack(ModItems.ELIXIR, blockEntity.getItem(4).getCount() + 1), potion));
            level.playSound(null, blockPos, SoundEvents.BREWING_STAND_BREW, SoundSource.BLOCKS, 1.0f, 1.0f);

            blockEntity.resetProgress();
        }
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
            setChanged();
            if(!level.isClientSide()) {
                sendFluidPacket();
            }
        }
    };

    public final void onPlayerAddFluid() {
        transferFluidToFluidStorage(this);
    }

    public final void onPlayerRemoveFluid(CondenserBlockEntity entity)
    {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.extract(FluidVariant.of(Fluids.WATER),
                    1000, transaction);
            transaction.commit();
        }
    }

    private void sendFluidPacket() {
        FriendlyByteBuf data = PacketByteBufs.create();
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeBlockPos(getBlockPos());

        for (ServerPlayer player : PlayerLookup.tracking((ServerLevel) level, getBlockPos())) {
            ServerPlayNetworking.send(player, ModNetworkSync.FLUID_SYNC, data);
        }
    }

    public static void transferFluidToFluidStorage(CondenserBlockEntity entity) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.fluidStorage.insert(FluidVariant.of(Fluids.WATER),
                    FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
            transaction.commit();
            //entity.setItem(0, new ItemStack(Items.BUCKET));
        }
    }

    private static void extractFluid(CondenserBlockEntity entity) {
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

    public boolean atCapacity(CondenserBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= blockEntity.fluidStorage.getCapacity();
    }

    public boolean canPullFluid(CondenserBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= 1000;
    }

    private static boolean hasEnoughFluid(CondenserBlockEntity blockEntity) {
        return blockEntity.fluidStorage.amount >= 500;
    }

//        boolean hasItemInFirstSlot = blockEntity.getItem(0).getItem() == ModItems.COHOSH;
//        boolean hasItemInSecondSlot = blockEntity.getItem(1).getItem() == Items.HONEYCOMB;
//        boolean hasItemInThridSlot = blockEntity.getItem(2).getItem() == Items.GLASS_BOTTLE;
//        boolean hasItemInFourthSlot = blockEntity.getItem(3).getItem() == Items.COAL;
//        boolean hasItemInFifthSlot = blockEntity.getItem(4).getItem() == Items.WATER_BUCKET;\
}
