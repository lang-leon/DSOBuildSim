package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.gems.enums.GemUpgradeType;

import java.util.Map;

public class Opal extends AbstractGem{


    public Opal(int tier, Map<StatType, Double> stats){
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
