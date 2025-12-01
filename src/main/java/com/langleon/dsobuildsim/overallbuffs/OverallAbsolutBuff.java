package com.langleon.dsobuildsim.overallbuffs;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;

public class OverallAbsolutBuff extends OverallBuff{

    private final AbsoluteStatType type;
    private final Double value;

    public OverallAbsolutBuff(AbsoluteStatType type, Double value) {
        this.type = type;
        this.value = value;
    }

    public AbsoluteStatType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
