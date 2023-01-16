package net.mcs3.rusticated.world.level.block.crop;

import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModItems;
import net.mcs3.rusticated.world.level.block.RopeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class GrapeStemBlock extends CropBlock
{
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(7.0, 0.0, 7.0, 9.0, 3.0, 9.0),
            Block.box(6.0, 0.0, 6.0, 10.0, 9.0, 10.0),
            Block.box(6.0, 0.0, 6.0, 10.0, 15.0, 10.0),
            Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0)};


    public GrapeStemBlock() {
        super(BlockBehaviour.Properties.of(Material.PLANT).strength(0.5F).randomTicks().sound(SoundType.CROP));
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(getAgeProperty(), 0));
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        float f;
        int i;
        if (level.getRawBrightness(pos, 0) >= 9 && (i = this.getAge(state)) < this.getMaxAge() && random.nextInt((int)(25.0f / (f = getGrowthSpeed(this, level, pos))) + 1) == 0) {
            level.setBlock(pos, this.getStateForAge(i + 1), 2);
            if(state.getValue(AGE) == 2)
            {
                Direction.Axis axis = level.getBlockState(pos.above()).getValue(RopeBlock.AXIS);
                level.setBlock(pos.above(), ModBlocks.GRAPE_LEAVES.defaultBlockState().setValue(GrapeLeavesBlock.AXIS, axis).setValue(GrapeLeavesBlock.DISTANCE, 0), 3);
            }
        }
    }

    @Override
    public void growCrops(Level level, BlockPos pos, BlockState state) {
        int j;
        int i = this.getAge(state) + this.getBonemealAgeIncrease(level);
        if (i > (j = this.getMaxAge())) {
            i = j;
        }
        level.setBlock(pos, this.getStateForAge(i), 2);
        Direction.Axis axis = level.getBlockState(pos.above()).getValue(RopeBlock.AXIS);
        level.setBlock(pos.above(), ModBlocks.GRAPE_LEAVES.defaultBlockState().setValue(GrapeLeavesBlock.DISTANCE, 0).setValue(GrapeLeavesBlock.AXIS, axis), 3);

    }

    protected static float getGrowthSpeed(Block block, BlockGetter level, BlockPos pos)
    {
        return 7F;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return (level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos)) && (level.getBlockState(pos.above()).getBlock() instanceof RopeBlock || level.getBlockState(pos.above()).getBlock() instanceof LeavesBlock) && super.canSurvive(state, level, pos);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.GRAPE_SEEDS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
