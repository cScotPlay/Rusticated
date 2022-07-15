package net.mcs3.elixiremporium.world.level.block;

import net.mcs3.elixiremporium.util.CopperStateMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ModBlock extends Block
{
    public ModBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
    {
        var stack = player.getItemInHand(hand);
        if (stack.getItem() instanceof AxeItem)
        {
            var block = CopperStateMap.getUnwaxed(state.getBlock());
            if (block.isPresent()) {
                world.setBlock(pos, block.map(b -> b.withPropertiesOf(state)).get(), 11);
                world.levelEvent(player, 3003, pos, 0);
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer) player, pos, stack);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
