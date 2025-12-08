package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.enums.runes.RuneType;

import java.util.Map;

public record RuneConfig(Map<RuneType, RuneDefinition> runes, Map<Integer, Integer> offensiveUpgradeCosts, Map<Integer, Integer> defensiveUpgradeCosts, Map<Integer, Integer> basicUpgradeCosts)
{
}
