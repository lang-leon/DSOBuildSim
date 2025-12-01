package com.langleon.dsobuildsim.enums;

public enum ItemType {

    AMULET("Amulet"),
    BELT("Belt"),
    BOOTS("Boots"),
    CLOAK("Cloak"),
    GLOVES("Gloves"),
    HELMET("Helmet"),
    ONE_HAND_WEAPON("Main Hand"),
    OFF_HAND("Off Hand"),
    RING("Ring"),
    SHOULDERS("Shoulders"),
    TORSO("Torso"),
    TWO_HAND_WEAPON("Two Hand Weapon"),
    WEAPON_ADORNMENT("Adornment");


    private final String description;

    ItemType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
