package net.mcs3.rusticated.data.tags;

import net.mcs3.rusticated.Rusticated;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags
{
    public static final TagKey<Item> JARS = modItem("jars");
    public static final TagKey<Item> POTS = modItem("pots");

    public static final TagKey<Item> COLORED_COBBLESTONE = modItem("colored_cobblestone");
    public static final TagKey<Item> COLORED_COBBLESTONE_SLAB = modItem("colored_cobblestone_slab");
    public static final TagKey<Item> COLORED_COBBLESTONE_STAIRS = modItem("colored_cobblestone_stairs");
    public static final TagKey<Item> COLORED_COBBLESTONE_WALL = modItem("colored_cobblestone_wall");

    public static final TagKey<Item> COLORED_STONE = modItem("colored_stone");
    public static final TagKey<Item> COLORED_STONE_SLAB = modItem("colored_stone_slab");
    public static final TagKey<Item> COLORED_STONE_STAIRS = modItem("colored_stone_stairs");

    public static final TagKey<Item> IRONWOOD_LOGS = modItem("ironwood_logs");
    public static final TagKey<Item> OLIVE_LOGS = modItem("olive_logs");

    public static final TagKey<Item> HERBS = modItem("herbs");
    public static final TagKey<Item> ELIXIR = modItem("elixir");

    public static final TagKey<Item> BREWING_FLUID = modItem("brewing_fluid");
    public static final TagKey<Item> BOOZE_ITEMS = modItem("booze_items");
    public static final TagKey<Item> FLUID_BOTTLES = modItem("fluid_bottles");


    public static TagKey<Item> modItem(String path) {
        return TagKey.create(Registry.ITEM.key(), new ResourceLocation(Rusticated.MOD_ID, path));
    }
}
