package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.dragonstones.DragonStoneType;

import java.util.Map;

public class DragonStone {
    private final DragonStoneType dragonStoneType;
    private final int tier;
    private final Map<StatType, Double> stats;
    private final String description;

    public DragonStone(DragonStoneType dragonStoneType, int tier, Map<StatType, Double> stats, String description) {
        this.dragonStoneType = dragonStoneType;
        this.tier = tier;
        this.stats = stats;
        this.description = description;
    }

    public DragonStoneType getDragonStoneType() {
        return dragonStoneType;
    }

    public int getTier() {
        return tier;
    }

    public Map<StatType, Double> getStats() {
        return stats;
    }

    public String getDescription() {
        return description;
    }
}
