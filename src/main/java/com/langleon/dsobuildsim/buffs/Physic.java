package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.buffs.PhysicType;

public record Physic(PhysicType physicType, StatType statType, Double statValue, int tier) {

    public String description()
    {
        return String.format("+ %.2f%% %s", statValue * 100, statType);
    }

    public String getName()
    {
        return physicType.getName();
    }

}
