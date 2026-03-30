package com.langleon.dsobuildsim.collectorbagbonus.dto.definition;

import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;

import java.util.List;


public record CollectorBagCategoryBonusDefinitionDTO(
        CollectorBagCategory category,
        String name,
        List<CollectorBagBonusDefinitionDTO> bonuses
) {
}
