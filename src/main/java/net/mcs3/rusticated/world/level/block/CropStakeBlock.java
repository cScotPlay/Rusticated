package net.mcs3.rusticated.world.level.block;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.world.item.ModItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CropStakeBlock extends Block
{
    protected static final VoxelShape CROP_SHAPE = Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0);

    public static final Material CROP_STAKE_MATERIAL = new Material(MaterialColor.WOOD, false, false,true, false, true, false, PushReaction.NORMAL);


    public CropStakeBlock()
    {
        super(BlockBehaviour.Properties.of(CROP_STAKE_MATERIAL).requiresCorrectToolForDrops().strength(2.0F, 5.0F).sound(SoundType.WOOD));
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return CROP_SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        if (!level.isClientSide)
        {
            ItemStack itemStack = player.getItemInHand(hand);
            if (itemStack.getItem() instanceof ModItem)//TODO update for Crops
            {
                Rusticated.LOGGER.info("Added Crops to Crop Stake");
                //return InteractionResult.SUCCESS;
            }
            else if (itemStack.is(ModBlocks.ROPE.asItem()))
            {
                level.setBlock(pos, ModBlocks.TIED_STAKE.defaultBlockState(), 0);
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(state, level, pos, player, hand, hit);
    }
}
