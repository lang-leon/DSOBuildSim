package com.langleon.dsobuildsim.gems.dto;

import com.langleon.dsobuildsim.gems.enums.GemCategory;
import com.langleon.dsobuildsim.gems.enums.GemType;

import java.util.List;

public record GemInstanceDTO(GemCategory gemCategory, List<GemType> gemType, int tier) {
}
