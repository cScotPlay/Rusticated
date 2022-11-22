package net.mcs3.elixiremporium.world.level.block.crop;

import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
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
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class ModMushroomBlock extends CropBlock
{
    public static ItemLike MUSHROOMTYPE;
    public static TagKey<Block> MUSHROOMBASE;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(3.0, 0.0, 3.0, 13.0, 9.0, 13.0),
            Block.box(3.0, 0.0, 3.0, 14.0, 11.0, 14.0),
            Block.box(0.0, 0.0, 0.0, 14.0, 13.0, 14.0),
            Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0)};

    public ModMushroomBlock(TagKey<Block> plantOnBlock) {
        super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().lightLevel((blockStatex) -> {
            return 8;
        }).instabreak().sound(SoundType.CROP));
        this.MUSHROOMTYPE = getMushroomdBase();
        this.MUSHROOMBASE = plantOnBlock;
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(this.getAgeProperty(), 0));

    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
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
        return state.is(MUSHROOMBASE);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockPos = pos.below();
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.is(MUSHROOMBASE)) {
            return true;
        }
        return level.getRawBrightness(pos, 0) < 13 && this.mayPlaceOn(blockState, level, blockPos);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(MUSHROOMTYPE);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit)
    {
        int age = state.getValue(AGE);
        ItemStack heldItem = player.getItemInHand(hand);

        if (age > 0 && heldItem.getItem() instanceof ShearsItem)
        {
            level.playSound(null, pos, SoundEvents.MOOSHROOM_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.setBlock(pos, state.setValue(AGE, 0), 2);
            int n = new Random().nextInt(1,3);
            for (int i = 1; i <= n; ++i) {
                Block.popResource(level, pos, getMushroomdBase().asItem().getDefaultInstance());
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
    public int getMaxAge() {
        return 3;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    private ItemLike getMushroomdBase()
    {
        if(this == ModBlocks.NIGHTSHROOM) return ModItems.NIGHTSHROOM;
        if(this == ModBlocks.GREEN_SPORED_ASBESTOS) return ModItems.GREEN_SPORED_ASBESTOS;
        else return null;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return MUSHROOMTYPE;
    }
}
