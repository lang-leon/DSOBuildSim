package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public enum CharacterClass {

    DRAGONKNIGHT("Dragonknight",
            Map.of(StatType.DAMAGE, 16800.0, StatType.ATTACK_SPEED, 1.0, StatType.MANA, 100.0, StatType.MANA_PER_SECOND, 0.0, StatType.MOVEMENT_SPEED, 5.0, StatType.HEALTH_POINTS, 450000.0),
            Map.of(StatType.ATTACK_SPEED, 0.50, StatType.HONOR_GAIN, 1.00, StatType.XP_GAIN, 1.00)),
    RANGER("Ranger",
            Map.of(StatType.DAMAGE, 29400.0, StatType.ATTACK_SPEED, 1.0, StatType.MANA, 100.0, StatType.MANA_PER_SECOND, 8.0, StatType.MOVEMENT_SPEED, 5.0, StatType.HEALTH_POINTS, 345000.0),
            Map.of(StatType.HONOR_GAIN, 1.00, StatType.XP_GAIN, 1.00)),
    SPELLWEAVER("Spellweaver",
            Map.of(StatType.DAMAGE, 51850.0, StatType.ATTACK_SPEED, 1.0, StatType.MANA, 100.0, StatType.MANA_PER_SECOND, 12.0, StatType.MOVEMENT_SPEED, 5.0, StatType.HEALTH_POINTS, 152500.0),
            Map.of(StatType.DAMAGE, 0.50, StatType.HONOR_GAIN, 1.00, StatType.XP_GAIN, 1.00)),
    STEAM_MECHANICUS("Steam Mechanicus",
            Map.of(StatType.DAMAGE, 38640.0, StatType.ATTACK_SPEED, 1.0, StatType.MANA, 100.0, StatType.MANA_PER_SECOND, 3.0, StatType.MOVEMENT_SPEED, 5.0, StatType.HEALTH_POINTS, 262500.0),
            Map.of(StatType.HONOR_GAIN, 1.00, StatType.XP_GAIN, 1.00));

    private final String className;
    private final Map<StatType, Double> classBaseStats;
    private final Map<StatType, Double> classRelativeStats;

    CharacterClass(String className, Map<StatType, Double> classBaseStats, Map<StatType, Double> classRelativeStats){
        this.className = className;
        this.classBaseStats = classBaseStats;
        this.classRelativeStats = classRelativeStats;
    }

    public String getClassName() {
        return className;
    }

    public Map<StatType, Double> getClassBaseStats() {
        return classBaseStats;
    }

    public Map<StatType, Double> getClassRelativeStats() {
        return classRelativeStats;
    }

    @Override
    public String toString() {
        return className;
    }

}
