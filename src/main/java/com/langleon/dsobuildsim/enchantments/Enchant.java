package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.enums.EnchantType;
import com.langleon.dsobuildsim.enums.StatType;

public class Enchant {
    private final EnchantType enchantType;
    private final StatType statType;
    private Double value;

    public Enchant(EnchantType enchantType, Double value) {
        this.enchantType = enchantType;
        this.statType = enchantType.getStatType();
        this.value = value;
    }

    public Enchant(EnchantType enchantType) {
        this.enchantType = enchantType;
        this.statType = enchantType.getStatType();
        this.value = enchantType.getMaxValue();
    }

    public EnchantType getEnchantType() {
        return enchantType;
    }

    public StatType getStatType() {
        return statType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        if (value <= this.enchantType.getMaxValue()){
            this.value = value;
        }else{
            this.value = this.enchantType.getMaxValue();
        }
    }

    public void setValue(Double value, boolean overrideMaxValue) {
        if (overrideMaxValue) this.value = value;
    }

    public Enchant copyEnchant()
    {
        return new Enchant(this.enchantType, this.value);
    }

    @Override
    public String toString() {
        return String.format(enchantType.getDescription(), value*100);
    }
}
