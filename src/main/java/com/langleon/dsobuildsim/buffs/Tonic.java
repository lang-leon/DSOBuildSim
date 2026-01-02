package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.buffs.TonicType;

public record Tonic(TonicType tonicType, StatType statType, Double value, int tier) {

    public String description()
    {
        return String.format("+ %.2f%% %s", value * 100, statType);
    }

    public String getName()
    {
        return tonicType.getName();
    }

}