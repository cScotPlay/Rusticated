package net.mcs3.rusticated.world.level.block.crop;

import net.mcs3.rusticated.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AloeVeraBlock extends CropBlock
{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(7.0, 0.0, 7.0, 10.0, 3.0, 10.0),
            Block.box(3.0, 0.0, 3.0, 14.0, 8.0, 14.0),
            Block.box(3.0, 0.0, 3.0, 14.0, 8.0, 14.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0)};

    public AloeVeraBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(this.getAgeProperty(), 0));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (state.getValue(AGE) == getMaxAge())
        {
            level.setBlock(pos, this.defaultBlockState().setValue(AGE, 0), 3);
            Block.popResource(level, pos, getSeedBase().asItem().getDefaultInstance());
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    private ItemLike getSeedBase()
    {
        return ModItems.ALOE_VERA;
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
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        float f;
        int i;
        if (serverLevel.getRawBrightness(blockPos, 0) >= 9 && (i = this.getAge(blockState)) < this.getMaxAge() && randomSource.nextInt((int)(25.0f / (f = this.getGrowthSpeed(this, serverLevel, blockPos))) + 1) == 0) {
            serverLevel.setBlock(blockPos, this.getStateForAge(i + 1), 2);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.below();
        return this.mayPlaceOn(level.getBlockState(blockPos), level, blockPos);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos)
    {
        return state.is(BlockTags.SAND);
    }

    protected static float getGrowthSpeed(Block block, BlockGetter level, BlockPos pos)
    {
        return 4F;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.ALOE_VERA;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
