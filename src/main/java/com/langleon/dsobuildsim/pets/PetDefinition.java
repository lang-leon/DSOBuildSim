package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.pets.PetCategory;
import com.langleon.dsobuildsim.enums.pets.PetType;
import com.langleon.dsobuildsim.enums.pets.PetUpgradeType;

import java.util.Map;

public record PetDefinition(PetType petType, PetCategory petCategory, PetUpgradeType petUpgradeType, int defaultTier, Map<Integer, Map<StatType, Double>> statsPerTier, Map<Integer, String> descriptionPerTier)
{
}
