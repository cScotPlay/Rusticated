package net.mcs3.rusticated.init;

import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.world.food.ModFoodProperties;
import net.mcs3.rusticated.world.item.*;
import net.mcs3.rusticated.world.item.alchmey.ElixirItem;
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

    public static Item OILED_APPLE = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.APPLE.getFoodProperties()));
    public static Item OILED_BAKED_POTATO = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.BAKED_POTATO.getFoodProperties()));
    public static Item OILED_BEEF = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.BEEF.getFoodProperties()));
    public static Item OILED_BEETROOT = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.BEETROOT.getFoodProperties()));
    public static Item OILED_BEETROOT_SOUP = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.BEETROOT_SOUP.getFoodProperties()));
    public static Item OILED_BREAD = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.BREAD.getFoodProperties()));
    public static Item OILED_CARROT = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.CARROT.getFoodProperties()));
    public static Item OILED_CHICKEN = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.CHICKEN.getFoodProperties()));
    public static Item OILED_CHORUS_FRUIT = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.CHORUS_FRUIT.getFoodProperties()));
    public static Item OILED_COD = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.COD.getFoodProperties()));
    public static Item OILED_COOKED_BEEF = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.COOKED_BEEF.getFoodProperties()));
    public static Item OILED_COOKED_CHICKEN = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.COOKED_CHICKEN.getFoodProperties()));
    public static Item OILED_COOKED_COD = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.COOKED_COD.getFoodProperties()));
    public static Item OILED_COOKED_MUTTON = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.COOKED_MUTTON.getFoodProperties()));
    public static Item OILED_COOKED_PORKCHOP = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.COOKED_PORKCHOP.getFoodProperties()));
    public static Item OILED_COOKED_RABBIT = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.COOKED_RABBIT.getFoodProperties()));
    public static Item OILED_COOKED_SALMON = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.COOKED_SALMON.getFoodProperties()));
    public static Item OILED_COOKIE = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.COOKIE.getFoodProperties()));
    public static Item OILED_DRIED_KELP = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.DRIED_KELP.getFoodProperties()));
    public static Item OILED_GOLDEN_APPLE = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.GOLDEN_APPLE.getFoodProperties()));
    public static Item OILED_GOLDEN_CARROT = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.GOLDEN_CARROT.getFoodProperties()));
    public static Item OILED_MELON_SLICE = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.MELON_SLICE.getFoodProperties()));
    public static Item OILED_MUSHROOM_STEW = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.MUSHROOM_STEW.getFoodProperties()));
    public static Item OILED_MUTTON = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.MUTTON.getFoodProperties()));
    public static Item OILED_POISONOUS_POTATO = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.POISONOUS_POTATO.getFoodProperties()));
    public static Item OILED_PORKCHOP = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.PORKCHOP.getFoodProperties()));
    public static Item OILED_POTATO = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.POTATO.getFoodProperties()));
    public static Item OILED_PUFFERFISH = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.PUFFERFISH.getFoodProperties()));
    public static Item OILED_PUMPKIN_PIE = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.PUMPKIN_PIE.getFoodProperties()));
    public static Item OILED_RABBIT = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.RABBIT.getFoodProperties()));
    public static Item OILED_RABBIT_STEW = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.RABBIT_STEW.getFoodProperties()));
    public static Item OILED_ROTTEN_FLESH = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.ROTTEN_FLESH.getFoodProperties()));
    public static Item OILED_SALMON = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.SALMON.getFoodProperties()));
    public static Item OILED_SPIDER_EYE = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.SPIDER_EYE.getFoodProperties()));
    public static Item OILED_SUSPICIOUS_STEW = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.SUSPICIOUS_STEW.getFoodProperties()));
    public static Item OILED_SWEET_BERRIES = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.SWEET_BERRIES.getFoodProperties()));
    public static Item OILED_GLOW_BERRIES = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.GLOW_BERRIES.getFoodProperties()));
    public static Item OILED_TROPICAL_FISH = new OliveOilFoodItem(new Item.Properties().tab(AG_TAB).food(Items.TROPICAL_FISH.getFoodProperties()));



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

        register("oiled_apple", OILED_APPLE);
        register("oiled_baked_potato", OILED_BAKED_POTATO);
        register("oiled_beef", OILED_BEEF);
        register("oiled_beetroot", OILED_BEETROOT);
        register("oiled_beetroot_soup", OILED_BEETROOT_SOUP);
        register("oiled_bread", OILED_BREAD);
        register("oiled_carrot", OILED_CARROT);
        register("oiled_chicken", OILED_CHICKEN);
        register("oiled_chorus_fruit", OILED_CHORUS_FRUIT);
        register("oiled_cod", OILED_COD);
        register("oiled_cooked_beef", OILED_COOKED_BEEF);
        register("oiled_cooked_chicken", OILED_COOKED_CHICKEN);
        register("oiled_cooked_cod", OILED_COOKED_COD);
        register("oiled_cooked_mutton", OILED_COOKED_MUTTON);
        register("oiled_cooked_porkchop", OILED_COOKED_PORKCHOP);
        register("oiled_cooked_rabbit", OILED_COOKED_RABBIT);
        register("oiled_cooked_salmon", OILED_COOKED_SALMON);
        register("oiled_cookie", OILED_COOKIE);
        register("oiled_dried_kelp", OILED_DRIED_KELP);
        register("oiled_golden_apple", OILED_GOLDEN_APPLE);
        register("oiled_golden_carrot", OILED_GOLDEN_CARROT);
        register("oiled_melon_slice", OILED_MELON_SLICE);
        register("oiled_mushroom_stew", OILED_MUSHROOM_STEW);
        register("oiled_mutton", OILED_MUTTON);
        register("oiled_poisonous_potato", OILED_POISONOUS_POTATO);
        register("oiled_porkchop", OILED_PORKCHOP);
        register("oiled_potato", OILED_POTATO);
        register("oiled_pufferfish", OILED_PUFFERFISH);
        register("oiled_pumpkin_pie", OILED_PUMPKIN_PIE);
        register("oiled_rabbit", OILED_RABBIT);
        register("oiled_rabbit_stew", OILED_RABBIT_STEW);
        register("oiled_rotten_flesh", OILED_ROTTEN_FLESH);
        register("oiled_salmon", OILED_SALMON);
        register("oiled_spider_eye", OILED_SPIDER_EYE);
        register("oiled_suspicious_stew", OILED_SUSPICIOUS_STEW);
        register("oiled_sweet_berries", OILED_SWEET_BERRIES);
        register("oiled_glow_berries", OILED_GLOW_BERRIES);
        register("oiled_tropical_fish", OILED_TROPICAL_FISH);


    }

    static <T extends Item> T register(String name, T anyItem)
    {
        ITEMS.put(new ResourceLocation(Rusticated.MOD_ID, name), anyItem);
        Registry.register(Registry.ITEM, new ResourceLocation(Rusticated.MOD_ID, name), anyItem);

        return anyItem;
    }
}
