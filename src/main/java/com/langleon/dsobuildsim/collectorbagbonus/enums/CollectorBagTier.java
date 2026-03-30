package com.langleon.dsobuildsim.collectorbagbonus.enums;

public enum CollectorBagTier {
    TIER0(0),
    TIER1(1),
    TIER2(2),
    TIER3(3);

    private final int tier;

    CollectorBagTier(int tier) {
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }
}
