package com.langleon.dsobuildsim.dragonstones;

public enum DragonStoneType {
    GREEDSTONE("Greedstone"),
    POWERSTONE("Powerstone"),
    SLOTHSTONE("Soulstone"),
    TRANQUIL_STONE("Tranquil Stone"),
    FURYSTONE("Furystone"),
    RESTLESS_STONE("Restless Stone"),
    FERVORSTONE("Fervorstone"),
    TIMESTONE("Timestone")
    ;

    private final String name;

    DragonStoneType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
