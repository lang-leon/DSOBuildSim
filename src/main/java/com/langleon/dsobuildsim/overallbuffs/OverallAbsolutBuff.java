package com.langleon.dsobuildsim.overallbuffs;

import com.langleon.dsobuildsim.common.StatType;

public class OverallAbsolutBuff extends OverallBuff{

    private final StatType type;
    private final Double value;

    public OverallAbsolutBuff(StatType type, Double value) {
        this.type = type;
        this.value = value;
    }

    public StatType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
