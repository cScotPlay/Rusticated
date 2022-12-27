package net.mcs3.rusticated.init;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.world.food.ModFoodProperties;
import net.mcs3.rusticated.world.item.BoozeItem;
import net.mcs3.rusticated.world.item.FluidBottleItem;
import net.mcs3.rusticated.world.item.ModBookItem;
import net.mcs3.rusticated.world.item.ModItem;
import net.mcs3.rusticated.world.item.alchmey.ElixirItem;
import net.mcs3.rusticated.world.level.material.ModFluids;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import java.util.HashMap;
import java.util.Map;

public class ModItems
{
    public static final Map<ResourceLocation, Item> ITEMS = new HashMap<>();

    public static CreativeModeTab DECORATION_TAB = Rusticated.ITEMGROUPDECO;
    public static CreativeModeTab AG_TAB = Rusticated.ITEMGROUPAG;
    public static CreativeModeTab HERB_TAB = Rusticated.ITEMGROUPHERB;


    public static Item CATALOG = new ModBookItem();
    public static Item OLIVES = new ModItem(new Item.Properties().tab(AG_TAB).food(ModFoodProperties.OLIVES));
    public static Item IRON_BERRIES = new ModItem(new Item.Properties().tab(AG_TAB).food(ModFoodProperties.IRONBERRIES));
    public static Item GRAPE_SEEDS = new ItemNameBlockItem(ModBlocks.GRAPE_STEM,  new Item.Properties().tab(AG_TAB));
    public static Item GRAPES = new ModItem(new Item.Properties().tab(AG_TAB).food(ModFoodProperties.GRAPES));

    public static Item COPPER_NUGGET = new ModItem(new Item.Properties().tab(DECORATION_TAB));

    public static Item ALOE_VERA = new ItemNameBlockItem(ModBlocks.ALOE_VERA, new Item.Properties().tab(HERB_TAB));
    public static Item BLOOD_ORCHID = new ItemNameBlockItem(ModBlocks.BLOOD_ORCHID, new Item.Properties().tab(HERB_TAB));
    public static Item CHAMOMILE = new ItemNameBlockItem(ModBlocks.CHAMOMILE, new Item.Properties().tab(HERB_TAB));
    public static Item CLOUD_LILY = new ItemNameBlockItem(ModBlocks.CLOUD_LILY, new Item.Properties().tab(HERB_TAB).food(ModFoodProperties.CLOUD_LILY));
    public static Item COHOSH = new ItemNameBlockItem(ModBlocks.COHOSH, new Item.Properties().tab(HERB_TAB));
    public static Item HORSETAIL = new ItemNameBlockItem(ModBlocks.HORSETAIL, new Item.Properties().tab(HERB_TAB));
    public static Item WIND_THISTLE = new ItemNameBlockItem(ModBlocks.WIND_THISTLE, new Item.Properties().tab(HERB_TAB));
    public static Item NIGHTSHROOM = new ItemNameBlockItem(ModBlocks.NIGHTSHROOM, new Item.Properties().tab(HERB_TAB));
    public static Item GREEN_SPORED_ASBESTOS = new ItemNameBlockItem(ModBlocks.GREEN_SPORED_ASBESTOS, new Item.Properties().tab(HERB_TAB));
    public static Item CORE_ROOT = new ItemNameBlockItem(ModBlocks.CORE_ROOT, new Item.Properties().tab(HERB_TAB).food(ModFoodProperties.CORE_ROOT));
    public static Item GINSENG = new ItemNameBlockItem(ModBlocks.GINSENG, new Item.Properties().tab(HERB_TAB).food(ModFoodProperties.GINSENG));
    public static Item MARSHMALLOW = new ItemNameBlockItem(ModBlocks.MARSHMALLOW, new Item.Properties().tab(HERB_TAB).food(ModFoodProperties.MARSHMALLOW));

    public static Item ELIXIR = new ElixirItem();

    public static Item UNFIRED_EVAPORATING_BASIN = new ModItem(new Item.Properties().tab(AG_TAB));

    public static Item OLIVE_OIL_BOTTLE = new FluidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).food(ModFoodProperties.OLIVE_OIL).stacksTo(16));
    public static Item IRONBERRY_JUICE_BOTTLE = new FluidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).food(ModFoodProperties.IRONBERRY_JUICE).stacksTo(16));
    public static Item SWEET_BERRY_JUICE_BOTTLE = new FluidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).food(ModFoodProperties.SWEET_BERRY_JUICE).stacksTo(16));
    public static Item GRAPE_JUICE_BOTTLE = new FluidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).food(ModFoodProperties.GRAPE_JUICE).stacksTo(16));
    public static Item APPLE_JUICE_BOTTLE = new FluidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).food(ModFoodProperties.APPLE_JUICE).stacksTo(16));
    public static Item ALE_WORT_BOTTLE = new FluidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).food(ModFoodProperties.ALE_WORT).stacksTo(16));
    public static Item ALE_CUP = new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).stacksTo(8), ModFluids.SOURCE_ALE);
    public static Item CIDER_CUP = new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).stacksTo(8), ModFluids.SOURCE_CIDER);
    public static Item IRON_WINE_CUP = new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).stacksTo(8), ModFluids.SOURCE_IRON_WINE);
    public static Item MEAD_CUP = new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).stacksTo(8), ModFluids.SOURCE_MEAD);
    public static Item SWEET_BERRY_WINE_CUP = new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).stacksTo(8), ModFluids.SOURCE_SWEET_BERRY_WINE);
    public static Item WINE_CUP = new BoozeItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).stacksTo(8), ModFluids.SOURCE_WINE);


    public static Item TINY_IRON_DUST = new ModItem(new Item.Properties().tab(AG_TAB));



    public static void init()
    {
        register("catalog", CATALOG);
        register("unfired_evaporating_basin", UNFIRED_EVAPORATING_BASIN);
        register("iron_berries", IRON_BERRIES);
        register("tiny_iron_dust", TINY_IRON_DUST);
        register("olives", OLIVES);
        register("grape_seeds", GRAPE_SEEDS);
        register("grapes", GRAPES);

        register("copper_nugget", COPPER_NUGGET);



        //////////////////////////////////////////////////////////
        ///               Herbal Items Registry                ///
        //////////////////////////////////////////////////////////
        register("aloe_vera", ALOE_VERA);
        register("blood_orchid", BLOOD_ORCHID);
        register("chamomile", CHAMOMILE);
        register("cloud_lily", CLOUD_LILY);
        register("cohosh", COHOSH);
        register("horsetail", HORSETAIL);  //Advance
        register("wind_thistle", WIND_THISTLE);
        register("nightshroom", NIGHTSHROOM);
        register("green_spored_asbestos", GREEN_SPORED_ASBESTOS);
        register("core_root", CORE_ROOT);
        register("ginseng", GINSENG);
        register("marshmallow", MARSHMALLOW); // Advance

        register("elixir", ELIXIR);


        register("olive_oil_bottle", OLIVE_OIL_BOTTLE);
        register("ironberry_juice_bottle", IRONBERRY_JUICE_BOTTLE);
        register("sweet_berry_juice_bottle", SWEET_BERRY_JUICE_BOTTLE);
        register("grape_juice_bottle", GRAPE_JUICE_BOTTLE);
        register("apple_juice_bottle", APPLE_JUICE_BOTTLE);
        register("ale_wort_bottle", ALE_WORT_BOTTLE);

        register("ale_cup", ALE_CUP);
        register("cider_cup", CIDER_CUP);
        register("iron_wine_cup", IRON_WINE_CUP);
        register("mead_cup", MEAD_CUP);
        register("sweet_berry_wine_cup", SWEET_BERRY_WINE_CUP);
        register("wine_cup", WINE_CUP);


    }

    static <T extends Item> T register(String name, T anyItem)
    {
        ITEMS.put(new ResourceLocation(Rusticated.MOD_ID, name), anyItem);
        Registry.register(Registry.ITEM, new ResourceLocation(Rusticated.MOD_ID, name), anyItem);

        return anyItem;
    }
}
