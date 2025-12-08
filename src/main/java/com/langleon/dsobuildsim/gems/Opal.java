package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.gems.GemLimitGroup;
import com.langleon.dsobuildsim.enums.gems.GemType;
import com.langleon.dsobuildsim.enums.gems.GemUpgradeType;

import java.util.Map;

public class Opal extends AbstractGem{


    public Opal(int tier, Map<AbsoluteStatType, Double> stats){
        super.gemType = GemType.OPAL;
        super.gemUpgradeType = GemUpgradeType.OPAL;
        super.gemLimitGroup = GemLimitGroup.OPAL;
        super.tier = tier;
        super.stats = stats;
    }

    @Override
    public Opal copyGem()
    {
        return new Opal(this.tier, this.stats);
    }
}
