package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.buffs.TonicType;

import java.util.Map;

public record TonicDefinition(TonicType tonicType, int defaultTier, StatType statType, Map<Integer, Double> statsPerTier){
}
