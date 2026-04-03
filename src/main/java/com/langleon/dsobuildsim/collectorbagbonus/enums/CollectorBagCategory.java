package com.langleon.dsobuildsim.collectorbagbonus.enums;

public enum CollectorBagCategory {
    DRAGON_SPAWN("Dragon Spawn"),
    SCOUNDRELS("Scoundrels"),
    DOMESTICATED("Domesticated"),
    WILD_BEASTS("Wild Beasts"),
    AQUATICS("Aquatics"),
    AVIANS("Avians"),
    TAMED_FOES("Tamed Foes"),
    FREE_SPIRITS("Free Spirits"),
    AUTOMATONS("Automatons"),
    LUCKY_CATS("Lucky Cats"),
    ENIGMATIC_HATCHLINGS("Enigmatic Hatchlings"),
    AWOKEN_LION("Awoken Lion"),
    ANCIENT_DRAGONS("Ancient Dragons"),
    ALCHEMY_CIRCLES("Alchemy Circles"),
    SHADOW_SOULS("Shadow Souls");

    private final String name;

    CollectorBagCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
