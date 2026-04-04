package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;

import java.util.Map;

public class Opal extends AbstractGem{


    public Opal(int tier, Map<StatType, Double> stats){
        super.gemType = GemType.OPAL;
        super.gemLimitGroup = GemLimitGroup.OPAL;
        super.tier = tier;
        super.stats = stats;
    }
}
