package com.langleon.dsobuildsim.gems.dto;

import com.langleon.dsobuildsim.gems.enums.GemType;

public record OpalDefinitionDTO(GemType gemType1, GemType gemType2, GemType gemType3, int tier) {
}