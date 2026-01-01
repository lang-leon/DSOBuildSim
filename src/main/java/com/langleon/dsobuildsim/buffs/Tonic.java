package com.langleon.dsobuildsim.buffs;

import com.langleon.dsobuildsim.enums.StatType;

public class Tonic extends AbstractBuff{

    StatType type;
    Double value;

    public Tonic(String name, StatType type, Double value){
        this.name = name;
        this.type =type;
        this.value = value;
    }

    public StatType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
