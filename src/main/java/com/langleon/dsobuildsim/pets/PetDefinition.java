package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.pets.enums.PetCategory;
import com.langleon.dsobuildsim.pets.enums.PetType;
import com.langleon.dsobuildsim.pets.enums.PetUpgradeType;

import java.util.Map;

public record PetDefinition(PetType petType, PetCategory petCategory, PetUpgradeType petUpgradeType, int defaultTier, Map<Integer, Map<StatType, Double>> statsPerTier, Map<Integer, String> descriptionPerTier)
{
}
