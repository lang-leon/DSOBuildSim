package com.langleon.dsobuildsim.items.itemdatabase.setitems;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemType;
import com.langleon.dsobuildsim.items.actualitems.SetItem;
import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.sets.SpellweaverSets;

import java.util.Map;

public enum SpellweaverSetItems implements Item {

    HELMET_OF_THE_BLACK_KNIGHT("Helmet of the Black Knight", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.CRIT_VALUE, 1401.911, AbsoluteStatType.HEALTH_POINTS, 20637.978), 145),
    SHOULDERS_OF_THE_BLACK_KNIGHT("Shoulders of the Black Knight", ItemType.SHOULDERS, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.HEALTH_POINTS, 33014.398), 145),
    CLOAK_OF_THE_BLACK_KNIGHT("Cloak of the Black Knight", ItemType.CLOAK, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.ATTACK_SPEED, 0.06, AbsoluteStatType.HEALTH_POINTS, 16507.200), 145),

    HELMET_OF_THE_END("Helmet of the End", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.CRIT_VALUE, 1401.911, AbsoluteStatType.HEALTH_POINTS, 20637.978), 145),
    SHOULDERS_OF_THE_END("Shoulders of the End", ItemType.SHOULDERS, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.HEALTH_POINTS, 33014.398), 145),
    CLOAK_OF_THE_END("Cloak of the End", ItemType.CLOAK, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.ATTACK_SPEED, 0.06, AbsoluteStatType.HEALTH_POINTS, 16507.200), 145),

    MIGHTY_WRATHFUL_SEEKERS_HELMET("Mighty Wrathful Seeker's Helmet", ItemType.HELMET, Map.of(AbsoluteStatType.HEALTH_POINTS, 20185.0, AbsoluteStatType.ARMOR_VALUE, 1068.0, AbsoluteStatType.FIRE_RESISTANCE, 4150.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_SHOULDERS("Mighty Wrathful Seeker's Shoulders", ItemType.SHOULDERS, Map.of(AbsoluteStatType.HEALTH_POINTS, 16145.0, AbsoluteStatType.ICE_RESISTANCE, 4041.0, AbsoluteStatType.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_TORSO("Mighty Wrathful Seeker's Torso", ItemType.TORSO, Map.of(AbsoluteStatType.ARMOR_VALUE, 1603.0, AbsoluteStatType.ANDERMAGIC_RESISTANCE, 6062.0, AbsoluteStatType.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_GLOVES("Mighty Wrathful Seeker's Gloves", ItemType.GLOVES, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.ATTACK_SPEED, 0.054, AbsoluteStatType.CRIT_VALUE, 1709.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_BOOTS("Mighty Wrathful Seeker's Boots", ItemType.BOOTS, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.MOVEMENT_SPEED, 1.208, AbsoluteStatType.CRIT_VALUE, 1366.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_CAPE("Mighty Wrathful Seeker's Cape", ItemType.CLOAK, Map.of(AbsoluteStatType.DAMAGE, 1841.0, AbsoluteStatType.ATTACK_SPEED, 0.059, AbsoluteStatType.HEALTH_POINTS, 16145.0), 140),

    SARGONS_HORNS("Sargon's Horns", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.CRIT_VALUE, 1401.991, AbsoluteStatType.HEALTH_POINTS, 20637.978), 145),
    SARGONS_PAULDRONS("Sargon's Pauldrons", ItemType.SHOULDERS, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.CRIT_VALUE, 1401.991, AbsoluteStatType.ANDERMAGIC_RESISTANCE, 4150.0), 145),
    SARGONS_TORSO("Sargon's Torso", ItemType.TORSO, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.HEALTH_POINTS, 16507.0, AbsoluteStatType.ARMOR_VALUE, 1648.0), 145),

    ARMOR_OF_THE_FLAME_CONQUEROR("Armor of the Flame Conqueror", ItemType.TORSO, Map.of(AbsoluteStatType.ARMOR_VALUE, 1603.0, AbsoluteStatType.ANDERMAGIC_RESISTANCE, 6062.0, AbsoluteStatType.BLOCK_VALUE, 1549.0), 140),
    GLOVES_OF_THE_FLAME_CONQUEROR("Gloves of the Flame Conqueror", ItemType.GLOVES, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.ATTACK_SPEED, 0.054, AbsoluteStatType.CRIT_VALUE, 1709.0), 140),
    BOOTS_OF_THE_FLAME_CONQUEROR("Boots of the Flame Conqueror", ItemType.BOOTS, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.MOVEMENT_SPEED, 1.208, AbsoluteStatType.CRIT_VALUE, 1366.0), 140),

    KRANPARUS_ICY_AMULET("Kranparus' Icy Amulet", ItemType.AMULET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.HEALTH_POINTS, 1401.991, AbsoluteStatType.ICE_RESISTANCE, 20637.978), 145),
    KRANPARUS_ICY_CONJURING_BOOK("Kranparus' Icy Conjuring Book", ItemType.OFF_HAND, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.ATTACK_SPEED, 1401.991, AbsoluteStatType.CRIT_VALUE, 4150.0), 145),
    KRANPARUS_ICY_STAFF("Kranparus' Icy Staff", ItemType.ONE_HAND_WEAPON, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.ATTACK_SPEED, 16507.0), 145),

    AMULET_OF_DEATH("Amulet of Death", ItemType.AMULET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.CRIT_VALUE, 1754.0, AbsoluteStatType.RESISTANCE_VALUE, 1162.0), 145),
    CAP_OF_DEATH("Cap of Death", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.CRIT_VALUE, 1754.0, AbsoluteStatType.RESISTANCE_VALUE, 1162.0), 145),

    BLACK_ESSENCE_HELMET("Black Essence Helmet", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.HEALTH_POINTS, 20185.0, AbsoluteStatType.ARMOR_VALUE, 1068.0), 140),
    BLACK_ESSENCE_PAULDRONS("Black Essence Pauldrons", ItemType.SHOULDERS, Map.of(AbsoluteStatType.HEALTH_POINTS, 16145.0, AbsoluteStatType.ARMOR_VALUE, 1068.0, AbsoluteStatType.RESISTANCE_VALUE, 1131.0), 140),
    BLACK_ESSENCE_ARMOR("Black Essence Armor", ItemType.TORSO, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.HEALTH_POINTS, 16145.0, AbsoluteStatType.ARMOR_VALUE, 1603.0), 140),
    BLACK_ESSENCE_GLOVES("Black Essence Gloves", ItemType.GLOVES, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.ATTACK_SPEED, 0.054, AbsoluteStatType.ARMOR_VALUE, 1068.0), 140),
    BLACK_ESSENCE_BOOTS("Black Essence Boots", ItemType.BOOTS, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.MOVEMENT_SPEED, 1.208, AbsoluteStatType.HEALTH_POINTS, 16145.0), 140),

    //destructor set
    AUTOMATED_SKULLCAP("Automated Skullcap", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.CRIT_VALUE, 1402.0, AbsoluteStatType.HEALTH_POINTS, 20638.0), 145),
    AUTOMATED_SHOULDERGUARDS("Automated Shoulderguards", ItemType.SHOULDERS, Map.of(AbsoluteStatType.HEALTH_POINTS, 16507.0, AbsoluteStatType.ARMOR_VALUE, 1098.0, AbsoluteStatType.RESISTANCE_VALUE, 1162.0), 145),
    AUTOMATED_STERNUM_GUARD("Automated Sternum Guard", ItemType.TORSO, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.HEALTH_POINTS, 16507.0, AbsoluteStatType.ARMOR_VALUE, 1648.0), 145),
    AUTOMATED_ARMGUARDS("Automated Armguards", ItemType.GLOVES, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.ATTACK_SPEED, 0.055, AbsoluteStatType.CRIT_VALUE, 1754.0), 145),
    AUTOMATED_SHINGUARDS("Automated Shinguards", ItemType.BOOTS, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.MOVEMENT_SPEED, 1.221, AbsoluteStatType.HEALTH_POINTS, 16507.0), 145),
    AUTOMATED_BELT("Automated Belt", ItemType.BELT, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.HEALTH_POINTS, 24761.0, AbsoluteStatType.RESISTANCE_VALUE, 1743.0), 145),
    AUTOMATED_ARKAN_STAFF("Automated Arkan Staff", ItemType.TWO_HAND_WEAPON, Map.of(AbsoluteStatType.DAMAGE, 6582.0,  AbsoluteStatType.CRIT_VALUE, 7012.0), 145),

    //poison extinguisher
    POISON_EXTINGUISHER_HAT("Poison Extinguisher Hat", ItemType.HELMET, Map.of(AbsoluteStatType.MOVEMENT_SPEED, 0.489, AbsoluteStatType.HEALTH_POINTS, 20638.0, AbsoluteStatType.POISON_RESISTANCE, 4150.0), 145),
    POISON_EXTINGUISHER_GLOVES("Poison Extinguisher Gloves", ItemType.GLOVES, Map.of(AbsoluteStatType.ATTACK_SPEED, 0.055, AbsoluteStatType.MOVEMENT_SPEED, 0.489, AbsoluteStatType.POISON_RESISTANCE, 4150.0), 145),
    POISON_EXTINGUISHER_BOOTS("Poison Extinguisher Boots", ItemType.BOOTS, Map.of(AbsoluteStatType.MOVEMENT_SPEED, 1.221, AbsoluteStatType.HEALTH_POINTS, 16507.0, AbsoluteStatType.POISON_RESISTANCE, 4150.0), 145),
    ;

    private final String name;
    private final ItemType itemType;
    private final Map<AbsoluteStatType, Double> baseStats;
    private final CharacterClass characterClass;
    private final int itemLevel;
    private SpellweaverSets set;

    SpellweaverSetItems(String name, ItemType itemType, Map<AbsoluteStatType, Double> baseStats, int itemLevel) {
        this.characterClass = CharacterClass.SPELLWEAVER;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.itemLevel = itemLevel;
    }

    public SetItem getItem() {
        return new SetItem(this.name, CharacterClass.SPELLWEAVER, this.itemType, this.baseStats, this.itemLevel, this.set);
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    static
    {
        HELMET_OF_THE_BLACK_KNIGHT.set = SpellweaverSets.BLACK_WARLORD_REGALIA;
        SHOULDERS_OF_THE_BLACK_KNIGHT.set = SpellweaverSets.BLACK_WARLORD_REGALIA;
        CLOAK_OF_THE_BLACK_KNIGHT.set = SpellweaverSets.BLACK_WARLORD_REGALIA;
        HELMET_OF_THE_END.set = SpellweaverSets.END_OF_THE_EMPIRE;
        SHOULDERS_OF_THE_END.set = SpellweaverSets.END_OF_THE_EMPIRE;
        CLOAK_OF_THE_END.set = SpellweaverSets.END_OF_THE_EMPIRE;
        MIGHTY_WRATHFUL_SEEKERS_HELMET.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_SHOULDERS.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_TORSO.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_GLOVES.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_BOOTS.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_CAPE.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        SARGONS_HORNS.set = SpellweaverSets.SARGONS_IMMORTAL_TERROR_ARMOR;
        SARGONS_PAULDRONS.set = SpellweaverSets.SARGONS_IMMORTAL_TERROR_ARMOR;
        SARGONS_TORSO.set = SpellweaverSets.SARGONS_IMMORTAL_TERROR_ARMOR;
        ARMOR_OF_THE_FLAME_CONQUEROR.set = SpellweaverSets.ENRAGED_EMPORER;
        GLOVES_OF_THE_FLAME_CONQUEROR.set = SpellweaverSets.ENRAGED_EMPORER;
        BOOTS_OF_THE_FLAME_CONQUEROR.set = SpellweaverSets.ENRAGED_EMPORER;
        KRANPARUS_ICY_AMULET.set = SpellweaverSets.KRANPARUS_TREASURES;
        KRANPARUS_ICY_CONJURING_BOOK.set = SpellweaverSets.KRANPARUS_TREASURES;
        KRANPARUS_ICY_STAFF.set = SpellweaverSets.KRANPARUS_TREASURES;
        AMULET_OF_DEATH.set = SpellweaverSets.AT_DEATHS_DOOR;
        CAP_OF_DEATH.set = SpellweaverSets.AT_DEATHS_DOOR;
        BLACK_ESSENCE_HELMET.set = SpellweaverSets.BLACK_ESSENCE_ARMAMENT;
        BLACK_ESSENCE_PAULDRONS.set = SpellweaverSets.BLACK_ESSENCE_ARMAMENT;
        BLACK_ESSENCE_ARMOR.set = SpellweaverSets.BLACK_ESSENCE_ARMAMENT;
        BLACK_ESSENCE_GLOVES.set = SpellweaverSets.BLACK_ESSENCE_ARMAMENT;
        BLACK_ESSENCE_BOOTS.set = SpellweaverSets.BLACK_ESSENCE_ARMAMENT;
        AUTOMATED_SKULLCAP.set = SpellweaverSets.AUTOMATED_UNIT;
        AUTOMATED_SHOULDERGUARDS.set = SpellweaverSets.AUTOMATED_UNIT;
        AUTOMATED_STERNUM_GUARD.set = SpellweaverSets.AUTOMATED_UNIT;
        AUTOMATED_ARMGUARDS.set = SpellweaverSets.AUTOMATED_UNIT;
        AUTOMATED_SHINGUARDS.set = SpellweaverSets.AUTOMATED_UNIT;
        AUTOMATED_BELT.set = SpellweaverSets.AUTOMATED_UNIT;
        AUTOMATED_ARKAN_STAFF.set = SpellweaverSets.AUTOMATED_UNIT;
        POISON_EXTINGUISHER_HAT.set = SpellweaverSets.POISON_EXTINGUISHER;
        POISON_EXTINGUISHER_GLOVES.set = SpellweaverSets.POISON_EXTINGUISHER;
        POISON_EXTINGUISHER_BOOTS.set = SpellweaverSets.POISON_EXTINGUISHER;
    }
}
