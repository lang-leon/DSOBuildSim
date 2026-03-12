package com.langleon.dsobuildsim.config;

import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.dto.ClassStatsDTO;

import java.util.Map;

public record ClassStatsConfig(Map<CharacterClass, ClassStatsDTO> classStats) {
}
