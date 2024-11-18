package kaukasus.OverallBuffs;

import kaukasus.Enums.OverallRelativeBuffTypeEnum;

public class OverallRelativeBuff extends OverallBuff{

    private final OverallRelativeBuffTypeEnum type;
    private final Double value;

    public OverallRelativeBuff(OverallRelativeBuffTypeEnum type, Double value) {
        this.type = type;
        this.value = value;
    }

    public OverallRelativeBuffTypeEnum getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
