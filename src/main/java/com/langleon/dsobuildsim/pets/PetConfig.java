package com.langleon.dsobuildsim.pets;

import com.langleon.dsobuildsim.pets.enums.PetType;

import java.util.Map;

public record PetConfig(Map<PetType, PetDefinition> pets, Map<Integer, Integer> normalUpgradeCosts, Map<Integer, Integer> silverCatUpgradeCosts, Map<Integer, Integer> gildedCatUpgradeCosts)
{
}
