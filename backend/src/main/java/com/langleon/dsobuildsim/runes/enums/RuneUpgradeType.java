package com.langleon.dsobuildsim.runes.enums;

public enum RuneUpgradeType {
    OFFENSIVE("Offensive"),
    DEFENSIVE("Defensive"),
    GROUP("Group"),
    BASIC("Basic"),
    NONE("Can't be upgraded");

    private final String name;

    RuneUpgradeType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
