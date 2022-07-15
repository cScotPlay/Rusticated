package net.mcs3.elixiremporium.util;

import net.mcs3.elixiremporium.init.ModBlocks;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CopperStateMap
{
    private static final Map<Block, Block> INCREASES = new HashMap<>();

    private static final Map<Block, Block> DECREASES = new HashMap<>();

    private static final Map<Block, Block> WAXED = new HashMap<>();

    private static final Map<Block, Block> UNWAXED = new HashMap<>();

    public static void put(Block block, @Nullable Block oxidized, Block waxed) {
        if (oxidized != null) {
            INCREASES.put(block, oxidized);
            DECREASES.put(oxidized, block);
        }
        WAXED.put(block, waxed);
        UNWAXED.put(waxed, block);
    }

    public static Optional<Block> getIncrease(Block block) {
        return Optional.ofNullable(INCREASES.get(block));
    }

    public static Optional<Block> getDecrease(Block block) {
        return Optional.ofNullable(DECREASES.get(block));
    }

    public static Optional<Block> getWaxed(Block block) {
        return Optional.ofNullable(WAXED.get(block));
    }

    public static Optional<Block> getUnwaxed(Block block) {
        return Optional.ofNullable(UNWAXED.get(block));
    }

    public static Block getOriginalStage(Block block) {
        var result = block;
        for (var b = getDecrease(block); b.isPresent(); b = getDecrease(b.get())) {
            result = b.get();
        }
        return result;
    }

    static {
        put(ModBlocks.CHAIN_COPPER, ModBlocks.CHAIN_EXPOSED_COPPER, ModBlocks.CHAIN_WAXED_COPPER);
        put(ModBlocks.CHAIN_EXPOSED_COPPER, ModBlocks.CHAIN_WEATHERED_COPPER, ModBlocks.CHAIN_WAXED_EXPOSED_COPPER);
        put(ModBlocks.CHAIN_WEATHERED_COPPER, ModBlocks.CHAIN_OXIDIZED_COPPER, ModBlocks.CHAIN_WAXED_WEATHERED_COPPER);
        put(ModBlocks.CHAIN_OXIDIZED_COPPER, null, ModBlocks.CHAIN_WAXED_OXIDIZED_COPPER);
        put(ModBlocks.CHANDELIER_COPPER, ModBlocks.CHANDELIER_EXPOSED_COPPER, ModBlocks.CHANDELIER_WAXED_COPPER);
        put(ModBlocks.CHANDELIER_EXPOSED_COPPER, ModBlocks.CHANDELIER_WEATHERED_COPPER, ModBlocks.CHANDELIER_WAXED_EXPOSED_COPPER);
        put(ModBlocks.CHANDELIER_WEATHERED_COPPER, ModBlocks.CHANDELIER_OXIDIZED_COPPER, ModBlocks.CHANDELIER_WAXED_WEATHERED_COPPER);
        put(ModBlocks.CHANDELIER_OXIDIZED_COPPER, null, ModBlocks.CHANDELIER_WAXED_OXIDIZED_COPPER);

    }
}
