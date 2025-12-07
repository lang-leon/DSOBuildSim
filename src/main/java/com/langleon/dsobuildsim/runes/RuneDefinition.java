package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.enums.*;

import java.util.Map;

/**
 * @param runeType
 * @param runeUpgradeType
 * @param statsPerTier
 *
 * Used to keep a definition for each rune type to create actual gem instances from.
 */
public record RuneDefinition(RuneType runeType, RuneUpgradeType runeUpgradeType,
                             Map<Integer, Map<OverallRelativeBuffType, Double>> statsPerTier, String description) {
}
