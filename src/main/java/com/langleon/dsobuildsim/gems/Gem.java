package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;

import java.util.Map;

public class Gem extends AbstractGem{
    public Gem(GemType gemType, GemLimitGroup gemLimitGroup, int tier, Map<StatType, Double> stats) {
        super.gemType = gemType;
        super.gemLimitGroup = gemLimitGroup;
        super.tier = tier;
        super.stats = stats;
    }
}
