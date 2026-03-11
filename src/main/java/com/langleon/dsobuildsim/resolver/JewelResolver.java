package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dto.JewelDTO;
import com.langleon.dsobuildsim.jewels.Jewel;
import com.langleon.dsobuildsim.jewels.JewelFactory;

import java.util.List;

public class JewelResolver {
    
    private final JewelFactory jewelFactory;

    public JewelResolver(JewelFactory jewelFactory) {
        this.jewelFactory = jewelFactory;
    }
    
    public Jewel resolveJewel(JewelDTO jewelDTO)
    {
        try
        {
            return jewelFactory.createJewel(jewelDTO.jewelType(), jewelDTO.characterClass(), jewelDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown jewel type: " + jewelDTO.jewelType(), e);
        }
    }

    public List<Jewel> resolveJewels(List<JewelDTO> jewelDTOs)
    {
        if (jewelDTOs==null) return List.of();
        return jewelDTOs.stream().map(this::resolveJewel).toList();
    }
}
