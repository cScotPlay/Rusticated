package net.mcs3.elixiremporium.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.tags.ModBlockTags;
import net.mcs3.elixiremporium.world.level.block.*;
import net.mcs3.elixiremporium.world.level.block.crop.HerbPerennialBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChainBlock;

import java.util.Comparator;
import java.util.function.Predicate;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider
{
    protected final Predicate<Block> BLOCKS = registry -> ElixirEmporium.MOD_ID.equals(registry.asItem().toString());

    public BlockTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags()
    {
        // ***************************************************************************** //
        //  Vanilla Tags
        // ***************************************************************************** //
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(registry.stream().filter(b -> b instanceof PlanksBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(registry.stream().filter(b -> b instanceof ModStairsBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(registry.stream().filter(b -> b instanceof ColoredStoneStairBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(registry.stream().filter(b -> b instanceof ModStairsBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(registry.stream().filter(b -> b instanceof ModSlabBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(registry.stream().filter(b -> b instanceof ColoredStoneSlabBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(registry.stream().filter(b -> b instanceof ModSlabBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(registry.stream().filter(b -> b instanceof ColoredStoneWallBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(registry.stream().filter(b -> b instanceof ModChainBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(registry.stream().filter(b -> b instanceof WeatheringCopperChainBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.CLIMBABLE).add(
                ModBlocks.ROPE,
                ModBlocks.TIED_STAKE,
                ModBlocks.IRON_LATTICE);

        getOrCreateTagBuilder(BlockTags.CLIMBABLE)
                .add(registry.stream().filter(b -> b instanceof TiedStakeBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.SAPLINGS).add(
                ModBlocks.IRONWOOD_SAPLING,
                ModBlocks.OLIVE_SAPLING);

        getOrCreateTagBuilder(BlockTags.LEAVES).add(
                ModBlocks.IRONWOOD_LEAVES,
                ModBlocks.OLIVE_LEAVES);

        getOrCreateTagBuilder(BlockTags.LOGS).add(
                ModBlocks.IRONWOOD_LOG,
                ModBlocks.OLIVE_LOG);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(
                ModBlockTags.IRONWOOD_LOGS);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(
                ModBlockTags.OLIVE_LOGS);

        getOrCreateTagBuilder(BlockTags.FENCES).add(
                ModBlocks.IRONWOOD_FENCE,
                ModBlocks.OLIVE_FENCE);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(
                ModBlocks.IRONWOOD_FENCE,
                ModBlocks.OLIVE_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(
                ModBlocks.IRONWOOD_GATE,
                ModBlocks.OLIVE_GATE);


        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof PathBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof ChandelierBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof ChainBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof WeatheringCopperChainBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof ColoredStoneBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof ColoredStoneSlabBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof ColoredStoneStairBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof ColoredStoneWallBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof LatticeBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(
                ModBlocks.CHANDELIER_WAXED_COPPER,
                ModBlocks.CHANDELIER_WAXED_EXPOSED_COPPER,
                ModBlocks.CHANDELIER_WAXED_WEATHERED_COPPER,
                ModBlocks.CHANDELIER_WAXED_OXIDIZED_COPPER);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(registry.stream().filter(b -> b instanceof WeatheringCopperChandelierBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));


        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE).add(
                ModBlocks.BARREL,
                ModBlocks.LIQUID_BARREL,
                ModBlocks.CROP_STAKE,
                ModBlocks.TIED_STAKE
        );

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(registry.stream().filter(b -> b instanceof FramedWallBlocks).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(
                ModBlocks.FERTILE_SOIL
        );

        getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK).add(
                ModBlocks.FERTILE_SOIL
        );

        // ***************************************************************************** //
        //  Modded Tags
        // ***************************************************************************** //
        getOrCreateTagBuilder(ModBlockTags.IRONWOOD_LOGS).add(
                ModBlocks.IRONWOOD_LOG,
                ModBlocks.IRONWOOD_WOOD,
                ModBlocks.STRIPPED_IRONWOOD_LOG,
                ModBlocks.STRIPPED_IRONWOOD_WOOD);

        getOrCreateTagBuilder(ModBlockTags.OLIVE_LOGS).add(
                ModBlocks.OLIVE_LOG,
                ModBlocks.OLIVE_WOOD,
                ModBlocks.STRIPPED_OLIVE_LOG,
                ModBlocks.STRIPPED_OLIVE_WOOD);

        getOrCreateTagBuilder(ModBlockTags.FRAMED_WALLS)
                .add(registry.stream().filter(b -> b instanceof FramedWallBlocks).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(ModBlockTags.FLAMMABLE_BLOCK)
                .add(registry.stream().filter(b -> b instanceof PlanksBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(ModBlockTags.FLAMMABLE_BLOCK)
                .add(registry.stream().filter(b -> b instanceof ModStairsBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(ModBlockTags.FLAMMABLE_BLOCK)
                .add(registry.stream().filter(b -> b instanceof ModSlabBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

        getOrCreateTagBuilder(ModBlockTags.HERBS)
                .add(registry.stream().filter(b -> b instanceof HerbPerennialBlock).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));

    }
}
