package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.buffs.enums.PhysicType;

import java.util.Map;

public record PhysicDefinition(PhysicType physicType, int defaultTier, StatType statType, Map<Integer, Double> statsPerTier) {
}
