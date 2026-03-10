package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.dto.GemDTO;
import com.langleon.dsobuildsim.gems.GemDefinition;

import java.util.Collections;

public class GemMapper {

    public static GemDTO from(GemDefinition definition)
    {
        return new GemDTO(definition.gemType(), definition.gemLimitGroup(), definition.gemLimitGroup().getLimit(), Collections.max(definition.statsPerTier().keySet()), definition.statType(), definition.statsPerTier());
    }
}