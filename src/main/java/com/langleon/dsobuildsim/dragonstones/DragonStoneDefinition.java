package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.dragonstones.DragonStoneType;

import java.util.Map;

public record DragonStoneDefinition(DragonStoneType dragonStoneType, Integer defaultTier, Map<Integer, Map<StatType, Double>> statsPerTier, Map<Integer, String> descriptionPerTier) {
}
