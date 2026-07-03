package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.exceptions.LimitExceededException;
import com.langleon.dsobuildsim.exceptions.LimitType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class JewelTrinket {

    private final List<Jewel> jewels;

    public JewelTrinket(List<Jewel> jewels) {
        if (jewels.size() > 10) throw new LimitExceededException(LimitType.JEWEL_TRINKET, "Jewel Trinket can only hold up to 10 jewels.");
        this.jewels = jewels;
    }

    public List<Jewel> getJewels() {
        return jewels;
    }

    public Map<StatType, Double> getTotalRelativeStats()
    {
        Map<StatType, Double> stats = new EnumMap<>(StatType.class);
        for(int i=0; i<10; i++)
        {
            if (jewels.get(i)!=null)
            {
                for(Map.Entry<StatType, Double> entry : jewels.get(i).getStats().entrySet())
                {
                    stats.merge(entry.getKey(), entry.getValue(), Double::sum);
                }
            }
        }
        return stats;
    }
}
