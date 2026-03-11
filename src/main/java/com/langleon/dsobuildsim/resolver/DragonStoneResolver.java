package com.langleon.dsobuildsim.resolver;

import com.langleon.dsobuildsim.dragonstones.DragonStone;
import com.langleon.dsobuildsim.dragonstones.DragonStoneFactory;
import com.langleon.dsobuildsim.dragonstones.DragonStoneType;
import com.langleon.dsobuildsim.dto.DragonStoneDTO;

public class DragonStoneResolver {

    private final DragonStoneFactory dragonStoneFactory;

    public DragonStoneResolver(DragonStoneFactory dragonStoneFactory) {
        this.dragonStoneFactory = dragonStoneFactory;
    }

    public DragonStone resolveDragonStone(DragonStoneDTO dragonStoneDTO)
    {
        try
        {
            DragonStoneType dragonStoneType = dragonStoneDTO.dragonStoneType();
            return dragonStoneFactory.createDragonStone(dragonStoneType, dragonStoneDTO.tier());
        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("Unknown dragonstone type: " + dragonStoneDTO.dragonStoneType(), e);
        }
    }
}
