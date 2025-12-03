package com.langleon.dsobuildsim.enums;

public enum GemType {
    RUBY("Ruby", GemUpgradeType.OFFENSIVE),
    ONYX("Onyx", GemUpgradeType.OFFENSIVE),
    ZIRCON("Zircon", GemUpgradeType.OFFENSIVE),
    RHODOLITE("Rhodolite", GemUpgradeType.OFFENSIVE),
    AMETHYST("Amethyst", GemUpgradeType.DEFENSIVE),
    CYANITE("Cyanite", GemUpgradeType.DEFENSIVE),
    DIAMOND("Diamond", GemUpgradeType.DEFENSIVE),
    FIRE_DIAMOND("Diamond (Fire)", GemUpgradeType.DEFENSIVE),
    POISON_DIAMOND("Diamond (Poison)", GemUpgradeType.DEFENSIVE),
    ICE_DIAMOND("Diamond (Ice)", GemUpgradeType.DEFENSIVE),
    LIGHTNING_DIAMOND("Diamond (Lightning)", GemUpgradeType.DEFENSIVE),
    ANDERMAGIC_DIAMOND("Diamond (Andermagic)", GemUpgradeType.DEFENSIVE),
    EMERALD("Emerald", GemUpgradeType.DEFENSIVE),
    OPAL("Opal", GemUpgradeType.OPAL);

    private final String name;
    private final GemUpgradeType gemUpgradeType;

    GemType(String name, GemUpgradeType gemUpgradeType) {
        this.name = name;
        this.gemUpgradeType = gemUpgradeType;
    }

    public GemUpgradeType getGemUpgradeType() {
        return gemUpgradeType;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
