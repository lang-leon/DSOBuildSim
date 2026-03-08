package com.langleon.dsobuildsim.pets.enums;

public enum PetUpgradeType {

    NORMAL("Normal"),
    SILVERCAT("Silvered Lucky Cat"),
    GILDEDCAT("Gilded Lucky Cat"),
    NONE("None");
    ;

    private final String name;

    PetUpgradeType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
