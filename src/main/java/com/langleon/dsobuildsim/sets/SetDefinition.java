package com.langleon.dsobuildsim.sets;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;
import java.util.Set;

public record SetDefinition (SetType setType, String name, int defaultLevel, Set<String> setItems, Map<Integer, Map<StatType, Double>> baseValuesPerTier, Map<Integer, Map<StatType, Double>> relativeValuesPerTier, Map<Integer, String> descriptionPerTier){
}