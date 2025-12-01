package com.langleon.dsobuildsim.enums;

public enum CharacterClass {

    DRAGONKNIGHT("Dragonknight"),
    RANGER("Ranger"),
    SPELLWEAVER("Spellweaver"),
    STEAM_MECHANICUS("Steam Mechanicus");

    private final String name;

    CharacterClass(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
