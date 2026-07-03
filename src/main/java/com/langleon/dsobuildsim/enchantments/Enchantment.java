package com.langleon.dsobuildsim.enchantments;

import com.langleon.dsobuildsim.common.StatType;

import java.util.Objects;

public class Enchantment {
    private final StatType statType;
    private final Double value;

    public Enchantment(StatType statType, Double value) {
        this.statType = statType;
        this.value = value;
    }

    public StatType getStatType() {
        return statType;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Enchantment that = (Enchantment) o;
        return statType == that.statType && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statType, value);
    }
}
