package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.buffs.enums.BuffType;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.buffs.dto.BuffDefinitionDTO;

import java.util.Map;

public class BuffMapper {

    private static BuffDefinitionDTO from(BuffType buffType, String name, int tier, StatType statType, Map<Integer, Double> statsPerTier)
    {
        return new BuffDefinitionDTO(buffType.toString(), name, tier, statType, statsPerTier);
    }

    public static BuffDefinitionDTO from(TonicDefinition tonic)
    {
        return from(tonic.tonicType(), tonic.tonicType().getName(), tonic.defaultTier(), tonic.statType(), tonic.statsPerTier());
    }

    public static BuffDefinitionDTO from(PhysicDefinition physic)
    {
        return from(physic.physicType(), physic.physicType().getName(), physic.defaultTier(), physic.statType(), physic.statsPerTier());
    }
}
