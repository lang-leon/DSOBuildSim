package com.langleon.dsobuildsim.enums;

public enum RuneType {
    VIGOR("Rune of Vigor", RuneUpgradeType.OFFENSIVE),
    DEVASTATION("Rune of Devastation", RuneUpgradeType.OFFENSIVE),
    CELERITY("Rune of Celerity", RuneUpgradeType.OFFENSIVE),
    ACCELERATION("Rune of Acceleration", RuneUpgradeType.OFFENSIVE),
    EFFICACY("Rune of Efficacy", RuneUpgradeType.OFFENSIVE),
    RECHARGING("Rune of Recharging", RuneUpgradeType.OFFENSIVE),
    SPRING("Concentrated Spring Rune", RuneUpgradeType.OFFENSIVE),
    SUMMER("Concentrated Summer Rune", RuneUpgradeType.OFFENSIVE),
    AUTUMN("Concentrated Autumn Rune", RuneUpgradeType.OFFENSIVE),
    WINTER("Concentrated Solstice Rune", RuneUpgradeType.OFFENSIVE),
    VITALITY("Rune of Vitality", RuneUpgradeType.DEFENSIVE),
    REGENERATION("Rune of Regeneration", RuneUpgradeType.DEFENSIVE),
    FORTITUDE("Rune of Fortitude", RuneUpgradeType.DEFENSIVE),
    RESILIENCE("Rune of Resilience", RuneUpgradeType.DEFENSIVE),
    FIRE_RESILIENCE("Rune of Fire Resilience", RuneUpgradeType.DEFENSIVE),
    ICE_RESILIENCE("Rune of Ice Resilience", RuneUpgradeType.DEFENSIVE),
    POISON_RESILIENCE("Rune of Poison Resilience", RuneUpgradeType.DEFENSIVE),
    LIGHTNING_RESILIENCE("Rune of Lightning Resilience", RuneUpgradeType.DEFENSIVE),
    ANDERMAGIC_RESILIENCE("Rune of Andermagic Resilience", RuneUpgradeType.DEFENSIVE),
    PERSISTENCE("Rune of Persistence", RuneUpgradeType.DEFENSIVE),
    ANDERMANT_FEVER("Rune of Andermant Fever", RuneUpgradeType.GROUP),
    GOLD_FEVER("Rune of the Gold Fever", RuneUpgradeType.GROUP),
    REALM_CHANGER("Rune of the Realm Changer", RuneUpgradeType.GROUP),
    ANXIETY_KEEPER("Rune of the Anxiety Keeper", RuneUpgradeType.GROUP),
    SCHOLAR("Rune of the Scholar", RuneUpgradeType.GROUP),
    EXPERIENCE_HUNTER("Rune of the Experience Hunter", RuneUpgradeType.GROUP),
    INSIGHT("Rune of Insight", RuneUpgradeType.BASIC),
    MATERI_BLESSING("Rune of Materi Blessing", RuneUpgradeType.BASIC),
    WISDOM_SEEKER("Rune of the Wisdom Seeker", RuneUpgradeType.BASIC),
    RISING_VIGOR("Rune of Rising Vigor", RuneUpgradeType.NONE),
    RISING_POWER("Rune of the Rising Power", RuneUpgradeType.NONE),
    HOLY_STAR_SHARD("Holy Star Shard Rune", RuneUpgradeType.NONE),
    ;

    private final String name;
    private final RuneUpgradeType runeUpgradeType;

    RuneType(String name, RuneUpgradeType runeUpgradeType) {
        this.name = name;
        this.runeUpgradeType = runeUpgradeType;
    }

    public RuneUpgradeType getRuneUpgradeType() {
        return runeUpgradeType;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
