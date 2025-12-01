package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;

public class Tonic extends AbstractBuff{

    AbsoluteStatType type;
    Double value;

    public Tonic(String name, AbsoluteStatType type, Double value){
        this.name = name;
        this.type =type;
        this.value = value;
    }

    public AbsoluteStatType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
