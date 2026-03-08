package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.common.StatType;

import java.util.EnumMap;
import java.util.Map;

public class DragonCrestTrinket {

    private DragonStone[] dragonStones;

    public DragonCrestTrinket() {
        this.dragonStones = new DragonStone[10];
    }

    public DragonStone[] getDragonStones() {
        return dragonStones;
    }

    public DragonStone getDragonStone(int slot) {
        return dragonStones[slot];
    }

    public void addDragonStone(DragonStone dragonStone, int slot)
    {
        if (dragonStone==null) throw new IllegalArgumentException("Dragon Stone is null!");
        if (slot<0 || slot>10) throw new IllegalArgumentException("Index out of range!");
        dragonStones[slot] = dragonStone;
    }

    public void removeDragonStone(int slot)
    {
        if (slot<0 || slot>10) throw new IllegalArgumentException("Index out of range!");
        dragonStones[slot] = null;
    }

    public void updateDragonStones(DragonStone[] dragonStones)
    {
        if (dragonStones.length!=10) throw new IllegalArgumentException("Invalid array length!");
        this.dragonStones = dragonStones;
    }

    public Map<StatType, Double> getTotalRelativeStats()
    {
        Map<StatType, Double> stats = new EnumMap<>(StatType.class);
        for(int i=0; i<10; i++)
        {
            if (dragonStones[i]!=null)
            {
                for(Map.Entry<StatType, Double> entry : dragonStones[i].stats().entrySet())
                {
                    stats.merge(entry.getKey(), entry.getValue(), Double::sum);
                }
            }
        }
        return stats;
    }
}
