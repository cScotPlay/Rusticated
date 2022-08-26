package net.mcs3.elixiremporium.world.level.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.tags.ModBlockTags;
import net.minecraft.tags.BlockTags;

public class ModFireBlock
{
    public static void registerFlammableBlock()
    {
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(ModBlockTags.FLAMMABLE_BLOCK, 5, 20);

        instance.add(ModBlockTags.FRAMED_WALLS, 10, 30);

        instance.add(ModBlockTags.IRONWOOD_LOGS, 5, 5);
        instance.add(ModBlocks.IRONWOOD_LEAVES, 30, 60);

        instance.add(ModBlockTags.OLIVE_LOGS, 5, 5);
        instance.add(ModBlocks.OLIVE_LEAVES, 30, 60);

        instance.add(ModBlocks.ROPE, 20, 60);
        instance.add(ModBlocks.ROPE, 5, 20);

        instance.add(ModBlocks.GRAPE_STEM, 20, 100);
        instance.add(ModBlocks.GRAPE_LEAVES, 30, 60);

    }
}
