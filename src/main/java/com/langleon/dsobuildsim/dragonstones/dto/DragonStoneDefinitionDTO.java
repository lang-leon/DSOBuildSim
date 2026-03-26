package com.langleon.dsobuildsim.dragonstones.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;

import java.util.Map;

public record DragonStoneDefinitionDTO(DragonStoneType dragonStoneType, String name, int defaultTier, Map<Integer, Map<StatType, Double>> stats, Map<Integer, String> description) {
}
