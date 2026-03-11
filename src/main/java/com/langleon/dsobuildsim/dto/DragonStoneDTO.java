package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;

import java.util.Map;

public record DragonStoneDTO(DragonStoneType dragonStoneType, String name, int tier, Map<Integer, Map<StatType, Double>> stats, Map<Integer, String> description) {
}
