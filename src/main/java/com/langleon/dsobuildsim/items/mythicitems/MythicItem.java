package com.langleon.dsobuildsim.items.mythicitems;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;
import com.langleon.dsobuildsim.enums.items.SetType;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.items.core.AbstractItem;
import com.langleon.dsobuildsim.items.core.SetBonusProvider;
import com.langleon.dsobuildsim.items.core.UniqueStatProvider;

import java.util.HashMap;
import java.util.Map;

public class MythicItem extends AbstractItem implements SetBonusProvider, UniqueStatProvider {
    private final Map<StatType, Double> uniqueRelativeValues;
    private final Map<StatType, Double> uniqueAbsoluteValues;
    private final SetType setType;

    public MythicItem(ItemType itemType, String name, int level, int tier, ItemSlotType itemSlotType, Map<StatType, Double> baseStats, Map<StatType, Double> uniqueRelativeValues, Map<StatType, Double> uniqueAbsoluteValues, SetType set){
        this.itemType = itemType;
        this.name = name;
        this.level = level;
        this.tier = tier;
        this.itemSlotType = itemSlotType;
        this.baseValues = baseStats;
        this.uniqueRelativeValues = uniqueRelativeValues;
        this.uniqueAbsoluteValues = uniqueAbsoluteValues;
        this.setType = set;
        this.gems = new AbstractGem[10];
        this.enchantments = new Enchantment[10];
    }

    public SetType getSetType() {
        return setType;
    }

    public Map<StatType, Double> getUniqueRelativeValues() {
        return uniqueRelativeValues;
    }

    public Map<StatType, Double> getUniqueAbsoluteValues() {
        return uniqueAbsoluteValues;
    }

    @Override
    public Map<StatType, Double> calculateTotalStats() {
        Map<StatType, Double> totalStats = new HashMap<>(getBaseValues());

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

