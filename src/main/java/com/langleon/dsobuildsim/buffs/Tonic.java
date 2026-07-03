package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.buffs.enums.TonicType;

public record Tonic(TonicType tonicType, StatType statType, Double statValue, int tier) {

    public String description()
    {
        return String.format("+ %.0f %s", statValue, statType.getName());
    }

    public String getName()
    {
        return tonicType.getName();
    }

}