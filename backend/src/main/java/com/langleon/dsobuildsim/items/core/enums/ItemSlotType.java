package com.langleon.dsobuildsim.items.core.enums;

public enum ItemSlotType {

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
    WEAPON_ADORNMENT("Adornment"),
    SOUL_COMPANION_AMULET("Amulet (Soul Companion)"),
    SOUL_COMPANION_BELT("Belt (Soul Companion)"),
    SOUL_COMPANION_BOOTS("Boots (Soul Companion)"),
    SOUL_COMPANION_CLOAK("Cloak (Soul Companion)"),
    SOUL_COMPANION_GLOVES("Gloves (Soul Companion)"),
    SOUL_COMPANION_HELMET("Helmet (Soul Companion)"),
    SOUL_COMPANION_RING("Ring (Soul Companion)"),
    SOUL_COMPANION_SHOULDERS("Shoulders (Soul Companion)"),
    SOUL_COMPANION_TORSO("Torso (Soul Companion)");

    private final String name;

    ItemSlotType(String description){
        this.name = description;
    }

    public String getName() {
        return name;
    }
}
