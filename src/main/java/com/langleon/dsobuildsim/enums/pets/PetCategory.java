package com.langleon.dsobuildsim.enums.pets;

public enum PetCategory {
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
    ANCIENT_DRAGONS("Ancient Dragons");

    private final String name;

    PetCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
