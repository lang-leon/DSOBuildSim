package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.enums.dragonstones.DragonStoneType;

public class DragonStoneFactory {

    private final DragonStoneConfig config;

    public DragonStoneFactory(DragonStoneConfig config) {
        this.config = config;
    }

    public DragonStone createDragonStone(DragonStoneType dragonStoneType)
    {
        DragonStoneDefinition dragonStoneDefinition = this.config.dragonStones().get(dragonStoneType);
        return new DragonStone(dragonStoneType, dragonStoneDefinition.tier(), dragonStoneDefinition.stats(), dragonStoneDefinition.description());
    }
}
