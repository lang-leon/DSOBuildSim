package com.langleon.dsobuildsim.dragonstones;

import java.util.Map;

public record DragonStoneConfig(Map<DragonStoneType, DragonStoneDefinition> dragonStones) {
}
