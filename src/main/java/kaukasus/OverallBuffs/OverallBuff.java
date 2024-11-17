package kaukasus.OverallBuffs;

import kaukasus.Enums.OverallBuffTypeEnum;

public class OverallBuff {

    private final OverallBuffTypeEnum type;
    private final Double value;

    public OverallBuff(OverallBuffTypeEnum type, Double value) {
        this.type = type;
        this.value = value;
    }

    public OverallBuffTypeEnum getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
