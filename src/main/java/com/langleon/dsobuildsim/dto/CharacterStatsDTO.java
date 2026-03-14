package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record CharacterStatsDTO(Map<StatType, Double> stats) {
}
