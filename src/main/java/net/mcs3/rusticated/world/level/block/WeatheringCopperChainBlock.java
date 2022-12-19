package net.mcs3.rusticated.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class WeatheringCopperChainBlock extends ChainBlock implements WeatheringCopper
{
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperChainBlock(WeatheringCopper.WeatherState weatherState, BlockBehaviour.Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
    this.onRandomTick(state, level, pos, random);
}

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return WeatheringCopper.getNext(state.getBlock()).isPresent();
    }

    public WeatherState getAge() {
        return this.weatherState;
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        ItemStack heldItemStack = player.getMainHandItem();
        Item heldItem = heldItemStack.getItem();
        Item chain = this.asItem();

        if(heldItem == chain){
            Boolean isChain = true;
            Block currentBlock = this;
            BlockPos currentPos = pos;
            while (isChain)
            {
                currentPos = currentPos.below();
                currentBlock = level.getBlockState(currentPos).getBlock();

                if(currentBlock != this)
                {
                    isChain = false;
                }
            }
            if (currentBlock != Blocks.AIR)
                return InteractionResult.FAIL;
            else
            {
                int heldItemStackCount = heldItemStack.getCount() - 1;
                ItemStack newHeldItemStack = new ItemStack(heldItem, heldItemStackCount);
                level.setBlockAndUpdate(currentPos, this.defaultBlockState());
                level.playSound(player, pos, SoundType.CHAIN.getPlaceSound(), SoundSource.BLOCKS, soundType.getVolume() + 1.0F, soundType.getPitch() * 0.8F);
                player.setItemInHand(hand, newHeldItemStack);
                return InteractionResult.CONSUME;
            }
        }
        else
            return InteractionResult.FAIL;
    }


    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (!state.canSurvive(level, currentPos))
            return Blocks.AIR.defaultBlockState();
        else
            return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos)
    {
        int xPos = pos.getX();
        int yPos = pos.getY() + 1;
        int zPos = pos.getZ();
        BlockPos blockAbove = new BlockPos(xPos, yPos, zPos);
        Block block = level.getBlockState(blockAbove).getBlock();

        if(state.getValue(AXIS) == Direction.Axis.X || state.getValue(AXIS) == Direction.Axis.Z) return true;
        else if(block == Blocks.AIR) return false;

        return true;
    }
}
