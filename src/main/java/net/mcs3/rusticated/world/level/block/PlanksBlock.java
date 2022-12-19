package net.mcs3.rusticated.world.level.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class PlanksBlock extends Block {

    public PlanksBlock(MaterialColor color) {
        super(Properties.of(Material.WOOD, color)
                .strength(2.0f, 3.0f)
                .sound(SoundType.WOOD));
    }
}
