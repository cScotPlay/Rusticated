package net.mcs3.elixiremporium.world.menu;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;

//TODO Erase if not needed
public class ModMenuTypes
{
    public static MenuType<BarrelMenu> BARREL_MENU_TYPE;

    public static void init()
    {
        BARREL_MENU_TYPE = ScreenHandlerRegistry.registerSimple(new ResourceLocation(ElixirEmporium.MOD_ID, "barrel_menu"), BarrelMenu::new);

    }
}
