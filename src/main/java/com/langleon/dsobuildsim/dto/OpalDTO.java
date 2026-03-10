package com.langleon.dsobuildsim.dto;

import com.langleon.dsobuildsim.gems.enums.GemType;

public record OpalDTO(GemType gemType1, GemType gemType2, GemType gemType3, int tier) {
}