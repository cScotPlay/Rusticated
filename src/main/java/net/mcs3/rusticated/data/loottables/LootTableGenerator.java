package net.mcs3.rusticated.data.loottables;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.mcs3.rusticated.init.ModBlocks;
import net.mcs3.rusticated.init.ModItems;
import net.mcs3.rusticated.world.level.block.storage.barrel.BarrelBlock;
import net.mcs3.rusticated.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.stream.Stream;

public class LootTableGenerator extends FabricBlockLootTableProvider
{
    private static final net.minecraft.world.level.storage.loot.predicates.LootItemCondition.Builder HAS_SILK_TOUCH;
    private static final net.minecraft.world.level.storage.loot.predicates.LootItemCondition.Builder HAS_SHEARS;
    private static final net.minecraft.world.level.storage.loot.predicates.LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH;
    private static final net.minecraft.world.level.storage.loot.predicates.LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH;
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES;


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

                ModBlocks.FRAMED_WALL_CROSS_WHITE,
                ModBlocks.FRAMED_WALL_CROSS_ORANGE,
                ModBlocks.FRAMED_WALL_CROSS_MAGENTA,
                ModBlocks.FRAMED_WALL_CROSS_LIGHT_BLUE,
                ModBlocks.FRAMED_WALL_CROSS_YELLOW,
                ModBlocks.FRAMED_WALL_CROSS_LIME,
                ModBlocks.FRAMED_WALL_CROSS_PINK,
                ModBlocks.FRAMED_WALL_CROSS_GRAY,
                ModBlocks.FRAMED_WALL_CROSS_LIGHT_GRAY,
                ModBlocks.FRAMED_WALL_CROSS_CYAN,
                ModBlocks.FRAMED_WALL_CROSS_PURPLE,
                ModBlocks.FRAMED_WALL_CROSS_BLUE,
                ModBlocks.FRAMED_WALL_CROSS_BROWN,
                ModBlocks.FRAMED_WALL_CROSS_GREEN,
                ModBlocks.FRAMED_WALL_CROSS_RED,
                ModBlocks.FRAMED_WALL_CROSS_BLACK,

                ModBlocks.FRAMED_WALL_RT_DIAG_WHITE,
                ModBlocks.FRAMED_WALL_RT_DIAG_ORANGE,
                ModBlocks.FRAMED_WALL_RT_DIAG_MAGENTA,
                ModBlocks.FRAMED_WALL_RT_DIAG_LIGHT_BLUE,
                ModBlocks.FRAMED_WALL_RT_DIAG_YELLOW,
                ModBlocks.FRAMED_WALL_RT_DIAG_LIME,
                ModBlocks.FRAMED_WALL_RT_DIAG_PINK,
                ModBlocks.FRAMED_WALL_RT_DIAG_GRAY,
                ModBlocks.FRAMED_WALL_RT_DIAG_LIGHT_GRAY,
                ModBlocks.FRAMED_WALL_RT_DIAG_CYAN,
                ModBlocks.FRAMED_WALL_RT_DIAG_PURPLE,
                ModBlocks.FRAMED_WALL_RT_DIAG_BLUE,
                ModBlocks.FRAMED_WALL_RT_DIAG_BROWN,
                ModBlocks.FRAMED_WALL_RT_DIAG_GREEN,
                ModBlocks.FRAMED_WALL_RT_DIAG_RED,
                ModBlocks.FRAMED_WALL_RT_DIAG_BLACK,

                ModBlocks.FRAMED_WALL_LEFT_DIAG_WHITE,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_ORANGE,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_MAGENTA,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_LIGHT_BLUE,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_YELLOW,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_LIME,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_PINK,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_GRAY,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_LIGHT_GRAY,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_CYAN,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_PURPLE,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_BLUE,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_BROWN,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_GREEN,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_RED,
                ModBlocks.FRAMED_WALL_LEFT_DIAG_BLACK,

                ModBlocks.FRAMED_WALL_WHITE,
                ModBlocks.FRAMED_WALL_ORANGE,
                ModBlocks.FRAMED_WALL_MAGENTA,
                ModBlocks.FRAMED_WALL_LIGHT_BLUE,
                ModBlocks.FRAMED_WALL_YELLOW,
                ModBlocks.FRAMED_WALL_LIME,
                ModBlocks.FRAMED_WALL_PINK,
                ModBlocks.FRAMED_WALL_GRAY,
                ModBlocks.FRAMED_WALL_LIGHT_GRAY,
                ModBlocks.FRAMED_WALL_CYAN,
                ModBlocks.FRAMED_WALL_PURPLE,
                ModBlocks.FRAMED_WALL_BLUE,
                ModBlocks.FRAMED_WALL_BROWN,
                ModBlocks.FRAMED_WALL_GREEN,
                ModBlocks.FRAMED_WALL_RED,
                ModBlocks.FRAMED_WALL_BLACK,

                ModBlocks.UNFIRED_JAR,
                ModBlocks.UNFIRED_POT,
                ModBlocks.IRON_LATTICE,

                ModBlocks.FERTILE_SOIL,
                ModBlocks.IRONWOOD_SAPLING,
                ModBlocks.IRONWOOD_LOG,
                ModBlocks.IRONWOOD_WOOD,
                ModBlocks.STRIPPED_IRONWOOD_LOG,
                ModBlocks.STRIPPED_IRONWOOD_WOOD,
                ModBlocks.IRONWOOD_PLANKS,
                ModBlocks.IRONWOOD_STAIRS,
                ModBlocks.IRONWOOD_FENCE,
                ModBlocks.IRONWOOD_GATE,

                ModBlocks.OLIVE_SAPLING,
                ModBlocks.OLIVE_LOG,
                ModBlocks.OLIVE_WOOD,
                ModBlocks.STRIPPED_OLIVE_LOG,
                ModBlocks.STRIPPED_OLIVE_WOOD,
                ModBlocks.OLIVE_PLANKS,
                ModBlocks.OLIVE_STAIRS,
                ModBlocks.OLIVE_FENCE,
                ModBlocks.OLIVE_GATE,

                ModBlocks.ROPE,
                ModBlocks.CROP_STAKE,
                ModBlocks.RETORT,
                ModBlocks.ADV_RETORT
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

        add(ModBlocks.IRONWOOD_SLAB, BlockLoot::createSlabItemTable);
        add(ModBlocks.OLIVE_SLAB, BlockLoot::createSlabItemTable);

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



        add(ModBlocks.IRONWOOD_LEAVES, (block -> {
            return createLeavesDropswithItem(ModBlocks.IRONWOOD_LEAVES, ModBlocks.IRONWOOD_SAPLING, ModItems.IRON_BERRIES, NORMAL_LEAVES_SAPLING_CHANCES);
        }));

        add(ModBlocks.OLIVE_LEAVES, (block -> {
            return createLeavesDropswithItem(ModBlocks.OLIVE_LEAVES, ModBlocks.OLIVE_SAPLING, ModItems.OLIVES, NORMAL_LEAVES_SAPLING_CHANCES);
        }));

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

        add(ModBlocks.ALOE_VERA, (block -> {
            return createSingleItemTable(ModItems.ALOE_VERA);
        }));
        add(ModBlocks.BLOOD_ORCHID, (block -> {
            return createSingleItemTable(ModItems.BLOOD_ORCHID);
        }));
        add(ModBlocks.CHAMOMILE, (block -> {
            return createSingleItemTable(ModItems.CHAMOMILE);
        }));
        add(ModBlocks.CLOUD_LILY, (block -> {
            return createSingleItemTable(ModItems.CLOUD_LILY);
        }));
        add(ModBlocks.COHOSH, (block -> {
            return createSingleItemTable(ModItems.COHOSH);
        }));
        add(ModBlocks.HORSETAIL, (block -> {
            return createSingleItemTable(ModItems.HORSETAIL);
        }));
        add(ModBlocks.HORSETAIL, (block -> {
            return createSingleItemTable(ModItems.WIND_THISTLE);
        }));
        add(ModBlocks.NIGHTSHROOM, (block -> {
            return createSingleItemTable(ModItems.NIGHTSHROOM);
        }));
        add(ModBlocks.GREEN_SPORED_ASBESTOS, (block -> {
            return createSingleItemTable(ModItems.GREEN_SPORED_ASBESTOS);
        }));
        add(ModBlocks.CORE_ROOT, (block -> {
            return createSingleItemTable(ModItems.CORE_ROOT);
        }));
        add(ModBlocks.GINSENG, (block -> {
            return createSingleItemTable(ModItems.GINSENG);
        }));
        add(ModBlocks.MARSHMALLOW, (block -> {
            return createSingleItemTable(ModItems.MARSHMALLOW);
        }));

        add(ModBlocks.STORAGE_BARREL, BlockLoot::createNameableBlockEntityTable);

        add(ModBlocks.CONDENSER, BlockLoot::createNameableBlockEntityTable);
        add(ModBlocks.ADV_CONDENSER, BlockLoot::createNameableBlockEntityTable);
        add(ModBlocks.EVAPORATING_BASIN, BlockLoot::createNameableBlockEntityTable);
        add(ModBlocks.CRUSHING_TUB, BlockLoot::createNameableBlockEntityTable);
        add(ModBlocks.OAK_BREWING_BARREL, BlockLoot::createNameableBlockEntityTable);

        add(ModBlocks.TIED_STAKE, LootTableGenerator::createTiedStakeDrop);
        add(Blocks.VINE, LootTableGenerator::createGrapeSeedDrop);

    }

    public static LootTable.Builder createLeavesDropswithItem(Block leavesBlock, Block saplingBlock, Item droppedItem, float... chances) {
        return createLeavesDrops(leavesBlock, saplingBlock, chances).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(((net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer.Builder)applyExplosionCondition(leavesBlock, LootItem.lootTableItem(droppedItem))).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, new float[]{0.1F, 0.025F, 0.06F, 0.025F, 0.3F}))));
    }

    public static LootTable.Builder createTiedStakeDrop(Block block){
        return LootTable.lootTable().withPool(BlockLoot.applyExplosionCondition(ModBlocks.TIED_STAKE, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(ModBlocks.CROP_STAKE)))).withPool(BlockLoot.applyExplosionCondition(ModBlocks.ROPE, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(ModBlocks.ROPE))));
    }

    public static LootTable.Builder createGrapeSeedDrop(Block block) {
        return BlockLoot.createShearsDispatchTable(block, (LootPoolEntryContainer.Builder)BlockLoot.applyExplosionDecay(block, ((LootPoolSingletonContainer.Builder)LootItem.lootTableItem(ModItems.GRAPE_SEEDS.asItem()).when(LootItemRandomChanceCondition.randomChance(0.250f))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))));
    }

    static {
        HAS_SILK_TOUCH = MatchTool.toolMatches(net.minecraft.advancements.critereon.ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
        HAS_SHEARS = MatchTool.toolMatches(net.minecraft.advancements.critereon.ItemPredicate.Builder.item().of(new ItemLike[]{Items.SHEARS}));
        HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
        HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
        NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    }

}
