package net.mcs3.elixiremporium.init;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.world.food.ModFoodProperties;
import net.mcs3.elixiremporium.world.item.LiquidBarrelItem;
import net.mcs3.elixiremporium.world.item.ModBookItem;
import net.mcs3.elixiremporium.world.item.ModItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class ModItems
{
    public static final Map<ResourceLocation, Item> ITEMS = new HashMap<>();

    public static CreativeModeTab DECORATION_TAB = ElixirEmporium.ITEMGROUPDECO;
    public static CreativeModeTab AG_TAB = ElixirEmporium.ITEMGROUPAG;


    public static Item CATALOG = new ModBookItem();
    public static Item OLIVES = new ModItem(new Item.Properties().tab(AG_TAB).food(ModFoodProperties.OLIVES));

    public static Item COPPER_NUGGET = new ModItem(new Item.Properties().tab(DECORATION_TAB));


    public static void init()
    {
        register("catalog", CATALOG);
        register("olives", OLIVES);
        register("copper_nugget", COPPER_NUGGET);

    }

    static <T extends Item> T register(String name, T anyItem)
    {
        ITEMS.put(new ResourceLocation(ElixirEmporium.MOD_ID, name), anyItem);
        Registry.register(Registry.ITEM, new ResourceLocation(ElixirEmporium.MOD_ID, name), anyItem);

        return anyItem;
    }
}