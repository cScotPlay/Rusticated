package net.mcs3.elixiremporium.world.level.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class ModMushroomBlock extends BushBlock implements BonemealableBlock
{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final int MAX_AGE = 3;
    protected static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D),
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D),
            Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D),
    };

    private final Item mushroomType;


    public ModMushroomBlock(Properties properties, Item mushroomType) {
        super(properties);
        this.mushroomType = mushroomType;
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(AGE, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(AGE);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random)
    {
        super.randomTick(state, level, pos, random);
        int age = state.getValue(AGE);
        BlockState groundState = level.getBlockState(pos.below());
        if(age < MAX_AGE && groundState.is(BlockTags.MUSHROOM_GROW_BLOCK) && level.getRawBrightness(pos.above(), 0) <= 12 && random.nextInt(5) == 0)
        {
            level.setBlock(pos, state.setValue(AGE, age + 1), 2);
        }
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.MUSHROOM_GROW_BLOCK);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.below();
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        }
        return level.getRawBrightness(pos, 0) < 13 && this.mayPlaceOn(blockState, level, blockPos);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean isClient) {
        return !this.AGE.equals(AGE);
    }

    @Override
    public boolean isBonemealSuccess(Level level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, Random random, BlockPos pos, BlockState state)
    {
        int age = Math.min(3, state.getValue(AGE) + 1);
        level.setBlock(pos, state.setValue(AGE, age), 2);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(mushroomType);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        int age = state.getValue(AGE);
        ItemStack heldItem = player.getItemInHand(hand);

        if (age > 0 && heldItem.getItem() instanceof ShearsItem)
        {
            Block.popResource(level, pos, getCloneItemStack(level, pos, state));
            level.playSound(null, pos, SoundEvents.MOOSHROOM_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.setBlock(pos, state.setValue(AGE, 0), 2);
            if (!level.isClientSide)
            {
                heldItem.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(hand));
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
}
