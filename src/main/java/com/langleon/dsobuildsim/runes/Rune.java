package com.langleon.dsobuildsim.runes;

import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;

public class Rune extends AbstractRune{
    private final OverallRelativeBuffType type;
    private final Double value;

    public Rune(String name, OverallRelativeBuffType type, Double value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public OverallRelativeBuffType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
