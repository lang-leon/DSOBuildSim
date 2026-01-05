package com.langleon.dsobuildsim.items.itemdatabase.setitems;

import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.ItemSlotType;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.items.setitems.SetItem;
import com.langleon.dsobuildsim.items.itemdatabase.Item;
import com.langleon.dsobuildsim.sets.DragonknightSets;

import java.util.Map;

public enum DragonknightSetItems implements Item {

    //dragan set
    HELMET_OF_THE_BLACK_KNIGHT("Helmet of the Black Knight", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1401.911, StatType.HEALTH_POINTS, 61913.936), 145),
    SHOULDERS_OF_THE_BLACK_KNIGHT("Shoulders of the Black Knight", ItemSlotType.SHOULDERS, Map.of(StatType.DAMAGE, 1891.513, StatType.HEALTH_POINTS, 99043.192), 145),
    CLOAK_OF_THE_BLACK_KNIGHT("Cloak of the Black Knight", ItemSlotType.CLOAK, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.06, StatType.HEALTH_POINTS, 49521.596), 145),

    HELMET_OF_THE_END("Helmet of the End", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1401.911, StatType.HEALTH_POINTS, 61913.936), 145),
    SHOULDERS_OF_THE_END("Shoulders of the End", ItemSlotType.SHOULDERS, Map.of(StatType.DAMAGE, 1891.513, StatType.HEALTH_POINTS, 99043.192), 145),
    CLOAK_OF_THE_END("Cloak of the End", ItemSlotType.CLOAK, Map.of(StatType.DAMAGE, 1891.513, StatType.ATTACK_SPEED, 0.06, StatType.HEALTH_POINTS, 49521.596), 145),

    //maze of blaze set
    ARMOR_OF_THE_FLAME_CONQUEROR("Armor of the Flame Conqueror", ItemSlotType.TORSO, Map.of(StatType.ARMOR_VALUE, 1603.0, StatType.ANDERMAGIC_RESISTANCE, 6062.0, StatType.BLOCK_VALUE, 1549.0), 140),
    GLOVES_OF_THE_FLAME_CONQUEROR("Gloves of the Flame Conqueror", ItemSlotType.GLOVES, Map.of(StatType.DAMAGE, 1601.0, StatType.ATTACK_SPEED, 0.054, StatType.CRIT_VALUE, 1709.0), 140),
    BOOTS_OF_THE_FLAME_CONQUEROR("Boots of the Flame Conqueror", ItemSlotType.BOOTS, Map.of(StatType.DAMAGE, 1601.0, StatType.MOVEMENT_SPEED, 1.208, StatType.CRIT_VALUE, 1366.0), 140),

    //mighty wrathful seeker set
    MIGHTY_WRATHFUL_SEEKERS_HELMET("Mighty Wrathful Seeker's Helmet", ItemSlotType.HELMET, Map.of(StatType.HEALTH_POINTS, 60555.0, StatType.ARMOR_VALUE, 1068.0, StatType.FIRE_RESISTANCE, 4150.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_SHOULDERS("Mighty Wrathful Seeker's Shoulders", ItemSlotType.SHOULDERS, Map.of(StatType.HEALTH_POINTS, 48435.0, StatType.ICE_RESISTANCE, 4041.0, StatType.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_TORSO("Mighty Wrathful Seeker's Torso", ItemSlotType.TORSO, Map.of(StatType.ARMOR_VALUE, 1603.0, StatType.ANDERMAGIC_RESISTANCE, 6062.0, StatType.BLOCK_VALUE, 1549.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_GLOVES("Mighty Wrathful Seeker's Gloves", ItemSlotType.GLOVES, Map.of(StatType.DAMAGE, 1601.0, StatType.ATTACK_SPEED, 0.054, StatType.CRIT_VALUE, 1709.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_BOOTS("Mighty Wrathful Seeker's Boots", ItemSlotType.BOOTS, Map.of(StatType.DAMAGE, 1601.0, StatType.MOVEMENT_SPEED, 1.208, StatType.CRIT_VALUE, 1366.0), 140),
    MIGHTY_WRATHFUL_SEEKERS_CAPE("Mighty Wrathful Seeker's Cape", ItemSlotType.CLOAK, Map.of(StatType.DAMAGE, 1841.0, StatType.ATTACK_SPEED, 0.059, StatType.HEALTH_POINTS, 48435.0), 140),

    //mortis set
    HELMET_OF_DEATH("Helmet of Death", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1645.0, StatType.CRIT_VALUE, 1754.0, StatType.RESISTANCE_VALUE, 1162.0), 145),
    SEAL_OF_DEATH("Seal of Death", ItemSlotType.AMULET, Map.of(StatType.DAMAGE, 1645.0, StatType.CRIT_VALUE, 1402.0, StatType.RESISTANCE_VALUE, 1162.0), 145),

    //sargon set
    SARGONS_HORNS("Sargon's Horns", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1644.883, StatType.CRIT_VALUE, 1401.991, StatType.HEALTH_POINTS, 61914.0), 145),
    SARGONS_PAULDRONS("Sargon's Pauldrons", ItemSlotType.SHOULDERS, Map.of(StatType.DAMAGE, 1891.513, StatType.CRIT_VALUE, 1401.991, StatType.ANDERMAGIC_RESISTANCE, 4150.0), 145),
    SARGONS_TORSO("Sargon's Torso", ItemSlotType.TORSO, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 49522.0, StatType.ARMOR_VALUE, 1648.0), 145),

    //destructor set
    MACHINE_HELMET("Machine Helmet", ItemSlotType.HELMET, Map.of(StatType.DAMAGE, 1645.0, StatType.CRIT_VALUE, 1402.0, StatType.HEALTH_POINTS, 61914.0), 145),
    MACHINE_SHOULDERS("Machine Shoulders", ItemSlotType.SHOULDERS, Map.of(StatType.HEALTH_POINTS, 49522.0, StatType.ARMOR_VALUE, 1098.0, StatType.RESISTANCE_VALUE, 1162.0), 145),
    MACHINE_ARMOR("Machine Armor", ItemSlotType.TORSO, Map.of(StatType.DAMAGE, 1645.0, StatType.HEALTH_POINTS, 49522.0, StatType.ARMOR_VALUE, 1648.0), 145),
    MACHINE_FISTS("Machine Fists", ItemSlotType.GLOVES, Map.of(StatType.DAMAGE, 1645.0, StatType.ATTACK_SPEED, 0.055, StatType.CRIT_VALUE, 1754.0), 145),
    MACHINE_BOOTS("Machine Boots", ItemSlotType.BOOTS, Map.of(StatType.DAMAGE, 1645.0, StatType.MOVEMENT_SPEED, 1.221, StatType.HEALTH_POINTS, 49522.0), 145),
    MACHINE_BELT("Machine Belt", ItemSlotType.BELT, Map.of(StatType.DAMAGE, 1645.0, StatType.HEALTH_POINTS, 74283.0, StatType.RESISTANCE_VALUE, 1743.0), 145),
    LARGE_MACHINE_AXE("Large Machine Axe", ItemSlotType.TWO_HAND_WEAPON, Map.of(StatType.DAMAGE, 6582.0,  StatType.CRIT_VALUE, 7012.0), 145),
    LARGE_MACHINE_HAMMER("Large Machine Hammer", ItemSlotType.TWO_HAND_WEAPON, Map.of(StatType.DAMAGE, 13163.0,  StatType.CRIT_VALUE, 3506.0), 145),
    LARGE_MACHINE_BLADE("Large Machine Blade", ItemSlotType.TWO_HAND_WEAPON, Map.of(StatType.DAMAGE, 6582.0, StatType.ATTACK_SPEED, 0.329, StatType.CRIT_VALUE, 3506.0), 145),

    //Kranparus' Treasures
    KRANPARUS_ICY_BATTLE_MACE("Kranparus' Icy Battle Mace", ItemSlotType.ONE_HAND_WEAPON, Map.of(StatType.DAMAGE, 3292.0, StatType.ATTACK_SPEED, 0.220), 145),
    KRANPARUS_ICY_SHIELD("Kranparus' Icy Shield", ItemSlotType.OFF_HAND, Map.of(StatType.DAMAGE, 3292.0, StatType.ATTACK_SPEED, 0.109, StatType.CRIT_VALUE, 2104.0), 145),
    KRANPARUS_ICY_AMULET("Kranparus' Icy Amulet", ItemSlotType.AMULET, Map.of(StatType.DAMAGE, 1644.883, StatType.HEALTH_POINTS, 74283.0, StatType.ICE_RESISTANCE, 4150.0), 145),
    ;

    private final String name;
    private final ItemSlotType itemSlotType;
    private final Map<StatType, Double> baseStats;
    private final CharacterClass characterClass;
    private final int itemLevel;
    private DragonknightSets set;

    DragonknightSetItems(String name, ItemSlotType itemSlotType, Map<StatType, Double> baseStats, int itemLevel) {
        this.characterClass = CharacterClass.DRAGONKNIGHT;
        this.name = name;
        this.itemSlotType = itemSlotType;
        this.baseStats = baseStats;
        this.itemLevel = itemLevel;
    }

    public SetItem getItem() {
        return new SetItem(this.name, CharacterClass.DRAGONKNIGHT, this.itemSlotType, this.baseStats, this.itemLevel, this.set);
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
