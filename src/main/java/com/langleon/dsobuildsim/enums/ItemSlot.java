package com.langleon.dsobuildsim.enums;

public enum ItemSlot {

    AMULET("Amulet", ItemSlotType.AMULET),
    BELT("Belt", ItemSlotType.BELT),
    BOOTS("Boots", ItemSlotType.BOOTS),
    CLOAK("Cloak", ItemSlotType.CLOAK),
    GLOVES("Gloves", ItemSlotType.GLOVES),
    HELMET("Helmet", ItemSlotType.HELMET),
    ONE_HAND_WEAPON("Main Hand", ItemSlotType.ONE_HAND_WEAPON),
    OFF_HAND("Off Hand", ItemSlotType.OFF_HAND),
    RING1("Ring 1", ItemSlotType.RING),
    RING2("Ring 2", ItemSlotType.RING),
    SHOULDERS("Shoulders", ItemSlotType.SHOULDERS),
    TORSO("Torso", ItemSlotType.TORSO),
    TWO_HAND_WEAPON("Two Hand Weapon", ItemSlotType.TWO_HAND_WEAPON),
    WEAPON_ADORNMENT("Adornment", ItemSlotType.WEAPON_ADORNMENT),
    SOUL_COMPANION_AMULET("Amulet (Soul Companion)", ItemSlotType.SOUL_COMPANION_AMULET),
    SOUL_COMPANION_BELT("Belt (Soul Companion)", ItemSlotType.SOUL_COMPANION_BELT),
    SOUL_COMPANION_BOOTS("Boots (Soul Companion)", ItemSlotType.SOUL_COMPANION_BOOTS),
    SOUL_COMPANION_CLOAK("Cloak (Soul Companion)", ItemSlotType.SOUL_COMPANION_CLOAK),
    SOUL_COMPANION_GLOVES("Gloves (Soul Companion)", ItemSlotType.SOUL_COMPANION_GLOVES),
    SOUL_COMPANION_HELMET("Helmet (Soul Companion)", ItemSlotType.SOUL_COMPANION_HELMET),
    SOUL_COMPANION_RING1("Ring 1 (Soul Companion)", ItemSlotType.SOUL_COMPANION_RING),
    SOUL_COMPANION_RING2("Ring 2 (Soul Companion)", ItemSlotType.SOUL_COMPANION_RING),
    SOUL_COMPANION_SHOULDERS("Shoulders (Soul Companion)", ItemSlotType.SOUL_COMPANION_SHOULDERS),
    SOUL_COMPANION_TORSO("Torso (Soul Companion)", ItemSlotType.SOUL_COMPANION_TORSO);

    private final String name;
    private final ItemSlotType allowedItemType;

    ItemSlot(String name, ItemSlotType allowedItemType) {
        this.name = name;
        this.allowedItemType = allowedItemType;
    }

    public String getName() {
        return name;
    }

    public ItemSlotType getAllowedItemType() {
        return allowedItemType;
    }

    @Override
    public String toString() {
        return name;
    }
}
