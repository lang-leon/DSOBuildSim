package com.langleon.dsobuildsim.items.setitems;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.items.core.ItemType;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.items.core.SetBonusProvider;

import java.util.EnumMap;
import java.util.Map;

public class SetItem extends Item implements SetBonusProvider {
    private final SetType setType;
    private final SetItemType itemType;

    public SetItem(SetItemDefinition itemDefinition, Map<StatType, Double> baseValues, int level){
        super(itemDefinition.itemSlotType(), baseValues, level);
        this.itemType = itemDefinition.itemType();
        this.setType = itemDefinition.set();
    }

    @Override
    public ItemType getItemType() {
        return this.itemType;
    }

    @Override
    public SetType getSetType() {
        return setType;
    }

    @Override
    public String getSetItemIdentifier() {
        return this.itemType.toString();
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
                totalStats.computeIfPresent(entry.getKey(), (_, oldVal) -> oldVal * (entry.getValue()+1));
            }
        }

        return totalStats;
    }
}