package net.mcs3.rusticated.world.level.block.crop;

import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class RootBlock extends CropBlock
{
    public static ItemLike ROOT;
    public static TagKey<Block> ROOTBASE;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(7.0, 0.0, 7.0, 10.0, 3.0, 10.0),
            Block.box(6.0, 0.0, 6.0, 10.0, 4.0, 10.0),
            Block.box(6.0, 0.0, 6.0, 10.0, 4.0, 10.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0)};

    public RootBlock(TagKey<Block> plantOnBlock)
    {
        super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.ROOTS));
        this.ROOT = getRootBase();
        this.ROOTBASE = plantOnBlock;
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(this.getAgeProperty(), 0));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        int age = state.getValue(AGE);
        ItemStack heldItem = player.getItemInHand(hand);

        if (age > 0 && heldItem.getItem() instanceof ShearsItem)
        {
            level.playSound(null, pos, SoundEvents.ROOTS_BREAK, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.setBlock(pos, state.setValue(AGE, 0), 2);
            int n = new Random().nextInt(1,3);
            for (int i = 1; i <= n; ++i) {
                Block.popResource(level, pos, getRootBase().asItem().getDefaultInstance());
            }
            if (!level.isClientSide)
            {
                heldItem.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(hand));
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
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
        return state.isSolidRender(level, pos);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ROOT;
    }

    private ItemLike getRootBase()
    {
        if(this == ModBlocks.CORE_ROOT) return ModItems.CORE_ROOT;
        if(this == ModBlocks.GINSENG) return ModItems.GINSENG;
        if(this == ModBlocks.MARSHMALLOW) return ModItems.MARSHMALLOW;
        else return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
