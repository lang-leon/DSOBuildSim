package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.gems.dto.GemDefinitionDTO;

import java.util.Collections;

public class GemMapper {

    public static GemDefinitionDTO from(GemDefinition definition)
    {
        return new GemDefinitionDTO(definition.gemType(), definition.gemLimitGroup(), definition.name(), Collections.max(definition.statsPerTier().keySet()), definition.statType(), definition.statsPerTier());
    }
}