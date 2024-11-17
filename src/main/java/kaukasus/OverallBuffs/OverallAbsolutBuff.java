package kaukasus.OverallBuffs;

import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.OverallBuffTypeEnum;

public class OverallAbsolutBuff extends OverallBuff{

    private final AbsoluteStatTypeEnum type;
    private final Double value;

    public OverallAbsolutBuff(AbsoluteStatTypeEnum type, Double value) {
        this.type = type;
        this.value = value;
    }

    public AbsoluteStatTypeEnum getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
