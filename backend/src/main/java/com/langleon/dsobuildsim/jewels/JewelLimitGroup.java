package com.langleon.dsobuildsim.jewels;

public enum JewelLimitGroup {

    AMBIDEXTROUS_VIGOR(1),
    AMPLIFIED_HEALING(1),
    ANDER_POWER(1),
    BLACK_KNIGHT_ORDER(1),
    CONTRIBUTION(1),
    CONVERSE(1),
    DEXTROUS_VIGOR(1),
    EASTER_FEVER(1),
    ENCOURAGEMENT(1),
    ETERNAL_SCORN(1),
    ETERNAL_WRATH(1),
    FLOWER(1),
    FOCUS(5),
    FORTITUDE(1),
    FROZEN_HEART(1),
    GEM_FORTUNE(1),
    GHOST_POWER(3),
    GLACIAL_FANG(1),
    GLORY(1),
    INGREDIENT_HUNTER(3),
    LASTING_HEALTH(1),
    PENT_UP_POWER(1),
    POISONOUS_THORNS(1),
    PROLONGATION(1),
    RAGE(1),
    RELENTLESSNESS(5),
    REVIVAL_BOON(1),
    SCORCHING_RAY(1),
    STRENUOUSNESS(1),
    SWIFTNESS(1),
    VANQUISHER(1),
    VIGOR(1),
    VITALITY(1);

    private final int limit;

    JewelLimitGroup(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
