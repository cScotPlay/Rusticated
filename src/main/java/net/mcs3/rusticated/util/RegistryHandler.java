package net.mcs3.rusticated.util;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.data.worldgen.features.ModTreeFeatures;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModItems;
import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.mcs3.rusticated.init.ModFluids;
import net.mcs3.rusticated.world.level.levelgen.WorldGeneration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistryHandler
{
    private static final Logger LOGGER = Rusticated.LOGGER;

    public static void onBlockRegistry()
    {
        ModBlocks.init();
        //LOGGER.info("Rusticated Blocks Registered");
    }

    public static void onItemRegistry()
    {
        ModItems.init();
        //LOGGER.info("Rusticated Items Registered");
    }

    public static void onBlockEntityRegistry()
    {
        ModBlockEntityTypes.init();
    }

    public static void onFluidRegistry() {
        ModFluids.init();
    }

    public static void onTreeFeatureRegistry() {
        ModTreeFeatures.init();
    }

    public static void onGenerateWorldRegistry() {
        WorldGeneration.generateWorld();
    }
}
