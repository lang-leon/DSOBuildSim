package com.langleon.dsobuildsim.essences.dto;

import com.langleon.dsobuildsim.essences.EssenceType;

import java.util.Map;

public record EssenceDefinitionDTO(EssenceType essenceType, String name, int defaultTier, Map<Integer, Double> damage, Map<Integer, String> description) {
}
