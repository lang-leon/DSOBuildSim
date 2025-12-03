package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.GemType;

import java.util.Map;

public class Gem extends AbstractGem{
    public Gem(GemType gemType, int tier, Map<AbsoluteStatType, Double> stats) {
        super.gemType = gemType;
        super.tier = tier;
        super.stats = stats;
    }

    @Override
    public Gem copyGem()
    {
        return new Gem(this.gemType, this.tier, this.stats);
    }
}
