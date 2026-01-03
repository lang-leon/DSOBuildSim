package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.dragonstones.DragonStoneType;

import java.util.Map;

public record DragonStone(DragonStoneType dragonStoneType, int tier, Map<StatType, Double> stats, String description) {
}
