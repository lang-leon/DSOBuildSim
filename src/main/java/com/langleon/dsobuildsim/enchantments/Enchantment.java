package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.enums.EnchantmentType;
import com.langleon.dsobuildsim.enums.StatType;

import java.util.Objects;

public class Enchantment {
    private final EnchantmentType enchantType;
    private final StatType statType;
    private Double value;

    public Enchantment(EnchantmentType enchantType, Double value) {
        this.enchantType = enchantType;
        this.statType = enchantType.getStatType();
        this.value = value;
    }

    public Enchantment(EnchantmentType enchantType) {
        this.enchantType = enchantType;
        this.statType = enchantType.getStatType();
        this.value = enchantType.getMaxValue();
    }

    public EnchantmentType getEnchantType() {
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

    public void setValueOverride(Double value, boolean overrideMaxValue) {
        if (overrideMaxValue) this.value = value;
    }

    public void setMaxValue()
    {
        this.value = this.enchantType.getMaxValue();
    }

    public Enchantment copyEnchant()
    {
        return new Enchantment(this.enchantType, this.value);
    }

    @Override
    public String toString() {
        return String.format(enchantType.getDescription(), value*100);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Enchantment that = (Enchantment) o;
        return enchantType == that.enchantType && statType == that.statType && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enchantType, statType, value);
    }
}
