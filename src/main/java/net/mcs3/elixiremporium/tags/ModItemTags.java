package net.mcs3.elixiremporium.tags;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags
{
    public static final TagKey<Item> JARS = modItem("jars");
    public static final TagKey<Item> COLORED_COBBLESTONE = modItem("colored_cobblestone");
    public static final TagKey<Item> COLORED_COBBLESTONE_SLAB = modItem("colored_cobblestone_slab");
    public static final TagKey<Item> COLORED_COBBLESTONE_STAIRS = modItem("colored_cobblestone_stairs");
    public static final TagKey<Item> COLORED_COBBLESTONE_WALL = modItem("colored_cobblestone_wall");


    public static TagKey<Item> modItem(String path) {
        return TagKey.create(Registry.ITEM.key(), new ResourceLocation(ElixirEmporium.MOD_ID, path));
    }
}
