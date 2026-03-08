package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.buffs.enums.TonicType;

import java.util.Map;

public record TonicDefinition(TonicType tonicType, int defaultTier, StatType statType, Map<Integer, Double> statsPerTier){
}
