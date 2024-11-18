package kaukasus.Buffs;

import kaukasus.Enums.OverallRelativeBuffTypeEnum;

public class Physic extends AbstractBuff{

    OverallRelativeBuffTypeEnum type;
    Double value;

    public Physic(String name, OverallRelativeBuffTypeEnum type, Double value){
        this.name = name;
        this.type =type;
        this.value = value;
    }

    public OverallRelativeBuffTypeEnum getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
