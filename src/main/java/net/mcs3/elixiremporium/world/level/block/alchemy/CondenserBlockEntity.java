package net.mcs3.elixiremporium.world.level.block.alchemy;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModItems;
import net.mcs3.elixiremporium.world.ModContainer;
import net.mcs3.elixiremporium.world.inventory.CondenserMenu;
import net.mcs3.elixiremporium.world.item.crafting.CondenserRecipe;
import net.mcs3.elixiremporium.world.item.crafting.ModRecipes;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PotionItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class CondenserBlockEntity extends BlockEntity implements MenuProvider, ModContainer
{
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(6, ItemStack.EMPTY);

    protected final ContainerData dataAccess;
    private int progress = 0;
    private int maxProgress = 72;
    private int fuelTime = 0;
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
        return new CondenserMenu(i, inventory, this, this.dataAccess);
    }

    @Override
    public void load(CompoundTag tag)
    {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, inventory);
        tag.putInt("condenser.progress", progress);
        tag.putInt("condenser.fuelTime", fuelTime);
        tag.putInt("condenser.maxFuelTime", maxFuelTime);
    }

    @Override
    protected void saveAdditional(CompoundTag tag)
    {
        ContainerHelper.saveAllItems(tag, inventory);
        super.saveAdditional(tag);
        progress = tag.getInt("condenser.progress");
        fuelTime = tag.getInt("condenser.fuelTime");
        maxFuelTime = tag.getInt("condenser.maxFuelTime");
    }

    private void consumeFuel() {
        if(!getItem(3).isEmpty()) {
            this.fuelTime = FuelRegistry.INSTANCE.get(this.removeItem(3, 1).getItem());
            this.maxFuelTime = this.fuelTime;
        }
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, CondenserBlockEntity blockEntity)
    {
        if(isConsumingFuel(blockEntity))
        {
            blockEntity.fuelTime--;
        }

        if(hasRecipe(blockEntity))
        {
            if(hasFuelInFuelSlot(blockEntity) && !isConsumingFuel(blockEntity))
            {
                blockEntity.consumeFuel();
            }
            if(isConsumingFuel(blockEntity))
            {
                blockEntity.progress++;
                if(blockEntity.progress > blockEntity.maxProgress)
                {
                    craftItems(blockEntity);
                }
            }

        }
        else {
            blockEntity.resetProgress();
        }

//        if(hasRecipe(blockEntity) && hasNotReachedStackLimit(blockEntity))
//        {
//            craftItems(blockEntity);
//        }
    }

    private void resetProgress()
    {
        this.progress = 0;
    }

    private static boolean hasFuelInFuelSlot(CondenserBlockEntity blockEntity)
    {
        return !blockEntity.getItem(3).isEmpty();
    }

    private static boolean hasRecipe(CondenserBlockEntity blockEntity)
    {
        Level level = blockEntity.level;
        Container container = new SimpleContainer(blockEntity.inventory.size());
        for (int i = 0; i < blockEntity.inventory.size(); i++)
        {
            container.setItem(i, blockEntity.getItem(i));
        }

//        ElixirEmporium.LOGGER.info("Test Stop");
//        return true;
//
        Optional<CondenserRecipe> match = level.getRecipeManager().getRecipeFor(CondenserRecipe.Type.INSTANCE, container, level);

        //ElixirEmporium.LOGGER.info("Test Stop");

        return match.isPresent() && canInsertAmountIntoOutputSlot(container)
                    && canInsertItemIntoOutputSlot(container, match.get().getResultItem());

    }

    private static boolean isConsumingFuel(CondenserBlockEntity blockEntity)
    {
        return  blockEntity.fuelTime > 0;
    }

    private static boolean canInsertAmountIntoOutputSlot(Container container)
    {
        return container.getItem(5).getMaxStackSize() > container.getItem(5).getCount();
    }

    private static boolean canInsertItemIntoOutputSlot(Container container, ItemStack resultItem)
    {
        return container.getItem(5).getItem() == resultItem.getItem() || container.getItem(5).isEmpty();
    }

    private static void craftItems(CondenserBlockEntity blockEntity)
    {
        Level level = blockEntity.level;
        Container container = new SimpleContainer(blockEntity.inventory.size());
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

            blockEntity.setItem(5, new ItemStack(match.get().getResultItem().getItem(), blockEntity.getItem(5).getCount() + 1));

            blockEntity.resetProgress();
        }

//        blockEntity.removeItem(0, 1);
//        blockEntity.removeItem(1, 1);
//        blockEntity.removeItem(2, 1);
//        blockEntity.removeItem(3, 1);
//        blockEntity.removeItem(4, 1);
//
//        blockEntity.setItem(5, new ItemStack(Items.GOLDEN_APPLE, blockEntity.getItem(5).getCount() + 1));
    }
//
//    private static boolean hasNotReachedStackLimit(CondenserBlockEntity blockEntity)
//    {
//        return blockEntity.getItem(5).getCount() < blockEntity.getItem(3).getMaxStackSize();
//    }
//
//    private static boolean hasRecipe(CondenserBlockEntity blockEntity)
//    {
//        boolean hasItemInFirstSlot = blockEntity.getItem(0).getItem() == ModItems.COHOSH;
//        boolean hasItemInSecondSlot = blockEntity.getItem(1).getItem() == Items.HONEYCOMB;
//        boolean hasItemInThridSlot = blockEntity.getItem(2).getItem() == Items.GLASS_BOTTLE;
//        boolean hasItemInFourthSlot = blockEntity.getItem(3).getItem() == Items.COAL;
//        boolean hasItemInFifthSlot = blockEntity.getItem(4).getItem() == Items.WATER_BUCKET;
//
//        return hasItemInFirstSlot && hasItemInSecondSlot && hasItemInThridSlot && hasItemInFourthSlot && hasItemInFifthSlot;
//    }
}
