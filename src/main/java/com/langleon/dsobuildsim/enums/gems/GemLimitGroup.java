package com.langleon.dsobuildsim.enums.gems;

public enum GemLimitGroup {
    RUBY(50),
    ONYX(30),
    ZIRCON(30),
    RHODOLITE(30),
    AMETHYST(50),
    CYANITE(50),
    DIAMOND(50),
    EMERALD(30),
    OPAL(10);

    private final int limit;

    GemLimitGroup(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
