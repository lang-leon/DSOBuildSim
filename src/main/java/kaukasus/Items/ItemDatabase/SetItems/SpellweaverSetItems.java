package kaukasus.Items.ItemDatabase.SetItems;

import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.CharacterClassEnum;
import kaukasus.Enums.ItemTypeEnum;
import kaukasus.Items.ActualItems.SetItem;
import kaukasus.Items.ItemDatabase.Item;
import kaukasus.Sets.SpellweaverSets;

import java.util.Map;

public enum SpellweaverSetItems implements Item {

    MIGHTY_WRATHFUL_SEEKERS_HELMET("Mighty Wrathful Seeker's Helmet", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 20185.0, AbsoluteStatTypeEnum.ARMOR, 1068.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 4150.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_SHOULDERS("Mighty Wrathful Seeker's Shoulders", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 16145.0, AbsoluteStatTypeEnum.ICE_RESISTANCE, 4041.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_TORSO("Mighty Wrathful Seeker's Torso", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.ARMOR, 1603.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 6062.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_GLOVES("Mighty Wrathful Seeker's Gloves", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.054, AbsoluteStatTypeEnum.CRIT_VALUE, 1709.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_BOOTS("Mighty Wrathful Seeker's Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_CAPE("Mighty Wrathful Seeker's Cape", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1841.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.059, AbsoluteStatTypeEnum.HEALTH_POINTS, 16145.0), 140),
    SARGONS_HORNS("Sargon's Horns", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE, 1401.991, AbsoluteStatTypeEnum.HEALTH_POINTS, 20637.978), 145),
    SARGONS_PAULDRONS("Sargon's Pauldrons", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.CRIT_VALUE, 1401.991, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 4150.0), 145),
    SARGONS_TORSO("Sargon's Torso", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 16507.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), 145),
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
        MIGHTY_WRATHFUL_SEEKERS_HELMET.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_SHOULDERS.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_TORSO.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_GLOVES.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_BOOTS.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_CAPE.set = SpellweaverSets.MIGHTY_VISIONARY_SEEKER;
        SARGONS_HORNS.set = SpellweaverSets.SARGONS_IMMORTAL_TERROR_ARMOR;
        SARGONS_PAULDRONS.set = SpellweaverSets.SARGONS_IMMORTAL_TERROR_ARMOR;
        SARGONS_TORSO.set = SpellweaverSets.SARGONS_IMMORTAL_TERROR_ARMOR;
    }
}
