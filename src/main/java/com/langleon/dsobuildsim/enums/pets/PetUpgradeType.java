package com.langleon.dsobuildsim.enums.pets;

public enum PetUpgradeType {

    NORMAL("Normal"),
    SILVERCAT("Silver Lucky Cat"),
    GILDEDCAT("Gilded Lucky Cat"),
    NONE("None");
    ;

    private final String name;

    PetUpgradeType(String name) {
        this.name = name;
    }
}
