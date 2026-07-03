package com.langleon.dsobuildsim.items.mythicitems;

import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.enchantments.Enchantment;
import com.langleon.dsobuildsim.gems.AbstractGem;
import com.langleon.dsobuildsim.items.core.enums.ItemType;
import com.langleon.dsobuildsim.sets.SetType;
import com.langleon.dsobuildsim.items.core.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class MythicItem extends Item implements SetBonusProvider, UniqueStatProvider {
    private final Map<StatType, Double> uniqueRelativeValues;
    private final Map<StatType, Double> uniqueAbsoluteValues;
    private final SetType setType;
    private final MythicItemType itemType;

    public MythicItem(MythicItemDefinition itemDefinition, Map<StatType, Double> baseValues, int level, List<AbstractGem> gems, List<Enchantment> enchantments){
        super(itemDefinition.itemSlotType(), baseValues, level, gems, enchantments);
        this.uniqueRelativeValues = itemDefinition.uniqueRelativeValues();
        this.uniqueAbsoluteValues = itemDefinition.uniqueAbsoluteValues();
        this.itemType = itemDefinition.itemType();
        this.setType = itemDefinition.set();
    }

    @Override
    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public SetType getSetType() {
        return setType;
    }

    @Override
    public String getSetItemIdentifier() {
        return this.itemType.toString();
    }

    public Map<StatType, Double> getUniqueRelativeValues() {
        return uniqueRelativeValues;
    }

    public Map<StatType, Double> getUniqueAbsoluteValues() {
        return uniqueAbsoluteValues;
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

        //calculate stats with unique absolute values applied
        for (Map.Entry<StatType, Double> entry : uniqueAbsoluteValues.entrySet())
        {
            totalStats.merge(entry.getKey(), entry.getValue(), Double::sum);
        }

        return totalStats;
    }
}

