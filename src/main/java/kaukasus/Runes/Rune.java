package kaukasus.Runes;

import kaukasus.Enums.OverallBuffTypeEnum;

public class Rune extends AbstractRune{
    private final OverallBuffTypeEnum type;
    private final Double value;

    public Rune(String name, OverallBuffTypeEnum type, Double value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public OverallBuffTypeEnum getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }
}
