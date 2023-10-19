package net.mcs3.rusticated;

import net.fabricmc.api.ModInitializer;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModCompostable;
import net.mcs3.rusticated.init.ModFluids;
import net.mcs3.rusticated.init.ModItems;
import net.mcs3.rusticated.util.RegistryHandler;
import net.mcs3.rusticated.world.effect.ModEffects;
import net.mcs3.rusticated.world.inventory.ModMenuTypes;
import net.mcs3.rusticated.world.item.alchmey.Elixirs;
import net.mcs3.rusticated.world.item.alchmey.ModPotions;
import net.mcs3.rusticated.world.item.crafting.ModRecipes;
import net.mcs3.rusticated.world.item.creativetabs.RusticatedCreativeTabs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import org.apache.logging.log4j.LogManager;

public class Rusticated implements ModInitializer {

	public static final String MOD_ID = "rusticated";
	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static Rusticated INSTANCE;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		INSTANCE = this;
		LOGGER.info("Loading Rusticated");

		RusticatedCreativeTabs.registerItemGroup();
		Elixirs.initElixirs();


		RegistryHandler.onBlockRegistry();
		RegistryHandler.onFluidRegistry();
		RegistryHandler.onItemRegistry();

		RegistryHandler.onBlockEntityRegistry();

		RegistryHandler.onGenerateWorldRegistry();

		ModEffects.registerEffects();
		ModPotions.registerPotions();



		ModMenuTypes.registerAllMenuTypes();



		ModCompostable.registerCompostables();
		Elixirs.initElixirs();
		ModRecipes.onRecipeRegistry();

		LOGGER.info("Rusticated Successfully Loaded");
	}

	public static String loc (String name) {
		return "rusticated:" + name;
	}
}
