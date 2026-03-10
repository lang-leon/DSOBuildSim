package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dto.GemDTO;
import com.langleon.dsobuildsim.dto.OpalDTO;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.gems.Opal;
import com.langleon.dsobuildsim.gems.enums.GemType;

public class GemResolver {

    private final GemFactory gemFactory;

    public GemResolver(GemFactory gemFactory) {
        this.gemFactory = gemFactory;
    }

    public Gem resolve(GemDTO gemDTO)
    {
        try
        {
            return gemFactory.createGem(gemDTO.gemType(), gemDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown gem type: " + gemDTO.gemType(), e);
        }
    }

    public Opal resolve(OpalDTO opalDTO)
    {
        try
        {
            GemType gemType1 = opalDTO.gemType1();
            GemType gemType2 = opalDTO.gemType2();
            GemType gemType3 = opalDTO.gemType3();
            return gemFactory.createOpal(gemType1, gemType2, gemType3, opalDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown gem type combination: " + opalDTO.gemType1() + ", "+ opalDTO.gemType2() +", "+opalDTO.gemType3()+".", e);
        }
    }
}