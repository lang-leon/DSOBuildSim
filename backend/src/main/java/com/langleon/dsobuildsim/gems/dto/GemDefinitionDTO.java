package com.langleon.dsobuildsim.gems.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;

import java.util.Map;

public record GemDefinitionDTO(GemType gemType, GemLimitGroup gemLimitGroup, int gemLimit, int tier, StatType statType, Map<Integer, Double> stats) {
}