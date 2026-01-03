package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.enums.dragonstones.DragonStoneType;

import java.util.Map;

public record DragonStoneConfig(Map<DragonStoneType, DragonStoneDefinition> dragonStones) {
}
