package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.runes.enums.RuneUpgradeType;

import java.util.Map;

public record RuneDefinition(RuneType runeType, String name, RuneUpgradeType runeUpgradeType, RuneLimitGroup runeLimitGroup, int defaultTier,
                             Map<Integer, Map<StatType, Double>> statsPerTier, String description) {
}
