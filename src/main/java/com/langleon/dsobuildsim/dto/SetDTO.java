package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.sets.SetType;

import java.util.Map;
import java.util.Set;

public record SetDTO(SetType setType, String name, int level, Set<String> setItems, Map<Integer, Map<StatType, Double>> baseValuesPerTier, Map<Integer, Map<StatType, Double>> relativeValuesPerTier, Map<Integer, String> descriptionPerTier) {
}
