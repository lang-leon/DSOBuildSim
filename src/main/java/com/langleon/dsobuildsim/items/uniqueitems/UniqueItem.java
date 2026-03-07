package com.langleon.dsobuildsim.items.uniqueitems;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.items.core.LevelMultiplierTable;
import com.langleon.dsobuildsim.items.core.UniqueStatProvider;
import com.langleon.dsobuildsim.utils.MapUtils;

import java.util.EnumMap;

import java.util.List;
import java.util.Map;

public class UniqueItem extends Item implements UniqueStatProvider {

    private final Map<StatType, Double> uniqueBaseValues;
    private final Map<StatType, Double> uniqueRelativeValues;
    private final List<Enchantment> uniqueEnchantments;
    private final String uniqueDescription;

    public UniqueItem(UniqueItemDefinition itemDefinition, LevelMultiplierTable levelMultipliers, Map<StatType, Double> uniqueBaseValues, Map<StatType, Double> uniqueRelativeValues, List<Enchantment> uniqueEnchantments, String uniqueDescription){
        super(itemDefinition, levelMultipliers);
        this.uniqueBaseValues = uniqueBaseValues;
        this.uniqueRelativeValues = uniqueRelativeValues;
        this.uniqueEnchantments = uniqueEnchantments;
        this.uniqueDescription = uniqueDescription;
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
        Map<StatType, Double> totalStats = new EnumMap<>(StatType.class);
        totalStats.putAll(getBaseValues());

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
