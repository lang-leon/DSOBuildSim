package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;

public class Physic extends AbstractBuff{

    OverallRelativeBuffType type;
    Double value;

    public Physic(String name, OverallRelativeBuffType type, Double value){
        this.name = name;
        this.type =type;
        this.value = value;
    }

    public OverallRelativeBuffType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
