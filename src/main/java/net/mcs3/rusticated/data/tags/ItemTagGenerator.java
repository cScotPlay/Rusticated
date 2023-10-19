package net.mcs3.rusticated.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mcs3.rusticated.init.ModBlockItems;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModFluids;
import net.mcs3.rusticated.init.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {


    public ItemTagGenerator(FabricDataOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);

    }


    @Override
    protected void addTags(HolderLookup.Provider arg) {

        // ***************************************************************************** //
        //  Vanilla Tags
        // ***************************************************************************** //
        getOrCreateTagBuilder(ItemTags.PLANKS).add(
                ModBlocks.PAINTED_PLANKS_WHITE.asItem(),
                ModBlocks.PAINTED_PLANKS_ORANGE.asItem(),
                ModBlocks.PAINTED_PLANKS_MAGENTA.asItem(),
                ModBlocks.PAINTED_PLANKS_LIGHT_BLUE.asItem(),
                ModBlocks.PAINTED_PLANKS_YELLOW.asItem(),
                ModBlocks.PAINTED_PLANKS_LIME.asItem(),
                ModBlocks.PAINTED_PLANKS_PINK.asItem(),
                ModBlocks.PAINTED_PLANKS_GRAY.asItem(),
                ModBlocks.PAINTED_PLANKS_LIGHT_GRAY.asItem(),
                ModBlocks.PAINTED_PLANKS_CYAN.asItem(),
                ModBlocks.PAINTED_PLANKS_PURPLE.asItem(),
                ModBlocks.PAINTED_PLANKS_BLUE.asItem(),
                ModBlocks.PAINTED_PLANKS_BROWN.asItem(),
                ModBlocks.PAINTED_PLANKS_GREEN.asItem(),
                ModBlocks.PAINTED_PLANKS_RED.asItem(),
                ModBlocks.PAINTED_PLANKS_BLACK.asItem(),
                ModBlocks.IRONWOOD_PLANKS.asItem(),
                ModBlocks.OLIVE_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(
                ModBlocks.PAINTED_STAIRS_WHITE.asItem(),
                ModBlocks.PAINTED_STAIRS_ORANGE.asItem(),
                ModBlocks.PAINTED_STAIRS_MAGENTA.asItem(),
                ModBlocks.PAINTED_STAIRS_LIGHT_BLUE.asItem(),
                ModBlocks.PAINTED_STAIRS_YELLOW.asItem(),
                ModBlocks.PAINTED_STAIRS_LIME.asItem(),
                ModBlocks.PAINTED_STAIRS_PINK.asItem(),
                ModBlocks.PAINTED_STAIRS_GRAY.asItem(),
                ModBlocks.PAINTED_STAIRS_LIGHT_GRAY.asItem(),
                ModBlocks.PAINTED_STAIRS_CYAN.asItem(),
                ModBlocks.PAINTED_STAIRS_PURPLE.asItem(),
                ModBlocks.PAINTED_STAIRS_BLUE.asItem(),
                ModBlocks.PAINTED_STAIRS_BROWN.asItem(),
                ModBlocks.PAINTED_STAIRS_GREEN.asItem(),
                ModBlocks.PAINTED_STAIRS_RED.asItem(),
                ModBlocks.PAINTED_STAIRS_BLACK.asItem(),
                ModBlocks.IRONWOOD_STAIRS.asItem(),
                ModBlocks.OLIVE_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(
                ModBlocks.PAINTED_SLAB_WHITE.asItem(),
                ModBlocks.PAINTED_SLAB_ORANGE.asItem(),
                ModBlocks.PAINTED_SLAB_MAGENTA.asItem(),
                ModBlocks.PAINTED_SLAB_LIGHT_BLUE.asItem(),
                ModBlocks.PAINTED_SLAB_YELLOW.asItem(),
                ModBlocks.PAINTED_SLAB_LIME.asItem(),
                ModBlocks.PAINTED_SLAB_PINK.asItem(),
                ModBlocks.PAINTED_SLAB_GRAY.asItem(),
                ModBlocks.PAINTED_SLAB_LIGHT_GRAY.asItem(),
                ModBlocks.PAINTED_SLAB_CYAN.asItem(),
                ModBlocks.PAINTED_SLAB_PURPLE.asItem(),
                ModBlocks.PAINTED_SLAB_BLUE.asItem(),
                ModBlocks.PAINTED_SLAB_BROWN.asItem(),
                ModBlocks.PAINTED_SLAB_GREEN.asItem(),
                ModBlocks.PAINTED_SLAB_RED.asItem(),
                ModBlocks.PAINTED_SLAB_BLACK.asItem(),
                ModBlocks.IRONWOOD_SLAB.asItem(),
                ModBlocks.OLIVE_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.STAIRS).add(
                ModBlocks.PAINTED_STAIRS_WHITE.asItem(),
                ModBlocks.PAINTED_STAIRS_ORANGE.asItem(),
                ModBlocks.PAINTED_STAIRS_MAGENTA.asItem(),
                ModBlocks.PAINTED_STAIRS_LIGHT_BLUE.asItem(),
                ModBlocks.PAINTED_STAIRS_YELLOW.asItem(),
                ModBlocks.PAINTED_STAIRS_LIME.asItem(),
                ModBlocks.PAINTED_STAIRS_PINK.asItem(),
                ModBlocks.PAINTED_STAIRS_GRAY.asItem(),
                ModBlocks.PAINTED_STAIRS_LIGHT_GRAY.asItem(),
                ModBlocks.PAINTED_STAIRS_CYAN.asItem(),
                ModBlocks.PAINTED_STAIRS_PURPLE.asItem(),
                ModBlocks.PAINTED_STAIRS_BLUE.asItem(),
                ModBlocks.PAINTED_STAIRS_BROWN.asItem(),
                ModBlocks.PAINTED_STAIRS_GREEN.asItem(),
                ModBlocks.PAINTED_STAIRS_RED.asItem(),
                ModBlocks.PAINTED_STAIRS_BLACK.asItem(),
                ModBlocks.STONE_STAIRS_WHITE.asItem(),
                ModBlocks.STONE_STAIRS_ORANGE.asItem(),
                ModBlocks.STONE_STAIRS_MAGENTA.asItem(),
                ModBlocks.STONE_STAIRS_LIGHT_BLUE.asItem(),
                ModBlocks.STONE_STAIRS_YELLOW.asItem(),
                ModBlocks.STONE_STAIRS_LIME.asItem(),
                ModBlocks.STONE_STAIRS_PINK.asItem(),
                ModBlocks.STONE_STAIRS_GRAY.asItem(),
                ModBlocks.STONE_STAIRS_LIGHT_GRAY.asItem(),
                ModBlocks.STONE_STAIRS_CYAN.asItem(),
                ModBlocks.STONE_STAIRS_PURPLE.asItem(),
                ModBlocks.STONE_STAIRS_BLUE.asItem(),
                ModBlocks.STONE_STAIRS_BROWN.asItem(),
                ModBlocks.STONE_STAIRS_GREEN.asItem(),
                ModBlocks.STONE_STAIRS_RED.asItem(),
                ModBlocks.STONE_STAIRS_BLACK.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_WHITE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_ORANGE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_MAGENTA.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_LIGHT_BLUE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_YELLOW.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_LIME.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_PINK.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_GRAY.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_LIGHT_GRAY.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_CYAN.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_PURPLE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_BLUE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_BROWN.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_GREEN.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_RED.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_BLACK.asItem(),
                ModBlocks.IRONWOOD_STAIRS.asItem(),
                ModBlocks.OLIVE_STAIRS.asItem());

        getOrCreateTagBuilder(ItemTags.SLABS).add(
                ModBlocks.PAINTED_SLAB_WHITE.asItem(),
                ModBlocks.PAINTED_SLAB_ORANGE.asItem(),
                ModBlocks.PAINTED_SLAB_MAGENTA.asItem(),
                ModBlocks.PAINTED_SLAB_LIGHT_BLUE.asItem(),
                ModBlocks.PAINTED_SLAB_YELLOW.asItem(),
                ModBlocks.PAINTED_SLAB_LIME.asItem(),
                ModBlocks.PAINTED_SLAB_PINK.asItem(),
                ModBlocks.PAINTED_SLAB_GRAY.asItem(),
                ModBlocks.PAINTED_SLAB_LIGHT_GRAY.asItem(),
                ModBlocks.PAINTED_SLAB_CYAN.asItem(),
                ModBlocks.PAINTED_SLAB_PURPLE.asItem(),
                ModBlocks.PAINTED_SLAB_BLUE.asItem(),
                ModBlocks.PAINTED_SLAB_BROWN.asItem(),
                ModBlocks.PAINTED_SLAB_GREEN.asItem(),
                ModBlocks.PAINTED_SLAB_RED.asItem(),
                ModBlocks.PAINTED_SLAB_BLACK.asItem(),
                ModBlocks.STONE_SLAB_WHITE.asItem(),
                ModBlocks.STONE_SLAB_ORANGE.asItem(),
                ModBlocks.STONE_SLAB_MAGENTA.asItem(),
                ModBlocks.STONE_SLAB_LIGHT_BLUE.asItem(),
                ModBlocks.STONE_SLAB_YELLOW.asItem(),
                ModBlocks.STONE_SLAB_LIME.asItem(),
                ModBlocks.STONE_SLAB_PINK.asItem(),
                ModBlocks.STONE_SLAB_GRAY.asItem(),
                ModBlocks.STONE_SLAB_LIGHT_GRAY.asItem(),
                ModBlocks.STONE_SLAB_CYAN.asItem(),
                ModBlocks.STONE_SLAB_PURPLE.asItem(),
                ModBlocks.STONE_SLAB_BLUE.asItem(),
                ModBlocks.STONE_SLAB_BROWN.asItem(),
                ModBlocks.STONE_SLAB_GREEN.asItem(),
                ModBlocks.STONE_SLAB_RED.asItem(),
                ModBlocks.STONE_SLAB_BLACK.asItem(),
                ModBlocks.COBBLESTONE_SLAB_WHITE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_ORANGE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_MAGENTA.asItem(),
                ModBlocks.COBBLESTONE_SLAB_LIGHT_BLUE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_YELLOW.asItem(),
                ModBlocks.COBBLESTONE_SLAB_LIME.asItem(),
                ModBlocks.COBBLESTONE_SLAB_PINK.asItem(),
                ModBlocks.COBBLESTONE_SLAB_GRAY.asItem(),
                ModBlocks.COBBLESTONE_SLAB_LIGHT_GRAY.asItem(),
                ModBlocks.COBBLESTONE_SLAB_CYAN.asItem(),
                ModBlocks.COBBLESTONE_SLAB_PURPLE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_BLUE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_BROWN.asItem(),
                ModBlocks.COBBLESTONE_SLAB_GREEN.asItem(),
                ModBlocks.COBBLESTONE_SLAB_RED.asItem(),
                ModBlocks.COBBLESTONE_SLAB_BLACK.asItem(),
                ModBlocks.IRONWOOD_SLAB.asItem(),
                ModBlocks.OLIVE_SLAB.asItem());

        getOrCreateTagBuilder(ItemTags.SAPLINGS).add(
                ModBlocks.IRONWOOD_SAPLING.asItem(),
                ModBlocks.OLIVE_SAPLING.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES).add(
                ModBlocks.IRONWOOD_LEAVES.asItem(),
                ModBlocks.OLIVE_LEAVES.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS).add(
                ModBlocks.IRONWOOD_LOG.asItem(),
                ModBlocks.IRONWOOD_WOOD.asItem(),
                ModBlocks.STRIPPED_IRONWOOD_LOG.asItem(),
                ModBlocks.STRIPPED_IRONWOOD_WOOD.asItem(),
                ModBlocks.OLIVE_LOG.asItem(),
                ModBlocks.OLIVE_WOOD.asItem(),
                ModBlocks.STRIPPED_OLIVE_LOG.asItem(),
                ModBlocks.STRIPPED_IRONWOOD_WOOD.asItem()
                );

        getOrCreateTagBuilder(ItemTags.FENCES).add(
                ModBlocks.IRONWOOD_FENCE.asItem(),
                ModBlocks.OLIVE_FENCE.asItem()
                );

        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(
                ModBlocks.IRONWOOD_FENCE.asItem(),
                ModBlocks.OLIVE_FENCE.asItem()
        );







        // ***************************************************************************** //
        //  Modded Tags
        // ***************************************************************************** //

        getOrCreateTagBuilder(ModItemTags.JARS).add(
                ModBlockItems.GLAZED_JAR_0_ITEM,
                ModBlockItems.GLAZED_JAR_1_ITEM,
                ModBlockItems.GLAZED_JAR_2_ITEM,
                ModBlockItems.GLAZED_JAR_3_ITEM,
                ModBlockItems.GLAZED_JAR_4_ITEM);

        getOrCreateTagBuilder(ModItemTags.POTS).add(
                ModBlocks.GLAZED_POT_0.asItem(),
                ModBlocks.GLAZED_POT_1.asItem(),
                ModBlocks.GLAZED_POT_2.asItem(),
                ModBlocks.GLAZED_POT_3.asItem(),
                ModBlocks.GLAZED_POT_4.asItem());

        getOrCreateTagBuilder(ModItemTags.COLORED_STONE).add(
                Blocks.STONE.asItem(),
                ModBlocks.STONE_WHITE.asItem(),
                ModBlocks.STONE_ORANGE.asItem(),
                ModBlocks.STONE_MAGENTA.asItem(),
                ModBlocks.STONE_LIGHT_BLUE.asItem(),
                ModBlocks.STONE_YELLOW.asItem(),
                ModBlocks.STONE_LIME.asItem(),
                ModBlocks.STONE_PINK.asItem(),
                ModBlocks.STONE_GRAY.asItem(),
                ModBlocks.STONE_LIGHT_GRAY.asItem(),
                ModBlocks.STONE_CYAN.asItem(),
                ModBlocks.STONE_PURPLE.asItem(),
                ModBlocks.STONE_BLUE.asItem(),
                ModBlocks.STONE_BROWN.asItem(),
                ModBlocks.STONE_GREEN.asItem(),
                ModBlocks.STONE_RED.asItem(),
                ModBlocks.STONE_BLACK.asItem());

        getOrCreateTagBuilder(ModItemTags.COLORED_STONE_SLAB).add(
                Blocks.STONE_SLAB.asItem(),
                ModBlocks.STONE_SLAB_WHITE.asItem(),
                ModBlocks.STONE_SLAB_ORANGE.asItem(),
                ModBlocks.STONE_SLAB_MAGENTA.asItem(),
                ModBlocks.STONE_SLAB_LIGHT_BLUE.asItem(),
                ModBlocks.STONE_SLAB_YELLOW.asItem(),
                ModBlocks.STONE_SLAB_LIME.asItem(),
                ModBlocks.STONE_SLAB_PINK.asItem(),
                ModBlocks.STONE_SLAB_GRAY.asItem(),
                ModBlocks.STONE_SLAB_LIGHT_GRAY.asItem(),
                ModBlocks.STONE_SLAB_CYAN.asItem(),
                ModBlocks.STONE_SLAB_PURPLE.asItem(),
                ModBlocks.STONE_SLAB_BLUE.asItem(),
                ModBlocks.STONE_SLAB_BROWN.asItem(),
                ModBlocks.STONE_SLAB_GREEN.asItem(),
                ModBlocks.STONE_SLAB_RED.asItem(),
                ModBlocks.STONE_SLAB_BLACK.asItem());

        getOrCreateTagBuilder(ModItemTags.COLORED_STONE_STAIRS).add(
                Blocks.STONE_STAIRS.asItem(),
                ModBlocks.STONE_STAIRS_WHITE.asItem(),
                ModBlocks.STONE_STAIRS_ORANGE.asItem(),
                ModBlocks.STONE_STAIRS_MAGENTA.asItem(),
                ModBlocks.STONE_STAIRS_LIGHT_BLUE.asItem(),
                ModBlocks.STONE_STAIRS_YELLOW.asItem(),
                ModBlocks.STONE_STAIRS_LIME.asItem(),
                ModBlocks.STONE_STAIRS_PINK.asItem(),
                ModBlocks.STONE_STAIRS_GRAY.asItem(),
                ModBlocks.STONE_STAIRS_LIGHT_GRAY.asItem(),
                ModBlocks.STONE_STAIRS_CYAN.asItem(),
                ModBlocks.STONE_STAIRS_PURPLE.asItem(),
                ModBlocks.STONE_STAIRS_BLUE.asItem(),
                ModBlocks.STONE_STAIRS_BROWN.asItem(),
                ModBlocks.STONE_STAIRS_GREEN.asItem(),
                ModBlocks.STONE_STAIRS_RED.asItem(),
                ModBlocks.STONE_STAIRS_BLACK.asItem());

        getOrCreateTagBuilder(ModItemTags.COLORED_COBBLESTONE).add(
                Blocks.COBBLESTONE.asItem(),
                ModBlocks.COBBLESTONE_WHITE.asItem(),
                ModBlocks.COBBLESTONE_ORANGE.asItem(),
                ModBlocks.COBBLESTONE_MAGENTA.asItem(),
                ModBlocks.COBBLESTONE_LIGHT_BLUE.asItem(),
                ModBlocks.COBBLESTONE_YELLOW.asItem(),
                ModBlocks.COBBLESTONE_LIME.asItem(),
                ModBlocks.COBBLESTONE_PINK.asItem(),
                ModBlocks.COBBLESTONE_GRAY.asItem(),
                ModBlocks.COBBLESTONE_LIGHT_GRAY.asItem(),
                ModBlocks.COBBLESTONE_CYAN.asItem(),
                ModBlocks.COBBLESTONE_PURPLE.asItem(),
                ModBlocks.COBBLESTONE_BLUE.asItem(),
                ModBlocks.COBBLESTONE_BROWN.asItem(),
                ModBlocks.COBBLESTONE_GREEN.asItem(),
                ModBlocks.COBBLESTONE_RED.asItem(),
                ModBlocks.COBBLESTONE_BLACK.asItem());

        getOrCreateTagBuilder(ModItemTags.COLORED_COBBLESTONE_SLAB).add(
                Blocks.COBBLESTONE_SLAB.asItem(),
                ModBlocks.COBBLESTONE_SLAB_WHITE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_ORANGE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_MAGENTA.asItem(),
                ModBlocks.COBBLESTONE_SLAB_LIGHT_BLUE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_YELLOW.asItem(),
                ModBlocks.COBBLESTONE_SLAB_LIME.asItem(),
                ModBlocks.COBBLESTONE_SLAB_PINK.asItem(),
                ModBlocks.COBBLESTONE_SLAB_GRAY.asItem(),
                ModBlocks.COBBLESTONE_SLAB_LIGHT_GRAY.asItem(),
                ModBlocks.COBBLESTONE_SLAB_CYAN.asItem(),
                ModBlocks.COBBLESTONE_SLAB_PURPLE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_BLUE.asItem(),
                ModBlocks.COBBLESTONE_SLAB_BROWN.asItem(),
                ModBlocks.COBBLESTONE_SLAB_GREEN.asItem(),
                ModBlocks.COBBLESTONE_SLAB_RED.asItem(),
                ModBlocks.COBBLESTONE_SLAB_BLACK.asItem());

        getOrCreateTagBuilder(ModItemTags.COLORED_COBBLESTONE_STAIRS).add(
                Blocks.COBBLESTONE_STAIRS.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_WHITE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_ORANGE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_MAGENTA.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_LIGHT_BLUE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_YELLOW.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_LIME.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_PINK.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_GRAY.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_LIGHT_GRAY.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_CYAN.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_PURPLE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_BLUE.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_BROWN.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_GREEN.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_RED.asItem(),
                ModBlocks.COBBLESTONE_STAIRS_BLACK.asItem());

        getOrCreateTagBuilder(ModItemTags.COLORED_COBBLESTONE_WALL).add(
                Blocks.COBBLESTONE_WALL.asItem(),
                ModBlocks.COBBLESTONE_WALL_WHITE.asItem(),
                ModBlocks.COBBLESTONE_WALL_ORANGE.asItem(),
                ModBlocks.COBBLESTONE_WALL_MAGENTA.asItem(),
                ModBlocks.COBBLESTONE_WALL_LIGHT_BLUE.asItem(),
                ModBlocks.COBBLESTONE_WALL_YELLOW.asItem(),
                ModBlocks.COBBLESTONE_WALL_LIME.asItem(),
                ModBlocks.COBBLESTONE_WALL_PINK.asItem(),
                ModBlocks.COBBLESTONE_WALL_GRAY.asItem(),
                ModBlocks.COBBLESTONE_WALL_LIGHT_GRAY.asItem(),
                ModBlocks.COBBLESTONE_WALL_CYAN.asItem(),
                ModBlocks.COBBLESTONE_WALL_PURPLE.asItem(),
                ModBlocks.COBBLESTONE_WALL_BLUE.asItem(),
                ModBlocks.COBBLESTONE_WALL_BROWN.asItem(),
                ModBlocks.COBBLESTONE_WALL_GREEN.asItem(),
                ModBlocks.COBBLESTONE_WALL_RED.asItem(),
                ModBlocks.COBBLESTONE_WALL_BLACK.asItem());

        getOrCreateTagBuilder(ModItemTags.IRONWOOD_LOGS).add(
                ModBlocks.IRONWOOD_LOG.asItem(),
                ModBlocks.IRONWOOD_WOOD.asItem(),
                ModBlocks.STRIPPED_IRONWOOD_LOG.asItem(),
                ModBlocks.STRIPPED_IRONWOOD_WOOD.asItem()
        );

        getOrCreateTagBuilder(ModItemTags.OLIVE_LOGS).add(
                ModBlocks.OLIVE_LOG.asItem(),
                ModBlocks.OLIVE_LOG.asItem(),
                ModBlocks.STRIPPED_OLIVE_LOG.asItem(),
                ModBlocks.STRIPPED_OLIVE_WOOD.asItem()
        );

        getOrCreateTagBuilder(ModItemTags.HERBS).add(
                ModItems.ALOE_VERA,
                ModItems.BLOOD_ORCHID,
                ModItems.CHAMOMILE,
                ModItems.CLOUD_LILY,
                ModItems.COHOSH,
                ModItems.HORSETAIL,
                ModItems.WIND_THISTLE,
                ModItems.NIGHTSHROOM,
                ModItems.GREEN_SPORED_ASBESTOS,
                ModItems.CORE_ROOT,
                ModItems.GINSENG,
                ModItems.MARSHMALLOW
        );

        getOrCreateTagBuilder(ModItemTags.ELIXIR).add(
                ModItems.ELIXIR
        );

        getOrCreateTagBuilder(ModItemTags.BREWING_FLUID).add(
                ModFluids.ALE_WORT_BUCKET,
                ModFluids.APPLE_JUICE_BUCKET,
                ModFluids.GRAPE_JUICE_BUCKET,
                ModFluids.HONEY_BUCKET,
                ModFluids.SWEET_BERRY_JUICE_BUCKET,
                ModFluids.IRONBERRY_JUICE_BUCKET,

                ModFluids.ALE_CUP,
                ModFluids.CIDER_CUP,
                ModFluids.IRON_WINE_CUP,
                ModFluids.MEAD_CUP,
                ModFluids.SWEET_BERRY_WINE_CUP,
                ModFluids.WINE_CUP
        );

        getOrCreateTagBuilder(ModItemTags.BOOZE_ITEMS).add(
                ModFluids.ALE_CUP,
                ModFluids.CIDER_CUP,
                ModFluids.IRON_WINE_CUP,
                ModFluids.MEAD_CUP,
                ModFluids.SWEET_BERRY_WINE_CUP,
                ModFluids.WINE_CUP
        );

        getOrCreateTagBuilder(ModItemTags.FLUID_BOTTLES).add(
                ModItems.ALE_WORT_BOTTLE,
                ModItems.APPLE_JUICE_BOTTLE,
                ModItems.GRAPE_JUICE_BOTTLE,
                ModItems.SWEET_BERRY_JUICE_BOTTLE,
                ModItems.IRONBERRY_JUICE_BOTTLE,
                ModItems.OLIVE_OIL_BOTTLE,
                ModFluids.ALE_CUP,
                ModFluids.CIDER_CUP,
                ModFluids.IRON_WINE_CUP,
                ModFluids.MEAD_CUP,
                ModFluids.SWEET_BERRY_WINE_CUP,
                ModFluids.WINE_CUP
        );
    }

}
