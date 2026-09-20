package com.langleon.dsobuildsim.runes.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;

import java.util.Map;

public record RuneDefinitionDTO(RuneType runeType, String name, RuneLimitGroup runeLimitGroup, int defaultTier, Map<Integer, Map<StatType, Double>> statsPerTier, String description) {
}
