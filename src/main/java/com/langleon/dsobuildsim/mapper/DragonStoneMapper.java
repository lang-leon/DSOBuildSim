package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.dragonstones.DragonStoneDefinition;
import com.langleon.dsobuildsim.dto.DragonStoneDTO;

public class DragonStoneMapper {

    public static DragonStoneDTO from(DragonStoneDefinition definition)
    {
        return new DragonStoneDTO(definition.dragonStoneType(), definition.dragonStoneType().getName(), definition.defaultTier(), definition.statsPerTier(), definition.descriptionPerTier());
    }
}
