package com.langleon.dsobuildsim.collectorbagbonus.dto.instance;

import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;

public record CollectorBagCategoryBonusInstanceDTO(
        CollectorBagCategory category,
        int tier
) {
}
