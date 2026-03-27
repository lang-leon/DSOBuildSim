package com.langleon.dsobuildsim.items.uniqueitems;

import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.items.core.Item;
import com.langleon.dsobuildsim.items.core.enums.ItemType;
import com.langleon.dsobuildsim.items.core.UniqueStatProvider;

import java.util.EnumMap;

import java.util.List;
import java.util.Map;

public class UniqueItem extends Item implements UniqueStatProvider {

    private final Map<StatType, Double> uniqueBaseValues;
    private final Map<StatType, Double> uniqueRelativeValues;
    private final List<Enchantment> uniqueEnchantments;
    private final UniqueItemType itemType;

    public UniqueItem(UniqueItemDefinition itemDefinition, Map<StatType, Double> baseValues, int level, Map<StatType, Double> uniqueBaseValues, List<Enchantment> uniqueEnchantments){
        super(itemDefinition.itemSlotType(), baseValues, level);
        this.itemType = itemDefinition.itemType();
        this.uniqueBaseValues = uniqueBaseValues;
        this.uniqueRelativeValues = itemDefinition.uniqueRelativeValues();
        this.uniqueEnchantments = uniqueEnchantments;
    }

    @Override
    public ItemType getItemType() {
        return this.itemType;
    }

    public Map<StatType, Double> getUniqueBaseValues() {
        return uniqueBaseValues;
    }

    public Map<StatType, Double> getUniqueRelativeValues() {
        return uniqueRelativeValues;
    }

    public List<Enchantment> getUniqueEnchants() {
        return uniqueEnchantments;
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
                totalStats.computeIfPresent(entry.getKey(), (_, oldVal) -> oldVal * (entry.getValue()+1));
            }
        }

        return totalStats;
    }
}
