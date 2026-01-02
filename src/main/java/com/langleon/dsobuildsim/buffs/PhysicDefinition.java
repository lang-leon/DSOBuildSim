package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.buffs.PhysicType;

import java.util.Map;

public record PhysicDefinition(PhysicType physicType, int defaultTier, StatType statType, Map<Integer, Double> statsPerTier) {
}
