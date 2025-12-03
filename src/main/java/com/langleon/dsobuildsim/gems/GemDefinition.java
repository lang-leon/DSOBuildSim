package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.GemType;
import com.langleon.dsobuildsim.enums.GemUpgradeType;

import java.util.Map;

/**
 * @param gemType
 * @param gemUpgradeType
 * @param statType
 * @param statsPerTier
 *
 * Used to keep a definition for each gem type to create actual gem instances from.
 */
public record GemDefinition(GemType gemType, GemUpgradeType gemUpgradeType, AbsoluteStatType statType,
                            Map<Integer, Double> statsPerTier) {
}
