package net.mcs3.rusticated.init;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.world.item.BoozeItem;
import net.mcs3.rusticated.world.level.material.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
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
    private static String MOD_ID = Rusticated.MOD_ID;

    public static FlowingFluid SOURCE_OLIVE_OIL;
    public static FlowingFluid SOURCE_IRONBERRY_JUICE;
    public static FlowingFluid SOURCE_SWEET_BERRY_JUICE;
    public static FlowingFluid SOURCE_GRAPE_JUICE;
    public static FlowingFluid SOURCE_APPLE_JUICE;
    public static FlowingFluid SOURCE_ALE_WORT;
    public static FlowingFluid SOURCE_HONEY;
    public static FlowingFluid SOURCE_ALE;
    public static FlowingFluid SOURCE_CIDER;
    public static FlowingFluid SOURCE_IRON_WINE;
    public static FlowingFluid SOURCE_MEAD;
    public static FlowingFluid SOURCE_SWEET_BERRY_WINE;
    public static FlowingFluid SOURCE_WINE;

    public static FlowingFluid FLOWING_OLIVE_OIL;
    public static FlowingFluid FLOWING_IRONBERRY_JUICE;
    public static FlowingFluid FLOWING_SWEET_BERRY_JUICE;
    public static FlowingFluid FLOWING_GRAPE_JUICE;
    public static FlowingFluid FLOWING_APPLE_JUICE;
    public static FlowingFluid FLOWING_ALE_WORT;
    public static FlowingFluid FLOWING_HONEY;
    public static FlowingFluid FLOWING_ALE;
    public static FlowingFluid FLOWING_CIDER;
    public static FlowingFluid FLOWING_IRON_WINE;
    public static FlowingFluid FLOWING_MEAD;
    public static FlowingFluid FLOWING_SWEET_BERRY_WINE;
    public static FlowingFluid FLOWING_WINE;

    public static Block OLIVE_OIL_BLOCK;
    public static Block IRONBERRY_JUICE_BLOCK;
    public static Block SWEET_BERRY_JUICE_BLOCK;
    public static Block GRAPE_JUICE_BLOCK;
    public static Block APPLE_JUICE_BLOCK;
    public static Block ALE_WORT_BLOCK;
    public static Block HONEY_FLUID_BLOCK;
    public static Block ALE_FLUID_BLOCK;
    public static Block CIDER_FLUID_BLOCK;
    public static Block IRON_WINE_FLUID_BLOCK;
    public static Block MEAD_FLUID_BLOCK;
    public static Block SWEET_BERRY_WINE_FLUID_BLOCK;
    public static Block WINE_FLUID_BLOCK;


    public static Item OLIVE_OIL_BUCKET;
    public static Item IRONBERRY_JUICE_BUCKET;
    public static Item SWEET_BERRY_JUICE_BUCKET;
    public static Item GRAPE_JUICE_BUCKET;
    public static Item APPLE_JUICE_BUCKET;
    public static Item ALE_WORT_BUCKET;
    public static Item HONEY_BUCKET;

    public static Item ALE_CUP;
    public static Item CIDER_CUP;
    public static Item IRON_WINE_CUP;
    public static Item MEAD_CUP;
    public static Item SWEET_BERRY_WINE_CUP;
    public static Item WINE_CUP;

    public static void preInitFluids() {}

    public static void init() {
        SOURCE_OLIVE_OIL = Registry.register(BuiltInRegistries.FLUID, setResource("olive_oil"), new OliveOilFluid.Source());
        SOURCE_IRONBERRY_JUICE = Registry.register(BuiltInRegistries.FLUID, setResource("ironberry_juice"), new IronberryFluid.Source());
        SOURCE_SWEET_BERRY_JUICE = Registry.register(BuiltInRegistries.FLUID, setResource("sweet_berry_juice"), new SweetBerryFluid.Source());
        SOURCE_GRAPE_JUICE = Registry.register(BuiltInRegistries.FLUID, setResource("grape_juice"), new GrapeFluid.Source());
        SOURCE_APPLE_JUICE = Registry.register(BuiltInRegistries.FLUID, setResource("apple_juice"), new AppleFluid.Source());
        SOURCE_ALE_WORT = Registry.register(BuiltInRegistries.FLUID, setResource("ale_wort"), new AleWortFluid.Source());
        SOURCE_HONEY = Registry.register(BuiltInRegistries.FLUID, setResource("honey_fluid"), new HoneyFluid.Source());
        SOURCE_ALE = Registry.register(BuiltInRegistries.FLUID, setResource("ale_fluid"), new AleFluid.Source());
        SOURCE_CIDER = Registry.register(BuiltInRegistries.FLUID, setResource("cider_fluid"), new CiderFluid.Source());
        SOURCE_IRON_WINE = Registry.register(BuiltInRegistries.FLUID, setResource("iron_wine_fluid"), new IronWineFluid.Source());
        SOURCE_MEAD = Registry.register(BuiltInRegistries.FLUID, setResource("mead_fluid"), new MeadFluid.Source());
        SOURCE_SWEET_BERRY_WINE = Registry.register(BuiltInRegistries.FLUID, setResource("sweet_berry_wine_fluid"), new SweetBerryWineFluid.Source());
        SOURCE_WINE = Registry.register(BuiltInRegistries.FLUID, setResource("wine_fluid"), new WineFluid.Source());

        FLOWING_OLIVE_OIL = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_olive_oil"), new OliveOilFluid.Flowing());
        FLOWING_IRONBERRY_JUICE = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_ironberry_juice"), new IronberryFluid.Flowing());
        FLOWING_SWEET_BERRY_JUICE = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_sweet_berry_juice"), new SweetBerryFluid.Flowing());
        FLOWING_GRAPE_JUICE = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_grape_juice"), new GrapeFluid.Flowing());
        FLOWING_APPLE_JUICE = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_apple_juice"), new AppleFluid.Flowing());
        FLOWING_ALE_WORT = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_ale_wort"), new AleWortFluid.Flowing());
        FLOWING_HONEY = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_honey"), new HoneyFluid.Flowing());
        FLOWING_ALE = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_ale"), new AleFluid.Flowing());
        FLOWING_CIDER = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_cider"), new CiderFluid.Flowing());
        FLOWING_IRON_WINE = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_iron_wine"), new IronWineFluid.Flowing());
        FLOWING_MEAD = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_mead"), new MeadFluid.Flowing());
        FLOWING_SWEET_BERRY_WINE = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_sweet_berry_wine"), new SweetBerryWineFluid.Flowing());
        FLOWING_WINE = Registry.register(BuiltInRegistries.FLUID, setResource("flowing_wine"), new WineFluid.Flowing());

        OLIVE_OIL_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("olive_oil_block"), new LiquidBlock(ModFluids.SOURCE_OLIVE_OIL, BlockBehaviour.Properties.copy(Blocks.WATER)));
        IRONBERRY_JUICE_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("ironberry_juice_block"), new LiquidBlock(ModFluids.SOURCE_IRONBERRY_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
        SWEET_BERRY_JUICE_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("sweet_berry_juice_block"), new LiquidBlock(ModFluids.SOURCE_SWEET_BERRY_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
        GRAPE_JUICE_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("grape_juice_block"), new LiquidBlock(ModFluids.SOURCE_GRAPE_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
        APPLE_JUICE_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("apple_juice_block"), new LiquidBlock(ModFluids.SOURCE_APPLE_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));
        ALE_WORT_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("ale_wort_block"), new LiquidBlock(ModFluids.SOURCE_ALE_WORT, BlockBehaviour.Properties.copy(Blocks.WATER)));
        HONEY_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("honey_fluid_block"), new LiquidBlock(ModFluids.SOURCE_HONEY, BlockBehaviour.Properties.copy(Blocks.WATER)));
        ALE_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("ale_fluid_block"), new LiquidBlock(ModFluids.SOURCE_ALE, BlockBehaviour.Properties.copy(Blocks.WATER)));
        CIDER_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("cider_fluid_block"), new LiquidBlock(ModFluids.SOURCE_CIDER, BlockBehaviour.Properties.copy(Blocks.WATER)));
        IRON_WINE_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("iron_wine_fluid_block"), new LiquidBlock(ModFluids.SOURCE_IRON_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)));
        MEAD_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("mead_fluid_block"), new LiquidBlock(ModFluids.SOURCE_MEAD, BlockBehaviour.Properties.copy(Blocks.WATER)));
        SWEET_BERRY_WINE_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("sweet_berry_wine_fluid_block"), new LiquidBlock(ModFluids.SOURCE_SWEET_BERRY_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)));
        WINE_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK, setResource("wine_fluid_block"), new LiquidBlock(ModFluids.SOURCE_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)));

        OLIVE_OIL_BUCKET = Registry.register(BuiltInRegistries.ITEM, setResource("olive_oil_bucket"), new BucketItem(ModFluids.SOURCE_OLIVE_OIL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        IRONBERRY_JUICE_BUCKET = Registry.register(BuiltInRegistries.ITEM, setResource("ironberry_juice_bucket"), new BucketItem(ModFluids.SOURCE_IRONBERRY_JUICE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        SWEET_BERRY_JUICE_BUCKET = Registry.register(BuiltInRegistries.ITEM, setResource("sweet_berry_juice_bucket"), new BucketItem(ModFluids.SOURCE_SWEET_BERRY_JUICE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        GRAPE_JUICE_BUCKET = Registry.register(BuiltInRegistries.ITEM, setResource("grape_juice_bucket"), new BucketItem(ModFluids.SOURCE_GRAPE_JUICE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        APPLE_JUICE_BUCKET = Registry.register(BuiltInRegistries.ITEM, setResource("apple_juice_bucket"), new BucketItem(ModFluids.SOURCE_APPLE_JUICE, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        ALE_WORT_BUCKET = Registry.register(BuiltInRegistries.ITEM, setResource("ale_wort_bucket"), new BucketItem(ModFluids.SOURCE_ALE_WORT, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));
        HONEY_BUCKET = Registry.register(BuiltInRegistries.ITEM, setResource("honey_bucket"), new BucketItem(ModFluids.SOURCE_HONEY, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

        ALE_CUP = Registry.register(BuiltInRegistries.ITEM, setResource("ale_cup"), new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(8), ModFluids.SOURCE_ALE));
        CIDER_CUP = Registry.register(BuiltInRegistries.ITEM, setResource("cider_cup"), new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(8), ModFluids.SOURCE_CIDER));
        IRON_WINE_CUP = Registry.register(BuiltInRegistries.ITEM, setResource("iron_wine_cup"), new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(8), ModFluids.SOURCE_IRON_WINE));
        MEAD_CUP = Registry.register(BuiltInRegistries.ITEM, setResource("mead_cup"), new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(8), ModFluids.SOURCE_MEAD));
        SWEET_BERRY_WINE_CUP = Registry.register(BuiltInRegistries.ITEM, setResource("sweet_berry_wine_cup"), new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(8), ModFluids.SOURCE_SWEET_BERRY_WINE));
        WINE_CUP = Registry.register(BuiltInRegistries.ITEM, setResource("wine_cup"), new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(8), ModFluids.SOURCE_WINE));
    }

    private static ResourceLocation setResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }
}
