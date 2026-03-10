package com.langleon.dsobuildsim.dto;

import java.util.Map;

public record EssenceDTO(String essenceType, String name, int tier, Map<Integer, Double> damage, Map<Integer, String> description) {
}
