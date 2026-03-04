package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.enums.StatType;

import java.util.HashMap;
import java.util.Map;

public class RuneTrinket {

    private Rune[] runes;

    public RuneTrinket() {
        runes = new Rune[10];
    }

    public Rune[] getRunes() {
        return runes;
    }

    public Rune getRune(int slot) {
        return runes[slot];
    }

    public void addRune(Rune rune, int slot){
        if (rune==null) throw new IllegalArgumentException("Rune is null!");
        if (slot<0 || slot>10) throw new IllegalArgumentException("Index out of range!");
        runes[slot] = rune;
    }

    public void removeRune(int slot){
        if (slot<0 || slot>10) throw new IllegalArgumentException("Index out of range!");
        runes[slot] = null;
    }

    public void updateRunes(Rune[] runes)
    {
        if (runes.length!=10) throw new IllegalArgumentException("Invalid array length!");
        this.runes = runes;
    }

    public Map<StatType, Double> getTotalStats()
    {
        Map<StatType, Double> stats = new HashMap<>();
        for(int i=0; i<10; i++)
        {
            if (runes[i]!=null)
            {
                for(Map.Entry<StatType, Double> entry : runes[i].getStats().entrySet())
                {
                    stats.merge(entry.getKey(), entry.getValue(), Double::sum);
                }
            }
        }
        return stats;
    }
}
