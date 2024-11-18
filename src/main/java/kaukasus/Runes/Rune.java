package kaukasus.Runes;

import kaukasus.Enums.OverallRelativeBuffTypeEnum;

public class Rune extends AbstractRune{
    private final OverallRelativeBuffTypeEnum type;
    private final Double value;

    public Rune(String name, OverallRelativeBuffTypeEnum type, Double value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public OverallRelativeBuffTypeEnum getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
