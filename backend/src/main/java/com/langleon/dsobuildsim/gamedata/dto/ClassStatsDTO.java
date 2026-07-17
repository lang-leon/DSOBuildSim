package com.langleon.dsobuildsim.gamedata.dto;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Map;

public record ClassStatsDTO (Map<StatType, Double> absoluteStats, Map<StatType, Double> relativeStats){
}
