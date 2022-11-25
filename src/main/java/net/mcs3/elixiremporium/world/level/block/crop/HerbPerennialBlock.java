package net.mcs3.elixiremporium.world.level.block.crop;

import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class HerbPerennialBlock extends CropBlock
{
    public static ItemLike SEED;
    public static TagKey<Block> PLANTBASE;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(7.0, 0.0, 7.0, 10.0, 3.0, 10.0),
            Block.box(3.0, 0.0, 3.0, 14.0, 8.0, 14.0),
            Block.box(3.0, 0.0, 3.0, 14.0, 8.0, 14.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0)};

    public HerbPerennialBlock(/*ItemLike seedItem, */TagKey<Block> plantOnBlock) {
        super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
        //this.SEED = seedItem;
        this.SEED = getSeedBase();
        this.PLANTBASE = plantOnBlock;
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

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity)) {
            return;
        }

        if(this == ModBlocks.WIND_THISTLE){
            entity.makeStuckInBlock(state, new Vec3(0.8f, 0.75, 0.8f));
            if (!(level.isClientSide || state.getValue(AGE) <= 2 || entity.xOld == entity.getX() && entity.zOld == entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.xOld);
                double e = Math.abs(entity.getZ() - entity.zOld);
                if (d >= (double)0.003f || e >= (double)0.003f) {
                    entity.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0f);
                }
            }
        }
    }

    private ItemLike getSeedBase()
    {
        if(this == ModBlocks.BLOOD_ORCHID) return ModItems.BLOOD_ORCHID;
        if(this == ModBlocks.CHAMOMILE) return ModItems.CHAMOMILE;
        if(this == ModBlocks.CLOUD_LILY) return ModItems.CLOUD_LILY;
        if(this == ModBlocks.COHOSH) return ModItems.COHOSH;
        if(this == ModBlocks.HORSETAIL) return ModItems.HORSETAIL;
        if(this == ModBlocks.WIND_THISTLE) return ModItems.WIND_THISTLE;
        else return null;
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
        if (level.getRawBrightness(pos, 0) >= 9 && (i = this.getAge(state)) < this.getMaxAge() && random.nextInt((int)(25.0f / (f = this.getGrowthSpeed(this, level, pos))) + 1) == 0) {
            level.setBlock(pos, this.getStateForAge(i + 1), 2);
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
        //return state.isSolidRender(level, pos);
        return state.is(PLANTBASE);
    }

    protected static float getGrowthSpeed(Block block, BlockGetter level, BlockPos pos)
    {
        return 4F;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return SEED;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
