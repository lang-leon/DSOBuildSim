package com.langleon.dsobuildsim.jewels;

import java.util.Map;

public record JewelConfig (Map<JewelType, JewelDefinition> jewels, Map<Integer, Integer> upgradeCosts)
{
}
