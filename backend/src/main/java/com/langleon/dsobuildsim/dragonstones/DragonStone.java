package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record DragonStone(DragonStoneType dragonStoneType, int tier, Map<StatType, Double> stats, String description) {
}
