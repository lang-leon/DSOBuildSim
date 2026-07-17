package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.buffs.enums.PhysicType;

public record Physic(PhysicType physicType, StatType statType, Double statValue, int tier) {

    public String description()
    {
        return String.format("+ %.2f%% %s", statValue * 100, statType.getName());
    }

    public String getName()
    {
        return physicType.getName();
    }

}
