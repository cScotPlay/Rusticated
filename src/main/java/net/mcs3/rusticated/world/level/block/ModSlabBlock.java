package net.mcs3.rusticated.world.level.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class ModSlabBlock extends SlabBlock
{

    public ModSlabBlock(MaterialColor color) {
        super(FabricBlockSettings.of(Material.WOOD, color)
                .strength(2.0f, 3.0f)
                .sounds(SoundType.WOOD));
    }
}
