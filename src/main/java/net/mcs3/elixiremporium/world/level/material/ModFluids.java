package net.mcs3.elixiremporium.world.level.material;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

public class ModFluids {
    private static String MOD_ID = ElixirEmporium.MOD_ID;

    public static FlowingFluid SOURCE_OLIVE_OIL;
    public static FlowingFluid FLOWING_OLIVE_OIL;
    public static Block OLIVE_OIL_BLOCK;
    public static Item OLIVE_OIL_BUCKET;



    public static void init() {
        SOURCE_OLIVE_OIL = Registry.register(Registry.FLUID, setResource("olive_oil"), new OliveOilFluid.Source());
        FLOWING_OLIVE_OIL = Registry.register(Registry.FLUID, setResource("flowing_olive_oil"), new OliveOilFluid.Flowing());

        OLIVE_OIL_BLOCK = Registry.register(Registry.BLOCK, setResource("olive_oil_block"), new LiquidBlock(ModFluids.SOURCE_OLIVE_OIL, BlockBehaviour.Properties.copy(Blocks.WATER)));

        OLIVE_OIL_BUCKET = Registry.register(Registry.ITEM, setResource("olive_oil_bucket"), new BucketItem(ModFluids.SOURCE_OLIVE_OIL, new Item.Properties().tab(ElixirEmporium.ITEMGROUPAG).craftRemainder(Items.BUCKET).stacksTo(1)));
    }

    private static ResourceLocation setResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

}
