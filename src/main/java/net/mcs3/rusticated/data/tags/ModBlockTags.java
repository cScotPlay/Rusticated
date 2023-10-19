package net.mcs3.rusticated.data.tags;

import net.mcs3.rusticated.Rusticated;
import net.minecraft.core.registries.Registries;
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
        return TagKey.create(Registries.BLOCK, new ResourceLocation(Rusticated.MOD_ID, name));
    }
}
