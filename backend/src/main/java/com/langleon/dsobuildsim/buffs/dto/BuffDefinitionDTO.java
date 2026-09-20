package com.langleon.dsobuildsim.buffs.dto;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record BuffDefinitionDTO(String type, String name, int defaultTier, StatType statType, Map<Integer, Double> statsPerTier) {
}
