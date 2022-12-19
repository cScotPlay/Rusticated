package net.mcs3.rusticated.util;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModItems;
import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.mcs3.rusticated.world.level.material.ModFluids;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistryHandler
{
    private static final Logger LOGGER = LogManager.getLogger(Rusticated.MOD_ID);

    public static void onBlockRegistry()
    {
        ModBlocks.init();

        LOGGER.info("Rusticated Blocks Registered");
    }

    public static void onItemRegistry()
    {
        ModItems.init();
        LOGGER.info("Rusticated Items Registered");
    }

    public static void onBlockEntityRegistry()
    {
        ModBlockEntityTypes.init();
    }

    public static void onFluidRegistry() {
        ModFluids.init();
    }
}
