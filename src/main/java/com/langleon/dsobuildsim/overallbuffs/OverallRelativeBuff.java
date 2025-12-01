package com.langleon.dsobuildsim.overallbuffs;

import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;

public class OverallRelativeBuff extends OverallBuff{

    private final OverallRelativeBuffType type;
    private final Double value;

    public OverallRelativeBuff(OverallRelativeBuffType type, Double value) {
        this.type = type;
        this.value = value;
    }

    public OverallRelativeBuffType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
