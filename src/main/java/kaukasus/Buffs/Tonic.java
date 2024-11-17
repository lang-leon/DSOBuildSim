package kaukasus.Buffs;

import kaukasus.Enums.AbsoluteStatTypeEnum;

public class Tonic extends AbstractBuff{

    AbsoluteStatTypeEnum type;
    Double value;

    public Tonic(String name, AbsoluteStatTypeEnum type, Double value){
        this.name = name;
        this.type =type;
        this.value = value;
    }

    public AbsoluteStatTypeEnum getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
