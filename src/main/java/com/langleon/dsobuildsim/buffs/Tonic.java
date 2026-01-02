package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.buffs.TonicType;

public record Tonic(TonicType tonicType, StatType statType, Double statValue, int tier) {

    public String description()
    {
        return String.format("+ %.0f %s", statValue, statType);
    }

    public String getName()
    {
        return tonicType.getName();
    }

}