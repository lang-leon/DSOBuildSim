package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.gems.enums.GemUpgradeType;

import java.util.Map;

public record GemDefinition(GemType gemType, GemUpgradeType gemUpgradeType, String name, GemLimitGroup gemLimitGroup, StatType statType,
                            Map<Integer, Double> statsPerTier) {
}
