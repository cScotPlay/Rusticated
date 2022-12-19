package net.mcs3.rusticated.world.level.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class FramedWallBlocks extends Block
{
    public FramedWallBlocks(Properties properties) {
        super(properties.requiresCorrectToolForDrops().strength(2.0F, 3.0F).sound(SoundType.WOOD));
    }
}
