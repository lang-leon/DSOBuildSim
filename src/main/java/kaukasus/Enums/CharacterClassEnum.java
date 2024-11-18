package kaukasus.Enums;

public enum CharacterClassEnum {

    DRAGONKNIGHT("Dragonknight"),
    RANGER("Ranger"),
    SPELLWEAVER("Spellweaver"),
    STEAM_MECHANICUS("Steam Mechanicus");

    private final String name;

    CharacterClassEnum(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
