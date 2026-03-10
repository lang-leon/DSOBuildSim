package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.dto.RuneDTO;
import com.langleon.dsobuildsim.runes.RuneDefinition;

public class RuneMapper {

    public static RuneDTO from(RuneDefinition runeDefinition)
    {
        return new RuneDTO(runeDefinition.runeType(), runeDefinition.runeLimitGroup(), runeDefinition.defaultTier(), runeDefinition.statsPerTier(), runeDefinition.description());
    }
}
