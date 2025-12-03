package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.enums.GemType;

import java.util.Map;

public record GemConfig (Map<GemType, GemDefinition> gems, Map<Integer, Integer> offensiveUpgradeCosts, Map<Integer, Integer> defensiveUpgradeCosts, Map<Integer, Integer> opalUpgradeCosts){
}
