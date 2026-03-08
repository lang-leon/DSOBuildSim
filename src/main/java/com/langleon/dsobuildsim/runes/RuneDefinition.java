package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.runes.enums.RuneLimitGroup;
import com.langleon.dsobuildsim.runes.enums.RuneType;
import com.langleon.dsobuildsim.runes.enums.RuneUpgradeType;

import java.util.Map;

/**
 * @param runeType
 * @param runeUpgradeType
 * @param statsPerTier
 *
 * Used to keep a definition for each rune type to create actual gem instances from.
 */
public record RuneDefinition(RuneType runeType, RuneUpgradeType runeUpgradeType, RuneLimitGroup runeLimitGroup, int defaultTier,
                             Map<Integer, Map<StatType, Double>> statsPerTier, String description) {
}
