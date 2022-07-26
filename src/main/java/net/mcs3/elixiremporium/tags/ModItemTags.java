package net.mcs3.elixiremporium.tags;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags
{
    public static final TagKey<Item> JARS = modItem("jars");


    public static TagKey<Item> modItem(String path) {
        return TagKey.create(Registry.ITEM.key(), new ResourceLocation(ElixirEmporium.MOD_ID, path));
    }
}
