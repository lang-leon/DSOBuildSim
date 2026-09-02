package com.langleon.dsobuildsim.jewels;

public enum JewelType {

    AMBIDEXTROUS_VIGOR(JewelLimitGroup.AMBIDEXTROUS_VIGOR),
    AMPLIFIED_HEALING(JewelLimitGroup.AMPLIFIED_HEALING),
    ANDER_POWER(JewelLimitGroup.ANDER_POWER),
    BLACK_KNIGHT_ORDER(JewelLimitGroup.BLACK_KNIGHT_ORDER),
    CONTRIBUTION(JewelLimitGroup.CONTRIBUTION),
    CONVERSE(JewelLimitGroup.CONVERSE),
    DEXTROUS_VIGOR(JewelLimitGroup.DEXTROUS_VIGOR),
    EASTER_FEVER(JewelLimitGroup.EASTER_FEVER),
    ENCOURAGEMENT(JewelLimitGroup.ENCOURAGEMENT),
    ETERNAL_SCORN(JewelLimitGroup.ETERNAL_SCORN),
    ETERNAL_WRATH(JewelLimitGroup.ETERNAL_WRATH),
    FLOWER(JewelLimitGroup.FLOWER),
    FOCUS(JewelLimitGroup.FOCUS),
    FORTITUDE(JewelLimitGroup.FORTITUDE),
    FROZEN_HEART(JewelLimitGroup.FROZEN_HEART),
    GEM_FORTUNE(JewelLimitGroup.GEM_FORTUNE),
    GHOST_POWER(JewelLimitGroup.GHOST_POWER),
    GLACIAL_FANG(JewelLimitGroup.GLACIAL_FANG),
    GLORY(JewelLimitGroup.GLORY),
    INGREDIENT_HUNTER(JewelLimitGroup.INGREDIENT_HUNTER),
    LASTING_HEALTH(JewelLimitGroup.LASTING_HEALTH),
    PENT_UP_POWER(JewelLimitGroup.PENT_UP_POWER),
    POISONOUS_THORNS(JewelLimitGroup.POISONOUS_THORNS),
    PROLONGATION(JewelLimitGroup.PROLONGATION),
    RAGE(JewelLimitGroup.RAGE),
    RELENTLESSNESS(JewelLimitGroup.RELENTLESSNESS),
    REVIVAL_BOON(JewelLimitGroup.REVIVAL_BOON),
    SCORCHING_RAY(JewelLimitGroup.SCORCHING_RAY),
    STRENUOUSNESS(JewelLimitGroup.STRENUOUSNESS),
    SWIFTNESS(JewelLimitGroup.SWIFTNESS),
    VANQUISHER(JewelLimitGroup.VANQUISHER),
    VIGOR(JewelLimitGroup.VIGOR),
    VITALITY(JewelLimitGroup.VITALITY);

    private final JewelLimitGroup limitGroup;

    JewelType(JewelLimitGroup limitGroup) {
        this.limitGroup = limitGroup;
    }

    public JewelLimitGroup getLimitGroup() {
        return limitGroup;
    }
}
