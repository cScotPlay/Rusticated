package net.mcs3.elixiremporium.world.level.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.world.level.block.ModBlockItems;
import net.mcs3.elixiremporium.world.level.block.storage.barrel.BarrelEntityBlock;
import net.mcs3.elixiremporium.world.level.block.storage.liquid_barrel.LiquidBarrelEntityBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

//TODO Erase if not needed
public class ModBlockEntityTypes
{
    public static BlockEntityType<BarrelEntityBlock> BARREL_CONTAINER;
    public static BlockEntityType<BlockEntity> LIQUID_BARREL_CONTAINER;



    public static void init()
    {
        EntityBlock factory = (pos, state) -> new LiquidBarrelEntityBlock(LIQUID_BARREL_CONTAINER, pos, state, 16);

        BARREL_CONTAINER = register("barrel_container", ModBlocks.BARREL, BarrelEntityBlock::new);
        LIQUID_BARREL_CONTAINER = register("liquid_barrel_container", ModBlocks.LIQUID_BARREL, factory::newBlockEntity);

        FluidStorage.SIDED.registerSelf(LIQUID_BARREL_CONTAINER);
        //FluidStorage.SIDED.registerForBlockEntity((tank, direction) -> LiquidBarrelEntityBlock.fluidStorage, LIQUID_BARREL_CONTAINER);
        ModBlockItems.LIQUID_BARREL_ITEM.registerItemApi();

    }

    private static <T extends BlockEntity>BlockEntityType<T> register (String name, Block block, FabricBlockEntityTypeBuilder.Factory<T> factory)
    {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(ElixirEmporium.MOD_ID, name), FabricBlockEntityTypeBuilder.create(factory, block).build(null));
    }
}
