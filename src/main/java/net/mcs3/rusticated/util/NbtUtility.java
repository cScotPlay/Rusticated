package net.mcs3.rusticated.util;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class NbtUtility
{
    public static void putFluid(CompoundTag tag, String key, FluidVariant fluid) {
        CompoundTag savedTag = new CompoundTag();
        savedTag.put("fk", fluid.toNbt());
        tag.put(key, savedTag);
    }

    public static Item getItem(CompoundTag tag, String key) {
        return BuiltInRegistries.ITEM.get(new ResourceLocation(tag.getString(key)));
    }

    public static void putItem(CompoundTag tag, String key, Item item) {
        tag.putString(key, BuiltInRegistries.ITEM.getKey(item).toString());
    }

    public static byte encodeDirections(Iterable<Direction> directions) {
        byte mask = 0;
        for (Direction direction : directions) {
            mask |= 1 << direction.get3DDataValue();
        }
        return mask;
    }

    public static Direction[] decodeDirections(byte mask) {
        Direction[] directions = new Direction[Long.bitCount(mask)];
        int j = 0;
        for (int i = 0; i < 6; ++i) {
            if ((mask & (1 << i)) != 0) {
                directions[j++] = Direction.from3DDataValue(i);
            }
        }
        return directions;
    }

    public static <T> void putList(CompoundTag tag, String key, List<T> list, Function<T, CompoundTag> encoder) {
        ListTag listTag = new ListTag();
        for (T t : list) {
            listTag.add(encoder.apply(t));
        }
        tag.put(key, listTag);
    }

    public static <T> void getList(CompoundTag tag, String key, List<T> list, Function<CompoundTag, T> decoder) {
        list.clear();
        ListTag listTag = tag.getList(key, NbtType.COMPOUND);
        for (int i = 0; i < listTag.size(); ++i) {
            CompoundTag elementTag = listTag.getCompound(i);
            list.add(decoder.apply(elementTag));
        }
    }

    public static void putBlockPos(CompoundTag tag, String key, @Nullable BlockPos pos) {
        if (pos != null) {
            tag.putIntArray(key, new int[] { pos.getX(), pos.getY(), pos.getZ() });
        }
    }

    public static BlockPos getBlockPos(CompoundTag tag, String key) {
        if (tag.contains(key)) {
            int[] pos = tag.getIntArray(key);
            return new BlockPos(pos[0], pos[1], pos[2]);
        } else {
            return null;
        }
    }

    public static FluidVariant getFluidCompatible(CompoundTag tag, String key) {
        if (tag == null || !tag.contains(key))
            return FluidVariant.blank();

        if (tag.get(key) instanceof StringTag) {
            return FluidVariant.of(BuiltInRegistries.FLUID.get(new ResourceLocation(tag.getString(key))));
        } else {
            CompoundTag compound = tag.getCompound(key);
            if (compound.contains("fk")) {
                return FluidVariant.fromNbt(compound.getCompound("fk"));
            } else {
                return FluidVariant.of(readLbaTag(tag.getCompound(key)));
            }
        }
    }

    private static Fluid readLbaTag(CompoundTag tag) {
        if (tag.contains("ObjName") && tag.getString("Registry").equals("f")) {
            return BuiltInRegistries.FLUID.get(new ResourceLocation(tag.getString("ObjName")));
        } else {
            return Fluids.EMPTY;
        }
    }

    public static void putNonzeroInt(CompoundTag tag, String key, int i) {
        if (i == 0) {
            tag.remove(key);
        } else {
            tag.putInt(key, i);
        }
    }

    public static boolean verifyExistence(ItemStack stack, String tag) {
        return !stack.isEmpty() && stack.hasTag() && stack.getOrCreateTag().contains(tag);
    }

    public static String getString(ItemStack stack, String tag, String defaultExpected) {
        return verifyExistence(stack, tag) ? stack.getOrCreateTag().getString(tag) : defaultExpected;
    }

    public static String getString(ItemStack item, String key) {
        return hasTag(item) ? item.getOrCreateTag().getString(key) : "";
    }

    public static boolean hasTag(ItemStack stack)
    {
        return stack.hasTag();
    }
}
