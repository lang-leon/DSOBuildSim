package com.langleon.dsobuildsim.items.itemdatabase.setitems;

import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.items.setitems.SetItem;
import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.sets.SpellweaverSets;

import java.util.Map;

public enum SpellweaverSetItems implements Item {

    HELMET_OF_THE_BLACK_KNIGHT("Helmet of the Black Knight", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1401.911, StatType.HEALTH_POINTS, 20637.978), 145),
    SHOULDERS_OF_THE_BLACK_KNIGHT("Shoulders of the Black Knight", ItemSlotType.SHOULDERS, Map.of(StatType.DAMAGE, 1891.513, StatType.HEALTH_POINTS, 33014.398), 145),
    CLOAK_OF_THE_BLACK_KNIGHT("Cloak of the Black Knight", ItemSlotType.CLOAK, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.06, StatType.HEALTH_POINTS, 16507.200), 145),

    HELMET_OF_THE_END("Helmet of the End", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1401.911, StatType.HEALTH_POINTS, 20637.978), 145),
    SHOULDERS_OF_THE_END("Shoulders of the End", ItemSlotType.SHOULDERS, Map.of(StatType.DAMAGE, 1891.513, StatType.HEALTH_POINTS, 33014.398), 145),
    CLOAK_OF_THE_END("Cloak of the End", ItemSlotType.CLOAK, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.06, StatType.HEALTH_POINTS, 16507.200), 145),

    MIGHTY_WRATHFUL_SEEKERS_HELMET("Mighty Wrathful Seeker's Helmet", ItemSlotType.HELMET, Map.of(StatType.HEALTH_POINTS, 20185.0, StatType.ARMOR_VALUE, 1068.0, StatType.FIRE_RESISTANCE, 4150.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_SHOULDERS("Mighty Wrathful Seeker's Shoulders", ItemSlotType.SHOULDERS, Map.of(StatType.HEALTH_POINTS, 16145.0, StatType.ICE_RESISTANCE, 4041.0, StatType.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_TORSO("Mighty Wrathful Seeker's Torso", ItemSlotType.TORSO, Map.of(StatType.ARMOR_VALUE, 1603.0, StatType.ANDERMAGIC_RESISTANCE, 6062.0, StatType.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_GLOVES("Mighty Wrathful Seeker's Gloves", ItemSlotType.GLOVES, Map.of(StatType.DAMAGE, 1601.0, StatType.ATTACK_SPEED, 0.054, StatType.CRIT_VALUE, 1709.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_BOOTS("Mighty Wrathful Seeker's Boots", ItemSlotType.BOOTS, Map.of(StatType.DAMAGE, 1601.0, StatType.MOVEMENT_SPEED, 1.208, StatType.CRIT_VALUE, 1366.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_CAPE("Mighty Wrathful Seeker's Cape", ItemSlotType.CLOAK, Map.of(StatType.DAMAGE, 1841.0, StatType.ATTACK_SPEED, 0.059, StatType.HEALTH_POINTS, 16145.0), 140),

    SARGONS_HORNS("Sargon's Horns", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1401.991, StatType.HEALTH_POINTS, 20637.978), 145),
    SARGONS_PAULDRONS("Sargon's Pauldrons", ItemSlotType.SHOULDERS, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 1401.991, StatType.ANDERMAGIC_RESISTANCE, 4150.0), 145),
    SARGONS_TORSO("Sargon's Torso", ItemSlotType.TORSO, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1648.0), 145),

    ARMOR_OF_THE_FLAME_CONQUEROR("Armor of the Flame Conqueror", ItemSlotType.TORSO, Map.of(StatType.ARMOR_VALUE, 1603.0, StatType.ANDERMAGIC_RESISTANCE, 6062.0, StatType.BLOCK_VALUE, 1549.0), 140),
    GLOVES_OF_THE_FLAME_CONQUEROR("Gloves of the Flame Conqueror", ItemSlotType.GLOVES, Map.of(StatType.DAMAGE, 1601.0, StatType.ATTACK_SPEED, 0.054, StatType.CRIT_VALUE, 1709.0), 140),
    BOOTS_OF_THE_FLAME_CONQUEROR("Boots of the Flame Conqueror", ItemSlotType.BOOTS, Map.of(StatType.DAMAGE, 1601.0, StatType.MOVEMENT_SPEED, 1.208, StatType.CRIT_VALUE, 1366.0), 140),

    KRANPARUS_ICY_AMULET("Kranparus' Icy Amulet", ItemSlotType.AMULET, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 1401.991, StatType.ICE_RESISTANCE, 20637.978), 145),
    KRANPARUS_ICY_CONJURING_BOOK("Kranparus' Icy Conjuring Book", ItemSlotType.OFF_HAND, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 1401.991, StatType.CRIT_VALUE, 4150.0), 145),
    KRANPARUS_ICY_STAFF("Kranparus' Icy Staff", ItemSlotType.ONE_HAND_WEAPON, Map.of(StatType.DAMAGE, 1644.883, StatType.ATTACK_SPEED, 16507.0), 145),

    AMULET_OF_DEATH("Amulet of Death", ItemSlotType.AMULET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1754.0, StatType.RESISTANCE_VALUE, 1162.0), 145),
    CAP_OF_DEATH("Cap of Death", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1754.0, StatType.RESISTANCE_VALUE, 1162.0), 145),

    BLACK_ESSENCE_HELMET("Black Essence Helmet", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1601.0, StatType.HEALTH_POINTS, 20185.0, StatType.ARMOR_VALUE, 1068.0), 140),
    BLACK_ESSENCE_PAULDRONS("Black Essence Pauldrons", ItemSlotType.SHOULDERS, Map.of(StatType.HEALTH_POINTS, 16145.0, StatType.ARMOR_VALUE, 1068.0, StatType.RESISTANCE_VALUE, 1131.0), 140),
    BLACK_ESSENCE_ARMOR("Black Essence Armor", ItemSlotType.TORSO, Map.of(StatType.DAMAGE, 1601.0, StatType.HEALTH_POINTS, 16145.0, StatType.ARMOR_VALUE, 1603.0), 140),
    BLACK_ESSENCE_GLOVES("Black Essence Gloves", ItemSlotType.GLOVES, Map.of(StatType.DAMAGE, 1601.0, StatType.ATTACK_SPEED, 0.054, StatType.ARMOR_VALUE, 1068.0), 140),
    BLACK_ESSENCE_BOOTS("Black Essence Boots", ItemSlotType.BOOTS, Map.of(StatType.DAMAGE, 1601.0, StatType.MOVEMENT_SPEED, 1.208, StatType.HEALTH_POINTS, 16145.0), 140),

    //destructor set
    AUTOMATED_SKULLCAP("Automated Skullcap", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1645.0, StatType.CRIT_VALUE, 1402.0, StatType.HEALTH_POINTS, 20638.0), 145),
    AUTOMATED_SHOULDERGUARDS("Automated Shoulderguards", ItemSlotType.SHOULDERS, Map.of(StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1098.0, StatType.RESISTANCE_VALUE, 1162.0), 145),
    AUTOMATED_STERNUM_GUARD("Automated Sternum Guard", ItemSlotType.TORSO, Map.of(StatType.DAMAGE, 1645.0, StatType.HEALTH_POINTS, 16507.0, StatType.ARMOR_VALUE, 1648.0), 145),
    AUTOMATED_ARMGUARDS("Automated Armguards", ItemSlotType.GLOVES, Map.of(StatType.DAMAGE, 1645.0, StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 1754.0), 145),
    AUTOMATED_SHINGUARDS("Automated Shinguards", ItemSlotType.BOOTS, Map.of(StatType.DAMAGE, 1645.0, StatType.MOVEMENT_SPEED, 1.221, StatType.HEALTH_POINTS, 16507.0), 145),
    AUTOMATED_BELT("Automated Belt", ItemSlotType.BELT, Map.of(StatType.DAMAGE, 1645.0, StatType.HEALTH_POINTS, 24761.0, StatType.RESISTANCE_VALUE, 1743.0), 145),
    AUTOMATED_ARKAN_STAFF("Automated Arkan Staff", ItemSlotType.TWO_HAND_WEAPON, Map.of(StatType.DAMAGE, 6582.0,  StatType.CRIT_VALUE, 7012.0), 145),

    //poison extinguisher
    POISON_EXTINGUISHER_HAT("Poison Extinguisher Hat", ItemSlotType.HELMET, Map.of(StatType.MOVEMENT_SPEED, 0.489, StatType.HEALTH_POINTS, 20638.0, StatType.POISON_RESISTANCE, 4150.0), 145),
    POISON_EXTINGUISHER_GLOVES("Poison Extinguisher Gloves", ItemSlotType.GLOVES, Map.of(StatType.ATTACK_SPEED, 0.055, StatType.MOVEMENT_SPEED, 0.489, StatType.POISON_RESISTANCE, 4150.0), 145),
    POISON_EXTINGUISHER_BOOTS("Poison Extinguisher Boots", ItemSlotType.BOOTS, Map.of(StatType.MOVEMENT_SPEED, 1.221, StatType.HEALTH_POINTS, 16507.0, StatType.POISON_RESISTANCE, 4150.0), 145),
    ;

    private final String name;
    private final ItemSlotType itemSlotType;
    private final Map<StatType, Double> baseStats;
    private final CharacterClass characterClass;
    private final int itemLevel;
    private SpellweaverSets set;

    SpellweaverSetItems(String name, ItemSlotType itemSlotType, Map<StatType, Double> baseStats, int itemLevel) {
        this.characterClass = CharacterClass.SPELLWEAVER;
        this.name = name;
        this.itemSlotType = itemSlotType;
        this.baseStats = baseStats;
        this.itemLevel = itemLevel;
    }

    public SetItem getItem() {
        return new SetItem(this.name, CharacterClass.SPELLWEAVER, this.itemSlotType, this.baseStats, this.itemLevel, this.set);
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
