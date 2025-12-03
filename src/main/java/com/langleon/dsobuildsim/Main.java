package com.langleon.dsobuildsim;

import com.langleon.dsobuildsim.enums.*;
import com.langleon.dsobuildsim.gems.Opal;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    public static void printStats(Map<AbsoluteStatType, Double> stats)
    {
        System.out.println("Character:");
        System.out.println(AbsoluteStatType.DAMAGE + ": " + stats.get(AbsoluteStatType.DAMAGE));
        System.out.println(AbsoluteStatType.ATTACK_SPEED + ": " + stats.get(AbsoluteStatType.ATTACK_SPEED));
        System.out.println(AbsoluteStatType.CRIT_VALUE + ": " + stats.get(AbsoluteStatType.CRIT_VALUE));
        System.out.println(AbsoluteStatType.MANA + ": " + stats.get(AbsoluteStatType.MANA));
        System.out.println(AbsoluteStatType.MANA_PER_SECOND + ": " + stats.get(AbsoluteStatType.MANA_PER_SECOND));
        System.out.println(AbsoluteStatType.MOVEMENT_SPEED + ": " + stats.get(AbsoluteStatType.MOVEMENT_SPEED));
        System.out.println(AbsoluteStatType.HEALTH_POINTS + ": " + stats.get(AbsoluteStatType.HEALTH_POINTS));
        System.out.println(AbsoluteStatType.HEALTH_PER_SECOND + ": " + stats.get(AbsoluteStatType.HEALTH_PER_SECOND));
        System.out.println(AbsoluteStatType.BLOCK_VALUE + ": " + stats.get(AbsoluteStatType.BLOCK_VALUE));
        System.out.println(AbsoluteStatType.ARMOR_VALUE + ": " + stats.get(AbsoluteStatType.ARMOR_VALUE));
        System.out.println(AbsoluteStatType.FIRE_RESISTANCE + ": " + stats.get(AbsoluteStatType.FIRE_RESISTANCE));
        System.out.println(AbsoluteStatType.ICE_RESISTANCE + ": " + stats.get(AbsoluteStatType.ICE_RESISTANCE));
        System.out.println(AbsoluteStatType.LIGHTNING_RESISTANCE + ": " + stats.get(AbsoluteStatType.LIGHTNING_RESISTANCE));
        System.out.println(AbsoluteStatType.ANDERMAGIC_RESISTANCE + ": " + stats.get(AbsoluteStatType.ANDERMAGIC_RESISTANCE));
        System.out.println(AbsoluteStatType.POISON_RESISTANCE + ": " + stats.get(AbsoluteStatType.POISON_RESISTANCE));
    }
}