package com.langleon.dsobuildsim.sets;

import com.langleon.dsobuildsim.sets.dto.SetDTO;

public class SetMapper {

    public static SetDTO from(SetDefinition setDefinition)
    {
        return new SetDTO(setDefinition.setType(), setDefinition.name(), setDefinition.defaultLevel(), setDefinition.setItems(), setDefinition.baseValuesPerTier(), setDefinition.relativeValuesPerTier(), setDefinition.descriptionPerTier());
    }
}
