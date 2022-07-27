package net.mcs3.elixiremporium.world.level.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModChainBlock extends ChainBlock
{
    public ModChainBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(WATERLOGGED, false)).setValue(AXIS, Direction.Axis.Y));
    }
}
