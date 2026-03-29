package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.common.StatType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RuneTrinket {

    private final List<Rune> runes;

    public RuneTrinket(List<Rune> runes) {
        if (runes.size() > 10) throw new IllegalArgumentException("Rune Trinket can only hold up to 10 Runes.");
        this.runes = runes;
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public Map<StatType, Double> getTotalRelativeStats()
    {
        Map<StatType, Double> stats = new EnumMap<>(StatType.class);
        for(int i=0; i<10; i++)
        {
            if (runes.get(i)!=null)
            {
                for(Map.Entry<StatType, Double> entry : runes.get(i).getStats().entrySet())
                {
                    stats.merge(entry.getKey(), entry.getValue(), Double::sum);
                }
            }
        }
        return stats;
    }
}
