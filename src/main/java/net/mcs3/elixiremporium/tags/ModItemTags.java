package net.mcs3.elixiremporium.tags;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

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


    public static TagKey<Item> modItem(String path) {
        return TagKey.create(Registry.ITEM.key(), new ResourceLocation(ElixirEmporium.MOD_ID, path));
    }
}
