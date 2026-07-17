package com.langleon.dsobuildsim.collectorbagbonus.dto.instance;

import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagCategory;
import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagTier;

public record CollectorBagCategoryBonusInstanceDTO(
        CollectorBagCategory category,
        CollectorBagTier tier
) {
}
