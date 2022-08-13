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

        instance.add(BlockTags.PLANKS, 5, 20);
        instance.add(BlockTags.WOODEN_STAIRS, 5, 20);
        instance.add(BlockTags.WOODEN_SLABS, 5, 20);

        instance.add(ModBlockTags.FRAMED_WALLS, 10, 30);

        instance.add(ModBlockTags.IRONWOOD_LOGS, 5, 5);
        instance.add(ModBlocks.IRONWOOD_LEAVES, 30, 60);

    }
}
