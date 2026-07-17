package com.langleon.dsobuildsim.essences;

import com.langleon.dsobuildsim.essences.dto.EssenceDefinitionDTO;

public class EssenceMapper {

    public static EssenceDefinitionDTO from(EssenceDefinition essence)
    {
        return new EssenceDefinitionDTO(essence.essenceType(), essence.essenceType().getName(), essence.defaultTier(), essence.damagePerTier(), essence.descriptionPerTier());
    }
}
