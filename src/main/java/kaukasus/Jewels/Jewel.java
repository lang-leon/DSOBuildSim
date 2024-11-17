package kaukasus.Jewels;

import kaukasus.Enums.OverallBuffTypeEnum;

public class Jewel {

    private final String name;
    private final String description;
    private OverallBuffTypeEnum type;
    private Double value;

    public Jewel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Jewel(String name, OverallBuffTypeEnum type, Double value) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.description = "";
    }

    public Jewel(String name, OverallBuffTypeEnum type, Double value, String description) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public OverallBuffTypeEnum getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
