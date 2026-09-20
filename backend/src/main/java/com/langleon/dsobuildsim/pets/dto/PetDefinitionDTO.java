package com.langleon.dsobuildsim.pets.dto;

import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.pets.enums.PetType;

import java.util.Map;

public record PetDefinitionDTO(PetType petType, CollectorBagCategory petCategory, String name, int tier, Map<Integer, Map<StatType, Double>> stats, Map<Integer, String> description) {
}
