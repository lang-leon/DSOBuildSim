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

    HELMET_OF_THE_END("Helmet of the End",ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883,AbsoluteStatTypeEnum.CRIT_VALUE, 1401.911,AbsoluteStatTypeEnum.HEALTH_POINTS, 61913.936), 145),
    SHOULDERS_OF_THE_END("Shoulders of the End", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.HEALTH_POINTS, 99043.192), 145),
    CLOAK_OF_THE_END("Cloak of the End", ItemTypeEnum.CLOAK, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.06, AbsoluteStatTypeEnum.HEALTH_POINTS, 49521.596), 145),

    //maze of blaze set
    ARMOR_OF_THE_FLAME_CONQUEROR("Armor of the Flame Conqueror", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.ARMOR, 1603.0, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 6062.0, AbsoluteStatTypeEnum.BLOCK_VALUE, 1549.0), 140),
    GLOVES_OF_THE_FLAME_CONQUEROR("Gloves of the Flame Conqueror", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.054, AbsoluteStatTypeEnum.CRIT_VALUE, 1709.0), 140),
    BOOTS_OF_THE_FLAME_CONQUEROR("Boots of the Flame Conqueror", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1601.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.208, AbsoluteStatTypeEnum.CRIT_VALUE, 1366.0), 140),

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

    //sargon set
    SARGONS_HORNS("Sargon's Horns", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.CRIT_VALUE, 1401.991, AbsoluteStatTypeEnum.HEALTH_POINTS, 61914.0), 145),
    SARGONS_PAULDRONS("Sargon's Pauldrons", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1891.513, AbsoluteStatTypeEnum.CRIT_VALUE, 1401.991, AbsoluteStatTypeEnum.ANDERMAGIC_RESISTANCE, 4150.0), 145),
    SARGONS_TORSO("Sargon's Torso", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 49522.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), 145),

    //destructor set
    MACHINE_HELMET("Machine Helmet", ItemTypeEnum.HELMET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.CRIT_VALUE, 1402.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 61914.0), 145),
    MACHINE_SHOULDERS("Machine Shoulders", ItemTypeEnum.SHOULDERS, Map.of(AbsoluteStatTypeEnum.HEALTH_POINTS, 49522.0, AbsoluteStatTypeEnum.ARMOR, 1098.0, AbsoluteStatTypeEnum.RESISTANCE, 1162.0), 145),
    MACHINE_ARMOR("Machine Armor", ItemTypeEnum.TORSO, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 49522.0, AbsoluteStatTypeEnum.ARMOR, 1648.0), 145),
    MACHINE_FISTS("Machine Fists", ItemTypeEnum.GLOVES, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.055, AbsoluteStatTypeEnum.CRIT_VALUE, 1754.0), 145),
    MACHINE_BOOTS("Machine Boots", ItemTypeEnum.BOOTS, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.MOVEMENT_SPEED, 1.221, AbsoluteStatTypeEnum.HEALTH_POINTS, 49522.0), 145),
    MACHINE_BELT("Machine Belt", ItemTypeEnum.BELT, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1645.0, AbsoluteStatTypeEnum.HEALTH_POINTS, 74283.0, AbsoluteStatTypeEnum.RESISTANCE, 1743.0), 145),
    LARGE_MACHINE_AXE("Large Machine Axe", ItemTypeEnum.TWO_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 6582.0,  AbsoluteStatTypeEnum.CRIT_VALUE, 7012.0), 145),
    LARGE_MACHINE_HAMMER("Large Machine Hammer", ItemTypeEnum.TWO_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 13163.0,  AbsoluteStatTypeEnum.CRIT_VALUE, 3506.0), 145),
    LARGE_MACHINE_BLADE("Large Machine Blade", ItemTypeEnum.TWO_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 6582.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.329, AbsoluteStatTypeEnum.CRIT_VALUE, 3506.0), 145),

    //Kranparus' Treasures
    KRANPARUS_ICY_BATTLE_MACE("Kranparus' Icy Battle Mace", ItemTypeEnum.ONE_HAND_WEAPON, Map.of(AbsoluteStatTypeEnum.DAMAGE, 3292.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.220), 145),
    KRANPARUS_ICY_SHIELD("Kranparus' Icy Shield", ItemTypeEnum.OFF_HAND, Map.of(AbsoluteStatTypeEnum.DAMAGE, 3292.0, AbsoluteStatTypeEnum.ATTACK_SPEED, 0.109, AbsoluteStatTypeEnum.CRIT_VALUE, 2104.0), 145),
    KRANPARUS_ICY_AMULET("Kranparus' Icy Amulet", ItemTypeEnum.AMULET, Map.of(AbsoluteStatTypeEnum.DAMAGE, 1644.883, AbsoluteStatTypeEnum.HEALTH_POINTS, 74283.0, AbsoluteStatTypeEnum.ICE_RESISTANCE, 4150.0), 145),
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

        HELMET_OF_THE_END.set = DragonknightSets.END_OF_THE_EMPIRE;
        SHOULDERS_OF_THE_END.set = DragonknightSets.END_OF_THE_EMPIRE;
        CLOAK_OF_THE_END.set = DragonknightSets.END_OF_THE_EMPIRE;

        ARMOR_OF_THE_FLAME_CONQUEROR.set = DragonknightSets.ENRAGED_EMPORER;
        GLOVES_OF_THE_FLAME_CONQUEROR.set = DragonknightSets.ENRAGED_EMPORER;
        BOOTS_OF_THE_FLAME_CONQUEROR.set = DragonknightSets.ENRAGED_EMPORER;

        MIGHTY_WRATHFUL_SEEKERS_HELMET.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_SHOULDERS.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_TORSO.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_GLOVES.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_BOOTS.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;
        MIGHTY_WRATHFUL_SEEKERS_CAPE.set = DragonknightSets.MIGHTY_VISIONARY_SEEKER;

        HELMET_OF_DEATH.set = DragonknightSets.AT_DEATHS_DOOR;
        SEAL_OF_DEATH.set = DragonknightSets.AT_DEATHS_DOOR;

        SARGONS_HORNS.set = DragonknightSets.SARGONS_IMMORTAL_TERROR_ARMOR;
        SARGONS_PAULDRONS.set = DragonknightSets.SARGONS_IMMORTAL_TERROR_ARMOR;
        SARGONS_TORSO.set = DragonknightSets.SARGONS_IMMORTAL_TERROR_ARMOR;

        MACHINE_HELMET.set = DragonknightSets.MACHINE_POWER;
        MACHINE_SHOULDERS.set = DragonknightSets.MACHINE_POWER;
        MACHINE_ARMOR.set = DragonknightSets.MACHINE_POWER;
        MACHINE_FISTS.set = DragonknightSets.MACHINE_POWER;
        MACHINE_BOOTS.set = DragonknightSets.MACHINE_POWER;
        MACHINE_BELT.set = DragonknightSets.MACHINE_POWER;
        LARGE_MACHINE_AXE.set = DragonknightSets.MACHINE_POWER;
        LARGE_MACHINE_BLADE.set = DragonknightSets.MACHINE_POWER;
        LARGE_MACHINE_HAMMER.set = DragonknightSets.MACHINE_POWER;

        KRANPARUS_ICY_BATTLE_MACE.set = DragonknightSets.KRANPARUS_TREASURES;
        KRANPARUS_ICY_SHIELD.set = DragonknightSets.KRANPARUS_TREASURES;
        KRANPARUS_ICY_AMULET.set = DragonknightSets.KRANPARUS_TREASURES;
    }
}
