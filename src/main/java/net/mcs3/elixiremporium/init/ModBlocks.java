package net.mcs3.elixiremporium.init;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.mcs3.elixiremporium.ElixirEmporium;
import net.mcs3.elixiremporium.world.level.block.*;
import net.mcs3.elixiremporium.world.level.block.alchemy.CondenserBlock;
import net.mcs3.elixiremporium.world.level.block.alchemy.RetortBlock;
import net.mcs3.elixiremporium.world.level.block.crop.*;
import net.mcs3.elixiremporium.world.level.block.grower.IronwoodTreeGrower;
import net.mcs3.elixiremporium.world.level.block.grower.OliveTreeGrower;
import net.mcs3.elixiremporium.world.level.block.storage.barrel.BarrelBlock;
import net.mcs3.elixiremporium.world.level.block.storage.jar.FiredJarBlock;
import net.mcs3.elixiremporium.world.level.block.storage.jar.GlazedJarBlock;
import net.mcs3.elixiremporium.world.level.block.storage.liquid_barrel.LiquidBarrelBlock;
import net.mcs3.elixiremporium.world.level.block.storage.pot.*;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.AxeItem;
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
    public static CreativeModeTab AGRICULTURAL_TAB = ElixirEmporium.ITEMGROUPAG;
    public static CreativeModeTab HERB_TAB = ElixirEmporium.ITEMGROUPHERB;

    public static final BarrelBlock BARREL = new BarrelBlock();
    public static final Block LIQUID_BARREL = new LiquidBarrelBlock();

    public static final Block UNFIRED_JAR = new ModBlock(Properties.of(Material.CLAY).instabreak().noOcclusion());
    public static final Block FIRED_JAR = new FiredJarBlock();
    public static final Block GLAZED_JAR_0 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_1 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_2 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_3 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_4 = new GlazedJarBlock();

    public static final Block UNFIRED_POT = new ModBlock(Properties.of(Material.CLAY).instabreak().noOcclusion());
    public static final Block FIRED_POT = new FiredPotBlock();
    public static final Block GLAZED_POT_0 = new GlazedPotBlock();
    public static final Block GLAZED_POT_1 = new GlazedPotBlock1();
    public static final Block GLAZED_POT_2 = new GlazedPotBlock2();
    public static final Block GLAZED_POT_3 = new GlazedPotBlock3();
    public static final Block GLAZED_POT_4 = new GlazedPotBlock4();

    public static final Block IRON_LATTICE = new LatticeBlock();

    public static final Block CHANDELIER_IRON = new ChandelierBlock(Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.ANVIL).noOcclusion());
    public static final Block CHANDELIER_GOLD = new ChandelierBlock(Properties.copy(Blocks.GOLD_BLOCK).sound(SoundType.ANVIL).noOcclusion());
    public static final Block CHANDELIER_COPPER = new WeatheringCopperChandelierBlock(WeatheringCopper.WeatherState.UNAFFECTED, Properties.copy(Blocks.COPPER_BLOCK).sound(SoundType.ANVIL).noOcclusion());
    public static final Block CHANDELIER_EXPOSED_COPPER = new WeatheringCopperChandelierBlock(WeatheringCopper.WeatherState.EXPOSED, Properties.copy(Blocks.EXPOSED_COPPER).sound(SoundType.ANVIL).noOcclusion());
    public static final Block CHANDELIER_WEATHERED_COPPER = new WeatheringCopperChandelierBlock(WeatheringCopper.WeatherState.WEATHERED, Properties.copy(Blocks.WEATHERED_COPPER).sound(SoundType.ANVIL).noOcclusion());
    public static final Block CHANDELIER_OXIDIZED_COPPER = new WeatheringCopperChandelierBlock(WeatheringCopper.WeatherState.OXIDIZED, Properties.copy(Blocks.OXIDIZED_COPPER).sound(SoundType.ANVIL).noOcclusion());
    public static final Block CHANDELIER_WAXED_COPPER = new ChandelierBlock(Properties.copy(Blocks.COPPER_BLOCK).sound(SoundType.ANVIL).noOcclusion());
    public static final Block CHANDELIER_WAXED_EXPOSED_COPPER = new ChandelierBlock(Properties.copy(Blocks.EXPOSED_COPPER).sound(SoundType.ANVIL).noOcclusion());
    public static final Block CHANDELIER_WAXED_WEATHERED_COPPER = new ChandelierBlock(Properties.copy(Blocks.WEATHERED_COPPER).sound(SoundType.ANVIL).noOcclusion());
    public static final Block CHANDELIER_WAXED_OXIDIZED_COPPER = new ChandelierBlock(Properties.copy(Blocks.OXIDIZED_COPPER).sound(SoundType.ANVIL).noOcclusion());

    public static final Block CHAIN_GOLD = new ModChainBlock(Properties.copy(Blocks.CHAIN));
    public static final Block CHAIN_COPPER = new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.UNAFFECTED, Properties.copy(Blocks.COPPER_BLOCK));
    public static final Block CHAIN_EXPOSED_COPPER = new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.EXPOSED, Properties.copy(Blocks.EXPOSED_COPPER));
    public static final Block CHAIN_WEATHERED_COPPER = new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.WEATHERED, Properties.copy(Blocks.WEATHERED_COPPER));
    public static final Block CHAIN_OXIDIZED_COPPER = new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.OXIDIZED, Properties.copy(Blocks.OXIDIZED_COPPER));
    public static final Block CHAIN_WAXED_COPPER = new ModChainBlock(Properties.copy(ModBlocks.CHAIN_COPPER));
    public static final Block CHAIN_WAXED_EXPOSED_COPPER = new ModChainBlock(Properties.copy(ModBlocks.CHAIN_EXPOSED_COPPER));
    public static final Block CHAIN_WAXED_WEATHERED_COPPER = new ModChainBlock(Properties.copy(ModBlocks.CHAIN_WEATHERED_COPPER));
    public static final Block CHAIN_WAXED_OXIDIZED_COPPER = new ModChainBlock(Properties.copy(ModBlocks.CHAIN_OXIDIZED_COPPER));

    public static final Block STONE_WHITE = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_ORANGE = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_MAGENTA = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_LIGHT_BLUE = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_YELLOW = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_LIME = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_PINK = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_GRAY = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_LIGHT_GRAY = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_CYAN = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_PURPLE = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_BLUE = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_BROWN = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_GREEN = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_RED = new ColoredStoneBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_BLACK = new ColoredStoneBlock(Properties.copy(Blocks.STONE));

    public static final Block STONE_SLAB_WHITE = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_ORANGE = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_MAGENTA = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_LIGHT_BLUE = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_YELLOW = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_LIME = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_PINK = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_GRAY = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_LIGHT_GRAY = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_CYAN = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_PURPLE = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_BLUE = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_BROWN = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_GREEN = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_RED = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));
    public static final Block STONE_SLAB_BLACK = new ColoredStoneSlabBlock(Properties.copy(Blocks.STONE));

    public static final Block STONE_STAIRS_WHITE = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_ORANGE = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_MAGENTA = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_LIGHT_BLUE = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_YELLOW = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_LIME = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_PINK = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_GRAY = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_LIGHT_GRAY = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_CYAN = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_PURPLE = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_BLUE = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_BROWN = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_GREEN = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_RED = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));
    public static final Block STONE_STAIRS_BLACK = new ColoredStoneStairBlock(Blocks.STONE.defaultBlockState(), Properties.copy(Blocks.STONE));

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

    public static final Block COBBLESTONE_STAIRS_WHITE = new ColoredStoneStairBlock(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
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

    public static final Block FRAMED_WALL_CROSS_WHITE = new FramedWallBlocks(Properties.copy(Blocks.WHITE_WOOL));
    public static final Block FRAMED_WALL_CROSS_ORANGE = new FramedWallBlocks(Properties.copy(Blocks.ORANGE_WOOL));
    public static final Block FRAMED_WALL_CROSS_MAGENTA = new FramedWallBlocks(Properties.copy(Blocks.MAGENTA_WOOL));
    public static final Block FRAMED_WALL_CROSS_LIGHT_BLUE = new FramedWallBlocks(Properties.copy(Blocks.LIGHT_BLUE_WOOL));
    public static final Block FRAMED_WALL_CROSS_YELLOW = new FramedWallBlocks(Properties.copy(Blocks.YELLOW_WOOL));
    public static final Block FRAMED_WALL_CROSS_LIME = new FramedWallBlocks(Properties.copy(Blocks.LIME_WOOL));
    public static final Block FRAMED_WALL_CROSS_PINK = new FramedWallBlocks(Properties.copy(Blocks.PINK_WOOL));
    public static final Block FRAMED_WALL_CROSS_GRAY = new FramedWallBlocks(Properties.copy(Blocks.GRAY_WOOL));
    public static final Block FRAMED_WALL_CROSS_LIGHT_GRAY = new FramedWallBlocks(Properties.copy(Blocks.GRAY_WOOL));
    public static final Block FRAMED_WALL_CROSS_CYAN = new FramedWallBlocks(Properties.copy(Blocks.CYAN_WOOL));
    public static final Block FRAMED_WALL_CROSS_PURPLE = new FramedWallBlocks(Properties.copy(Blocks.PURPLE_WOOL));
    public static final Block FRAMED_WALL_CROSS_BLUE = new FramedWallBlocks(Properties.copy(Blocks.BLUE_WOOL));
    public static final Block FRAMED_WALL_CROSS_BROWN = new FramedWallBlocks(Properties.copy(Blocks.BROWN_WOOL));
    public static final Block FRAMED_WALL_CROSS_GREEN = new FramedWallBlocks(Properties.copy(Blocks.GREEN_WOOL));
    public static final Block FRAMED_WALL_CROSS_RED = new FramedWallBlocks(Properties.copy(Blocks.RED_WOOL));
    public static final Block FRAMED_WALL_CROSS_BLACK = new FramedWallBlocks(Properties.copy(Blocks.BLACK_WOOL));

    public static final Block FRAMED_WALL_RT_DIAG_WHITE = new FramedWallBlocks(Properties.copy(Blocks.WHITE_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_ORANGE = new FramedWallBlocks(Properties.copy(Blocks.ORANGE_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_MAGENTA = new FramedWallBlocks(Properties.copy(Blocks.MAGENTA_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_LIGHT_BLUE = new FramedWallBlocks(Properties.copy(Blocks.LIGHT_BLUE_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_YELLOW = new FramedWallBlocks(Properties.copy(Blocks.YELLOW_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_LIME = new FramedWallBlocks(Properties.copy(Blocks.LIME_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_PINK = new FramedWallBlocks(Properties.copy(Blocks.PINK_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_GRAY = new FramedWallBlocks(Properties.copy(Blocks.GRAY_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_LIGHT_GRAY = new FramedWallBlocks(Properties.copy(Blocks.GRAY_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_CYAN = new FramedWallBlocks(Properties.copy(Blocks.CYAN_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_PURPLE = new FramedWallBlocks(Properties.copy(Blocks.PURPLE_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_BLUE = new FramedWallBlocks(Properties.copy(Blocks.BLUE_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_BROWN = new FramedWallBlocks(Properties.copy(Blocks.BROWN_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_GREEN = new FramedWallBlocks(Properties.copy(Blocks.GREEN_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_RED = new FramedWallBlocks(Properties.copy(Blocks.RED_WOOL));
    public static final Block FRAMED_WALL_RT_DIAG_BLACK = new FramedWallBlocks(Properties.copy(Blocks.BLACK_WOOL));

    public static final Block FRAMED_WALL_LEFT_DIAG_WHITE = new FramedWallBlocks(Properties.copy(Blocks.WHITE_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_ORANGE = new FramedWallBlocks(Properties.copy(Blocks.ORANGE_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_MAGENTA = new FramedWallBlocks(Properties.copy(Blocks.MAGENTA_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_LIGHT_BLUE = new FramedWallBlocks(Properties.copy(Blocks.LIGHT_BLUE_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_YELLOW = new FramedWallBlocks(Properties.copy(Blocks.YELLOW_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_LIME = new FramedWallBlocks(Properties.copy(Blocks.LIME_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_PINK = new FramedWallBlocks(Properties.copy(Blocks.PINK_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_GRAY = new FramedWallBlocks(Properties.copy(Blocks.GRAY_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_LIGHT_GRAY = new FramedWallBlocks(Properties.copy(Blocks.GRAY_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_CYAN = new FramedWallBlocks(Properties.copy(Blocks.CYAN_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_PURPLE = new FramedWallBlocks(Properties.copy(Blocks.PURPLE_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_BLUE = new FramedWallBlocks(Properties.copy(Blocks.BLUE_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_BROWN = new FramedWallBlocks(Properties.copy(Blocks.BROWN_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_GREEN = new FramedWallBlocks(Properties.copy(Blocks.GREEN_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_RED = new FramedWallBlocks(Properties.copy(Blocks.RED_WOOL));
    public static final Block FRAMED_WALL_LEFT_DIAG_BLACK = new FramedWallBlocks(Properties.copy(Blocks.BLACK_WOOL));

    public static final Block FRAMED_WALL_WHITE = new FramedWallBlocks(Properties.copy(Blocks.WHITE_WOOL));
    public static final Block FRAMED_WALL_ORANGE = new FramedWallBlocks(Properties.copy(Blocks.ORANGE_WOOL));
    public static final Block FRAMED_WALL_MAGENTA = new FramedWallBlocks(Properties.copy(Blocks.MAGENTA_WOOL));
    public static final Block FRAMED_WALL_LIGHT_BLUE = new FramedWallBlocks(Properties.copy(Blocks.LIGHT_BLUE_WOOL));
    public static final Block FRAMED_WALL_YELLOW = new FramedWallBlocks(Properties.copy(Blocks.YELLOW_WOOL));
    public static final Block FRAMED_WALL_LIME = new FramedWallBlocks(Properties.copy(Blocks.LIME_WOOL));
    public static final Block FRAMED_WALL_PINK = new FramedWallBlocks(Properties.copy(Blocks.PINK_WOOL));
    public static final Block FRAMED_WALL_GRAY = new FramedWallBlocks(Properties.copy(Blocks.GRAY_WOOL));
    public static final Block FRAMED_WALL_LIGHT_GRAY = new FramedWallBlocks(Properties.copy(Blocks.GRAY_WOOL));
    public static final Block FRAMED_WALL_CYAN = new FramedWallBlocks(Properties.copy(Blocks.CYAN_WOOL));
    public static final Block FRAMED_WALL_PURPLE = new FramedWallBlocks(Properties.copy(Blocks.PURPLE_WOOL));
    public static final Block FRAMED_WALL_BLUE = new FramedWallBlocks(Properties.copy(Blocks.BLUE_WOOL));
    public static final Block FRAMED_WALL_BROWN = new FramedWallBlocks(Properties.copy(Blocks.BROWN_WOOL));
    public static final Block FRAMED_WALL_GREEN = new FramedWallBlocks(Properties.copy(Blocks.GREEN_WOOL));
    public static final Block FRAMED_WALL_RED = new FramedWallBlocks(Properties.copy(Blocks.RED_WOOL));
    public static final Block FRAMED_WALL_BLACK = new FramedWallBlocks(Properties.copy(Blocks.BLACK_WOOL));

    public static final PathBlock COBBLESTONE_PATH = new PathBlock();
    public static final PathBlock STONE_PATH = new PathBlock();
    public static final PathBlock GRANITE_PATH = new PathBlock();
    public static final PathBlock ANDESITE_PATH = new PathBlock();
    public static final PathBlock DIORITE_PATH = new PathBlock();
    public static final PathBlock COBBLED_DEEPSLATE_PATH = new PathBlock();
    public static final PathBlock BLACKSTONE_PATH = new PathBlock();
    public static final PathBlock NETHER_BRICKS_PATH = new PathBlock();

    //////////////////////////////////////////////////////////
    ///               Ironwood Blocks                  ///
    //////////////////////////////////////////////////////////
    public static final Block IRONWOOD_SAPLING = new SaplingBlock(new IronwoodTreeGrower(), Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    public static final Block POTTED_IRONWOOD_SAPLING = new FlowerPotBlock(IRONWOOD_SAPLING, Properties.of(Material.DECORATION).instabreak().noOcclusion());
    public static final Block IRONWOOD_LEAVES = new LeavesBlock(Properties.copy(Blocks.ACACIA_LEAVES));

    public static final Block IRONWOOD_LOG = new RotatedPillarBlock(Properties.of(Material.WOOD, (blockState) -> {
        return blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.SAND : MaterialColor.COLOR_GRAY;
    }).strength(2.0F).sound(SoundType.WOOD));
    public static final Block IRONWOOD_WOOD = new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(2.0F).sound(SoundType.WOOD));
    public static final Block STRIPPED_IRONWOOD_LOG = new RotatedPillarBlock(Properties.of(Material.WOOD, (blockState) -> {
        return blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.SAND : MaterialColor.COLOR_GRAY;
    }).strength(2.0F).sound(SoundType.WOOD));
    public static final Block STRIPPED_IRONWOOD_WOOD = new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_GRAY).strength(2.0F).sound(SoundType.WOOD));
    public static final Block IRONWOOD_PLANKS = new PlanksBlock(MaterialColor.SAND);
    public static final ModSlabBlock IRONWOOD_SLAB = new ModSlabBlock(MaterialColor.SAND);
    public static final ModStairsBlock IRONWOOD_STAIRS = new ModStairsBlock(IRONWOOD_PLANKS.defaultBlockState(), Properties.copy(IRONWOOD_PLANKS));
    public static final Block IRONWOOD_FENCE = new FenceBlock(Properties.copy(IRONWOOD_PLANKS));
    public static final Block IRONWOOD_GATE = new FenceGateBlock(Properties.copy(IRONWOOD_PLANKS));

    //////////////////////////////////////////////////////////
    ///               Olive Blocks                  ///
    //////////////////////////////////////////////////////////
    public static final Block OLIVE_SAPLING = new SaplingBlock(new OliveTreeGrower(), Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    public static final Block POTTED_OLIVE_SAPLING = new FlowerPotBlock(OLIVE_SAPLING, Properties.of(Material.DECORATION).instabreak().noOcclusion());
    public static final Block OLIVE_LEAVES = new LeavesBlock(Properties.copy(Blocks.ACACIA_LEAVES));

    public static final Block OLIVE_LOG = new RotatedPillarBlock(Properties.of(Material.WOOD, (blockState) -> {
        return blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.PODZOL : MaterialColor.COLOR_LIGHT_GRAY;
    }).strength(2.0F).sound(SoundType.WOOD));
    public static final Block OLIVE_WOOD = new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GRAY).strength(2.0F).sound(SoundType.WOOD));
    public static final Block STRIPPED_OLIVE_LOG = new RotatedPillarBlock(Properties.of(Material.WOOD, (blockState) -> {
        return blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.PODZOL : MaterialColor.COLOR_LIGHT_GRAY;
    }).strength(2.0F).sound(SoundType.WOOD));
    public static final Block STRIPPED_OLIVE_WOOD = new RotatedPillarBlock(Properties.of(Material.WOOD, MaterialColor.COLOR_LIGHT_GRAY).strength(2.0F).sound(SoundType.WOOD));
    public static final Block OLIVE_PLANKS = new PlanksBlock(MaterialColor.PODZOL);
    public static final ModSlabBlock OLIVE_SLAB = new ModSlabBlock(MaterialColor.PODZOL);
    public static final ModStairsBlock OLIVE_STAIRS = new ModStairsBlock(OLIVE_PLANKS.defaultBlockState(), Properties.copy(OLIVE_PLANKS));
    public static final Block OLIVE_FENCE = new FenceBlock(Properties.copy(OLIVE_PLANKS));
    public static final Block OLIVE_GATE = new FenceGateBlock(Properties.copy(OLIVE_PLANKS));


    //////////////////////////////////////////////////////////
    ///               Agricultural Blocks                  ///
    //////////////////////////////////////////////////////////

    public static final Block FERTILE_SOIL = new FertileSoilBlock(Properties.copy(Blocks.FARMLAND));
    public static final Block CROP_STAKE = new CropStakeBlock();
    public static final Block TIED_STAKE = new TiedStakeBlock(Properties.copy(CROP_STAKE));
    public static final Block ROPE = new RopeBlock();
    public static final Block GRAPE_STEM = new GrapeStemBlock();
    public static final Block GRAPE_LEAVES = new GrapeLeavesBlock();

    //////////////////////////////////////////////////////////
    ///                   Herbal Blocks                    ///
    //////////////////////////////////////////////////////////
    public static final Block ALOE_VERA = new AloeVeraBlock();
    public static final Block BLOOD_ORCHID = new HerbPerennialBlock(BlockTags.DIRT);
    public static final Block CHAMOMILE = new HerbPerennialBlock(BlockTags.DIRT);
    public static final Block CLOUD_LILY = new HerbPerennialBlock(BlockTags.DIRT);
    public static final Block COHOSH = new HerbPerennialBlock(BlockTags.DIRT);
    public static final Block HORSETAIL = new HerbPerennialBlock(BlockTags.DIRT);
    public static final Block WIND_THISTLE = new HerbPerennialBlock(BlockTags.DIRT);
    public static final Block NIGHTSHROOM = new ModMushroomBlock(BlockTags.MUSHROOM_GROW_BLOCK);
    public static final Block GREEN_SPORED_ASBESTOS = new ModMushroomBlock(BlockTags.MUSHROOM_GROW_BLOCK);
    public static final Block CORE_ROOT = new RootBlock(BlockTags.BASE_STONE_OVERWORLD);
    public static final Block GINSENG = new RootBlock(BlockTags.DIRT);
    public static final Block MARSHMALLOW = new RootBlock(BlockTags.DIRT);


    //////////////////////////////////////////////////////////
    ///                  Alchemy Blocks                    ///
    //////////////////////////////////////////////////////////
    public static final Block CONDENSER = new CondenserBlock();
    public static final Block RETORT = new RetortBlock();





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

        register("unfired_pot", UNFIRED_POT, DECORATION_TAB);
        registerSpecial("fired_pot", FIRED_POT, ModBlockItems.FIRE_POT_ITEM, DECORATION_TAB);
        registerSpecial("glazed_pot_0", GLAZED_POT_0 , ModBlockItems.GLAZED_POT_0_ITEM, DECORATION_TAB);
        registerSpecial("glazed_pot_1", GLAZED_POT_1 , ModBlockItems.GLAZED_POT_1_ITEM, DECORATION_TAB);
        registerSpecial("glazed_pot_2", GLAZED_POT_2 , ModBlockItems.GLAZED_POT_2_ITEM, DECORATION_TAB);
        registerSpecial("glazed_pot_3", GLAZED_POT_3 , ModBlockItems.GLAZED_POT_3_ITEM, DECORATION_TAB);
        registerSpecial("glazed_pot_4", GLAZED_POT_4 , ModBlockItems.GLAZED_POT_4_ITEM, DECORATION_TAB);

        register("iron_lattice", ModBlocks.IRON_LATTICE, DECORATION_TAB);

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

        register("ironwood_log", IRONWOOD_LOG, DECORATION_TAB);
        register("ironwood_wood", IRONWOOD_WOOD, DECORATION_TAB);
        register("stripped_ironwood_log", STRIPPED_IRONWOOD_LOG, DECORATION_TAB);
        register("stripped_ironwood_wood", STRIPPED_IRONWOOD_WOOD, DECORATION_TAB);
        register("ironwood_planks", IRONWOOD_PLANKS, DECORATION_TAB);
        register("ironwood_slab", IRONWOOD_SLAB, DECORATION_TAB);
        register("ironwood_stairs", IRONWOOD_STAIRS, DECORATION_TAB);
        register("ironwood_fence", IRONWOOD_FENCE, DECORATION_TAB);
        register("ironwood_gate", IRONWOOD_GATE, DECORATION_TAB);

        register("olive_log", OLIVE_LOG, DECORATION_TAB);
        register("olive_wood", OLIVE_WOOD, DECORATION_TAB);
        register("stripped_olive_log", STRIPPED_OLIVE_LOG, DECORATION_TAB);
        register("stripped_olive_wood", STRIPPED_OLIVE_WOOD, DECORATION_TAB);
        register("olive_planks", OLIVE_PLANKS, DECORATION_TAB);
        register("olive_slab", OLIVE_SLAB, DECORATION_TAB);
        register("olive_stairs", OLIVE_STAIRS, DECORATION_TAB);
        register("olive_fence", OLIVE_FENCE, DECORATION_TAB);
        register("olive_gate", OLIVE_GATE, DECORATION_TAB);

        register("stone_white", STONE_WHITE, DECORATION_TAB);
        register("stone_orange", STONE_ORANGE, DECORATION_TAB);
        register("stone_magenta", STONE_MAGENTA, DECORATION_TAB);
        register("stone_light_blue", STONE_LIGHT_BLUE, DECORATION_TAB);
        register("stone_yellow", STONE_YELLOW, DECORATION_TAB);
        register("stone_lime", STONE_LIME, DECORATION_TAB);
        register("stone_pink", STONE_PINK, DECORATION_TAB);
        register("stone_gray", STONE_GRAY, DECORATION_TAB);
        register("stone_light_gray", STONE_LIGHT_GRAY, DECORATION_TAB);
        register("stone_cyan", STONE_CYAN, DECORATION_TAB);
        register("stone_purple", STONE_PURPLE, DECORATION_TAB);
        register("stone_blue", STONE_BLUE, DECORATION_TAB);
        register("stone_brown", STONE_BROWN, DECORATION_TAB);
        register("stone_green", STONE_GREEN, DECORATION_TAB);
        register("stone_red", STONE_RED, DECORATION_TAB);
        register("stone_black", STONE_BLACK, DECORATION_TAB);

        register("stone_slab_white", STONE_SLAB_WHITE, DECORATION_TAB);
        register("stone_slab_orange", STONE_SLAB_ORANGE, DECORATION_TAB);
        register("stone_slab_magenta", STONE_SLAB_MAGENTA, DECORATION_TAB);
        register("stone_slab_light_blue", STONE_SLAB_LIGHT_BLUE, DECORATION_TAB);
        register("stone_slab_yellow", STONE_SLAB_YELLOW, DECORATION_TAB);
        register("stone_slab_lime", STONE_SLAB_LIME, DECORATION_TAB);
        register("stone_slab_pink", STONE_SLAB_PINK, DECORATION_TAB);
        register("stone_slab_gray", STONE_SLAB_GRAY, DECORATION_TAB);
        register("stone_slab_light_gray", STONE_SLAB_LIGHT_GRAY, DECORATION_TAB);
        register("stone_slab_cyan", STONE_SLAB_CYAN, DECORATION_TAB);
        register("stone_slab_purple", STONE_SLAB_PURPLE, DECORATION_TAB);
        register("stone_slab_blue", STONE_SLAB_BLUE, DECORATION_TAB);
        register("stone_slab_brown", STONE_SLAB_BROWN, DECORATION_TAB);
        register("stone_slab_green", STONE_SLAB_GREEN, DECORATION_TAB);
        register("stone_slab_red", STONE_SLAB_RED, DECORATION_TAB);
        register("stone_slab_black", STONE_SLAB_BLACK, DECORATION_TAB);

        register("stone_stairs_white", STONE_STAIRS_WHITE, DECORATION_TAB);
        register("stone_stairs_orange", STONE_STAIRS_ORANGE, DECORATION_TAB);
        register("stone_stairs_magenta", STONE_STAIRS_MAGENTA, DECORATION_TAB);
        register("stone_stairs_light_blue", STONE_STAIRS_LIGHT_BLUE, DECORATION_TAB);
        register("stone_stairs_yellow", STONE_STAIRS_YELLOW, DECORATION_TAB);
        register("stone_stairs_lime", STONE_STAIRS_LIME, DECORATION_TAB);
        register("stone_stairs_pink", STONE_STAIRS_PINK, DECORATION_TAB);
        register("stone_stairs_gray", STONE_STAIRS_GRAY, DECORATION_TAB);
        register("stone_stairs_light_gray", STONE_STAIRS_LIGHT_GRAY, DECORATION_TAB);
        register("stone_stairs_cyan", STONE_STAIRS_CYAN, DECORATION_TAB);
        register("stone_stairs_purple", STONE_STAIRS_PURPLE, DECORATION_TAB);
        register("stone_stairs_blue", STONE_STAIRS_BLUE, DECORATION_TAB);
        register("stone_stairs_brown", STONE_STAIRS_BROWN, DECORATION_TAB);
        register("stone_stairs_green", STONE_STAIRS_GREEN, DECORATION_TAB);
        register("stone_stairs_red", STONE_STAIRS_RED, DECORATION_TAB);
        register("stone_stairs_black", STONE_STAIRS_BLACK, DECORATION_TAB);

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

        register("framed_wall_white", FRAMED_WALL_WHITE, DECORATION_TAB);
        register("framed_wall_orange", FRAMED_WALL_ORANGE, DECORATION_TAB);
        register("framed_wall_magenta", FRAMED_WALL_MAGENTA, DECORATION_TAB);
        register("framed_wall_light_blue", FRAMED_WALL_LIGHT_BLUE, DECORATION_TAB);
        register("framed_wall_yellow", FRAMED_WALL_YELLOW, DECORATION_TAB);
        register("framed_wall_lime", FRAMED_WALL_LIME, DECORATION_TAB);
        register("framed_wall_pink", FRAMED_WALL_PINK, DECORATION_TAB);
        register("framed_wall_gray", FRAMED_WALL_GRAY, DECORATION_TAB);
        register("framed_wall_light_gray", FRAMED_WALL_LIGHT_GRAY, DECORATION_TAB);
        register("framed_wall_cyan", FRAMED_WALL_CYAN, DECORATION_TAB);
        register("framed_wall_purple", FRAMED_WALL_PURPLE, DECORATION_TAB);
        register("framed_wall_blue", FRAMED_WALL_BLUE, DECORATION_TAB);
        register("framed_wall_brown", FRAMED_WALL_BROWN, DECORATION_TAB);
        register("framed_wall_green", FRAMED_WALL_GREEN, DECORATION_TAB);
        register("framed_wall_red", FRAMED_WALL_RED, DECORATION_TAB);
        register("framed_wall_black", FRAMED_WALL_BLACK, DECORATION_TAB);

        register("framed_wall_cross_white", FRAMED_WALL_CROSS_WHITE, DECORATION_TAB);
        register("framed_wall_cross_orange", FRAMED_WALL_CROSS_ORANGE, DECORATION_TAB);
        register("framed_wall_cross_magenta", FRAMED_WALL_CROSS_MAGENTA, DECORATION_TAB);
        register("framed_wall_cross_light_blue", FRAMED_WALL_CROSS_LIGHT_BLUE, DECORATION_TAB);
        register("framed_wall_cross_yellow", FRAMED_WALL_CROSS_YELLOW, DECORATION_TAB);
        register("framed_wall_cross_lime", FRAMED_WALL_CROSS_LIME, DECORATION_TAB);
        register("framed_wall_cross_pink", FRAMED_WALL_CROSS_PINK, DECORATION_TAB);
        register("framed_wall_cross_gray", FRAMED_WALL_CROSS_GRAY, DECORATION_TAB);
        register("framed_wall_cross_light_gray", FRAMED_WALL_CROSS_LIGHT_GRAY, DECORATION_TAB);
        register("framed_wall_cross_cyan", FRAMED_WALL_CROSS_CYAN, DECORATION_TAB);
        register("framed_wall_cross_purple", FRAMED_WALL_CROSS_PURPLE, DECORATION_TAB);
        register("framed_wall_cross_blue", FRAMED_WALL_CROSS_BLUE, DECORATION_TAB);
        register("framed_wall_cross_brown", FRAMED_WALL_CROSS_BROWN, DECORATION_TAB);
        register("framed_wall_cross_green", FRAMED_WALL_CROSS_GREEN, DECORATION_TAB);
        register("framed_wall_cross_red", FRAMED_WALL_CROSS_RED, DECORATION_TAB);
        register("framed_wall_cross_black", FRAMED_WALL_CROSS_BLACK, DECORATION_TAB);

        register("framed_wall_rt_diag_white", FRAMED_WALL_RT_DIAG_WHITE, DECORATION_TAB);
        register("framed_wall_rt_diag_orange", FRAMED_WALL_RT_DIAG_ORANGE, DECORATION_TAB);
        register("framed_wall_rt_diag_magenta", FRAMED_WALL_RT_DIAG_MAGENTA, DECORATION_TAB);
        register("framed_wall_rt_diag_light_blue", FRAMED_WALL_RT_DIAG_LIGHT_BLUE, DECORATION_TAB);
        register("framed_wall_rt_diag_yellow", FRAMED_WALL_RT_DIAG_YELLOW, DECORATION_TAB);
        register("framed_wall_rt_diag_lime", FRAMED_WALL_RT_DIAG_LIME, DECORATION_TAB);
        register("framed_wall_rt_diag_pink", FRAMED_WALL_RT_DIAG_PINK, DECORATION_TAB);
        register("framed_wall_rt_diag_gray", FRAMED_WALL_RT_DIAG_GRAY, DECORATION_TAB);
        register("framed_wall_rt_diag_light_gray", FRAMED_WALL_RT_DIAG_LIGHT_GRAY, DECORATION_TAB);
        register("framed_wall_rt_diag_cyan", FRAMED_WALL_RT_DIAG_CYAN, DECORATION_TAB);
        register("framed_wall_rt_diag_purple", FRAMED_WALL_RT_DIAG_PURPLE, DECORATION_TAB);
        register("framed_wall_rt_diag_blue", FRAMED_WALL_RT_DIAG_BLUE, DECORATION_TAB);
        register("framed_wall_rt_diag_brown", FRAMED_WALL_RT_DIAG_BROWN, DECORATION_TAB);
        register("framed_wall_rt_diag_green", FRAMED_WALL_RT_DIAG_GREEN, DECORATION_TAB);
        register("framed_wall_rt_diag_red", FRAMED_WALL_RT_DIAG_RED, DECORATION_TAB);
        register("framed_wall_rt_diag_black", FRAMED_WALL_RT_DIAG_BLACK, DECORATION_TAB);

        register("framed_wall_left_diag_white", FRAMED_WALL_LEFT_DIAG_WHITE, DECORATION_TAB);
        register("framed_wall_left_diag_orange", FRAMED_WALL_LEFT_DIAG_ORANGE, DECORATION_TAB);
        register("framed_wall_left_diag_magenta", FRAMED_WALL_LEFT_DIAG_MAGENTA, DECORATION_TAB);
        register("framed_wall_left_diag_light_blue", FRAMED_WALL_LEFT_DIAG_LIGHT_BLUE, DECORATION_TAB);
        register("framed_wall_left_diag_yellow", FRAMED_WALL_LEFT_DIAG_YELLOW, DECORATION_TAB);
        register("framed_wall_left_diag_lime", FRAMED_WALL_LEFT_DIAG_LIME, DECORATION_TAB);
        register("framed_wall_left_diag_pink", FRAMED_WALL_LEFT_DIAG_PINK, DECORATION_TAB);
        register("framed_wall_left_diag_gray", FRAMED_WALL_LEFT_DIAG_GRAY, DECORATION_TAB);
        register("framed_wall_left_diag_light_gray", FRAMED_WALL_LEFT_DIAG_LIGHT_GRAY, DECORATION_TAB);
        register("framed_wall_left_diag_cyan", FRAMED_WALL_LEFT_DIAG_CYAN, DECORATION_TAB);
        register("framed_wall_left_diag_purple", FRAMED_WALL_LEFT_DIAG_PURPLE, DECORATION_TAB);
        register("framed_wall_left_diag_blue", FRAMED_WALL_LEFT_DIAG_BLUE, DECORATION_TAB);
        register("framed_wall_left_diag_brown", FRAMED_WALL_LEFT_DIAG_BROWN, DECORATION_TAB);
        register("framed_wall_left_diag_green", FRAMED_WALL_LEFT_DIAG_GREEN, DECORATION_TAB);
        register("framed_wall_left_diag_red", FRAMED_WALL_LEFT_DIAG_RED, DECORATION_TAB);
        register("framed_wall_left_diag_black", FRAMED_WALL_LEFT_DIAG_BLACK, DECORATION_TAB);

        register("cobblestone_path", COBBLESTONE_PATH, DECORATION_TAB);
        register("stone_path", STONE_PATH, DECORATION_TAB);
        register("granite_path", GRANITE_PATH, DECORATION_TAB);
        register("andesite_path", ANDESITE_PATH, DECORATION_TAB);
        register("diorite_path", DIORITE_PATH, DECORATION_TAB);
        register("cobbled_deepslate_path", COBBLED_DEEPSLATE_PATH, DECORATION_TAB);
        register("blackstone_path", BLACKSTONE_PATH, DECORATION_TAB);
        register("nether_bricks_path", NETHER_BRICKS_PATH, DECORATION_TAB);

        //////////////////////////////////////////////////////////
        ///          Agricultural Blocks Registry              ///
        //////////////////////////////////////////////////////////

        register("fertile_soil", FERTILE_SOIL, AGRICULTURAL_TAB);
        register("ironwood_sapling", IRONWOOD_SAPLING, AGRICULTURAL_TAB);
        register("potted_ironwood_sapling", POTTED_IRONWOOD_SAPLING, null);
        register("ironwood_leaves", IRONWOOD_LEAVES, AGRICULTURAL_TAB);

        register("olive_sapling", OLIVE_SAPLING, AGRICULTURAL_TAB);
        register("potted_olive_sapling", POTTED_OLIVE_SAPLING, null);
        register("olive_leaves", OLIVE_LEAVES, AGRICULTURAL_TAB);

        register("crop_stake", CROP_STAKE, AGRICULTURAL_TAB);
        register("tied_stake", TIED_STAKE, null);
        register("rope", ROPE, AGRICULTURAL_TAB);
        register("grape_stem", GRAPE_STEM, null);
        register("grape_leaves", GRAPE_LEAVES, null);

        //////////////////////////////////////////////////////////
        ///               Herbal Blocks Registry               ///
        //////////////////////////////////////////////////////////
        registerHerbs("aloe_vera", ALOE_VERA);
        registerHerbs("blood_orchid", BLOOD_ORCHID);
        registerHerbs("chamomile", CHAMOMILE);
        registerHerbs("cloud_lily", CLOUD_LILY);
        registerHerbs("cohosh", COHOSH);
        registerHerbs("horsetail", HORSETAIL);
        registerHerbs("wind_thistle", WIND_THISTLE);
        registerHerbs("nightshroom", NIGHTSHROOM);
        registerHerbs("green_spored_asbestos", GREEN_SPORED_ASBESTOS);
        registerHerbs("core_root", CORE_ROOT);
        registerHerbs("ginseng", GINSENG);
        registerHerbs("marshmallow", MARSHMALLOW);


        //////////////////////////////////////////////////////////
        ///               Alchemy Blocks Registry              ///
        //////////////////////////////////////////////////////////
        register("condenser", CONDENSER, HERB_TAB);
        register("retort", RETORT, HERB_TAB);


        initOxidizables();
        initStrippableWoods();
        ModFireBlock.registerFlammableBlock();

    }

    public static void initOxidizables()
    {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(CHAIN_COPPER, CHAIN_EXPOSED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(CHAIN_EXPOSED_COPPER, CHAIN_WEATHERED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(CHAIN_WEATHERED_COPPER, CHAIN_OXIDIZED_COPPER);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(CHANDELIER_COPPER, CHANDELIER_EXPOSED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(CHANDELIER_EXPOSED_COPPER, CHANDELIER_WEATHERED_COPPER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(CHANDELIER_WEATHERED_COPPER, CHANDELIER_OXIDIZED_COPPER);

        OxidizableBlocksRegistry.registerWaxableBlockPair(CHAIN_COPPER, CHAIN_WAXED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CHAIN_EXPOSED_COPPER, CHAIN_WAXED_EXPOSED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CHAIN_WEATHERED_COPPER, CHAIN_WAXED_WEATHERED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CHAIN_OXIDIZED_COPPER, CHAIN_WAXED_OXIDIZED_COPPER);

        OxidizableBlocksRegistry.registerWaxableBlockPair(CHANDELIER_COPPER, CHANDELIER_WAXED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CHANDELIER_EXPOSED_COPPER, CHANDELIER_WAXED_EXPOSED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CHANDELIER_WEATHERED_COPPER, CHANDELIER_WAXED_WEATHERED_COPPER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(CHANDELIER_OXIDIZED_COPPER, CHANDELIER_WAXED_OXIDIZED_COPPER);
    }

    public static void initStrippableWoods()
    {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(ModBlocks.IRONWOOD_LOG, ModBlocks.STRIPPED_IRONWOOD_LOG);
        AxeItem.STRIPPABLES.put(ModBlocks.IRONWOOD_WOOD, ModBlocks.STRIPPED_IRONWOOD_WOOD);
        AxeItem.STRIPPABLES.put(ModBlocks.OLIVE_LOG, ModBlocks.STRIPPED_OLIVE_LOG);
        AxeItem.STRIPPABLES.put(ModBlocks.OLIVE_WOOD, ModBlocks.STRIPPED_IRONWOOD_WOOD);
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

        Registry.register(Registry.ITEM, new ResourceLocation(ElixirEmporium.MOD_ID, name), item);

        return anyBlock;
    }

    static <T extends Block> T registerHerbs(String name, T anyBlock)
    {
        T block = Registry.register(Registry.BLOCK, new ResourceLocation(ElixirEmporium.MOD_ID, name), anyBlock);
        BLOCKS.put(new ResourceLocation(ElixirEmporium.MOD_ID, name), block);
        //BlockItem blockItem = new BlockItem(block, new Item.Properties().tab(tab));

        //Registry.register(Registry.ITEM, new ResourceLocation(ElixirEmporium.MOD_ID, name), blockItem);

        return anyBlock;
    }

}
