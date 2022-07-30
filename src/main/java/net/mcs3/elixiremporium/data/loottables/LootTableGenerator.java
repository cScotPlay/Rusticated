package net.mcs3.elixiremporium.data.loottables;

import dev.architectury.platform.Mod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.world.level.block.storage.barrel.BarrelBlock;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetContainerContents;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.stream.Stream;

public class LootTableGenerator extends FabricBlockLootTableProvider
{

    public LootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateBlockLootTables()
    {
        Stream.of(
                ModBlocks.STONE_STAIRS_WHITE,
                ModBlocks.STONE_STAIRS_ORANGE,
                ModBlocks.STONE_STAIRS_MAGENTA,
                ModBlocks.STONE_STAIRS_LIGHT_BLUE,
                ModBlocks.STONE_STAIRS_YELLOW,
                ModBlocks.STONE_STAIRS_LIME,
                ModBlocks.STONE_STAIRS_PINK,
                ModBlocks.STONE_STAIRS_GRAY,
                ModBlocks.STONE_STAIRS_LIGHT_GRAY,
                ModBlocks.STONE_STAIRS_CYAN,
                ModBlocks.STONE_STAIRS_PURPLE,
                ModBlocks.STONE_STAIRS_BLUE,
                ModBlocks.STONE_STAIRS_BROWN,
                ModBlocks.STONE_STAIRS_GREEN,
                ModBlocks.STONE_STAIRS_RED,
                ModBlocks.STONE_STAIRS_BLACK,

                ModBlocks.COBBLESTONE_WHITE,
                ModBlocks.COBBLESTONE_ORANGE,
                ModBlocks.COBBLESTONE_MAGENTA,
                ModBlocks.COBBLESTONE_LIGHT_BLUE,
                ModBlocks.COBBLESTONE_YELLOW,
                ModBlocks.COBBLESTONE_LIME,
                ModBlocks.COBBLESTONE_PINK,
                ModBlocks.COBBLESTONE_GRAY,
                ModBlocks.COBBLESTONE_LIGHT_GRAY,
                ModBlocks.COBBLESTONE_CYAN,
                ModBlocks.COBBLESTONE_PURPLE,
                ModBlocks.COBBLESTONE_BLUE,
                ModBlocks.COBBLESTONE_BROWN,
                ModBlocks.COBBLESTONE_GREEN,
                ModBlocks.COBBLESTONE_RED,
                ModBlocks.COBBLESTONE_BLACK,

                ModBlocks.COBBLESTONE_STAIRS_WHITE,
                ModBlocks.COBBLESTONE_STAIRS_ORANGE,
                ModBlocks.COBBLESTONE_STAIRS_MAGENTA,
                ModBlocks.COBBLESTONE_STAIRS_LIGHT_BLUE,
                ModBlocks.COBBLESTONE_STAIRS_YELLOW,
                ModBlocks.COBBLESTONE_STAIRS_LIME,
                ModBlocks.COBBLESTONE_STAIRS_PINK,
                ModBlocks.COBBLESTONE_STAIRS_GRAY,
                ModBlocks.COBBLESTONE_STAIRS_LIGHT_GRAY,
                ModBlocks.COBBLESTONE_STAIRS_CYAN,
                ModBlocks.COBBLESTONE_STAIRS_PURPLE,
                ModBlocks.COBBLESTONE_STAIRS_BLUE,
                ModBlocks.COBBLESTONE_STAIRS_BROWN,
                ModBlocks.COBBLESTONE_STAIRS_GREEN,
                ModBlocks.COBBLESTONE_STAIRS_RED,
                ModBlocks.COBBLESTONE_STAIRS_BLACK,

                ModBlocks.COBBLESTONE_WALL_WHITE,
                ModBlocks.COBBLESTONE_WALL_ORANGE,
                ModBlocks.COBBLESTONE_WALL_MAGENTA,
                ModBlocks.COBBLESTONE_WALL_LIGHT_BLUE,
                ModBlocks.COBBLESTONE_WALL_YELLOW,
                ModBlocks.COBBLESTONE_WALL_LIME,
                ModBlocks.COBBLESTONE_WALL_PINK,
                ModBlocks.COBBLESTONE_WALL_GRAY,
                ModBlocks.COBBLESTONE_WALL_LIGHT_GRAY,
                ModBlocks.COBBLESTONE_WALL_CYAN,
                ModBlocks.COBBLESTONE_WALL_PURPLE,
                ModBlocks.COBBLESTONE_WALL_BLUE,
                ModBlocks.COBBLESTONE_WALL_BROWN,
                ModBlocks.COBBLESTONE_WALL_GREEN,
                ModBlocks.COBBLESTONE_WALL_RED,
                ModBlocks.COBBLESTONE_WALL_BLACK,

                ModBlocks.PAINTED_PLANKS_WHITE,
                ModBlocks.PAINTED_PLANKS_ORANGE,
                ModBlocks.PAINTED_PLANKS_MAGENTA,
                ModBlocks.PAINTED_PLANKS_LIGHT_BLUE,
                ModBlocks.PAINTED_PLANKS_YELLOW,
                ModBlocks.PAINTED_PLANKS_LIME,
                ModBlocks.PAINTED_PLANKS_PINK,
                ModBlocks.PAINTED_PLANKS_GRAY,
                ModBlocks.PAINTED_PLANKS_LIGHT_GRAY,
                ModBlocks.PAINTED_PLANKS_CYAN,
                ModBlocks.PAINTED_PLANKS_PURPLE,
                ModBlocks.PAINTED_PLANKS_BLUE,
                ModBlocks.PAINTED_PLANKS_BROWN,
                ModBlocks.PAINTED_PLANKS_GREEN,
                ModBlocks.PAINTED_PLANKS_RED,
                ModBlocks.PAINTED_PLANKS_BLACK,

                ModBlocks.PAINTED_STAIRS_WHITE,
                ModBlocks.PAINTED_STAIRS_ORANGE,
                ModBlocks.PAINTED_STAIRS_MAGENTA,
                ModBlocks.PAINTED_STAIRS_LIGHT_BLUE,
                ModBlocks.PAINTED_STAIRS_YELLOW,
                ModBlocks.PAINTED_STAIRS_LIME,
                ModBlocks.PAINTED_STAIRS_PINK,
                ModBlocks.PAINTED_STAIRS_GRAY,
                ModBlocks.PAINTED_STAIRS_LIGHT_GRAY,
                ModBlocks.PAINTED_STAIRS_CYAN,
                ModBlocks.PAINTED_STAIRS_PURPLE,
                ModBlocks.PAINTED_STAIRS_BLUE,
                ModBlocks.PAINTED_STAIRS_BROWN,
                ModBlocks.PAINTED_STAIRS_GREEN,
                ModBlocks.PAINTED_STAIRS_RED,
                ModBlocks.PAINTED_STAIRS_BLACK,

                ModBlocks.COBBLESTONE_PATH,
                ModBlocks.STONE_PATH,
                ModBlocks.GRANITE_PATH,
                ModBlocks.ANDESITE_PATH,
                ModBlocks.DIORITE_PATH,
                ModBlocks.COBBLED_DEEPSLATE_PATH,
                ModBlocks.BLACKSTONE_PATH,
                ModBlocks.NETHER_BRICKS_PATH,

                ModBlocks.CHANDELIER_IRON,
                ModBlocks.CHANDELIER_GOLD,
                ModBlocks.CHANDELIER_COPPER,
                ModBlocks.CHANDELIER_EXPOSED_COPPER,
                ModBlocks.CHANDELIER_WEATHERED_COPPER,
                ModBlocks.CHANDELIER_OXIDIZED_COPPER,
                ModBlocks.CHANDELIER_WAXED_COPPER,
                ModBlocks.CHANDELIER_WAXED_EXPOSED_COPPER,
                ModBlocks.CHANDELIER_WAXED_WEATHERED_COPPER,
                ModBlocks.CHANDELIER_WAXED_OXIDIZED_COPPER,
                ModBlocks.CHAIN_GOLD,
                ModBlocks.CHAIN_COPPER,
                ModBlocks.CHAIN_EXPOSED_COPPER,
                ModBlocks.CHAIN_WEATHERED_COPPER,
                ModBlocks.CHAIN_OXIDIZED_COPPER,
                ModBlocks.CHAIN_WAXED_COPPER,
                ModBlocks.CHAIN_WAXED_EXPOSED_COPPER,
                ModBlocks.CHAIN_WAXED_WEATHERED_COPPER,
                ModBlocks.CHAIN_WAXED_OXIDIZED_COPPER,

                ModBlocks.UNFIRED_JAR,
                ModBlocks.UNFIRED_POT,
                ModBlocks.IRON_LATTICE
        )

                .forEach(this::dropSelf);

        add(ModBlocks.PAINTED_SLAB_WHITE, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_ORANGE, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_MAGENTA, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_LIGHT_BLUE, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_YELLOW, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_LIME, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_PINK, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_GRAY, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_LIGHT_GRAY, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_CYAN, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_PURPLE, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_BLUE, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_BROWN, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_GREEN, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_RED, BlockLoot::createSlabItemTable);
        add(ModBlocks.PAINTED_SLAB_BLACK, BlockLoot::createSlabItemTable);

        add(ModBlocks.COBBLESTONE_SLAB_WHITE, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_ORANGE, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_MAGENTA, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_LIGHT_BLUE, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_YELLOW, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_LIME, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_PINK, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_GRAY, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_LIGHT_GRAY, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_CYAN, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_PURPLE, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_BLUE, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_BROWN, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_GREEN, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_RED, BlockLoot::createSlabItemTable);
        add(ModBlocks.COBBLESTONE_SLAB_BLACK, BlockLoot::createSlabItemTable);

        add(ModBlocks.STONE_SLAB_WHITE, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_ORANGE, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_MAGENTA, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_LIGHT_BLUE, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_YELLOW, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_LIME, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_PINK, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_GRAY, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_LIGHT_GRAY, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_CYAN, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_PURPLE, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_BLUE, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_BROWN, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_GREEN, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_RED, BlockLoot::createSlabItemTable);
        add(ModBlocks.STONE_SLAB_BLACK, BlockLoot::createSlabItemTable);

        this.add(ModBlocks.BARREL, LootTableGenerator::createBarrelDrop);



        add(ModBlocks.STONE_WHITE, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_WHITE);
        });
        add(ModBlocks.STONE_ORANGE, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_ORANGE);
        });
        add(ModBlocks.STONE_MAGENTA, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_MAGENTA);
        });
        add(ModBlocks.STONE_LIGHT_BLUE, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_LIGHT_BLUE);
        });
        add(ModBlocks.STONE_YELLOW, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_YELLOW);
        });
        add(ModBlocks.STONE_LIME, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_LIME);
        });
        add(ModBlocks.STONE_PINK, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_PINK);
        });
        add(ModBlocks.STONE_GRAY, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_GRAY);
        });
        add(ModBlocks.STONE_LIGHT_GRAY, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_LIGHT_GRAY);
        });
        add(ModBlocks.STONE_CYAN, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_CYAN);
        });
        add(ModBlocks.STONE_PURPLE, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_PURPLE);
        });
        add(ModBlocks.STONE_BLUE, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_BLUE);
        });
        add(ModBlocks.STONE_BROWN, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_BROWN);
        });
        add(ModBlocks.STONE_GREEN, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_GREEN);
        });
        add(ModBlocks.STONE_RED, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_RED);
        });
        add(ModBlocks.STONE_BLACK, (blockx) -> {
            return createSingleItemTableWithSilkTouch(blockx, ModBlocks.COBBLESTONE_BLACK);
        });

    }

    public static LootTable.Builder createBarrelDrop(Block barrelBlock) {
        return LootTable.lootTable().withPool((net.minecraft.world.level.storage.loot.LootPool.Builder)applyExplosionCondition(barrelBlock, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(barrelBlock).apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY)).apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY).copy("Lock", "BlockEntityTag.Lock").copy("LootTable", "BlockEntityTag.LootTable").copy("LootTableSeed", "BlockEntityTag.LootTableSeed")).apply(SetContainerContents.setContents(ModBlockEntityTypes.BARREL_CONTAINER).withEntry(DynamicLoot.dynamicEntry(BarrelBlock.CONTENTS))))));
    }

}
