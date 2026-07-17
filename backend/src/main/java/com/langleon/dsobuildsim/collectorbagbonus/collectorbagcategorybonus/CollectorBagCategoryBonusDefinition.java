package com.langleon.dsobuildsim.collectorbagbonus.collectorbagcategorybonus;

import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagBonusType;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;

import java.util.List;

public record CollectorBagCategoryBonusDefinition(
        CollectorBagCategory category,
        List<CollectorBagBonusType> bonuses) {
}
