package net.mcs3.rusticated.world.level.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModBlockItems;
import net.mcs3.rusticated.world.level.block.alchemy.AdvCondenserBlockEntity;
import net.mcs3.rusticated.world.level.block.alchemy.CondenserBlockEntity;
import net.mcs3.rusticated.world.level.block.storage.barrel.BarrelEntityBlock;
import net.mcs3.rusticated.world.level.block.storage.pot.PotEntityBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypes
{
    public static BlockEntityType<BarrelEntityBlock> BARREL_CONTAINER;
    public static BlockEntityType<LiquidBarrelBlockEntity> LIQUID_BARREL_CONTAINER;
    public static BlockEntityType<JarBlockEntity> JAR_CONTAINER;
    public static BlockEntityType<GlazedJarBlockEntity> GLAZED_JAR_CONTAINER;
    public static BlockEntityType<BlockEntity> POT_CONTAINER;
    public static BlockEntityType<BlockEntity> GLAZED_POT_0_CONTAINER;
    public static BlockEntityType<BlockEntity> GLAZED_POT_1_CONTAINER;
    public static BlockEntityType<BlockEntity> GLAZED_POT_2_CONTAINER;
    public static BlockEntityType<BlockEntity> GLAZED_POT_3_CONTAINER;
    public static BlockEntityType<BlockEntity> GLAZED_POT_4_CONTAINER;
    public static BlockEntityType<CondenserBlockEntity> CONDENSER_CONTAINER;
    public static BlockEntityType<AdvCondenserBlockEntity> ADV_CONDENSER_CONTAINER;
    public static BlockEntityType<EvaporatingBasinBlockEntity> EVAPORATING_BASIN_CONTAINER;
    public static BlockEntityType<CrushingTubBlockEntity> CRUSHING_TUB_CONTAINER;
    public static BlockEntityType<BrewingBarrelBlockEntity> BREWING_BARREL_CONTAINER;

    public static void init()
    {
        //EntityBlock factoryBarrel = (pos, state) -> new LiquidBarrelEntityBlock(LIQUID_BARREL_CONTAINER, pos, state, 16);
        //EntityBlock factoryJar = (pos, state) -> new JarBlockEntity(JAR_CONTAINER, pos, state, 4);
        //EntityBlock factoryGlazedJar = (pos, state) -> new JarBlockEntity(GLAZED_JAR_0_CONTAINER, pos, state, 8);
        EntityBlock factoryPot = (pos, state) -> new PotEntityBlock(POT_CONTAINER, pos, state, 8);
        EntityBlock factoryGlazedPot = (pos, state) -> new PotEntityBlock(GLAZED_POT_0_CONTAINER, pos, state, 16);
        EntityBlock factoryGlazedPot1 = (pos, state) -> new PotEntityBlock(GLAZED_POT_1_CONTAINER, pos, state, 16);
        EntityBlock factoryGlazedPot2 = (pos, state) -> new PotEntityBlock(GLAZED_POT_2_CONTAINER, pos, state, 16);
        EntityBlock factoryGlazedPot3 = (pos, state) -> new PotEntityBlock(GLAZED_POT_3_CONTAINER, pos, state, 16);
        EntityBlock factoryGlazedPot4 = (pos, state) -> new PotEntityBlock(GLAZED_POT_4_CONTAINER, pos, state, 16);

        BARREL_CONTAINER = register("barrel_container", ModBlocks.STORAGE_BARREL, BarrelEntityBlock::new);
        LIQUID_BARREL_CONTAINER = register("liquid_barrel_container", ModBlocks.LIQUID_BARREL, LiquidBarrelBlockEntity::new);
        JAR_CONTAINER = register("jar_container", ModBlocks.FIRED_JAR, JarBlockEntity::new);
        GLAZED_JAR_CONTAINER = register("glazed_jar_0_container", ModBlocks.GLAZED_JAR_0, GlazedJarBlockEntity::new);
        POT_CONTAINER = register("pot_container", ModBlocks.FIRED_POT, factoryPot::newBlockEntity);
        GLAZED_POT_0_CONTAINER = register("glazed_pot_0_container", ModBlocks.GLAZED_POT_0, factoryGlazedPot::newBlockEntity);
        GLAZED_POT_1_CONTAINER = register("glazed_pot_1_container", ModBlocks.GLAZED_POT_1, factoryGlazedPot1::newBlockEntity);
        GLAZED_POT_2_CONTAINER = register("glazed_pot_2_container", ModBlocks.GLAZED_POT_2, factoryGlazedPot2::newBlockEntity);
        GLAZED_POT_3_CONTAINER = register("glazed_pot_3_container", ModBlocks.GLAZED_POT_3, factoryGlazedPot3::newBlockEntity);
        GLAZED_POT_4_CONTAINER = register("glazed_pot_4_container", ModBlocks.GLAZED_POT_4, factoryGlazedPot4::newBlockEntity);
        CONDENSER_CONTAINER = register("condenser_container", ModBlocks.CONDENSER, CondenserBlockEntity::new);
        ADV_CONDENSER_CONTAINER = register("adv_condenser_container", ModBlocks.ADV_CONDENSER, AdvCondenserBlockEntity::new);
        EVAPORATING_BASIN_CONTAINER = register("evaporating_basin_container", ModBlocks.EVAPORATING_BASIN, EvaporatingBasinBlockEntity::new);
        CRUSHING_TUB_CONTAINER = register("crushing_tub_container", ModBlocks.CRUSHING_TUB, CrushingTubBlockEntity::new);
        BREWING_BARREL_CONTAINER = register("brewing_barrel_container", ModBlocks.OAK_BREWING_BARREL, BrewingBarrelBlockEntity::new);

        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, LIQUID_BARREL_CONTAINER);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, JAR_CONTAINER);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, GLAZED_JAR_CONTAINER);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, CONDENSER_CONTAINER);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, ADV_CONDENSER_CONTAINER);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, EVAPORATING_BASIN_CONTAINER);
        FluidStorage.SIDED.registerForBlockEntity((blockEntity, direction) -> blockEntity.fluidStorage, CRUSHING_TUB_CONTAINER);


        //FluidStorage.SIDED.registerSelf(LIQUID_BARREL_CONTAINER);
        //FluidStorage.SIDED.registerSelf(JAR_CONTAINER);
        //FluidStorage.SIDED.registerSelf(GLAZED_JAR_0_CONTAINER);

        ItemStorage.SIDED.registerSelf(POT_CONTAINER);
        ItemStorage.SIDED.registerSelf(GLAZED_POT_0_CONTAINER);
        ItemStorage.SIDED.registerSelf(GLAZED_POT_1_CONTAINER);
        ItemStorage.SIDED.registerSelf(GLAZED_POT_2_CONTAINER);
        ItemStorage.SIDED.registerSelf(GLAZED_POT_3_CONTAINER);
        ItemStorage.SIDED.registerSelf(GLAZED_POT_4_CONTAINER);


        ModBlockItems.LIQUID_BARREL_ITEM.registerItemApi();
        ModBlockItems.FIRED_JAR_ITEM.registerItemApi();
    }

    private static <T extends BlockEntity>BlockEntityType<T> register (String name, Block block, FabricBlockEntityTypeBuilder.Factory<T> factory)
    {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new ResourceLocation(Rusticated.MOD_ID, name), FabricBlockEntityTypeBuilder.create(factory, block).build(null));
    }
}
