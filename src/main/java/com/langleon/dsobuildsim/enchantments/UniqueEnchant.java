package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.enums.EnchantType;

public class UniqueEnchant{
    private EnchantType type;
    private Double value;


    public UniqueEnchant(EnchantType type, Double value){
        this.type = type;
        this.value = value;
    }

    public EnchantType getType() {
        return type;
    }

    public void setType(EnchantType type) {
        this.type = type;
        if (this.value>type.getMaxValue()){
            this.value = type.getMaxValue();
        }
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
