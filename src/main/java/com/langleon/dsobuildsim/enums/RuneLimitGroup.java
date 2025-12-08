package com.langleon.dsobuildsim.enums;

public enum RuneLimitGroup {
    VIGOR(5),
    DEVASTATION(5),
    CELERITY(5),
    ACCELERATION(5),
    EFFICACY(5),
    RECHARGING(5),
    SPRING(5),
    SUMMER(5),
    AUTUMN(5),
    WINTER(5),
    VITALITY(5),
    REGENERATION(5),
    FORTITUDE(5),
    RESILIENCE(5),
    PERSISTENCE(5),
    ANDERMANT_FEVER(1),
    GOLD_FEVER(1),
    REALM_CHANGER(1),
    ANXIETY_KEEPER(1),
    SCHOLAR(1),
    EXPERIENCE_HUNTER(5),
    INSIGHT(5),
    MATERI_BLESSING(5),
    WISDOM_SEEKER(5),
    PARAGON(1),
    VARNOK(1);

    private final int limit;

    RuneLimitGroup(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
