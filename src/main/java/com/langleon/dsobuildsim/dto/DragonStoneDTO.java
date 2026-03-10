package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record DragonStoneDTO(String dragonStoneType, String name, int tier, Map<Integer, Map<StatType, Double>> stats, Map<Integer, String> description) {
}
