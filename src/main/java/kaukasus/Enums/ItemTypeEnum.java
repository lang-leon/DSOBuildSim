package kaukasus.Enums;

public enum ItemTypeEnum {

    AMULET("Amulet"),
    BELT("Belt"),
    BOOTS("Boots"),
    CLOAK("Cloak"),
    GLOVES("Gloves"),
    HELMET("Helmet"),
    MAIN_HAND("Main Hand"),
    OFF_HAND("Off Hand"),
    RING("Ring"),
    SHOULDERS("Shoulders"),
    TORSO("Torso"),
    TWO_HAND_WEAPON("Two Hand Weapon"),
    WEAPON_ADORNMENT("Adornment");


    private final String description;

    ItemTypeEnum(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
