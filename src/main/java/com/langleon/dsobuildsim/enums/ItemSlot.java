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
    WEAPON_ADORNMENT("Adornment", ItemSlotType.WEAPON_ADORNMENT);


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
