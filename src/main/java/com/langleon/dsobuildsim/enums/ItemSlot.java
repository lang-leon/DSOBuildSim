package com.langleon.dsobuildsim.enums;

public enum ItemSlot {

    AMULET("Amulet"),
    BELT("Belt"),
    BOOTS("Boots"),
    CLOAK("Cloak"),
    GLOVES("Gloves"),
    HELMET("Helmet"),
    ONE_HAND_WEAPON("Main Hand"),
    OFF_HAND("Off Hand"),
    RING1("Ring 1"),
    RING2("Ring 2"),
    SHOULDERS("Shoulders"),
    TORSO("Torso"),
    TWO_HAND_WEAPON("Two Hand Weapon"),
    WEAPON_ADORNMENT("Adornment");


    private final String description;

    ItemSlot(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
