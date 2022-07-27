package net.mcs3.elixiremporium.init;

import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.world.level.block.*;
import net.mcs3.elixiremporium.world.level.block.storage.barrel.BarrelBlock;
import net.mcs3.elixiremporium.world.level.block.storage.jar.FiredJarBlock;
import net.mcs3.elixiremporium.world.level.block.storage.jar.GlazedJarBlock;
import net.mcs3.elixiremporium.world.level.block.storage.liquid_barrel.LiquidBarrelBlock;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.HashMap;
import java.util.Map;


public class ModBlocks
{
    public static final Map<ResourceLocation, Block> BLOCKS = new HashMap<>();

    public static CreativeModeTab DECORATION_TAB = ElixirEmporium.ITEMGROUPDECO;

    public static final BarrelBlock BARREL = new BarrelBlock();
    public static final Block LIQUID_BARREL = new LiquidBarrelBlock();

    public static final Block UNFIRED_JAR = new ModBlock(Properties.of(Material.CLAY).instabreak().noOcclusion());
    public static final Block FIRED_JAR = new FiredJarBlock();
    public static final Block GLAZED_JAR_0 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_1 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_2 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_3 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_4 = new GlazedJarBlock();

    public static final ChandelierBlock CHANDELIER_IRON = new ChandelierBlock(Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANVIL).noOcclusion());
    public static final ChandelierBlock CHANDELIER_GOLD = new ChandelierBlock(Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.ANVIL).noOcclusion());
    public static final WeatheringCopperChandelierBlock CHANDELIER_COPPER = new WeatheringCopperChandelierBlock(WeatheringCopper.WeatherState.UNAFFECTED, Properties.copy(Blocks.COPPER_BLOCK).sound(SoundType.ANVIL).noOcclusion());
    public static final WeatheringCopperChandelierBlock CHANDELIER_EXPOSED_COPPER = new WeatheringCopperChandelierBlock(WeatheringCopper.WeatherState.EXPOSED, Properties.copy(Blocks.EXPOSED_COPPER).sound(SoundType.ANVIL).noOcclusion());
    public static final WeatheringCopperChandelierBlock CHANDELIER_WEATHERED_COPPER = new WeatheringCopperChandelierBlock(WeatheringCopper.WeatherState.WEATHERED, Properties.copy(Blocks.WEATHERED_COPPER).sound(SoundType.ANVIL).noOcclusion());
    public static final WeatheringCopperChandelierBlock CHANDELIER_OXIDIZED_COPPER = new WeatheringCopperChandelierBlock(WeatheringCopper.WeatherState.OXIDIZED, Properties.copy(Blocks.OXIDIZED_COPPER).sound(SoundType.ANVIL).noOcclusion());
    public static final ModBlock CHANDELIER_WAXED_COPPER = new ModBlock(Properties.copy(ModBlocks.CHANDELIER_COPPER));
    public static final ModBlock CHANDELIER_WAXED_EXPOSED_COPPER = new ModBlock(Properties.copy(ModBlocks.CHANDELIER_EXPOSED_COPPER));
    public static final ModBlock CHANDELIER_WAXED_WEATHERED_COPPER = new ModBlock(Properties.copy(ModBlocks.CHANDELIER_WEATHERED_COPPER));
    public static final ModBlock CHANDELIER_WAXED_OXIDIZED_COPPER = new ModBlock(Properties.copy(ModBlocks.CHANDELIER_OXIDIZED_COPPER));

    public static final ModChainBlock CHAIN_GOLD = new ModChainBlock(Properties.copy(Blocks.CHAIN));
    public static final WeatheringCopperChainBlock CHAIN_COPPER = new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.UNAFFECTED, Properties.copy(Blocks.COPPER_BLOCK));
    public static final WeatheringCopperChainBlock CHAIN_EXPOSED_COPPER = new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.EXPOSED, Properties.copy(Blocks.EXPOSED_COPPER));
    public static final WeatheringCopperChainBlock CHAIN_WEATHERED_COPPER = new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.WEATHERED, Properties.copy(Blocks.WEATHERED_COPPER));
    public static final WeatheringCopperChainBlock CHAIN_OXIDIZED_COPPER = new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.OXIDIZED, Properties.copy(Blocks.OXIDIZED_COPPER));
    public static final ModChainBlock CHAIN_WAXED_COPPER = new ModChainBlock(Properties.copy(ModBlocks.CHAIN_COPPER));
    public static final ModChainBlock CHAIN_WAXED_EXPOSED_COPPER = new ModChainBlock(Properties.copy(ModBlocks.CHAIN_EXPOSED_COPPER));
    public static final ModChainBlock CHAIN_WAXED_WEATHERED_COPPER = new ModChainBlock(Properties.copy(ModBlocks.CHAIN_WEATHERED_COPPER));
    public static final ModChainBlock CHAIN_WAXED_OXIDIZED_COPPER = new ModChainBlock(Properties.copy(ModBlocks.CHAIN_OXIDIZED_COPPER));

    public static final Block COBBLESTONE_WHITE = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_ORANGE = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_MAGENTA = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_LIGHT_BLUE = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_YELLOW = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_LIME = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_PINK = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_GRAY = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_LIGHT_GRAY = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_CYAN = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_PURPLE = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_BLUE = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_BROWN = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_GREEN = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_RED = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_BLACK = new ColoredStoneBlock(Properties.copy(Blocks.COBBLESTONE));

    public static final Block COBBLESTONE_SLAB_WHITE = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_ORANGE = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_MAGENTA = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_LIGHT_BLUE = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_YELLOW = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_LIME = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_PINK = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_GRAY = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_LIGHT_GRAY = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_CYAN = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_PURPLE = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_BLUE = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_BROWN = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_GREEN = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_RED = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_SLAB_BLACK = new ColoredStoneSlabBlock(Properties.copy(Blocks.COBBLESTONE));

    public static final Block COBBLESTONE_STAIRS_WHITE = new ColoredStoneStairBlock(COBBLESTONE_WHITE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_ORANGE = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_MAGENTA = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_LIGHT_BLUE = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_YELLOW = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_LIME = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_PINK = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_GRAY = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_LIGHT_GRAY = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_CYAN = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_PURPLE = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_BLUE = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_BROWN = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_GREEN = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_RED = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_STAIRS_BLACK = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));

    public static final Block COBBLESTONE_WALL_WHITE = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_ORANGE = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_MAGENTA = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_LIGHT_BLUE = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_YELLOW = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_LIME = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_PINK = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_GRAY = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_LIGHT_GRAY = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_CYAN = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_PURPLE = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_BLUE = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_BROWN = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_GREEN = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_RED = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));
    public static final Block COBBLESTONE_WALL_BLACK = new ColoredStoneWallBlock(Properties.copy(Blocks.COBBLESTONE));

    public static final PlanksBlock PAINTED_PLANKS_WHITE = new PlanksBlock(MaterialColor.SNOW);
    public static final PlanksBlock PAINTED_PLANKS_ORANGE = new PlanksBlock(MaterialColor.COLOR_ORANGE);
    public static final PlanksBlock PAINTED_PLANKS_MAGENTA = new PlanksBlock(MaterialColor.COLOR_MAGENTA);
    public static final PlanksBlock PAINTED_PLANKS_LIGHT_BLUE = new PlanksBlock(MaterialColor.COLOR_LIGHT_BLUE);
    public static final PlanksBlock PAINTED_PLANKS_YELLOW = new PlanksBlock(MaterialColor.COLOR_YELLOW);
    public static final PlanksBlock PAINTED_PLANKS_LIME = new PlanksBlock(MaterialColor.COLOR_LIGHT_GREEN);
    public static final PlanksBlock PAINTED_PLANKS_PINK = new PlanksBlock(MaterialColor.COLOR_PINK);
    public static final PlanksBlock PAINTED_PLANKS_GRAY = new PlanksBlock(MaterialColor.COLOR_GRAY);
    public static final PlanksBlock PAINTED_PLANKS_LIGHT_GRAY = new PlanksBlock(MaterialColor.COLOR_LIGHT_GRAY);
    public static final PlanksBlock PAINTED_PLANKS_CYAN = new PlanksBlock(MaterialColor.COLOR_CYAN);
    public static final PlanksBlock PAINTED_PLANKS_PURPLE = new PlanksBlock(MaterialColor.COLOR_PURPLE);
    public static final PlanksBlock PAINTED_PLANKS_BLUE = new PlanksBlock(MaterialColor.COLOR_BLUE);
    public static final PlanksBlock PAINTED_PLANKS_BROWN = new PlanksBlock(MaterialColor.COLOR_BROWN);
    public static final PlanksBlock PAINTED_PLANKS_GREEN = new PlanksBlock(MaterialColor.COLOR_GREEN);
    public static final PlanksBlock PAINTED_PLANKS_RED = new PlanksBlock(MaterialColor.COLOR_RED);
    public static final PlanksBlock PAINTED_PLANKS_BLACK = new PlanksBlock(MaterialColor.COLOR_BLACK);

    public static final ModSlabBlock PAINTED_SLAB_WHITE = new ModSlabBlock(MaterialColor.SNOW);
    public static final ModSlabBlock PAINTED_SLAB_ORANGE = new ModSlabBlock(MaterialColor.COLOR_ORANGE);
    public static final ModSlabBlock PAINTED_SLAB_MAGENTA = new ModSlabBlock(MaterialColor.COLOR_MAGENTA);
    public static final ModSlabBlock PAINTED_SLAB_LIGHT_BLUE = new ModSlabBlock(MaterialColor.COLOR_LIGHT_BLUE);
    public static final ModSlabBlock PAINTED_SLAB_YELLOW = new ModSlabBlock(MaterialColor.COLOR_YELLOW);
    public static final ModSlabBlock PAINTED_SLAB_LIME = new ModSlabBlock(MaterialColor.COLOR_LIGHT_GREEN);
    public static final ModSlabBlock PAINTED_SLAB_PINK = new ModSlabBlock(MaterialColor.COLOR_PINK);
    public static final ModSlabBlock PAINTED_SLAB_GRAY = new ModSlabBlock(MaterialColor.COLOR_GRAY);
    public static final ModSlabBlock PAINTED_SLAB_LIGHT_GRAY = new ModSlabBlock(MaterialColor.COLOR_LIGHT_GRAY);
    public static final ModSlabBlock PAINTED_SLAB_CYAN = new ModSlabBlock(MaterialColor.COLOR_CYAN);
    public static final ModSlabBlock PAINTED_SLAB_PURPLE = new ModSlabBlock(MaterialColor.COLOR_PURPLE);
    public static final ModSlabBlock PAINTED_SLAB_BLUE = new ModSlabBlock(MaterialColor.COLOR_BLUE);
    public static final ModSlabBlock PAINTED_SLAB_BROWN = new ModSlabBlock(MaterialColor.COLOR_BROWN);
    public static final ModSlabBlock PAINTED_SLAB_GREEN = new ModSlabBlock(MaterialColor.COLOR_GREEN);
    public static final ModSlabBlock PAINTED_SLAB_RED = new ModSlabBlock(MaterialColor.COLOR_RED);
    public static final ModSlabBlock PAINTED_SLAB_BLACK = new ModSlabBlock(MaterialColor.COLOR_BLACK);

    public static final ModStairsBlock PAINTED_STAIRS_WHITE = new ModStairsBlock(PAINTED_PLANKS_WHITE.defaultBlockState(), Properties.copy(PAINTED_PLANKS_WHITE));
    public static final ModStairsBlock PAINTED_STAIRS_ORANGE = new ModStairsBlock(PAINTED_PLANKS_ORANGE.defaultBlockState(), Properties.copy(PAINTED_PLANKS_ORANGE));
    public static final ModStairsBlock PAINTED_STAIRS_MAGENTA = new ModStairsBlock(PAINTED_PLANKS_MAGENTA.defaultBlockState(), Properties.copy(PAINTED_PLANKS_MAGENTA));
    public static final ModStairsBlock PAINTED_STAIRS_LIGHT_BLUE = new ModStairsBlock(PAINTED_PLANKS_LIGHT_BLUE.defaultBlockState(), Properties.copy(PAINTED_PLANKS_LIGHT_BLUE));
    public static final ModStairsBlock PAINTED_STAIRS_YELLOW = new ModStairsBlock(PAINTED_PLANKS_YELLOW.defaultBlockState(), Properties.copy(PAINTED_PLANKS_YELLOW));
    public static final ModStairsBlock PAINTED_STAIRS_LIME = new ModStairsBlock(PAINTED_PLANKS_LIME.defaultBlockState(), Properties.copy(PAINTED_PLANKS_LIME));
    public static final ModStairsBlock PAINTED_STAIRS_PINK = new ModStairsBlock(PAINTED_PLANKS_PINK.defaultBlockState(), Properties.copy(PAINTED_PLANKS_PINK));
    public static final ModStairsBlock PAINTED_STAIRS_GRAY = new ModStairsBlock(PAINTED_PLANKS_GRAY.defaultBlockState(), Properties.copy(PAINTED_PLANKS_GRAY));
    public static final ModStairsBlock PAINTED_STAIRS_LIGHT_GRAY = new ModStairsBlock(PAINTED_PLANKS_LIGHT_GRAY.defaultBlockState(), Properties.copy(PAINTED_PLANKS_LIGHT_GRAY));
    public static final ModStairsBlock PAINTED_STAIRS_CYAN = new ModStairsBlock(PAINTED_PLANKS_CYAN.defaultBlockState(), Properties.copy(PAINTED_PLANKS_CYAN));
    public static final ModStairsBlock PAINTED_STAIRS_PURPLE = new ModStairsBlock(PAINTED_PLANKS_PURPLE.defaultBlockState(), Properties.copy(PAINTED_PLANKS_PURPLE));
    public static final ModStairsBlock PAINTED_STAIRS_BLUE = new ModStairsBlock(PAINTED_PLANKS_BLUE.defaultBlockState(), Properties.copy(PAINTED_PLANKS_BLUE));
    public static final ModStairsBlock PAINTED_STAIRS_BROWN = new ModStairsBlock(PAINTED_PLANKS_BROWN.defaultBlockState(), Properties.copy(PAINTED_PLANKS_BROWN));
    public static final ModStairsBlock PAINTED_STAIRS_GREEN = new ModStairsBlock(PAINTED_PLANKS_GREEN.defaultBlockState(), Properties.copy(PAINTED_PLANKS_GREEN));
    public static final ModStairsBlock PAINTED_STAIRS_RED = new ModStairsBlock(PAINTED_PLANKS_RED.defaultBlockState(), Properties.copy(PAINTED_PLANKS_RED));
    public static final ModStairsBlock PAINTED_STAIRS_BLACK = new ModStairsBlock(PAINTED_PLANKS_BLACK.defaultBlockState(), Properties.copy(PAINTED_PLANKS_BLACK));



    public static final PathBlock COBBLESTONE_PATH = new PathBlock();
    public static final PathBlock STONE_PATH = new PathBlock();
    public static final PathBlock GRANITE_PATH = new PathBlock();
    public static final PathBlock ANDESITE_PATH = new PathBlock();
    public static final PathBlock DIORITE_PATH = new PathBlock();
    public static final PathBlock COBBLED_DEEPSLATE_PATH = new PathBlock();
    public static final PathBlock BLACKSTONE_PATH = new PathBlock();
    public static final PathBlock NETHER_BRICKS_PATH = new PathBlock();







    public static void init()
    {
        register("barrel", BARREL, DECORATION_TAB);
        registerSpecial("liquid_barrel", LIQUID_BARREL, ModBlockItems.LIQUID_BARREL_ITEM, DECORATION_TAB);

        register("unfired_jar", UNFIRED_JAR, DECORATION_TAB);
        registerSpecial("fired_jar", FIRED_JAR , ModBlockItems.FIRED_JAR_ITEM, DECORATION_TAB);
        registerSpecial("glazed_jar_0", GLAZED_JAR_0 , ModBlockItems.GLAZED_JAR_0_ITEM, DECORATION_TAB);
        registerSpecial("glazed_jar_1", GLAZED_JAR_1 , ModBlockItems.GLAZED_JAR_1_ITEM, DECORATION_TAB);
        registerSpecial("glazed_jar_2", GLAZED_JAR_2 , ModBlockItems.GLAZED_JAR_2_ITEM, DECORATION_TAB);
        registerSpecial("glazed_jar_3", GLAZED_JAR_3 , ModBlockItems.GLAZED_JAR_3_ITEM, DECORATION_TAB);
        registerSpecial("glazed_jar_4", GLAZED_JAR_4 , ModBlockItems.GLAZED_JAR_4_ITEM, DECORATION_TAB);

        register("chandelier_iron", CHANDELIER_IRON, DECORATION_TAB);
        register("chandelier_gold", CHANDELIER_GOLD, DECORATION_TAB);
        register("chandelier_copper", CHANDELIER_COPPER, DECORATION_TAB);
        register("chandelier_exposed_copper", CHANDELIER_EXPOSED_COPPER, DECORATION_TAB);
        register("chandelier_weathered_copper", CHANDELIER_WEATHERED_COPPER, DECORATION_TAB);
        register("chandelier_oxidized_copper", CHANDELIER_OXIDIZED_COPPER, DECORATION_TAB);
        register("chandelier_waxed_copper", CHANDELIER_WAXED_COPPER, DECORATION_TAB);
        register("chandelier_waxed_exposed_copper", CHANDELIER_WAXED_EXPOSED_COPPER, DECORATION_TAB);
        register("chandelier_waxed_weathered_copper", CHANDELIER_WAXED_WEATHERED_COPPER, DECORATION_TAB);
        register("chandelier_waxed_oxidized_copper", CHANDELIER_WAXED_OXIDIZED_COPPER, DECORATION_TAB);

        register("chain_gold", CHAIN_GOLD, DECORATION_TAB);
        register("chain_copper", CHAIN_COPPER, DECORATION_TAB);
        register("chain_exposed_copper", CHAIN_EXPOSED_COPPER, DECORATION_TAB);
        register("chain_weathered_copper", CHAIN_WEATHERED_COPPER, DECORATION_TAB);
        register("chain_oxidized_copper", CHAIN_OXIDIZED_COPPER, DECORATION_TAB);
        register("chain_waxed_copper", CHAIN_WAXED_COPPER, DECORATION_TAB);
        register("chain_waxed_exposed_copper", CHAIN_WAXED_EXPOSED_COPPER, DECORATION_TAB);
        register("chain_waxed_weathered_copper", CHAIN_WAXED_WEATHERED_COPPER, DECORATION_TAB);
        register("chain_waxed_oxidized_copper", CHAIN_WAXED_OXIDIZED_COPPER, DECORATION_TAB);

        register("cobblestone_white", COBBLESTONE_WHITE, DECORATION_TAB);
        register("cobblestone_orange", COBBLESTONE_ORANGE, DECORATION_TAB);
        register("cobblestone_magenta", COBBLESTONE_MAGENTA, DECORATION_TAB);
        register("cobblestone_light_blue", COBBLESTONE_LIGHT_BLUE, DECORATION_TAB);
        register("cobblestone_yellow", COBBLESTONE_YELLOW, DECORATION_TAB);
        register("cobblestone_lime", COBBLESTONE_LIME, DECORATION_TAB);
        register("cobblestone_pink", COBBLESTONE_PINK, DECORATION_TAB);
        register("cobblestone_gray", COBBLESTONE_GRAY, DECORATION_TAB);
        register("cobblestone_light_gray", COBBLESTONE_LIGHT_GRAY, DECORATION_TAB);
        register("cobblestone_cyan", COBBLESTONE_CYAN, DECORATION_TAB);
        register("cobblestone_purple", COBBLESTONE_PURPLE, DECORATION_TAB);
        register("cobblestone_blue", COBBLESTONE_BLUE, DECORATION_TAB);
        register("cobblestone_brown", COBBLESTONE_BROWN, DECORATION_TAB);
        register("cobblestone_green", COBBLESTONE_GREEN, DECORATION_TAB);
        register("cobblestone_red", COBBLESTONE_RED, DECORATION_TAB);
        register("cobblestone_black", COBBLESTONE_BLACK, DECORATION_TAB);

        register("cobblestone_slab_white", COBBLESTONE_SLAB_WHITE, DECORATION_TAB);
        register("cobblestone_slab_orange", COBBLESTONE_SLAB_ORANGE, DECORATION_TAB);
        register("cobblestone_slab_magenta", COBBLESTONE_SLAB_MAGENTA, DECORATION_TAB);
        register("cobblestone_slab_light_blue", COBBLESTONE_SLAB_LIGHT_BLUE, DECORATION_TAB);
        register("cobblestone_slab_yellow", COBBLESTONE_SLAB_YELLOW, DECORATION_TAB);
        register("cobblestone_slab_lime", COBBLESTONE_SLAB_LIME, DECORATION_TAB);
        register("cobblestone_slab_pink", COBBLESTONE_SLAB_PINK, DECORATION_TAB);
        register("cobblestone_slab_gray", COBBLESTONE_SLAB_GRAY, DECORATION_TAB);
        register("cobblestone_slab_light_gray", COBBLESTONE_SLAB_LIGHT_GRAY, DECORATION_TAB);
        register("cobblestone_slab_cyan", COBBLESTONE_SLAB_CYAN, DECORATION_TAB);
        register("cobblestone_slab_purple", COBBLESTONE_SLAB_PURPLE, DECORATION_TAB);
        register("cobblestone_slab_blue", COBBLESTONE_SLAB_BLUE, DECORATION_TAB);
        register("cobblestone_slab_brown", COBBLESTONE_SLAB_BROWN, DECORATION_TAB);
        register("cobblestone_slab_green", COBBLESTONE_SLAB_GREEN, DECORATION_TAB);
        register("cobblestone_slab_red", COBBLESTONE_SLAB_RED, DECORATION_TAB);
        register("cobblestone_slab_black", COBBLESTONE_SLAB_BLACK, DECORATION_TAB);

        register("cobblestone_stairs_white", COBBLESTONE_STAIRS_WHITE, DECORATION_TAB);
        register("cobblestone_stairs_orange", COBBLESTONE_STAIRS_ORANGE, DECORATION_TAB);
        register("cobblestone_stairs_magenta", COBBLESTONE_STAIRS_MAGENTA, DECORATION_TAB);
        register("cobblestone_stairs_light_blue", COBBLESTONE_STAIRS_LIGHT_BLUE, DECORATION_TAB);
        register("cobblestone_stairs_yellow", COBBLESTONE_STAIRS_YELLOW, DECORATION_TAB);
        register("cobblestone_stairs_lime", COBBLESTONE_STAIRS_LIME, DECORATION_TAB);
        register("cobblestone_stairs_pink", COBBLESTONE_STAIRS_PINK, DECORATION_TAB);
        register("cobblestone_stairs_gray", COBBLESTONE_STAIRS_GRAY, DECORATION_TAB);
        register("cobblestone_stairs_light_gray", COBBLESTONE_STAIRS_LIGHT_GRAY, DECORATION_TAB);
        register("cobblestone_stairs_cyan", COBBLESTONE_STAIRS_CYAN, DECORATION_TAB);
        register("cobblestone_stairs_purple", COBBLESTONE_STAIRS_PURPLE, DECORATION_TAB);
        register("cobblestone_stairs_blue", COBBLESTONE_STAIRS_BLUE, DECORATION_TAB);
        register("cobblestone_stairs_brown", COBBLESTONE_STAIRS_BROWN, DECORATION_TAB);
        register("cobblestone_stairs_green", COBBLESTONE_STAIRS_GREEN, DECORATION_TAB);
        register("cobblestone_stairs_red", COBBLESTONE_STAIRS_RED, DECORATION_TAB);
        register("cobblestone_stairs_black", COBBLESTONE_STAIRS_BLACK, DECORATION_TAB);

        register("cobblestone_wall_white", COBBLESTONE_WALL_WHITE, DECORATION_TAB);
        register("cobblestone_wall_orange", COBBLESTONE_WALL_ORANGE, DECORATION_TAB);
        register("cobblestone_wall_magenta", COBBLESTONE_WALL_MAGENTA, DECORATION_TAB);
        register("cobblestone_wall_light_blue", COBBLESTONE_WALL_LIGHT_BLUE, DECORATION_TAB);
        register("cobblestone_wall_yellow", COBBLESTONE_WALL_YELLOW, DECORATION_TAB);
        register("cobblestone_wall_lime", COBBLESTONE_WALL_LIME, DECORATION_TAB);
        register("cobblestone_wall_pink", COBBLESTONE_WALL_PINK, DECORATION_TAB);
        register("cobblestone_wall_gray", COBBLESTONE_WALL_GRAY, DECORATION_TAB);
        register("cobblestone_wall_light_gray", COBBLESTONE_WALL_LIGHT_GRAY, DECORATION_TAB);
        register("cobblestone_wall_cyan", COBBLESTONE_WALL_CYAN, DECORATION_TAB);
        register("cobblestone_wall_purple", COBBLESTONE_WALL_PURPLE, DECORATION_TAB);
        register("cobblestone_wall_blue", COBBLESTONE_WALL_BLUE, DECORATION_TAB);
        register("cobblestone_wall_brown", COBBLESTONE_WALL_BROWN, DECORATION_TAB);
        register("cobblestone_wall_green", COBBLESTONE_WALL_GREEN, DECORATION_TAB);
        register("cobblestone_wall_red", COBBLESTONE_WALL_RED, DECORATION_TAB);
        register("cobblestone_wall_black", COBBLESTONE_WALL_BLACK, DECORATION_TAB);

        register("painted_planks_white", PAINTED_PLANKS_WHITE, DECORATION_TAB);
        register("painted_planks_orange", PAINTED_PLANKS_ORANGE, DECORATION_TAB);
        register("painted_planks_magenta", PAINTED_PLANKS_MAGENTA, DECORATION_TAB);
        register("painted_planks_light_blue", PAINTED_PLANKS_LIGHT_BLUE, DECORATION_TAB);
        register("painted_planks_yellow", PAINTED_PLANKS_YELLOW, DECORATION_TAB);
        register("painted_planks_lime", PAINTED_PLANKS_LIME, DECORATION_TAB);
        register("painted_planks_pink", PAINTED_PLANKS_PINK, DECORATION_TAB);
        register("painted_planks_gray", PAINTED_PLANKS_GRAY, DECORATION_TAB);
        register("painted_planks_light_gray", PAINTED_PLANKS_LIGHT_GRAY, DECORATION_TAB);
        register("painted_planks_cyan", PAINTED_PLANKS_CYAN, DECORATION_TAB);
        register("painted_planks_purple", PAINTED_PLANKS_PURPLE, DECORATION_TAB);
        register("painted_planks_blue", PAINTED_PLANKS_BLUE, DECORATION_TAB);
        register("painted_planks_brown", PAINTED_PLANKS_BROWN, DECORATION_TAB);
        register("painted_planks_green", PAINTED_PLANKS_GREEN, DECORATION_TAB);
        register("painted_planks_red", PAINTED_PLANKS_RED, DECORATION_TAB);
        register("painted_planks_black", PAINTED_PLANKS_BLACK, DECORATION_TAB);

        register("painted_slab_white", PAINTED_SLAB_WHITE, DECORATION_TAB);
        register("painted_slab_orange", PAINTED_SLAB_ORANGE, DECORATION_TAB);
        register("painted_slab_magenta", PAINTED_SLAB_MAGENTA, DECORATION_TAB);
        register("painted_slab_light_blue", PAINTED_SLAB_LIGHT_BLUE, DECORATION_TAB);
        register("painted_slab_yellow", PAINTED_SLAB_YELLOW, DECORATION_TAB);
        register("painted_slab_lime", PAINTED_SLAB_LIME, DECORATION_TAB);
        register("painted_slab_pink", PAINTED_SLAB_PINK, DECORATION_TAB);
        register("painted_slab_gray", PAINTED_SLAB_GRAY, DECORATION_TAB);
        register("painted_slab_light_gray", PAINTED_SLAB_LIGHT_GRAY, DECORATION_TAB);
        register("painted_slab_cyan", PAINTED_SLAB_CYAN, DECORATION_TAB);
        register("painted_slab_purple", PAINTED_SLAB_PURPLE, DECORATION_TAB);
        register("painted_slab_blue", PAINTED_SLAB_BLUE, DECORATION_TAB);
        register("painted_slab_brown", PAINTED_SLAB_BROWN, DECORATION_TAB);
        register("painted_slab_green", PAINTED_SLAB_GREEN, DECORATION_TAB);
        register("painted_slab_red", PAINTED_SLAB_RED, DECORATION_TAB);
        register("painted_slab_black", PAINTED_SLAB_BLACK, DECORATION_TAB);

        register("painted_stairs_white", PAINTED_STAIRS_WHITE, DECORATION_TAB);
        register("painted_stairs_orange", PAINTED_STAIRS_ORANGE, DECORATION_TAB);
        register("painted_stairs_magenta", PAINTED_STAIRS_MAGENTA, DECORATION_TAB);
        register("painted_stairs_light_blue", PAINTED_STAIRS_LIGHT_BLUE, DECORATION_TAB);
        register("painted_stairs_yellow", PAINTED_STAIRS_YELLOW, DECORATION_TAB);
        register("painted_stairs_lime", PAINTED_STAIRS_LIME, DECORATION_TAB);
        register("painted_stairs_pink", PAINTED_STAIRS_PINK, DECORATION_TAB);
        register("painted_stairs_gray", PAINTED_STAIRS_GRAY, DECORATION_TAB);
        register("painted_stairs_light_gray", PAINTED_STAIRS_LIGHT_GRAY, DECORATION_TAB);
        register("painted_stairs_cyan", PAINTED_STAIRS_CYAN, DECORATION_TAB);
        register("painted_stairs_purple", PAINTED_STAIRS_PURPLE, DECORATION_TAB);
        register("painted_stairs_blue", PAINTED_STAIRS_BLUE, DECORATION_TAB);
        register("painted_stairs_brown", PAINTED_STAIRS_BROWN, DECORATION_TAB);
        register("painted_stairs_green", PAINTED_STAIRS_GREEN, DECORATION_TAB);
        register("painted_stairs_red", PAINTED_STAIRS_RED, DECORATION_TAB);
        register("painted_stairs_black", PAINTED_STAIRS_BLACK, DECORATION_TAB);



        register("cobblestone_path", COBBLESTONE_PATH, DECORATION_TAB);
        register("stone_path", STONE_PATH, DECORATION_TAB);
        register("granite_path", GRANITE_PATH, DECORATION_TAB);
        register("andesite_path", ANDESITE_PATH, DECORATION_TAB);
        register("diorite_path", DIORITE_PATH, DECORATION_TAB);
        register("cobbled_deepslate_path", COBBLED_DEEPSLATE_PATH, DECORATION_TAB);
        register("blackstone_path", BLACKSTONE_PATH, DECORATION_TAB);
        register("nether_bricks_path", NETHER_BRICKS_PATH, DECORATION_TAB);








    }

    static <T extends Block> T register(String name, T anyBlock, CreativeModeTab tab)
    {
        T block = Registry.register(Registry.BLOCK, new ResourceLocation(ElixirEmporium.MOD_ID, name), anyBlock);
        BLOCKS.put(new ResourceLocation(ElixirEmporium.MOD_ID, name), block);
        BlockItem blockItem = new BlockItem(block, new Item.Properties().tab(tab));

        Registry.register(Registry.ITEM, new ResourceLocation(ElixirEmporium.MOD_ID, name), blockItem);

        return anyBlock;
    }

    static <T extends Block> T registerSpecial(String name, T anyBlock, BlockItem item, CreativeModeTab tab)
    {
        T block = Registry.register(Registry.BLOCK, new ResourceLocation(ElixirEmporium.MOD_ID, name), anyBlock);
        BLOCKS.put(new ResourceLocation(ElixirEmporium.MOD_ID, name), block);
        //BlockItem blockItem = new BlockItem(item.getBlock(), new Item.Properties().tab(tab));

        Registry.register(Registry.ITEM, new ResourceLocation(ElixirEmporium.MOD_ID, name), item);

        return anyBlock;
    }

}
