package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record DragonStoneDefinition(DragonStoneType dragonStoneType, Integer defaultTier, Map<Integer, Map<StatType, Double>> statsPerTier, Map<Integer, String> descriptionPerTier) {
}
