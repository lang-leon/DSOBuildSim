package com.langleon.dsobuildsim.enums.dragonstones;

public enum DragonStoneType {
    GREEDSTONE_HATCHLING("Dragon Hatchling's Greedstone"),
    GREEDSTONE_MIGTHY("Mighty Dragon's Greedstone"),
    GREEDSTONE_ELDERS("Dragon Elder's Greedstone"),

    POWERSTONE_HATCHLING("Dragon Hatchling's Powerstone"),
    POWERSTONE_MIGTHY("Mighty Dragon's Powerstone"),
    POWERSTONE_ELDERS("Dragon Elder's Powersone"),

    SLOTHSTONE_HATCHLING("Dragon Hatchling's Slothstone"),
    SLOTHSTONE_MIGTHY("Mighty Dragon's Slothstone"),
    SLOTHSTONE_ELDERS("Dragon Elder's Slothstone"),

    TRANQUIL_STONE_HATCHLING("Dragon Hatchling's Tranquil Stone"),
    TRANQUIL_STONE_MIGTHY("Mighty Dragon's Tranquil Stone"),
    TRANQUIL_STONE_ELDERS("Dragon Elder's Tranquil Stone"),

    FURYSTONE_HATCHLING("Dragon Hatchling's Furystone"),
    FURYSTONE_MIGTHY("Mighty Dragon's Furystone"),
    FURYSTONE_ELDERS("Dragon Elder's Furystone"),

    RESTLESS_STONE_HATCHLING("Dragon Hatchling's Restless Stone"),
    RESTLESS_STONE_MIGTHY("Mighty Dragon's Restless Stone"),
    RESTLESS_STONE_ELDERS("Dragon Elder's Restless Stone"),

    FERVORSTONE_HATCHLING("Dragon Hatchling's Fervorstone"),
    FERVORSTONE_MIGTHY("Mighty Dragon's Fervorstone"),
    FERVORSTONE_ELDERS("Dragon Elder's Fervorstone"),

    TIMESTONE_HATCHLING("Dragon Hatchling's Timestone"),
    TIMESTONE_MIGTHY("Mighty Dragon's Timestone"),
    TIMESTONE_ELDERS("Dragon Elder's Timestone"),
    ;

    private final String name;

    DragonStoneType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
