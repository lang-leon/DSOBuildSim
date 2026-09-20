package com.langleon.dsobuildsim.collectorbagbonus.dto.definition;

import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagBonusType;
import com.langleon.dsobuildsim.common.StatType;

import java.util.EnumMap;

public record CollectorBagBonusDefinitionDTO(
        CollectorBagBonusType type,
        String name,
        EnumMap<StatType, Double> stats
) {
}
