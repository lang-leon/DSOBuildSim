package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.enums.StatType;

import java.util.HashMap;
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

    public Map<StatType, Double> getTotalStats()
    {
        Map<StatType, Double> stats = new HashMap<>();
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
