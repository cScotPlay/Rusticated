package net.mcs3.rusticated.init;

import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class ModCompostable {

    public static void registerCompostables() {

        var compostableItems = new Object2FloatOpenHashMap<ItemLike>();

        compostableItems.put(ModItems.GRAPE_SEEDS, 0.3F);
        compostableItems.put(ModItems.IRON_BERRIES, 0.3F);
        compostableItems.put(ModItems.OLIVES, 0.3F);
        compostableItems.put(ModItems.GRAPES, 0.3F);

        compostableItems.put(ModItems.ALOE_VERA, 0.5F);
        compostableItems.put(ModItems.BLOOD_ORCHID, 0.5F);
        compostableItems.put(ModItems.CHAMOMILE, 0.5F);
        compostableItems.put(ModItems.CLOUD_LILY, 0.5F);
        compostableItems.put(ModItems.COHOSH, 0.5F);
        compostableItems.put(ModItems.HORSETAIL, 0.5F);
        compostableItems.put(ModItems.WIND_THISTLE, 0.5F);
        compostableItems.put(ModItems.NIGHTSHROOM, 0.5F);
        compostableItems.put(ModItems.GREEN_SPORED_ASBESTOS, 0.5F);
        compostableItems.put(ModItems.CORE_ROOT, 0.5F);
        compostableItems.put(ModItems.GINSENG, 0.5F);
        compostableItems.put(ModItems.MARSHMALLOW, 0.5F);

        compostableItems.put(ModBlocks.IRONWOOD_SAPLING.asItem(), 0.3F);
        compostableItems.put(ModBlocks.OLIVE_SAPLING.asItem(), 0.3F);
        compostableItems.put(ModBlocks.IRONWOOD_LEAVES.asItem(), 0.3F);
        compostableItems.put(ModBlocks.OLIVE_LEAVES.asItem(), 0.3F);

        ComposterBlock.COMPOSTABLES.putAll(compostableItems);
    }
}
