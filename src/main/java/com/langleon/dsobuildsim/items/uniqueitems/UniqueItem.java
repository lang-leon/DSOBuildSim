package com.langleon.dsobuildsim.items.uniqueitems;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.ItemType;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.items.core.AbstractItem;
import com.langleon.dsobuildsim.items.core.UniqueStatProvider;
import com.langleon.dsobuildsim.utils.MapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueItem extends AbstractItem implements UniqueStatProvider {

    private final Map<StatType, Double> uniqueBaseValues;
    private final Map<StatType, Double> uniqueRelativeValues;
    private final List<Enchantment> uniqueEnchantments;
    private final String uniqueDescription;

    public UniqueItem(ItemType itemType, String name, int level, int tier, ItemSlotType itemSlotType, Map<StatType, Double> baseStats, Map<StatType, Double> uniqueBaseValues, Map<StatType, Double> uniqueRelativeValues, List<Enchantment> uniqueEnchantments, String uniqueDescription){
        this.itemType = itemType;
        this.name = name;
        this.level = level;
        this.tier = tier;
        this.itemSlotType = itemSlotType;
        this.baseValues = baseStats;
        this.uniqueBaseValues = uniqueBaseValues;
        this.uniqueRelativeValues = uniqueRelativeValues;
        this.uniqueEnchantments = uniqueEnchantments;
        this.uniqueDescription = uniqueDescription;
        this.gems = new AbstractGem[10];
        this.enchantments = new Enchantment[4];
    }

    public Map<StatType, Double> getUniqueBaseValues() {
        return uniqueBaseValues;
    }

    public void updateUniqueBaseValues(Map<StatType, Double> newUniqueBaseValues)
    {
        MapUtils.replaceExisting(this.uniqueBaseValues, newUniqueBaseValues);
    }

    public Map<StatType, Double> getUniqueRelativeValues() {
        return uniqueRelativeValues;
    }

    public List<Enchantment> getUniqueEnchants() {
        return uniqueEnchantments;
    }

    public String getUniqueDescription() {
        return uniqueDescription;
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
        for (Enchantment enchantment : uniqueEnchantments)
        {
            totalEnchants.merge(enchantment.getStatType(), enchantment.getValue(), Double::sum);
        }
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
