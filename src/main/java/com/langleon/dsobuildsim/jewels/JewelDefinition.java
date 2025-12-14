package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;
import com.langleon.dsobuildsim.enums.jewels.JewelType;

import java.util.Map;

public record JewelDefinition(JewelType jewelType,
                              Map<Integer, Map<OverallRelativeBuffType, Double>> statsPerTier, Map<CharacterClass, Map<Integer, String>> descriptionPerClassPerTier) {
}