package net.mcs3.elixiremporium.init;

import com.terraformersmc.modmenu.util.mod.Mod;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.world.food.ModFoodProperties;
import net.mcs3.elixiremporium.world.item.FluidBottleItem;
import net.mcs3.elixiremporium.world.item.LiquidBarrelItem;
import net.mcs3.elixiremporium.world.item.ModBookItem;
import net.mcs3.elixiremporium.world.item.ModItem;
import net.mcs3.elixiremporium.world.item.alchmey.ElixirItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import org.lwjgl.system.CallbackI;

import java.util.HashMap;
import java.util.Map;

public class ModItems
{
    public static final Map<ResourceLocation, Item> ITEMS = new HashMap<>();

    public static CreativeModeTab DECORATION_TAB = ElixirEmporium.ITEMGROUPDECO;
    public static CreativeModeTab AG_TAB = ElixirEmporium.ITEMGROUPAG;
    public static CreativeModeTab HERB_TAB = ElixirEmporium.ITEMGROUPHERB;


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

    public static Item OLIVE_OIL_BOTTLE = new FluidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).food(ModFoodProperties.OLIVE_OIL).stacksTo(16));
    public static Item IRONBERRY_JUICE_BOTTLE = new FluidBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).tab(AG_TAB).food(ModFoodProperties.IRONBERRY_JUICE).stacksTo(16));


    public static void init()
    {
        register("catalog", CATALOG);
        register("iron_berries", IRON_BERRIES);
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

    }

    static <T extends Item> T register(String name, T anyItem)
    {
        ITEMS.put(new ResourceLocation(ElixirEmporium.MOD_ID, name), anyItem);
        Registry.register(Registry.ITEM, new ResourceLocation(ElixirEmporium.MOD_ID, name), anyItem);

        return anyItem;
    }
}
