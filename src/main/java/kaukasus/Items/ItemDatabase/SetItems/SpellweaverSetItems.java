package kaukasus.Items.ItemDatabase.SetItems;

import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.CharacterClassEnum;
import kaukasus.Enums.ItemTypeEnum;
import kaukasus.Items.ActualItems.SetItem;
import kaukasus.Items.ItemDatabase.Item;
import kaukasus.Sets.SpellweaverSets;

import java.util.Map;

public enum SpellweaverSetItems implements Item {

    HELMET_OF_THE_BLACK_KNIGHT("Helmet of the Black Knight", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE, 1401.911, AbsoluteStatTypeEnum.HEALTH_POINTS, 20637.978), 145),
    SHOULDERS_OF_THE_BLACK_KNIGHT("Shoulders of the Black Knight", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.HEALTH_POINTS, 33014.398), 145),
    CLOAK_OF_THE_BLACK_KNIGHT("Cloak of the Black Knight", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.06, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.200), 145),

    HELMET_OF_THE_END("Helmet of the End", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE, 1401.911, AbsoluteStatTypeEnum.HEALTH_POINTS, 20637.978), 145),
    SHOULDERS_OF_THE_END("Shoulders of the End", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.HEALTH_POINTS, 33014.398), 145),
    CLOAK_OF_THE_END("Cloak of the End", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.06, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.200), 145),

    MIGHTY_WRATHFUL_SEEKERS_HELMET("Mighty Wrathful Seeker's Helmet", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 20185.0, AbsoluteStatTypeEnum.ARMOR, 1068.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 4150.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_SHOULDERS("Mighty Wrathful Seeker's Shoulders", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 16145.0, AbsoluteStatTypeEnum.ICE_RESISTANCE, 4041.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_TORSO("Mighty Wrathful Seeker's Torso", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.ARMOR, 1603.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 6062.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_GLOVES("Mighty Wrathful Seeker's Gloves", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.054, AbsoluteStatTypeEnum.CRIT_VALUE, 1709.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_BOOTS("Mighty Wrathful Seeker's Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_CAPE("Mighty Wrathful Seeker's Cape", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1841.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.059, AbsoluteStatTypeEnum.HEALTH_POINTS, 16145.0), 140),

    SARGONS_HORNS("Sargon's Horns", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE, 1401.991, AbsoluteStatTypeEnum.HEALTH_POINTS, 20637.978), 145),
    SARGONS_PAULDRONS("Sargon's Pauldrons", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.CRIT_VALUE, 1401.991, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 4150.0), 145),
    SARGONS_TORSO("Sargon's Torso", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), 145),

    ARMOR_OF_THE_FLAME_CONQUEROR("Armor of the Flame Conqueror", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.ARMOR, 1603.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 6062.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1549.0), 140),
    GLOVES_OF_THE_FLAME_CONQUEROR("Gloves of the Flame Conqueror", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.054, AbsoluteStatTypeEnum.CRIT_VALUE, 1709.0), 140),
    BOOTS_OF_THE_FLAME_CONQUEROR("Boots of the Flame Conqueror", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0), 140),

    KRANPARUS_ICY_AMULET("Kranparus' Icy Amulet", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 1401.991, AbsoluteStatTypeEnum.ICE_RESISTANCE, 20637.978), 145),
    KRANPARUS_ICY_CONJURING_BOOK("Kranparus' Icy Conjuring Book", ItemTypeEnum.OFF_HAND, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.ATTACK_SPEED, 1401.991, AbsoluteStatTypeEnum.CRIT_VALUE, 4150.0), 145),
    KRANPARUS_ICY_STAFF("Kranparus' Icy Staff", ItemTypeEnum.ONE_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.ATTACK_SPEED, 16507.0), 145),

    AMULET_OF_DEATH("Amulet of Death", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE, 1754.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), 145),
    CAP_OF_DEATH("Cap of Death", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE, 1754.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), 145),

    BLACK_ESSENCE_HELMET("Black Essence Helmet", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 20185.0, AbsoluteStatTypeEnum.ARMOR, 1068.0), 140),
    BLACK_ESSENCE_PAULDRONS("Black Essence Pauldrons", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 16145.0, AbsoluteStatTypeEnum.ARMOR, 1068.0, AbsoluteStatTypeEnum.RESISTANCE, 1131.0), 140),
    BLACK_ESSENCE_ARMOR("Black Essence Armor", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 16145.0, AbsoluteStatTypeEnum.ARMOR, 1603.0), 140),
    BLACK_ESSENCE_GLOVES("Black Essence Gloves", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.054, AbsoluteStatTypeEnum.ARMOR, 1068.0), 140),
    BLACK_ESSENCE_BOOTS("Black Essence Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.HEALTH_POINTS, 16145.0), 140),

    //destructor set
    AUTOMATED_SKULLCAP("Automated Skullcap", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.CRIT_VALUE, 1402.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 20638.0), 145),
    AUTOMATED_SHOULDERGUARDS("Automated Shoulderguards", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), 145),
    AUTOMATED_STERNUM_GUARD("Automated Sternum Guard", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), 145),
    AUTOMATED_ARMGUARDS("Automated Armguards", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 1754.0), 145),
    AUTOMATED_SHINGUARDS("Automated Shinguards", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.221, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0), 145),
    AUTOMATED_BELT("Automated Belt", ItemTypeEnum.BELT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 24761.0, AbsoluteStatTypeEnum.RESISTANCE, 1743.0), 145),
    AUTOMATED_ARKAN_STAFF("Automated Arkan Staff", ItemTypeEnum.TWO_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 6582.0,  AbsoluteStatTypeEnum.CRIT_VALUE, 7012.0), 145),

    //poison extinguisher
    POISON_EXTINGUISHER_HAT("Poison Extinguisher Hat", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.489, AbsoluteStatTypeEnum.HEALTH_POINTS, 20638.0, AbsoluteStatTypeEnum.POISON_RESISTANCE, 4150.0), 145),
    POISON_EXTINGUISHER_GLOVES("Poison Extinguisher Gloves", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 0.489, AbsoluteStatTypeEnum.POISON_RESISTANCE, 4150.0), 145),
    POISON_EXTINGUISHER_BOOTS("Poison Extinguisher Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.221, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.POISON_RESISTANCE, 4150.0), 145),
    ;

    private final String name;
    private final ItemTypeEnum itemType;
    private final Map<AbsoluteStatTypeEnum, Double> baseStats;
    private final CharacterClassEnum characterClass;
    private final int itemLevel;
    private SpellweaverSets set;

    SpellweaverSetItems(String name, ItemTypeEnum itemType, Map<AbsoluteStatTypeEnum, Double> baseStats, int itemLevel) {
        this.characterClass = CharacterClassEnum.SPELLWEAVER;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.itemLevel = itemLevel;
    }

    public SetItem getItem() {
        return new SetItem(this.name, CharacterClassEnum.SPELLWEAVER, this.itemType, this.baseStats, this.itemLevel, this.set);
    }

    public CharacterClassEnum getCharacterClass() {
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
