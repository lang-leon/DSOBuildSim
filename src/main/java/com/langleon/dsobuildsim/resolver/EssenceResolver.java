package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dto.EssenceDTO;
import com.langleon.dsobuildsim.essences.Essence;
import com.langleon.dsobuildsim.essences.EssenceFactory;
import com.langleon.dsobuildsim.essences.EssenceType;

public class EssenceResolver {

    private final EssenceFactory essenceFactory;

    public EssenceResolver(EssenceFactory essenceFactory) {
        this.essenceFactory = essenceFactory;
    }

    public Essence resolveEssence(EssenceDTO essenceDTO)
    {
        try
        {
            EssenceType essenceType = essenceDTO.essenceType();
            return essenceFactory.createEssence(essenceType, essenceDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown essence type: " + essenceDTO.essenceType(), e);
        }
    }
}
