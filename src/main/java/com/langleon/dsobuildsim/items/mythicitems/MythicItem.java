package com.langleon.dsobuildsim.items.mythicitems;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;
import com.langleon.dsobuildsim.enums.items.SetType;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.items.core.AbstractItem;
import java.util.HashMap;
import java.util.Map;

public class MythicItem extends AbstractItem {
    private final Map<StatType, Double> uniqueRelativeValues;
    private final Map<StatType, Double> uniqueAbsoluteValues;
    private final SetType set;

    public MythicItem(ItemType itemType, String name, int level, int tier, ItemSlotType itemSlotType, Map<StatType, Double> baseStats, Map<StatType, Double> uniqueRelativeValues, Map<StatType, Double> uniqueAbsoluteValues, SetType set){
        this.itemType = itemType;
        this.name = name;
        this.level = level;
        this.tier = tier;
        this.itemSlotType = itemSlotType;
        this.baseStats = baseStats;
        this.uniqueRelativeValues = uniqueRelativeValues;
        this.uniqueAbsoluteValues = uniqueAbsoluteValues;
        this.set = set;
        this.gems = new Gem[10];
        this.enchants = new Enchant[10];
    }

    public SetType getSet() {
        return set;
    }

    public Map<StatType, Double> getUniqueRelativeValues() {
        return uniqueRelativeValues;
    }

    public Map<StatType, Double> getUniqueAbsoluteValues() {
        return uniqueAbsoluteValues;
    }

    @Override
    public Map<StatType, Double> calculateTotalStats() {
        Map<StatType, Double> totalStats = new HashMap<>(getBaseStats());

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
                totalStats.computeIfPresent(entry.getKey(), (k, oldVal) -> oldVal * entry.getValue());
            }
        }

        //calculate stats with unique absolute values applied
        for (Map.Entry<StatType, Double> entry : uniqueAbsoluteValues.entrySet())
        {
            totalStats.merge(entry.getKey(), entry.getValue(), Double::sum);
        }

        return totalStats;
    }
}

