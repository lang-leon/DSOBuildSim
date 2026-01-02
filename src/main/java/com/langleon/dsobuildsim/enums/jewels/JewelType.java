package com.langleon.dsobuildsim.enums.jewels;

public enum JewelType {

    AMBIDEXTROUS_VIGOR("Jewel of Ambidextrous Vigor", 1),
    AMPLIFIED_HEALING("Jewel of Amplified Healing", 1),
    ANDER_POWER("Jewel of Ander Power", 1),
    BLACK_KNIGHT_ORDER("Jewel of the Black Knight Order", 1),
    CONTRIBUTION("Jewel of Contribution", 1),
    CONVERSE("Jewel of Converse", 1),
    DEXTROUS_VIGOR("Jewel of Dextrous Vigor", 1),
    EASTER_FEVER("Jewel of the Easter Fever", 1),
    ENCOURAGEMENT("Jewel of Encouragement", 1),
    ETERNAL_SCORN("Jewel of Eternal Scorn", 1),
    ETERNAL_WRATH("Jewel of the Eternal Wrath", 1),
    FIERY_FLOWER("Fiery Flower Jewel", 1),
    FOCUS("Jewel of Focus", 5),
    FORTITUDE("Jewel of Fortitude", 1),
    FROZEN_HEART("Jewel of the Frozen Heart", 1),
    GEM_FORTUNE("Jewel of Gem Fortune", 1),
    GHOST_POWER("Jewel of Ghost Power", 3),
    GLACIAL_FANG("Jewel of Glacial Fang", 1),
    INGREDIENT_HUNTER("Jewel of the Ingredient Hunter", 3),
    LASTING_HEALTH("Jewel of Lasting Health", 1),
    PENT_UP_POWER("Jewel of Pent-up Power", 1),
    POISONOUS_THORNS("Jewel of Poisonous Thorns", 1),
    PROLONGATION("Jewel of Prolongation", 1),
    RAGE("Jewel of Rage", 1),
    RELENTLESSNESS("Jewel of Relentlessness", 5),
    REVIVAL_BOON("Jewel of Revival Boon", 1),
    SCORCHING_RAY("Jewel of Scorching Ray", 1),
    STRENUOUSNESS("Jewel of Strenuousness", 1),
    SWIFTNESS("Jewel of Swiftness", 1),
    THUNDERING_FLOWER("Thundering Flower Jewel", 1),
    VANQUISHER("Jewel of the Vanquisher", 1),
    VIGOR("Jewel of Vigor", 1),
    VITALITY("Jewel of Vitality", 1);

    private final String name;
    private final int limit;

    JewelType(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return name;
    }
}
