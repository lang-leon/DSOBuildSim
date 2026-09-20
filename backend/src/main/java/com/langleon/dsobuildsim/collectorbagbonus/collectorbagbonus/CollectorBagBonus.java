package com.langleon.dsobuildsim.collectorbagbonus.collectorbagbonus;

import com.langleon.dsobuildsim.collectorbagbonus.enums.CollectorBagBonusType;
import com.langleon.dsobuildsim.common.StatType;

import java.util.EnumMap;

public record CollectorBagBonus(
        CollectorBagBonusType type,
        EnumMap<StatType, Double> stats
) {
}
