package net.mcs3.elixiremporium.data.tags;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags
{
    public static final TagKey<Block> FRAMED_WALLS = create("framed_walls");
    public static final TagKey<Block> IRONWOOD_LOGS = create("ironwood_logs");
    public static final TagKey<Block> OLIVE_LOGS = create("olive_logs");
    public static final TagKey<Block> FLAMMABLE_BLOCK = create("flammable_block");
    public static final TagKey<Block> HERBS = create("herbs");

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(ElixirEmporium.MOD_ID, name));
    }
}