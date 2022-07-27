package net.mcs3.elixiremporium.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mcs3.elixiremporium.init.ModBlockItems;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.tags.ModItemTags;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider
{
    public ItemTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags()
    {
        getOrCreateTagBuilder(ModItemTags.JARS).add(
                ModBlockItems.GLAZED_JAR_0_ITEM,
                ModBlockItems.GLAZED_JAR_1_ITEM,
                ModBlockItems.GLAZED_JAR_2_ITEM,
                ModBlockItems.GLAZED_JAR_3_ITEM,
                ModBlockItems.GLAZED_JAR_4_ITEM);

        getOrCreateTagBuilder(ModItemTags.COLORED_COBBLESTONE).add(
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


    }
}
