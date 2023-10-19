package net.mcs3.rusticated.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.world.level.block.*;
import net.mcs3.rusticated.world.level.block.alchemy.AdvCondenserBlock;
import net.mcs3.rusticated.world.level.block.alchemy.AdvRetortBlock;
import net.mcs3.rusticated.world.level.block.alchemy.CondenserBlock;
import net.mcs3.rusticated.world.level.block.alchemy.RetortBlock;
import net.mcs3.rusticated.world.level.block.crop.*;
import net.mcs3.rusticated.world.level.block.grower.IronwoodTreeGrower;
import net.mcs3.rusticated.world.level.block.grower.OliveTreeGrower;
import net.mcs3.rusticated.world.level.block.storage.LiquidBarrelBlock;
import net.mcs3.rusticated.world.level.block.storage.barrel.BarrelBlock;
import net.mcs3.rusticated.world.level.block.storage.jar.FiredJarBlock;
import net.mcs3.rusticated.world.level.block.storage.jar.GlazedJarBlock;
import net.mcs3.rusticated.world.level.block.storage.pot.PotBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.HashMap;
import java.util.Map;


public class ModBlocks
{
    public static final Map<ResourceLocation, Block> BLOCKS = new HashMap<>();

    public static final Block STORAGE_BARREL = new BarrelBlock();
    public static final Block LIQUID_BARREL = new LiquidBarrelBlock();

    public static final Block UNFIRED_JAR = new ModBlock(Properties.of().mapColor(MapColor.CLAY).instabreak().noOcclusion());
    public static final Block FIRED_JAR = new FiredJarBlock();
    public static final Block GLAZED_JAR_0 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_1 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_2 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_3 = new GlazedJarBlock();
    public static final Block GLAZED_JAR_4 = new GlazedJarBlock();

    public static final Block UNFIRED_POT = new ModBlock(Properties.of().mapColor(MapColor.CLAY).instabreak().noOcclusion());
    public static final Block FIRED_POT = new PotBlock(8);
    public static final Block GLAZED_POT_0 = new PotBlock(16);
    public static final Block GLAZED_POT_1 = new PotBlock(16);
    public static final Block GLAZED_POT_2 = new PotBlock(16);
    public static final Block GLAZED_POT_3 = new PotBlock(16);
    public static final Block GLAZED_POT_4 = new PotBlock(16);

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

    public static final PlanksBlock PAINTED_PLANKS_WHITE = new PlanksBlock(MapColor.SNOW);
    public static final PlanksBlock PAINTED_PLANKS_ORANGE = new PlanksBlock(MapColor.COLOR_ORANGE);
    public static final PlanksBlock PAINTED_PLANKS_MAGENTA = new PlanksBlock(MapColor.COLOR_MAGENTA);
    public static final PlanksBlock PAINTED_PLANKS_LIGHT_BLUE = new PlanksBlock(MapColor.COLOR_LIGHT_BLUE);
    public static final PlanksBlock PAINTED_PLANKS_YELLOW = new PlanksBlock(MapColor.COLOR_YELLOW);
    public static final PlanksBlock PAINTED_PLANKS_LIME = new PlanksBlock(MapColor.COLOR_LIGHT_GREEN);
    public static final PlanksBlock PAINTED_PLANKS_PINK = new PlanksBlock(MapColor.COLOR_PINK);
    public static final PlanksBlock PAINTED_PLANKS_GRAY = new PlanksBlock(MapColor.COLOR_GRAY);
    public static final PlanksBlock PAINTED_PLANKS_LIGHT_GRAY = new PlanksBlock(MapColor.COLOR_LIGHT_GRAY);
    public static final PlanksBlock PAINTED_PLANKS_CYAN = new PlanksBlock(MapColor.COLOR_CYAN);
    public static final PlanksBlock PAINTED_PLANKS_PURPLE = new PlanksBlock(MapColor.COLOR_PURPLE);
    public static final PlanksBlock PAINTED_PLANKS_BLUE = new PlanksBlock(MapColor.COLOR_BLUE);
    public static final PlanksBlock PAINTED_PLANKS_BROWN = new PlanksBlock(MapColor.COLOR_BROWN);
    public static final PlanksBlock PAINTED_PLANKS_GREEN = new PlanksBlock(MapColor.COLOR_GREEN);
    public static final PlanksBlock PAINTED_PLANKS_RED = new PlanksBlock(MapColor.COLOR_RED);
    public static final PlanksBlock PAINTED_PLANKS_BLACK = new PlanksBlock(MapColor.COLOR_BLACK);

    public static final ModSlabBlock PAINTED_SLAB_WHITE = new ModSlabBlock(MapColor.SNOW);
    public static final ModSlabBlock PAINTED_SLAB_ORANGE = new ModSlabBlock(MapColor.COLOR_ORANGE);
    public static final ModSlabBlock PAINTED_SLAB_MAGENTA = new ModSlabBlock(MapColor.COLOR_MAGENTA);
    public static final ModSlabBlock PAINTED_SLAB_LIGHT_BLUE = new ModSlabBlock(MapColor.COLOR_LIGHT_BLUE);
    public static final ModSlabBlock PAINTED_SLAB_YELLOW = new ModSlabBlock(MapColor.COLOR_YELLOW);
    public static final ModSlabBlock PAINTED_SLAB_LIME = new ModSlabBlock(MapColor.COLOR_LIGHT_GREEN);
    public static final ModSlabBlock PAINTED_SLAB_PINK = new ModSlabBlock(MapColor.COLOR_PINK);
    public static final ModSlabBlock PAINTED_SLAB_GRAY = new ModSlabBlock(MapColor.COLOR_GRAY);
    public static final ModSlabBlock PAINTED_SLAB_LIGHT_GRAY = new ModSlabBlock(MapColor.COLOR_LIGHT_GRAY);
    public static final ModSlabBlock PAINTED_SLAB_CYAN = new ModSlabBlock(MapColor.COLOR_CYAN);
    public static final ModSlabBlock PAINTED_SLAB_PURPLE = new ModSlabBlock(MapColor.COLOR_PURPLE);
    public static final ModSlabBlock PAINTED_SLAB_BLUE = new ModSlabBlock(MapColor.COLOR_BLUE);
    public static final ModSlabBlock PAINTED_SLAB_BROWN = new ModSlabBlock(MapColor.COLOR_BROWN);
    public static final ModSlabBlock PAINTED_SLAB_GREEN = new ModSlabBlock(MapColor.COLOR_GREEN);
    public static final ModSlabBlock PAINTED_SLAB_RED = new ModSlabBlock(MapColor.COLOR_RED);
    public static final ModSlabBlock PAINTED_SLAB_BLACK = new ModSlabBlock(MapColor.COLOR_BLACK);

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
    public static final BlockSetType IRONWOOD_SET = new BlockSetType(new ResourceLocation(Rusticated.MOD_ID, "ironwood").toString());
    public static final BlockSetType OLIVE_SET = new BlockSetType(new ResourceLocation(Rusticated.MOD_ID, "olive").toString());

    public static final WoodType IRONWOOD_TYPE = WoodTypeRegistry.register(new ResourceLocation(Rusticated.MOD_ID, "ironwood"), IRONWOOD_SET);
    public static final WoodType OLIVE_TYPE = WoodTypeRegistry.register(new ResourceLocation(Rusticated.MOD_ID, "olive"), OLIVE_SET);



    public static final Block IRONWOOD_SAPLING = new SaplingBlock(new IronwoodTreeGrower(), Properties.copy(Blocks.OAK_SAPLING));
    public static final Block POTTED_IRONWOOD_SAPLING = new FlowerPotBlock(IRONWOOD_SAPLING, Properties.copy(Blocks.POTTED_OAK_SAPLING));
    public static final Block IRONWOOD_LEAVES = new LeavesBlock(Properties.copy(Blocks.ACACIA_LEAVES));

    public static final Block IRONWOOD_LOG = new RotatedPillarBlock(Properties.copy(Blocks.ACACIA_LOG));
    public static final Block IRONWOOD_WOOD = new RotatedPillarBlock(Properties.copy(Blocks.ACACIA_WOOD));
    public static final Block STRIPPED_IRONWOOD_LOG = new RotatedPillarBlock(Properties.copy(Blocks.ACACIA_WOOD));
    public static final Block STRIPPED_IRONWOOD_WOOD = new RotatedPillarBlock(Properties.copy(Blocks.ACACIA_WOOD));
    public static final Block IRONWOOD_PLANKS = new PlanksBlock(MapColor.SAND);
    public static final ModSlabBlock IRONWOOD_SLAB = new ModSlabBlock(MapColor.SAND);
    public static final ModStairsBlock IRONWOOD_STAIRS = new ModStairsBlock(IRONWOOD_PLANKS.defaultBlockState(), Properties.copy(IRONWOOD_PLANKS));
    public static final Block IRONWOOD_FENCE = new FenceBlock(Properties.copy(IRONWOOD_PLANKS));
    public static final Block IRONWOOD_GATE = new FenceGateBlock(Properties.copy(IRONWOOD_PLANKS), IRONWOOD_TYPE);

    //////////////////////////////////////////////////////////
    ///               Olive Blocks                  ///
    //////////////////////////////////////////////////////////
    public static final Block OLIVE_SAPLING = new SaplingBlock(new OliveTreeGrower(), Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    public static final Block POTTED_OLIVE_SAPLING = new FlowerPotBlock(OLIVE_SAPLING, Properties.of().instabreak().noOcclusion());
    public static final Block OLIVE_LEAVES = new LeavesBlock(Properties.copy(Blocks.ACACIA_LEAVES));

    public static final Block OLIVE_LOG = new RotatedPillarBlock(Properties.copy(Blocks.SPRUCE_LOG));
    public static final Block OLIVE_WOOD = new RotatedPillarBlock(Properties.copy(Blocks.SPRUCE_LOG));
    public static final Block STRIPPED_OLIVE_LOG = new RotatedPillarBlock(Properties.copy(Blocks.SPRUCE_LOG));
    public static final Block STRIPPED_OLIVE_WOOD = new RotatedPillarBlock(Properties.copy(Blocks.SPRUCE_LOG));
    public static final Block OLIVE_PLANKS = new PlanksBlock(MapColor.PODZOL);
    public static final ModSlabBlock OLIVE_SLAB = new ModSlabBlock(MapColor.PODZOL);
    public static final ModStairsBlock OLIVE_STAIRS = new ModStairsBlock(OLIVE_PLANKS.defaultBlockState(), Properties.copy(OLIVE_PLANKS));
    public static final Block OLIVE_FENCE = new FenceBlock(Properties.copy(OLIVE_PLANKS));
    public static final Block OLIVE_GATE = new FenceGateBlock(Properties.copy(OLIVE_PLANKS), OLIVE_TYPE);


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
    public static final Block ADV_CONDENSER = new AdvCondenserBlock();
    public static final Block ADV_RETORT = new AdvRetortBlock();

    //////////////////////////////////////////////////////////
    ///                  Brewing Blocks                    ///
    //////////////////////////////////////////////////////////
    public static final Block EVAPORATING_BASIN = new EvaporatingBasinBlock();
    public static final Block CRUSHING_TUB = new CrushingTubBlock();
    public static final Block OAK_BREWING_BARREL = new OakBrewingBarrel();





    public static void preInitBlocks(){}


    public static void init() {
        register("storage_barrel", STORAGE_BARREL);
        registerSpecial("liquid_barrel", LIQUID_BARREL, ModBlockItems.LIQUID_BARREL_ITEM);

        register("unfired_jar", UNFIRED_JAR);
        registerSpecial("fired_jar", FIRED_JAR , ModBlockItems.FIRED_JAR_ITEM);
        registerSpecial("glazed_jar_0", GLAZED_JAR_0 , ModBlockItems.GLAZED_JAR_0_ITEM);
        registerSpecial("glazed_jar_1", GLAZED_JAR_1 , ModBlockItems.GLAZED_JAR_1_ITEM);
        registerSpecial("glazed_jar_2", GLAZED_JAR_2 , ModBlockItems.GLAZED_JAR_2_ITEM);
        registerSpecial("glazed_jar_3", GLAZED_JAR_3 , ModBlockItems.GLAZED_JAR_3_ITEM);
        registerSpecial("glazed_jar_4", GLAZED_JAR_4 , ModBlockItems.GLAZED_JAR_4_ITEM);

        register("unfired_pot", UNFIRED_POT);
        register("fired_pot", FIRED_POT);
        register("glazed_pot_0", GLAZED_POT_0);
        register("glazed_pot_1", GLAZED_POT_1);
        register("glazed_pot_2", GLAZED_POT_2);
        register("glazed_pot_3", GLAZED_POT_3);
        register("glazed_pot_4", GLAZED_POT_4);

        register("iron_lattice", ModBlocks.IRON_LATTICE);

        register("chandelier_iron", CHANDELIER_IRON);
        register("chandelier_gold", CHANDELIER_GOLD);
        register("chandelier_copper", CHANDELIER_COPPER);
        register("chandelier_exposed_copper", CHANDELIER_EXPOSED_COPPER);
        register("chandelier_weathered_copper", CHANDELIER_WEATHERED_COPPER);
        register("chandelier_oxidized_copper", CHANDELIER_OXIDIZED_COPPER);
        register("chandelier_waxed_copper", CHANDELIER_WAXED_COPPER);
        register("chandelier_waxed_exposed_copper", CHANDELIER_WAXED_EXPOSED_COPPER);
        register("chandelier_waxed_weathered_copper", CHANDELIER_WAXED_WEATHERED_COPPER);
        register("chandelier_waxed_oxidized_copper", CHANDELIER_WAXED_OXIDIZED_COPPER);

        register("chain_gold", CHAIN_GOLD);
        register("chain_copper", CHAIN_COPPER);
        register("chain_exposed_copper", CHAIN_EXPOSED_COPPER);
        register("chain_weathered_copper", CHAIN_WEATHERED_COPPER);
        register("chain_oxidized_copper", CHAIN_OXIDIZED_COPPER);
        register("chain_waxed_copper", CHAIN_WAXED_COPPER);
        register("chain_waxed_exposed_copper", CHAIN_WAXED_EXPOSED_COPPER);
        register("chain_waxed_weathered_copper", CHAIN_WAXED_WEATHERED_COPPER);
        register("chain_waxed_oxidized_copper", CHAIN_WAXED_OXIDIZED_COPPER);

        register("ironwood_log", IRONWOOD_LOG);
        register("ironwood_wood", IRONWOOD_WOOD);
        register("stripped_ironwood_log", STRIPPED_IRONWOOD_LOG);
        register("stripped_ironwood_wood", STRIPPED_IRONWOOD_WOOD);
        register("ironwood_planks", IRONWOOD_PLANKS);
        register("ironwood_slab", IRONWOOD_SLAB);
        register("ironwood_stairs", IRONWOOD_STAIRS);
        register("ironwood_fence", IRONWOOD_FENCE);
        register("ironwood_gate", IRONWOOD_GATE);

        register("olive_log", OLIVE_LOG);
        register("olive_wood", OLIVE_WOOD);
        register("stripped_olive_log", STRIPPED_OLIVE_LOG);
        register("stripped_olive_wood", STRIPPED_OLIVE_WOOD);
        register("olive_planks", OLIVE_PLANKS);
        register("olive_slab", OLIVE_SLAB);
        register("olive_stairs", OLIVE_STAIRS);
        register("olive_fence", OLIVE_FENCE);
        register("olive_gate", OLIVE_GATE);

        register("stone_white", STONE_WHITE);
        register("stone_orange", STONE_ORANGE);
        register("stone_magenta", STONE_MAGENTA);
        register("stone_light_blue", STONE_LIGHT_BLUE);
        register("stone_yellow", STONE_YELLOW);
        register("stone_lime", STONE_LIME);
        register("stone_pink", STONE_PINK);
        register("stone_gray", STONE_GRAY);
        register("stone_light_gray", STONE_LIGHT_GRAY);
        register("stone_cyan", STONE_CYAN);
        register("stone_purple", STONE_PURPLE);
        register("stone_blue", STONE_BLUE);
        register("stone_brown", STONE_BROWN);
        register("stone_green", STONE_GREEN);
        register("stone_red", STONE_RED);
        register("stone_black", STONE_BLACK);

        register("stone_slab_white", STONE_SLAB_WHITE);
        register("stone_slab_orange", STONE_SLAB_ORANGE);
        register("stone_slab_magenta", STONE_SLAB_MAGENTA);
        register("stone_slab_light_blue", STONE_SLAB_LIGHT_BLUE);
        register("stone_slab_yellow", STONE_SLAB_YELLOW);
        register("stone_slab_lime", STONE_SLAB_LIME);
        register("stone_slab_pink", STONE_SLAB_PINK);
        register("stone_slab_gray", STONE_SLAB_GRAY);
        register("stone_slab_light_gray", STONE_SLAB_LIGHT_GRAY);
        register("stone_slab_cyan", STONE_SLAB_CYAN);
        register("stone_slab_purple", STONE_SLAB_PURPLE);
        register("stone_slab_blue", STONE_SLAB_BLUE);
        register("stone_slab_brown", STONE_SLAB_BROWN);
        register("stone_slab_green", STONE_SLAB_GREEN);
        register("stone_slab_red", STONE_SLAB_RED);
        register("stone_slab_black", STONE_SLAB_BLACK);

        register("stone_stairs_white", STONE_STAIRS_WHITE);
        register("stone_stairs_orange", STONE_STAIRS_ORANGE);
        register("stone_stairs_magenta", STONE_STAIRS_MAGENTA);
        register("stone_stairs_light_blue", STONE_STAIRS_LIGHT_BLUE);
        register("stone_stairs_yellow", STONE_STAIRS_YELLOW);
        register("stone_stairs_lime", STONE_STAIRS_LIME);
        register("stone_stairs_pink", STONE_STAIRS_PINK);
        register("stone_stairs_gray", STONE_STAIRS_GRAY);
        register("stone_stairs_light_gray", STONE_STAIRS_LIGHT_GRAY);
        register("stone_stairs_cyan", STONE_STAIRS_CYAN);
        register("stone_stairs_purple", STONE_STAIRS_PURPLE);
        register("stone_stairs_blue", STONE_STAIRS_BLUE);
        register("stone_stairs_brown", STONE_STAIRS_BROWN);
        register("stone_stairs_green", STONE_STAIRS_GREEN);
        register("stone_stairs_red", STONE_STAIRS_RED);
        register("stone_stairs_black", STONE_STAIRS_BLACK);

        register("cobblestone_white", COBBLESTONE_WHITE);
        register("cobblestone_orange", COBBLESTONE_ORANGE);
        register("cobblestone_magenta", COBBLESTONE_MAGENTA);
        register("cobblestone_light_blue", COBBLESTONE_LIGHT_BLUE);
        register("cobblestone_yellow", COBBLESTONE_YELLOW);
        register("cobblestone_lime", COBBLESTONE_LIME);
        register("cobblestone_pink", COBBLESTONE_PINK);
        register("cobblestone_gray", COBBLESTONE_GRAY);
        register("cobblestone_light_gray", COBBLESTONE_LIGHT_GRAY);
        register("cobblestone_cyan", COBBLESTONE_CYAN);
        register("cobblestone_purple", COBBLESTONE_PURPLE);
        register("cobblestone_blue", COBBLESTONE_BLUE);
        register("cobblestone_brown", COBBLESTONE_BROWN);
        register("cobblestone_green", COBBLESTONE_GREEN);
        register("cobblestone_red", COBBLESTONE_RED);
        register("cobblestone_black", COBBLESTONE_BLACK);

        register("cobblestone_slab_white", COBBLESTONE_SLAB_WHITE);
        register("cobblestone_slab_orange", COBBLESTONE_SLAB_ORANGE);
        register("cobblestone_slab_magenta", COBBLESTONE_SLAB_MAGENTA);
        register("cobblestone_slab_light_blue", COBBLESTONE_SLAB_LIGHT_BLUE);
        register("cobblestone_slab_yellow", COBBLESTONE_SLAB_YELLOW);
        register("cobblestone_slab_lime", COBBLESTONE_SLAB_LIME);
        register("cobblestone_slab_pink", COBBLESTONE_SLAB_PINK);
        register("cobblestone_slab_gray", COBBLESTONE_SLAB_GRAY);
        register("cobblestone_slab_light_gray", COBBLESTONE_SLAB_LIGHT_GRAY);
        register("cobblestone_slab_cyan", COBBLESTONE_SLAB_CYAN);
        register("cobblestone_slab_purple", COBBLESTONE_SLAB_PURPLE);
        register("cobblestone_slab_blue", COBBLESTONE_SLAB_BLUE);
        register("cobblestone_slab_brown", COBBLESTONE_SLAB_BROWN);
        register("cobblestone_slab_green", COBBLESTONE_SLAB_GREEN);
        register("cobblestone_slab_red", COBBLESTONE_SLAB_RED);
        register("cobblestone_slab_black", COBBLESTONE_SLAB_BLACK);

        register("cobblestone_stairs_white", COBBLESTONE_STAIRS_WHITE);
        register("cobblestone_stairs_orange", COBBLESTONE_STAIRS_ORANGE);
        register("cobblestone_stairs_magenta", COBBLESTONE_STAIRS_MAGENTA);
        register("cobblestone_stairs_light_blue", COBBLESTONE_STAIRS_LIGHT_BLUE);
        register("cobblestone_stairs_yellow", COBBLESTONE_STAIRS_YELLOW);
        register("cobblestone_stairs_lime", COBBLESTONE_STAIRS_LIME);
        register("cobblestone_stairs_pink", COBBLESTONE_STAIRS_PINK);
        register("cobblestone_stairs_gray", COBBLESTONE_STAIRS_GRAY);
        register("cobblestone_stairs_light_gray", COBBLESTONE_STAIRS_LIGHT_GRAY);
        register("cobblestone_stairs_cyan", COBBLESTONE_STAIRS_CYAN);
        register("cobblestone_stairs_purple", COBBLESTONE_STAIRS_PURPLE);
        register("cobblestone_stairs_blue", COBBLESTONE_STAIRS_BLUE);
        register("cobblestone_stairs_brown", COBBLESTONE_STAIRS_BROWN);
        register("cobblestone_stairs_green", COBBLESTONE_STAIRS_GREEN);
        register("cobblestone_stairs_red", COBBLESTONE_STAIRS_RED);
        register("cobblestone_stairs_black", COBBLESTONE_STAIRS_BLACK);

        register("cobblestone_wall_white", COBBLESTONE_WALL_WHITE);
        register("cobblestone_wall_orange", COBBLESTONE_WALL_ORANGE);
        register("cobblestone_wall_magenta", COBBLESTONE_WALL_MAGENTA);
        register("cobblestone_wall_light_blue", COBBLESTONE_WALL_LIGHT_BLUE);
        register("cobblestone_wall_yellow", COBBLESTONE_WALL_YELLOW);
        register("cobblestone_wall_lime", COBBLESTONE_WALL_LIME);
        register("cobblestone_wall_pink", COBBLESTONE_WALL_PINK);
        register("cobblestone_wall_gray", COBBLESTONE_WALL_GRAY);
        register("cobblestone_wall_light_gray", COBBLESTONE_WALL_LIGHT_GRAY);
        register("cobblestone_wall_cyan", COBBLESTONE_WALL_CYAN);
        register("cobblestone_wall_purple", COBBLESTONE_WALL_PURPLE);
        register("cobblestone_wall_blue", COBBLESTONE_WALL_BLUE);
        register("cobblestone_wall_brown", COBBLESTONE_WALL_BROWN);
        register("cobblestone_wall_green", COBBLESTONE_WALL_GREEN);
        register("cobblestone_wall_red", COBBLESTONE_WALL_RED);
        register("cobblestone_wall_black", COBBLESTONE_WALL_BLACK);

        register("painted_planks_white", PAINTED_PLANKS_WHITE);
        register("painted_planks_orange", PAINTED_PLANKS_ORANGE);
        register("painted_planks_magenta", PAINTED_PLANKS_MAGENTA);
        register("painted_planks_light_blue", PAINTED_PLANKS_LIGHT_BLUE);
        register("painted_planks_yellow", PAINTED_PLANKS_YELLOW);
        register("painted_planks_lime", PAINTED_PLANKS_LIME);
        register("painted_planks_pink", PAINTED_PLANKS_PINK);
        register("painted_planks_gray", PAINTED_PLANKS_GRAY);
        register("painted_planks_light_gray", PAINTED_PLANKS_LIGHT_GRAY);
        register("painted_planks_cyan", PAINTED_PLANKS_CYAN);
        register("painted_planks_purple", PAINTED_PLANKS_PURPLE);
        register("painted_planks_blue", PAINTED_PLANKS_BLUE);
        register("painted_planks_brown", PAINTED_PLANKS_BROWN);
        register("painted_planks_green", PAINTED_PLANKS_GREEN);
        register("painted_planks_red", PAINTED_PLANKS_RED);
        register("painted_planks_black", PAINTED_PLANKS_BLACK);

        register("painted_slab_white", PAINTED_SLAB_WHITE);
        register("painted_slab_orange", PAINTED_SLAB_ORANGE);
        register("painted_slab_magenta", PAINTED_SLAB_MAGENTA);
        register("painted_slab_light_blue", PAINTED_SLAB_LIGHT_BLUE);
        register("painted_slab_yellow", PAINTED_SLAB_YELLOW);
        register("painted_slab_lime", PAINTED_SLAB_LIME);
        register("painted_slab_pink", PAINTED_SLAB_PINK);
        register("painted_slab_gray", PAINTED_SLAB_GRAY);
        register("painted_slab_light_gray", PAINTED_SLAB_LIGHT_GRAY);
        register("painted_slab_cyan", PAINTED_SLAB_CYAN);
        register("painted_slab_purple", PAINTED_SLAB_PURPLE);
        register("painted_slab_blue", PAINTED_SLAB_BLUE);
        register("painted_slab_brown", PAINTED_SLAB_BROWN);
        register("painted_slab_green", PAINTED_SLAB_GREEN);
        register("painted_slab_red", PAINTED_SLAB_RED);
        register("painted_slab_black", PAINTED_SLAB_BLACK);

        register("painted_stairs_white", PAINTED_STAIRS_WHITE);
        register("painted_stairs_orange", PAINTED_STAIRS_ORANGE);
        register("painted_stairs_magenta", PAINTED_STAIRS_MAGENTA);
        register("painted_stairs_light_blue", PAINTED_STAIRS_LIGHT_BLUE);
        register("painted_stairs_yellow", PAINTED_STAIRS_YELLOW);
        register("painted_stairs_lime", PAINTED_STAIRS_LIME);
        register("painted_stairs_pink", PAINTED_STAIRS_PINK);
        register("painted_stairs_gray", PAINTED_STAIRS_GRAY);
        register("painted_stairs_light_gray", PAINTED_STAIRS_LIGHT_GRAY);
        register("painted_stairs_cyan", PAINTED_STAIRS_CYAN);
        register("painted_stairs_purple", PAINTED_STAIRS_PURPLE);
        register("painted_stairs_blue", PAINTED_STAIRS_BLUE);
        register("painted_stairs_brown", PAINTED_STAIRS_BROWN);
        register("painted_stairs_green", PAINTED_STAIRS_GREEN);
        register("painted_stairs_red", PAINTED_STAIRS_RED);
        register("painted_stairs_black", PAINTED_STAIRS_BLACK);

        register("framed_wall_white", FRAMED_WALL_WHITE);
        register("framed_wall_orange", FRAMED_WALL_ORANGE);
        register("framed_wall_magenta", FRAMED_WALL_MAGENTA);
        register("framed_wall_light_blue", FRAMED_WALL_LIGHT_BLUE);
        register("framed_wall_yellow", FRAMED_WALL_YELLOW);
        register("framed_wall_lime", FRAMED_WALL_LIME);
        register("framed_wall_pink", FRAMED_WALL_PINK);
        register("framed_wall_gray", FRAMED_WALL_GRAY);
        register("framed_wall_light_gray", FRAMED_WALL_LIGHT_GRAY);
        register("framed_wall_cyan", FRAMED_WALL_CYAN);
        register("framed_wall_purple", FRAMED_WALL_PURPLE);
        register("framed_wall_blue", FRAMED_WALL_BLUE);
        register("framed_wall_brown", FRAMED_WALL_BROWN);
        register("framed_wall_green", FRAMED_WALL_GREEN);
        register("framed_wall_red", FRAMED_WALL_RED);
        register("framed_wall_black", FRAMED_WALL_BLACK);

        register("framed_wall_cross_white", FRAMED_WALL_CROSS_WHITE);
        register("framed_wall_cross_orange", FRAMED_WALL_CROSS_ORANGE);
        register("framed_wall_cross_magenta", FRAMED_WALL_CROSS_MAGENTA);
        register("framed_wall_cross_light_blue", FRAMED_WALL_CROSS_LIGHT_BLUE);
        register("framed_wall_cross_yellow", FRAMED_WALL_CROSS_YELLOW);
        register("framed_wall_cross_lime", FRAMED_WALL_CROSS_LIME);
        register("framed_wall_cross_pink", FRAMED_WALL_CROSS_PINK);
        register("framed_wall_cross_gray", FRAMED_WALL_CROSS_GRAY);
        register("framed_wall_cross_light_gray", FRAMED_WALL_CROSS_LIGHT_GRAY);
        register("framed_wall_cross_cyan", FRAMED_WALL_CROSS_CYAN);
        register("framed_wall_cross_purple", FRAMED_WALL_CROSS_PURPLE);
        register("framed_wall_cross_blue", FRAMED_WALL_CROSS_BLUE);
        register("framed_wall_cross_brown", FRAMED_WALL_CROSS_BROWN);
        register("framed_wall_cross_green", FRAMED_WALL_CROSS_GREEN);
        register("framed_wall_cross_red", FRAMED_WALL_CROSS_RED);
        register("framed_wall_cross_black", FRAMED_WALL_CROSS_BLACK);

        register("framed_wall_rt_diag_white", FRAMED_WALL_RT_DIAG_WHITE);
        register("framed_wall_rt_diag_orange", FRAMED_WALL_RT_DIAG_ORANGE);
        register("framed_wall_rt_diag_magenta", FRAMED_WALL_RT_DIAG_MAGENTA);
        register("framed_wall_rt_diag_light_blue", FRAMED_WALL_RT_DIAG_LIGHT_BLUE);
        register("framed_wall_rt_diag_yellow", FRAMED_WALL_RT_DIAG_YELLOW);
        register("framed_wall_rt_diag_lime", FRAMED_WALL_RT_DIAG_LIME);
        register("framed_wall_rt_diag_pink", FRAMED_WALL_RT_DIAG_PINK);
        register("framed_wall_rt_diag_gray", FRAMED_WALL_RT_DIAG_GRAY);
        register("framed_wall_rt_diag_light_gray", FRAMED_WALL_RT_DIAG_LIGHT_GRAY);
        register("framed_wall_rt_diag_cyan", FRAMED_WALL_RT_DIAG_CYAN);
        register("framed_wall_rt_diag_purple", FRAMED_WALL_RT_DIAG_PURPLE);
        register("framed_wall_rt_diag_blue", FRAMED_WALL_RT_DIAG_BLUE);
        register("framed_wall_rt_diag_brown", FRAMED_WALL_RT_DIAG_BROWN);
        register("framed_wall_rt_diag_green", FRAMED_WALL_RT_DIAG_GREEN);
        register("framed_wall_rt_diag_red", FRAMED_WALL_RT_DIAG_RED);
        register("framed_wall_rt_diag_black", FRAMED_WALL_RT_DIAG_BLACK);

        register("framed_wall_left_diag_white", FRAMED_WALL_LEFT_DIAG_WHITE);
        register("framed_wall_left_diag_orange", FRAMED_WALL_LEFT_DIAG_ORANGE);
        register("framed_wall_left_diag_magenta", FRAMED_WALL_LEFT_DIAG_MAGENTA);
        register("framed_wall_left_diag_light_blue", FRAMED_WALL_LEFT_DIAG_LIGHT_BLUE);
        register("framed_wall_left_diag_yellow", FRAMED_WALL_LEFT_DIAG_YELLOW);
        register("framed_wall_left_diag_lime", FRAMED_WALL_LEFT_DIAG_LIME);
        register("framed_wall_left_diag_pink", FRAMED_WALL_LEFT_DIAG_PINK);
        register("framed_wall_left_diag_gray", FRAMED_WALL_LEFT_DIAG_GRAY);
        register("framed_wall_left_diag_light_gray", FRAMED_WALL_LEFT_DIAG_LIGHT_GRAY);
        register("framed_wall_left_diag_cyan", FRAMED_WALL_LEFT_DIAG_CYAN);
        register("framed_wall_left_diag_purple", FRAMED_WALL_LEFT_DIAG_PURPLE);
        register("framed_wall_left_diag_blue", FRAMED_WALL_LEFT_DIAG_BLUE);
        register("framed_wall_left_diag_brown", FRAMED_WALL_LEFT_DIAG_BROWN);
        register("framed_wall_left_diag_green", FRAMED_WALL_LEFT_DIAG_GREEN);
        register("framed_wall_left_diag_red", FRAMED_WALL_LEFT_DIAG_RED);
        register("framed_wall_left_diag_black", FRAMED_WALL_LEFT_DIAG_BLACK);

        register("cobblestone_path", COBBLESTONE_PATH);
        register("stone_path", STONE_PATH);
        register("granite_path", GRANITE_PATH);
        register("andesite_path", ANDESITE_PATH);
        register("diorite_path", DIORITE_PATH);
        register("cobbled_deepslate_path", COBBLED_DEEPSLATE_PATH);
        register("blackstone_path", BLACKSTONE_PATH);
        register("nether_bricks_path", NETHER_BRICKS_PATH);

        //////////////////////////////////////////////////////////
        ///          Agricultural Blocks Registry              ///
        //////////////////////////////////////////////////////////

        register("fertile_soil", FERTILE_SOIL);
        register("ironwood_sapling", IRONWOOD_SAPLING);
        registerBlocksOnly("potted_ironwood_sapling", POTTED_IRONWOOD_SAPLING);
        register("ironwood_leaves", IRONWOOD_LEAVES);

        register("olive_sapling", OLIVE_SAPLING);
        registerBlocksOnly("potted_olive_sapling", POTTED_OLIVE_SAPLING);
        register("olive_leaves", OLIVE_LEAVES);

        register("crop_stake", CROP_STAKE);
        registerBlocksOnly("tied_stake", TIED_STAKE);
        register("rope", ROPE);
        registerBlocksOnly("grape_stem", GRAPE_STEM);
        registerBlocksOnly("grape_leaves", GRAPE_LEAVES);

        //////////////////////////////////////////////////////////
        ///               Herbal Blocks Registry               ///
        //////////////////////////////////////////////////////////
        registerBlocksOnly("aloe_vera", ALOE_VERA);
        registerBlocksOnly("blood_orchid", BLOOD_ORCHID);
        registerBlocksOnly("chamomile", CHAMOMILE);
        registerBlocksOnly("cloud_lily", CLOUD_LILY);
        registerBlocksOnly("cohosh", COHOSH);
        registerBlocksOnly("horsetail", HORSETAIL);
        registerBlocksOnly("wind_thistle", WIND_THISTLE);
        registerBlocksOnly("nightshroom", NIGHTSHROOM);
        registerBlocksOnly("green_spored_asbestos", GREEN_SPORED_ASBESTOS);
        registerBlocksOnly("core_root", CORE_ROOT);
        registerBlocksOnly("ginseng", GINSENG);
        registerBlocksOnly("marshmallow", MARSHMALLOW);


        //////////////////////////////////////////////////////////
        ///               Alchemy Blocks Registry              ///
        //////////////////////////////////////////////////////////
        register("condenser", CONDENSER);
        register("retort", RETORT);
        register("adv_condenser", ADV_CONDENSER);
        register("adv_retort", ADV_RETORT);

        //////////////////////////////////////////////////////////
        ///               Brewing Blocks Registry              ///
        //////////////////////////////////////////////////////////
        register("evaporating_basin", EVAPORATING_BASIN);
        register("crushing_tub", CRUSHING_TUB);
        register("oak_brewing_barrel", OAK_BREWING_BARREL);


        initOxidizables();
        initStrippableWoods();
        ModFireBlock.registerFlammableBlock();

    }

    public static void initOxidizables() {
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

    public static void initStrippableWoods() {
        StrippableBlockRegistry.register(ModBlocks.IRONWOOD_LOG, ModBlocks.STRIPPED_IRONWOOD_LOG);
        StrippableBlockRegistry.register(ModBlocks.IRONWOOD_WOOD, ModBlocks.STRIPPED_IRONWOOD_WOOD);
        StrippableBlockRegistry.register(ModBlocks.OLIVE_LOG, ModBlocks.STRIPPED_OLIVE_LOG);
        StrippableBlockRegistry.register(ModBlocks.OLIVE_WOOD, ModBlocks.STRIPPED_OLIVE_WOOD);
    }

    private static Block register(String name, Block anyBlock) {
        registerBlockItem(name, anyBlock);
        BLOCKS.put(new ResourceLocation(Rusticated.MOD_ID, name), anyBlock);


        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Rusticated.MOD_ID, name), anyBlock);
    }

    private static Block registerSpecial(String name, Block anyBlock, BlockItem item) {
        BLOCKS.put(new ResourceLocation(Rusticated.MOD_ID, name), anyBlock);

        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Rusticated.MOD_ID, name), item);

        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Rusticated.MOD_ID, name), anyBlock);
    }

    private static Block registerBlocksOnly(String name, Block anyBlock) {
        BLOCKS.put(new ResourceLocation(Rusticated.MOD_ID, name), anyBlock);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Rusticated.MOD_ID, name), anyBlock);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Rusticated.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));

        return item;
    }


}
