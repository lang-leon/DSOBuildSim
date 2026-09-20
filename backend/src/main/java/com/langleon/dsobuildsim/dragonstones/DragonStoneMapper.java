package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneDefinitionDTO;

public class DragonStoneMapper {

    public static DragonStoneDefinitionDTO from(DragonStoneDefinition definition)
    {
        return new DragonStoneDefinitionDTO(definition.dragonStoneType(), definition.dragonStoneType().getName(), definition.defaultTier(), definition.statsPerTier(), definition.descriptionPerTier());
    }
}
