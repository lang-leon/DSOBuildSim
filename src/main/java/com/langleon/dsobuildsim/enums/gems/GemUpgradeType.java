package com.langleon.dsobuildsim.enums.gems;

public enum GemUpgradeType {
    OFFENSIVE("Offensive"),
    DEFENSIVE("Defensive"),
    OPAL("Opal");

    private final String name;

    GemUpgradeType(String name){
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
