package com.langleon.dsobuildsim;

import com.langleon.dsobuildsim.common.StatType;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("test run");
    }

    public static void printStats(Map<StatType, Double> stats)
    {
        System.out.println("Character:");
        System.out.printf("%s: %.3f%n", StatType.DAMAGE, stats.get(StatType.DAMAGE));
        System.out.printf("%s: %.3f%n", StatType.ATTACK_SPEED, stats.get(StatType.ATTACK_SPEED));
        System.out.printf("%s: %.3f%n", StatType.CRIT_VALUE, stats.get(StatType.CRIT_VALUE));
        System.out.printf("%s: %.3f%n", StatType.MANA, stats.get(StatType.MANA));
        System.out.printf("%s: %.3f%n", StatType.MANA_PER_SECOND, stats.get(StatType.MANA_PER_SECOND));
        System.out.printf("%s: %.3f%n", StatType.MOVEMENT_SPEED, stats.get(StatType.MOVEMENT_SPEED));
        System.out.printf("%s: %.3f%n", StatType.HEALTH_POINTS, stats.get(StatType.HEALTH_POINTS));
        System.out.printf("%s: %.3f%n", StatType.HEALTH_PER_SECOND, stats.get(StatType.HEALTH_PER_SECOND));
        System.out.printf("%s: %.3f%n", StatType.BLOCK_VALUE, stats.get(StatType.BLOCK_VALUE));
        System.out.printf("%s: %.3f%n", StatType.ARMOR_VALUE, stats.get(StatType.ARMOR_VALUE));
        System.out.printf("%s: %.3f%n", StatType.FIRE_RESISTANCE, stats.get(StatType.FIRE_RESISTANCE));
        System.out.printf("%s: %.3f%n", StatType.ICE_RESISTANCE, stats.get(StatType.ICE_RESISTANCE));
        System.out.printf("%s: %.3f%n", StatType.LIGHTNING_RESISTANCE, stats.get(StatType.LIGHTNING_RESISTANCE));
        System.out.printf("%s: %.3f%n", StatType.ANDERMAGIC_RESISTANCE, stats.get(StatType.ANDERMAGIC_RESISTANCE));
        System.out.printf("%s: %.3f%n", StatType.POISON_RESISTANCE, stats.get(StatType.POISON_RESISTANCE));
    }
}