package com.langleon.dsobuildsim.gems.enums;

public enum GemType {
    RUBY("Ruby"),
    ONYX("Onyx"),
    ZIRCON("Zircon"),
    RHODOLITE("Rhodolite"),
    AMETHYST("Amethyst"),
    CYANITE("Cyanite"),
    DIAMOND("Diamond"),
    FIRE_DIAMOND("Diamond (Fire)"),
    POISON_DIAMOND("Diamond (Poison)"),
    ICE_DIAMOND("Diamond (Ice)"),
    LIGHTNING_DIAMOND("Diamond (Lightning)"),
    ANDERMAGIC_DIAMOND("Diamond (Andermagic)"),
    EMERALD("Emerald"),
    OPAL("Opal");

    private final String name;

    GemType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
