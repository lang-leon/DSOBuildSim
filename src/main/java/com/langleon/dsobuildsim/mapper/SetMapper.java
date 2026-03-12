package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.dto.SetDTO;
import com.langleon.dsobuildsim.sets.SetDefinition;

public class SetMapper {

    public static SetDTO from(SetDefinition setDefinition)
    {
        return new SetDTO(setDefinition.setType(), setDefinition.name(), setDefinition.defaultLevel(), setDefinition.setItems(), setDefinition.baseValuesPerTier(), setDefinition.relativeValuesPerTier(), setDefinition.descriptionPerTier());
    }
}
