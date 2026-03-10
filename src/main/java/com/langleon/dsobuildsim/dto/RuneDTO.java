package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;

import java.util.Map;

public record RuneDTO(RuneType runeType, RuneLimitGroup runeLimitGroup, int tier, Map<Integer, Map<StatType, Double>> statsPerTier, String description) {
}
