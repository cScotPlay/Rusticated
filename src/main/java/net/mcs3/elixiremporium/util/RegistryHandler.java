package net.mcs3.elixiremporium.util;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModItems;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class RegistryHandler
{
    private static final Logger LOGGER = LogManager.getLogger(ElixirEmporium.MOD_ID);

    public static void onBlockRegistry()
    {
        ModBlocks.init();

        LOGGER.info("Elixir Blocks Registered");
    }

    public static void onItemRegistry()
    {
        ModItems.init();
        LOGGER.info("Elixir Items Registered");
    }

    public static void onBlockEntityRegistry()
    {
        ModBlockEntityTypes.init();
    }
}
