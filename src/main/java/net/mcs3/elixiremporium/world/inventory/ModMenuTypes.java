package net.mcs3.elixiremporium.world.inventory;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;

import java.util.Scanner;


public class ModMenuTypes
{
    public static MenuType<CondenserMenu> CONDENSER_MENU_TYPE;

    public static void registerAllMenuTypes()
    {
        CONDENSER_MENU_TYPE = Registry.register(Registry.MENU, new ResourceLocation(ElixirEmporium.MOD_ID, "condenser_menu_type"), new MenuType<>(CondenserMenu::new));

    }

}
