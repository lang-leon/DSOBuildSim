package kaukasus.Enchants;

import kaukasus.Enums.EnchantTypeEnum;

public class UniqueEnchant{
    private EnchantTypeEnum type;
    private Double value;


    public UniqueEnchant(EnchantTypeEnum type, Double value){
        this.type = type;
        this.value = value;
    }

    public EnchantTypeEnum getType() {
        return type;
    }

    public void setType(EnchantTypeEnum type) {
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
