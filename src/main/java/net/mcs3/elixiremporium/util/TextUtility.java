package net.mcs3.elixiremporium.util;

import net.fabricmc.fabric.impl.client.indigo.renderer.helper.TextureHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;

public class TextUtility
{
    public static final Style GRAY_TEXT = Style.EMPTY.withColor(TextColor.fromRgb(0xa9a9a9)).withItalic(true);
    public static final Style NUMBER_TEXT = Style.EMPTY.withColor(TextColor.fromRgb(0xffde7d)).withItalic(false);
    public static final Style WATER_TEXT = Style.EMPTY.withColor(TextColor.fromRgb(0x3264ff));
    public static final Style WARNING_TEXT = Style.EMPTY.withColor(ChatFormatting.RED);
    public static final Style MAX_TEMP_TEXT = Style.EMPTY.withColor(TextColor.fromRgb(0xd94a1e));
    public static final Style HEAT_CONDUCTION = Style.EMPTY.withColor(TextColor.fromRgb(0x0073ba));
    public static final Style NEUTRONS = Style.EMPTY.withColor(TextColor.fromRgb(0x29a329));
    public static final Style YELLOW_BOLD = Style.EMPTY.withColor(ChatFormatting.YELLOW).withBold(true);
    public static final Style YELLOW = Style.EMPTY.withColor(ChatFormatting.YELLOW);

    public static final Style RED = Style.EMPTY.withColor(ChatFormatting.RED);
    public static final Style GREEN = Style.EMPTY.withColor(ChatFormatting.GREEN);

    public static int getOverlayTextColor(int rgb) {
        double luminance =  ((0.2126 * (rgb & 0xff) + 0.7152 * ((rgb >> 8) & 0xff)) + 0.0722 * ((rgb >> 16) & 0xff)) / 255;;
        if (luminance < 0.5) {
            return 0xFFFFFF;
        } else {
            return 0x000000;
        }
    }

    public record Amount(String digit, String unit) {
    }

    ;

    public record MaxedAmount(String digit, String maxDigit, String unit) {
    }

    ;

    public static final String[] units = new String[] { "k", "M", "G", "T", "P", "E" };
    public static final long[] nums = new long[] { 1000L, 1000_000L, 1000_000_000L, 1000_000_000_000L, 1000_000_000_000_000L,
            1000_000_000_000_000_000L };

    public static String getAmount(double amount, long num) {
        double fract = amount / num;
        if (fract < 10) {
            return String.format("%.3f", fract);
        } else if (fract < 100) {
            return String.format("%.2f", fract);
        } else {
            return String.format("%.1f", fract);
        }
    }

    public static Amount getAmountGeneric(Number number) {
        if (number instanceof Long l) {
            return getAmount(l);
        } else if (number instanceof Integer i) {
            return getAmount(i);
        } else if (number instanceof Double d) {
            return getAmount(d);
        } else if (number instanceof Float f) {
            return getAmount(f);
        }
        throw new IllegalArgumentException("Number " + number + " is neither long, int, double or float");
    }

    public static Amount getAmount(double amount) {
        if (amount < 10000) {
            return new Amount(getAmount(amount, 1), "");
        } else {
            int i = 0;
            while (amount / nums[i] >= 1000) {
                i++;
            }
            return new Amount(getAmount(amount, nums[i]), units[i]);
        }
    }

    public static MaxedAmount getMaxedAmount(double amount, double max) {
        if (max < 10000) {
            return new MaxedAmount(getAmount(amount, 1), getAmount(max, 1), "");
        } else {
            int i = 0;
            while (max / nums[i] >= 1000) {
                i++;
            }
            return new MaxedAmount(getAmount(amount, nums[i]), getAmount(max, nums[i]), units[i]);
        }
    }

    public static Amount getAmount(long amount) {
        if (amount < 10000) {
            return new Amount(String.valueOf(amount), "");
        } else {
            int i = 0;
            while (amount / nums[i] >= 1000) {
                i++;
            }
            return new Amount(getAmount(amount, nums[i]), units[i]);
        }
    }

    public static MaxedAmount getMaxedAmount(long amount, long max) {
        if (max < 10000) {
            return new MaxedAmount(String.valueOf(amount), String.valueOf(max), "");
        } else {
            int i = 0;
            while (max / nums[i] >= 1000) {
                i++;
            }
            return new MaxedAmount(getAmount(amount, nums[i]), getAmount(max, nums[i]), units[i]);
        }
    }
}
