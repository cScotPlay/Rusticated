package net.mcs3.elixiremporium.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.tags.ModItemTags;
import net.mcs3.elixiremporium.world.level.block.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.SlabBlock;

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
                ModBlocks.LIQUID_BARREL
        );

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(registry.stream().filter(b -> b instanceof FramedWallBlocks).sorted(Comparator.comparing(Block::getDescriptionId)).toArray(Block[]::new));
    }
}
