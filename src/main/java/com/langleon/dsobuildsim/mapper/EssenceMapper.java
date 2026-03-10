package com.langleon.dsobuildsim.mapper;

import com.langleon.dsobuildsim.dto.EssenceDTO;
import com.langleon.dsobuildsim.essences.EssenceDefinition;

public class EssenceMapper {

    public static EssenceDTO from(EssenceDefinition essence)
    {
        return new EssenceDTO(essence.essenceType().toString(), essence.essenceType().getName(), essence.defaultTier(), essence.damagePerTier(), essence.descriptionPerTier());
    }
}
