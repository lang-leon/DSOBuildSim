package com.langleon.dsobuildsim.enums;

public enum RuneType {
    VIGOR("Rune of Vigor"),
    DEVASTATION("Rune of Devastation"),
    CELERITY("Rune of Celerity"),
    ACCELERATION("Rune of Acceleration"),
    EFFICACY("Rune of Efficacy"),
    RECHARGING("Rune of Recharging"),
    SPRING("Concentrated Spring Rune"),
    SUMMER("Concentrated Summer Rune"),
    AUTUMN("Concentrated Autumn Rune"),
    WINTER("Concentrated Solstice Rune"),
    VITALITY("Rune of Vitality"),
    REGENERATION("Rune of Regeneration"),
    FORTITUDE("Rune of Fortitude"),
    RESILIENCE("Rune of Resilience"),
    FIRE_RESILIENCE("Rune of Fire Resilience"),
    ICE_RESILIENCE("Rune of Ice Resilience"),
    POISON_RESILIENCE("Rune of Poison Resilience"),
    LIGHTNING_RESILIENCE("Rune of Lightning Resilience"),
    ANDERMAGIC_RESILIENCE("Rune of Andermagic Resilience"),
    PERSISTENCE("Rune of Persistence"),
    ANDERMANT_FEVER("Rune of Andermant Fever"),
    GOLD_FEVER("Rune of the Gold Fever"),
    REALM_CHANGER("Rune of the Realm Changer"),
    ANXIETY_KEEPER("Rune of the Anxiety Keeper"),
    SCHOLAR("Rune of the Scholar"),
    EXPERIENCE_HUNTER("Rune of the Experience Hunter"),
    INSIGHT("Rune of Insight"),
    MATERI_BLESSING("Rune of Materi Blessing"),
    WISDOM_SEEKER("Rune of the Wisdom Seeker"),
    RISING_VIGOR("Rune of Rising Vigor"),
    RISING_POWER("Rune of the Rising Power"),
    HOLY_STAR_SHARD("Holy Star Shard Rune"),
    ;

    private final String name;

    RuneType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
