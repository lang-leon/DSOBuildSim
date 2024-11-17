package kaukasus.OverallBuffs;

import kaukasus.Enums.OverallBuffTypeEnum;

public class OverallRelativeBuff extends OverallBuff{

    private final OverallBuffTypeEnum type;
    private final Double value;

    public OverallRelativeBuff(OverallBuffTypeEnum type, Double value) {
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
