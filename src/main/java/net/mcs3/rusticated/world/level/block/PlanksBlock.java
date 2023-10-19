package net.mcs3.rusticated.world.level.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class PlanksBlock extends Block {

    public PlanksBlock(MapColor color) {
        super(Properties.of().mapColor(color)
                .strength(2.0f, 3.0f)
                .sound(SoundType.WOOD));
    }
}
