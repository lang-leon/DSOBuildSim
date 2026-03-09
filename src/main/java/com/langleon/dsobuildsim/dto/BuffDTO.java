package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record BuffDTO(String type, String name, int tier, StatType statType, Map<Integer, Double> statsPerTier) {
}
