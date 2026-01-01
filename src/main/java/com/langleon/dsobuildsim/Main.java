package com.langleon.dsobuildsim;

import com.langleon.dsobuildsim.enums.*;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    public static void printStats(Map<StatType, Double> stats)
    {
        System.out.println("Character:");
        System.out.println(StatType.DAMAGE + ": " + stats.get(StatType.DAMAGE));
        System.out.println(StatType.ATTACK_SPEED + ": " + stats.get(StatType.ATTACK_SPEED));
        System.out.println(StatType.CRIT_VALUE + ": " + stats.get(StatType.CRIT_VALUE));
        System.out.println(StatType.MANA + ": " + stats.get(StatType.MANA));
        System.out.println(StatType.MANA_PER_SECOND + ": " + stats.get(StatType.MANA_PER_SECOND));
        System.out.println(StatType.MOVEMENT_SPEED + ": " + stats.get(StatType.MOVEMENT_SPEED));
        System.out.println(StatType.HEALTH_POINTS + ": " + stats.get(StatType.HEALTH_POINTS));
        System.out.println(StatType.HEALTH_PER_SECOND + ": " + stats.get(StatType.HEALTH_PER_SECOND));
        System.out.println(StatType.BLOCK_VALUE + ": " + stats.get(StatType.BLOCK_VALUE));
        System.out.println(StatType.ARMOR_VALUE + ": " + stats.get(StatType.ARMOR_VALUE));
        System.out.println(StatType.FIRE_RESISTANCE + ": " + stats.get(StatType.FIRE_RESISTANCE));
        System.out.println(StatType.ICE_RESISTANCE + ": " + stats.get(StatType.ICE_RESISTANCE));
        System.out.println(StatType.LIGHTNING_RESISTANCE + ": " + stats.get(StatType.LIGHTNING_RESISTANCE));
        System.out.println(StatType.ANDERMAGIC_RESISTANCE + ": " + stats.get(StatType.ANDERMAGIC_RESISTANCE));
        System.out.println(StatType.POISON_RESISTANCE + ": " + stats.get(StatType.POISON_RESISTANCE));
    }
}