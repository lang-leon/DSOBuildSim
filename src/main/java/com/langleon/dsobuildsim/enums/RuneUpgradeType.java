package com.langleon.dsobuildsim.enums;

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

    public String toString() {
        return name;
    }

}
