package com.langleon.dsobuildsim.dragonstones;

public class DragonStoneFactory {

    private final DragonStoneConfig config;

    public DragonStoneFactory(DragonStoneConfig config) {
        this.config = config;
    }

    public DragonStone createDragonStone(DragonStoneType dragonStoneType, int tier)
    {
        DragonStoneDefinition dragonStoneDefinition = this.config.dragonStones().get(dragonStoneType);
        return new DragonStone(dragonStoneType, tier, dragonStoneDefinition.statsPerTier().get(tier), dragonStoneDefinition.descriptionPerTier().get(tier));
    }
}
