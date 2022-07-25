package net.mcs3.elixiremporium.world.level.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModBlockItems;
import net.mcs3.elixiremporium.world.level.block.storage.barrel.BarrelEntityBlock;
import net.mcs3.elixiremporium.world.level.block.storage.jar.JarEntityBlock;
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
    public static BlockEntityType<BlockEntity> JAR_CONTAINER;
    public static BlockEntityType<BlockEntity> GLAZED_JAR_CONTAINER;



    public static void init()
    {
        EntityBlock factoryBarrel = (pos, state) -> new LiquidBarrelEntityBlock(LIQUID_BARREL_CONTAINER, pos, state, 16);
        EntityBlock factoryJar = (pos, state) -> new JarEntityBlock(JAR_CONTAINER, pos, state, 4);
        EntityBlock factoryGlazedJar = (pos, state) -> new JarEntityBlock(GLAZED_JAR_CONTAINER, pos, state, 8);

        BARREL_CONTAINER = register("barrel_container", ModBlocks.BARREL, BarrelEntityBlock::new);
        LIQUID_BARREL_CONTAINER = register("liquid_barrel_container", ModBlocks.LIQUID_BARREL, factoryBarrel::newBlockEntity);
        JAR_CONTAINER = register("jar_container", ModBlocks.FIRED_JAR, factoryJar::newBlockEntity);
        GLAZED_JAR_CONTAINER = register("glazed_jar_container", ModBlocks.FIRED_JAR, factoryJar::newBlockEntity);

        FluidStorage.SIDED.registerSelf(LIQUID_BARREL_CONTAINER);
        FluidStorage.SIDED.registerSelf(JAR_CONTAINER);
        FluidStorage.SIDED.registerSelf(GLAZED_JAR_CONTAINER);


        ModBlockItems.LIQUID_BARREL_ITEM.registerItemApi();
        ModBlockItems.FIRED_JAR_ITEM.registerItemApi();

    }

    private static <T extends BlockEntity>BlockEntityType<T> register (String name, Block block, FabricBlockEntityTypeBuilder.Factory<T> factory)
    {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(ElixirEmporium.MOD_ID, name), FabricBlockEntityTypeBuilder.create(factory, block).build(null));
    }
}
