package com.langleon.dsobuildsim.gems.dto;

import com.langleon.dsobuildsim.gems.enums.GemType;

public record GemInstanceDTO(GemType gemType, int tier) implements AbstractGemInstanceDTO {
}
