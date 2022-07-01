package net.mcs3.elixiremporium;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElixirEmporium implements ModInitializer {

	public static final String MOD_ID = "elixiremporium";
	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(MOD_ID);
	public static ElixirEmporium INSTANCE;

	public static ItemGroup ITEMGROUP = FabricItemGroupBuilder.build(
			new Identifier("elixiremporium", "item_group"),
			() -> new ItemStack(Items.WHEAT)); //TODO Update Item

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}
