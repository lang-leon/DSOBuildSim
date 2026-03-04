package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.enums.StatType;

import java.util.HashMap;
import java.util.Map;

public class JewelTrinket {

    private Jewel[] jewels;

    public JewelTrinket() {
        jewels = new Jewel[10];
    }

    public Jewel[] getJewels() {
        return jewels;
    }

    public Jewel getJewel(int slot) {
        return jewels[slot];
    }

    public void addJewel(Jewel jewel, int slot){
        if (jewel==null) throw new IllegalArgumentException("Jewel is null!");
        if (slot<0 || slot>10) throw new IllegalArgumentException("Index out of range!");
        jewels[slot] = jewel;
    }

    public void removeJewel(int slot){
        if (slot<0 || slot>10) throw new IllegalArgumentException("Index out of range!");
        jewels[slot] = null;
    }

    public void updateJewels(Jewel[] jewels)
    {
        if (jewels.length!=10) throw new IllegalArgumentException("Invalid array length!");
        this.jewels = jewels;
    }

    public Map<StatType, Double> getTotalStats()
    {
        Map<StatType, Double> stats = new HashMap<>();
        for(int i=0; i<10; i++)
        {
            if (jewels[i]!=null)
            {
                for(Map.Entry<StatType, Double> entry : jewels[i].getStats().entrySet())
                {
                    stats.merge(entry.getKey(), entry.getValue(), Double::sum);
                }
            }
        }
        return stats;
    }
}
