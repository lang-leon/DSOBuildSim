package kaukasus.Items.ItemDatabase.SetItems;

import kaukasus.Enums.AbsoluteStatTypeEnum;
import kaukasus.Enums.CharacterClassEnum;
import kaukasus.Enums.ItemTypeEnum;
import kaukasus.Items.ActualItems.SetItem;
import kaukasus.Items.ItemDatabase.Item;
import kaukasus.Sets.DragonknightSets;

import java.util.List;
import java.util.Map;

public enum DragonknightSetItems implements Item {

    //dragan set
    HELMET_OF_THE_BLACK_KNIGHT("Helmet of the Black Knight",ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883,AbsoluteStatTypeEnum.CRIT_VALUE, 1401.911,AbsoluteStatTypeEnum.HEALTH_POINTS, 61913.936), 145),
    SHOULDERS_OF_THE_BLACK_KNIGHT("Shoulders of the Black Knight", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.HEALTH_POINTS, 99043.192), 145),
    CLOAK_OF_THE_BLACK_KNIGHT("Cloak of the Black Knight", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.06, AbsoluteStatTypeEnum.HEALTH_POINTS, 49521.596), 145),

    //mighty wrathful seeker set
    MIGHTY_WRATHFUL_SEEKERS_HELMET("Mighty Wrathful Seeker's Helmet", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 60555.0, AbsoluteStatTypeEnum.ARMOR, 1068.0, AbsoluteStatTypeEnum.FIRE_RESISTANCE, 4150.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_SHOULDERS("Mighty Wrathful Seeker's Shoulders", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 48435.0, AbsoluteStatTypeEnum.ICE_RESISTANCE, 4041.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_TORSO("Mighty Wrathful Seeker's Torso", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.ARMOR, 1603.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 6062.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_GLOVES("Mighty Wrathful Seeker's Gloves", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.054, AbsoluteStatTypeEnum.CRIT_VALUE, 1709.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_BOOTS("Mighty Wrathful Seeker's Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_CAPE("Mighty Wrathful Seeker's Cape", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1841.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.059, AbsoluteStatTypeEnum.HEALTH_POINTS, 48435.0), 140),

    //mortis set
    HELMET_OF_DEATH("Helmet of Death", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.CRIT_VALUE, 1754.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), 145),
    SEAL_OF_DEATH("Seal of Death", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.CRIT_VALUE, 1402.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), 145),

    ;

    private final String name;
    private final ItemTypeEnum itemType;
    private final Map<AbsoluteStatTypeEnum, Double> baseStats;
    private final CharacterClassEnum characterClass;
    private final int itemLevel;
    private DragonknightSets set;

    DragonknightSetItems(String name, ItemTypeEnum itemType, Map<AbsoluteStatTypeEnum, Double> baseStats, int itemLevel) {
        this.characterClass = CharacterClassEnum.DRAGONKNIGHT;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.itemLevel = itemLevel;
    }

    public SetItem getItem() {
        return new SetItem(this.name, CharacterClassEnum.DRAGONKNIGHT, this.itemType, this.baseStats, this.itemLevel, this.set);
    }

    public CharacterClassEnum getCharacterClass() {
        return characterClass;
    }

    static
    {
        HELMET_OF_THE_BLACK_KNIGHT.set = DragonknightSets.BLACK_WARLORD_REGALIA;
        SHOULDERS_OF_THE_BLACK_KNIGHT.set = DragonknightSets.BLACK_WARLORD_REGALIA;
        CLOAK_OF_THE_BLACK_KNIGHT.set = DragonknightSets.BLACK_WARLORD_REGALIA;

        MIGHTY_WRATHFUL_SEEKERS_HELMET.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_SHOULDERS.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_TORSO.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_GLOVES.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_BOOTS.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_CAPE.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;

        HELMET_OF_DEATH.set = DragonknightSets.AT_DEATHS_DOOR;
        SEAL_OF_DEATH.set = DragonknightSets.AT_DEATHS_DOOR;
    }
}
