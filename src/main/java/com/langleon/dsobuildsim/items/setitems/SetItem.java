package com.langleon.dsobuildsim.items.setitems;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;
import com.langleon.dsobuildsim.enums.items.SetType;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.items.core.AbstractItem;

import java.util.HashMap;
import java.util.Map;

public class SetItem extends AbstractItem {
    private final SetType set;

    public SetItem(ItemType itemType, String name, int level, int tier, ItemSlotType itemSlotType, Map<StatType, Double> baseStats, SetType set){
        this.itemType = itemType;
        this.name = name;
        this.level = level;
        this.tier = tier;
        this.itemSlotType = itemSlotType;
        this.baseValues = baseStats;
        this.set = set;
        this.gems = new Gem[10];
        this.enchantments = new Enchantment[10];
    }

    public SetType getSet() {
        return set;
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

        return totalStats;
    }
}