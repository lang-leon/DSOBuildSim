package com.langleon.dsobuildsim.essences;

public enum EssenceType {
    VIGOR("Essence of Vigor"),
    FIREWORK("Essence of Vigor (Firework)"),
    ELEMENTAL_FIRE("Essence of Vigor (Fire)"),
    ELEMENTAL_POISON("Essence of Vigor (Poison)"),
    ELEMENTAL_ICE("Essence of Vigor (Ice)"),
    ELEMENTAL_LIGHTNING("Essence of Vigor (Lightning)"),
    ELEMENTAL_ANDERMAGIC("Essence of Vigor (Andermagic)"),
    LIGHT("Light Essence"),
    LIGHT_LEGACY("Light Essence"),
    COLORFUL("Colorful Essence"),
    CANDYCORN("Candycorn"),
    CARROTCANDY_AMMO("Carrotcandy Ammo"),
    MANGOCANDY_AMMO("Mangocandy Ammo"),
    FRUIT_CANDY("Fruit Candy"),
    SUPERCANDY_AMMO("Supercandy Ammo"),
    ODDCANDY_AMMO("Oddcandy Ammo"),
    SILVER("Silver Essences"),
    SHINING_SILVER("Shining Silver Essences"),
    SNOW("Snow Essence"),
    SPIRIT_SPELLWEAVER("Spirit Essence of the Spellweaver"),
    SPIRIT_DRAGONKNIGHT("Spirit Essence of the Dragonknight"),
    SPIRIT_RANGER("Spirit Essence of the Ranger"),
    SPIRIT_DWARF("Spirit Essence of the Steam Mechanicus"),
    STELLAR_GOLD("Stellar Gold Essence"),
    VITALITY_ABDUCTION("Essence of Vitality Abduction"),
    ANTIDOTAL("Antidotal Essence"),
    ANTIDOTAL_MIGHTY("Mighty Antidotal Essence"),
    BLAZING("Blazing Essence of Vigor")
    ;

    private final String name;

    EssenceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
