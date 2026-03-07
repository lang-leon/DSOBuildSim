package com.langleon.dsobuildsim.items.core;

import com.langleon.dsobuildsim.enums.StatType;

import java.util.EnumMap;
import java.util.Map;

public class LevelMultiplierTable {
    private final Map<Integer, EnumMap<StatType, Double>> multiplierPerLevel;

    public LevelMultiplierTable(Map<Integer, EnumMap<StatType, Double>> multiplierPerLevel) {
        this.multiplierPerLevel = multiplierPerLevel;
    }

    public EnumMap<StatType, Double> getMultipliersForLevel(int level)
    {
        return multiplierPerLevel.getOrDefault(level, new EnumMap<>(StatType.class));
    }

    public Double getMultiplier(int level, StatType statType)
    {
        return multiplierPerLevel.getOrDefault(level, new EnumMap<>(StatType.class)).getOrDefault(statType, 0.0);
    }
}
