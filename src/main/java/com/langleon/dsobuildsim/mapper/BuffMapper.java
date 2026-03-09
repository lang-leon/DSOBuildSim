package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.buffs.PhysicDefinition;
import com.langleon.dsobuildsim.buffs.TonicDefinition;
import com.langleon.dsobuildsim.buffs.enums.BuffType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.BuffDTO;

import java.util.Map;

public class BuffMapper {

    private static BuffDTO from(BuffType buffType, String name, int tier, StatType statType, Map<Integer, Double> statsPerTier)
    {
        return new BuffDTO(buffType.toString(), name, tier, statType, statsPerTier);
    }

    public static BuffDTO from(TonicDefinition tonic)
    {
        return from(tonic.tonicType(), tonic.tonicType().getName(), tonic.defaultTier(), tonic.statType(), tonic.statsPerTier());
    }

    public static BuffDTO from(PhysicDefinition physic)
    {
        return from(physic.physicType(), physic.physicType().getName(), physic.defaultTier(), physic.statType(), physic.statsPerTier());
    }
}
