package com.langleon.dsobuildsim.items.itemdatabase.setitems;

import com.langleon.dsobuildsim.enums.AbsoluteStatType;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemType;
import com.langleon.dsobuildsim.items.actualitems.SetItem;
import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.sets.DragonknightSets;

import java.util.Map;

public enum DragonknightSetItems implements Item {

    //dragan set
    HELMET_OF_THE_BLACK_KNIGHT("Helmet of the Black Knight", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.CRIT_VALUE, 1401.911, AbsoluteStatType.HEALTH_POINTS, 61913.936), 145),
    SHOULDERS_OF_THE_BLACK_KNIGHT("Shoulders of the Black Knight", ItemType.SHOULDERS, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.HEALTH_POINTS, 99043.192), 145),
    CLOAK_OF_THE_BLACK_KNIGHT("Cloak of the Black Knight", ItemType.CLOAK, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.ATTACK_SPEED, 0.06, AbsoluteStatType.HEALTH_POINTS, 49521.596), 145),

    HELMET_OF_THE_END("Helmet of the End", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.CRIT_VALUE, 1401.911, AbsoluteStatType.HEALTH_POINTS, 61913.936), 145),
    SHOULDERS_OF_THE_END("Shoulders of the End", ItemType.SHOULDERS, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.HEALTH_POINTS, 99043.192), 145),
    CLOAK_OF_THE_END("Cloak of the End", ItemType.CLOAK, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.ATTACK_SPEED, 0.06, AbsoluteStatType.HEALTH_POINTS, 49521.596), 145),

    //maze of blaze set
    ARMOR_OF_THE_FLAME_CONQUEROR("Armor of the Flame Conqueror", ItemType.TORSO, Map.of(AbsoluteStatType.ARMOR, 1603.0, AbsoluteStatType.ANDERMAGIC_RESISTANCE, 6062.0, AbsoluteStatType.BLOCK_VALUE, 1549.0), 140),
    GLOVES_OF_THE_FLAME_CONQUEROR("Gloves of the Flame Conqueror", ItemType.GLOVES, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.ATTACK_SPEED, 0.054, AbsoluteStatType.CRIT_VALUE, 1709.0), 140),
    BOOTS_OF_THE_FLAME_CONQUEROR("Boots of the Flame Conqueror", ItemType.BOOTS, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.MOVEMENT_SPEED, 1.208, AbsoluteStatType.CRIT_VALUE, 1366.0), 140),

    //mighty wrathful seeker set
    MIGHTY_WRATHFUL_SEEKERS_HELMET("Mighty Wrathful Seeker's Helmet", ItemType.HELMET, Map.of(AbsoluteStatType.HEALTH_POINTS, 60555.0, AbsoluteStatType.ARMOR, 1068.0, AbsoluteStatType.FIRE_RESISTANCE, 4150.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_SHOULDERS("Mighty Wrathful Seeker's Shoulders", ItemType.SHOULDERS, Map.of(AbsoluteStatType.HEALTH_POINTS, 48435.0, AbsoluteStatType.ICE_RESISTANCE, 4041.0, AbsoluteStatType.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_TORSO("Mighty Wrathful Seeker's Torso", ItemType.TORSO, Map.of(AbsoluteStatType.ARMOR, 1603.0, AbsoluteStatType.ANDERMAGIC_RESISTANCE, 6062.0, AbsoluteStatType.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_GLOVES("Mighty Wrathful Seeker's Gloves", ItemType.GLOVES, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.ATTACK_SPEED, 0.054, AbsoluteStatType.CRIT_VALUE, 1709.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_BOOTS("Mighty Wrathful Seeker's Boots", ItemType.BOOTS, Map.of(AbsoluteStatType.DAMAGE, 1601.0, AbsoluteStatType.MOVEMENT_SPEED, 1.208, AbsoluteStatType.CRIT_VALUE, 1366.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_CAPE("Mighty Wrathful Seeker's Cape", ItemType.CLOAK, Map.of(AbsoluteStatType.DAMAGE, 1841.0, AbsoluteStatType.ATTACK_SPEED, 0.059, AbsoluteStatType.HEALTH_POINTS, 48435.0), 140),

    //mortis set
    HELMET_OF_DEATH("Helmet of Death", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.CRIT_VALUE, 1754.0, AbsoluteStatType.RESISTANCE, 1162.0), 145),
    SEAL_OF_DEATH("Seal of Death", ItemType.AMULET, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.CRIT_VALUE, 1402.0, AbsoluteStatType.RESISTANCE, 1162.0), 145),

    //sargon set
    SARGONS_HORNS("Sargon's Horns", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.CRIT_VALUE, 1401.991, AbsoluteStatType.HEALTH_POINTS, 61914.0), 145),
    SARGONS_PAULDRONS("Sargon's Pauldrons", ItemType.SHOULDERS, Map.of(AbsoluteStatType.DAMAGE, 1891.513, AbsoluteStatType.CRIT_VALUE, 1401.991, AbsoluteStatType.ANDERMAGIC_RESISTANCE, 4150.0), 145),
    SARGONS_TORSO("Sargon's Torso", ItemType.TORSO, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.HEALTH_POINTS, 49522.0, AbsoluteStatType.ARMOR, 1648.0), 145),

    //destructor set
    MACHINE_HELMET("Machine Helmet", ItemType.HELMET, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.CRIT_VALUE, 1402.0, AbsoluteStatType.HEALTH_POINTS, 61914.0), 145),
    MACHINE_SHOULDERS("Machine Shoulders", ItemType.SHOULDERS, Map.of(AbsoluteStatType.HEALTH_POINTS, 49522.0, AbsoluteStatType.ARMOR, 1098.0, AbsoluteStatType.RESISTANCE, 1162.0), 145),
    MACHINE_ARMOR("Machine Armor", ItemType.TORSO, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.HEALTH_POINTS, 49522.0, AbsoluteStatType.ARMOR, 1648.0), 145),
    MACHINE_FISTS("Machine Fists", ItemType.GLOVES, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.ATTACK_SPEED, 0.055, AbsoluteStatType.CRIT_VALUE, 1754.0), 145),
    MACHINE_BOOTS("Machine Boots", ItemType.BOOTS, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.MOVEMENT_SPEED, 1.221, AbsoluteStatType.HEALTH_POINTS, 49522.0), 145),
    MACHINE_BELT("Machine Belt", ItemType.BELT, Map.of(AbsoluteStatType.DAMAGE, 1645.0, AbsoluteStatType.HEALTH_POINTS, 74283.0, AbsoluteStatType.RESISTANCE, 1743.0), 145),
    LARGE_MACHINE_AXE("Large Machine Axe", ItemType.TWO_HAND_WEAPON, Map.of(AbsoluteStatType.DAMAGE, 6582.0,  AbsoluteStatType.CRIT_VALUE, 7012.0), 145),
    LARGE_MACHINE_HAMMER("Large Machine Hammer", ItemType.TWO_HAND_WEAPON, Map.of(AbsoluteStatType.DAMAGE, 13163.0,  AbsoluteStatType.CRIT_VALUE, 3506.0), 145),
    LARGE_MACHINE_BLADE("Large Machine Blade", ItemType.TWO_HAND_WEAPON, Map.of(AbsoluteStatType.DAMAGE, 6582.0, AbsoluteStatType.ATTACK_SPEED, 0.329, AbsoluteStatType.CRIT_VALUE, 3506.0), 145),

    //Kranparus' Treasures
    KRANPARUS_ICY_BATTLE_MACE("Kranparus' Icy Battle Mace", ItemType.ONE_HAND_WEAPON, Map.of(AbsoluteStatType.DAMAGE, 3292.0, AbsoluteStatType.ATTACK_SPEED, 0.220), 145),
    KRANPARUS_ICY_SHIELD("Kranparus' Icy Shield", ItemType.OFF_HAND, Map.of(AbsoluteStatType.DAMAGE, 3292.0, AbsoluteStatType.ATTACK_SPEED, 0.109, AbsoluteStatType.CRIT_VALUE, 2104.0), 145),
    KRANPARUS_ICY_AMULET("Kranparus' Icy Amulet", ItemType.AMULET, Map.of(AbsoluteStatType.DAMAGE, 1644.883, AbsoluteStatType.HEALTH_POINTS, 74283.0, AbsoluteStatType.ICE_RESISTANCE, 4150.0), 145),
    ;

    private final String name;
    private final ItemType itemType;
    private final Map<AbsoluteStatType, Double> baseStats;
    private final CharacterClass characterClass;
    private final int itemLevel;
    private DragonknightSets set;

    DragonknightSetItems(String name, ItemType itemType, Map<AbsoluteStatType, Double> baseStats, int itemLevel) {
        this.characterClass = CharacterClass.DRAGONKNIGHT;
        this.name = name;
        this.itemType = itemType;
        this.baseStats = baseStats;
        this.itemLevel = itemLevel;
    }

    public SetItem getItem() {
        return new SetItem(this.name, CharacterClass.DRAGONKNIGHT, this.itemType, this.baseStats, this.itemLevel, this.set);
    }

    public CharacterClass getCharacterClass() {
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
