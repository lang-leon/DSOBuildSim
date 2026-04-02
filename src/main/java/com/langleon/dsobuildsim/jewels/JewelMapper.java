package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.jewels.dto.JewelDefinitionDTO;

public class JewelMapper {

    public static JewelDefinitionDTO from(JewelDefinition jewelDefinition)
    {
        return new JewelDefinitionDTO(jewelDefinition.jewelType(), jewelDefinition.name(), jewelDefinition.defaultTier(), jewelDefinition.statsPerTier(), jewelDefinition.descriptionPerTier());
    }
}
