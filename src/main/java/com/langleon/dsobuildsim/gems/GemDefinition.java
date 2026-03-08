package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.gems.enums.GemUpgradeType;

import java.util.Map;

/**
 * @param gemType
 * @param gemUpgradeType
 * @param statType
 * @param statsPerTier
 *
 * Used to keep a definition for each gem type to create actual gem instances from.
 */
public record GemDefinition(GemType gemType, GemUpgradeType gemUpgradeType, GemLimitGroup gemLimitGroup, StatType statType,
                            Map<Integer, Double> statsPerTier) {
}
