package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record JewelDefinition(JewelType jewelType, int defaultTier,
                              Map<Integer, Map<StatType, Double>> statsPerTier, Map<CharacterClass, Map<Integer, String>> descriptionPerClassPerTier) {
}