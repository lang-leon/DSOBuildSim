package com.langleon.dsobuildsim.items.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.langleon.dsobuildsim.enums.StatType;

import java.util.EnumMap;
import java.util.Map;

public class LevelMultiplierTable {
    private final Map<Integer, EnumMap<StatType, Double>> multipliersPerLevel;

    @JsonCreator
    public LevelMultiplierTable(@JsonProperty("multipliersPerLevel") Map<Integer, EnumMap<StatType, Double>> multipliersPerLevel) {
        this.multipliersPerLevel = multipliersPerLevel;
    }

    public EnumMap<StatType, Double> getMultipliersForLevel(int level)
    {
        return multipliersPerLevel.getOrDefault(level, new EnumMap<>(StatType.class));
    }

    public Double getMultiplier(int level, StatType statType)
    {
        return multipliersPerLevel.getOrDefault(level, new EnumMap<>(StatType.class)).getOrDefault(statType, 0.0);
    }
}
