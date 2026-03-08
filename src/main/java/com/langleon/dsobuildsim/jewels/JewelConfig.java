package com.langleon.dsobuildsim.jewels;

import java.util.Map;

public record JewelConfig (Map<JewelType, JewelDefinition> spellweaverJewels, Map<JewelType, JewelDefinition> dragonknightJewels, Map<JewelType, JewelDefinition> rangerJewels, Map<JewelType, JewelDefinition> steamMechanicusJewels, Map<Integer, Integer> upgradeCosts)
{
}
