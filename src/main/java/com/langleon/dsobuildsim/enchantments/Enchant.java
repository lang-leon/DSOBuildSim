package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.enums.EnchantType;

public class Enchant {
    private EnchantType type;
    private Double value;

    public Enchant(EnchantType type, Double value){
        this.type = type;
        if (value <= this.type.getMaxValue()){
            this.value = value;
        }else{
            this.value = this.type.getMaxValue();
        }
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
        if (value <= this.type.getMaxValue()){
            this.value = value;
        }else{
            this.value = this.type.getMaxValue();
        }
    }

    public Enchant copyEnchant()
    {
        return new Enchant(this.type, this.value);
    }

    @Override
    public String toString() {
        return "Enchant{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
