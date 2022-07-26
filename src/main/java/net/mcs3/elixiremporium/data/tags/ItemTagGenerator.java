package net.mcs3.elixiremporium.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.mcs3.elixiremporium.init.ModBlockItems;
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


    }
}
