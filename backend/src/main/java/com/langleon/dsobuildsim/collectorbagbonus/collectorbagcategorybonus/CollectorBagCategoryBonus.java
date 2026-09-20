package com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus;

import com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus.CollectorBagBonus;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.common.StatType;

import java.util.EnumMap;
import java.util.List;

public record CollectorBagCategoryBonus(
        CollectorBagCategory category,
        List<CollectorBagBonus> collectorBagBonuses
) {
    public EnumMap<StatType, Double> calculateStats()
    {
        EnumMap<StatType, Double> stats = new EnumMap<>(StatType.class);
        collectorBagBonuses.forEach((bonus) -> bonus.stats().forEach(((k, v) -> stats.merge(k, v, Double::sum))));
        return stats;
    }
}
