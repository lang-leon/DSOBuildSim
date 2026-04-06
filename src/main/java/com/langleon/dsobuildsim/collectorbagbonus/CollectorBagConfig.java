package com.langleon.dsobuildsim.collectorbagbonus;

import com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus.CollectorBagBonusDefinition;
import com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus.CollectorBagCategoryBonusDefinition;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagBonusType;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;

import java.util.EnumMap;

public record CollectorBagConfig(
        EnumMap<CollectorBagBonusType, CollectorBagBonusDefinition> bonuses,
        EnumMap<CollectorBagCategory, CollectorBagCategoryBonusDefinition> categoryBonuses
) {
}
