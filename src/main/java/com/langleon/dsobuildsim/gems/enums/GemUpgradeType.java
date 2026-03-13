package com.langleon.dsobuildsim.gems.enums;

public enum GemUpgradeType {
    OFFENSIVE("Offensive"),
    DEFENSIVE("Defensive"),
    OPAL("Opal");

    private final String name;

    GemUpgradeType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
