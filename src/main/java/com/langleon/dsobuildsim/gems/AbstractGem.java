package com.langleon.dsobuildsim.gems;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;

import java.util.Objects;

public abstract class AbstractGem {

    protected AbsoluteStatType type;
    protected Double value;

    public AbsoluteStatType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public abstract AbstractGem copyGem();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractGem that = (AbstractGem) o;
        return type == that.type && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}
