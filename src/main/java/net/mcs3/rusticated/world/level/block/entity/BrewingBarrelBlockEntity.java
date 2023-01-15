package net.mcs3.rusticated.world.level.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.fabricmc.fabric.mixin.transfer.BucketItemAccessor;
import net.mcs3.rusticated.data.tags.ModItemTags;
import net.mcs3.rusticated.fluid.FluidStack;
import net.mcs3.rusticated.network.ModNetworkSync;
import net.mcs3.rusticated.world.ModContainer;
import net.mcs3.rusticated.world.inventory.BrewingBarrelMenu;
import net.mcs3.rusticated.world.item.BoozeItem;
import net.mcs3.rusticated.world.item.crafting.BrewingBarrelRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class BrewingBarrelBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ModContainer {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(6, ItemStack.EMPTY);
    private static final Random rand = new Random();
    private BrewingBarrelRecipe recipe;

    protected final ContainerData dataAccess;
    private int progress = 0;
    private int maxProgress = 12000;
    private int primerQuality = 0;
    private int resultQuality = 0;

    public BrewingBarrelBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.BREWING_BARREL_CONTAINER, blockPos, blockState);
        this.dataAccess = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: {
                        return BrewingBarrelBlockEntity.this.progress;
                    }
                    case 1: {
                        return BrewingBarrelBlockEntity.this.maxProgress;
                    }
                    case 2: {
                        return BrewingBarrelBlockEntity.this.primerQuality;
                    }
                    case 3: {
                        return BrewingBarrelBlockEntity.this.resultQuality;
                    }
                }
                return 0;
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: {
                        BrewingBarrelBlockEntity.this.progress = value;
                        break;
                    }
                    case 1: {
                        BrewingBarrelBlockEntity.this.maxProgress = value;
                        break;
                    }
                    case 2: {
                        BrewingBarrelBlockEntity.this.primerQuality = value;
                        break;
                    }
                    case 3: {
                        BrewingBarrelBlockEntity.this.resultQuality = value;
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
    public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
        buf.writeBlockPos(this.getBlockPos());
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        sendFluidPacket(inputFluidStorage);
        sendFluidPacket(resultFluidStorage);
        sendFluidPacket(primerFluidStorage);

        return new BrewingBarrelMenu(i, this, inventory, this, this.dataAccess);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, BrewingBarrelBlockEntity blockEntity) {
        if(level.isClientSide) return;

        if(blockEntity.resultFluidStorage.amount == 0) {
            blockEntity.resultQuality = 0;
        }

        if(blockEntity.primerFluidStorage.amount == 0) {
            blockEntity.primerQuality = 0;
        }

        for(int i = 0; i < 2; i++) {
            if(hasFluidSourceInSlot(blockEntity, i)) {
                transferFluidsToFluidStorage(blockEntity);
            }
        }

        if(hasFluidRecipes(blockEntity) && blockEntity.resultFluidStorage.variant.isBlank()) {
            blockEntity.progress++;
            if(blockEntity.progress >= blockEntity.maxProgress) {
                tryToBrewFluids(blockEntity, blockEntity.recipe);
                resetProgress(blockEntity);
            }
        }
    }

    private static boolean hasFluidRecipes(BrewingBarrelBlockEntity blockEntity) {
        Level level = blockEntity.level;
        List<BrewingBarrelRecipe> matchAll = level.getRecipeManager().getAllRecipesFor(BrewingBarrelRecipe.Type.INSTANCE);

        if (!matchAll.isEmpty()) {
            for (int i = 0; i < matchAll.size(); i++) {
                BrewingBarrelRecipe tryRecipe = matchAll.get(i);
                Fluid recipeFluid = tryRecipe.getInputFluid();
                Fluid barrelFluid = blockEntity.inputFluidStorage.variant.getFluid();
                if (tryRecipe.isPrimerUsed()) {
                    Fluid primerRecipeFluid = tryRecipe.getPrimerFluid();
                    Fluid primerBarrelFluid = blockEntity.primerFluidStorage.variant.getFluid();
                    if (primerRecipeFluid == primerBarrelFluid) {
                        if(recipeFluid == barrelFluid) {
                            blockEntity.recipe = tryRecipe;
                            return true;
                        }
                    }
                }
                else if (blockEntity.primerFluidStorage.variant.isBlank() && recipeFluid == barrelFluid) {
                    blockEntity.recipe = tryRecipe;
                    return true;
                }
            }
        } return false;
    }

    private static void tryToBrewFluids(BrewingBarrelBlockEntity blockEntity, BrewingBarrelRecipe brewingRecipe) {
        Fluid recipeFluid = brewingRecipe.getInputFluid();
        Fluid barrelFluid = blockEntity.inputFluidStorage.variant.getFluid();
        BoozeItem boozeItem = (BoozeItem) brewingRecipe.getResultItem().getItem();
        Fluid resultFluid = boozeItem.getFluidType();
        long inputFluidAmount = blockEntity.inputFluidStorage.amount;

        if (!blockEntity.hasLevel()) return;

        if(brewingRecipe.isPrimerUsed()) {
            Fluid primerRecipeFluid = brewingRecipe.getPrimerFluid();
            Fluid primerBarrelFluid = blockEntity.primerFluidStorage.variant.getFluid();

            if(primerRecipeFluid == primerBarrelFluid) {
                if(recipeFluid == barrelFluid) {

                    int primerAdditionalQuality = rand.nextInt(15);
                    int qualityWithPrimer = Math.max(Math.min(primerAdditionalQuality + blockEntity.primerQuality, 99), 0);

                    blockEntity.resultQuality = qualityWithPrimer;

                    insertFluids(blockEntity, blockEntity.resultFluidStorage, FluidVariant.of(resultFluid), inputFluidAmount);
                    blockEntity.extractFluids(blockEntity, blockEntity.inputFluidStorage, blockEntity.inputFluidStorage.variant, inputFluidAmount);
                    //blockEntity.extractFluids(blockEntity, blockEntity.primerFluidStorage, blockEntity.primerFluidStorage.variant, blockEntity.primerFluidStorage.amount);
                    resetProgress(blockEntity);
                }
            }
        }
        else if(recipeFluid == barrelFluid) {
            blockEntity.resultQuality = (5 + rand.nextInt(71));
            insertFluids(blockEntity, blockEntity.resultFluidStorage, FluidVariant.of(resultFluid), inputFluidAmount);
            blockEntity.extractFluids(blockEntity, blockEntity.inputFluidStorage, blockEntity.inputFluidStorage.variant, inputFluidAmount);
            resetProgress(blockEntity);
        }
    }

    public static void resetProgress(BrewingBarrelBlockEntity blockEntity) {
        blockEntity.progress = 0;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, inventory);
        this.progress = tag.getInt("brewing.progress");
        this.primerQuality = tag.getInt("brewing.primer_quality");
        this.resultQuality = tag.getInt("brewing.result_quality");
        this.inputFluidStorage.variant = FluidVariant.fromNbt((CompoundTag) tag.get("brewing.inputFluidVariant"));
        this.inputFluidStorage.amount = tag.getLong("brewing.inputFluidLevel");
        this.resultFluidStorage.variant = FluidVariant.fromNbt((CompoundTag) tag.get("brewing.resultFluidVariant"));
        this.resultFluidStorage.amount = tag.getLong("brewing.resultFluidLevel");
        this.primerFluidStorage.variant = FluidVariant.fromNbt((CompoundTag) tag.get("brewing.primerFluidVariant"));
        this.primerFluidStorage.amount = tag.getLong("brewing.primerFluidLevel");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        ContainerHelper.saveAllItems(tag, inventory);
        super.saveAdditional(tag);
        tag.putInt("brewing.progress", this.progress);
        tag.putInt("brewing.primer_quality", this.primerQuality);
        tag.putInt("brewing.result_quality", this.resultQuality);
        tag.put("brewing.inputFluidVariant", inputFluidStorage.variant.toNbt());
        tag.putLong("brewing.inputFluidLevel", inputFluidStorage.amount);
        tag.put("brewing.resultFluidVariant", resultFluidStorage.variant.toNbt());
        tag.putLong("brewing.resultFluidLevel", resultFluidStorage.amount);
        tag.put("brewing.primerFluidVariant", primerFluidStorage.variant.toNbt());
        tag.putLong("brewing.primerFluidLevel", primerFluidStorage.amount);
    }

    private void sendFluidPacket(SingleVariantStorage<FluidVariant> fluidStorageType) {
        FriendlyByteBuf data = PacketByteBufs.create();
        SingleVariantStorage<FluidVariant> fluidStorage = fluidStorageType;
        fluidStorage.variant.toPacket(data);
        data.writeLong(fluidStorage.amount);
        data.writeBlockPos(getBlockPos());
        if(fluidStorageType == primerFluidStorage) {
            data.writeInt(0);
        }
        if (fluidStorageType == inputFluidStorage) {
            data.writeInt(1);
        }
        if (fluidStorageType == resultFluidStorage) {
            data.writeInt(2);
        }

        for (ServerPlayer player : PlayerLookup.tracking((ServerLevel) level, getBlockPos())) {
            ServerPlayNetworking.send(player, ModNetworkSync.BREWING_SYNC, data);
        }
    }

    public void update() {
        if(this.level == null) return;
        this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    /////FLUID HANDLING///////////
    public final SingleVariantStorage<FluidVariant> inputFluidStorage = new SingleVariantStorage<FluidVariant>() {
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
                sendFluidPacket(inputFluidStorage);
            }
        }
    };

    public final SingleVariantStorage<FluidVariant> resultFluidStorage = new SingleVariantStorage<FluidVariant>() {
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
                sendFluidPacket(resultFluidStorage);
            }
        }
    };

    public final SingleVariantStorage<FluidVariant> primerFluidStorage = new SingleVariantStorage<FluidVariant>() {
        @Override
        protected FluidVariant getBlankVariant() {
            return FluidVariant.blank();
        }

        @Override
        protected long getCapacity(FluidVariant variant) {
            return FluidStack.convertDropletsToMb(FluidConstants.BUCKET * 1);  // 1 Buckets or 1000mb of fluid
        }

        @Override
        protected void onFinalCommit() {
            setChanged();
            if(!level.isClientSide()) {
                sendFluidPacket(primerFluidStorage);
            }
        }
    };

    public SingleVariantStorage<FluidVariant> getFluidStorage(int slotNumber) {
        if(slotNumber == 0) {
            return primerFluidStorage;
        } else if (slotNumber == 1) {
            return inputFluidStorage;
        } else if (slotNumber == 2) {
            return resultFluidStorage;
        }
        return null;
    }

    public void setFluidLevel(SingleVariantStorage<FluidVariant> fluidStorage, FluidVariant fluidVariant, long fluidLevel) {
        fluidStorage.variant = fluidVariant;
        fluidStorage.amount = fluidLevel;
    }

    private static boolean hasFluidSourceInSlot(BrewingBarrelBlockEntity entity, int slotNumber) {
        return entity.getItem(slotNumber).is(ModItemTags.BREWING_FLUID) || entity.getItem(0).getItem() == Items.GLASS_BOTTLE || entity.getItem(1).getItem() == Items.BUCKET || entity.getItem(2).getItem() == Items.GLASS_BOTTLE;
    }

    private static void transferFluidsToFluidStorage(BrewingBarrelBlockEntity blockEntity) {
        if(!blockEntity.getItem(0).isEmpty()) {
            transferPrimerFluidToStorage(blockEntity);
        }
        if(!blockEntity.getItem(1).isEmpty()) {
            transferImportFluidToStorage(blockEntity);
        }
        if(!blockEntity.getItem(2).isEmpty() && !blockEntity.resultFluidStorage.variant.isBlank()) {
            if(blockEntity.getItem(5).isEmpty()) {
                transferResultFluidFromStorage(blockEntity);
            } else if (!blockEntity.getItem(5).isEmpty()) {
                int fluid_quality = blockEntity.resultQuality;
                int item_quality = (int) (blockEntity.getItem(5).getOrCreateTag().getFloat("rusticated.fluid_quality") * 100);

                if (fluid_quality == item_quality) {
                    transferResultFluidFromStorage(blockEntity);
                }
            }
        }
    }

    public static void transferPrimerFluidToStorage(BrewingBarrelBlockEntity blockEntity) {
        try(Transaction transaction = Transaction.openOuter()) {
            if(blockEntity.getItem(0).getItem() == Items.GLASS_BOTTLE && blockEntity.getItem(3).isEmpty() && !blockEntity.primerFluidStorage.variant.isBlank()) {
                Fluid barrelFluid = blockEntity.primerFluidStorage.variant.getFluid();
                List<BrewingBarrelRecipe> matchAll = blockEntity.level.getRecipeManager().getAllRecipesFor(BrewingBarrelRecipe.Type.INSTANCE);
                if (!matchAll.isEmpty()) {
                    for (int i = 0; i < matchAll.size(); i++) {
                        BrewingBarrelRecipe tryRecipe = matchAll.get(i);
                        BoozeItem boozeItem = (BoozeItem) tryRecipe.getResultItem().getItem();
                        Fluid recipeFluid = boozeItem.getFluidType();
                        if(recipeFluid == barrelFluid) {
                            blockEntity.recipe = tryRecipe;
                        }
                    }
                }
                int slotCount = blockEntity.getItem(3).getCount();
                ItemStack resultItem = new ItemStack(blockEntity.recipe.getResultItem().getItem(), slotCount + 1);
                CompoundTag qualityTag = new CompoundTag();
                qualityTag.putFloat("rusticated.fluid_quality", (float) blockEntity.primerQuality / 100);
                resultItem.setTag(qualityTag);
                blockEntity.setItem(3, resultItem);

                blockEntity.removeItem(0, 1);
                blockEntity.primerFluidStorage.extract(blockEntity.primerFluidStorage.variant,
                        FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
                transaction.commit();
                blockEntity.update();
            }

            else if(blockEntity.primerFluidStorage.variant.isBlank() && blockEntity.getItem(0).getItem() instanceof BoozeItem) {
                BoozeItem cupItem = (BoozeItem) blockEntity.getItem(0).getItem();
                Fluid fluid = cupItem.getFluidType();
                int cupQuality = (int) (blockEntity.getItem(0).getOrCreateTag().getFloat("rusticated.fluid_quality") * 100);

                blockEntity.primerFluidStorage.insert(FluidVariant.of(fluid),
                        FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
                transaction.commit();
                blockEntity.primerQuality = cupQuality;
                blockEntity.removeItem(0, 1);
                int count = blockEntity.getItem(3).getCount();
                blockEntity.setItem(3, new ItemStack(Items.GLASS_BOTTLE, count + 1));
                resetProgress(blockEntity);
                blockEntity.update();
            }
        }
    }

    public static void transferImportFluidToStorage(BrewingBarrelBlockEntity blockEntity) {
        try(Transaction transaction = Transaction.openOuter()) {
            BucketItem fluidBucketItem = (BucketItem) blockEntity.getItem(1).getItem();
            Fluid fluid = ((BucketItemAccessor) fluidBucketItem).fabric_getFluid();

            if(fluidBucketItem == Items.BUCKET) {
                if(blockEntity.inputFluidStorage.amount >= 1000) {
                    FluidVariant storageFluid = blockEntity.inputFluidStorage.variant;
                    blockEntity.inputFluidStorage.extract(storageFluid, FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
                    transaction.commit();
                    blockEntity.removeItem(1, 1);
                    int bucketCount = blockEntity.getItem(4).getCount();
                    Item bucketItem = storageFluid.getFluid().getBucket();
                    blockEntity.setItem(4, new ItemStack(bucketItem, bucketCount + 1));
                    resetProgress(blockEntity);
                    blockEntity.update();
                }
                return;
            }

            else if(blockEntity.inputFluidStorage.getCapacity() > blockEntity.inputFluidStorage.amount &&
                    (blockEntity.inputFluidStorage.getCapacity() - blockEntity.inputFluidStorage.amount) > 1000) {
                blockEntity.inputFluidStorage.insert(FluidVariant.of(fluid),
                        FluidStack.convertDropletsToMb(FluidConstants.BUCKET), transaction);
                transaction.commit();
                blockEntity.removeItem(1, 1);
                int count = blockEntity.getItem(4).getCount();
                blockEntity.setItem(4, new ItemStack(Items.BUCKET, count + 1));
                resetProgress(blockEntity);
                blockEntity.update();
            }
        }
    }

    public static void transferResultFluidFromStorage(BrewingBarrelBlockEntity blockEntity) {
        try(Transaction transaction = Transaction.openOuter()) {
            FluidVariant fluidVariant = blockEntity.resultFluidStorage.variant;
            blockEntity.resultFluidStorage.extract(fluidVariant,
                    250, transaction);
            blockEntity.removeItem(2, 1);
            transaction.commit();

            Fluid barrelFluid = fluidVariant.getFluid();
            List<BrewingBarrelRecipe> matchAll = blockEntity.level.getRecipeManager().getAllRecipesFor(BrewingBarrelRecipe.Type.INSTANCE);
            if (!matchAll.isEmpty()) {
                for (int i = 0; i < matchAll.size(); i++) {
                    BrewingBarrelRecipe tryRecipe = matchAll.get(i);
                    BoozeItem boozeItem = (BoozeItem) tryRecipe.getResultItem().getItem();
                    Fluid recipeFluid = boozeItem.getFluidType();
                    if(recipeFluid == barrelFluid) {
                        blockEntity.recipe = tryRecipe;
                    }
                }
            }

            int slotCount = blockEntity.getItem(5).getCount();
            ItemStack resultItem = new ItemStack(blockEntity.recipe.getResultItem().getItem(), slotCount + 1);
            CompoundTag qualityTag = new CompoundTag();
            qualityTag.putFloat("rusticated.fluid_quality", (float) blockEntity.resultQuality / 100);
            resultItem.setTag(qualityTag);
            blockEntity.setItem(5, resultItem);
            blockEntity.update();
        }
    }

    public static boolean capacityFull(SingleVariantStorage<FluidVariant> fluidVariant) {
        if(fluidVariant.amount >= fluidVariant.getCapacity()) {
            return true;
        } return false;
    }

    public static void insertFluids(BrewingBarrelBlockEntity blockEntity, SingleVariantStorage<FluidVariant> fluidStorage, FluidVariant fluidVariant, long fluidLevel) {
        try(Transaction transaction = Transaction.openOuter()) {
            fluidStorage.insert(fluidVariant,
                    fluidLevel, transaction);
            transaction.commit();
            blockEntity.update();
        }
    }

    public void extractFluids(BrewingBarrelBlockEntity blockEntity, SingleVariantStorage<FluidVariant> fluidStorage, FluidVariant fluidVariant, long fluidLevel) {
        try(Transaction transaction = Transaction.openOuter()) {
            fluidStorage.extract(fluidVariant,
                    fluidLevel, transaction);
            transaction.commit();
            blockEntity.update();
        }
    }
}
