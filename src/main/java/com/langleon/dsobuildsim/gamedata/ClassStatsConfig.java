package com.langleon.dsobuildsim.gamedata;

import com.langleon.dsobuildsim.character.CharacterClass;
  import com.langleon.dsobuildsim.gamedata.dto.ClassStatsDTO;

import java.util.Map;

public record ClassStatsConfig(Map<CharacterClass, ClassStatsDTO> classStats) {
}
