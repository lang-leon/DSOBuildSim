package com.langleon.dsobuildsim.items.uniqueitems;

import com.langleon.dsobuildsim.enchantments.Enchant;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;
import com.langleon.dsobuildsim.enums.items.SetType;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.items.core.AbstractItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueItem extends AbstractItem {

    private final Map<StatType, Double> uniqueBaseValues;
    private final Map<StatType, Double> uniqueRelativeValues;
    private final List<Enchant> uniqueEnchants;

    public UniqueItem(ItemType itemType, String name, int level, int tier, ItemSlotType itemSlotType, Map<StatType, Double> baseStats, Map<StatType, Double> uniqueBaseValues, Map<StatType, Double> uniqueRelativeValues, List<Enchant> uniqueEnchants){
        this.itemType = itemType;
        this.name = name;
        this.level = level;
        this.tier = tier;
        this.itemSlotType = itemSlotType;
        this.baseValues = baseStats;
        this.uniqueBaseValues = uniqueBaseValues;
        this.uniqueRelativeValues = uniqueRelativeValues;
        this.uniqueEnchants = uniqueEnchants;
        this.gems = new Gem[10];
        this.enchants = new Enchant[10];
    }

    public Map<StatType, Double> getUniqueBaseValues() {
        return uniqueBaseValues;
    }

    public Map<StatType, Double> getUniqueRelativeValues() {
        return uniqueRelativeValues;
    }

    public List<Enchant> getUniqueEnchants() {
        return uniqueEnchants;
    }

    @Override
    public Map<StatType, Double> calculateTotalStats() {
        Map<StatType, Double> totalStats = new HashMap<>(getBaseValues());

        //add unique base stats
        for (Map.Entry<StatType, Double> entry : uniqueBaseValues.entrySet())
        {
            totalStats.merge(entry.getKey(), entry.getValue(), Double::sum);
        }

        //add gem stats
        for (Map.Entry<StatType, Double> entry : super.calculateGemStats().entrySet())
        {
            totalStats.merge(entry.getKey(), entry.getValue(), Double::sum);
        }

        //calculate item stats with enchants applied
        Map<StatType, Double> totalEnchants = calculateEnchantStats();
        for (Enchant enchant : uniqueEnchants)
        {
            totalEnchants.merge(enchant.getStatType(), enchant.getValue(), Double::sum);
        }
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
