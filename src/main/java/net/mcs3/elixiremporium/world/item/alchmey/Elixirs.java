package net.mcs3.elixiremporium.world.item.alchmey;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;

import java.util.ArrayList;
import java.util.List;

public class Elixirs {

    public static final List<Potion> ELIXIRS = new ArrayList<Potion>();

    public static Potion HEALING_ELIXIR;
    public static Potion HEALING_STRONG_ELIXIR;
    public static Potion REGENERATION_ELIXIR;
    public static Potion LONG_REGENERATION_ELIXIR;
    public static Potion STRONG_REGENERATION_ELIXIR;
    public static Potion NIGHT_VISION_ELIXIR;
    public static Potion LONG_NIGHT_VISION_ELIXIR;
    public static Potion SWIFTNESS_ELIXIR;
    public static Potion LONG_SWIFTNESS_ELIXIR;
    public static Potion STRONG_SWIFTNESS_ELIXIR;
    public static Potion FIRE_RESISTANCE_ELIXIR;
    public static Potion LONG_FIRE_RESISTANCE_ELIXIR;
    public static Potion STRENGTH_ELIXIR;
    public static Potion LONG_STRENGTH_ELIXIR;
    public static Potion STRONG_STRENGTH_ELIXIR;
    public static Potion WATER_BREATHING_ELIXIR;
    public static Potion LONG_WATER_BREATHING_ELIXIR;
    public static Potion SLOW_FALLING_ELIXIR;
    public static Potion LONG_SLOW_FALLING_ELIXIR;
    public static Potion INVISIBILITY_ELIXIR;
    public static Potion LONG_INVISIBILITY_ELIXIR;

    public static Potion init(Potion potion) {
        ELIXIRS.add(potion);
        return potion;
    }

    public static void initElixirs() {
        HEALING_ELIXIR = init(Potions.HEALING);//
        HEALING_STRONG_ELIXIR = init(Potions.STRONG_HEALING);
        REGENERATION_ELIXIR = init(Potions.REGENERATION);//
        LONG_REGENERATION_ELIXIR = init(Potions.LONG_REGENERATION);
        STRONG_REGENERATION_ELIXIR = init(Potions.STRONG_REGENERATION);
        NIGHT_VISION_ELIXIR = init(Potions.NIGHT_VISION);//
        LONG_NIGHT_VISION_ELIXIR = init(Potions.LONG_NIGHT_VISION);
        SWIFTNESS_ELIXIR = init(Potions.SWIFTNESS);//
        LONG_SWIFTNESS_ELIXIR = init(Potions.LONG_SWIFTNESS);
        STRONG_SWIFTNESS_ELIXIR = init(Potions.STRONG_SWIFTNESS);
        FIRE_RESISTANCE_ELIXIR = init(Potions.FIRE_RESISTANCE);
        LONG_FIRE_RESISTANCE_ELIXIR = init(Potions.LONG_FIRE_RESISTANCE);
        STRENGTH_ELIXIR = init(Potions.STRENGTH);
        LONG_STRENGTH_ELIXIR = init(Potions.LONG_STRENGTH);
        STRONG_STRENGTH_ELIXIR = init(Potions.STRONG_STRENGTH);
        WATER_BREATHING_ELIXIR = init(Potions.WATER_BREATHING);
        LONG_WATER_BREATHING_ELIXIR = init(Potions.LONG_WATER_BREATHING);
        SLOW_FALLING_ELIXIR = init(Potions.SLOW_FALLING);
        LONG_SLOW_FALLING_ELIXIR = init(Potions.LONG_SLOW_FALLING);
        INVISIBILITY_ELIXIR = init(Potions.INVISIBILITY);
        LONG_INVISIBILITY_ELIXIR = init(Potions.LONG_INVISIBILITY);

    }
}
