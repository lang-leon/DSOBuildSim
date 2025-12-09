package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.enums.jewels.JewelType;

import java.util.Map;

public record JewelConfig (Map<JewelType, JewelDefinition> jewels, Map<Integer, Integer> upgradeCosts)
{
}
