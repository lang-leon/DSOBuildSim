package com.langleon.dsobuildsim.jewels.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.jewels.JewelType;

import java.util.Map;

public record JewelDefinitionDTO(JewelType jewelType, String name, int tier, Map<Integer, Map<StatType, Double>> statsPerTier, Map<Integer, String> descriptionPerTier) {
}
