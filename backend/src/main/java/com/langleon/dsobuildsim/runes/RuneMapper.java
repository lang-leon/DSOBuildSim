package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.runes.dto.RuneDefinitionDTO;

public class RuneMapper {

    public static RuneDefinitionDTO from(RuneDefinition runeDefinition)
    {
        return new RuneDefinitionDTO(runeDefinition.runeType(), runeDefinition.runeLimitGroup(), runeDefinition.defaultTier(), runeDefinition.statsPerTier(), runeDefinition.description());
    }
}
