package kaukasus.Buffs;

import kaukasus.Enums.OverallBuffTypeEnum;

public class Physic extends AbstractBuff{

    OverallBuffTypeEnum type;
    Double value;

    public Physic(String name, OverallBuffTypeEnum type, Double value){
        this.name = name;
        this.type =type;
        this.value = value;
    }

    public OverallBuffTypeEnum getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
