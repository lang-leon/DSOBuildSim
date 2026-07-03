package com.langleon.dsobuildsim.collectorbagbonus.enums;

public enum CollectorBagBonusType {
    BULWARK_OF_SIX("Bulwark of Six"),
    RESISTANCE_OF_SIX("Resistance of Six"),
    SOULBOUND_POWER_1("Soulbound Power"),
    SOULBOUND_POWER_2("Soulbound Power"),
    STRENGTH_OF_NINE("Strength of Nine"),
    TRIAD_OF_LIFE("Triad of Life"),
    WAVING_OF_FORTUNE("Waving of Fortune"),
    ;

    private final String name;

    CollectorBagBonusType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
