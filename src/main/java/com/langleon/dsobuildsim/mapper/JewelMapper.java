package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.dto.JewelDTO;
import com.langleon.dsobuildsim.jewels.JewelDefinition;

public class JewelMapper {

    public static JewelDTO from(JewelDefinition jewelDefinition)
    {
        return new JewelDTO(jewelDefinition.jewelType(), jewelDefinition.name(), jewelDefinition.defaultTier(), null, jewelDefinition.statsPerTier(), jewelDefinition.descriptionPerTier());
    }
}
