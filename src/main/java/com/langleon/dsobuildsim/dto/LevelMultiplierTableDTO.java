package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record LevelMultiplierTableDTO(Map<Integer, Map<StatType, Double>> multipliersPerLevel) {
}
