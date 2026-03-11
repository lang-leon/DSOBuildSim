package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.essences.EssenceType;

import java.util.Map;

public record EssenceDTO(EssenceType essenceType, String name, int tier, Map<Integer, Double> damage, Map<Integer, String> description) {
}
