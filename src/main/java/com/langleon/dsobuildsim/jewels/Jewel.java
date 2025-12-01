package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.enums.OverallRelativeBuffType;

import java.util.Objects;

public class Jewel {

    private final String name;
    private final String description;
    private OverallRelativeBuffType type;
    private Double value;

    public Jewel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Jewel(String name, OverallRelativeBuffType type, Double value) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.description = "";
    }

    public Jewel(String name, OverallRelativeBuffType type, Double value, String description) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public OverallRelativeBuffType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jewel jewel = (Jewel) o;
        return Objects.equals(name, jewel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
