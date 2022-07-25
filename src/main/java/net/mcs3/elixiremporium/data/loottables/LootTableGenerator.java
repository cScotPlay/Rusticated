package net.mcs3.elixiremporium.data.loottables;

import dev.architectury.platform.Mod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mcs3.elixiremporium.init.ModBlocks;
import net.mcs3.elixiremporium.world.level.block.storage.barrel.BarrelBlock;
import net.mcs3.elixiremporium.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetContainerContents;
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

                ModBlocks.UNFIRED_JAR
        )

                .forEach(this::dropSelf);

        createSlabItemTable(ModBlocks.PAINTED_PLANKS_WHITE);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_ORANGE);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_MAGENTA);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_LIGHT_BLUE);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_YELLOW);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_LIME);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_PINK);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_GRAY);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_LIGHT_GRAY);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_CYAN);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_PURPLE);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_BLUE);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_BROWN);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_GREEN);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_RED);
        createSlabItemTable(ModBlocks.PAINTED_PLANKS_BLACK);

        this.add(ModBlocks.BARREL, LootTableGenerator::createBarrelDrop);

        //createBarrelDrop(ModBlocks.BARREL);


        //addDrop(ModBlocks.PAINTED_PLANKS_WHITE);
    }

    public static LootTable.Builder createBarrelDrop(Block barrelBlock) {
        return LootTable.lootTable().withPool((net.minecraft.world.level.storage.loot.LootPool.Builder)applyExplosionCondition(barrelBlock, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(barrelBlock).apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY)).apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY).copy("Lock", "BlockEntityTag.Lock").copy("LootTable", "BlockEntityTag.LootTable").copy("LootTableSeed", "BlockEntityTag.LootTableSeed")).apply(SetContainerContents.setContents(ModBlockEntityTypes.BARREL_CONTAINER).withEntry(DynamicLoot.dynamicEntry(BarrelBlock.CONTENTS))))));
    }
}
