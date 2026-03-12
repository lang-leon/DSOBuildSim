package com.langleon.dsobuildsim.character;

import com.langleon.dsobuildsim.dto.ClassStatsDTO;

import java.util.Map;

public record ClassStatsConfig(Map<CharacterClass, ClassStatsDTO> classStats) {
}
