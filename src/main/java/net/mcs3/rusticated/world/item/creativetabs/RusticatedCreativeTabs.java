package net.mcs3.rusticated.world.item.creativetabs;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.mcs3.rusticated.Rusticated;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModFluids;
import net.mcs3.rusticated.init.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class RusticatedCreativeTabs {

    public static CreativeModeTab ITEMGROUPDECO = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Rusticated.MOD_ID, "item_group_deco"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.rusticated.item_group_deco"))
                    .icon(() -> ModBlocks.GLAZED_POT_4.asItem().getDefaultInstance()).displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.STORAGE_BARREL.asItem());
                        output.accept(ModBlocks.LIQUID_BARREL.asItem());

                        output.accept(ModBlocks.UNFIRED_JAR.asItem());
                        output.accept(ModBlocks.FIRED_JAR.asItem());
                        output.accept(ModBlocks.GLAZED_JAR_0.asItem());
                        output.accept(ModBlocks.GLAZED_JAR_1.asItem());
                        output.accept(ModBlocks.GLAZED_JAR_2.asItem());
                        output.accept(ModBlocks.GLAZED_JAR_3.asItem());
                        output.accept(ModBlocks.GLAZED_JAR_4.asItem());

                        output.accept(ModBlocks.UNFIRED_POT.asItem());
                        output.accept(ModBlocks.FIRED_POT.asItem());
                        output.accept(ModBlocks.GLAZED_POT_0.asItem());
                        output.accept(ModBlocks.GLAZED_POT_1.asItem());
                        output.accept(ModBlocks.GLAZED_POT_2.asItem());
                        output.accept(ModBlocks.GLAZED_POT_3.asItem());
                        output.accept(ModBlocks.GLAZED_POT_4.asItem());

                        output.accept(ModBlocks.IRON_LATTICE.asItem());

                        output.accept(ModBlocks.IRONWOOD_LOG.asItem());
                        output.accept(ModBlocks.IRONWOOD_WOOD.asItem());
                        output.accept(ModBlocks.STRIPPED_IRONWOOD_LOG.asItem());
                        output.accept(ModBlocks.STRIPPED_IRONWOOD_WOOD.asItem());
                        output.accept(ModBlocks.IRONWOOD_PLANKS.asItem());
                        output.accept(ModBlocks.IRONWOOD_SLAB.asItem());
                        output.accept(ModBlocks.IRONWOOD_STAIRS.asItem());
                        output.accept(ModBlocks.IRONWOOD_FENCE.asItem());
                        output.accept(ModBlocks.IRONWOOD_GATE.asItem());
                        
                        output.accept(ModBlocks.OLIVE_LOG.asItem());
                        output.accept(ModBlocks.OLIVE_WOOD.asItem());
                        output.accept(ModBlocks.STRIPPED_OLIVE_LOG.asItem());
                        output.accept(ModBlocks.STRIPPED_OLIVE_WOOD.asItem());
                        output.accept(ModBlocks.OLIVE_PLANKS.asItem());
                        output.accept(ModBlocks.OLIVE_SLAB.asItem());
                        output.accept(ModBlocks.OLIVE_STAIRS.asItem());
                        output.accept(ModBlocks.OLIVE_FENCE.asItem());
                        output.accept(ModBlocks.OLIVE_GATE.asItem());

                        output.accept(ModBlocks.CHANDELIER_IRON.asItem());
                        output.accept(ModBlocks.CHANDELIER_GOLD.asItem());
                        output.accept(ModBlocks.CHANDELIER_COPPER.asItem());
                        output.accept(ModBlocks.CHANDELIER_EXPOSED_COPPER.asItem());
                        output.accept(ModBlocks.CHANDELIER_WEATHERED_COPPER.asItem());
                        output.accept(ModBlocks.CHANDELIER_OXIDIZED_COPPER.asItem());
                        output.accept(ModBlocks.CHANDELIER_WAXED_COPPER.asItem());
                        output.accept(ModBlocks.CHANDELIER_WAXED_EXPOSED_COPPER.asItem());
                        output.accept(ModBlocks.CHANDELIER_WAXED_WEATHERED_COPPER.asItem());
                        output.accept(ModBlocks.CHANDELIER_WAXED_OXIDIZED_COPPER.asItem());

                        output.accept(ModBlocks.CHAIN_GOLD.asItem());
                        output.accept(ModBlocks.CHAIN_COPPER.asItem());
                        output.accept(ModBlocks.CHAIN_EXPOSED_COPPER.asItem());
                        output.accept(ModBlocks.CHAIN_WEATHERED_COPPER.asItem());
                        output.accept(ModBlocks.CHAIN_OXIDIZED_COPPER.asItem());
                        output.accept(ModBlocks.CHAIN_WAXED_COPPER.asItem());
                        output.accept(ModBlocks.CHAIN_WAXED_EXPOSED_COPPER.asItem());
                        output.accept(ModBlocks.CHAIN_WAXED_WEATHERED_COPPER.asItem());
                        output.accept(ModBlocks.CHAIN_WAXED_OXIDIZED_COPPER.asItem());

                        output.accept(ModBlocks.STONE_WHITE.asItem());
                        output.accept(ModBlocks.STONE_ORANGE.asItem());
                        output.accept(ModBlocks.STONE_MAGENTA.asItem());
                        output.accept(ModBlocks.STONE_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.STONE_YELLOW.asItem());
                        output.accept(ModBlocks.STONE_LIME.asItem());
                        output.accept(ModBlocks.STONE_PINK.asItem());
                        output.accept(ModBlocks.STONE_GRAY.asItem());
                        output.accept(ModBlocks.STONE_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.STONE_CYAN.asItem());
                        output.accept(ModBlocks.STONE_PURPLE.asItem());
                        output.accept(ModBlocks.STONE_BLUE.asItem());
                        output.accept(ModBlocks.STONE_BROWN.asItem());
                        output.accept(ModBlocks.STONE_GREEN.asItem());
                        output.accept(ModBlocks.STONE_RED.asItem());
                        output.accept(ModBlocks.STONE_BLACK.asItem());

                        output.accept(ModBlocks.STONE_SLAB_WHITE.asItem());
                        output.accept(ModBlocks.STONE_SLAB_ORANGE.asItem());
                        output.accept(ModBlocks.STONE_SLAB_MAGENTA.asItem());
                        output.accept(ModBlocks.STONE_SLAB_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.STONE_SLAB_YELLOW.asItem());
                        output.accept(ModBlocks.STONE_SLAB_LIME.asItem());
                        output.accept(ModBlocks.STONE_SLAB_PINK.asItem());
                        output.accept(ModBlocks.STONE_SLAB_GRAY.asItem());
                        output.accept(ModBlocks.STONE_SLAB_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.STONE_SLAB_CYAN.asItem());
                        output.accept(ModBlocks.STONE_SLAB_PURPLE.asItem());
                        output.accept(ModBlocks.STONE_SLAB_BLUE.asItem());
                        output.accept(ModBlocks.STONE_SLAB_BROWN.asItem());
                        output.accept(ModBlocks.STONE_SLAB_GREEN.asItem());
                        output.accept(ModBlocks.STONE_SLAB_RED.asItem());
                        output.accept(ModBlocks.STONE_SLAB_BLACK.asItem());

                        output.accept(ModBlocks.STONE_STAIRS_WHITE .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_ORANGE .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_MAGENTA .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_LIGHT_BLUE .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_YELLOW .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_LIME .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_PINK .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_GRAY .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_LIGHT_GRAY .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_CYAN .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_PURPLE .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_BLUE .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_BROWN .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_GREEN .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_RED .asItem());
                        output.accept(ModBlocks.STONE_STAIRS_BLACK .asItem());

                        output.accept(ModBlocks.COBBLESTONE_WHITE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_ORANGE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_MAGENTA.asItem());
                        output.accept(ModBlocks.COBBLESTONE_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_YELLOW.asItem());
                        output.accept(ModBlocks.COBBLESTONE_LIME.asItem());
                        output.accept(ModBlocks.COBBLESTONE_PINK.asItem());
                        output.accept(ModBlocks.COBBLESTONE_GRAY.asItem());
                        output.accept(ModBlocks.COBBLESTONE_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.COBBLESTONE_CYAN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_PURPLE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_BLUE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_BROWN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_GREEN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_RED.asItem());
                        output.accept(ModBlocks.COBBLESTONE_BLACK.asItem());

                        output.accept(ModBlocks.COBBLESTONE_SLAB_WHITE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_ORANGE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_MAGENTA.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_YELLOW.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_LIME.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_PINK.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_GRAY.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_CYAN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_PURPLE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_BLUE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_BROWN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_GREEN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_RED.asItem());
                        output.accept(ModBlocks.COBBLESTONE_SLAB_BLACK.asItem());

                        output.accept(ModBlocks.COBBLESTONE_STAIRS_WHITE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_ORANGE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_MAGENTA.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_YELLOW.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_LIME.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_PINK.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_GRAY.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_CYAN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_PURPLE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_BLUE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_BROWN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_GREEN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_RED.asItem());
                        output.accept(ModBlocks.COBBLESTONE_STAIRS_BLACK.asItem());

                        output.accept(ModBlocks.COBBLESTONE_WALL_WHITE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_ORANGE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_MAGENTA.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_YELLOW.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_LIME.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_PINK.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_GRAY.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_CYAN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_PURPLE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_BLUE.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_BROWN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_GREEN.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_RED.asItem());
                        output.accept(ModBlocks.COBBLESTONE_WALL_BLACK.asItem());

                        output.accept(ModBlocks.PAINTED_PLANKS_WHITE.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_ORANGE.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_MAGENTA.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_YELLOW.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_LIME.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_PINK.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_GRAY.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_CYAN.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_PURPLE.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_BLUE.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_BROWN.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_GREEN.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_RED.asItem());
                        output.accept(ModBlocks.PAINTED_PLANKS_BLACK.asItem());

                        output.accept(ModBlocks.PAINTED_SLAB_WHITE.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_ORANGE.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_MAGENTA.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_YELLOW.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_LIME.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_PINK.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_GRAY.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_CYAN.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_PURPLE.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_BLUE.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_BROWN.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_GREEN.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_RED.asItem());
                        output.accept(ModBlocks.PAINTED_SLAB_BLACK.asItem());

                        output.accept(ModBlocks.PAINTED_STAIRS_WHITE.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_ORANGE.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_MAGENTA.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_YELLOW.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_LIME.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_PINK.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_GRAY.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_CYAN.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_PURPLE.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_BLUE.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_BROWN.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_GREEN.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_RED.asItem());
                        output.accept(ModBlocks.PAINTED_STAIRS_BLACK.asItem());

                        output.accept(ModBlocks.FRAMED_WALL_CROSS_WHITE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_ORANGE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_MAGENTA.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_YELLOW.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_LIME.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_PINK.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_GRAY.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_CYAN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_PURPLE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_BLUE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_BROWN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_GREEN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_RED.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CROSS_BLACK.asItem());

                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_WHITE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_ORANGE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_MAGENTA.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_YELLOW.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_LIME.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_PINK.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_GRAY.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_CYAN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_PURPLE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_BLUE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_BROWN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_GREEN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_RED.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RT_DIAG_BLACK.asItem());

                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_WHITE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_ORANGE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_MAGENTA.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_YELLOW.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_LIME.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_PINK.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_GRAY.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_CYAN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_PURPLE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_BLUE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_BROWN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_GREEN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_RED.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LEFT_DIAG_BLACK.asItem());

                        output.accept(ModBlocks.FRAMED_WALL_WHITE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_ORANGE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_MAGENTA.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LIGHT_BLUE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_YELLOW.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LIME.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_PINK.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_GRAY.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_LIGHT_GRAY.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_CYAN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_PURPLE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_BLUE.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_BROWN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_GREEN.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_RED.asItem());
                        output.accept(ModBlocks.FRAMED_WALL_BLACK.asItem());

                        output.accept(ModBlocks.COBBLESTONE_PATH.asItem());
                        output.accept(ModBlocks.STONE_PATH.asItem());
                        output.accept(ModBlocks.GRANITE_PATH.asItem());
                        output.accept(ModBlocks.ANDESITE_PATH.asItem());
                        output.accept(ModBlocks.DIORITE_PATH.asItem());
                        output.accept(ModBlocks.COBBLED_DEEPSLATE_PATH.asItem());
                        output.accept(ModBlocks.BLACKSTONE_PATH.asItem());
                        output.accept(ModBlocks.NETHER_BRICKS_PATH.asItem());
                        output.accept(ModItems.CATALOG);
                        output.accept(ModItems.COPPER_NUGGET);
                        

                    }).build());

    public static CreativeModeTab ITEMGROUPAG = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Rusticated.MOD_ID, "item_group_ag"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.rusticated.item_group_ag"))
                    .icon(() -> ModItems.GRAPES.getDefaultInstance()).displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.FERTILE_SOIL.asItem());
                        output.accept(ModBlocks.CROP_STAKE.asItem());
                        output.accept(ModBlocks.ROPE.asItem());

                        output.accept(ModBlocks.IRONWOOD_SAPLING.asItem());
                        output.accept(ModBlocks.IRONWOOD_LEAVES.asItem());
                        output.accept(ModBlocks.OLIVE_SAPLING.asItem());
                        output.accept(ModBlocks.OLIVE_LEAVES.asItem());

                        output.accept(ModItems.UNFIRED_EVAPORATING_BASIN);
                        output.accept(ModBlocks.EVAPORATING_BASIN.asItem());
                        output.accept(ModBlocks.CRUSHING_TUB.asItem());
                        output.accept(ModBlocks.OAK_BREWING_BARREL.asItem());

                        output.accept(ModFluids.OLIVE_OIL_BUCKET);
                        output.accept(ModFluids.IRONBERRY_JUICE_BUCKET);
                        output.accept(ModFluids.SWEET_BERRY_JUICE_BUCKET);
                        output.accept(ModFluids.GRAPE_JUICE_BUCKET);
                        output.accept(ModFluids.APPLE_JUICE_BUCKET);
                        output.accept(ModFluids.ALE_WORT_BUCKET);
                        output.accept(ModFluids.HONEY_BUCKET);

                        output.accept(ModItems.OLIVES);
                        output.accept(ModItems.IRON_BERRIES);
                        output.accept(ModItems.GRAPE_SEEDS);
                        output.accept(ModItems.GRAPES);
                        output.accept(ModItems.OLIVE_OIL_BOTTLE);
                        output.accept(ModItems.IRONBERRY_JUICE_BOTTLE);
                        output.accept(ModItems.SWEET_BERRY_JUICE_BOTTLE);
                        output.accept(ModItems.GRAPE_JUICE_BOTTLE);
                        output.accept(ModItems.APPLE_JUICE_BOTTLE);
                        output.accept(ModItems.ALE_WORT_BOTTLE);
                        output.accept(ModFluids.ALE_CUP);
                        output.accept(ModFluids.CIDER_CUP);
                        output.accept(ModFluids.IRON_WINE_CUP);
                        output.accept(ModFluids.MEAD_CUP);
                        output.accept(ModFluids.SWEET_BERRY_WINE_CUP);
                        output.accept(ModFluids.WINE_CUP);
                        output.accept(ModItems.TINY_IRON_DUST);
                        output.accept(ModItems.OILED_APPLE);
                        output.accept(ModItems.OILED_BAKED_POTATO);
                        output.accept(ModItems.OILED_BEEF);
                        output.accept(ModItems.OILED_BEETROOT);
                        output.accept(ModItems.OILED_BEETROOT_SOUP);
                        output.accept(ModItems.OILED_BREAD);
                        output.accept(ModItems.OILED_CARROT);
                        output.accept(ModItems.OILED_CHICKEN);
                        output.accept(ModItems.OILED_CHORUS_FRUIT);
                        output.accept(ModItems.OILED_COD);
                        output.accept(ModItems.OILED_COOKED_BEEF);
                        output.accept(ModItems.OILED_COOKED_CHICKEN);
                        output.accept(ModItems.OILED_COOKED_COD);
                        output.accept(ModItems.OILED_COOKED_MUTTON);
                        output.accept(ModItems.OILED_COOKED_PORKCHOP);
                        output.accept(ModItems.OILED_COOKED_RABBIT);
                        output.accept(ModItems.OILED_COOKED_SALMON);
                        output.accept(ModItems.OILED_COOKIE);
                        output.accept(ModItems.OILED_DRIED_KELP);
                        output.accept(ModItems.OILED_GOLDEN_APPLE);
                        output.accept(ModItems.OILED_GOLDEN_CARROT);
                        output.accept(ModItems.OILED_MELON_SLICE);
                        output.accept(ModItems.OILED_MUSHROOM_STEW);
                        output.accept(ModItems.OILED_MUTTON);
                        output.accept(ModItems.OILED_POISONOUS_POTATO);
                        output.accept(ModItems.OILED_PORKCHOP);
                        output.accept(ModItems.OILED_POTATO);
                        output.accept(ModItems.OILED_PUFFERFISH);
                        output.accept(ModItems.OILED_PUMPKIN_PIE);
                        output.accept(ModItems.OILED_RABBIT);
                        output.accept(ModItems.OILED_RABBIT_STEW);
                        output.accept(ModItems.OILED_ROTTEN_FLESH);
                        output.accept(ModItems.OILED_SALMON);
                        output.accept(ModItems.OILED_SPIDER_EYE);
                        output.accept(ModItems.OILED_SUSPICIOUS_STEW);
                        output.accept(ModItems.OILED_SWEET_BERRIES);
                        output.accept(ModItems.OILED_GLOW_BERRIES);
                        output.accept(ModItems.OILED_TROPICAL_FISH);


                    }).build());

    public static CreativeModeTab ITEMGROUPHERB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(Rusticated.MOD_ID, "item_group_herb"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.rusticated.item_group_herb"))
                    .icon(() -> ModBlocks.CONDENSER.asItem().getDefaultInstance()).displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.CONDENSER.asItem());
                        output.accept(ModBlocks.RETORT.asItem());
                        output.accept(ModBlocks.ADV_CONDENSER.asItem());
                        output.accept(ModBlocks.ADV_RETORT.asItem());

                        output.accept(ModItems.ALOE_VERA);
                        output.accept(ModItems.BLOOD_ORCHID);
                        output.accept(ModItems.CHAMOMILE);
                        output.accept(ModItems.CLOUD_LILY);
                        output.accept(ModItems.COHOSH);
                        output.accept(ModItems.HORSETAIL);
                        output.accept(ModItems.WIND_THISTLE);
                        output.accept(ModItems.NIGHTSHROOM);
                        output.accept(ModItems.GREEN_SPORED_ASBESTOS);
                        output.accept(ModItems.CORE_ROOT);
                        output.accept(ModItems.GINSENG);
                        output.accept(ModItems.MARSHMALLOW);
                        output.accept(ModItems.ELIXIR);
                        
                    }).build());



    public static void registerItemGroup() {

    }
}
