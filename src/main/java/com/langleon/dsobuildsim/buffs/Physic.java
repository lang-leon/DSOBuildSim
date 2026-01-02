package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.buffs.PhysicType;

public record Physic(PhysicType physicType, StatType statType, Double value, int tier) {

    public String description()
    {
        return String.format("+ %.0f %s", value, statType);
    }

    public String getName()
    {
        return physicType.getName();
    }

}
