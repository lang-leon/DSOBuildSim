package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;

import java.util.Map;

public record GemDTO(GemType gemType, GemLimitGroup gemLimitGroup, int gemLimit, int tier, StatType statType, Map<Integer, Double> stats) {
}