package com.langleon.dsobuildsim.items.setitems;

import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.SetType;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.items.core.LevelMultiplierTable;
import com.langleon.dsobuildsim.items.core.SetBonusProvider;

import java.util.EnumMap;
import java.util.Map;

public class SetItem extends Item implements SetBonusProvider {
    private final SetType setType;

    public SetItem(SetItemDefinition itemDefinition, LevelMultiplierTable levelMultipliers, SetType set){
        super(itemDefinition, levelMultipliers);
        this.setType = set;
    }

    @Override
    public SetType getSetType() {
        return setType;
    }

    @Override
    public String getSetItemIdentifier() {
        return this.itemDefinition.itemType().toString();
    }

    @Override
    public Map<StatType, Double> calculateTotalStats() {
        Map<StatType, Double> totalStats = new EnumMap<>(StatType.class);
        totalStats.putAll(getBaseValues());

        //calculate base stats + gem stats
        for (Map.Entry<StatType, Double> entry : super.calculateGemStats().entrySet())
        {
            totalStats.merge(entry.getKey(), entry.getValue(), Double::sum);
        }

        //calculate stats with enchants applied
        Map<StatType, Double> totalEnchants = calculateEnchantStats();
        for (Map.Entry<StatType, Double> entry : totalEnchants.entrySet())
        {
            if (totalStats.containsKey(entry.getKey()))
            {
                totalStats.computeIfPresent(entry.getKey(), (k, oldVal) -> oldVal * (entry.getValue()+1));
            }
        }

        return totalStats;
    }
}