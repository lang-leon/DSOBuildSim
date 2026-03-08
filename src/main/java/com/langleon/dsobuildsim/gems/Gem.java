package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import com.langleon.dsobuildsim.gems.enums.GemUpgradeType;

import java.util.Map;

public class Gem extends AbstractGem{
    public Gem(GemType gemType, GemUpgradeType gemUpgradeType, GemLimitGroup gemLimitGroup, int tier, Map<StatType, Double> stats) {
        super.gemType = gemType;
        super.gemUpgradeType = gemUpgradeType;
        super.gemLimitGroup = gemLimitGroup;
        super.tier = tier;
        super.stats = stats;
    }

    @Override
    public Gem copyGem()
    {
        return new Gem(this.gemType, this.gemUpgradeType, this.gemLimitGroup, this.tier, this.stats);
    }
}
