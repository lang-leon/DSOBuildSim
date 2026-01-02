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


    private final String name;

    ItemType(String description){
        this.name = description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
