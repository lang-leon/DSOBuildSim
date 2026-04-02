package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.character.CharacterClass;

import java.util.Map;

public record JewelConfig (Map<CharacterClass, Map<JewelType, JewelDefinition>> jewels, Map<Integer, Integer> upgradeCosts)
{
}
