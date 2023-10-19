package net.mcs3.rusticated.world.inventory;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.mcs3.rusticated.Rusticated;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;


public class ModMenuTypes
{
    public static MenuType<CondenserMenu> CONDENSER_MENU_TYPE = new ExtendedScreenHandlerType<>(CondenserMenu::new);
    public static MenuType<AdvCondenserMenu> ADV_CONDENSER_MENU_TYPE = new ExtendedScreenHandlerType<>(AdvCondenserMenu::new);
    public static MenuType<BrewingBarrelMenu> BREWING_BARREL_MENU_TYPE = new ExtendedScreenHandlerType<>(BrewingBarrelMenu::new);

    public static void registerAllMenuTypes()
    {
        Registry.register(BuiltInRegistries.MENU, new ResourceLocation(Rusticated.MOD_ID, "condenser_menu_type"), CONDENSER_MENU_TYPE);
        Registry.register(BuiltInRegistries.MENU, new ResourceLocation(Rusticated.MOD_ID, "adv_condenser_menu_type"), ADV_CONDENSER_MENU_TYPE);
        Registry.register(BuiltInRegistries.MENU, new ResourceLocation(Rusticated.MOD_ID, "brewing_barrel_menu_type"), BREWING_BARREL_MENU_TYPE);
    }
}
